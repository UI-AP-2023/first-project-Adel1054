module com.example.onlineshop {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.onlineshop.model.commodity to javafx.fxml;
    opens com.example.onlineshop.model.user.consumer to javafx.fxml;
    exports com.example.onlineshop.model.commodity;
    exports com.example.onlineshop.model.user.consumer;
    exports com.example.onlineshop.view.sceneControllers to javafx.fxml;
    opens com.example.onlineshop.view.sceneControllers;
    opens com.example.onlineshop to javafx.fxml;
    exports com.example.onlineshop;
}