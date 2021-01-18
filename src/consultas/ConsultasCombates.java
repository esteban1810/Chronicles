package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Estadistica;

public class ConsultasCombates extends Conexion{
    
    public Estadistica getCombatesJ1(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        Estadistica est=null;
        
        
        String sql = "SELECT sum(victoria) as victorias, "
                + "sum(derrota) as derrotas, sum(empate) as empates, "
                + "sum(puntos_j1) as puntos from combates where jugador1=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if(rs.next()){
                est = new Estadistica();
                est.setVictorias(rs.getInt("victorias"));
                est.setDerrotas(rs.getInt("derrotas"));
                est.setEmpates(rs.getInt("empates"));
                est.setPuntos(rs.getInt("puntos"));
                return est;
            }
            return est;
        } catch (SQLException ex) {
            System.out.println(ex);
            return est;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public Estadistica getEstadistica(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Estadistica est=this.getCombatesJ1(nombre);
        Connection con = getConnection();
        
        String sql = "SELECT sum(derrota) as victorias, "
                + "sum(victoria) as derrotas, sum(empate) as empates, "
                + "sum(puntos_j2) as puntos from combates where jugador2=?";

        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(est==null){
                    est = new Estadistica();
                }
                est.setVictorias(est.getVictorias()+rs.getInt("victorias"));
                est.setDerrotas(est.getDerrotas()+rs.getInt("derrotas"));
                est.setEmpates(est.getEmpates()+rs.getInt("empates"));
                est.setPuntos(est.getPuntos()+rs.getInt("puntos"));
                return est;
            }
            return est;
        } catch (SQLException ex) {
            System.out.println(ex);
            return est;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
