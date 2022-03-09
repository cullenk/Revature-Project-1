package servlets;

import model.Breed;
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

@WebServlet("/viewAllBreedsServlet")
public class viewAllBreedsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Inside All Breeds Servlet");

        BreedService breedService = new BreedService();
        List<Breed> allBreedsList = breedService.getAllBreeds();

        //Set the queried list to a value to pass along
        request.setAttribute("allBreedsList", allBreedsList);

        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("viewAllBreeds.jsp");
        rd.forward(request, response);

//
    }
}
