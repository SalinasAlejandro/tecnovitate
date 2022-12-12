<%-- 
    Document   : navbar
    Created on : 28/11/2020, 11:26:09 PM
    Author     : dykeo
--%>

<%@page import="com.mycompany.tecnovitate.Models.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario sesion = (Usuario) session.getAttribute("logIn");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top" style="background-color: rgb(15, 76, 155)">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="indexController"><img
                        src="https://img.pngio.com/new-svg-image-t-png-2000_2000.png"
                        width="25"
                        height="25"
                        class="d-inline-block align-top"
                        alt="https://img.pngio.com/new-svg-image-t-png-2000_2000.png"
                        loading="lazy"
                        />TECNOVITATE <span class="sr-only">(current)</span></a>
            </li>
            <%
                if (sesion != null) {
            %>
            <li class="nav-item" >
                <a class="nav-link" href="FavoritosController?idUser=<%= sesion.getIdUsua()%>" >Favoritos</a>
            </li>

            <%
                if (sesion.getTipo() == 2 || sesion.getTipo() == 4 || sesion.getTipo() == 5) {
            %>
            <li class="nav-item">
                <a class="nav-link" href="NoticiaCrearController">Crear Nueva Noticia</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="NoticiaCancelados?idCreador=<%= sesion.getIdUsua()%>" >Mis Noticias Pendientes</a>
            </li>
            <%
                }
            %>
            <%
                if (sesion.getTipo() == 2 || sesion.getTipo() == 5) {
            %>
            <li class="nav-item">
                <a class="nav-link" href="NoticiaPendienteController">Noticias Pendientes</a>
            </li>
            <%
                }
            %>
            <%
                }
            %>
        </ul>
        <%
            if (sesion == null) {
        %>
        <div class="dropdown">
            <button class="btn btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Iniciar Sesión
            </button>
            <div class="dropdown-menu">
                <form class="px-4 py-3" action="IniSesionController" method="POST">
                    <div class="form-group">
                        <label for="correo">Correo</label>
                        <input type="email" class="form-control" name="correo" id="correo" placeholder="correo@ejemplo.com">
                    </div>
                    <div class="form-group">
                        <label for="contra">Contraseña</label>
                        <input type="password" class="form-control" name="contra" id="contra" placeholder="Contraseña">
                    </div>
                    <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
                </form>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="Registrar.jsp">¿No tienes cuenta? Regístrate</a>
            </div>
        </div>
        <%
        } else {
        %>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4"
                aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown avatar">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user"></i> <%= sesion.getNombre_Usua()%> 
                    </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                        <a class="dropdown-item" href="Perfil.jsp">Perfil</a>
                        <a class="dropdown-item" href="CerrarSesion">Cerrar Sesión</a>
                    </div>
                </li>
                <li class="nav-item avatar">
                    <img src="<%= sesion.getPath()%>" class="rounded-circle z-depth-0"
                         alt="avatar image" height="45" style="max-height: 45px;max-width: 45px;min-width: 45px;min-height: 45px">
                </li>
                <li class="nav-item avatar"></li>
            </ul>
        </div>
        <%
            }
        %>
        <form class="form-inline my-2 my-lg-0" method="POST" action="BuscadorController">
            <input class="form-control mr-sm-2" type="search" placeholder="Buscar noticia" aria-label="Search" name="buscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="color: #FFF;">Buscar</button>
        </form>
    </div>
</nav>