module com.example.decorator_programmingtechnology {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.decorator_programmingtechnology to javafx.fxml;
    exports com.example.decorator_programmingtechnology;
}