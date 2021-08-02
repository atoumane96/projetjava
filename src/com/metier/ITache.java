/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import com.entities.Tache;

/**
 *
 * @author User PC
 */
public interface ITache {
    
    public int addTache(Tache tache);
    public Tache getTacheByid(int id);
    public int updateTache(int id, Tache tache);
    public int deleteTache(int id);
    public Tache getDevTache(int idDev);
    
}
