<%-- 
    Document   : Si
    Created on : 29/11/2020, 03:34:50 AM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario sesion = (Usuario) session.getAttribute("logIn");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>Perfil</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row">

                <h1 class="col-12 text-center"><br>Bienvenido<br></h1>
                <div id="carouselExampleControls" class="carousel slide col-12 justify-content-md-center" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<%= sesion.getPath()%>" class="rounded mx-auto d-block w-5 h-5" alt="..." style="max-height: 500px;max-width: 500px;min-height: 500px;min-width: 500px">
                        </div>
                    </div>
                </div>
                <div id="InfoP" class="col-12">

                    <div class="container-md col-6">
                        <p><h4 class="col-6 "><br>Nombre Usuario:<br> <%= sesion.getNombre_Usua()%></h4></p>
                        <p><h4 class="col-6 "><br>Correo: <br><%= sesion.getEmail()%></h4></p>
                        <p><h4 class="col-6 "><br>Redes Sociales:<br> <% if (sesion.getRedes() != null) {%><%= sesion.getRedes()%><% } %></h4></p>
                        <p><h4 class="col-6 "><br>Descripción:<br> <% if (sesion.getDescripcion() != null) {%><%= sesion.getDescripcion()%><% }%><br></h4></p>
                    </div>
                </div>


                <div class="row px-4">

                </div>
                <div class="container px-4 other-seccion">
                    <div class="row justify-content-md-center ">
                        <div class="input-group  col-6 justify-content-md-center">
                            <form action="editUsuaController">
                                <input type="submit" class="btn btn-primary" value="Editar Información">
                            </form>
                        </div>
                        <div class="input-group col-6 justify-content-md-center">
                            <form action="FavoritosController" >
                                <input type="submit" class="btn btn-info" value="Favoritos ">
                                <input type="hidden" name="idUser" value="<%= sesion.getIdUsua()%>">
                            </form>
                        </div>
                        <div class="input-group  col-12 justify-content-md-center">
                            <form action="CerrarSesion" method="POST" >
                                <input type="submit" class="btn btn-danger" value="Cerrar Sesión">
                            </form>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
