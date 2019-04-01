package challenge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Quote quote = new Quote();
			String pathInfo = req.getPathInfo();
			if (pathInfo == null || pathInfo.equals("/")) {
				quote = new QuoteDao().getQuote();
			} else {
				String actor = pathInfo.split("/")[1];
				quote = new QuoteDao().getQuoteByActor(actor);
			}
			System.out.println(quote.jsonToString());
			resp.getWriter().print(quote.jsonToString());
			resp.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
}