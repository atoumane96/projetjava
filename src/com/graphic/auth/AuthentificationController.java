/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphic.auth;

import com.entities.ChefDeProjet;
import com.fonctionnalite.Outil;
import com.imp.ChefProImp;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static com.sun.javafx.application.PlatformImpl.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class AuthentificationController implements Initializable {

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXPasswordField txtPassword;
    
    private ChefProImp service = new ChefProImp();
    private Outil outil = new Outil();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void controlAuth(ActionEvent event){
        String identifiant = txtName.getText();
        String mdp = txtPassword.getText();
        
        //System.out.println(identifiant+"  "+mdp);
        ChefDeProjet cdp =  service.auth(identifiant, mdp);
        
        if( cdp != null){
            outil.redirect(event, "/com/graphic/home/home.fxml");
        }else{
            System.out.println("login ou mot de passe incorrect");
        }
    }
    
     public void exiteAppli()
     {
     exit();
     }
    
}
