/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author josep
 */
public class Sala extends javax.swing.JPanel {

    public JToggleButton[][] botonesB1;
        public JToggleButton[][] botonesB2;
        public JToggleButton[][] botonesA;
        public JToggleButton[][] botonesC;
        public JLabel[][] btnB1;
        public JLabel[][] btnB2;
        public JLabel[][] btnA;
        public JLabel[][] btnC;
    
    public Sala() {
        initComponents();
    }

    public JLabel[][] getBtnB2() {
        return btnB2;
    }

    public void setBtnB2(JLabel[][] btnB2) {
        this.btnB2 = btnB2;
    }

    public JLabel[][] getBtnA() {
        return btnA;
    }

    public void setBtnA(JLabel[][] btnA) {
        this.btnA = btnA;
    }

    public JLabel[][] getBtnC() {
        return btnC;
    }

    public void setBtnC(JLabel[][] btnC) {
        this.btnC = btnC;
    }



    public JLabel[][] getBtnB1() {
        return btnB1;
    }

    public void setBtnB1(JLabel[][] btnB1) {
        this.btnB1 = btnB1;
    }
    
    

    public JButton getBtnAceptar() {
        return BtnAceptar;
    }

    public void setBtnAceptar(JButton BtnAceptar) {
        this.BtnAceptar = BtnAceptar;
    }
    
    

    public JPanel getPanelSala() {
        return panelSala;
    }

    public void setPanelSala(JPanel panelSala) {
        this.panelSala = panelSala;
    }

    
    public JToggleButton[][] getBotonesB1() {
        return botonesB1;
    }

    public void setBotonesB1(JToggleButton[][] botonesB1) {
        this.botonesB1 = botonesB1;
    }

    public JToggleButton[][] getBotonesB2() {
        return botonesB2;
    }

    public void setBotonesB2(JToggleButton[][] botonesB2) {
        this.botonesB2 = botonesB2;
    }

    public JToggleButton[][] getBotonesA() {
        return botonesA;
    }

    public void setBotonesA(JToggleButton[][] botonesA) {
        this.botonesA = botonesA;
    }

    public JToggleButton[][] getBotonesC() {
        return botonesC;
    }

    public void setBotonesC(JToggleButton[][] botonesC) {
        this.botonesC = botonesC;
    }

    
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        labelSillaSeleccion = new javax.swing.JLabel();
        jLabelSeleccion = new javax.swing.JLabel();
        labelSillaDisponible = new javax.swing.JLabel();
        jLabelDisponible = new javax.swing.JLabel();
        labelSillaOcupado = new javax.swing.JLabel();
        jLabelOcupado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelSala = new javax.swing.JPanel();
        BtnAceptar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        fondoAsientosMorado = new javax.swing.JLabel();
        fondoAsientos = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelSillaSeleccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientoSeleccionado.png"))); // NOI18N

        jLabelSeleccion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelSeleccion.setText("Selección");
        jLabelSeleccion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelSillaDisponible.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientoDisponible.png"))); // NOI18N

        jLabelDisponible.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelDisponible.setText("Disponible ");

        labelSillaOcupado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asientoOcupado.png"))); // NOI18N

        jLabelOcupado.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabelOcupado.setText("Ocupado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSillaSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSeleccion)
                .addGap(24, 24, 24)
                .addComponent(labelSillaDisponible)
                .addGap(7, 7, 7)
                .addComponent(jLabelDisponible)
                .addGap(33, 33, 33)
                .addComponent(labelSillaOcupado)
                .addGap(7, 7, 7)
                .addComponent(jLabelOcupado)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOcupado)
                    .addComponent(jLabelDisponible)
                    .addComponent(jLabelSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSillaOcupado)
                    .addComponent(labelSillaDisponible)
                    .addComponent(labelSillaSeleccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 420, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Selecciona tus asientos");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        panelSala.setBackground(new java.awt.Color(255, 255, 255));
        panelSala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelSalaLayout = new javax.swing.GroupLayout(panelSala);
        panelSala.setLayout(panelSalaLayout);
        panelSalaLayout.setHorizontalGroup(
            panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        panelSalaLayout.setVerticalGroup(
            panelSalaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        add(panelSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1280, 530));

        BtnAceptar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        BtnAceptar.setText("Aceptar");
        add(BtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1313, 650, 110, 50));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Para cambiar el lugar asignado da clic en el asiento deseado ");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        fondoAsientosMorado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fondoAsientosMorado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAmarillo.jpg"))); // NOI18N
        fondoAsientosMorado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(fondoAsientosMorado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1460, 50));

        fondoAsientos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        fondoAsientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoAzul.jpg"))); // NOI18N
        fondoAsientos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(fondoAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 720));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JLabel fondoAsientos;
    private javax.swing.JLabel fondoAsientosMorado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabelDisponible;
    private javax.swing.JLabel jLabelOcupado;
    private javax.swing.JLabel jLabelSeleccion;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelSillaDisponible;
    private javax.swing.JLabel labelSillaOcupado;
    private javax.swing.JLabel labelSillaSeleccion;
    private javax.swing.JPanel panelSala;
    // End of variables declaration//GEN-END:variables
}
