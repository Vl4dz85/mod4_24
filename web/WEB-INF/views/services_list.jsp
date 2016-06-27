<%@ page import="java.util.Collection" %>
<%@ page import="models.ServicesEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="models.AbonentsEntity" %><%--
  Created by IntelliJ IDEA.
  User: Vlad
  Date: 25.06.16
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Services list</title>
</head>
<body>
    <h1>List of services</h1>
    <table>
        <tr>
            <th>Service ID</th>
            <th>Service name</th>
            <th>IS_METER</th>
            <th>Provider ID</th>
            <th>Provider name</th>
            <th>Provider address</th>
            <th>Quantity</th>
            <th>Abonents info</th>
        </tr>

        <%

            List<ServicesEntity> sColl = (List<ServicesEntity>)request.getAttribute("services collection");

            for (Integer i = 0; i < sColl.size();i++) {

        %>

            <tr>

                <td> <%= sColl.get(i).getServiceId()%></td>
                <td> <%= sColl.get(i).getServiceName()%></td>
                <td> <%= sColl.get(i).getIsMeter()%></td>

                <td> <%= sColl.get(i).getProvidersByProviderId().getProviderId()%></td>
                <td> <%= sColl.get(i).getProvidersByProviderId().getProviderName()%></td>
                <td> <%= sColl.get(i).getProvidersByProviderId().getProviderAddress()%></td>

                <td>

                    <%
                        if (sColl.get(i).getAbonentsByServiceId() != null){

                    %>
                        <%= sColl.get(i).getAbonentsByServiceId().size() %> abonents

                    <%
                        }
                        else {
                    %>
                        No abonents yet.
                    <%
                        }
                    %>

                </td>

                <td>
                    <%
                        if (sColl.get(i).getAbonentsByServiceId() != null){
                            List<AbonentsEntity> aList = (List<AbonentsEntity>)sColl.get(i).getAbonentsByServiceId();
                            for (Integer j = 0; j < aList.size(); j++ ) {

                    %>

                        <%=
                            (j + 1) + ") " + "ID: "+ aList.get(j).getAbonentId() + " " + "Acc.N: " + aList.get(j).getAbonentAccount()

                        %>

                    <%
                            }//for
                        }//if
                    %>
                </td>



            </tr>

        <%
            }
        %>


    </table>
</body>
</html>
