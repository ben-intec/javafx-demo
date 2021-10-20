module be.bacdesmedt.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.bacdesmedt.javafxdemo to javafx.fxml;
    exports be.bacdesmedt.javafxdemo;
}