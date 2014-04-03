package com.jackgraham.customNN;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLogicFile {

	int neuronCount;
	int procedureLine;
	int endOfNeuronInput;
	String currentLine;
	ArrayList<Integer> neuronLocation = new ArrayList<Integer>();
	ArrayList<String> inputList = new ArrayList<String>();
	ArrayList<ParsedNet> neuronInputList = new ArrayList<ParsedNet>();
	Network net = new Network();

	public ParseLogicFile() {

	}

	public Network parseFile(ArrayList<String> file) {

		for (int x = 0; x < file.size(); x++) {
			currentLine = file.get(x);
			Pattern pattern = Pattern.compile("Procedure");
			Matcher matcher = pattern.matcher(currentLine);

			while (matcher.find()) {
				procedureLine = x;
			}

		}
		System.out.println("Found procedure at line " + procedureLine);
		if (procedureLine > 0) {
			findNeurons(file);
		} else {
			System.out
					.println("No procedure found. Please review your prolog file");
		}
		return net;
	}

	public void findNeurons(ArrayList<String> file) {
		neuronCount = 0;
		for (int x = procedureLine; x < file.size(); x++) {
			currentLine = file.get(x);
			Pattern pattern = Pattern.compile(":-");
			Matcher matcher = pattern.matcher(currentLine);

			while (matcher.find()) {
				neuronCount++;
				neuronLocation.add(x);
			}
		}
		System.out.println("Found " + neuronCount + " neuron(s)");

		for (int x = 0; x < neuronLocation.size(); x++) {
			neuronInputList.add(findInput(neuronLocation.get(x), file));
		}
		buildNetObject(neuronInputList);
	}

	public ParsedNet findInput(int neuronLine, ArrayList<String> file) {
		ParsedNet parsedNet = new ParsedNet();
		ArrayList<Integer> neuronInputs = new ArrayList<Integer>();
		boolean foundFullStop = false;
		int loopForFullStop = neuronLine;

		do {
			currentLine = file.get(loopForFullStop);
			Pattern pattern = Pattern.compile("\\.");
			Matcher matcher = pattern.matcher(currentLine);

			while (matcher.find()) {
				endOfNeuronInput = loopForFullStop;
				foundFullStop = true;
			}
			loopForFullStop++;
		} while (foundFullStop == false);
		System.out.println("Found fullstop at " + endOfNeuronInput);

		for (int x = neuronLine + 1; x < endOfNeuronInput + 1; x++) {
			currentLine = file.get(x);
			String[] inputSplit = currentLine.split("\\(");
			System.out.println(inputSplit[0]);
			if (inputList.contains(inputSplit[0]) == false) {
				inputList.add(inputSplit[0]);
				neuronInputs.add(inputList.size());
			} else {
				neuronInputs.add(inputList.indexOf(inputSplit[0]) + 1);

			}

		}
		parsedNet.setInputs(neuronInputs);
		return parsedNet;
	}

	public void buildNetObject(ArrayList<ParsedNet> neurons) {

		ArrayList<int[]> connections = new ArrayList<int[]>();
		net.setInputAmount(inputList.size());
		net.setLayerAmount(neuronCount);
		net.setOutputSize(neuronCount);

		for (int x = 0; x < neuronCount; x++) {
			ArrayList<Integer> inputs = neurons.get(x).getInputs();

			for (int y = 0; y < inputs.size(); y++) {
				int[] inputToNet = new int[2];
				inputToNet[0] = x + 1;
				inputToNet[1] = inputs.get(y);
				connections.add(inputToNet);
			}

		}
		net.setConnections(connections);
	}

}
