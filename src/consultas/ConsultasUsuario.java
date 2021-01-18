package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class ConsultasUsuario extends Conexion{
    
    public boolean registrar(Usuario user){
        PreparedStatement ps;
        Connection con = getConnection();
        
        String sql = "INSERT INTO usuarios VALUES(?,default,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getNickname());
            ps.setString(3, user.getCorreo());
            ps.setString(2, user.getNombre());
            ps.setString(4, user.getPass());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public boolean buscarCorreo(String correo){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT correo FROM usuarios WHERE correo=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public boolean buscarNickname(String nickname){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT nickname FROM usuarios WHERE nickname=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public Usuario buscar(String nickname, String pass){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Usuario user;
        
        String sql = "SELECT * FROM usuarios WHERE nickname=? AND pass=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new Usuario();
                user.setNickname(rs.getString("nickname"));
                user.setLiga(rs.getString("liga"));
                user.setCorreo(rs.getString("correo"));
                user.setNombre(rs.getString("nombre"));
                user.setPass(rs.getString("pass"));
                return user;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
