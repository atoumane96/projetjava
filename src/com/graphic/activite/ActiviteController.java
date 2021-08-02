package com.graphic.activite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.entities.Activite;
import com.entities.TypeActivite;
import com.fonctionnalite.Outil;
import com.imp.ActivityImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class ActiviteController implements Initializable {

    Outil outil = new Outil();
            
    private ActivityImp activiteImp = new ActivityImp();
    @FXML
    private JFXButton BtnConnexion;
    
     @FXML
    private DatePicker dateDebut;

    @FXML
    private DatePicker dateFin;

    @FXML
    private JFXButton BtnConnexion1;

    @FXML
    private JFXButton BtnConnexion11;

    @FXML
    private TableView<Activite> tableActivite;
    
    @FXML
    private TableColumn<Activite, TypeActivite> colType;

    @FXML
    private TableColumn<Activite, Integer> colNumero;

    @FXML
    private TableColumn<Activite, String> colDateDebut;

    @FXML
    private TableColumn<Activite, String> colDateFin;

    @FXML
    private TableColumn<Activite, ?> colAction;
    
    @FXML
    private JFXCheckBox type1;

    @FXML
    private JFXCheckBox type2;

    @FXML
    private JFXCheckBox type3;

    @FXML
    void addActivity(ActionEvent event) {
           LocalDate dateD =  dateDebut.getValue();
           LocalDate dateF =  dateFin.getValue();
           Activite activite = new Activite();
           TypeActivite ta = new TypeActivite();
           ta.setDateCreation(null);
           ta.setLibelle(null);
           
           if(type1.isSelected()){
               ta.setId(1);
              
           }else if(type2.isSelected()){
               ta.setId(2);
              
           }else if(type3.isSelected()){
               ta.setId(3);
              
           }
           
           activite.setTypeActivite(ta);
           activite.setDateDebut(dateD);
           activite.setDateFin(dateF);
          
           
           activiteImp.addActivite(activite);
           loadData();
           initialiser();
    }

    @FXML
    void deleteActivity(ActionEvent event) {
        TableView.TableViewSelectionModel<Activite> activity = tableActivite.getSelectionModel();
        Activite ac = activity.getSelectedItem();
        activiteImp.deleteActivite(ac.getId());
        loadData();
    }

    @FXML
    void editActivity(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNumero.setCellValueFactory(new PropertyValueFactory<>("id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("typeActivite"));
        colDateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        colDateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        loadData();
    }
    
    
    
   private void loadData(){
        ObservableList<Activite> activites = FXCollections.observableArrayList();
        List<Activite> ActiviteListe = activiteImp.getAllActivite();

        for (Activite c : ActiviteListe) {
            activites.add(c);
         // System.out.println("**************"+c.getNom());
        }
        tableActivite.setItems(activites);

   }
   
   public void initialiser(){
     dateDebut.setValue(null);
     dateFin.setValue(null);
     type1.disarm();
     type2.disarm();
     type3.disarm();
   }
   
   public void retourHome(ActionEvent event){
        outil.redirect(event,  "/com/graphic/home/home.fxml");
   }
   
}
