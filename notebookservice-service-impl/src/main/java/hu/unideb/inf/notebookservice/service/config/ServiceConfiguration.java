package hu.unideb.inf.notebookservice.service.config;

import hu.unideb.inf.notebookservice.persistence.config.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * The {@link org.springframework.context.annotation.Configuration} indicates
 * that a class declares one or more bean methods and may be processed by
 * the Spring container to generate bean definitions and service requests
 * for those beans at runtime
 * The {@link org.springframework.context.annotation.Import}
 * indicates one or more
 * {@link Configuration @Configuration} classes to import.
 * The {@link org.springframework.context.annotation.ComponentScan}
 * configured component scanning directives for use with
 * {@link Configuration} classes.
 */
@Configuration
@Import(PersistenceConfiguration.class)
@ComponentScan("hu.unideb.inf.notebookservice.service")
public class ServiceConfiguration {
}
