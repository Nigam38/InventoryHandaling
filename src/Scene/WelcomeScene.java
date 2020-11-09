package Scene;
import Main.ScreenSize;
import Pane.WelcomePane;
import javafx.scene.Scene;

public class WelcomeScene extends Scene {
    public WelcomeScene() {
        super(new WelcomePane(), ScreenSize.ScreenX, ScreenSize.ScreenY);
        this.getStylesheets().add(getClass().getClassLoader().getResource("StyleSheet/color.css").toExternalForm());
    }
}
