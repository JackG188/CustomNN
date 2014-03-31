package com.jackgraham.customNN;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFile {

	ArrayList<int[]> connections = new ArrayList<int[]>();
	ArrayList<String> weights = new ArrayList<String>();
	String weightArray = "";
	
	public CreateFile() {

	}

	public void writeTofile(Network net) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/jackgraham/Documents/MatLab/test2.m"));
			out.write("net = network;");
			out.newLine();
			out.write("net.numInputs=(" + net.getInputAmount() +");");
			out.newLine();
			out.write("net.numLayers=(" + net.getLayerAmount() +");");
			out.newLine();
			for (int x =1;x<net.getInputAmount()+1;x++)
			{
				out.write("net.inputs{"+x+"}.size = 1;");
				out.newLine();
			}
			for (int x =1;x<net.getLayerAmount()+1;x++)
			{
				out.write("net.layers{"+x+"}.size = 1;");
				out.newLine();
			}
			connections = net.getConnections();
			
			for (int x =0;x<connections.size();x++)
			{
				int[] temp = connections.get(x);
				out.write("net.inputConnect("+temp[0]+","+temp[1]+") = 1;");
				out.newLine();
			}
			
			for (int x=1;x<net.getOutputSize()+1;x++)
			{
				out.write("net.outputConnect("+x+") = 1;");
				out.newLine();
			}
			
			weights = net.getWeights();
			
			for (int x =0;x<weights.size();x++)
			{
				String temp = weights.get(x);
			//[0.5,0.5,0.5,0.5,0.5,0.5]
				
				weightArray += (""+temp);
				if (x!=weights.size())
				{
					weightArray+=",";
				}
			}
			
			out.write("net = setwb(net,["+weightArray+"]);");
			out.newLine();
			out.write("view(net)");
			out.newLine();
			
			
			
			out.close();
		} catch (IOException e) {
			System.out.println("Exception ");
		}
	}

}
