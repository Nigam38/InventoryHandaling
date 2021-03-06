package pane;

import database.DBTables;
import database.DatabaseConnection;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import main.StartMain;
import scene.SceneCRUD;

import java.sql.ResultSet;
import java.sql.Statement;

public class WelcomePane extends BorderPane {
    public WelcomePane() {

        // HBox

        VBox vb = new VBox();

        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(25);
        gridPane.setVgap(10);
        gridPane.setMaxSize(350,150);


        // Label and TextBox
/*
        try {

            Label lblUserName = new Label("Username:");
            TextField txtUserName = new TextField();
            Label lblPassword = new Label("Password:");
            PasswordField pf = new PasswordField();
            Button btnLogin = new Button("Login");
            Label lblMessage = new Label();

        // Set fonts in Label and Button
        Font font = Font.font("Acme", FontWeight.EXTRA_BOLD, 25);
        lblUserName.setFont(font);
        lblPassword.setFont(font);
        btnLogin.setFont(font);


        // GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 1, 3);
        gridPane.add(lblMessage, 1, 2);

        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        // Title and DropShadow effect to it
        Text title = new Text("Login");
        title.setFont(Font.font("Acme", FontWeight.EXTRA_BOLD, 50));
        title.setEffect(dropShadow);

        //Adding Title to HBox


        // Adding title and gridPane to VBox
        vb.getChildren().addAll(title,gridPane);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(100);
        vb.setMaxSize(500,600);


        // ID's for StyleSheet CSS
        this.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        title.setId("text");
        vb.setId("vb");

        //Action for btnLogin
        btnLogin.setOnMouseClicked(e -> {

            String username = txtUserName.getText();
            String password = pf.getText();
            DatabaseConnection db = DatabaseConnection.getInstance();

            try {
                Statement getCategories =
                        db.getConnection().createStatement();
                String query = "SELECT * FROM " + DBTables.TABLE_LOGIN;
                query+=" WHERE user='"+username+"' and password='"+password+"'";

                ResultSet data = getCategories.executeQuery(query);
                Alert alert;
                if(data.next()){
                    StartMain.mainStage.setScene(new SceneCRUD());
                }else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Ooops, Error!");
                    alert.setContentText("Incorrect User or Password.");
                    alert.show();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            txtUserName.setText("");
            pf.setText("");
        });
        } catch (Exception ex){
            System.out.println(ex);
        }
*/

        //Add HBox and GridPane to BorderPane
        this.setCenter(vb);

    }
}
