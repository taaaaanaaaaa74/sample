package nkym;

import java.io.Serializable;

public class CartBean implements Serializable {
	private String name = null;
	private int price = 0;
	private int num = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


}
