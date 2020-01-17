package nkym;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	public static ArrayList<CartBean> list = new ArrayList<>();	// cartリスト
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 文字コードの設定
				req.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");

				// submitされたボタンの value 取得
				String jump = "";
				// name="jump" が null でない時 value 取得
				if(req.getParameter("jump") != null) jump = req.getParameter("jump");

				String url = null;

				// 受け取った value の値に応じて遷移先の url の設定
				switch(jump) {
				case "買い物を続ける":
					url ="Search.jsp";
					break;

				case "購入":
					url = "check.jsp";
					break;


				default:
					url = "Cart.jsp";

					CartDao CD = new CartDao();

					//list = CD.main(req, resp);
			//CartDaoのmainメソッドを呼び、結果としてcartben型arraylistを返す。
			//拡張for文にて自身のlistに追加していく
					//for(CartBean bean:CD.main(req, resp)) list.add(bean);
					list.addAll(CD.main(req, resp));

					Logic lg = new Logic();
					// Logicクラスのインスタンス化
					// setTax():cartリストから消費税の算出
					lg.setTax(list);
					// setSum():cartリストから合計を算出
					lg.setSum(list);

					// session 開始指定しているなら実行
					HttpSession session = req.getSession(false);
					session.setAttribute("logic", lg);
					session.setAttribute("list", list);
				}

				// 画面遷移処理
				RequestDispatcher rd = req.getRequestDispatcher(url);
				rd.forward(req,resp);
	}
}
