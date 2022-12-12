<%-- 
    Document   : index
    Created on : 28/11/2020, 08:43:02 PM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Usuario"%>
<%@page import="com.mycompany.tecnovitate.Models.Noticias"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Noticias> noticias = (List<Noticias>) request.getAttribute("noticias");
    List<Noticias> noticiasLikes = (List<Noticias>) request.getAttribute("noticiasLikes");
    Usuario sesion = (Usuario) session.getAttribute("logIn");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>TECNOVITATE</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row input-group inline">

                <%
                    for (Noticias element : noticias) {
                %>
                <div class="card bg-dark col-12">
                    <a href="NoticiaMostrarController?id=<%= element.getId()%>&idUser=<%if (sesion != null) {%><%=sesion.getIdUsua()%><%}%>">
                        <img class="card-img" src="<%= element.getPath1()%>" alt="Card image">
                        <div class="card-img-overlay justify-content-md-center align-items-end" id="Portada">
                        </div>    
                        <div class="card-body">
                            <h3 class="card-title"><%= element.getTitulo()%></h3>
                            <p class="card-text"><small class="text-muted"><%= element.getFecha()%></small></p>
                        </div>

                    </a>
                </div>
                <%
                        break;
                    }
                %>

                <div class="card-deck mb-12 other-seccion">
                    <h2 class="col-12 text-center">Los más gustados</h2>
                    <%
                        int i = 0;
                        for (Noticias element : noticiasLikes) {
                    %>
                    <div class="card bg-dark col-lg-4 col-md-12 col-sm-12">
                        <a href="NoticiaMostrarController?id=<%= element.getId()%>&idUser=<%if (sesion != null) {%><%=sesion.getIdUsua()%><%}%>">
                            <img src="<%= element.getPath1()%>" class="card-img-top">
                            <div class="card-body col-md-12 col-sm-12">
                                <h5 class="card-title"><%= element.getTitulo()%></h5>
                                <p class="card-text"><%= element.getDescrip()%></p>
                                <p class="card-text"><small class="text-muted">Fecha publicación: <%= element.getFecha()%></small></p>
                            </div>
                        </a>
                    </div>
                    <%i++;
                            if (i == 3) {
                                break;
                            }
                        }%>
                </div>

                <div id="Tarjetas" class="other-seccion">
                    <h2 class="text-center">Últimos agregados</h2>
                    <%
                        for (Noticias element : noticias) {
                    %>
                    <div class="card mb-3 bg-dark" style="max-width: 1500px">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <a href="NoticiaMostrarController?id=<%= element.getId()%>&idUser=<%if (sesion != null) {%><%=sesion.getIdUsua()%><%}%>">
                                    <img src="<%= element.getPath1()%>" class="card-img"/>
                                </a>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <a href="NoticiaMostrarController?id=<%= element.getId()%>&idUser=<%if (sesion != null) {%><%=sesion.getIdUsua()%><%}%>">
                                        <h5 class="card-title"><%= element.getTitulo()%></h5>
                                        <p class="card-text">
                                            <%= element.getDescrip()%>
                                        </p>
                                        <p class="card-text">
                                            <small class="text-muted"><%= element.getFecha()%></small>
                                        </p>  
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                </div>


            </div>
        </div>
    </div>
</body>
</html>
