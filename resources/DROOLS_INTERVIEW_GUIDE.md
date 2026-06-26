# Drools Rule Engine Interview Guide

## 1) What is Drools?
Drools is a Java rule engine (business rule management system) that evaluates facts against rules written in DRL (Drools Rule Language).

In simple terms:
- Your Java objects are facts.
- Your DRL file contains IF-THEN rules.
- Drools matches facts to rule conditions and executes the matching rule actions.

Why teams use it:
- Move changing business logic out of hardcoded if-else blocks.
- Keep rules readable for business and technical teams.
- Update decision logic faster with less Java code churn.

---

## 2) Core concepts you should know for interviews

- Rule: A single IF-THEN unit.
  - when section: condition
  - then section: action

- Fact: Any Java object inserted into the session and evaluated by rules.
  - In this project, OrderPricingRequest is the main fact.

- KieServices: Drools bootstrap/factory entry point.

- KieContainer: Holds compiled rule modules and creates sessions.

- KieBase: Collection of rules.

- KieSession:
  - StatelessKieSession: one-shot execution, no long-lived state.
  - StatefulKieSession: keeps working memory across calls until disposed.

- kmodule.xml: Declares kbases and ksessions (names, type, defaults).

- Agenda and salience:
  - Agenda decides which eligible rules fire.
  - salience gives rule priority (higher number fires first among eligible rules).

---

## 3) Drools lifecycle (end-to-end)

Typical lifecycle:
1. Author rules in DRL files.
2. Build/compile rules (Maven with kie-maven-plugin helps validate/compile).
3. Start app and create KieContainer.
4. Create a KieSession (stateless or stateful).
5. Insert facts and execute rules.
6. Rules fire, update facts, and produce outcomes.
7. For stateful sessions, dispose after use.

For stateless sessions:
- No long-lived memory between executions.
- You usually create and execute per request.

For stateful sessions:
- Facts remain in memory until deleted/disposed.
- Must call dispose() to avoid memory/resource issues.

---

## 4) How Drools works in this project (step by step)

### Project files involved
- src/main/resources/rules/pricing/order-pricing.drl
- src/main/resources/META-INF/kmodule.xml
- src/main/java/com/kodegravity/inclass_exr/config/DroolsConfiguration.java
- src/main/java/com/kodegravity/inclass_exr/rules/OrderPricingService.java
- src/main/java/com/kodegravity/inclass_exr/rules/OrderPricingController.java
- src/main/java/com/kodegravity/inclass_exr/rules/model/OrderPricingRequest.java

### Runtime flow
1. App starts (Spring Boot).
2. DroolsConfiguration creates Spring beans:
   - KieServices
   - KieContainer from classpath (loads kmodule.xml and DRL resources).
3. Client calls POST /evaluate with OrderPricingRequest JSON.
4. Controller forwards request to OrderPricingService.
5. Service resets computed fields:
   - discountPercentage = 0
   - shippingFee = 0.0
   - appliedRules list is cleared
6. Service creates stateless session by name orderPricingSession.
7. Service executes session with request object as fact.
8. Matching rules in order-pricing.drl fire and mutate request:
   - set discount/shipping
   - append fired rule names into appliedRules
9. Updated request object is returned as API response.

---

## 5) Your specific interview questions

## Q1) Why are we creating KieServices and KieContainer for each session instead of creating a bean?
Short answer: In this project, you are not creating them for each session. They are Spring singleton beans.

What actually happens:
- KieServices bean is created once at application startup.
- KieContainer bean is created once at application startup.
- For each evaluate call, only a new StatelessKieSession is created from the container.

Why this is good:
- KieContainer is heavier and should be reused.
- StatelessKieSession is lightweight and request-scoped by usage pattern.

Optional simplification:
- You can remove KieServices bean and directly expose KieContainer bean if preferred, but current code is valid.

---

## Q2) What does private static final String ORDER_PRICING_SESSION = "orderPricingSession" do?
It is a constant session name used to look up the configured ksession in kmodule.xml.

Meaning:
- private: used only in OrderPricingService.
- static: belongs to class, not instance.
- final: cannot change.

Why useful:
- Avoids hardcoded string repetition.
- Prevents typos.
- Easy rename in one place.

If this name does not match kmodule.xml ksession name, session creation fails at runtime.

---

## Q3) Explain each property in <ksession name="orderPricingSession" type="stateless" default="true"/>

- name="orderPricingSession"
  - Identifier used by Java code to request this session from KieContainer.

- type="stateless"
  - Session does not keep working memory across invocations.
  - Best for independent request-response evaluations like pricing.

- default="true"
  - Marks this as default session in the kbase.
  - If code requests unnamed default session, Drools can pick this one.
  - In this project, code requests by name, so default helps readability but is not mandatory.

---

## Q4) Explain request.getAppliedRules().clear();
Also: why list exists, why cleared, who inserts names, and whether required.

What it does:
- Removes all previous entries from appliedRules before re-evaluation.

Why list exists:
- appliedRules is an audit/explainability field.
- It tells which rules fired for this request.
- Great for debugging, API transparency, and interview demos.

Who inserts rule names:
- The DRL rule actions insert names.
- Example pattern in DRL then block:
  - request.getAppliedRules().add("gold-tier-discount")

Why clear it:
- Defensive reset to avoid stale data if same object instance is reused.
- Keeps evaluate method idempotent for repeated invocations on same object reference.

Is it required?
- Required for current DRL code because rules call add on that list.
- Not required by Drools engine itself.
- If you do not need rule audit output, you can remove the list and remove add calls in DRL.

---

## 6) Interview-ready 30-second summary
In this project, Spring creates a singleton KieContainer at startup from classpath rules. For each pricing request, the service creates a stateless session named orderPricingSession, executes rules against an OrderPricingRequest fact, and returns the mutated object. The DRL rules set discount and shipping values and append fired rule names to an appliedRules list for explainability. The list is cleared before execution to avoid stale results if the same request object is reused.

---

## 7) Common interview follow-ups and strong answers

- Why stateless session here?
  - Each API call is independent; no need to retain facts between calls.

- When would you choose stateful?
  - Long-running workflows, event streams, or incremental fact updates.

- How do you test rule behavior?
  - Unit/integration tests that submit input facts and assert output fields and fired-rule markers.

- What can go wrong?
  - Session name mismatch with kmodule.
  - Missing package alignment between kbase packages and DRL package.
  - Mutating shared state incorrectly in stateful sessions.

---

## 8) Improvement ideas for this repository
- Add focused tests for OrderPricingService rule outcomes.
- Use constructor injection consistently in all controllers/services.
- Optionally return a separate response DTO instead of mutating request object directly.
- Keep rule naming conventions stable for clearer audit trails.
