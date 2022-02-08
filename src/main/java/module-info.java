module eic.ifpr.pgua.relatorios {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;
    
    opens eic.ifpr.pgua.relatorios.telas to javafx.fxml;
    exports eic.ifpr.pgua.relatorios;
}
