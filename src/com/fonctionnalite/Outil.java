/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fonctionnalite;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author User PC
 */
public class Outil {
    
    
    public  void redirect(ActionEvent event,String url){
        try {
              ((Node) event.getSource()).getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource(url));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
              } catch (IOException ex) { System.out.println(ex.getMessage());}
    }
    
    public int msgConfirm(){
        /* JOptionPane dialog = new JOptionPane("",JOptionPane.YES_NO_OPTION);
         JDialog boite = dialog.createDialog("");
        
        boite.setVisible(true);
        */
        return 0;
    }
}
