/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphic.home;

import com.fonctionnalite.Outil;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class HomeController implements Initializable {

     public AnchorPane pane1,pane2,pane3,pane4,opacityPane,drawerPane;
        public JFXButton btnDeconnexion;
        public JFXButton btnGestionEquipe;
         private Outil outil = new Outil();
    
    /**
     * Initializes the controller class.
     */
        
        
     @FXML
     public ImageView drawerImage;
     
     
      @FXML
      
         private void Deconnexion(ActionEvent event) throws IOException {
                outil.redirect(event, "/com/graphic/auth/Authentification.fxml");
         }
    
           @FXML
                  private void GestionEquipe(ActionEvent event) throws IOException {
                  //btnGestionEquipe.getScene().getWindow().hide();
                  Stage GE = new Stage();
                  Parent root = FXMLLoader.load(getClass().getResource("Equipe.fxml"));
                  Scene sceneMenu = new Scene(root);
                  GE.setScene(sceneMenu);
                  GE.show();
                  GE.setResizable(false);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
         opacityPane.setVisible(false);
       
       FadeTransition FT = new FadeTransition(Duration.seconds(0.5),opacityPane);
       FT.setFromValue(0);
       FT.setToValue(0.15);
       FT.play();
       
        
        
       TranslateTransition TT = new TranslateTransition(Duration.seconds(0.5),drawerPane);
       TT.setByX(-600);
       TT.play();
        
       pane1.setStyle("-fx-background-image: url('/images/back1.jpg')");
       pane2.setStyle("-fx-background-image: url('/images/back2.jpg')");
       pane3.setStyle("-fx-background-image: url('/images/back3.jpg')");
       pane4.setStyle("-fx-background-image: url('/images/slide-3.jpg')");
       
       
       //fonction pour le slider
       Slider();
       
       
       
       //fonction pour icon du menu pour la navigation drawwer
      // handleDrawer();
       
       drawerImage.setOnMouseClicked(( MouseEvent event) ->{
       opacityPane.setVisible(true);
        
       FadeTransition FT1 = new FadeTransition(Duration.seconds(0.5),opacityPane);
       FT1.setFromValue(0);
       FT1.setToValue(0.15);
       FT1.play();
           
       
       TranslateTransition TT1 = new TranslateTransition(Duration.seconds(0.5),drawerPane);
       TT1.setByX(+600);
       TT1.play();
       });
       
       
       opacityPane.setOnMouseClicked(( MouseEvent event) ->{
       
      
       FadeTransition FT1 = new FadeTransition(Duration.seconds(0.5),opacityPane);
       FT1.setFromValue(0);
       FT1.setToValue(0.15);
       FT1.play();
       
        
       FT1.setOnFinished((ActionEvent event1)   ->{
       opacityPane.setVisible(false);
       });
        
        TranslateTransition TT1 = new TranslateTransition(Duration.seconds(0.5),drawerPane);
        TT1.setByX(-600);
        TT1.play();
        });

    }    
    
     public void Slider()
     {
        
       FadeTransition FT = new FadeTransition(Duration.seconds(3),pane4);
       FT.setFromValue(1);
       FT.setToValue(0);
       FT.play();
       
       FT.setOnFinished((ActionEvent event) -> {
       FadeTransition FT1 = new FadeTransition(Duration.seconds(3),pane3);
       FT1.setFromValue(1);
       FT1.setToValue(0);
       FT1.play();
       
       
       FT1.setOnFinished((ActionEvent event1) -> {
       FadeTransition FT2 = new FadeTransition(Duration.seconds(3),pane2);
       FT2.setFromValue(1);
       FT2.setToValue(0);
       FT2.play();
       
       
       FT2.setOnFinished((ActionEvent event2) -> {
       FadeTransition FT3 = new FadeTransition(Duration.seconds(3),pane2);
       FT3.setFromValue(0);
       FT3.setToValue(1);
       FT3.play();
       
       
        FT3.setOnFinished((ActionEvent event3) -> {
        FadeTransition FT4 = new FadeTransition(Duration.seconds(3),pane3);
        FT4.setFromValue(0);
        FT4.setToValue(1);
        FT4.play();
       
            FT4.setOnFinished((ActionEvent event4) -> {
            FadeTransition FT5 = new FadeTransition(Duration.seconds(3),pane4);
            FT5.setFromValue(0);
            FT5.setToValue(1);
            FT5.play();

                 });
         
         });
       
       
         });
       
       
         });
       
       
       
       
       
       
       
       });
    
    }
    
    @FXML
     public void redirectionTOActivity(ActionEvent event){
         outil.redirect(event,  "/com/graphic/activite/activite.fxml");
     }
     
     @FXML
     public void redirectionToDev(ActionEvent event){
         outil.redirect(event,  "/com/graphic/dev/dev.fxml");
     }
     
     @FXML
     public void redirectionToGroup(ActionEvent event){
         outil.redirect(event,  "/com/graphic/groupe/groupe.fxml");
     }
}
