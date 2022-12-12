/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.UsuarioDAO;
import com.mycompany.tecnovitate.Models.Usuario;
import com.mycompany.tecnovitate.Utils.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author dykeo
 */
@WebServlet(name = "editUsuaController", urlPatterns = {"/editUsuaController"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 25)
public class editUsuaController extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        request.getRequestDispatcher("ediUser.jsp").forward(request, response);
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
        String contraNew = request.getParameter("contra");
        HttpSession session = request.getSession();
        Usuario sesion = (Usuario) session.getAttribute("logIn");

        sesion.setNombre_Usua(request.getParameter("nomUsua"));
        sesion.setEmail(request.getParameter("correo"));
        sesion.setRedes(request.getParameter("redes"));
        sesion.setDescripcion(request.getParameter("descripcion"));
        sesion.setContraseña(request.getParameter("conf"));

        
        if (request.getPart("foto").getSize() > 0) {
            Part file = request.getPart("foto");
            String path = request.getServletContext().getRealPath("");
            File fileSaveDir = new File(path + FileUtils.RUTE_USER_IMAGE);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            String contentType = file.getContentType();
            // Remplazamos el nombre que tiene para que no existan duplicados
            String nameImage = file.getName() + System.currentTimeMillis() + FileUtils.GetExtension(contentType);
            String fullPath = path + FileUtils.RUTE_USER_IMAGE + "/" + nameImage;
            // Copiamos la imagen en la ruta especificada
            file.write(fullPath);
            sesion.setPath(FileUtils.RUTE_USER_IMAGE + "/" + nameImage);
        } else {
            sesion.setPath(request.getParameter("fotoPerfil"));
        }

        int id = sesion.getIdUsua();
        int band = UsuarioDAO.EditarUsua(sesion, contraNew);
        
        request.getSession().invalidate();
        Usuario logIn = UsuarioDAO.IniSesion(id);
        session = request.getSession();
        session.setAttribute("logIn", logIn);
        if (band == 0) {
            response.sendRedirect("editUsuaController");
        } else {
            response.sendRedirect("Perfil.jsp");
        }
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