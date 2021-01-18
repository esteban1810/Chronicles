package controlador;

import consultas.ConsultasCombates;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estadistica;
import vistas.Estadisticas;

public class EstadisticasCtrl implements ActionListener{
    Estadisticas est;
    Estadistica singular;
    ConsultasCombates conCombates;
    
    public EstadisticasCtrl(String nombre, String liga, Estadisticas est){
        this.est=est;
        conCombates = new ConsultasCombates();
        singular = this.conCombates.getEstadistica(nombre);
        this.llenarCampos(liga);
        
        this.est.btnCerrar.addActionListener(this);
        this.est.btnRegresar.addActionListener(this);
    }
    
    public void iniciar(){
        est.setVisible(true);
    }
    
    public void llenarCampos(String liga){
        if(singular==null)
            System.out.println(singular);
        est.txtBG.setText(String.valueOf(singular.getVictorias()));
        est.txtBE.setText(String.valueOf(singular.getEmpates()));
        est.txtBP.setText(String.valueOf(singular.getDerrotas()));
        est.txtPA.setText(String.valueOf(singular.getPuntos()));
        est.txtNivel.setText(String.valueOf(singular.getPuntos()/100));
        est.txtLiga.setText(liga);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==est.btnRegresar){
            est.setVisible(false);
        }
        else if (e.getSource()==est.btnCerrar){
            System.exit(0);
        }
    }
    
    
}
