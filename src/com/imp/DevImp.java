/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imp;

import com.database.DB;
import com.entities.Developpeur;
import com.metier.IDeveloppeur;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User PC
 */
public class DevImp implements IDeveloppeur{

    private DB db = new DB();
     
    public DevImp() {
    }
      
    @Override
    public int addDev(Developpeur dev) {
         int rs = -1;

        try {
            String sql = "INSERT INTO developpeur VALUES (NULL,'"
                    + dev.getNom()
                    + "','" + dev.getPrenom()
                    + "','" + dev.getTelephone()
                    + "','" + dev.getAdresse()
                    + "','" + dev.getRole()
                    + "','" + dev.getSpecialite()
                    + "','" + dev.getIdEquipe()
                    + "','" + dev.getPhoto()
                    + "')";
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    @Override
    public Developpeur getDevById(int id) {
        
        Developpeur developpeur = null;
        String sql = "SELECT * FROM developpeur WHERE developpeur.id = " + id;
        try {
            ResultSet rs = db.executeSelect(sql);
            if (rs.next()) {
                developpeur = new Developpeur();
                developpeur.setId(rs.getInt("id"));
                developpeur.setNom(rs.getString("nom"));
                developpeur.setPrenom(rs.getString("prenom"));
                developpeur.setTelephone(rs.getString("telephone"));
                developpeur.setAdresse(rs.getString("adresse"));
                developpeur.setRole(rs.getInt("role"));
                developpeur.setSpecialite(rs.getString("specialite"));
               // developpeur.setEquipe(new Equipe(rs.getString("nom"),rs.getDate("dateCreation"),rs.getInt("id")));
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        //return db.connectionRecuperation("SELECT * FROM user WHERE login = '"+login+"' AND password = '"+motDePasse+"'");
        //}

        return developpeur;
    }

    @Override
    public int updateDev(Developpeur developpeur) {
        
       int rs = -1;
        try {
            String sql = "UPDATE `developpeur` SET `nom` = '"+developpeur.getNom()+"', `prenom` = '"+developpeur.getPrenom()+"', `telephone` = '"+developpeur.getTelephone()+"', `adresse` = '"+developpeur.getAdresse()+"', `role` = '0', `specialite` = '"+developpeur.getSpecialite()+"' WHERE `developpeur`.`id` = "+developpeur.getId();;
            
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    @Override
    public int deleteDev(int id) {
        int rs = -1;
        try {
            String sql = "DELETE FROM `developpeur` WHERE `developpeur`.`id` = "+id;
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    @Override
    public List<Developpeur> getAllDev() {
         List<Developpeur> liste = new ArrayList<>();
           String sql = "SELECT * FROM developpeur";
            
        try {
             ResultSet rs = db.executeSelect(sql);
             while (rs.next()) {
               Developpeur dev = new Developpeur();
                dev.setId(rs.getInt("id"));
                dev.setNom(rs.getString("nom"));
                dev.setPrenom(rs.getString("prenom"));
                dev.setAdresse(rs.getString("adresse"));
                dev.setTelephone(rs.getString("telephone"));
                dev.setSpecialite(rs.getString("specialite"));
                dev.setIdEquipe(rs.getInt("idEquipe"));
                dev.setPhoto(1L);
                liste.add(dev);
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        
                
        return liste;
    }
    
    
   
}
