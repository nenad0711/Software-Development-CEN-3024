module Word_Analyzer {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires javafx.base;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
}
