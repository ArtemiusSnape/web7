package controller.command;

import model.DAO.DAORequest;
import model.entities.Request;
import model.exceptions.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OverdueRequestsCommand implements Command {
    final String urlPattern = "overdueRequests";
    final int accessLevel = 1;

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        String errorString = null;

        List<Request> list = null;
        try {
            list = (new DAORequest()).getOverdueRequests();
        } catch (DAOException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("pageName", "Overdue Requests List");
        request.setAttribute("errorString", errorString);
        request.setAttribute("requestsList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/requestsView.jsp");
        dispatcher.forward(request, response);
    }
}
