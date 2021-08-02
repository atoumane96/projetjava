/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphic.groupe;

import com.entities.Developpeur;
import com.entities.Equipe;
import com.fonctionnalite.Outil;
import com.imp.DevImp;
import com.imp.EquipeImp;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class GroupeController implements Initializable {
    Outil outil = new Outil();
    DevImp devImp = new DevImp();
    EquipeImp equipeImp = new EquipeImp();
    List<Developpeur> devSelected = new ArrayList<>();
    ObservableList<Developpeur> developpeursListSelect = FXCollections.observableArrayList();
    ObservableList<Developpeur> developpeurs = FXCollections.observableArrayList();
     List<Developpeur> listeD = new ArrayList<>();
    private static Equipe eq = null;
    
    @FXML
    private TableView<Developpeur> tabEquipeSelected;

   
    @FXML
    private TableColumn<Developpeur, Integer> numeroTabEquipeSlelect;

    @FXML
    private TableColumn<Developpeur, String> nomTabEquipeSlelect;

    @FXML
    private TableColumn<Developpeur, String> prenomTabEquipeSlelect;

    @FXML
    private TableColumn<Developpeur, String> specialiteTabEquipeSlelect;

    @FXML
    private Text nomEquipe;
    @FXML
    private Ellipse btnAnnuler;

    @FXML
    private TableView<Developpeur> tabDeveloppeur;

    @FXML
    private TableColumn<Developpeur, Integer> numeroDev;

    @FXML
    private TableColumn<?, ?> nomDev;

    @FXML
    private TableColumn<?, ?> prenomDev;

    @FXML
    private TableColumn<?, ?> telephoneDev;

    @FXML
    private TableColumn<?, ?> adresseDev;

    @FXML
    private TableColumn<?, ?> specialiteDev;

    @FXML
    private JFXButton btnSelect;

    @FXML
    private JFXButton BtnConnexion11;

    @FXML
    private Ellipse listeGroupePane;

    @FXML
    private TableView<Developpeur> tabDevSelect;

    @FXML
    private TableColumn<Developpeur, Integer> colNumeroDevSelect;

    @FXML
    private TableColumn<Developpeur, String> colNomDevSelect;

    @FXML
    private TableColumn<Developpeur, String> colPrenomDevSelect;

    @FXML
    private TableColumn<Developpeur, String> colSpecialiteDevSelect;

    @FXML
    private JFXButton btnValiderGroupeDev;

    @FXML
    private JFXButton btnAnnulerCreationGroup;

    @FXML
    private TableView<Equipe> tabEquipe;

    @FXML
    private TableColumn<Equipe, Integer> colNumeroTabEquipe;

    @FXML
    private TableColumn<Equipe, String> colNomTabEquipe;

    @FXML
    private TableColumn<Equipe, String> colDateCreaTabEquipe;

    @FXML
    private JFXButton btnEditGroupe;

    @FXML
    private JFXButton btnDeleteGroup;
    
    @FXML
    private JFXButton btnActualiser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadGroupe();
       initDevList();
       loadDevData();
       
    }    
    
    private void teste(){
        
    }
    
    public void actualiser(){
       loadGroupe();
    }
    
    public void retourHome(ActionEvent event){
        outil.redirect(event,  "/com/graphic/home/home.fxml");
   }
    
    private void initDevList(){
        numeroDev.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomDev.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomDev.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        adresseDev.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        telephoneDev.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        specialiteDev.setCellValueFactory(new PropertyValueFactory<>("specialite"));
    }
    
    private void loadDevData(){
        List<Developpeur> devListe = devImp.getAllDev();

        for (Developpeur c : devListe) {
            developpeurs.add(c);
           // System.out.println("**************"+c.getTelephone());
        }
        tabDeveloppeur.setItems(developpeurs);
        //devListe.clear();
    }
    
    @FXML
    public void loadSelectDev(){
        initTabDevSelected();
        devSelected.clear();
        TableView.TableViewSelectionModel<Developpeur> deve = tabDeveloppeur.getSelectionModel();
        Developpeur de = deve.getSelectedItem();
        devSelected.add(de);
        
       
        //List<Developpeur> devListe = devImp.getAllDev();

        for (Developpeur c : devSelected) {
            developpeursListSelect.add(c);
        }
        tabDevSelect.setItems(developpeursListSelect);
       
        
    }
    
    
    private void initTabDevSelected(){
        colNumeroDevSelect.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomDevSelect.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenomDevSelect.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colSpecialiteDevSelect.setCellValueFactory(new PropertyValueFactory<>("specialite"));
    }
    
     private void initTableGroupe(){
        colNumeroTabEquipe.setCellValueFactory(new PropertyValueFactory<>("idEquipe"));
        colNomTabEquipe.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colDateCreaTabEquipe.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
       
    }
     
     private void initTableGroupeSelected(){
        numeroTabEquipeSlelect.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomTabEquipeSlelect.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomTabEquipeSlelect.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specialiteTabEquipeSlelect.setCellValueFactory(new PropertyValueFactory<>("specialite"));
       
    }
    
    public void flushTabDevSelected(){
       //ObservableList<Developpeur> developpeurs = FXCollections.observableArrayList();
       developpeursListSelect.clear();
       tabDevSelect.setItems(developpeursListSelect);
       devSelected.clear();
    }
    
    @FXML
    public void createEquipe(ActionEvent event){
        if(!devSelected.isEmpty()){
            for (Developpeur c : devSelected) {
            developpeursListSelect.add(c);
            }
        
        
         try {
              //((Node) event.getSource()).getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/com/graphic/form/nomEquipe.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
              } catch (IOException ex) { System.out.println(ex.getMessage());}
         
        }else{
            System.out.println("la liste est vide");
        }
       
        deployDev();
        flushTabDevSelected();
    }
    
    
    
    public void loadGroupe(){
        initTableGroupe();
        ObservableList<Equipe> equipeListe = FXCollections.observableArrayList();
        
        List<Equipe> liste = equipeImp.getAllEquipe();

        for (Equipe e : liste) {
            equipeListe.add(e);
        }
        tabEquipe.setItems(equipeListe);
       
    }
    
   
   public void deleteEquipe(){
        TableView.TableViewSelectionModel<Equipe> equipes = tabEquipe.getSelectionModel();
        Equipe equipe = equipes.getSelectedItem();
        equipeImp.deleteEquipe(equipe.getIdEquipe());
        loadGroupe();
   }
   
   public void detailsGroupe(){
       
       initTableGroupeSelected();
       ObservableList<Developpeur> devListe = FXCollections.observableArrayList();
       listeD.clear();
       TableView.TableViewSelectionModel<Equipe> equipes = tabEquipe.getSelectionModel();
       Equipe e = equipes.getSelectedItem();
       nomEquipe.setText(e.getNom());
       
        listeD = equipeImp.getDevThisEquipe(e.getIdEquipe());
      // System.out.println("**********"+e.getIdEquipe());
       if(!listeD.isEmpty()){
           
            for (Developpeur dev : listeD) {
                devListe.add(dev);
            }
            tabEquipeSelected.setItems(devListe);
       }
       
   }
   
   
  
    
   public void deployDev(){
        
       // List<Developpeur> listeDev = controller.getAllDevSelected();
        List<Equipe> allEquipe = equipeImp.getAllEquipe();
        Equipe lastEquipe = allEquipe.get(allEquipe.size());
        
        System.out.println("*************"+lastEquipe.getNom());
        equipeImp.createEquipe(devSelected, (lastEquipe.getIdEquipe()+1));
   }
  
   
}
