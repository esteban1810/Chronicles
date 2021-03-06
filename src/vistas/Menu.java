/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author ESTEBAN SG
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEstad = new javax.swing.JButton();
        btnBatalla = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        lblNickname = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCartas = new javax.swing.JButton();
        btnCerrarS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(64, 239, 175));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEstad.setBackground(new java.awt.Color(79, 224, 66));
        btnEstad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/graph-5_icon-icons.com_58023.png"))); // NOI18N
        jPanel1.add(btnEstad, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, 110, 110));

        btnBatalla.setBackground(new java.awt.Color(9, 253, 127));
        btnBatalla.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBatalla.setForeground(new java.awt.Color(255, 255, 255));
        btnBatalla.setText("Batalla");
        jPanel1.add(btnBatalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconfinder-gymfightpunchboxing-glovessports-and-competitionboxingathleteolympictrainingglovessport-4394759_119509.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 256, 256));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estadisticas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cartas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        btnCerrar.setBackground(new java.awt.Color(79, 224, 66));
        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 60, 40));

        lblNickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNickname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 250, 40));

        lblPuntos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPuntos.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 110, 40));

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 40));

        btnCartas.setBackground(new java.awt.Color(79, 224, 66));
        btnCartas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/three-cards_icon-icons.com_68473.png"))); // NOI18N
        jPanel1.add(btnCartas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 110, 110));

        btnCerrarS.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrarS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrarS.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarS.setText("Cerrar Sesión");
        jPanel1.add(btnCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 503, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBatalla;
    public javax.swing.JButton btnCartas;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCerrarS;
    public javax.swing.JButton btnEstad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblNickname;
    public javax.swing.JLabel lblPuntos;
    // End of variables declaration//GEN-END:variables
}
