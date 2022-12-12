<%-- 
    Document   : favs
    Created on : 1/12/2020, 08:18:17 PM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Noticias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Noticias> noticia = (List<Noticias>) request.getAttribute("noticia");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>Busqueda</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row other-seccion">


                <%
                    if (!noticia.isEmpty()) {
                %>
                <div class="row row-cols-1 row-cols-md-3">
                    <%
                        for (Noticias noti : noticia) {
                    %>
                    <div class="col mb-4">
                        <div class="card h-100">
                            <a href="NoticiaMostrarController?id=<%= noti.getId()%>">
                                <img src="<%= noti.getPath1()%>" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title"><%= noti.getTitulo()%></h5>
                                    <p class="card-text"><%= noti.getDescrip()%></p>
                                    <p class="card-text"><small class="text-muted"><%= noti.getUser().getNombre_Usua()%> </small><small class="text-muted"><%= noti.getFecha()%></small></p>
                                    <p class="card-text"><small class="text-muted"><%= noti.getCategoria().getCategoria()%> </small></p>
                                </div>
                            </a>
                        </div>
                    </div>
                    <%
                        }
                    %>

                </div>
                <%
                    } else {
                %>
                <h3>No hay coincidencias encontradas :c</h3>
                <%
                    }
                %>

            </div>
        </div>
    </body>
</html>
