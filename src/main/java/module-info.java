module Assignment1_Fikri {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires java.sql;


    opens Assignment1 to javafx.fxml;
    exports Assignment1;
}