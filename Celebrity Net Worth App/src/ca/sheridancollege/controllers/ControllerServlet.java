package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Celebrity;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Celebrity> celebrityList = new CopyOnWriteArrayList<Celebrity>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
    
        Celebrity paul = new Celebrity("Paul","Hewson","bono@u2.com",700000000.00);
        Celebrity stefani = new Celebrity("Stefani","Germanotta","lady_gaga@mtv.com",275000000.00);
        Celebrity reginald = new Celebrity("Reginald","Dwight","eltonjohn@songwritersGuild.com",450000000.00);
        celebrityList.add(paul);
        celebrityList.add(stefani);
        celebrityList.add(reginald);
        
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Optional<Celebrity> queryResult = celebrityList.stream().filter(value -> value.getEmail().equals(request.getParameter("email"))).findFirst();
	
		if(queryResult.isPresent()){
			response.setContentType("text/html");
			response.getWriter().append("<h1>Email is already within the List, the networth will be updated to reflext new value :)</h1>");
			queryResult.get().setNetWorth(Double.parseDouble(request.getParameter("netWorth")));
		}else{
			Celebrity celeb = new Celebrity();
			celeb = (Celebrity) request.getAttribute("Celebrity");
			celebrityList.add(celeb);
		}
		request.setAttribute("celebrity", celebrityList);
		request.getRequestDispatcher("DisplayWorths").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = null;
		String lastName = null;
		String email = null;
		double netWorth = 0;
	
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		email = request.getParameter("email");
		netWorth = Double.parseDouble(request.getParameter("netWorth"));
		
	
		Celebrity celeb = new Celebrity(firstName, lastName, email, netWorth);
		request.setAttribute("Celebrity", celeb);
	
		doGet(request, response);
		
	}

}
