/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User PC
 */
public class TypeActivite {
    private int id;
    private String libelle;
    private LocalDate  dateCreation;
    
    public TypeActivite(){
        
    }

    
    public TypeActivite(String libelle, LocalDate  dateCreation) {
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate  getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate  dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
       return libelle;
    }
    
    
}
