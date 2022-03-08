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

@WebServlet("/adoptionRecordsServlet")
public class AdoptionRecordsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Inside Adoption Records Servlet");

        AdoptionRecordService adoptionService = new AdoptionRecordService();
        List<AdoptionRecord> adoptionRecordList = adoptionService.getAllAdoptionRecords();

        out.println("after query");

        request.setAttribute("adoptionRecordList", adoptionRecordList);


        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("adoptionRecords.jsp");
        rd.forward(request, response);

//
    }
}