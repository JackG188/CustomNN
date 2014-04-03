package com.jackgraham.customNN;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Network net = new Network();
		CreateCustomNet customNet = new CreateCustomNet();
		ReadLogicFile fileReader = new ReadLogicFile();
		ParseLogicFile fileParser = new ParseLogicFile();
		
		net = fileParser.parseFile(fileReader.readFileIn());
		net.setNetName(customNet.setName(net));
		net.setWeights(customNet.setWeights(net));
		net.setExpectedInput(customNet.setExpectedInput(net));
		net.setExpectedOutput(customNet.setExpectedOutput(net));
	//	net = customNet.getUserInput();
		CreateFile create = new CreateFile();
		create.writeTofile(net);
	}
}
