package controlador;

import consultas.ConsultasCartas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Carta;
import vistas.*;

public class CartasCtrl implements ActionListener, MouseListener{
    IndexCartas index;
    FormCarta form;
    DefaultTableModel modelo;
    ArrayList<Carta> lista;
    ConsultasCartas conCartas;
    Carta carta;
    int fila;
    int cont;
    
    public CartasCtrl(IndexCartas index){
        cont=-1;
        form = new FormCarta();
        conCartas = new ConsultasCartas();
        lista = conCartas.todasCartas();
        this.index = index;
        
        index.btnBuscar.addActionListener(this);
        index.btnMostrar.addActionListener(this);
        index.btnTodo.addActionListener(this);
        index.btnRegresar.addActionListener(this);
        index.btnCerrar.addActionListener(this);
        
        form.btnRegresar.addActionListener(this);
        form.btnCerrar.addActionListener(this);
        
        index.tbCartas.addMouseListener(this);
        
        index.btnBuscar.setVisible(false);
        index.txtBuscar.setVisible(false);
        index.btnTodo.setVisible(false);
        index.btnMostrar.setVisible(false);
        
    }
    
    public void iniciar(){
        index.setVisible(true);
        cargarTabla();
    }
    
    public void cargarTabla(){
       modelo = new DefaultTableModel(){
           @Override
           public boolean isCellEditable(int i, int i1) {
               return false; //To change body of generated methods, choose Tools | Templates.
           }
       };
       index.tbCartas.setModel(modelo);
       
       if(lista==null)
           return;

       modelo.addColumn("Nombre");
       modelo.addColumn("Tipo");
       modelo.addColumn("Ataque");
       modelo.addColumn("Defensa");
       modelo.addColumn("Mana");

       Object[] fila = new Object[5];

       for(int i=0; i<lista.size(); i++){
           fila = lista.get(i).arreglo();
           modelo.addRow(fila);
       }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==index.btnRegresar){
            index.setVisible(false);
        }
        else if(e.getSource()==index.btnBuscar){
            lista = conCartas.coincidencias(index.txtBuscar.getText());
            cargarTabla();
        }
        else if(e.getSource()==index.btnTodo){
            lista = conCartas.todasCartas();
            this.cargarTabla();
        }
        else if(e.getSource()==index.btnMostrar){
            int fila = index.tbCartas.getSelectedRow();
            String nombre;
            
            if (fila == -1) {
                return;
            }
            nombre = index.tbCartas.getValueAt(fila, 0).toString();
            carta = conCartas.buscar(nombre);
            index.setVisible(false);
            form.setVisible(true);
            
            form.txtNombre.setText(carta.getNombre());
            form.txtTipo.setText(String.valueOf(carta.getTipo()));
            form.txtAtaque.setText(String.valueOf(carta.getAtaque()));
            form.txtDefensa.setText(String.valueOf(carta.getDefensa()));
            form.txtMana.setText(String.valueOf(carta.getMana()));
            form.textADesc.append("hola como vamos");
        } else if(e.getSource()== index.btnCerrar){
            System.exit(0);
        }
        else if(e.getSource()==form.btnRegresar){
            index.setVisible(true);
            form.setVisible(false);
        } 
        else if(e.getSource()==form.btnCerrar){
            System.exit(0);
        }
        else if(e.getSource()==form.btnCerrar){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(me.getSource()==index.tbCartas){
            int fila = index.tbCartas.getSelectedRow();
            if(fila==-1){
                return;
            } 
            if(this.fila==-1){
                this.fila=fila;
            } else {
                if(this.fila==fila){
                    this.fila=-1;
                    String nombre = index.tbCartas.getValueAt(fila, 0).toString();
                    carta = conCartas.buscar(nombre);
                    index.setVisible(false);
                    form.setVisible(true);

                    form.txtNombre.setText(carta.getNombre());
                    form.txtTipo.setText(String.valueOf(carta.getTipo()));
                    form.txtAtaque.setText(String.valueOf(carta.getAtaque()));
                    form.txtDefensa.setText(String.valueOf(carta.getDefensa()));
                    form.txtMana.setText(String.valueOf(carta.getMana()));
                    form.textADesc.setText(String.valueOf(carta.getDescripcion()));
                    int fin = 40;
                    while(fin<form.textADesc.getText().length()){
                        fin = form.textADesc.getText().indexOf(" ",fin)+1;
                        if(fin==-1)
                            return;
                        form.textADesc.insert("\n", fin);
                        fin+=40;
                    }
                } else {
                    this.fila=fila;
                }
            }
            
        } 
    }

    @Override
    public void mousePressed(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
