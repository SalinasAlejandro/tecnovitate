/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.DAO;

import com.mycompany.tecnovitate.Models.Comentarios;
import com.mycompany.tecnovitate.Models.Favs;
import com.mycompany.tecnovitate.Models.Noticias;
import com.mycompany.tecnovitate.Models.Usuario;
import com.mycompany.tecnovitate.Utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dykeo
 */
public class FavsDAO {
    public static int insertFavs(Favs favs){
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setFav(?,?);";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setInt(1, favs.getIdUser());
            statement.setInt(2, favs.getIdNoti().getId());
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
    public static List<Favs> getFavs(int idUser){
        List<Favs> favs = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getFavs(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idUser);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt(1);
                idUser = result.getInt(2);
                int idNew = result.getInt(3);
                Noticias noti = NoticiasDAO.getNew(idNew);
                favs.add(new Favs(id, idUser, noti));
                
            }
            return favs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return favs;
    }
    
    public static int deleteFav(int idFav){
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL eliminarFav(?);";
            CallableStatement statement = con.prepareCall(sql);
            
            statement.setInt(1, idFav);
            
            return statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
    public static List<Favs> getFavsAll(){
        List<Favs> favs = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getFavsAll();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                int id = result.getInt(1);
                int idUser = result.getInt(2);
                int idNew = result.getInt(3);
                Noticias noti = NoticiasDAO.getNew(idNew);
                favs.add(new Favs(id, idUser, noti));
                
            }
            return favs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavsDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return favs;
    }
}
