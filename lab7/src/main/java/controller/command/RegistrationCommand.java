package controller.command;

import model.DAO.DAOUser;
import model.entities.User;
import model.exceptions.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
    final String urlPattern = "registration";
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
    public void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/registrationView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("command").equals("registration")){
            String errorString = "";
            String name = request.getParameter("name");
            String login = request.getParameter("login");
            String password = request.getParameter("password");


            System.out.println("Registration");
            try {
                DAOUser daoUser = new DAOUser();
                if (daoUser.isLoginValid(login)){
                    errorString = "Login already exists";
                }
                else {
                    User user = new User(0, name, login, password);
                    daoUser.insertUser(user);

                }
            } catch (DAOException e) {

                e.printStackTrace();
            }

            if(errorString.equals("")){
                request.getRequestDispatcher("/view/homeView.jsp").forward(request, response);
            } else {
                request.setAttribute("errorString", errorString);
                request.getRequestDispatcher("/view/registrationView.jsp").forward(request, response);
            }
        }
    }
}
