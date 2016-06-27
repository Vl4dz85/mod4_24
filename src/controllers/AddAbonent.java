package controllers;

import models.AbonentsEntity;
import models.IsMeter;
import models.ServicesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.AbonentServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Vlad on 16.06.16.
 */
@WebServlet("/AddAbonent")
public class AddAbonent extends HttpServlet {

    @EJB
    AbonentServiceBean abnService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random ran = new Random();

        AbonentsEntity abonent = new AbonentsEntity();
        abonent.setAbonentAccount((100000 + ran.nextInt(900000)));
        abonent.setAddressId(1);
        String sid = request.getParameter("sid");


        abnService.addAbonent(abonent, sid);




    }
}
