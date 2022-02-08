package eic.ifpr.pgua.relatorios.telas;

import java.io.File;
import java.time.format.DateTimeFormatter;

import eic.ifpr.pgua.relatorios.models.Pessoa;
import eic.ifpr.pgua.relatorios.repositorios.RepositorioPessoas;
import eic.ifpr.pgua.relatorios.utils.GeradorRelatorios;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class Principal {
    
    @FXML
    private TableView<Pessoa> tbPessoas;
    
    @FXML
    private TableColumn<Pessoa,Integer> tbcIdPessoa;

    @FXML
    private TableColumn<Pessoa,String> tbcNomePessoa;
    
    @FXML
    private TableColumn<Pessoa,String> tbcNascimentoPessoa;
    
    @FXML
    private TableColumn<Pessoa,Double> tbcAlturaPessoa;
    

    private RepositorioPessoas repositorioPessoas;

    public Principal(RepositorioPessoas repositorioPessoas){
        this.repositorioPessoas = repositorioPessoas;
    }


    public void initialize(){

        tbcIdPessoa.setCellValueFactory(item -> new SimpleIntegerProperty(item.getValue().getId()).asObject());
        tbcNomePessoa.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getNome()));
        tbcNascimentoPessoa.setCellValueFactory(item -> new SimpleStringProperty(item.getValue().getNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tbcAlturaPessoa.setCellValueFactory(item -> new SimpleDoubleProperty(item.getValue().getAltura()).asObject());
        
        try{
            tbPessoas.getItems().addAll(repositorioPessoas.listarPessoas());
        }catch(Exception e){
            Alert alert = new Alert(AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void gerarPdf(){
        GeradorRelatorios geradorRelatorios = new GeradorRelatorios(repositorioPessoas);
        try{
            
            FileChooser fc = new FileChooser();
            File f = fc.showSaveDialog(null);
            
            if(f != null){
                geradorRelatorios.gerarRelatorioPessoas(f.getName());
            }
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR,e.getMessage());
            alert.showAndWait(); 
        }
    }

}
