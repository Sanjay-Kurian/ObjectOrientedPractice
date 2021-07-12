package com.bridgelabz.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utility {
	
	Scanner scanner;
	
	public Utility(){
		scanner = new Scanner(System.in);
	}
	
	public int getIntValue() {
		return scanner.nextInt();
	}
	
	public String getStringValue() {
		return scanner.next();
	}
	
	public long getLongValue() {
		return scanner.nextLong();
	}
	/*-----------------------Rice,Wheat and pulse problem Q1 and Q2-----------------------------*/
	public void getInventory(File file) {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader fileReader = new FileReader(file);
			try {
				Object obj = jsonParser.parse(fileReader);
				JSONObject jsonObject = (JSONObject) obj;
				System.out.println("The list is " +jsonObject);
				JSONArray jsonArray = (JSONArray) jsonObject.get("listOfItem");
				System.out.println(jsonArray);
				long amount;
				long totalAmount = 0;
				for(Object element:jsonArray) {
					JSONObject jsonObject1 = (JSONObject) element;
					long price = (long) jsonObject1.get("price");
					long weight = (long) jsonObject1.get("weight");
					amount = price * weight;
					System.out.println("The price of " +jsonObject1.get("name") +" is " +amount);
					totalAmount = totalAmount + amount;
				}
				System.out.println("The total amount for all the items is " +totalAmount);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void inputInventory(File file) {
		System.out.println("Enter the price of rice");
		int pRice = getIntValue();
		System.out.println("Enter the quantity of rice");
		int qRice = getIntValue();
		System.out.println("Enter the price of wheat");
		int pWheat = getIntValue();
		System.out.println("Enter the quantity of wheat");
		int qWheat = getIntValue();
		System.out.println("Enter the price of pulses");
		int pPulses = getIntValue();
		System.out.println("Enter the quantity of pulses");
		int qPulses = getIntValue();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "rice");
		jsonObject.put("price", pRice);
		jsonObject.put("weight", qRice);
		
		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("name", "wheat");
		jsonObject1.put("price", pWheat);
		jsonObject1.put("weight", qWheat);
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("name", "pulses");
		jsonObject2.put("price", pPulses);
		jsonObject2.put("weight", qPulses);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject1);
		jsonArray.add(jsonObject2);
		
		JSONObject jsonMain = new JSONObject();
		jsonMain.put("listOfItem", jsonArray);
		System.out.println(jsonMain);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(jsonMain.toJSONString());
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Written in the file");		
	}
	
	/*---------------------------------Stock Account Management--------------------------------*/
	JSONArray jsonStock = new JSONArray();
	@SuppressWarnings("unchecked")
	public void inputStock(File file) {
		System.out.println("Enter stock name");
		String stockName = getStringValue();
		System.out.println("Enter number of shares");
		int shareNumber = getIntValue();
		System.out.println("Enter price of each share");
		int sharePrice = getIntValue();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Stock Name", stockName);
		jsonObject.put("Shares", shareNumber);
		jsonObject.put("Share Price", sharePrice);
		
		jsonStock.add(jsonObject);
		
		JSONObject jsonMain = new JSONObject();
		jsonMain.put("stocks", jsonStock);
		System.out.println(jsonMain);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(jsonMain.toJSONString());
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void calcStock(File file) {
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader fileReader = new FileReader(file);
			try {
				Object obj = jsonParser.parse(fileReader);
				JSONObject jsonMain = (JSONObject) obj;
				JSONArray jsonArray = (JSONArray) jsonMain.get("stocks");
				long amount;
				long totalAmount = 0;
				for(Object element : jsonArray) {
					JSONObject jsonObject = (JSONObject) element;
					long sharePrice = (long) jsonObject.get("Share Price");
					long shareNumber = (long) jsonObject.get("Shares");
					amount = sharePrice * shareNumber;
					System.out.println("The value of " +jsonObject.get("Stock Name") +" is " +amount);
					totalAmount = totalAmount + amount;
				}
				System.out.println("The total value of all the stocks is " +totalAmount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*--------------------------------------Deck of Cards----------------------------------------*/
	
	@SuppressWarnings("unchecked")
	public void assignCards(File file) {
		String[][] cards = new String[4][9];
		String[] suits = {"Clubs","Diamonds","Hearts","Spades"};
		String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		HashSet <String> draw = new HashSet<String>();
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 9;j++) {
				int count = 1;
				while(count == 1) {
					int rank = (int) ((Math.random()*10) % 13);
					int suit = (int) ((Math.random()*10) % 4);
					String s = ranks[rank] + "of" + suits[suit];
					if(draw.contains(s)) {
						count = 1;
					}
					else {
						cards[i][j] = s;
						draw.add(s);
						count = 0;
					}
				}
			}
		}
		for (int i = 0;i < 4;i++) {
			for (int j = 0;j < 9;j++) {
				System.out.print(cards[i][j] +" ");
			}
			System.out.println();
		}
		JSONArray jsonArray1 = new JSONArray();
		for (int i = 0;i < 9;i++) {
			jsonArray1.add(cards[0][i]);
		}
		
		JSONArray jsonArray2 = new JSONArray();
		for (int i = 0;i < 9;i++) {
			jsonArray2.add(cards[1][i]);
		}
		
		JSONArray jsonArray3 = new JSONArray();
		for (int i = 0;i < 9;i++) {
			jsonArray3.add(cards[2][i]);
		}
		
		JSONArray jsonArray4 = new JSONArray();
		for (int i = 0;i < 9;i++) {
			jsonArray4.add(cards[3][i]);
		}
		
		JSONObject jsonMain = new JSONObject();
		jsonMain.put("Player1", jsonArray1);
		jsonMain.put("Player2", jsonArray2);
		jsonMain.put("Player3", jsonArray3);
		jsonMain.put("Player4", jsonArray4);
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(jsonMain.toJSONString());
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
