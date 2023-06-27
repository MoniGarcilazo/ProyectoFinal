/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author josep
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    RegistroUsuario panelUsuario = new RegistroUsuario();
    RegistroObra panelObra = new RegistroObra();
    RegistroFuncion panelFuncion = new RegistroFuncion();
    RegistroBoleto panelBoleto = new RegistroBoleto();
    Sala sala = new Sala();
    ControlPago panelPago = new ControlPago();
    Reportes panelReportes = new Reportes();

    
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnLogOut = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        jLabelFondoVentanaPrincipal3 = new javax.swing.JLabel();
        jLabelFondoVentanaPrincipal2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuRegistro = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuObra = new javax.swing.JMenuItem();
        menuFuncion = new javax.swing.JMenuItem();
        menuBarBoleto = new javax.swing.JMenu();
        menuBoleto = new javax.swing.JMenuItem();
        menuControlPago = new javax.swing.JMenu();
        menuPago = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnLogOut.setBackground(new java.awt.Color(204, 204, 204));
        BtnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        BtnLogOut.setBorder(null);
        jPanel1.add(BtnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 0, 40, 40));

        BtnSalir.setBackground(new java.awt.Color(204, 204, 204));
        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        BtnSalir.setBorder(null);
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 0, 40, 40));

        jLabelFondoVentanaPrincipal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoTeatro.jpg"))); // NOI18N

        javax.swing.GroupLayout panelContenidoLayout = new javax.swing.GroupLayout(panelContenido);
        panelContenido.setLayout(panelContenidoLayout);
        panelContenidoLayout.setHorizontalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFondoVentanaPrincipal3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1460, Short.MAX_VALUE)
        );
        panelContenidoLayout.setVerticalGroup(
            panelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenidoLayout.createSequentialGroup()
                .addComponent(jLabelFondoVentanaPrincipal3, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel1.add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1460, 720));

        jLabelFondoVentanaPrincipal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAzul.jpg"))); // NOI18N
        jPanel1.add(jLabelFondoVentanaPrincipal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, 770));

        menuBar.setBackground(new java.awt.Color(255, 255, 255));
        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        menuBar.setForeground(new java.awt.Color(0, 0, 0));
        menuBar.setBorderPainted(false);
        menuBar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        menuBar.setMaximumSize(new java.awt.Dimension(100, 32769));
        menuBar.setMinimumSize(new java.awt.Dimension(100, 21));

        menuRegistro.setBackground(new java.awt.Color(255, 255, 255));
        menuRegistro.setForeground(new java.awt.Color(0, 0, 0));
        menuRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Registro.png"))); // NOI18N
        menuRegistro.setText(" Registro   ");
        menuRegistro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        menuUsuario.setBackground(new java.awt.Color(255, 255, 255));
        menuUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        menuUsuario.setForeground(new java.awt.Color(0, 0, 0));
        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Usuario.png"))); // NOI18N
        menuUsuario.setText("Usuario");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        menuRegistro.add(menuUsuario);

        menuObra.setBackground(new java.awt.Color(255, 255, 255));
        menuObra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        menuObra.setForeground(new java.awt.Color(0, 0, 0));
        menuObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Obra.png"))); // NOI18N
        menuObra.setText("Obra Teatral");
        menuObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuObraActionPerformed(evt);
            }
        });
        menuRegistro.add(menuObra);

        menuFuncion.setBackground(new java.awt.Color(255, 255, 255));
        menuFuncion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        menuFuncion.setForeground(new java.awt.Color(0, 0, 0));
        menuFuncion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Funcion.png"))); // NOI18N
        menuFuncion.setText("Funcion");
        menuFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFuncionActionPerformed(evt);
            }
        });
        menuRegistro.add(menuFuncion);

        menuBar.add(menuRegistro);

        menuBarBoleto.setBackground(new java.awt.Color(255, 255, 255));
        menuBarBoleto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        menuBarBoleto.setForeground(new java.awt.Color(0, 0, 0));
        menuBarBoleto.setText("   Venta Boleto   ");
        menuBarBoleto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        menuBarBoleto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuBarBoleto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        menuBoleto.setText("Boleto");
        menuBarBoleto.add(menuBoleto);

        menuBar.add(menuBarBoleto);

        menuControlPago.setBackground(new java.awt.Color(255, 255, 255));
        menuControlPago.setForeground(new java.awt.Color(0, 0, 0));
        menuControlPago.setText("   Control Pago   ");
        menuControlPago.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N

        menuPago.setText("Pago");
        menuPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPagoActionPerformed(evt);
            }
        });
        menuControlPago.add(menuPago);

        menuBar.add(menuControlPago);

        menuReportes.setBackground(new java.awt.Color(255, 255, 255));
        menuReportes.setForeground(new java.awt.Color(0, 0, 0));
        menuReportes.setText("   Reportes   ");
        menuReportes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        menuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportesActionPerformed(evt);
            }
        });

        menuReporte.setText("Reporte");
        menuReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteActionPerformed(evt);
            }
        });
        menuReportes.add(menuReporte);

        menuBar.add(menuReportes);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed

    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuObraActionPerformed

    }//GEN-LAST:event_menuObraActionPerformed

    private void menuFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFuncionActionPerformed

    }//GEN-LAST:event_menuFuncionActionPerformed

    private void menuPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPagoActionPerformed

    private void menuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuReportesActionPerformed

    private void menuReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuReporteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    public JButton getBtnLogOut() {
        return BtnLogOut;
    }

    public void setBtnLogOut(JButton BtnLogOut) {
        this.BtnLogOut = BtnLogOut;
    }

    public JButton getBtnSalir() {
        return BtnSalir;
    }

    public void setBtnSalir(JButton BtnSalir) {
        this.BtnSalir = BtnSalir;
    }

    
    
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public JLabel getjLabelFondoTeatro() {
        return jLabelFondoVentanaPrincipal3;
    }

    public void setjLabelFondoTeatro(JLabel jLabelFondoTeatro) {
        this.jLabelFondoVentanaPrincipal3 = jLabelFondoTeatro;
    }

    public JPanel getPanelContenido() {
        return panelContenido;
    }

    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }

    public RegistroUsuario getPanelUsuario() {
        return panelUsuario;
    }

    public void setPanelUsuario(RegistroUsuario panelUsuario) {
        this.panelUsuario = panelUsuario;
    }

    public RegistroObra getPanelObra() {
        return panelObra;
    }

    public void setPanelObra(RegistroObra panelObra) {
        this.panelObra = panelObra;
    }

    public RegistroFuncion getPanelFuncion() {
        return panelFuncion;
    }

    public void setPanelFuncion(RegistroFuncion panelFuncion) {
        this.panelFuncion = panelFuncion;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuItem getMenuObra() {
        return menuObra;
    }

    public void setMenuObra(JMenuItem menuObra) {
        this.menuObra = menuObra;
    }

    public JMenu getMenuRegistro() {
        return menuRegistro;
    }

    public void setMenuRegistro(JMenu menuRegistro) {
        this.menuRegistro = menuRegistro;
    }

    public JMenuItem getMenuUsuario() {
        return menuUsuario;
    }

    public void setMenuUsuario(JMenuItem menuUsuario) {
        this.menuUsuario = menuUsuario;
    }

    public JMenuItem getMenuFuncion() {
        return menuFuncion;
    }

    public void setMenuFuncion(JMenuItem menuFuncion) {
        this.menuFuncion = menuFuncion;
    }

    public JMenu getMenuReportes() {
        return menuReportes;
    }

    public void setMenuReportes(JMenu menuReportes) {
        this.menuReportes = menuReportes;
    }

    public RegistroBoleto getPanelBoleto() {
        return panelBoleto;
    }

    public void setPanelBoleto(RegistroBoleto panelBoleto) {
        this.panelBoleto = panelBoleto;
    }

    public JMenu getMenuBarBoleto() {
        return menuBarBoleto;
    }

    public void setMenuBarBoleto(JMenu menuBarBoleto) {
        this.menuBarBoleto = menuBarBoleto;
    }

    public JMenuItem getMenuBoleto() {
        return menuBoleto;
    }

    public void setMenuBoleto(JMenuItem menuBoleto) {
        this.menuBoleto = menuBoleto;
    }

    public ControlPago getPanelPago() {
        return panelPago;
    }

    public void setPanelPago(ControlPago panelPago) {
        this.panelPago = panelPago;
    }

    public JMenu getMenuControlPago() {
        return menuControlPago;
    }

    public void setMenuControlPago(JMenu menuControlPago) {
        this.menuControlPago = menuControlPago;
    }

    public JMenuItem getMenuPago() {
        return menuPago;
    }

    public void setMenuPago(JMenuItem menuPago) {
        this.menuPago = menuPago;
    }

    public Reportes getPanelReportes() {
        return panelReportes;
    }

    public void setPanelReportes(Reportes panelReportes) {
        this.panelReportes = panelReportes;
    }

    public JMenuItem getMenuReporte() {
        return menuReporte;
    }

    public void setMenuReporte(JMenuItem menuReporte) {
        this.menuReporte = menuReporte;
    }



    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogOut;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JLabel jLabelFondoVentanaPrincipal2;
    private javax.swing.JLabel jLabelFondoVentanaPrincipal3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBarBoleto;
    private javax.swing.JMenuItem menuBoleto;
    private javax.swing.JMenu menuControlPago;
    private javax.swing.JMenuItem menuFuncion;
    private javax.swing.JMenuItem menuObra;
    private javax.swing.JMenuItem menuPago;
    private javax.swing.JMenu menuRegistro;
    private javax.swing.JMenuItem menuReporte;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JPanel panelContenido;
    // End of variables declaration//GEN-END:variables
}
