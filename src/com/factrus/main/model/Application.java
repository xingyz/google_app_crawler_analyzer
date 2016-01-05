package com.factrus.main.model;

/**
 * Application model
 * All strings for displaying convenience
 * 
 * @author nicolas.husser
 */
public class Application {		
	
	private String name,
				   developer, 
				   iconURL,
				   rating,
				   price,
				   downloads;
	
	private String starFive,
				   starFour,
				   starThree,
				   starTwo,
				   starOne;
	
	
	public Application() {
		this.name = "";
		this.developer = "";
		this.iconURL = "";
		this.rating = "";
		this.price = "";
		this.downloads = "";
		this.starFive = "";
		this.starFour = "";
		this.starThree = "";
		this.starTwo = "";
		this.starOne = "";
	}

	
	public Application(String name, String developer, String iconURL,
			String rating, String price, String downloads, String starFive,
			String starFour, String starThree, String starTwo, String starOne) {
		super();
		this.name = name;
		this.developer = developer;
		if(iconURL.substring(0,2).equals("//"))
			iconURL = "http:"+iconURL;
		this.iconURL = iconURL;
		this.rating = rating;
		this.price = price;
		this.downloads = downloads;
		this.starFive = starFive;
		this.starFour = starFour;
		this.starThree = starThree;
		this.starTwo = starTwo;
		this.starOne = starOne;
		//System.out.println(this.iconURL);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDownloads() {
		return downloads;
	}
	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}
	public String getStarFive() {
		return starFive;
	}
	public void setStarFive(String starFive) {
		this.starFive = starFive;
	}
	public String getStarFour() {
		return starFour;
	}
	public void setStarFour(String starFour) {
		this.starFour = starFour;
	}
	public String getStarThree() {
		return starThree;
	}
	public void setStarThree(String starThree) {
		this.starThree = starThree;
	}
	public String getStarTwo() {
		return starTwo;
	}
	public void setStarTwo(String starTwo) {
		this.starTwo = starTwo;
	}
	public String getStarOne() {
		return starOne;
	}
	public void setStarOne(String starOne) {
		this.starOne = starOne;
	}

	@Override
	public String toString() {
		return name;
	}

}
