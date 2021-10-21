package be.bacdesmedt.javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Scene Switcher");

        //SCENE I
        Label label1 = new Label("Welcome to the first scene");
        Button button1 = new Button("Go to scene 2");
        VBox layout1 = new VBox(20);
        scene1 = new Scene(layout1, 200, 200);

        button1.setOnAction(e -> window.setScene(scene2));
        layout1.getChildren().addAll(label1, button1);


        //SCENE II
        Button button2 = new Button("This scene sucks, go back to scene 1");
        StackPane layout2 = new StackPane();
        scene2 = new Scene(layout2, 400, 500);

        button2.setOnAction(e -> window.setScene(scene1));
        layout2.getChildren().add(button2);


        window.setScene(scene1);
        window.show();
    }
}
