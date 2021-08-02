/*
*cette classe represente l'activite
*/
package com.entities;

import java.time.LocalDate;


public class Activite {
    
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private TypeActivite typeActivite;
    
    public Activite() {
    }

    public TypeActivite getTypeActivite() {
        return typeActivite;
    }

    public void setTypeActivite(TypeActivite typeActivite) {
        this.typeActivite = typeActivite;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
     
    
}
