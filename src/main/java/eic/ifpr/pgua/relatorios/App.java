package eic.ifpr.pgua.relatorios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import eic.ifpr.pgua.relatorios.daos.FakePessoaDao;
import eic.ifpr.pgua.relatorios.repositorios.RepositorioPessoas;
import eic.ifpr.pgua.relatorios.telas.Principal;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("principal"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        fxmlLoader.setControllerFactory(aClass -> new Principal(new RepositorioPessoas(new FakePessoaDao())));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}