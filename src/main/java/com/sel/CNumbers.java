/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author itexps
 */
public class CNumbers {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        BufferedReader fr=new BufferedReader(new FileReader(new File("c:\\data\\ln.csv")));
        BufferedWriter fw=new BufferedWriter(new FileWriter(new File("c:\\data\\lno.csv")));
        String line;
        fr.readLine();
        while((line=fr.readLine())!=null){
            String[] tokens=line.split(",");
            String[] st=tokens[1].split(" ");
            String wline=tokens[0]+",";
            for(String t:st){
                wline=wline+t+",";
            }
            fw.write(wline);
            fw.newLine();
        }
        fr.close();
        fw.close();
        
        
    }
    
}
