/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author MuStapha
 */
public class RemoveWawError {

    public RemoveWawError() {
    }
    
    public void removeWaw(String filePath ){
        
        try {
                BufferedReader buffer;
                buffer = new BufferedReader(new FileReader(filePath));
//                BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/com/dbAlphabet/fichier_waw_removed.txt")));
                BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/com/dbAlphabet/BAe_corrigé_waw_removed.txt")));
                
                try {
                     try {
                        String line;
                        while ((line=buffer.readLine())!=null) {
//                            while((line.startsWith("*1*")) || (line.startsWith("*2*")) || (line.startsWith("@")) ){
                                if(line.startsWith("*EOF*")){
                                    bw.write(line);
                                    bw.newLine();
                                    break;
                                }
                                while((line.startsWith("$و")) ){
                                    bw.write(line.replace("$و", "$"));
                                    bw.newLine();
                                    System.out.println(line.replace("$و", "$"));
                                    line=buffer.readLine();
                                }
                                bw.write(line);
                                bw.newLine();
                                System.out.println(line);
                            }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                        System.out.println(e.getMessage()+" not null ");
                        e.printStackTrace();
                }
                finally{
                        buffer.close();
                        bw.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage()+"message d'erreur!!!!", "Error", 
                   JOptionPane.ERROR_MESSAGE);
            }
    
    }
    
}
