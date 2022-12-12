/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.DAO;

import com.mycompany.tecnovitate.Models.Usuario;
import com.mycompany.tecnovitate.Utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dykeo
 */
public class UsuarioDAO {

    public static int Registrarse(Usuario user) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
//                                                      Stored procedure hecho
            CallableStatement statement = con.prepareCall("CALL registrarse(?,?,?,?);");
            statement.setString(1, user.getNombre_Usua());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getContraseña());
            statement.setString(4, "assets/image/anonimo.jpg");
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    public static Usuario IniSesion(Usuario user) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            //                                              Stored procedure hecho
            CallableStatement statement = con.prepareCall("CALL iniSesion(?,?);");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getContraseña());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String nomUsua = result.getString(2);
                String correo = result.getString(3);
                String contra = result.getString(4);
                String redes = result.getString(5);
                String avatar = result.getString(6);
                String desc = result.getString(7);
                int tipo = result.getInt(8);
                return new Usuario(id, nomUsua, correo, contra, redes, avatar, desc, tipo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
    
    public static int EditarUsua(Usuario user, String contraNew) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
//                                                      Stored procedure hecho
            CallableStatement statement = con.prepareCall("CALL editarUsua(?,?,?,?,?,?,?,?);");
            statement.setString(1, user.getNombre_Usua());
            statement.setString(2, user.getEmail());
            statement.setString(3, contraNew);
            statement.setString(4, user.getRedes());
            statement.setString(5, user.getPath());
            statement.setString(6, user.getDescripcion());
            statement.setInt(7, user.getIdUsua());
            statement.setString(8, user.getContraseña());
            
            return statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    
    public static Usuario IniSesion(int idUser) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            //                                              Stored procedure hecho
            CallableStatement statement = con.prepareCall("CALL iniSesionId(?);");
            statement.setInt(1, idUser);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String nomUsua = result.getString(2);
                String correo = result.getString(3);
                String contra = result.getString(4);
                String redes = result.getString(5);
                String avatar = result.getString(6);
                String desc = result.getString(7);
                int tipo = result.getInt(8);
                return new Usuario(id, nomUsua, correo, contra, redes, avatar, desc, tipo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
