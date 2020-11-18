package scene;
import main.ScreenSize;
import pane.WelcomePane;
import javafx.scene.Scene;

public class WelcomeScene extends Scene {
    public WelcomeScene() {
        super(new WelcomePane(), ScreenSize.ScreenX, ScreenSize.ScreenY);
        this.getStylesheets().add(getClass().getClassLoader().getResource("stylesheet/color.css").toExternalForm());
    }
}