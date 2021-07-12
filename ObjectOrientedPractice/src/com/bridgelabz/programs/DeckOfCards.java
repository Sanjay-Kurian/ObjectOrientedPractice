package com.bridgelabz.programs;

import java.io.File;

import com.bridgelabz.utility.Utility;

public class DeckOfCards {
	public static void main(String[] args) {
		System.out.println("4 players are playing cards");
		Utility utility = new Utility();
		File file = new File("E:\\bridgelabzJSONFiles\\DeckOfCards.json");
		utility.assignCards(file);
	}
}