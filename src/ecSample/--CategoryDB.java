package nkym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDB {
	public ArrayList<SearchBean> getProductDb(String SearchWord,String Category) {

		String url = "jdbc:mysql://localhost/lesson20xx";//urlの中の最後のデータベース名
		String id1 = "root";
		String pw = "password";
		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<SearchBean> prolis = new ArrayList<>();	// serachリスト

		/*ArrayList<String> productList = new ArrayList<String>();
		ArrayList<Integer> priceList = new ArrayList<Integer>();
		ArrayList<Integer> stockList = new ArrayList<Integer>();
		ArrayList<String> detailList = new ArrayList<String>();
		*/
			try {
				Class.forName("com.mysql.jdbc.Driver");

				cnct = DriverManager.getConnection(url,id1,pw);
				st = cnct.createStatement();


				String sql = ("SELECT product.pro_name,product.pro_price,product.stock_no,product.pro_msg "
						+ "from product inner join category on product.cat_id = category.cat_id "
						+ "WHERE product.pro_name LIKE '%" + SearchWord + "%' "
						+ "and category.cat_name = '" + Category + "'");
				rs = st.executeQuery(sql);
				while(rs.next()) {
					/*	productList.add(rs.getString("pro_name"));
						priceList.add(rs.getInt("pro_price"));
						stockList.add(rs.getInt("stock_no"));
						detailList.add(rs.getString("pro_msg"));
					*/
					if(SearchWord.length() != 0) {
						SearchBean SB = new SearchBean();
						SB.setName(rs.getString("pro_name"));
						SB.setPrice(rs.getInt("pro_price"));
						SB.setStock(rs.getInt("stock_no"));
						SB.setDetail(rs.getString("pro_msg"));

						prolis.add(SB);
					}
				}


			} catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			} catch(SQLException ex) {
				ex.printStackTrace();

			}

			return prolis;
	}

}
