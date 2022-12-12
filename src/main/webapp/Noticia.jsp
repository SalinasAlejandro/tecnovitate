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
    Usuario sesion = (Usuario) session.getAttribute("logIn");
    List<Comentarios> commentaries = (List<Comentarios>) request.getAttribute("Commentaries");
    List<Favs> favs = (List<Favs>) request.getAttribute("favs");
    int id = 0;
    boolean band = false;
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title><%= noticia.getTitulo()%></title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row other-seccion" id="NotiForm">

                <h1 class="col-12"><%= noticia.getTitulo()%></h1>
                <small class="col-4 text-muted" id="textsn">Categoría: <%= noticia.getCategoria().getCategoria()%> </small>
                <small class="col-4 text-muted" id="textsn">Creado por: <%= noticia.getUser().getNombre_Usua()%> </small>
                <small class="col-2 text-muted" id="textsn"> el día <%= noticia.getFecha()%> </small>
                <%
                    if (sesion != null) {
                        if (favs.size() != 0) {
                            for (Favs fav : favs) {
                                if (fav.getIdNoti().getId() == noticia.getId()) {
                                    band = true;
                                    id = fav.getId();
                                    break;
                                }
                            }
                        }
                        if (band == true) {%>
                <form action="FavoritosBorrarController" method="POST">
                    <input type="submit" class="btn btn-danger" value="Favorito">
                    <input type="hidden" name="id" value="<%=id%>">
                    <input type="hidden" name="idNews" value="<%= noticia.getId()%>">
                </form>
                <%
                } else {
                %>
                <form action="FavoritosController" method="POST">
                    <input type="submit" class="btn btn-dark" value="Favorito">
                    <input type="hidden" name="idNews" value="<%= noticia.getId()%>">
                    <input type="hidden" name="idUser" value="<%= sesion.getIdUsua()%>">
                </form>
                <%
                        }
                    }
                %>
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

                    if (noticia.getPathv()
                            != null) {
                %>
                <video class="col-12"  controls>
                    <source src="<%= noticia.getPathv()%>" type="video/mp4">
                    Your browser does not support the video tag.
                </video> 
                <%
                    }
                %>
                <a href="LikeNoticia?idNew=<%= noticia.getId()%>&idUser=<%if (sesion != null) {%><%= sesion.getIdUsua()%><%}%> ">
                    <button type="button" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M8.834.066C7.494-.087 6.5 1.048 6.5 2.25v.5c0 1.329-.647 2.124-1.318 2.614-.328.24-.66.403-.918.508A1.75 1.75 0 002.75 5h-1A1.75 1.75 0 000 6.75v7.5C0 15.216.784 16 1.75 16h1a1.75 1.75 0 001.662-1.201c.525.075 1.067.229 1.725.415.152.043.31.088.475.133 1.154.32 2.54.653 4.388.653 1.706 0 2.97-.153 3.722-1.14.353-.463.537-1.042.668-1.672.118-.56.208-1.243.313-2.033l.04-.306c.25-1.869.265-3.318-.188-4.316a2.418 2.418 0 00-1.137-1.2C13.924 5.085 13.353 5 12.75 5h-1.422l.015-.113c.07-.518.157-1.17.157-1.637 0-.922-.151-1.719-.656-2.3-.51-.589-1.247-.797-2.01-.884zM4.5 13.3c.705.088 1.39.284 2.072.478l.441.125c1.096.305 2.334.598 3.987.598 1.794 0 2.28-.223 2.528-.549.147-.193.276-.505.394-1.07.105-.502.188-1.124.295-1.93l.04-.3c.25-1.882.189-2.933-.068-3.497a.922.922 0 00-.442-.48c-.208-.104-.52-.174-.997-.174H11c-.686 0-1.295-.577-1.206-1.336.023-.192.05-.39.076-.586.065-.488.13-.97.13-1.328 0-.809-.144-1.15-.288-1.316-.137-.158-.402-.304-1.048-.378C8.357 1.521 8 1.793 8 2.25v.5c0 1.922-.978 3.128-1.933 3.825a5.861 5.861 0 01-1.567.81V13.3zM2.75 6.5a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1z"></path></svg> LIKE <%= noticia.getLikes()%></button>
                </a>
                <a href="DislikeNoticia?idNew=<%= noticia.getId()%>&idUser=<%if (sesion != null) {%><%= sesion.getIdUsua()%><%}%> ">
                    <button type="button" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M7.083 15.986c1.34.153 2.334-.982 2.334-2.183v-.5c0-1.329.646-2.123 1.317-2.614.329-.24.66-.403.919-.508a1.75 1.75 0 001.514.872h1a1.75 1.75 0 001.75-1.75v-7.5a1.75 1.75 0 00-1.75-1.75h-1a1.75 1.75 0 00-1.662 1.2c-.525-.074-1.068-.228-1.726-.415L9.305.705C8.151.385 6.765.053 4.917.053c-1.706 0-2.97.152-3.722 1.139-.353.463-.537 1.042-.669 1.672C.41 3.424.32 4.108.214 4.897l-.04.306c-.25 1.869-.266 3.318.188 4.316.244.537.622.943 1.136 1.2.495.248 1.066.334 1.669.334h1.422l-.015.112c-.07.518-.157 1.17-.157 1.638 0 .921.151 1.718.655 2.299.512.589 1.248.797 2.011.884zm4.334-13.232c-.706-.089-1.39-.284-2.072-.479a63.914 63.914 0 00-.441-.125c-1.096-.304-2.335-.597-3.987-.597-1.794 0-2.28.222-2.529.548-.147.193-.275.505-.393 1.07-.105.502-.188 1.124-.295 1.93l-.04.3c-.25 1.882-.19 2.933.067 3.497a.921.921 0 00.443.48c.208.104.52.175.997.175h1.75c.685 0 1.295.577 1.205 1.335-.022.192-.049.39-.075.586-.066.488-.13.97-.13 1.329 0 .808.144 1.15.288 1.316.137.157.401.303 1.048.377.307.035.664-.237.664-.693v-.5c0-1.922.978-3.127 1.932-3.825a5.862 5.862 0 011.568-.809V2.754zm1.75 6.798a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1z"></path></svg> DISLIKE <%= noticia.getDislikes()%></button>
                </a>

                <div class="col-12 commentaries p-5" id="ComentarySection">
                    <%
                        if (sesion == null) {
                    %>
                    <h5 class="mt-0">Anónimo</h5>
                    <%
                    } else {
                    %>
                    <h5 class="mt-0"><%= sesion.getNombre_Usua()%></h5>
                    <%
                        }
                    %>
                    <form method="POST" action="ComentariosController">
                        <div class="form-group">
                            <textarea class="form-control" name="commentary" id="commentary"
                                      placeholder="¿Alguna opinión? Cuentanoslo"></textarea>
                            <input type="hidden" name="idNews" value="<%= noticia.getId()%>">
                            <%
                                if (sesion
                                        != null) {%>
                            <input type="hidden" name="idUser" value="<%= sesion.getIdUsua()%>">
                            <% } else { %>
                            <input type="hidden" name="idUser" value="">  
                            <%
                                }
                            %>
                            <div class="form-group">
                                <input type="submit" class="btn btn-success" value="Comentar">
                            </div>
                        </div>
                    </form>
                    <%
                        for (Comentarios comentary : commentaries) {
                            if (comentary.getIdUsua() != null) {
                    %>
                    <div class="media">
                        <% if (sesion != null) {
                                if (sesion.getTipo() == 2 || sesion.getTipo() == 3) {%>
                        <a href="ComentariosBorrarController?id=<%= comentary.getId()%>&idNews=<%= noticia.getId()%>&idUser=<%if (sesion == null) {%><%= sesion.getIdUsua()%><%}%>">Borrar</a>
                        <% }
                            }%>

                        <img src="<%= comentary.getIdUsua().getPath()%>" class="mr-3 w-5 h-5" alt="..." style="max-width: 250px; max-height: 250px;min-width: 250px">
                        <div class="media-body">
                            <h5 class="mt-0"><%= comentary.getIdUsua().getNombre_Usua()%></h5>
                            <small class="col-12 text-muted">Creado: <%= comentary.getFecha()%> </small>
                            <a href="LikeComentario?idCom=<%= comentary.getId()%>&idNew=<%= noticia.getId()%>&idUser=<% if (sesion != null) {%><%= sesion.getIdUsua()%><%}%>">
                                <button type="button" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M8.834.066C7.494-.087 6.5 1.048 6.5 2.25v.5c0 1.329-.647 2.124-1.318 2.614-.328.24-.66.403-.918.508A1.75 1.75 0 002.75 5h-1A1.75 1.75 0 000 6.75v7.5C0 15.216.784 16 1.75 16h1a1.75 1.75 0 001.662-1.201c.525.075 1.067.229 1.725.415.152.043.31.088.475.133 1.154.32 2.54.653 4.388.653 1.706 0 2.97-.153 3.722-1.14.353-.463.537-1.042.668-1.672.118-.56.208-1.243.313-2.033l.04-.306c.25-1.869.265-3.318-.188-4.316a2.418 2.418 0 00-1.137-1.2C13.924 5.085 13.353 5 12.75 5h-1.422l.015-.113c.07-.518.157-1.17.157-1.637 0-.922-.151-1.719-.656-2.3-.51-.589-1.247-.797-2.01-.884zM4.5 13.3c.705.088 1.39.284 2.072.478l.441.125c1.096.305 2.334.598 3.987.598 1.794 0 2.28-.223 2.528-.549.147-.193.276-.505.394-1.07.105-.502.188-1.124.295-1.93l.04-.3c.25-1.882.189-2.933-.068-3.497a.922.922 0 00-.442-.48c-.208-.104-.52-.174-.997-.174H11c-.686 0-1.295-.577-1.206-1.336.023-.192.05-.39.076-.586.065-.488.13-.97.13-1.328 0-.809-.144-1.15-.288-1.316-.137-.158-.402-.304-1.048-.378C8.357 1.521 8 1.793 8 2.25v.5c0 1.922-.978 3.128-1.933 3.825a5.861 5.861 0 01-1.567.81V13.3zM2.75 6.5a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1z"></path></svg> LIKE <%= comentary.getLikes()%></button>
                            </a>
                            <a href="DislikeComentario?idCom=<%= comentary.getId()%>&idNew=<%= noticia.getId()%>&idUser=<% if (sesion != null) {%><%= sesion.getIdUsua()%><%}%>">
                                <button type="button" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M7.083 15.986c1.34.153 2.334-.982 2.334-2.183v-.5c0-1.329.646-2.123 1.317-2.614.329-.24.66-.403.919-.508a1.75 1.75 0 001.514.872h1a1.75 1.75 0 001.75-1.75v-7.5a1.75 1.75 0 00-1.75-1.75h-1a1.75 1.75 0 00-1.662 1.2c-.525-.074-1.068-.228-1.726-.415L9.305.705C8.151.385 6.765.053 4.917.053c-1.706 0-2.97.152-3.722 1.139-.353.463-.537 1.042-.669 1.672C.41 3.424.32 4.108.214 4.897l-.04.306c-.25 1.869-.266 3.318.188 4.316.244.537.622.943 1.136 1.2.495.248 1.066.334 1.669.334h1.422l-.015.112c-.07.518-.157 1.17-.157 1.638 0 .921.151 1.718.655 2.299.512.589 1.248.797 2.011.884zm4.334-13.232c-.706-.089-1.39-.284-2.072-.479a63.914 63.914 0 00-.441-.125c-1.096-.304-2.335-.597-3.987-.597-1.794 0-2.28.222-2.529.548-.147.193-.275.505-.393 1.07-.105.502-.188 1.124-.295 1.93l-.04.3c-.25 1.882-.19 2.933.067 3.497a.921.921 0 00.443.48c.208.104.52.175.997.175h1.75c.685 0 1.295.577 1.205 1.335-.022.192-.049.39-.075.586-.066.488-.13.97-.13 1.329 0 .808.144 1.15.288 1.316.137.157.401.303 1.048.377.307.035.664-.237.664-.693v-.5c0-1.922.978-3.127 1.932-3.825a5.862 5.862 0 011.568-.809V2.754zm1.75 6.798a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1z"></path></svg> DISLIKE <%= comentary.getDislikes()%></button>
                            </a>
                            <div><%= comentary.getComentario()%></div>
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <div class="media">
                        <% if (sesion != null) {
                                if (sesion.getTipo() == 2 || sesion.getTipo() == 3) {%>
                        <a href="ComentariosBorrarController?id=<%= comentary.getId()%>&idNews=<%= noticia.getId()%>">Borrar</a>
                        <% }
                            }%>
                        <img src="assets/image/anonimo.jpg" class="mr-3 " alt="..." style="max-width: 250px; max-height: 250px">
                        <div class="media-body">
                            <h5 class="mt-0">Anónimo</h5>
                            <small class="col-12 text-muted">Creado: <%= comentary.getFecha()%> </small>
                            <a href="LikeComentario?idCom=<%= comentary.getId()%>&idNew=<%= noticia.getId()%>&idUser=<% if (sesion != null) {%><%= sesion.getIdUsua()%><%}%>">
                                <button type="button" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M8.834.066C7.494-.087 6.5 1.048 6.5 2.25v.5c0 1.329-.647 2.124-1.318 2.614-.328.24-.66.403-.918.508A1.75 1.75 0 002.75 5h-1A1.75 1.75 0 000 6.75v7.5C0 15.216.784 16 1.75 16h1a1.75 1.75 0 001.662-1.201c.525.075 1.067.229 1.725.415.152.043.31.088.475.133 1.154.32 2.54.653 4.388.653 1.706 0 2.97-.153 3.722-1.14.353-.463.537-1.042.668-1.672.118-.56.208-1.243.313-2.033l.04-.306c.25-1.869.265-3.318-.188-4.316a2.418 2.418 0 00-1.137-1.2C13.924 5.085 13.353 5 12.75 5h-1.422l.015-.113c.07-.518.157-1.17.157-1.637 0-.922-.151-1.719-.656-2.3-.51-.589-1.247-.797-2.01-.884zM4.5 13.3c.705.088 1.39.284 2.072.478l.441.125c1.096.305 2.334.598 3.987.598 1.794 0 2.28-.223 2.528-.549.147-.193.276-.505.394-1.07.105-.502.188-1.124.295-1.93l.04-.3c.25-1.882.189-2.933-.068-3.497a.922.922 0 00-.442-.48c-.208-.104-.52-.174-.997-.174H11c-.686 0-1.295-.577-1.206-1.336.023-.192.05-.39.076-.586.065-.488.13-.97.13-1.328 0-.809-.144-1.15-.288-1.316-.137-.158-.402-.304-1.048-.378C8.357 1.521 8 1.793 8 2.25v.5c0 1.922-.978 3.128-1.933 3.825a5.861 5.861 0 01-1.567.81V13.3zM2.75 6.5a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1z"></path></svg> LIKE <%= comentary.getLikes()%></button>
                            </a>
                            <a href="DislikeComentario?idCom=<%= comentary.getId()%>&idNew=<%= noticia.getId()%>&idUser=<% if (sesion != null) {%><%= sesion.getIdUsua()%><%}%>">
                                <button type="button" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" width="16" height="16"><path fill-rule="evenodd" d="M7.083 15.986c1.34.153 2.334-.982 2.334-2.183v-.5c0-1.329.646-2.123 1.317-2.614.329-.24.66-.403.919-.508a1.75 1.75 0 001.514.872h1a1.75 1.75 0 001.75-1.75v-7.5a1.75 1.75 0 00-1.75-1.75h-1a1.75 1.75 0 00-1.662 1.2c-.525-.074-1.068-.228-1.726-.415L9.305.705C8.151.385 6.765.053 4.917.053c-1.706 0-2.97.152-3.722 1.139-.353.463-.537 1.042-.669 1.672C.41 3.424.32 4.108.214 4.897l-.04.306c-.25 1.869-.266 3.318.188 4.316.244.537.622.943 1.136 1.2.495.248 1.066.334 1.669.334h1.422l-.015.112c-.07.518-.157 1.17-.157 1.638 0 .921.151 1.718.655 2.299.512.589 1.248.797 2.011.884zm4.334-13.232c-.706-.089-1.39-.284-2.072-.479a63.914 63.914 0 00-.441-.125c-1.096-.304-2.335-.597-3.987-.597-1.794 0-2.28.222-2.529.548-.147.193-.275.505-.393 1.07-.105.502-.188 1.124-.295 1.93l-.04.3c-.25 1.882-.19 2.933.067 3.497a.921.921 0 00.443.48c.208.104.52.175.997.175h1.75c.685 0 1.295.577 1.205 1.335-.022.192-.049.39-.075.586-.066.488-.13.97-.13 1.329 0 .808.144 1.15.288 1.316.137.157.401.303 1.048.377.307.035.664-.237.664-.693v-.5c0-1.922.978-3.127 1.932-3.825a5.862 5.862 0 011.568-.809V2.754zm1.75 6.798a.25.25 0 01-.25-.25v-7.5a.25.25 0 01.25-.25h1a.25.25 0 01.25.25v7.5a.25.25 0 01-.25.25h-1z"></path></svg> DISLIKE <%= comentary.getDislikes()%></button>
                            </a>
                            <div><%= comentary.getComentario()%></div>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>

            </div>
        </div>
    </body>
</html>
