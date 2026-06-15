package com.kodegravity.inclass_exr.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfiguration {

    @Bean
    public KieServices kieServices() {
        return KieServices.Factory.get();
    }

    @Bean
    public KieContainer kieContainer(KieServices kieServices) {
        return kieServices.getKieClasspathContainer();
    }
}
