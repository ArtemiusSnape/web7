package controller.command;

import model.DAO.DAOWorkPlan;
import model.DAO.DAOWorker;
import model.entities.WorkPlan;
import model.entities.Worker;
import model.exceptions.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WorkPlansListCommand implements Command {

    final String urlPattern = "workPlansList";
    final int accessLevel = 0;

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

        List<WorkPlan> list = null;
        try {
            list = (new DAOWorkPlan()).getAllPlans();
        } catch (DAOException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("workPlanList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/workPlansView.jsp");
        dispatcher.forward(request, response);
    }
}
