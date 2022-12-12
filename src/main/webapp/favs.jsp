<%-- 
    Document   : favs
    Created on : 1/12/2020, 08:18:17 PM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Favs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Favs> favs = (List<Favs>) request.getAttribute("favs");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>Mis favoritos</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container other-seccion">
            <div class="row">

                <%if (favs.size() == 0) { %>
                <h3>No tienes favoritos marcados</h3>
                <% } else { %>
                <div class="row row-cols-1 row-cols-md-3">
                    <%
                        for (Favs fav : favs) {
                    %>
                    <div class="col mb-4">
                        <div class="card h-100">
                            <a href="NoticiaMostrarController?id=<%= fav.getIdNoti().getId()%>&idUser=<%= fav.getIdUser()%>">
                                <img src="<%= fav.getIdNoti().getPath1()%>" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title"><%= fav.getIdNoti().getTitulo()%></h5>
                                    <p class="card-text"><%= fav.getIdNoti().getDescrip()%></p>
                                    <p class="card-text"><small class="text-muted"><%= fav.getIdNoti().getUser().getNombre_Usua()%> </small><small class="text-muted"><%= fav.getIdNoti().getFecha()%></small></p>
                                    <p class="card-text"><small class="text-muted"><%= fav.getIdNoti().getCategoria().getCategoria()%> </small></p>
                                    <a href="FavoritosBorrarController?id=<%= fav.getId()%>&idUser=<%= fav.getIdUser()%>">Borrar de mis Favoritos</a>
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
