package modelo;

public class Carta {
    private String nombre;
    private String descripcion;
    private String tipo;
    private int ataque;
    private int defensa;
    private int mana;
    private int nivel;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int pts_ataque) {
        this.ataque = pts_ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int pts_defensa) {
        this.defensa = pts_defensa;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int pts_mana) {
        this.mana = pts_mana;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public Object[] arreglo(){
        Object[] arreglo = new Object[5];
        
        arreglo[0]=nombre;
        arreglo[1]=tipo;
        arreglo[2]=ataque;
        arreglo[3]=defensa;
        arreglo[4]=mana;
        return arreglo;
    }
}
