package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Welcome to the Addition Servlet!");

        int t1 = Integer.parseInt(request.getParameter("t1"));
        int t2 = Integer.parseInt(request.getParameter("t2"));
        int result = t1+t2;
        out.println(t1+" + "+t2+" = "+ result);

        //Set the addition result to a value to pass along
        request.setAttribute("result", result);

        //Forward to the Subtraction Servlet instead
        RequestDispatcher rd = request.getRequestDispatcher("subtraction");
        rd.forward(request, response);

    }
}