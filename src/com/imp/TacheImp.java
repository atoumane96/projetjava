/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imp;

import com.database.DB;
import com.entities.Tache;
import com.metier.ITache;

/**
 *
 * @author User PC
 */
public class TacheImp implements ITache{

    DB db = new DB();
    public TacheImp() {
    }

    @Override
    public int addTache(Tache tache) {
       int rs = -1;

        /*try {
            String sql = "INSERT INTO tache VALUES (NULL,'"
                    + activite.getDateDebut()
                    + "','" + activite.getDateFin()
                    + "','" + activite.getTypeActivite()
                    + "')";
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;*/
        return 0;
    }

    @Override
    public Tache getTacheByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int deleteTache(int id) {
        int rs = -1;
        try {
            String sql = "DELETE FROM tache =  WHERE tache.id = " +id;
            db.initPrepare(sql);
            rs = db.executeMaj();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    @Override
    public Tache getDevTache(int idDev) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateTache(int id, Tache tache) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
