module com.omnistock.omnistock {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.omnistock.omnistock to javafx.fxml;
    exports com.omnistock.omnistock;
}