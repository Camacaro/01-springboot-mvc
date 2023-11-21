package com.jesus.cources.sprintboot.webapp.sprintbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
/**
 * El classpath es desde /resources/
 * se transforma a /resources/texts.properties
 */
@PropertySources({
    @PropertySource("classpath:texts.properties")
})
public class TextPropertiesConfig {
}
