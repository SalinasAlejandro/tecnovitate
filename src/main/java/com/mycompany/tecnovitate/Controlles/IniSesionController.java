/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.UsuarioDAO;
import com.mycompany.tecnovitate.Models.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dykeo
 */
@WebServlet(name = "IniSesionController", urlPatterns = {"/IniSesionController"})
public class IniSesionController extends HttpServlet {

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
        //                                      Deben de tener el name del input
        String correo = request.getParameter("correo");
        String contra = request.getParameter("contra");
        //La clase que se construyó en models
        Usuario user = new Usuario(correo, contra);
        Usuario logIn = UsuarioDAO.IniSesion(user);
        if (logIn == null) {
            response.sendRedirect("indexController");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("logIn",logIn);
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
    }

}
