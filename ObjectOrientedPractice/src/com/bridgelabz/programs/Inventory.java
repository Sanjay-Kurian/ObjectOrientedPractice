package com.bridgelabz.programs;

import java.io.File;

import com.bridgelabz.utility.Utility;

public class Inventory {
	public static void main(String[] args) {
		System.out.println("Welcome to Inventory management system");
		Utility utility = new Utility();
		File file = new File("E:\\bridgelabzJSONFiles\\itemList.json");
		utility.getInventory(file);
	}
}
