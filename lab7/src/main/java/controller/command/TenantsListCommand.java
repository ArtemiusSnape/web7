package controller.command;

import model.DAO.DAORequest;
import model.DAO.DAOTenant;
import model.entities.Request;
import model.entities.Tenant;
import model.exceptions.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TenantsListCommand implements Command {

    final String urlPattern = "tenantsList";
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

        List<Tenant> list = null;
        try {
            list = (new DAOTenant()).getAllTenants();
        } catch (DAOException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("tenantsList", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/tenantsView.jsp");
        dispatcher.forward(request, response);
    }
}
