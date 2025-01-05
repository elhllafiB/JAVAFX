module org.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires static lombok;

    opens org.example.demo3 to javafx.fxml;
    exports org.example.demo3;
    exports org.example.demo3.Utils;
    opens org.example.demo3.Utils to javafx.fxml;
    exports org.example.demo3.Controller;
    opens org.example.demo3.Controller to javafx.fxml;
}