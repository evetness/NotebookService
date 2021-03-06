package hu.unideb.inf.notebookservice.service.config;

/*-
 * #%L
 * NotebookService Implementation
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2018 University of Debrecen IT Faculty
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
