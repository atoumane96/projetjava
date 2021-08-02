/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author User PC
 */
public class Tache {
    private int id;
    private int idDev;
    private int idActivite;
    private String sprint;

    public Tache() {
       
    }
    
    public Tache(int idDev, int idActivite, String sprint) {
        this.idDev = idDev;
        this.idActivite = idActivite;
        this.sprint = sprint;
    }

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }
    
    
}
