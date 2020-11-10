package Main;

import Scene.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartMain extends Application {

    public static Stage mainStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        mainStage.setScene(new WelcomeScene());
        mainStage.setTitle(ScreenSize.title);
        mainStage.setResizable(false);
        mainStage.show();

    }
}