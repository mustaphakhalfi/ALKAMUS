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
public class RacineFam {
    
    private Vector<EntreeLexical> entrerLexicals;
    private String valeurRacine;

    public RacineFam() {
    }

    public RacineFam(Vector<EntreeLexical> entrerLexicals) {
        this.entrerLexicals = entrerLexicals;
    }

    public RacineFam(String valeurRacine) {
        this.valeurRacine = valeurRacine;
    }
    
    public RacineFam(Vector<EntreeLexical> entrerLexicals, String valeurRacine) {
        this.entrerLexicals = entrerLexicals;
        this.valeurRacine = valeurRacine;
    }

    public Vector<EntreeLexical> getEntrerLexicals() {
        return entrerLexicals;
    }

    public void setEntrerLexicals(Vector<EntreeLexical> entrerLexicals) {
        this.entrerLexicals = entrerLexicals;
    }

    public String getValeurRacine() {
        return valeurRacine;
    }

    public void setValeurRacine(String valeurRacine) {
        this.valeurRacine = valeurRacine;
    }

    @Override
    public String toString() {
        return "RacineFam{" + "entrerLexicals=" + entrerLexicals + ", valeurRacine=" + valeurRacine + '}';
    }
    
}
