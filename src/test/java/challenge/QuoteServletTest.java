package challenge;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class QuoteServletTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private RequestDispatcher requestDispatcher;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getQuote() throws Exception {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		when(response.getWriter()).thenReturn(printWriter);

		new QuoteServlet().doGet(request, response);

		assertNotEquals("", stringWriter.toString());
	}

	@Test
	public void getQuoteByActor() throws Exception {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);

		when(request.getPathInfo()).thenReturn("/John Cleese");
		when(response.getWriter()).thenReturn(printWriter);

		new QuoteServlet().doGet(request, response);

		assertNotEquals("", stringWriter.toString());
	}

}
