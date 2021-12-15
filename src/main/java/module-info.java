module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires mysql.connector.java;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}