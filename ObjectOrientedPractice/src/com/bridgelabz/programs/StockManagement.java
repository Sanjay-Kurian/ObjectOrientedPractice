package com.bridgelabz.programs;

import java.io.File;

import com.bridgelabz.utility.Utility;

public class StockManagement {
	public static void main(String[] args) {
		File file = new File("E:\\bridgelabzJSONFiles\\StockManagement.json");
		System.out.println("Enter number of stocks");
		Utility utility = new Utility();
		int number = utility.getIntValue();
		for(int i=0;i<number;i++) {
			utility.inputStock(file);
		}
		utility.calcStock(file);
	}
}
