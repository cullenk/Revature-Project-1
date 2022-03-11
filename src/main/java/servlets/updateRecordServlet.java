package servlets;

import model.AdoptionRecord;
import services.AdoptionRecordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/updateRecordServlet")
public class updateRecordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int adoptionRecordId = Integer.parseInt(request.getParameter("recordId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String breed = request.getParameter("breed");
        String gender = request.getParameter("gender");
        String puppy_name = request.getParameter("puppy_name");
        String testFirstName = null;

        AdoptionRecordService recordService = new AdoptionRecordService();
        List<AdoptionRecord> returnedRecord = recordService.getAdoptionRecordById(adoptionRecordId);
        for(AdoptionRecord ar : returnedRecord){
            testFirstName = ar.firstName;
        }


        recordService.updateAdoptionRecord(adoptionRecordId, firstName, lastName, breed, gender, puppy_name);

        request.setAttribute("recordId", adoptionRecordId);
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("breed", breed);
        request.setAttribute("gender", gender);
        request.setAttribute("puppy_name", puppy_name);

        //Forward to response data to .jsp file if it's a valid record to begin with
        if(testFirstName != null){
            RequestDispatcher rd = request.getRequestDispatcher("updateRecord.jsp");
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
