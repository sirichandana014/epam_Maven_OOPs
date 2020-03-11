package com.epam.OOP;

public class Chocolate {

	/*
	public Chocolate(int chocoWeight, int chocoPrice) {
		// TODO Auto-generated constructor stub
	}

	public Integer getPrice() {
		// TODO Auto-generated method stub
		return this.getPrice();
	}

	public Integer getWeight() {
		// TODO Auto-generated method stub
		return this.getWeight();
	}*/


    
	 private String name;
	    private int price;
	    private int weight;

	    public Chocolate(String name,int price,int weight){
	        this.name=name;
	        this.price=price;
	        this.weight=weight;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public int getWeight() {
	        return weight;
	    }

	    
	    public int compareTo(Chocolate o) {
	        if(o.price > price)
	            return 1;
	        if(o.price < price)
	            return -1;
	        else
	            return 0;
	    }

	    @Override
	    public String toString() {
	        return "Chocolate{" +
	                "name='" + name + '\'' +
	                ", price=" + price +
	                ", weight=" + weight +
	                '}';
	    }



}
