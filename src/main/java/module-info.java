module com.jcalc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jcalc to javafx.fxml;
    exports com.jcalc;
}
