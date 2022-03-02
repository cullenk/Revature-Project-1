package servlets;

import model.Breed;
import services.BreedService;

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
        out.println("Welcome to the Initial Questions Servlet!");

        int breedId = Integer.parseInt(request.getParameter("breedId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String size = request.getParameter("size");
        String temperament = request.getParameter("temperament");
        String sheds = request.getParameter("sheds");

        BreedService breedService = new BreedService();
        List<Breed> queryResult = breedService.getBestBreedsForUser(size, temperament, sheds);

        out.println("Here are some breeds that may be best suited for you:");
        for(Breed b : queryResult){
            out.println(b.breed);
        }

        //Set the addition result to a value to pass along
//        request.setAttribute("result", result);

        //Forward to the Subtraction Servlet instead
//        RequestDispatcher rd = request.getRequestDispatcher("subtraction");
//        rd.forward(request, response);

    }
}