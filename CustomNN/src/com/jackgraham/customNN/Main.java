package com.jackgraham.customNN;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		Network net = new Network();
		CreateCustomNet customNet = new CreateCustomNet();
		
		net = customNet.getUserInput();
		CreateFile create = new CreateFile();
		create.writeTofile(net);
	}
}
