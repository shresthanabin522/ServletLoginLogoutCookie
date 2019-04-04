import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        request.getRequestDispatcher("link.html").include(request,response);

        Cookie cookie = new Cookie("name","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        printWriter.print("<br>You are successfully logged out!!!!");




    }
}
