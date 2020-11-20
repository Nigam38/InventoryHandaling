package scene;

import javafx.scene.Scene;
import main.ScreenSize;
import pane.PaneCRUD;

public class SceneCRUD extends Scene {
    public SceneCRUD() {
        super(new PaneCRUD(), ScreenSize.ScreenX, ScreenSize.ScreenY);
    }
}
