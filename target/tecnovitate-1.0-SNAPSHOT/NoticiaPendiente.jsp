<%-- 
    Document   : Noticia
    Created on : 30/11/2020, 11:00:19 AM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Favs"%>
<%@page import="com.mycompany.tecnovitate.Models.Comentarios"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.tecnovitate.Models.Usuario"%>
<%@page import="com.mycompany.tecnovitate.Models.Noticias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Noticias noticia = (Noticias) request.getAttribute("noticia");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title><%= noticia.getTitulo()%></title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container other-seccion">
            <div class="row">

                <h1 class="col-12"><%= noticia.getTitulo()%></h1>
                <small class="col-4 text-muted">Categoría: <%= noticia.getCategoria().getCategoria()%> </small>
                <small class="col-4 text-muted">Creado por: <%= noticia.getUser().getNombre_Usua()%> </small>
                <small class="col-2 text-muted"> el día <%= noticia.getFecha()%> </small>
                <div id="carouselExampleControls" class="carousel slide col-12" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<%= noticia.getPath1()%>" class="d-block w-100" alt="...">
                        </div>
                    </div>
                </div>
                <article class="col-12">
                    <p>
                        <%= noticia.getDescrip()%>
                    </p>
                </article>
                <div id="carouselExampleControls" class="carousel slide col-12" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<%= noticia.getPath2()%>" class="d-block w-100" alt="...">
                        </div>
                    </div>
                </div>
                <article class="col-12">
                    <p>
                        <%= noticia.getNoticia()%>
                    </p>
                </article>
                <div id="carouselExampleControls" class="carousel slide col-12" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<%= noticia.getPath3()%>" class="d-block w-100" alt="...">
                        </div>
                    </div>
                </div>
                <%

                    if (noticia.getPathv() != null) {
                %>
                <video class="col-12" controls>
                    <source src="<%= noticia.getPathv()%>" type="video/mp4">
                    Your browser does not support the video tag.
                </video> 
                <%
                    }
                %>

                <form action="NoticiaEstadoController">
                    <h3>Si considera que la noticia está bien y no necesita ningún cambio, confime que 
                        <input type="submit" class="btn btn-primary" value="ACEPTA LA NOTICIA"> </h3>
                    <input type="hidden" name="idNews" value="<%= noticia.getId()%>">
                </form>
                <form method="POST" action="NoticiaEstadoController">
                    <div class="form-group">
                        <h3>En cambio, si a su consideración, debe de hacerse algún cambio</h3>
                        <textarea class="form-control" name="cambio" id="commentary"
                                  placeholder="Escribalo aquí"></textarea>
                        <input type="submit" class="btn btn-primary" value="y confirme que CANCELA LA NOTICIA">
                        <input type="hidden" name="idNews" value="<%= noticia.getId()%>">
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>
