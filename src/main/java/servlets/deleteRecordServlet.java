package servlets;

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
        PrintWriter out = response.getWriter();
        out.println("Inside Delete Record Servlet");

        int adoptionRecordId = Integer.parseInt(request.getParameter("recordId"));

        AdoptionRecordService recordService = new AdoptionRecordService();
        recordService.deleteAdoptionRecord(adoptionRecordId);

        request.setAttribute("recordId", adoptionRecordId);

        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("deleteRecord.jsp");
        rd.forward(request, response);

    }
}
