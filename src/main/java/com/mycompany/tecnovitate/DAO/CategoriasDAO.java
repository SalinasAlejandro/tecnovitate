/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.DAO;

import com.mycompany.tecnovitate.Models.Categorias;
import com.mycompany.tecnovitate.Utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
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
public class CategoriasDAO {
    public static List<Categorias> getCategorias(){
        List<Categorias> categories = new ArrayList<>();
        Connection con = null;
        try{
            con = DbConnection.getConnection();
            String sql = "CALL getCategorias();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery(); 
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                categories.add(new Categorias(id, name));
            }
            return categories;
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categories;
    }
    
    public static Categorias getCategoria(int idCategory){
        Connection con = null;
        try{
            con = DbConnection.getConnection();
            String sql = "CALL getCategoria(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idCategory);
            ResultSet result = statement.executeQuery(); 
            while(result.next()){
                int id = result.getInt(1);
                String name = result.getString(2);
                return new Categorias(id, name);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
