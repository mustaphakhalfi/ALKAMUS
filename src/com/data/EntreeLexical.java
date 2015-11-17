/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

/**
 *
 * @author MuStapha
 */
public class EntreeLexical {
    private String racine;
    private String lemme;
    private String texteBrut;
    private Definition definition;
    private String valeurChapitre;
    private String valeurRacineFam;
    

    public EntreeLexical() {
        
    }

    
    
    public EntreeLexical( String texteBrut) {
        this.texteBrut = texteBrut;
        this.definition.setSens("sens");
        this.valeurChapitre="";
    }
    
    
    
    public String getRacine() {
        return racine;
    }

    public void setRacine(String racine) {
        this.racine = racine;
    }

    public String getTexteBrut() {
        return texteBrut;
    }

    public void setTexteBrut(String texteBrut) {
        this.texteBrut = texteBrut;
    }

    public Definition getDefinition() {
        return definition;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public String getValeurChapitre() {
        return valeurChapitre;
    }

    public void setValeurChapitre(String valeurChapitre) {
        this.valeurChapitre = valeurChapitre;
    }

    public String getLemme() {
        return lemme;
    }

    public void setLemme(String lemme) {
        this.lemme = lemme;
    }

    public String getValeurRacineFam() {
        return valeurRacineFam;
    }

    public void setValeurRacineFam(String valeurRacineFam) {
        this.valeurRacineFam = valeurRacineFam;
    }

    @Override
    public String toString() {
        return "EntreeLexical{" + "texteBrut=" + texteBrut + ", racine=" + racine + ", lemme=" + lemme + ", definition=" + definition + ", valeurChapitre=" + valeurChapitre + ", valeurRacineFam=" + valeurRacineFam + '}';
    }
    
}
