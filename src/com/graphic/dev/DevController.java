/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphic.dev;

import com.entities.Developpeur;
import com.fonctionnalite.Outil;
import com.imp.DevImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class DevController implements Initializable {
    Outil outil = new Outil();
    DevImp devImp = new DevImp();
    
    @FXML
    private JFXTextField txtNom;

    @FXML
    private JFXTextField txtPrenom;

    @FXML
    private JFXTextField txtAdresse;

    @FXML
    private JFXTextField txtTelephone;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<Developpeur> tabDev;

    @FXML
    private TableColumn<Developpeur, Integer> numeroDev;

    @FXML
    private TableColumn<Developpeur, String> nomDev;

    @FXML
    private TableColumn<Developpeur, String> prenomDev;

    @FXML
    private TableColumn<Developpeur, String> adresseDev;

    @FXML
    private TableColumn<Developpeur, String> telephoneDev;

    @FXML
    private TableColumn<Developpeur, String> specialiteDev;
    
    @FXML
    private JFXTextField txtSpecilaite;


   @Override
    public void initialize(URL location, ResourceBundle resources) {
        numeroDev.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomDev.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomDev.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresseDev.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        telephoneDev.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        specialiteDev.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        loadData();
    }
    
    
    
   private void loadData(){
        ObservableList<Developpeur> developpeurs = FXCollections.observableArrayList();
        List<Developpeur> devListe = devImp.getAllDev();

        for (Developpeur c : devListe) {
            developpeurs.add(c);
           // System.out.println("**************"+c.getTelephone());
        }
        tabDev.setItems(developpeurs);

   }
    
    
    @FXML
    private void addDev(){
        Developpeur developpeur = new Developpeur();
        developpeur.setNom(txtNom.getText());
        developpeur.setPrenom(txtPrenom.getText());
        developpeur.setAdresse(txtAdresse.getText());
        developpeur.setTelephone(txtTelephone.getText());
        developpeur.setSpecialite(txtSpecilaite.getText());
        developpeur.setPhoto(1L);
        
        devImp.addDev(developpeur);
        loadData();
        initForm();
    }
    
    
    @FXML
    private Developpeur editDev(){
        TableView.TableViewSelectionModel<Developpeur> deve = tabDev.getSelectionModel();
        Developpeur de = deve.getSelectedItem();
        txtNom.setText(de.getNom());
        txtPrenom.setText(de.getPrenom());
        txtAdresse.setText(de.getAdresse());
        txtSpecilaite.setText(de.getSpecialite());
        txtTelephone.setText(de.getTelephone());
        
       return de;
    }
    
    
     @FXML
    private void deletetDev(){
        TableView.TableViewSelectionModel<Developpeur> deve = tabDev.getSelectionModel();
        Developpeur de = deve.getSelectedItem();
        devImp.deleteDev(de.getId());
        loadData();
    }
    
    public void initForm(){
        txtNom.setText("");
        txtPrenom.setText("");
        txtAdresse.setText("");
        txtSpecilaite.setText("");
        txtTelephone.setText("");
    }
    
    public void retourHome(ActionEvent event){
        outil.redirect(event,  "/com/graphic/home/home.fxml");
   }
    
    public void modifierDev(){
        Developpeur d = editDev();
        devImp.updateDev(d);
        
        System.out.println("*********"+d.getId());
    }
}
