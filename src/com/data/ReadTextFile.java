/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.util.regex.*;

/**
 *
 * @author MuStapha
 */
public class ReadTextFile {
    
    private Document doc;
    private Document doc1;
    private Document doc2;
    private Document doc3;
    private Document doc4;
    
    private Element racine;
    private Element racine1;
    private Element racine2;
    private Element racine3;
    private Element racine4;
    
    private String fileName;
    private String fileNameError;
    
    private Rubrique rubrique;
    private Vector<Rubrique> rubriques;
    
    private Chapitre chapitre;
    private Vector<Chapitre> chapitres;
    
    private RacineFam racineFam;
    private Vector<RacineFam> racineFams;
    private Vector<RacineFam> rcfs;
        
    private EntreeLexical entreeLexical;
    private Vector<EntreeLexical> entreeLexicals;
    
    Vector<EntreeLexical> file;

    public ReadTextFile() {
        rubriques  = new Vector<Rubrique>();
        rubrique   = new Rubrique(chapitres);
        chapitres  = new Vector<Chapitre>();
        chapitre   = new Chapitre(racineFams);
        racineFams = new Vector<RacineFam>();
        racineFam  = new RacineFam(entreeLexicals);
        entreeLexicals=new Vector<EntreeLexical>();
        entreeLexical = new EntreeLexical();
    }
    
    
    //////////////////////////////// lecture fichier source //////////////////////////////////////////////
//    public void readText(String filePath ){
//            System.out.println("file path : "+filePath);
//            
//            try {
//                BufferedReader buffer;
//                buffer = new BufferedReader(new FileReader(filePath));
//                try {
//                    String line;
//                    while ((line=buffer.readLine())!=null) {
////                            if((line.startsWith("*1*باب"))){
//                            while((line.startsWith("*1*باب"))){
//                                
//                                String alphabet = line;
//                                alphabet=line.substring(line.lastIndexOf("باب")+4, line.length());
//                                
//                                //----------------- create list rubrique --------------
//                                rubrique.setAlphabet(alphabet);
//                                //racineFams = new Vector<RacineFam>();
//                                System.out.println();
//                                System.out.println("Rubrique : "+alphabet);
//                                chapitres = new Vector<Chapitre>();
//                                
//                                line=buffer.readLine();
//                                //----------------- create list chpt --------------
//                                Chapitre chapitre = new Chapitre();
//                                Vector<RacineFam> racineFs = new Vector<RacineFam>();
//                                    while( (line.startsWith("*2*فَصْلُ")) ) {
//                                        //racineFams = new Vector<RacineFam>();
//                                        racineFs = new Vector<RacineFam>();
//                                        String valeur = line.substring(line.lastIndexOf("فَصْلُ")+7, line.length());
////                                        Chapitre chapitre = new Chapitre();
//                                        chapitre.setValeur(valeur);
//                                        System.out.println("Nom chapitre : "+ chapitre.getValeur());
//                                        
//                                        RacineFam racinef = new RacineFam();
//                                        line=buffer.readLine();
//
//                                        //if((line.startsWith("@"))){
//                                        //Vector<EntreeLexical> entreeLexicals = new Vector<EntreeLexical>();
//                                        while ((line.startsWith("@"))){
//                                            //entreeLexicals = new Vector<EntreeLexical>();
//                                            Vector<EntreeLexical> entreeLexicals = new Vector<EntreeLexical>();
//                                            
//                                            String textBrut=line.replace("@", "");
//                                            EntreeLexical entreeLex = new EntreeLexical();
//                                            entreeLex.setTexteBrut(textBrut);
//                                            
//                                            entreeLexicals.add(entreeLex);
//                                           // racinef.setEntrerLexicals(entreeLexicals);
//                                            
//                                         //   System.out.println(" nbre EnterLex "+ entreeLexicals.size());
//                                         //   System.out.println(entreeLexicals);
//                                            line=buffer.readLine();
//                                            while((line.startsWith("$")) ){
//                                                textBrut=line.replace("$", "");
//                                                entreeLex = new EntreeLexical();
//                                                entreeLex.setTexteBrut(textBrut);
//
//                                                entreeLexicals.add(entreeLex);
//                                               // System.out.println(" nbre EnterLex "+ entreeLexicals.size());
//                                                //System.out.println(entreeLexicals);
//                                              //  racinef.setEntrerLexicals(entreeLexicals);
//                                               
//                                               // System.out.println(" Racine Familly "+racinef);
//                                                line=buffer.readLine();
//                                            }
//                                            racinef.setEntrerLexicals(entreeLexicals);
//                                            racineFs.add(racinef);
//                                          //  racineFams.add(racinef);
//                                            System.out.println("Vect RFs "+racineFams );
//                                        }
//                                        
//                                        if(line.startsWith("*EOF*")) 
//                                            break;
//                                            //line=buffer.readLine();
////                                        if((line=buffer.readLine()) == null) 
////                                            break;
//                                    }
//                                    
////                                chapitre.setRacineFams(racineFams);
//                                chapitre.setRacineFams(racineFs);
//                                chapitres.add(chapitre);
//                                System.out.println(" nbre chapts "+ chapitres.size());
//                                System.out.println(" nbr Racine Familly "+ racineFs.size());
//                            }
//                                    
//                        rubrique.setChapitres(chapitres);
//                        System.out.println(" nbre chpt "+rubrique.getChapitres().size());
//                    } 
//                    
//                } catch (Exception e) {
//                        System.out.println(e.getMessage()+" not null ");
//                        e.printStackTrace();
//                }
//                finally{
//                            buffer.close();
//                }
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e.getMessage()+"message d'erreur!!!!", "Error", 
//                   JOptionPane.ERROR_MESSAGE);
//            }
//    }
    
    
    
