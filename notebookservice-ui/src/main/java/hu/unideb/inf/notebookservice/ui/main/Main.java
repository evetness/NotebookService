package hu.unideb.inf.notebookservice.ui.main;

/*-
 * #%L
 * NotebookService user interface
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

import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import hu.unideb.inf.notebookservice.service.config.ServiceConfiguration;
import hu.unideb.inf.notebookservice.ui.config.UiConfiguration;
import hu.unideb.inf.notebookservice.ui.view.LoginView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ServiceConfiguration.class, UiConfiguration.class})
public class Main extends AbstractJavaFxApplicationSupport{

    public static void main(String[] args) {

        launch(Main.class, LoginView.class, args);
    }

}
