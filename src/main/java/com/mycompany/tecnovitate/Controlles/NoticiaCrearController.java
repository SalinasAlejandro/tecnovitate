/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.CategoriasDAO;
import com.mycompany.tecnovitate.DAO.NoticiasDAO;
import com.mycompany.tecnovitate.DAO.UsuarioDAO;
import com.mycompany.tecnovitate.Models.Categorias;
import com.mycompany.tecnovitate.Models.Noticias;
import com.mycompany.tecnovitate.Models.Usuario;
import com.mycompany.tecnovitate.Utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author dykeo
 */
@WebServlet(name = "NoticiaCrearController", urlPatterns = {"/NoticiaCrearController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class NoticiaCrearController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Categorias> categories = CategoriasDAO.getCategorias();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("CrearNoti.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String descripcion = request.getParameter("descripcion");
        String noticia = request.getParameter("noticia");
        int idCategory = Integer.parseInt(request.getParameter("category"), 10);
        String idUser = request.getParameter("idUser");

        Part file1 = request.getPart("image");
        String path = request.getServletContext().getRealPath("");
        File fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String contentType = file1.getContentType();
        // Remplazamos el nombre que tiene para que no existan duplicados
        String nameImage = file1.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        String fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
        // Copiamos la imagen en la ruta especificada
        file1.write(fullPath);
        Part file2 = request.getPart("image2");
        path = request.getServletContext().getRealPath("");
        fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        contentType = file2.getContentType();
        // Remplazamos el nombre que tiene para que no existan duplicados
        String nameImage2 = file2.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage2;
        // Copiamos la imagen en la ruta especificada
        file2.write(fullPath);
        Part file3 = request.getPart("image3");
        path = request.getServletContext().getRealPath("");
        fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        contentType = file3.getContentType();
        // Remplazamos el nombre que tiene para que no existan duplicados
        String nameImage3 = file3.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
        fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage3;
        // Copiamos la imagen en la ruta especificada
        file3.write(fullPath);
        String nameImage4 = ".ext";
        Part file4 = request.getPart("video");
        path = request.getServletContext().getRealPath("");
        fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String nameImagev = null;
        contentType = file4.getContentType();
        if (!FileUtils.GetExtension(contentType).equals(nameImage4)) {
            // Remplazamos el nombre que tiene para que no existan duplicados
            nameImage4 = file4.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
            fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage4;
            // Copiamos la imagen en la ruta especificada
            file4.write(fullPath);
            nameImagev = FileUtils.RUTE_USER_IMAGE + "/" + nameImage4;
        }
        
        Usuario user = new Usuario(Integer.parseInt(idUser, 10));

        Noticias nuevaNot = new Noticias(title, descripcion, noticia, new Categorias(idCategory),
                FileUtils.RUTE_USER_IMAGE + "/" + nameImage, FileUtils.RUTE_USER_IMAGE + "/" + nameImage2,
                FileUtils.RUTE_USER_IMAGE + "/" + nameImage3, nameImagev, user);
        NoticiasDAO.insertNews(nuevaNot);

        response.sendRedirect("indexController");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
