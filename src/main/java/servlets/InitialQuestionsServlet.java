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
        //If breeds are not found
        response.getWriter().println("<html>");
        response.getWriter().println("<body style='background-color: dodgerblue; display: flex; flex-direction: column; justify-content: center; align-items: center;'>");
        response.getWriter().println("<h1>Hmm, I couldn't find any breeds that match your preferences.</h1>");
        response.getWriter().println("<a style='text-decoration: none; color: white;' href='index.html'>Return Home</a>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String size = request.getParameter("size");
        String temperament = request.getParameter("temperament");
        String sheds = request.getParameter("sheds");

        BreedService breedService = new BreedService();
        List<Breed> returnedBreeds = breedService.getBestBreedsForUser(size, temperament, sheds);


        //Set the queried list to a value to pass along
        request.getSession().setAttribute("firstName", firstName);
        request.getSession().setAttribute("lastName", lastName);
        request.setAttribute("returnedBreeds", returnedBreeds);

        //Forward to response data to .jsp file if results found
            RequestDispatcher rd = request.getRequestDispatcher("initialQuestions.jsp");
            rd.forward(request, response);



    }
}