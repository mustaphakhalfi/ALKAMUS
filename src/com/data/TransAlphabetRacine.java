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
public class TransAlphabetRacine {
    
    private static String transcription[][]={{"أ"   , "ب"   ,"ت"    ,"ث"    ,"ج"    ,"ح"    ,"خ"    ,"د"    ,"ذ"    ,"ر"    ,"ز"    ,"س"    ,"ش"    ,"ص"    ,"ض"    ,"ط"    ,"ظ"    ,"ع"    ,"غ"    ,"ف"    ,"ق"    ,"ك"   ,"ل"    ,"م"    ,"ن"    ,"و"    ,"ه"    ,"ي"},
                                           {"الهَمْزة","البَاء","التَّاء","الثَّاء","الجيْم","الِحَاء","الخَاء","الدّال","الذّال","الرّاء","الزّاي","السِّيْن","الشِّيْن","الصَّاد","الضَّاد","الطّاء","الظّاء","العَيْن","الغَيْن","الفَاء","القَاف","الكاف","اللاّم","الميمْ","النُّون","الواو","الهاء","اليَاء"}};

    public TransAlphabetRacine() {
    }

    public String transcrire(String c){
        String c2="R2";
        for (int i = 0; i < transcription[0].length; i++) {
            if(transcription[0][i].contentEquals(c)){
                 return transcription[1][i];
            }
        }
        return c2;
    }
    
    public String transcrire_inv(String c){
        for (int i = 0; i < transcription[1].length; i++) {
            if(transcription[1][i].contentEquals(c))
                return transcription[0][i];
        }
        return null;
    }
    
//    public static void main(String []args){
//        
//        System.out.println((transcription[1]).toString());
//        
//        System.out.println(transcrire("أ"));
//        System.out.println(transcrire_inv("الهَمْزة"));
//        System.out.println(transcrire("ج"));
//        System.out.println(transcrire_inv("اليَاء"));
//    }
    
}
