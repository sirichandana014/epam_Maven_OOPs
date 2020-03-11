package com.epam.OOP;
import java.util.*;

public class GiftAnalysis {
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Chocolate>chocolates=new ArrayList<Chocolate>();
	static ArrayList<Chocolate>candies=new ArrayList<Chocolate>();
	static ArrayList<Sweet>sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer>nameToWeight=new HashMap<String,Integer>();
	static HashMap<String,Integer>nameToPrice=new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		inputChocolates();
		
		inputSweets();
		
		System.out.println("Total weight of gift is : "+calcTotalWeight());
		
		System.out.println("Choose the way to sort(enter the number):1. By Price 2. By Weight");
		int sortType=sc.nextInt();
		if(sortType==1) {
			Comparator<Chocolate> compareByPrice = (Chocolate c1,Chocolate c2) -> ((Integer)c1.getPrice()).compareTo(c2.getPrice());
			Collections.sort(chocolates,compareByPrice);
		}
		else {
			Comparator<Chocolate> compareByWeight = (Chocolate c1,Chocolate c2) -> ((Integer)c1.getWeight()).compareTo(c2.getWeight());
			Collections.sort(chocolates,compareByWeight);
		}
		System.out.println("The sorted result:");
		for(Chocolate chocolate:chocolates) {
			System.out.println(chocolate.getPrice());
		}
		calcRange(sortType);
	}

	@SuppressWarnings("rawtypes")
	public static void calcRange(int sortType) {
		System.out.println("Let's find the range:");
		int lowerLimit,higherLimit;
		if(sortType==1) {
			System.out.println("Enter the lower limit of the price: ");
			lowerLimit=sc.nextInt();
			System.out.println("Enter the higher limit of the price: ");
			higherLimit=sc.nextInt();
			
			Set<Map.Entry<String,Integer>> candySet=nameToPrice.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentPrice=(int)candyElement.getValue();
				if(currentPrice>=lowerLimit && currentPrice<=higherLimit)
					System.out.println(candyElement.getKey());
			}
		}
		else {
			System.out.println("Enter the lower limit of the price: ");
			lowerLimit=sc.nextInt();
			System.out.println("Enter the higher limit of the price: ");
			higherLimit=sc.nextInt();
			
			Set<Map.Entry<String,Integer>> candySet=nameToWeight.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator = candySet.iterator();
			while(candyIterator.hasNext()) {
				Map.Entry candyElement = (Map.Entry)candyIterator.next();
				int currentWeight=(int)candyElement.getValue();
				if(currentWeight>=lowerLimit && currentWeight<=higherLimit)
					System.out.println(candyElement.getKey());
			}
		}
	}

	public static int calcTotalWeight() {
		int totalWeight=0;
		for(Chocolate choco:chocolates) {
			totalWeight+=choco.getWeight();
		}
		for(Sweet swee:sweets) {
			totalWeight+=swee.getWeight();
		}
		return totalWeight;
	}

	public static void inputSweets() {
		System.out.println("Enter the number of sweets in gifts: ");
		int numberOfSweets=sc.nextInt();
		for(int sweetCount=1;sweetCount<=numberOfSweets;sweetCount++) {
			System.out.println("Enter the name of the sweet: ");
			String sweetName=sc.next();
			System.out.println("Enter the weight of the sweet:");
			int sweetWeight=sc.nextInt();
			System.out.println("Enter the price of the sweet:");
			int sweetPrice=sc.nextInt();
			Sweet sweet=new Sweet(sweetName,sweetWeight,sweetPrice);
			sweets.add(sweet);
		}
	}

	public static void inputChocolates() {
		
		System.out.println("Enter the number of chocolates in gifts:\n");
		int numberOfChocolates=sc.nextInt();
		for(int chocoCount=1;chocoCount<=numberOfChocolates;chocoCount++) {
			System.out.println("enter chocolate type(Enter the number): 1.Candy 2. Wafer");
			int chocolateType=sc.nextInt();
			String candyName=null;
			
			System.out.println("Enter the weight of the chocolate:");
			int chocoWeight=sc.nextInt();
			System.out.println("Enter the price of the chocolate:");
			int chocoPrice=sc.nextInt();
			if(chocolateType==1) {
				System.out.println("Enter the name of the candy: ");
				
				candyName=sc.next();
				if(nameToWeight.containsKey(candyName)) {
					nameToWeight.put(candyName,(int)nameToWeight.get(candyName)+chocoWeight);
				}
				else {
					nameToWeight.put(candyName, chocoWeight);
				}
				
				if(nameToPrice.containsKey(candyName)) {
					nameToPrice.put(candyName,(int)nameToPrice.get(candyName)+chocoPrice);
				}
				else {
					nameToPrice.put(candyName,chocoPrice);
				}
			}
			
			Chocolate choco=new Chocolate(candyName,chocoWeight,chocoPrice);
			chocolates.add(choco);
			if(chocolateType==1)
				candies.add(choco);
		}
	}

}
