package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/nameAndGender")
public class nameAndGenderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("Inside Name and Gender Servlet");
        String chosenBreed = request.getParameter("chosenBreed");

        request.getSession().setAttribute("chosenBreed", chosenBreed);

        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("nameAndGender.jsp");
        rd.forward(request, response);

    }
}