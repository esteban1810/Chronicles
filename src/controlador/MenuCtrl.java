package controlador;

import consultas.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import modelo.*;
import vistas.*;


public class MenuCtrl implements ActionListener{
    IndexCartas index;
    Login login;
    Menu menu;
    Estadisticas est;
    Registro registro;
    ConsultasUsuario conUser = new ConsultasUsuario();
    Usuario user;
    
    public MenuCtrl(){
        index = new IndexCartas();
        est = new Estadisticas();
        menu = new Menu();
        login = new Login();
        registro = new Registro();
        
        this.login.btnlLog.addActionListener(this);
        this.login.btnReg.addActionListener(this);
        this.login.btnCerrar.addActionListener(this);
        
        this.registro.btnRegistrar.addActionListener(this);
        this.registro.btnRegresar.addActionListener(this);
        
        
        this.menu.btnCartas.addActionListener(this);
        this.menu.btnEstad.addActionListener(this);
        this.menu.btnCerrar.addActionListener(this);
        this.menu.btnCerrarS.addActionListener(this);
        
        this.index.btnRegresar.addActionListener(this);
        
        this.est.btnRegresar.addActionListener(this);
    }
    
    public void iniciar(){
        login.setVisible(true);
    }
    
    public boolean validar(){
        String correo = registro.txtCorreo.getText().trim();
        String nickname = registro.txtNickname.getText().trim();
        String pass = String.valueOf(registro.txtPass.getPassword());
        String pass2 = String.valueOf(registro.txtPassConf.getPassword()).trim();
        String nombre = String.valueOf(registro.txtNombre.getText().trim());
        
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vacio Campo Nombre");
            return false;
        }
        else if(!nombre.matches("[A-Z a-zÁÉÍÓÚñáéíóúÑ\\']+")){
            JOptionPane.showMessageDialog(null, "Nombre Invalido");
            return false;
        }
        else if(correo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vacio Campo Correo");
            return false;
        }else if(!correo.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")){
            JOptionPane.showMessageDialog(null, "Campo Invalido Correo");
            return false;
        }
        else if(conUser.buscarCorreo(correo)){
            JOptionPane.showMessageDialog(null, "Correo Existente");
            return false;
        } 
        else if(nickname.isEmpty()){
           JOptionPane.showMessageDialog(null, "Vacio Campo Nickname");
            return false;
        }
        else if(conUser.buscarNickname(nickname)){
            JOptionPane.showMessageDialog(null, "Nickname Existente");
            return false;
        }
        else if(pass.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vacio Campo Contraseña");
            return false;
        }
        else if(pass.length()<8){
            JOptionPane.showMessageDialog(null, "La contraseña debe tener como minimo 8 caracteres");
            return false;
        }
        else if(pass2.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vacio Campo Confirmar Contraseña");
            return false;
        }
        else if(!pass.equals(pass2)){
            JOptionPane.showMessageDialog(null, "Password No Coinciden");
            return false;
        }
        else if(!registro.cboxTerminos.isSelected()){
            JOptionPane.showMessageDialog(null, "Acepta los terminos y condiciones para continuar");
            return false;
        }
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==login.btnlLog){
            Encriptacion enc = new Encriptacion();
            String nickname = login.txtNickname.getText();
            String pass = String.valueOf(login.txtPass.getPassword());
            
            if(nickname.isEmpty()){
                JOptionPane.showMessageDialog(null, "Vacio Campo Nickname");
                return;
            }
            else if(pass.isEmpty()){
                JOptionPane.showMessageDialog(null, "Vacio Campo Contraseña");
                return;
            }
            
            pass = enc.encriptar(nickname, pass);
            user = conUser.buscar(login.txtNickname.getText(), pass);
            
            if(user==null){
                JOptionPane.showMessageDialog(null, "No se encontró Información Sobre El Usuario");
                return;
            }
            login.setVisible(false);
            menu.setVisible(true);
            menu.lblNickname.setText(user.getNickname());
            menu.lblPuntos.setText(String.valueOf(new ConsultasCombates().getEstadistica(user.getNickname()).getPuntos()/100));
        } 
        else if(e.getSource()==login.btnReg){
            login.setVisible(false);
            registro.setVisible(true);
        }
        else if(e.getSource()==registro.btnRegistrar){
            user = new Usuario();
            user.setLiga("Ninguna");
            Encriptacion enc = new Encriptacion();
            String cadenaE;
            if(!validar()){
                return;
            }
            
            user.setNickname(registro.txtNickname.getText().trim());
            user.setCorreo(registro.txtCorreo.getText().trim());
            user.setNombre(registro.txtNombre.getText().trim());
            cadenaE = enc.encriptar(registro.txtNickname.getText(), String.valueOf(registro.txtPass.getPassword()));
            user.setPass(cadenaE);
            conUser.registrar(user);
            registro.setVisible(false);
            menu.setVisible(true);
            menu.lblNickname.setText(user.getNickname());
        }
        else if(e.getSource()==registro.btnRegresar){
            login.setVisible(true);
            registro.setVisible(false);
        }
        else if(e.getSource()==menu.btnCartas){
            CartasCtrl ctrl = new CartasCtrl(index);
            ctrl.iniciar();
            menu.setVisible(false);
        }
        else if(e.getSource()==menu.btnEstad){
            EstadisticasCtrl ctrl = new EstadisticasCtrl(user.getNickname(),user.getLiga(),est);
            ctrl.iniciar();
            menu.setVisible(false);
            
        }
        else if(e.getSource()==est.btnRegresar){
            menu.setVisible(true);
        }
        else if(e.getSource()==index.btnRegresar){
            menu.setVisible(true);
        }
        else if(e.getSource()==menu.btnCerrarS){
            user = null;
            menu.setVisible(false);
            login.setVisible(true);
            login.txtNickname.setText(null);
            login.txtPass.setText("");
        }
        else if(e.getSource()==menu.btnCerrar){
            System.exit(0);
        }
        else if(e.getSource()==login.btnCerrar){
            System.exit(0);
        } 
    }
}
