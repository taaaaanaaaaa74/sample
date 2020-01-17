package nkym;

import java.io.Serializable;
import java.util.ArrayList;

public class Logic implements Serializable {
	private int tax = 0;
	private int sum = 0;
	public int getTax() {
		return tax;
	}
	public void setTax(ArrayList<CartBean> list){
		int sum = 0;
		for(CartBean cart:list)
			sum +=cart.getPrice()*cart.getNum();
		this.tax =(int)(sum * 0.08);
	}
	public int getSum() {
		return sum;
	}
	public void setSum(ArrayList<CartBean> list) {

		for(CartBean cart:list)
			sum +=cart.getPrice()*cart.getNum();
		this.sum =(int)(sum * 1.08);

	}
}