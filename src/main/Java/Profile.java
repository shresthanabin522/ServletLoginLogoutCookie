import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Profile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        Cookie cookie[] = request.getCookies();
        if (cookie != null) {
            for(Cookie cokie: cookie) {
                if(cokie.getName().equals("name")) {
                    if (!cokie.getValue().equals("") || cokie.getValue() != null) {
                        printWriter.print("<br>Welcome to Profile</b>");
                        printWriter.print("<br>Welcome " +cokie.getValue());
                        break;
                    }
                    else {
                        printWriter.print("<br>Please Login first...");
                        request.getRequestDispatcher("login.html").include(request, response);
                    }
                }

            }

        }
        else {
            printWriter.print("<br>Please Login first...");
            request.getRequestDispatcher("login.html").include(request, response);
        }


    }
}
