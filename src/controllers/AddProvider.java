package controllers;

import models.ProvidersEntity;
import service.ProvidersServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vlad on 23.06.16.
 */
@WebServlet("/AddProvider")
public class AddProvider extends HttpServlet {

    @EJB
    ProvidersServiceBean psb;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvidersEntity pe = new ProvidersEntity();
        pe.setProviderName("Test");
        pe.setProviderAddress("Molodogvardeyskaya st, 15");

        psb.addProvider(pe);

    }
}
