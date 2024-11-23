module com.form.form {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.form.form to javafx.fxml;
    exports com.form.form;
}