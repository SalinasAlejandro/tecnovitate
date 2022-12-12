<%-- 
    Document   : ediUser
    Created on : 29/11/2020, 04:55:14 PM
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
        <title>Editar Perfil</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container other-seccion">
            <div class="row">

                <form class="col-12" action="editUsuaController" method="POST" enctype="multipart/form-data">
                    <h1>Editar Información</h1>
                    <div class="form-group">
                        <label for="nomUsua">Nombre de Usuario</label>
                        <input type="text" class="form-control" name="nomUsua" id="nomUsua"
                               value="<%= sesion.getNombre_Usua()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo electrónico</label>
                        <input type="email" class="form-control" name="correo" id="correo" 
                               value="<%= sesion.getEmail()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="contra">Contraseña</label>
                        <input type="password" class="form-control" name="contra" id="contra" 
                               value="<%= sesion.getContraseña()%>" required>
                    </div>
                    <div class="form-group">
                        <label for="redes">Redes Sociales</label>
                        <textarea class="form-control" name="redes" id="redes" 
                                  rows="3"><% if (sesion.getRedes() != null) {%><%= sesion.getRedes()%><% } %></textarea>
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <textarea class="form-control" name="descripcion" id="descripcion" 
                                  rows="3"><% if (sesion.getDescripcion() != null) {%><%= sesion.getDescripcion()%><% }%></textarea>
                    </div>
                    <div class="form-group">
                        <label for="foto">Foto de Perfil</label>
                        <input type="file" class="form-control" name="foto" id="foto">
                        <small class="form-text text-muted">Tamaño máximo de archivo: 5Mb.</small>
                        <input type="hidden" name="fotoPerfil" value="<%= sesion.getPath()%>" />
                    </div>

                    <div class="form-group">
                    </div>

                    <div class="form-group">
                        <label for="conf">Confirme con su antigua contraseña</label>
                        <input type="password" class="form-control" name="conf" id="conf" required>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Editar">
                    </div>
                </form>

            </div>
        </div>
    </body>
</html>
