package controller.command;

import model.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeCommand implements controller.command.Command
{

    final String urlPattern = "home";
    final int accessLevel = -1;

    @Override
    public int getAccessLevel()
    {
        return accessLevel;
    }
    @Override
    public String getPattern()
    {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException
    {

        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/view/homeView.jsp");
        dispatcher.forward(request, response);
    }
}
