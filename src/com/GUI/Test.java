/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.data.ReadTextFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MuStapha
 */
public class Test {
    
public Test() throws IOException {
        ex02();
    }

    public static void main(String []args ) throws IOException{
       new Test();
    }
    
    private void ex01() {
        ReadTextFile rtf=new ReadTextFile();
        rtf.readTxt("src/com/dbAlphabet/test-bAe.txt");
        System.out.println("Fin du chargement du Fichier...");
    } 
    
    private void ex02() {
        ReadTextFile rtf=new ReadTextFile();
        
//        rtf.readTxt("src/com/dbAlphabet/newBAe.txt");
        rtf.readTxt("src/com/dbAlphabet/BAe_corrigé_19_11_waw_removed.txt");
        System.out.println("Fin du chargement du Fichier...");
//        rtf.xmlFormat("src/com/dbAlphabet/test-bAe.txt");
        rtf.xmlFormat("src/com/dbAlphabet/BAe_corrigé_19_11_waw_removed.txt");
        System.out.println("Fin d'écriture du fichier XML ");
    }
    
    private void ex03() {
        ExtractError ext = new ExtractError();
        ext.extractligneErreur("src/com/dbAlphabet/BAe_corrige_waw_removed.txt");
        System.out.println("Fin d'écriture du fichier XML ");
    }
    
    private void ex04() {
        String str, chaine_arabe ="يُوبَبُ بباءَيْنِ موحَّدَتَيْنِ، كمَهْدَدٍ وجُنْدَبٍ: والِدُ شُعيبٍ النبيِّ، صلى الله عليه وسلم. ويُوبٌ، بالضم: جَدٌّ لمحمدِ بنِ عَبْدِ اللهِ بنِ عِياضٍ المُحَدِّثِ.";
        String [] ligne;
        str =chaine_arabe.substring(chaine_arabe.indexOf(":")+1, chaine_arabe.length());
        System.out.println(str);
    }
    
    private void ex05() {
        RemoveWawError rwaw = new RemoveWawError();
        rwaw.removeWaw("src/com/dbAlphabet/BAe_corrigé.txt");
        System.out.println("Fin d'écriture du fichier XML ");
    }
    
    private void ex06() {
        
        String lemme = "الأبُّ";
        String C3="ب";
        String C1="ث";
        String  root;
        ReadTextFile rtf=new ReadTextFile();
        System.out.println(" root");
        root = rtf.extractC2Root(lemme, C1, C3);
        System.out.println(" c2 " + root);
    }
    
    private void ex07() {
        String chaine_arabe ="[ء-يًًٌٌٍٍََُُِِّّّّّّّْآ؟!،لآ \\.•]*";
        String ligne =" وأ ب.";
            Pattern p1=Pattern.compile(""+chaine_arabe+"",Pattern.UNICODE_CASE);
            Matcher m1 = p1.matcher(ligne);
            System.out.println(m1);
            if(m1.matches()){
                System.out.println("  vrai  ");
            }
    }
    
    private void ex08(){
        String lemme = "أَنَّبَهُ";
        String racine;
        ReadTextFile rtf=new ReadTextFile();
        System.out.println(" lemme " + lemme);
        racine = rtf.extractracine(lemme, "أ", "ب");
        System.out.println(" racine = " + racine);
    }
    private void ex09(){
        String ligne = "رَغِبَ فيه، كَسَمِعَ، رَغْباً، ويُضَمُّ،";
        String lemma;
        ReadTextFile rtf=new ReadTextFile();
        //System.out.println(" lemme " + ligne);
        lemma = rtf.extractLemma(ligne);
        System.out.println(" Lemma  " + lemma);
    }
    
}
