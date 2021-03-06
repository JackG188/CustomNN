package com.jackgraham.customNN;

import java.util.ArrayList;

public class Network {

	String netName = "";
	
	int inputAmount = 0;
	int layerAmount = 0;

	int outputSize = 0;

	String expectedInput = "";
	String expectedOutput = "";

	static int layerSize = 1;
	static int inputSize = 1;

	ArrayList<int[]> connections = new ArrayList<int[]>();
	ArrayList<String> weights = new ArrayList<String>();

	public Network() {

	}
	
	public void setConnections(ArrayList<int[]> connections)
	{
		this.connections=connections;
	}

	public ArrayList<int[]> getConnections() {
		return connections;
	}

	public int getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(int inputAmount) {
		this.inputAmount = inputAmount;
	}

	public int getLayerAmount() {
		return layerAmount;
	}

	public void setLayerAmount(int layerAmount) {
		this.layerAmount = layerAmount;
	}

	public int getOutputSize() {
		return outputSize;
	}

	public void setOutputSize(int outputSize) {
		this.outputSize = outputSize;
	}

	public String getExpectedInput() {
		return expectedInput;
	}

	public void setExpectedInput(String expectedInput) {
		this.expectedInput = expectedInput;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	public static int getLayerSize() {
		return layerSize;
	}

	public static void setLayerSize(int layerSize) {
		Network.layerSize = layerSize;
	}

	public static int getInputSize() {
		return inputSize;
	}

	public static void setInputSize(int inputSize) {
		Network.inputSize = inputSize;
	}

	public String getNetName() {
		return netName;
	}

	public void setNetName(String netName) {
		this.netName = netName;
	}

	public ArrayList<String> getWeights() {
		return weights;
	}

	public void setWeights(ArrayList<String> weights) {
		this.weights = weights;
	}

}
