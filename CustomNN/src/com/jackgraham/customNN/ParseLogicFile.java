package com.jackgraham.customNN;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLogicFile {

	int count;
	int procedureLine;
	int endOfNeuronInput;
	String currentLine;
	ArrayList<Integer> neuronLocation = new ArrayList<Integer>();
	ArrayList<String> inputList = new ArrayList<String>();

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
					 neuronLocation.add(x);
				 }
		 }
		 System.out.println("Found " +count+" neuron(s)");
		 
		 for (int x=0;x<neuronLocation.size();x++)
		 {
			 findInput(neuronLocation.get(x),file);
		 }
		 
	}
	
	public void findInput(int neuronLine,ArrayList<String> file)
	{
		
		 for(int x=neuronLine+1;x<file.size();x++)
		 {
			 	currentLine = file.get(x);
				Pattern pattern = Pattern.compile(".");
				Matcher matcher = pattern.matcher(currentLine);

				 while (matcher.find())
				 {
					 endOfNeuronInput=x;
				 }
		 }
		 System.out.println("Found fullstop at " +endOfNeuronInput);
		 
		 for(int x=neuronLine+1;x<endOfNeuronInput+1;x++)
		 {
			 currentLine = file.get(x);
			 String [] inputSplit = currentLine.split("\\(");
			 System.out.println(inputSplit[0]);
			 inputList.add(inputSplit[0]);
		 }
		 
	}

}
