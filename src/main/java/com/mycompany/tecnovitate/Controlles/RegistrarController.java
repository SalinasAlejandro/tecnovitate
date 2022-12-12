/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.UsuarioDAO;
import com.mycompany.tecnovitate.Models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dykeo
 */
@WebServlet(name = "RegistrarController", urlPatterns = {"/RegistrarController"})
public class RegistrarController extends HttpServlet {

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
        String nombUsua = request.getParameter("nombUsua");
        if (nombUsua.length() > 2 && nombUsua.length() < 26) {
            String correo = request.getParameter("correo");
            String contra = request.getParameter("contra");
            if (contra.length() > 7 && contra.length() < 31) {
                int may = 0, min = 0, num = 0;

                for (int i = 0; i < contra.length(); i++) {
                    int clave = contra.charAt(i);
                    if(clave > 47 && clave < 58){
                        num++;
                    } else if(clave > 64 && clave < 91){
                        may++;
                    } else if(clave > 96 && clave < 123){
                        min++;
                    }
                }
                if (may > 0 && min > 0 && num > 0) {
                    Usuario user = new Usuario(nombUsua, correo, contra);
                    if (UsuarioDAO.Registrarse(user) == 1) {
                        response.sendRedirect("indexController");
                    } else {
                        response.sendRedirect("Registrar.jsp");
                    }
                } else {
                    response.sendRedirect("Registrar.jsp");
                }
            } else {
                response.sendRedirect("Registrar.jsp");
            }
        } else {
            response.sendRedirect("Registrar.jsp");
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
