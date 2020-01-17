package nkym;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckServlet extends HttpServlet {
	private final String url = "jdbc:mysql://localhost/lesson20xx";//urlの中の最後のデータベース名
	private final String id1 = "root";
	private final String pw = "";

	/*---------
	 * メソッド名:doPost()オーバーライド
	 * 戻り値:なし
	 * 引数:HttpServletRequest req, HttpServletResponse resp
	 * 内容:画面遷移を行う
	 ----------*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 文字コードの設定
		req.setCharacterEncoding("UTF-8");

		// submitされたボタンの value 取得
		String CHECK = req.getParameter("check");	// name="check" 取得
        String URL = null;

        // 受け取った value の値に応じて遷移先の url の設定
        switch(CHECK) {
		case "はい":
	        URL = "Thanks.jsp";
	        main(req, resp);	// mainメソッド呼び出し
	        CartServlet.list.clear();	// CartServletクラスのcartリストの初期化
	        break;

		case "いいえ":
			URL = "Search.jsp";
			break;
	    }

        // 画面遷移処理
		RequestDispatcher rd = req.getRequestDispatcher(URL);
		rd.forward(req, resp);
	}

	/*---------
	 * メソッド名:main()
	 * 戻り値:なし
	 * 引数:HttpServletRequest req, HttpServletResponse resp
	 * 内容:確認処理
	 ----------*/
	protected void main(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement st = null;
		ResultSet rs = null;

		try {
				// JDBCドライバの登録
				Class.forName("com.mysql.jdbc.Driver");
				// MySQLへ接続
				conn = DriverManager.getConnection(url, id1, pw);
				// SQL文の発行
				String updateSql = "UPDATE product SET stock_no = ? WHERE pro_name = ?";
				st = conn.createStatement();
				pstmt = conn.prepareStatement(updateSql);

				ArrayList<Integer> stock = new ArrayList<>();

				for(int i = 0; i < CartServlet.list.size(); i++) {
					// SQL文の発行
					String selectSql = "SELECT stock_no FROM product WHERE pro_name = '"+ CartServlet.list.get(i).getName() + "'";
					rs = st.executeQuery(selectSql);
					// rs.next()の値が存在する間ループ
					// rs.next():tableのカーソルを現在の位置から1行下に移動
					// rs.getInt():column の値をint型で取得
					while(rs.next()) stock.add(rs.getInt("stock_no"));
						// rs.setInt():ワイルドカード(?)に変数をint型で設定
						pstmt.setInt(1, (stock.get(i) - CartServlet.list.get(i).getNum()));
						// rs.setString():ワイルドカード(?)に変数をString型で設定
						pstmt.setString(2, CartServlet.list.get(i).getName());
						// 更新した内容を適用させる
						pstmt.executeUpdate();
				}
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				// 解放処理
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception ex) { }
		}
	}
}