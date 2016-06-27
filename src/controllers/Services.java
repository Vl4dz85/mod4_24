package controllers;

import models.ServicesEntity;
import service.ServiceServiceBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * Created by Vlad on 25.06.16.
 */
@WebServlet("/Services")
public class Services extends HttpServlet {

    @EJB
    ServiceServiceBean se;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection <ServicesEntity> sColl = (Collection <ServicesEntity> )se.getServices();
        request.setAttribute("services collection", sColl);
        PrintWriter out = response.getWriter();

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/services_list.jsp");

        view.forward(request, response);
    }
}
