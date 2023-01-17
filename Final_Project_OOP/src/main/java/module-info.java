module com.example.final_project_oop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.final_project_oop to javafx.fxml;
    exports com.example.final_project_oop;
}