package servlets;

import services.AdoptionRecordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adoptionPage")
public class adoptionPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Inside the Final Adoption Page");
        String gender = request.getParameter("gender");
        String name = request.getParameter("name");

        request.setAttribute("gender", gender);
        request.setAttribute("name", name);

        //Get the old session values to save the user first and last name as well as the breed they chose
        String firstName = (String) request.getSession().getAttribute("firstName");
        String lastName = (String) request.getSession().getAttribute("lastName");
        String breed = (String) request.getSession().getAttribute("chosenBreed");

        //Add the new adoption to the adoption records table
        AdoptionRecordService adr = new AdoptionRecordService();
        adr.addNewAdoptionRecord(firstName, lastName, breed, gender, name);

        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("adoptionPage.jsp");
        rd.forward(request, response);



    }
}