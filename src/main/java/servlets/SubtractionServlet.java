package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/subtraction")
public class SubtractionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Welcome to the Subtraction Servlet!");

        //Get the addition result from the other servlet
        int additionResult = (int) request.getAttribute("result");
        out.println("The addition result was: " + additionResult);

        int t1 = Integer.parseInt(request.getParameter("t1"));
        int t2 = Integer.parseInt(request.getParameter("t2"));
        out.println(t1+" - "+t2+" = "+(t1-t2));

    }
}