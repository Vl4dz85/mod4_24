package controllers;

import models.IsMeter;
import models.ProvidersEntity;
import models.ServicesEntity;
import service.ServiceServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad on 19.06.16.
 */
@WebServlet("/AddService")
public class AddService extends HttpServlet {
    @EJB
    ServiceServiceBean serService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String pid = request.getParameter("pid");
        ServicesEntity se = new ServicesEntity();
        se.setServiceName("Water supply");
        se.setIsMeter(IsMeter.True);

        serService.addService(se, pid);

    }
}
