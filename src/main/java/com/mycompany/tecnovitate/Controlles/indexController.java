/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.CategoriasDAO;
import com.mycompany.tecnovitate.DAO.NoticiasDAO;
import com.mycompany.tecnovitate.Models.Categorias;
import com.mycompany.tecnovitate.Models.Noticias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dykeo
 */
@WebServlet(name = "indexController", urlPatterns = {"/indexController"})
public class indexController extends HttpServlet {

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
        List<Noticias> noticias = NoticiasDAO.getNews();
        request.setAttribute("noticias", noticias);
        
        List<Noticias> noticiasLikes = NoticiasDAO.getNewsLikes();
        request.setAttribute("noticiasLikes", noticiasLikes);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
