package hu.unideb.inf.notebookservice.ui.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The {@link org.springframework.context.annotation.Configuration} indicates that a class declares
 * one or more bean methods and may be processed by the Spring container to generate bean definitions and
 * service requests for those beans at runtime
 * The {@link org.springframework.context.annotation.ComponentScan} configures component
 * scanning directives for use with @{@link Configuration} classes.
 */
@Configuration
@ComponentScan("hu.unideb.inf.notebookservice.ui")
public class UiConfiguration {
}
