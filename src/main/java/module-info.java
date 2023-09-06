module com.johann.colorfx {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.johann.colorfx to javafx.fxml;
    exports com.johann.colorfx;
    exports com.johann.colorfx.controller;
    opens com.johann.colorfx.controller to javafx.fxml;
}