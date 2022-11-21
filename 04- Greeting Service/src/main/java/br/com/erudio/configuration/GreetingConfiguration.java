package br.com.erudio.configuration;

import org.springframework.boot.context.properties.*;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
@PropertySource(value = "classpath:application.yml", encoding = "UTF-8")
public class GreetingConfiguration {

    private String greeting;
    private String defaultValue;

    public GreetingConfiguration() {}

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
