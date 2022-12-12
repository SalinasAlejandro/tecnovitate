<%-- 
    Document   : favs
    Created on : 1/12/2020, 08:18:17 PM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Noticias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Noticias> noti = (List<Noticias>) request.getAttribute("noti");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>Noticias Pendientes</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container other-seccion">
            <div class="row">

                <% if (noti.size() == 0) { %>
                <h3>No tienes noticias por modificar</h3>
                <% } else {%>
                <div class="row row-cols-1 row-cols-md-3">
                    <%
                        for (Noticias not : noti) {
                    %>
                    <div class="col mb-4">
                        <div class="card h-100">
                            <a href="NoticiaCanceladoControlle?id=<%= not.getId()%>">
                                <img src="<%= not.getPath1()%>" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title"><%= not.getTitulo()%></h5>
                                    <p class="card-text"><%= not.getDescrip()%></p>
                                    <p class="card-text"><small class="text-muted"><%= not.getCategoria().getCategoria()%> </small></p>
                                </div>
                            </a>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
                <% }%>

            </div>
        </div>
    </body>
</html>
