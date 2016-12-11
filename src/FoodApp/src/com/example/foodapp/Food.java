package com.example.foodapp;


public class Food {
	private String name;
	private int imageId;
	private String money;
	//private float scores;
	//private RatingBar bar;
	
	public Food(String name, int ImageId) {
		this.name = name;
		this.imageId = ImageId;
	}
	
	public Food(String name, int ImageId, String money) {
		this.name = name;
		this.imageId = ImageId;
		this.money = money;
		//this.scores = scores;
		//this.bar = bar;
	}
	
	public String getName() {
		return name;
	}
	public int getImageId() {
		return imageId;
	}
	public String getMoney() {
		return money;
	}
/*	public RatingBar getBar() {
		return bar;
	}*/
	
}
