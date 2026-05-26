- 'PROTECTED' is a access modifier used with members of the calls rather than the class itself
- Allows access to members within the same package and subpackage
- EXCEPTION: inheritance








| Element type       | Can be protected? | Notes                                   |
|--------------------|-------------------|------------------------------------------|
| Top‑level class    | ❌ No             | Only public or default allowed           |
| Nested class       | ✔ Yes            | Treated like a member                    |
| Methods            | ✔ Yes            | Common use case                          |
| Fields             | ✔ Yes            | Allowed but discouraged for encapsulation|
| Constructors       | ✔ Yes            | Useful for controlled inheritance        |


| Modifier    | Same Class | Same Package | Subclass | Everywhere |
| ----------- | ---------- | ------------ | -------- | ---------- |
| `private`   | ✅          | ❌            | ❌        | ❌          |
| `default`     | ✅          | ✅            | ❌        | ❌          |
| `protected` | ✅          | ✅            | ✅        | ❌          |
| `public`    | ✅          | ✅            | ✅        | ✅          |
