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
public class Rubrique {
 
    private Vector<Chapitre> chapitres;
    private String alphabet;

    public Rubrique() {
    }
    
    public Rubrique(Vector<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public Rubrique(String alphabet) {
        this.alphabet = alphabet;
    }

    public Rubrique(Vector<Chapitre> chapitres, String alphabet) {
        this.chapitres = chapitres;
        this.alphabet = alphabet;
    }
    
    
    public Vector<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(Vector<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "Rubrique{" + "chapitres=" + chapitres + ", alphabet=" + alphabet + '}';
    }
}
