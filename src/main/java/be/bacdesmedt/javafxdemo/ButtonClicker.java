package be.bacdesmedt.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class ButtonClicker extends Application{

    public static final String TITLE = "Pervy Button";

    Button button;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle(TITLE);
        button = new Button();
        button.setText("Touch me");
        button.setOnAction(this::showAlert);

        stage.setOnCloseRequest(this::onClose);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 150);
        stage.setScene(scene);

        stage.show();
    }

    private void showAlert(ActionEvent e) {
        new Alert(Alert.AlertType.NONE,
                "I love it when you touch me like that",
                ButtonType.CLOSE
        ).show();
    }

    private void onClose(WindowEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("You are ending our time together");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("I haven't touched you yet!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL){
            e.consume();
        }
    }

}

