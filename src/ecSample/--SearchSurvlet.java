package nkym;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchSurvlet extends HttpServlet {
public static ArrayList<SearchBean> sbl;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String SearchWord = req.getParameter("search");
		String category = req.getParameter("category");
		System.out.println(SearchWord);

		CategoryDB cd = new CategoryDB();

		sbl = cd.getProductDb(SearchWord, category);

		//RequestDispatcher rd = req.getRequestDispatcher("SearchResult");
		HttpSession session = req.getSession(false);
		session.setAttribute("productList", sbl);


		// 画面遷移処理
		RequestDispatcher rd = req.getRequestDispatcher("SearchResult.jsp");
		rd.forward(req, resp);
	}

	}



