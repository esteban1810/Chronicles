package modelo;

public class Estadistica {
    private int victorias;
    private int derrotas;
    private int empates;
    private int puntos;

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Estadistica{" + "victorias=" + victorias + ", derrotas=" + derrotas + ", empates=" + empates + ", puntos=" + puntos + '}';
    }
    
    
}
