package com.jackgraham.customNN;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadLogicFile {

	
	ArrayList<String> newFile = new ArrayList<String>();
	
	public ReadLogicFile()
	{
		
	}
	
	public void readFileIn()
	{
		FileInputStream fis = null;
        BufferedReader reader = null;
      
        try {
            fis = new FileInputStream("/Users/jackgraham/Dropbox/Honours Project/Prolog/murder.pl");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            String line = reader.readLine();
            while(line != null){
            	if(line.trim().length() != 0)
            	{
            		newFile.add(line);
            		System.out.println(line);
            	}
                line = reader.readLine();
            }           
            reader.close();
            fis.close();
          
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
          
        }
	
}
}
