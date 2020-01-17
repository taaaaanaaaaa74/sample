package nkym;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//テキストデータの使用の宣言
				resp.setContentType("text/html;charset=UTF-8");
				//ブラウザへテキストデータを出力
				PrintWriter out = resp.getWriter();
				//継続確認
				HttpSession session = req.getSession(false);
				//セッションオブジェクトの消滅
				if (session != null) {
					session.invalidate();
					}
				out.println("<html>");
				out.println("<head><title>ログアウト</title></head>");
				out.println("<body>");
				out.println("<h1></h1>");
				out.println("<p>セッションを終了しました</p>");
				out.println("</body>");
				out.println("</html>");
	}
}
