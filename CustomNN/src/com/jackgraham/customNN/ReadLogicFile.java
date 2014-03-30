package com.jackgraham.customNN;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLogicFile {

	public ReadLogicFile()
	{
		
	}
	
	public void ReadFileIn()
	{
		FileInputStream fis = null;
        BufferedReader reader = null;
      
        try {
            fis = new FileInputStream("C:/sample.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
          
            System.out.println("Reading File line by line using BufferedReader");
          
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
            }           
          
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {

	}
        }
	
}
}
