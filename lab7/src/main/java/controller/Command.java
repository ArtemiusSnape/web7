/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Command interface
 * @author Rai Alexander
 */
public interface Command {
    String getPattern();

    int getAccessLevel();

    void doGet(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException ;

    default void doPost(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ServletException, IOException{
        doGet(request, response, servletContext);
    }
}
