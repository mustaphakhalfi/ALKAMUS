/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

import com.data.Chapitre;
import com.data.EntreeLexical;
import com.data.RacineFam;
import com.data.Rubrique;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author MuStapha
 */
public class ExtractError {
    
    
    
    public void extractligneErreur(String filePath ){
        int i=0, numLigne=1;
            try {
                BufferedReader buffer;
                buffer = new BufferedReader(new FileReader(filePath));
                try {
                    
                     try {
                          BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/com/dbAlphabet/fichier_erreur1.txt")));
                        String line;
                        while ((line=buffer.readLine())!=null) {
                            while((line.startsWith("*1*باب")) || (line.startsWith("*2*")) || (line.startsWith("@")) || (line.startsWith("$"))  ){
                                //System.out.println();
                                
                                //i++;
                                numLigne++;    
                                line=buffer.readLine();
                            }
                            if(line.startsWith("*EOF*")) 
                                break;
                            String error = null;
                            String number = "";
                            number = number.valueOf(numLigne++);
                            error= number.concat("\t\t\t"+ line);
                            writer.write(error );
                            writer.newLine();
                            System.out.println(error);

                        }
                        writer.close();
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
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage()+"message d'erreur!!!!", "Error", 
                   JOptionPane.ERROR_MESSAGE);
            }
    }
    
}
