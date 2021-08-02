

package com.imp;

import com.database.DB;
import com.entities.ChefDeProjet;
import com.metier.IChefProjet;
import java.sql.ResultSet;

/**
 *
 * @author User PC
 */
public class ChefProImp implements IChefProjet{

    private DB db = new DB();

     public ChefProImp() {}
     
    @Override
    public ChefDeProjet auth(String login, String motdepass) {
        
        ChefDeProjet user = null;
        boolean loginSuccess = true;
        boolean mdpSuccess = true;

        String sql = "SELECT * FROM chefdeprojet WHERE identifiant = '" + login + "' AND motdepasse = '" + motdepass + "'";
        
        try {

            ResultSet rs = db.executeSelect(sql);
            if (rs.next()) {
                user = new ChefDeProjet();
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setAdresse(rs.getString("adresse"));
                user.setTelephone(rs.getString("telephone"));
                user.setPhoto(rs.getLong("photo"));
            }


        } catch (Exception ex) { System.out.println(ex.getMessage());}
        //return db.connectionRecuperation("SELECT * FROM user WHERE login = '"+login+"' AND password = '"+motDePasse+"'");
        //}

        return user;
     
    }
    
}
