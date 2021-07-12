package com.bridgelabz.programs;

import java.io.File;

import com.bridgelabz.utility.Utility;

public class InventoryManager {
	public static void main(String[] args) {
		System.out.println("Welcome to Inventory manager");
		Utility utility = new Utility();
		File file = new File("E:\\bridgelabzJSONFiles\\InventoryManager.json");
		utility.inputInventory(file);	
		utility.getInventory(file);
	}
}