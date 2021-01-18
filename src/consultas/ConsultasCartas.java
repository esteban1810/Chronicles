package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Carta;

public class ConsultasCartas extends Conexion{
    
    public ArrayList<Carta> todasCartas(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Carta> lista = new ArrayList();
        Carta carta;
        
        String sql = "SELECT * FROM cartas";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                carta = new Carta();
                carta.setNombre(rs.getString("nombre"));
                carta.setDescripcion(rs.getString("descripcion"));
                carta.setTipo(rs.getString("tipo"));
                carta.setAtaque(rs.getInt("pts_ataque"));
                carta.setDefensa(rs.getInt("pts_defensa"));
                carta.setMana(rs.getInt("pts_mana"));
                carta.setNivel(rs.getInt("nivel"));
                lista.add(carta);
            }
            return lista;
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
    
    public ArrayList<Carta> coincidencias(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ArrayList<Carta> lista = new ArrayList();
        Carta carta;
        
        String sql = "SELECT * FROM cartas WHERE nombre LIKE '%"+nombre+"%'";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                carta = new Carta();
                carta.setNombre(rs.getString("nombre"));
                carta.setDescripcion(rs.getString("descripcion"));
                carta.setTipo(rs.getString("tipo"));
                carta.setAtaque(rs.getInt("pts_ataque"));
                carta.setDefensa(rs.getInt("pts_defensa"));
                carta.setMana(rs.getInt("pts_mana"));
                carta.setNivel(rs.getInt("nivel"));
                lista.add(carta);
            }
            return lista;
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
    
    public Carta buscar(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Carta carta=null;
        
        
        String sql = "SELECT * FROM cartas WHERE nombre=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if(rs.next()){
                carta = new Carta();
                carta.setNombre(rs.getString("nombre"));
                carta.setDescripcion(rs.getString("descripcion"));
                carta.setTipo(rs.getString("tipo"));
                carta.setAtaque(rs.getInt("pts_ataque"));
                carta.setDefensa(rs.getInt("pts_defensa"));
                carta.setMana(rs.getInt("pts_mana"));
                carta.setNivel(rs.getInt("nivel"));
                return carta;
            }
            return carta;
        } catch (SQLException ex) {
            System.out.println(ex);
            return carta;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
}
