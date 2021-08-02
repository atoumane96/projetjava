/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import com.entities.ChefDeProjet;

/**
 *
 * @author User PC
 */
public interface IChefProjet {
    public ChefDeProjet auth(String identifiant, String motdepass);
}
