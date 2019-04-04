import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();


        String name = request.getParameter("name");
        String password = request.getParameter("password");

        request.getRequestDispatcher("link.html").include(request,response);


        if(name.equals("admin")&& password.equals("admin123")){

            printWriter.print("<br>You are successfully logged in....!!!!");
            printWriter.print("<br> Welcome  "+name);

            Cookie cookie = new Cookie("name",name);
            response.addCookie(cookie);

        }else {

            printWriter.print("<br>Sorry!!!!.....Please enter valid username and password");
            request.getRequestDispatcher("login.html").include(request,response);
        }


    }
}
