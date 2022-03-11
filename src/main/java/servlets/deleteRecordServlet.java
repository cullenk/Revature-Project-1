package servlets;

import model.AdoptionRecord;
import model.Breed;
import services.AdoptionRecordService;
import services.BreedService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deleteRecordServlet")
public class deleteRecordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int adoptionRecordId = Integer.parseInt(request.getParameter("recordId"));
        String firstName = null;
        String lastName = null;
        String breed = null;
        String gender = null;
        String puppy_name = null;

        AdoptionRecordService recordService = new AdoptionRecordService();
        List<AdoptionRecord> returnedRecords = recordService.getAdoptionRecordById(adoptionRecordId);
        for(AdoptionRecord ar : returnedRecords){
            firstName = ar.firstName;
            lastName = ar.lastName;
            breed = ar.breed;
            gender = ar.gender;
            puppy_name = ar.puppy_name;
        }

        request.setAttribute("recordId", adoptionRecordId);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("breed", breed);
        request.setAttribute("gender", gender);
        request.setAttribute("puppy_name", puppy_name);

        recordService.deleteAdoptionRecord(adoptionRecordId);

        //Forward to response data to .jsp file if it's a valid record to begin with
        if(firstName != null){
            RequestDispatcher rd = request.getRequestDispatcher("deleteRecord.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().println("<html>");
            response.getWriter().println("<body style='background-color: dodgerblue; display: flex; flex-direction: column; justify-content: center; align-items: center;'>");
            response.getWriter().println("<h1>Oops, that Record ID didn't exist!</h1>");
            response.getWriter().println("<a style='text-decoration: none; color: white;' href='index.html'>Return Home</a>");
            response.getWriter().println("</body>");
            response.getWriter().println("</html>");
        }

    }
}
