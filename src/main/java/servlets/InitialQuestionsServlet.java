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

@WebServlet("/initialQuestions")
public class InitialQuestionsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Inside Initial Questions Servlet");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String size = request.getParameter("size");
        String temperament = request.getParameter("temperament");
        String sheds = request.getParameter("sheds");

        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser(size, temperament, sheds);

        //Set the queried list to a value to pass along
        request.setAttribute("returnedBreeds", returnedBreeds);

        //Forward to response data to .jsp file.
        RequestDispatcher rd = request.getRequestDispatcher("initialQuestions.jsp");
        rd.forward(request, response);









//
    }
}