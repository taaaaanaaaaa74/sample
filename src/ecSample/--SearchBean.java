package nkym;

import java.io.Serializable;

public class SearchBean implements Serializable {
	private String name = null;
	private Integer price = null;
	private Integer stock = null;
	private String detail = null;
	/*---------
	 * メソッド名:getName()
	 * 戻り値:String
	 * 引数:なし
	 * 内容:name の値を返す
	 ----------*/
	public String getName() {
		return name;
	}/*---------
	 * メソッド名:setName()
	 * 戻り値:なし
	 * 引数:Stirng name
	 * 内容:this.name に引数の値を代入
	 ----------*/
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
