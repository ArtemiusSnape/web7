package controller;

import controller.command.*;
import controller.command.CancelRequestCommand;
import model.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * DAO class.
 * @author Artsiom Maroz
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static Map<String, Command> commands;

    public MainServlet() {
        super();
        commands = new HashMap<>();
    }

    @Override
    public void init() {
        Command[] commands = {new HomeCommand(), new WorkersListCommand(), new RequestsListCommand(),
                new TenantsListCommand(), new WorkPlansListCommand(),
        new OverdueRequestsCommand(), new SetWorkerToJobCommand(), new CancelRequestCommand(),
        new LoginCommand(), new RegistrationCommand(), new LogOutCommand()};
        for (Command c : commands) {
            this.commands.put(c.getPattern(), c);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            commands.get("home").doGet(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {

            commands.get(command).doGet(request, response, this.getServletContext());

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null) {
            commands.get("home").doPost(request, response, this.getServletContext());
        } else if (commands.containsKey(command)) {
            commands.get(command).doPost(request, response, this.getServletContext());

        }
    }

    /*private boolean checkPermission(HttpSession session, String command){
        int user_type = ((User)session.getAttribute("user")).getUser_type();
        return user_type >= commands.get(command).getAccessLevel();
    }*/
}
