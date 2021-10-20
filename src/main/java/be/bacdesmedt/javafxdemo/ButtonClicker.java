package be.bacdesmedt.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonClicker extends Application{

    public static final String TITLE = "JavaFX Demo";

    Button button;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle(TITLE);
        /*FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);*/

        button = new Button();
        button.setText("click me");
        button.setOnAction(e -> {
            new Alert(Alert.AlertType.NONE,
                    "I love it when you touch me like that",
                    ButtonType.CLOSE
            ).show();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);

        stage.show();
    }
}