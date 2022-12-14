/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Controlles;

import com.mycompany.tecnovitate.DAO.ComentariosDAO;
import com.mycompany.tecnovitate.DAO.FavsDAO;
import com.mycompany.tecnovitate.DAO.NoticiasDAO;
import com.mycompany.tecnovitate.Models.Comentarios;
import com.mycompany.tecnovitate.Models.Favs;
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
@WebServlet(name = "NoticiaMostrarController", urlPatterns = {"/NoticiaMostrarController"})
public class NoticiaMostrarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idNews = request.getParameter("id");
        String id = request.getParameter("idUser");

        Noticias noticia = NoticiasDAO.getNew(Integer.parseInt(idNews, 10));
        request.setAttribute("noticia", noticia);

        List<Comentarios> commentaries = ComentariosDAO.getCommentariesByNew(Integer.parseInt(idNews, 10));
        request.setAttribute("Commentaries", commentaries);
        
        List<Favs> favs = null;
        if (id.equals("") || id.equals(null)) {
            favs = FavsDAO.getFavsAll();
        } else {
            favs = FavsDAO.getFavs(Integer.parseInt(id, 10));
        }
        request.setAttribute("favs", favs);

        request.getRequestDispatcher("Noticia.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="S??lo GET usado">
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
        String idNews = request.getParameter("id");
        String id = request.getParameter("idUser");

        Noticias noticia = NoticiasDAO.getNew(Integer.parseInt(idNews, 10));
        request.setAttribute("noticia", noticia);

        List<Comentarios> commentaries = ComentariosDAO.getCommentariesByNew(Integer.parseInt(idNews, 10));
        request.setAttribute("Commentaries", commentaries);
        
        List<Favs> favs = null;
        if (id.equals("") || id.equals(null)) {
            favs = FavsDAO.getFavsAll();
        } else {
            favs = FavsDAO.getFavs(Integer.parseInt(id, 10));
        }
        request.setAttribute("favs", favs);

        request.getRequestDispatcher("Noticia.jsp").forward(request, response);
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
        processRequest(request, response);
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