    public void readTxt(String filePath ){
            try {
                BufferedReader buffer;
                buffer = new BufferedReader(new FileReader(filePath));
                try {
                    String line, c2root, lemmeRoot;
                    String [] split;
                    String [] splitLemme;
                    String [] lem = null;
                    
                    while ((line=buffer.readLine())!= null) {
//                        System.out.println(" Debut... "+line.charAt(0));
                        if(line.startsWith("*EOF*")) 
                                  break;
                        while((line.startsWith("*1*"))){
//                            System.out.println(" Debut while..." + line);
                            rubrique=new Rubrique();
                            chapitres = new Vector<Chapitre>();
                            String alphabet = line;
                            alphabet=line.substring(line.lastIndexOf("باب")+4, line.length());
                                
                            //----------------- create list rubrique --------------
                            rubrique.setAlphabet(alphabet);
                            System.out.println();
                            System.out.println("Rubrique : "+rubrique.getAlphabet());
                            line=buffer.readLine();
                                
                            //----------------- create list chpt --------------
                            while( (line.startsWith("*2*فَصْلُ")) ) {
                                chapitre = new Chapitre();
                                racineFams = new Vector<RacineFam>();
                                String valeur = line.substring(line.lastIndexOf("فَصْلُ")+7, line.length());
                                chapitre.setValeur(valeur);
                                System.out.println("Nom chapitre : "+ chapitre.getValeur());
                                        
                                line=buffer.readLine();
                                
                                while ((line.startsWith("@")) || (line.startsWith("$")) ){
                                    while (line.startsWith("@")){
                                        RacineFam racinef = new RacineFam();
                                        entreeLexicals = new Vector<EntreeLexical>();
                                        String textBrut=line.replace("@", "");
                                        System.out.println(" textBrut"+ textBrut);
                                        EntreeLexical entreeLex = new EntreeLexical();
                                        entreeLex.setTexteBrut(textBrut);
                                        String lemme = extractLemma(textBrut);
                                        TransAlphabetRacine tr = new TransAlphabetRacine();
                                        String C3=tr.transcrire_inv(rubrique.getAlphabet());
                                        String C1 = tr.transcrire_inv(chapitre.getValeur());
                                        
                                        if ( (lemme.contains(C3)) && (lemme.contains(C1))){
                                            entreeLex.setLemme(lemme);
                                        }else{
                                            if(textBrut.contains(":")){
                                                split = textBrut.split(":");
                                                if (split[0].contains("،")){
                                                    splitLemme = split[0].split("،");
                                                    entreeLex.setLemme(splitLemme[0]);
                                                }else{    
                                                    entreeLex.setLemme(split[0]);
                                                }
                                            }
                                        }
                                        if( textBrut.contains(":")){
                                            entreeLex.setDefinition(new Definition(textBrut.substring(textBrut.indexOf(":")+1, textBrut.length())));
                                        }
                                        
                                        if (chapitre.getValeur().equals("الهَمْزة")){//C1 == Hamza
//                                            System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot1 " + lemme);
                                            if ( !(lemme.contains("ّ")) && (lemme.contains(C3)) ){//ne contient pas shedda && 
//                                              System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot" + lemmeRoot);
                                                c2root = lemme.substring(lemme.lastIndexOf(C3)-2, lemme.lastIndexOf(C3)-1);
                                                //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                            }else{
                                                if ( (lemme.contains("ّ")) && (lemme.contains(C3)) ){// contient shedda 
                                                    c2root = lemme.substring(lemme.lastIndexOf(C1), lemme.lastIndexOf(C3));
                                                    c2root= removeDiacritic(c2root);
                                                    System.out.println("c2root11111111111111111111111111111111 "+c2root);
                                                    System.out.println("c2root "+c2root.length());
                                                    if(c2root.length()<4){
                                                        c2root = extractC2Root(lemme, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }  
                                            }                                                  
                                        }else{ //C1 != Hamza
                                            if ( !(lemme.contains("ّ")) && (lemme.contains(C1)) && (lemme.contains(C3)) ){//ne contient pas shedda
                                                //c2root = extractracine(lemme, C1, C3);
                                                String root = extractracine(lemme, C1, C3);
                                                entreeLex.setRacine(root);
                                                //entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                //racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                racinef.setValeurRacine(root);
                                            }
                                            else{
                                                if ( (lemme.contains("ّ")) && (lemme.contains(C3)) && (lemme.contains(C3)) ){// contient shedda &&
                                                    c2root = lemme.substring(lemme.indexOf(C1)+1, lemme.lastIndexOf(C3));
                                                    c2root= removeDiacritic(c2root);
                                                    System.out.println("c2root11111111111111111111111111111111 "+c2root);
                                                    System.out.println("c2root "+c2root.length());
                                                    if(c2root.length()<2){
                                                        c2root = extractC2Root(lemme, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }  
                                            }    
                                        }
                                        
                                        
                                    /*    
                                        if(textBrut.contains(":")){ //enter contains :
                                            split = textBrut.split(":");
                                            if (split[0].contains("،")){ // avant : (lemme) contient ،
                                                splitLemme = split[0].split("،");
//                                                entreeLex.setLemme(splitLemme[0]);
                                                ////// split Lemme to 1 word
                                                if(splitLemme[0].contains(" ")){ //entre lemme et ، existe espace
                                                    lem = splitLemme[0].split(" ");
                                                    lemmeRoot = lem[0];
                                                }else{
                                                    lemmeRoot = splitLemme[0];
                                                }
                                                
                                                if (chapitre.getValeur().equals("الهَمْزة")){//C1 == Hamza
//                                                    System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot1 " + lemmeRoot);
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda && 
//                                                        System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot" + lemmeRoot);
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }else if( (lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C3)) ){
                                                    
                                                    }
                                                    
                                                }else{ //C1 != Hamza
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C1)) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }
                                            }else if (split[0].contains(" ")){ // avant : (lemme) contient espace
                                                splitLemme = split[0].split(" ");
//                                                entreeLex.setLemme(splitLemme[0]);
                                                    lemmeRoot = splitLemme[0];
                                                if (chapitre.getValeur().equals("الهَمْزة")){//C1 == Hamza
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda && 
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }else{ //C1 != Hamza
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C1)) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }
                                            }
                                            else{    
//                                                entreeLex.setLemme(split[0]); //lemme un seul mot
                                            }
                                            entreeLex.setDefinition(new Definition(textBrut.substring(textBrut.indexOf(":")+1, textBrut.length())));
                                        }else{// ligne ne contient pas ":"
                                            if(textBrut.contains("،")){
                                                split = textBrut.split("،");
//                                                entreeLex.setLemme(split[0]);
                                                lemmeRoot = split[0];
                                                if (chapitre.getValeur().equals("الهَمْزة")){//C1 == Hamza
//                                                    System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot1 " + lemmeRoot);
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda && 
//                                                        System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot" + lemmeRoot);
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }else{ //C1 != Hamza
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C1)) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }
                                                
                                            }else if(textBrut.contains(".")){
                                                split = textBrut.split("\\.");
                                                lemmeRoot = split[0];
                                                System.out.println(" split[0] " + split[0]);
//                                                entreeLex.setLemme(lemmeRoot);
                                                if (chapitre.getValeur().equals("الهَمْزة")){//C1 == Hamza
//                                                    System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot1 " + lemmeRoot);
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda && 
//                                                        System.out.println("lemmeRooooooooooooooooooooooooooooooooooooooooooot" + lemmeRoot);
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }else{ //C1 != Hamza
                                                    if ( !(lemmeRoot.contains("ّ")) && (lemmeRoot.contains(C1)) && (lemmeRoot.contains(C3)) ){//ne contient pas shedda
                                                        c2root = lemmeRoot.substring(lemmeRoot.lastIndexOf(C3)-2, lemmeRoot.lastIndexOf(C3)-1);
                                                        //c2root = extractRoot(lemmeRoot, tr.transcrire_inv(chapitre.getValeur()), tr.transcrire_inv(rubrique.getAlphabet()));
                                                        entreeLex.setRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                        racinef.setValeurRacine(tr.transcrire_inv(chapitre.getValeur())+" "+c2root+" "+tr.transcrire_inv(rubrique.getAlphabet()));
                                                    }
                                                }
                                                
                                            }
                                        }*/

                                        entreeLexicals.add(entreeLex);
                                        line=buffer.readLine();
                                        while ((line.startsWith("$")) ){
                                            textBrut=line.replace("$", "");
                                            entreeLex = new EntreeLexical();
                                            entreeLex.setTexteBrut(textBrut);
                                            lemme = extractLemma(textBrut);
                                            entreeLex.setLemme(lemme);
                                            if ( (lemme.contains(C3)) && (lemme.contains(C1))){
                                                entreeLex.setLemme(lemme);
                                            }else{
                                                if(textBrut.contains(":")){
                                                    split = textBrut.split(":");
                                                    if (split[0].contains("،")){
                                                        splitLemme = split[0].split("،");
                                                        entreeLex.setLemme(splitLemme[0]);
                                                    }else{    
                                                        entreeLex.setLemme(split[0]);
                                                    }
                                                }
                                            }
                                            if(textBrut.contains(":")){
//                                                split = textBrut.split(":");
//                                                if (split[0].contains("،")){
//                                                    splitLemme = split[0].split("،");
//                                                    entreeLex.setLemme(splitLemme[0]);
//                                                }else{    
//                                                    entreeLex.setLemme(split[0]);
//                                                }
                                                entreeLex.setDefinition(new Definition(textBrut.substring(textBrut.indexOf(":")+1, textBrut.length())));
                                            }
                                            entreeLex.setRacine(racinef.getValeurRacine());
                                            entreeLexicals.add(entreeLex);
                                          //System.out.println(entreeLexicals);
                                         // System.out.println(" Racine Familly "+racinef);
                                            line=buffer.readLine();
                                        }
                                        racinef.setEntrerLexicals(entreeLexicals);
                                        racineFams.add(racinef);
//                                        System.out.println("Vect RFs "+racineFams );
                                    }    
                                }
                                        
                                chapitre.setRacineFams(racineFams);
                                chapitres.add(chapitre);
                                System.out.println(" nbre chapts "+ chapitres.size());
                                System.out.println(" nbr Racine Familly "+ racineFams.size());
                            }
                            rubrique.setChapitres(chapitres);
                        }
                        //System.out.println(" Rub "+rubrique);
                    } 
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage()+" not null ");
                    e.printStackTrace();
                }
                finally{
                    buffer.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage()+"message d'erreur!!!!", "Error", 
                   JOptionPane.ERROR_MESSAGE);
            }
    }
    
        //////////////////////////-- Generation XML --////////////////////////////////////////////
    
    public void xmlFormat(String nameFile){
        try {  
            racine = new Element("Document");
            doc =new Document();
            doc.setRootElement(racine);
    //-----------------------\\ create Rubrique //---------------------\\
            
            Element rubriq=new Element("Rubrique");
            //for (int k = 0; k < rubriques.size(); k++){ 
                rubriq=new Element("rubrique");
                rubriq.setAttribute("value", rubrique.getAlphabet());
//            }
//            racine.addContent(rubriq);

      //-----------------------\\ create Chapitre //---------------------\\  
            Element chapitr = new Element("Chapitre");
            //System.out.println("chapitres.size() = "+chapitres.size());
            for (int j = 0; j < chapitres.size(); j++){ 
                chapitr=new Element("chapitre");
                //addEnter(chapitres.get(i).getEntreeLexicals().elementAt(i));
                System.out.println("chapitre: "+chapitres.get(j).getValeur());
                //System.out.println(chapitres.get(j).getEntreeLexicals().size());
                chapitr.setAttribute("value", chapitres.get(j).getValeur());
                //----------- create Entree-Lexical -------------
                            
                Element racineFam=new Element("Racine_Familly");
                Element enter=new Element("Entrée_lexical");
                for (int x = 0; x < chapitres.get(j).getRacineFams().size(); x++) {
                    System.out.println(" RacineFams.size() " + chapitres.get(j).getRacineFams().size());
                    racineFam = new Element("Racine_Familly");
                    if (chapitres.get(j).getRacineFams().get(x).getValeurRacine() == null){
                        racineFam.setAttribute("C1",chapitres.get(j).getValeur()).setAttribute("C2","R2").setAttribute("C3",rubrique.getAlphabet());
                    }else{
                         
                        String C1,C2,C3;
                        String [] root;
                        TransAlphabetRacine tr = new TransAlphabetRacine();
                        root = chapitres.get(j).getRacineFams().get(x).getValeurRacine().split(" ");
                        C1 = tr.transcrire(root[0]); 
                        C2 = tr.transcrire(root[1]);
                        C3 = tr.transcrire(root[2]);
                        System.out.println("C1 "+C1 +"   C2 "+C2 + "    C3 "+C3 );
                        System.out.println("C1 "+root[0] +"   C2 "+root[1] + "    C3 "+root[2] );
                        racineFam.setAttribute("C1",C1).setAttribute("C2",C2).setAttribute("C3",C3);
                    }
                    for (int i = 0; i < chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().size(); i++) {
                       //System.out.println("  EntrerLexicals().size() "+chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().size());
                        enter=new Element("Entrée_lexical");
                        Element txtBrut=new Element("text-brut");
                        System.out.println(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getTexteBrut());
                        txtBrut.setText(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getTexteBrut());
                        enter.addContent(txtBrut);

                    Element lemme=new Element("lemme");
                    if(!(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getLemme() == null)){  
                        lemme.setText(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getLemme());
                        enter.addContent(lemme);
                    }
                    
//                    Element glosse=new Element("Définition");
                    if(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getDefinition() !=null){
                        Vector<String> defs = new Vector<>();
                        if(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getDefinition().getSens().contains("،")){
                            defs = extractDef(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getDefinition().getSens());
                            for (int p = 0; p < defs.size(); p++) {
                                if (defs.get(p).contains("ج.")){
                                    String plr = defs.get(p).replace("ج.", "");
                                    Element pluriel=new Element("Pluriel");
                                    pluriel.setText(plr);
                                    enter.addContent(pluriel);
                                }else{
                                    Element glosse=new Element("Définition"+(p+1));
                                    glosse.setText(defs.get(p));
                                    enter.addContent(glosse);
                                }
                            }
                        }else{
                            Element glosse=new Element("Définition");
                            glosse.setText(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getDefinition().getSens());
                            enter.addContent(glosse);
                        }
                       // enter.addContent(glosse);
                    }
                    
                        Element racine=new Element("racine");
                        
                        if(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getRacine() != null){
                            racine.setText(chapitres.get(j).getRacineFams().get(x).getEntrerLexicals().get(i).getRacine());
                        }else {
                            TransAlphabetRacine tar = new TransAlphabetRacine();
                            racine.setText(tar.transcrire_inv(chapitres.get(j).getValeur())+" "+"c2" +" "+tar.transcrire_inv(rubrique.getAlphabet()));
                        }
                        enter.addContent(racine);

                        racineFam.addContent(enter);
                    }
                    chapitr.addContent(racineFam);
                }

                rubriq.addContent(chapitr);
                //racine.addContent(chapitr);
            }
        //}
        racine.addContent(rubriq);

        } catch (Exception e) {
            System.out.println("Erreur : "+e.getMessage());
            e.printStackTrace();
        }

        try {
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(doc, new FileOutputStream("src/com/dbAlphabet/fichier.xml"));
        }
        catch (java.io.IOException e){}
    }
    
    //////////////////--- Defs Extract  ---//////////////////////////
    public Vector<String> extractDef(String def){
        Vector<String> defs = new Vector<>();
        String [] spl = def.split("،");;
        for (int i = 0; i < spl.length; i++) {
            defs.add(spl[i]);
        }
        return defs;
    }
    
     //////////////////--- Racine Extract  ---//////////////////////////
    public String extractC2Root(String lemme, String C1, String C3){
        String C2=null;
        C2 = lemme.substring(lemme.lastIndexOf("ّ")-1, lemme.lastIndexOf("ّ"));
        return C2;
    }
    
    public String removeDiacritic(String mot){
        String [] voyelles = {"َ","ِ","ُ","ْ","ً","ٍ","ٌ","ِّ","ُّ","َّ","ًّ","ٌّ","ٍّ","ّ"};
        for (int i = 0; i < voyelles.length; i++) {
            if ( mot.contains(voyelles[i]) ){
                mot = mot.replace(voyelles[i], ""); //enlever voyelles
                System.out.println(" mot sans voyelles "+ mot);
            }
        }
        return mot;
    }
    
    public String  extractracine(String lemme,String C1, String C3){
        String racine = null, lemma = null;
        String C2 = "";
        String [] lettreSolaire = {"ت","ث","د","ذ","ر","ز","س","ش","ص","ض","ط","ظ","ل","ن"};
        String [] voyelles = {"َ","ِ","ُ","ْ","ً","ٍ","ٌ","ِّ","ُّ","َّ","ًّ","ٌّ","ٍّ","ّ"};
        
        //if(lemme.startsWith("ال")){
//            System.out.println(" ---> " + lemme);
            for (int i = 0; i < voyelles.length; i++) {
                if ( lemme.contains(voyelles[i]) ){
                    lemma = lemme.replace(voyelles[i], ""); //enlever voyelles
                    lemme =lemma;
//                    System.out.println(" Lemma ss voyelles "+ lemma);
                }
            }
            lemma = lemma.substring(lemma.indexOf(C1)+1, lemma.lastIndexOf(C3));
            C2 = lemma+" ";
//            System.out.println(" C2 "+ lemma);
            if(lemma.length()>1){
                C2="";
                for (int i = 0; i < lemma.length(); i++) {
//                    System.out.println(lemma.charAt(i));
                    
                    C2 = C2.concat(lemma.charAt(i)+" ");
//                    System.out.println(" c2 = "+C2);
                }
            }
            racine = C1  +" "+ C2 + "" + C3;
//            System.out.println(" racine.length() "+racine.length());
            if (racine.length()>5  && racine.contains("ا")){
                racine = racine.replace(" ا", "");
            }
            if (racine.length()<6  && racine.contains("ا")){
                racine = racine.replace("ا", "و/ي");
            }
            
            return racine;
        //}
        //return null;
    }
    
    
    
    public String  extractLemma(String textBrut){
        String lemma = null ,lemme = null;
        String [] lettreSolaire = {"ت","ث","د","ذ","ر","ز","س","ش","ص","ض","ط","ظ","ل","ن"};
        String [] split, splitLemme,lem; 
        
        if(textBrut.contains(":")){ //enter contains :
            split = textBrut.split(":");
            if (split[0].contains("،")){ // avant : (lemme) contient ،
                splitLemme = split[0].split("،");
                lemme = splitLemme[0];
                ////// split Lemme to 1 word
                if(splitLemme[0].contains(" ")){ //entre lemme et ، existe espace
                    lem = splitLemme[0].split(" ");
                    lemme = lem[0];
                }else{                          // pas d'espace entre lemme et ، 
                    lemme = splitLemme[0];
                }
            }else if (split[0].contains(" ")){ // avant : (lemme) contient espace
                splitLemme = split[0].split(" ");
                lemme = splitLemme[0];
            }
            else{    
                lemme = split[0]; //lemme un seul mot
            }
        }else{// ligne ne contient pas ":"
            if(textBrut.contains("،")){
                split = textBrut.split("،");
                if(split[0].contains(" ")){ //entre lemme et ، existe espace
                    lem = split[0].split(" ");
                    lemme = lem[0];
                }else{                          // pas d'espace entre lemme et ، 
                    lemme = split[0];
                }
            }else if(textBrut.contains(".")){
                split = textBrut.split("\\.");
                //lemme = split[0];
                if(split[0].contains(" ")){ //entre lemme et ، existe espace
                    lem = split[0].split(" ");
                    lemme = lem[0];
                }else{                          // pas d'espace entre lemme et ، 
                    lemme = split[0];
                }
                //System.out.println(" split[0] " + split[0]);
            }else if(textBrut.contains(" ")){
                split = textBrut.split(" ");
                lemme = split[0];
            }
            
        }
//        System.out.println(" lemme " + lemme);
        if( (lemme.startsWith("ال")) && (lemme.charAt(3)=='ّ') ){ //if lemme commence avec "AL"
//            System.out.println(" ---> " + lemme);
            lemma = lemme.substring(lemme.indexOf("ال")+2, lemme.length()-1);
            for(int i = 0; i < lettreSolaire.length; i++) {
                if (lemma.startsWith(lettreSolaire[i]) && (lemma.contains("ّ"))){
                    lemma = lemma.replaceFirst("ّ", ""); //enlever Shadda
//                    System.out.println(" Lemma Shadda "+ lemma);
                }
            }
            return lemma;
        }
        return lemme;
    }
}