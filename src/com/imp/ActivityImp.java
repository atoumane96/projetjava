package com.imp;

import com.database.DB;
import com.entities.Activite;
import com.entities.Developpeur;
import com.entities.Equipe;
import com.entities.TypeActivite;
import com.metier.IActivite;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User PC
 */
public class ActivityImp implements IActivite{

    private DB db = new DB();
    
    
    public ActivityImp() {
    }

    
    @Override
    public int addActivite(Activite activite) {
        int rs = -1;

        try {
            String sql = 
                    "INSERT INTO activite VALUES (NULL,'"
                    + activite.getDateDebut()
                    + "','" + activite.getDateFin()
                    + "'," + activite.getTypeActivite().getId()
                    + ")";
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
        
        return rs;
    }
    
    

    @Override
    public Activite getActiviteById(int id) {
        Activite activite = null;
        String sql = "SELECT * FROM activite,typeactivite WHERE activite.id = " + id + " AND activite.type = typeactivite.id";
        try {
            ResultSet rs = db.executeSelect(sql);
            if (rs.next()) {
                activite = new Activite();
                activite.setId(rs.getInt("id"));
                activite.setDateDebut(LocalDate.parse(rs.getString("dateDebut")));
                activite.setDateFin(LocalDate.parse(rs.getString("dateFin")));
                activite.setTypeActivite(new TypeActivite(rs.getString("libelle"),LocalDate.parse(rs.getString("dateCreation"), DateTimeFormatter.ISO_DATE)));

            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        //return db.connectionRecuperation("SELECT * FROM user WHERE login = '"+login+"' AND password = '"+motDePasse+"'");
        //}

        return activite;
    }

    @Override
    public int updateActivite(int id, Activite activ) {
       int rs = -1;
        try {
            String sql = "UPDATE activite SET dateDebut = " + activ.getDateDebut() + ", dateFin = " + activ.getDateFin() + " WHERE activite.id = " + id;
            
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
        
        return rs;
    }

    
    @Override
    public int deleteActivite(int id) {
        int rs = -1;
        try {
            String sql = "DELETE FROM activite WHERE activite.id = " + id;
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    
    @Override
    public List<Equipe> getEquipeThisActivite(int id) {
        
           List<Equipe> liste = new ArrayList<>();
           String sql = "SELECT * FROM equipe WHERE id = " + id;
            
        try {
             ResultSet rs = db.executeSelect(sql);
             while (rs.next()) {
                Equipe equipe = new Equipe();
                equipe.setIdEquipe(rs.getInt("id"));
                equipe.setNom(rs.getString("nom"));
                equipe.setDateCreation(LocalDate.parse(rs.getString("dateCreation")));

                liste.add(equipe);
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        
                
        return liste;
    }
    

    @Override
    public int giveSprintToDev(int idActivite,Developpeur developpeur,String texte) {
       int rs = -1;

        try {
            String sql = "INSERT INTO tache VALUES (NULL,'"
                    + idActivite
                    + "','" + developpeur.getId()
                    + "','" + texte
                    + "')";
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
        
        return rs;
    }

    @Override
    public List<Activite> getAllActivite() {
       
           List<Activite> liste = new ArrayList<>();
           String sql = "SELECT * FROM `activite`,typeactivite WHERE activite.type=typeactivite.id";
            
        try {
             ResultSet rs = db.executeSelect(sql);
             while (rs.next()) {
               Activite activite = new Activite();
                activite.setId(rs.getInt("id"));
                activite.setDateDebut(LocalDate.parse(rs.getString("dateDebut")));
                activite.setDateFin(LocalDate.parse(rs.getString("dateFin")));
                activite.setTypeActivite(new TypeActivite(rs.getString("libelle"),LocalDate.parse(rs.getString("dateCreation"), DateTimeFormatter.ISO_DATE)));
                liste.add(activite);
            }

        } catch (Exception ex) { System.out.println(ex.getMessage());}
        
                
        return liste;
    }
    
    
    
}
