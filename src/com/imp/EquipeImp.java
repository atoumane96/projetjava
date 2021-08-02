/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imp;

import com.database.DB;
import com.entities.Developpeur;
import com.entities.Equipe;
import com.metier.IEquipe;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User PC
 */
public class EquipeImp implements IEquipe{

    DB db = new DB();
    
    public EquipeImp() {
    }
    
    @Override
    public int addEquipe(Equipe equipe) {
        int rs = -1;
        try {
            String sql = "INSERT INTO equipe VALUES (NULL,'"
                    + equipe.getNom()
                    + "','" + equipe.getDateCreation()
                    + "')";
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    

    @Override
    public Equipe getEquipeById(int id) {
        Equipe equipe = null;
        String sql = "SELECT * FROM equipe WHERE id = " + id;
        
        try {
            ResultSet rs = db.executeSelect(sql);
            if (rs.next()) {
                equipe = new Equipe();
                equipe.setIdEquipe(rs.getInt("id"));
                equipe.setNom(rs.getString("nom"));
                equipe.setDateCreation(LocalDate.parse(rs.getString("dateCreation")));
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        //return db.connectionRecuperation("SELECT * FROM user WHERE login = '"+login+"' AND password = '"+motDePasse+"'");
        //}

        return equipe;
    }

    
    @Override
    public int updateEquipe(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteEquipe(int id) {
      int rs = -1;
        try {
            String sql = "DELETE FROM equipe  WHERE equipe.id = "+id;
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    @Override
    public List<Developpeur> getDevThisEquipe(int id) {
        List<Developpeur> liste = new ArrayList<>();
        String sql = "SELECT * FROM developpeur WHERE idEquipe = " + id;
        try {
            ResultSet rs = db.executeSelect(sql);
             while (rs.next()) {
             Developpeur developpeur = new Developpeur();
                         developpeur.setId(rs.getInt("id"));
                         developpeur.setNom(rs.getString("nom"));
                         developpeur.setPrenom(rs.getString("prenom"));
                         developpeur.setTelephone(rs.getString("telephone"));
                         developpeur.setAdresse(rs.getString("adresse"));
                         developpeur.setRole(rs.getInt("role"));
                         developpeur.setSpecialite(rs.getString("specialite"));
                         liste.add(developpeur);
                         //developpeur.setEquipe(new Equipe(rs.getString("nom"),rs.getDate("dateCreation"),rs.getInt("id")));
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        
        return liste;
    }
    

    @Override
    public int chooseLeedGroup(int id) {
        int rs = -1;
        try {
            String sql = "UPDATE developpeur SET role = 1 WHERE developpeur.id = " +id;
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    
     public int createEquipe(List<Developpeur> developpeurs,int idE){
           int rs = -1;
           
           for(Developpeur dv : developpeurs){
                try {
                    String sql = "UPDATE developpeur SET idEquipe = " + idE + " WHERE developpeur.id = "+dv.getId();
                    db.initPrepare(sql);
                    rs = db.executeMaj();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
           }
       
        return rs;
       
    }
     
     
     public List<Equipe> getAllEquipe(){
         List<Equipe> equipes = new ArrayList<>();
        String sql = "SELECT * FROM equipe";
        
        try {
            ResultSet rs = db.executeSelect(sql);
            while (rs.next()) {
                Equipe equipe = new Equipe();
                equipe.setIdEquipe(rs.getInt("id"));
                equipe.setNom(rs.getString("nom"));
                equipe.setDateCreation(LocalDate.parse(rs.getString("dateCreation")));
                equipes.add(equipe);
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
       
        return equipes;
     }
}
