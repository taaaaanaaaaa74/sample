package nkym;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartDao{
	public ArrayList<CartBean> main(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("num"));	// name="num" の取得

		String name = null;
		// listに登録された cart の数だけ先頭からループ
		for(SearchBean cart: SearchSurvlet.sbl) {
			// name="入力された値" がcartリストに登録されている時
			if(req.getParameter(cart.getName()) != null) {
				// name に cart.getName()メソッドの値を代入
				name = cart.getName();
			}
		}

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost/lesson20xx";//urlの中の最後のデータベース名
		String id1 = "root";
		String pw = "password";

		ArrayList<CartBean> cartList = new ArrayList<>();

		try {
			// JDBCドライバの登録
			Class.forName("com.mysql.jdbc.Driver");
			// MySQLへ接続
			conn = DriverManager.getConnection(url,id1,pw);
			st = conn.createStatement();
			// SQL文の発行
			String sql = "SELECT * from product where pro_name = '"+ name + "'";
			rs = st.executeQuery(sql);

			// rs.next()の値が存在する間ループ
			// rs.next():tableのカーソルを現在の位置から1行下に移動
			while(rs.next()) {
				// cartクラスのインスタンス化
				CartBean cart = new CartBean();
				// cart に値をsetterメソッドで格納
				// rs.setString():ワイルドカード(?)に変数をString型で設定
				// rs.getString():column の値をString型で取得
				cart.setName(rs.getString("pro_name"));
				// rs.setInt():ワイルドカード(?)に変数をint型で設定
				// rs.getInt():column の値をint型で取得
				cart.setPrice(rs.getInt("pro_price"));
				// num が DBに登録された stock_no より多い時
				if(num > rs.getInt("stock_no")) num = rs.getInt("stock_no");
				cart.setNum(num);

				boolean useBean = false;
				for(int i = 0; i < cartList.size(); i++) {
					// cartリストの name がDB pro_name に存在する時
					if(cartList.get(i).getName().equals(cart.getName())) {
						// cartリストの値を更新
						cartList.set(i, cart);
						useBean = true;
					}
				}
				if(!useBean) cartList.add(cart);
			}
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				// 解放処理
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (conn != null) conn.close();
			} catch(Exception ex) { }
		}

		return cartList;
	}
}
