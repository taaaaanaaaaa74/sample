package nkym;

import java.io.Serializable;
public class ItemBean implements Serializable {
	private String name = null;
	private String category = null;
	private int price = 0;
	private int stock = 0;
	private String msg = null;
	private String img = null;

	/*---------
	 * メソッド名:getImg()
	 * 戻り値:String
	 * 引数:なし
	 * 内容:img の値を返す
	 ----------*/
	public String getImg() {
		return img;
	}

	/*---------
	 * メソッド名:setImg()
	 * 戻り値:なし
	 * 引数:Stirng img
	 * 内容:this.img に引数の値を代入
	 ----------*/
	public void setImg(String img) {
		this.img = img;
	}

	/*---------
	 * メソッド名:getName()
	 * 戻り値:String
	 * 引数:なし
	 * 内容:name の値を返す
	 ----------*/
	public String getName() {
		return name;
	}

	/*---------
	 * メソッド名:setName()
	 * 戻り値:なし
	 * 引数:Stirng name
	 * 内容:this.name に引数の値を代入
	 ----------*/
	public void setName(String name) {
		this.name = name;
	}

	/*---------
	 * メソッド名:getCategory()
	 * 戻り値:String
	 * 引数:なし
	 * 内容:category の値を返す
	 ----------*/
	public String getCategory() {
		return category;
	}

	/*---------
	 * メソッド名:setCategory()
	 * 戻り値:なし
	 * 引数:Stirng category
	 * 内容:this.category に引数の値を代入
	 ----------*/
	public void setCategory(String category) {
		this.category = category;
	}

	/*---------
	 * メソッド名:getPrice()
	 * 戻り値:int
	 * 引数:なし
	 * 内容:price の値を返す
	 ----------*/
	public int getPrice() {
		return price;
	}

	/*---------
	 * メソッド名:setPrice()
	 * 戻り値:なし
	 * 引数:int price
	 * 内容:this.price に引数の値を代入
	 ----------*/
	public void setPrice(int price) {
		this.price = price;
	}

	/*---------
	 * メソッド名:getStock()
	 * 戻り値:int
	 * 引数:なし
	 * 内容:stock の値を返す
	 ----------*/
	public int getStock() {
		return stock;
	}

	/*---------
	 * メソッド名:setStock()
	 * 戻り値:なし
	 * 引数:int stock
	 * 内容:this.stock に引数の値を代入
	 ----------*/
	public void setStock(int stock) {
		this.stock = stock;
	}

	/*---------
	 * メソッド名:getMsg()
	 * 戻り値:String
	 * 引数:なし
	 * 内容:msg の値を返す
	 ----------*/
	public String getMsg() {
		return msg;
	}

	/*---------
	 * メソッド名:setMsg()
	 * 戻り値:なし
	 * 引数:String msg
	 * 内容:this.msg に引数の値を代入
	 ----------*/
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
