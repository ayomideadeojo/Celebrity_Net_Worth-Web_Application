package ca.sheridancollege.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Celebrity;

/**
 * Servlet implementation class DisplayWorths
 */
@WebServlet("/DisplayWorths")
public class DisplayWorths extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayWorths() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<style>\r\n" + 
				"body {background-color: lightpink;\r\n" + 
				" font-family: cursive;\r\n" + 
				" padding: 20px;\r\n" + 
				" border: 20px solid white;\r\n" + 
				" border-radius: 4px;\r\n" + 
				"}\r\n" + 
				"</style><h1 style='color:lightpink; background-color:white;text-align:center'> Behold The Net Worth's You've Been Looking For</h1>");
		
		@SuppressWarnings("unchecked")
		List<Celebrity> celebrityList = (List<Celebrity>) request.getAttribute("celebrity");
		
		for(Celebrity celeb : celebrityList) {
			response.getWriter().append("<h3 style='color:white; background-color:violet;text-align:center'> " +
					" FirstName: " + celeb.getFirstName() + 
					" LastName: " + celeb.getLastName() + 
					" Email: " + celeb.getEmail() +
					" Networth: "+Double.toString(celeb.getNetWorth())+
					"</h3>");
		}
		response.getWriter().append("<IMG SRC='chris.gif'>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
