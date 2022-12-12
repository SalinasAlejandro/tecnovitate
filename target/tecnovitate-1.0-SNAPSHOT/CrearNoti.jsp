    <%-- 
    Document   : CrearNoti
    Created on : 29/11/2020, 10:11:56 PM
    Author     : dykeo
--%>


<%@page import="com.mycompany.tecnovitate.Models.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.tecnovitate.Models.Categorias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Categorias> categorias = (List<Categorias>) request.getAttribute("categories");
    Usuario sesion = (Usuario) session.getAttribute("logIn");
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="meta.jsp"/>
        <title>Crear Noticia</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container">
            <div class="row other-seccion">
                
                <form class="col-12" method="POST" enctype="multipart/form-data" action="NoticiaCrearController">
                    <h1>Nueva Noticia</h1>
                    <div class="form-group">
                        <label for="title">Título</label>
                        <input type="text" class="form-control" name="title" id="title">
                    </div>
                    <div class="form-group">
                        <label for="descripcion">Descripción Corta</label>
                        <textarea class="form-control" name="descripcion" id="descripcion" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="noticia">Noticia</label>
                        <textarea class="form-control" name="noticia" id="noticia" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="category">Categoría</label>
                        <select class="form-control" name="category" id="category">
                            <option value="-1">Seleccione una categoría</option>
                            <%
                                for (Categorias categori : categorias) {
                            %>
                            <option value="<%= categori.getId()%>"><%= categori.getCategoria()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <input type="hidden" name="idUser" value="<%= sesion.getIdUsua()%>">
                    <div class="form-group">
                        <label for="image">Imagen 1</label>
                        <input type="file" class="form-control" name="image" id="image">
                        <small class="form-text text-muted">Tamaño máximo de archivo: 5Mb.</small>
                    </div>
                    <div class="form-group">
                        <label for="image2">Imagen 2</label>
                        <input type="file" class="form-control" name="image2" id="image2">
                        <small class="form-text text-muted">Tamaño máximo de archivo: 5Mb.</small>
                    </div>
                    <div class="form-group">
                        <label for="image3">Imagen 3</label>
                        <input type="file" class="form-control" name="image3" id="image3">
                        <small class="form-text text-muted">Tamaño máximo de archivo: 5Mb.</small>
                    </div>
                    <div class="form-group">
                        <label for="video">Vídeo</label>
                        <input type="file" class="form-control" name="video" id="video">
                        <small class="form-text text-muted">Tamaño máximo de archivo: 5Mb.</small>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-primary" value="Subir noticia">
                    </div>
                </form>
                    
            </div>
        </div>
    </body>
</html>

