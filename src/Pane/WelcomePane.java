package Pane;


import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class WelcomePane extends BorderPane {

    public WelcomePane() {
        String user = "nigam";
        String pw = "password";
        final String[] checkUser = new String[1];
        final String[] checkPw = new String[1];


        // HBox
        HBox hb = new HBox();

        // GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setMaxSize(350,150);


        // Label and TextBox
        Label lblUserName = new Label("Username");
        TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
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
        Text title = new Text("Login Page");
        title.setFont(Font.font("Acme", FontWeight.EXTRA_BOLD, 50));
        title.setEffect(dropShadow);

        //Adding Title to HBox
        hb.getChildren().add(title);
        hb.setPadding(new Insets(30,0,0,165));

        // ID's for StyleSheet CSS
        this.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        title.setId("text");

        //Action for btnLogin
        btnLogin.setOnMouseClicked(e -> {
                checkUser[0] = txtUserName.getText().toString();
                checkPw[0] = pf.getText().toString();
                if(checkUser[0].equals(user) && checkPw[0].equals(pw)){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successful.");
                    alert.show();

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Ooops, Error!");
                    alert.setContentText("Incorrect User or Password.");
                    alert.show();
                }
                txtUserName.setText("");
                pf.setText("");
        });

        //Add HBox and GridPane to BorderPane
       this.setTop(hb);
       this.setCenter(gridPane);
    }
}
