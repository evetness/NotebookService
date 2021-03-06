package hu.unideb.inf.notebookservice.ui.view;

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

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;
import hu.unideb.inf.notebookservice.ui.controller.BrandController;
import hu.unideb.inf.notebookservice.ui.controller.NewProductController;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLView(title = "New Brand", value = "/fxml/brand.fxml")
public class BrandView extends AbstractFxmlView {
}
