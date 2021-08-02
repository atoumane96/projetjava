
package com.entities;

import java.time.LocalDate;
import java.util.Date;


public class Equipe {
    
    private String nom;
    private LocalDate  dateCreation;
    private int idEquipe;

    public Equipe() {
    }

    public Equipe(String nom, LocalDate  dateCreation, int idEquipe) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.idEquipe = idEquipe;
    }

    
    public String getNom() {
        return nom;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate  getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate  dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
}
