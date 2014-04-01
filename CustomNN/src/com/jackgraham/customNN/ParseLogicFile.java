package com.jackgraham.customNN;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLogicFile {

	int count;
	int procedureLine;
	String currentLine;

	public ParseLogicFile() {

	}

	public void parseFile(ArrayList<String> file) {
		
		for (int x = 0; x < file.size(); x++) {
			currentLine = file.get(x);
			Pattern pattern = Pattern.compile("Procedure");
			Matcher matcher = pattern.matcher(currentLine);

			 while (matcher.find())
			 {
			 procedureLine = x;
			 }

		}
		 System.out.println("Found procedure at line " +procedureLine);
		 if (procedureLine>0)
		 {
			 findNeurons(file);
		 }
		 else{
			 System.out.println("No procedure found. Please review your prolog file");
		 }

	}
	
	public void findNeurons(ArrayList<String> file)
	{
		count = 0;
		 for(int x=procedureLine;x<file.size();x++)
		 {
			 	currentLine = file.get(x);
				Pattern pattern = Pattern.compile(":-");
				Matcher matcher = pattern.matcher(currentLine);

				 while (matcher.find())
				 {
					 count++;
				 }
		 }
		 System.out.println("Found " +count+" neuron(s)");
		 findInput(file);
	}
	
	public void findInput(ArrayList<String> file)
	{
		count = 0;
		 for(int x=procedureLine;x<file.size();x++)
		 {
			 	currentLine = file.get(x);
				Pattern pattern = Pattern.compile("),");
				Pattern pattern2 = Pattern.compile(").");
				Matcher matcher = pattern.matcher(currentLine);
				Matcher matcher2 = pattern2.matcher(currentLine);
				
				 while (matcher.find() && matcher2.find()!=true)
				 {
					 count++;
				 }
				 if (matcher2.find()==true)
				 {
					 count++;
				 }
		 }
		 System.out.println("Found " +count+" input(s)");
	}

}
