package com.epam.OOP;

public class Sweet {

	/*public Sweet(int sweetWeight, int sweetPrice) {
		// TODO Auto-generated constructor stub
	}

	public Integer getPrice() {
		// TODO Auto-generated method stub
		return this.getPrice();
	}

	public Integer getWeight() {
		// TODO Auto-generated method stub
		return this.getWeight();
	}
	*/
	private String name;
    private int price;
    private int weight;

    public Sweet(String name,int price,int weight){
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

	//@Override
	public int compareTo(Sweet o) {
		if(o.price > price)
            return 1;
        if(o.price < price)
            return -1;
        else
            return 0;
	}
	
	 @Override
	    public String toString() {
	        return "Sweets{" +
	                "name='" + name + '\'' +
	                ", price=" + price +
	                ", weight=" + weight +
	                '}';
	    }

}
