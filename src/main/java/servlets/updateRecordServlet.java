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

@WebServlet("/updateRecordServlet")
public class updateRecordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Inside Delete Record Servlet");

        int adoptionRecordId = Integer.parseInt(request.getParameter("recordId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String breed = request.getParameter("breed");
        String gender = request.getParameter("gender");
        String puppy_name = request.getParameter("puppy_name");

        AdoptionRecordService recordService = new AdoptionRecordService();
        recordService.updateAdoptionRecord(adoptionRecordId, firstName, lastName, breed, gender, puppy_name);

        request.setAttribute("recordId", adoptionRecordId);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("breed", breed);
        request.setAttribute("gender", gender);
        request.setAttribute("puppy_name", puppy_name);

        //Forward to response data to .jsp file
        RequestDispatcher rd = request.getRequestDispatcher("updateRecord.jsp");
        rd.forward(request, response);

    }
}
