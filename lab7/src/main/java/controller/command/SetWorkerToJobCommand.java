package controller.command;

import model.DAO.DAORequest;
import model.DAO.DAOWorkPlan;
import model.entities.WorkPlan;
import model.exceptions.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetWorkerToJobCommand implements Command {
    final String urlPattern = "setWorkerToJob";
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
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/setWorkerToJob.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("setWorkerToJob")){
            int request_id = Integer.parseInt(request.getParameter("request_id"));
            int worker_id = Integer.parseInt(request.getParameter("worker_id"));

            try {
                (new DAOWorkPlan()).insertPlan(new WorkPlan(request_id, worker_id));
            } catch (DAOException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
        }
    }
}
