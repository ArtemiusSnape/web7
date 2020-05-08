package controller.command;


import model.DAO.DAOWorker;
import model.entities.Worker;
import model.exceptions.DAOException;

import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WorkersListCommand implements Command {

    final String urlPattern = "workersList";
    final int accessLevel = -1;

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }
    @Override
    public String getPattern() {
        return urlPattern;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException {
        String errorString = null;

        List<Worker> list = null;
        try {
            list = (new DAOWorker()).getAllWorkers();
        } catch (DAOException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("workersList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/workersView.jsp");
        dispatcher.forward(request, response);
    }
}
