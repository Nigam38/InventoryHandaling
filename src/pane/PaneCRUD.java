package pane;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import main.StartMain;
import scene.WelcomeScene;
import tabs.AddItemTab;
import tabs.RemoveItemTab;
import tabs.UpdateItemTab;

public class PaneCRUD extends BorderPane {
    public PaneCRUD() {
        MenuBar menu = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");

        MenuItem logout = new MenuItem("Logout");
        logout.setOnAction(e-> {
            StartMain.mainStage.setScene(new WelcomeScene());
        });

        fileMenu.getItems().add(logout);

        menu.getMenus().addAll(fileMenu,editMenu,viewMenu);

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        AddItemTab addItemTab = AddItemTab.getInstance();
     //   RemoveItemTab removeItemTab = RemoveItemTab.getInstance();
      //  UpdateItemTab updateItemTab = UpdateItemTab.getInstance();

        tabPane.getTabs().addAll(addItemTab);

        this.setTop(menu);
        this.setCenter(tabPane);
    }
}
