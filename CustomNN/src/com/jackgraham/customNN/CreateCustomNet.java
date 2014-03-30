package com.jackgraham.customNN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateCustomNet {

	Network net = new Network();

	String expectedInput = "";
	String expectedOutput = "";
	boolean connecting = true;

	public CreateCustomNet() {

	}

	public Network getUserInput() throws IOException {

		System.out.println("Welcome to Jack's Custom Net Builder");
		
		System.out.println("What would you like to call your net?: ");

		Scanner scanIn = new Scanner(System.in);
		net.setNetName(scanIn.nextLine());
		
		//Get inputs
		System.out.println("How many input elements do you want to use?: ");

		net.setInputAmount(Integer.parseInt(scanIn.nextLine()));
		//Get outputs
		System.out.println("How many output elements do you want to use?: ");

		net.setOutputSize(Integer.parseInt(scanIn.nextLine()));
		//Get layers
		System.out.println("How many neurons do you want to use?: ");

		net.setLayerAmount(Integer.parseInt(scanIn.nextLine()));

		
		// Get expected input and output
		for (int x = 1; x < net.getInputAmount() + 1; x++) {
			System.out.println("Please enter the lower range of input " + x);
			expectedInput += scanIn.nextLine();
			expectedInput += " ";

			System.out.println("Please enter the upper range of input " + x);
			expectedInput += scanIn.nextLine();
			if (x != net.getInputAmount()) {

				expectedInput += ";";
			}
		}

		net.setExpectedInput(expectedInput);
		System.out.println(expectedInput);

		for (int x = 1; x < net.getOutputSize() + 1; x++) {
			System.out.println("Please enter the lower range of output " + x);
			expectedOutput += scanIn.nextLine();
			expectedOutput += " ";

			System.out.println("Please enter the upper range of output " + x);
			expectedOutput += scanIn.nextLine();
			if (x != net.getOutputSize()) {

				expectedOutput += ";";
			}
		}

		net.setExpectedOutput(expectedOutput);
		System.out.println(expectedOutput);

		// Connect layers
		System.out.println("Setting Connections...");

		ArrayList<int[]> connections = new ArrayList<int[]>();

		for (int x = 1; x < net.getLayerAmount() + 1; x++) {
			int input = 0;
			System.out.println("Setting connections for layer " + x);
			
			do {
				System.out.println("Please enter which input element is to be connected to layer" +x + ": ");
				int inputToNet[] = new int[2];
				inputToNet[0] = x;
				inputToNet[1] = Integer.parseInt(scanIn.nextLine());
				connections.add(inputToNet);
				input++;

				System.out
						.println("Do you want to add another connection? Y or N");
				String newConnection = scanIn.nextLine();
				if (newConnection.contains("Y")) {
					connecting = true;
				} else {
					connecting = false;
				}

			} while (input > net.getInputAmount() || connecting != false);
			connecting = true;
		}

		net.setConnections(connections);
		
		
		// Set output links
		System.out.println("Setting output connections...");
		
		net.setOutputSize(net.getLayerAmount());
		return net;
		
	}

}
