package chapter03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderEx1
 */
@WebServlet("/chapter03/headerex1")
public class ResponseHeaderServletEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseHeaderServletEx1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		
		response.setHeader("myheader1","value1");
		response.setHeader("myheader2","value2");
		
		Collection<String> headerNames= response.getHeaderNames();
		
		out.println("<body>");
		out.println("<ul>");
		
		
		for(String name :headerNames) {
			out.println("<li>");
			out.println(name+":"+response.getHeader(name));
			out.println("</li>");
		}
		
		out.println("</ul>");
		out.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
