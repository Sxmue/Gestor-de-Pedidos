module com.cesur.gestortareas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires lombok;
    requires java.sql;
    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires ch.qos.logback.core;
    requires jbcrypt;
    requires itextpdf;



    opens img;
    exports com.cesur.gestorpedidos;
    opens com.cesur.gestorpedidos.controllers;
    exports com.cesur.gestorpedidos.traza;
    opens com.cesur.gestorpedidos.traza to javafx.fxml;
    exports com.cesur.gestorpedidos.controllers;
    opens com.cesur.gestorpedidos;
}