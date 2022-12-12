/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.DAO;

import com.mycompany.tecnovitate.Models.Comentarios;
import com.mycompany.tecnovitate.Models.Usuario;
import com.mycompany.tecnovitate.Utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dykeo
 */
public class ComentariosDAO {
    
    public static int insertCommentary(Comentarios commentary){
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setComentario(?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setString(1, commentary.getComentario());
            if(commentary.getIdUsua() == null){
                statement.setNull(2, 0);
            }
            else{
            statement.setInt(2, commentary.getIdUsua().getIdUsua());
            }
            statement.setInt(3, commentary.getIdNoticia());
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
    
    public static List<Comentarios> getCommentariesByNew(int idNews){
        List<Comentarios> commentaries = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getComentariosByNew(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt(1);
                int idUser = result.getInt(2);
                Date fecha = result.getDate(3);
                String content = result.getString(4);
                int idNew = result.getInt(5);
                int likes = result.getInt(6);
                int dislikes = result.getInt(7);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                commentaries.add(new Comentarios(id, user, fecha, content, idNew, likes, dislikes));
                
            }
            return commentaries;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return commentaries;
    }
    
    
    public static int deleteCommentary(int idCommentary){
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL eliminarComentario(?);";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setInt(1, idCommentary);
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComentariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    public static int setLike(int idCommentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setLikeCommentario(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idCommentary);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NoticiasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    public static int setDislike(int idCommentary) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setDislikeCommentario(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idCommentary);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NoticiasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
}
