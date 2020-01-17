package nkym;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThanksServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 文字コードの設定
		req.setCharacterEncoding("UTF-8");

		String THANKS = req.getParameter("thanks");	// name="thanks" 取得
        String URL = null;

        // 受け取った value の値に応じて遷移先の url の設定
		switch(THANKS) {
		case "ログアウト":
			// session 開始指定しているなら実行
			HttpSession session = req.getSession(false);
	        if (session != null) {
	        	// session の終了
	        	session.invalidate();
	        }
	        URL = "Login.jsp";
	        break;

		case "買い物を続ける":
			URL = "Search.jsp";
			break;
	    }

		// 画面遷移処理
		RequestDispatcher rd = req.getRequestDispatcher(URL);
		rd.forward(req, resp);
	}
}
