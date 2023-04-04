/**
 * @author Nenad Jovanovic
 * @version 1.0
 */
module com.example.word_analyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.jsoup;

    opens com.example.word_analyzer to javafx.fxml;
    exports com.example.word_analyzer;
}