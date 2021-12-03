module com.ponser2000.appclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.fasterxml.jackson.databind;

    opens com.ponser2000.appclient to javafx.fxml;
    exports com.ponser2000.appclient;
}
