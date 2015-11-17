/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.util.Vector;

/**
 *
 * @author MuStapha
 */
public class Chapitre {
    
    private Vector<RacineFam> racineFams;

    private String valeur;

    public Chapitre() {
    }
    
    public Chapitre(Vector<RacineFam> racineFams) {
        this.racineFams = racineFams;
    }

    public Chapitre(String valeur) {
        this.valeur = valeur;
    }

    public Chapitre(Vector<RacineFam> racineFams, String valeur) {
        this.racineFams = racineFams;
        this.valeur = valeur;
    }
    
    public Vector<RacineFam> getRacineFams() {
        return racineFams;
    }

    public void setRacineFams(Vector<RacineFam> racineFams) {
        this.racineFams = racineFams;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Chapitre{" + "racineFams=" + racineFams + ", valeur=" + valeur + '}';
    }

    
  
    
}
