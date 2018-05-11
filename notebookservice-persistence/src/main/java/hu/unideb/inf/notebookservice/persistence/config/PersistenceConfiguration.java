package hu.unideb.inf.notebookservice.persistence.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Configuration class which scans the packages for entities and repositories.
 * The {@link org.springframework.context.annotation.Configuration} indicates
 * that a class declaresone or more bean methods and may be processed by the
 * Spring container to generate bean definitions and service requests for those
 * beans at runtime.
 * The {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}
 * of the Spring Application Context, attempting to guess and configure beans
 * that you are likely to need. With the help of
 * {@link org.springframework.data.jpa.repository.config.EnableJpaRepositories}
 * annotation we enable JPA repositories. Configures the base packages used by
 * auto-configuration when scanning for entity classes with
 * {@link org.springframework.boot.autoconfigure.domain.EntityScan}.
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("hu.unideb.inf.notebookservice.persistence.repository")
@EntityScan("hu.unideb.inf.notebookservice.persistence.entity")
public class PersistenceConfiguration {
}
