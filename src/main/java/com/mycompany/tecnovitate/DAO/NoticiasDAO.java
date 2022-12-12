/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.DAO;

import com.mycompany.tecnovitate.Models.Categorias;
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
public class NoticiasDAO {

    public static int insertNews(Noticias news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setNoticia(?,?,?,?,?,?,?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, news.getTitulo());
            statement.setString(2, news.getDescrip());
            statement.setString(3, news.getNoticia());
            statement.setInt(4, news.getCategoria().getId());
            statement.setString(5, news.getPath1());
            statement.setString(6, news.getPath2());
            statement.setString(7, news.getPath3());
            statement.setString(8, news.getPathv());
            statement.setInt(9, news.getUser().getIdUsua());
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

    public static List<Noticias> getNews() {
        List<Noticias> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNoticias();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                news.add(new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user));
            }
            return news;
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

        return news;
    }

    public static Noticias getNew(int idNews) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNoticia(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                String cambio = result.getString(15);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                return new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user, cambio);
            }
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

        return null;
    }

    public static List<Noticias> getNewsPendientes() {
        List<Noticias> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNotiPendientes();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                news.add(new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user));
            }
            return news;
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

        return news;
    }

    public static int setAceptado(int idNews) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setAceptado(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
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

    public static int setCancelado(int idNews, String cambio) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setCancelado(?,?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
            statement.setString(2, cambio);
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

    public static List<Noticias> getCancelados(int idCreador) {
        List<Noticias> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNotiCancelados(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idCreador);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                news.add(new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user));
            }
            return news;
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

        return news;
    }

    public static int modifNoti(Noticias news) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL modiNoti(?,?,?,?,?,?,?,?,?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, news.getTitulo());
            statement.setString(2, news.getDescrip());
            statement.setString(3, news.getNoticia());
            statement.setInt(4, news.getCategoria().getId());
            statement.setString(5, news.getPath1());
            statement.setString(6, news.getPath2());
            statement.setString(7, news.getPath3());
            statement.setString(8, news.getPathv());
            statement.setInt(9, news.getId());
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
    
    public static int setLike(int idNews) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setLikeNoticia(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
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
    
    public static int setDisike(int idNews) {
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL setDislikeNoticia(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idNews);
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
    
    public static List<Noticias> buscar(String buscar) {
        List<Noticias> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL buscarNoticia(?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, buscar);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                news.add(new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user));
            }
            return news;
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

        return news;
    }
    
    public static List<Noticias> getNewsLikes() {
        List<Noticias> news = new ArrayList<>();
        Connection con = null;
        try {
            con = DbConnection.getConnection();
            String sql = "CALL getNoticiasLikes();";
            CallableStatement statement = con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt(1);
                String title = result.getString(2);
                String description = result.getString(3);
                String noticia = result.getString(4);
                int idCategory = result.getInt(5);
                String pathImage1 = result.getString(6);
                String pathImage2 = result.getString(7);
                String pathImage3 = result.getString(8);
                String pathV = result.getString(9);
                int estado = result.getInt(10);
                int likes = result.getInt(11);
                int dislikes = result.getInt(12);
                Date fecha = result.getDate(13);
                int idUser = result.getInt(14);
                Categorias category = CategoriasDAO.getCategoria(idCategory);
                Usuario user = UsuarioDAO.IniSesion(idUser);
                news.add(new Noticias(id, title, description, noticia, category, pathImage1, pathImage2, pathImage3, pathV,
                        estado, likes, dislikes, fecha, user));
            }
            return news;
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

        return news;
    }
}
