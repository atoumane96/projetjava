/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphic.form;

import com.entities.Equipe;
import com.fonctionnalite.Outil;
import com.imp.EquipeImp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author User PC
 */
public class NomEquipeController implements Initializable {

    EquipeImp equipeImp = new EquipeImp();
    Outil outil = new Outil();
    
    @FXML
    private JFXTextField txtNomEquipe;

    @FXML
    private JFXButton btnSelect;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void closeFen(ActionEvent event){
       ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
    public void addEquipe(ActionEvent event){
        Equipe equipe = new Equipe();
     
        equipe.setDateCreation(LocalDate.now());
        equipe.setNom(txtNomEquipe.getText());
        equipeImp.addEquipe(equipe);
       
        
        closeFen(event);
        
     
        
    }
    
    
}
