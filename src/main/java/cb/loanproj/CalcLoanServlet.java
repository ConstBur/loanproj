//Servlet class
package cb.loanproj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoanCalculator
 */
@WebServlet("/LoanCalculator")
public class CalcLoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START = "<html><body>";
	public static final String HTML_END = "</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcLoanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println(HTML_START + "<h2>Please enter your loan data:</h2>" +
				"<br/><form method=\"post\" action=\"LoanCalculator\">Loan Amount:<br>" +
				"<input type=\"text\" name=\"amount\"><br>" +
				"Loan Term (in months):<br>" +
				"<input type=\"text\" name=\"term\"><br>" +
				"Interest rate (annual):<br>" +
				"<input type=\"text\" name=\"rate\"><br>" +
				"<input type=\"submit\" value=\"Calculate\">" +
				"<input type=\"reset\">" +
				"</form>" + HTML_END);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CalcLoanClass calc = new CalcLoanClass();
		PrintWriter out = response.getWriter();
		String loan = request.getParameter("amount");
		String term = request.getParameter("term");
		String rate = request.getParameter("rate");
		String output = (HTML_START + "<pre>" + calc.toString(loan, term, rate) + "</pre>" + HTML_END);
		doGet(request, response);
		out.println(output);
	}

}