package controller.command;

import model.DAO.DAORequest;

import model.exceptions.DAOException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CancelRequestCommand implements Command {
    final String urlPattern = "cancelRequest";
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
                .getRequestDispatcher("/view/cancelRequestView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("cancelRequest")){
            int request_id = Integer.parseInt(request.getParameter("request_id"));

            try {
                (new DAORequest()).updateRequestStatus(request_id, 3);
            } catch (DAOException e) {
                e.printStackTrace();
            }

            request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
        }
    }
}
