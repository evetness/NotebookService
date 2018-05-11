package hu.unideb.inf.notebookservice.ui.main;

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
