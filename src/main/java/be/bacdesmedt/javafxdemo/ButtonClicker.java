package be.bacdesmedt.javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class ButtonClicker extends Application {

    public static final String TITLE = "Pervy Button";

    Button button1, button2, button3, button4;

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        window = stage;

        window.setTitle(TITLE);
        button1 = new Button("Touch me");
        button2 = new Button("Touch me here");
        button3 = new Button("Sensitive spot");
        button4 = new Button("Don't touch me");

        button1.setOnAction(this::touchMe);
        button2.setOnAction(this::touchMeHere);
        button3.setOnAction(this::sensitiveSpot);
        button4.setOnAction(this::dontTouch);

        window.setOnCloseRequest(this::onClose);

        GridPane layout = new GridPane();

        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints();
            RowConstraints row = new RowConstraints();

            column.setPercentWidth(50);
            column.setHalignment(HPos.CENTER);

            row.setPercentHeight(50);
            row.setValignment(VPos.CENTER);
            layout.getColumnConstraints().add(column);
            layout.getRowConstraints().add(row);
        }

        layout.addRow(0,button1,button2);
        layout.addRow(1,button3,button4);


        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);

        window.show();
    }

    private void touchMe(ActionEvent e) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You touched me");
        alert.setHeaderText("I love it when you touch me like that");
        alert.setContentText("Feels nice.");
        alert.show();
    }

    private void touchMeHere(ActionEvent e) {
        new Alert(Alert.AlertType.NONE,
                "Ooh yeah!",
                ButtonType.CLOSE
        ).show();
    }

    private void sensitiveSpot(ActionEvent e) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("You touched my sensitive spot");
        alert.setHeaderText("Careful, I'm sensitive here!");
        alert.setContentText("Be gentle.");
        alert.show();
    }

    private void dontTouch(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("You touched my forbidden spot");
        alert.setHeaderText("I said: DON'T TOUCH!");
        alert.setContentText("Grrrr");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
           window.close();
        }
    }

    private void onClose(WindowEvent e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("You are ending our time together");
        alert.setHeaderText("Are you sure?");
        alert.setContentText("I haven't touched you yet!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.CANCEL) {
            e.consume();
        }
    }

}

