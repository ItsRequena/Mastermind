/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.Interfaz;

import javax.swing.JOptionPane;
import mastermind.*;

/**
 *
 * @author raulrodriguezlopez-rey
 */
public class Entrenar extends javax.swing.JPanel {

    /**
     * Creates new form Entrenar
     */
    private int intentos;
    private Clave clave;
    private Usuario player1;
    private Entrenamiento training;
    private int i=1;
    public Entrenar(Usuario u) {
        this.intentos=intentos;
        initComponents();
        player1 =u;
        clave=new Clave();
        training=new Entrenamiento();
        if(player1.getAdministrador()==true){
            mostrarClave.setVisible(true);
            claveLabel.setVisible(true);}
        else{
        mostrarClave.setVisible(false);
        claveLabel.setVisible(false);}
        sigRonda.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        claveLabel = new javax.swing.JLabel();
        ClaveLabel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mostrarClave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        sigRonda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Clave_Label = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ENTRENAMIENTO");

        mostrarClave.setText("Mostrar clave");
        mostrarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarClaveActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        jButton1.setText("COMENZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sigRonda.setText("Siguiente ronda");
        sigRonda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigRondaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClaveLabel1Layout = new javax.swing.GroupLayout(ClaveLabel1);
        ClaveLabel1.setLayout(ClaveLabel1Layout);
        ClaveLabel1Layout.setHorizontalGroup(
            ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClaveLabel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ClaveLabel1Layout.createSequentialGroup()
                        .addComponent(mostrarClave)
                        .addGap(18, 18, 18)
                        .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clave_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168)
                        .addComponent(sigRonda))
                    .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ClaveLabel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        ClaveLabel1Layout.setVerticalGroup(
            ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClaveLabel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Clave_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ClaveLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mostrarClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sigRonda)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ClaveLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256)
                .addComponent(claveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(claveLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(ClaveLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sigRondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigRondaActionPerformed
        i++;
        boolean acierto=false;
        acierto=training.entrenarGUI(area,clave,i,false).esGanadora(clave);
        if(acierto&&i<intentos+1){
            area.setText("ENHORABUENA,has acertado\n Has necesitado "+i+" intentos\nLa clave era "+clave.toString()+"\nFin del entrenamiento");
            sigRonda.setVisible(false);
        }
        else if(i==intentos&&!acierto){
            area.setText("Fin del entrenamiento\nLa clave era "+clave.toString());
            sigRonda.setVisible(false);
        }
    }//GEN-LAST:event_sigRondaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane pane = new JOptionPane();

        String str=pane.showInputDialog(this,"Introduce el numero de rondas","Numero de rondas");
        intentos=intentos(str);
        jButton1.setVisible(false);

        training.entrenarGUI(area,clave,1,true);
        sigRonda.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostrarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarClaveActionPerformed
        Clave_Label.setText(clave.toString());
    }//GEN-LAST:event_mostrarClaveActionPerformed
    public int intentos(String str){
    
        int valor=0;
        
        try {
            valor = Integer.parseInt(str);
         } 
        catch (NumberFormatException e) {
            System.err.println("No se puede convertir a numero");
            e.printStackTrace();
         }
        return valor;
    }
    
    public void setTexto (String s){
        area.setText(s);       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClaveLabel1;
    private javax.swing.JLabel Clave_Label;
    private javax.swing.JTextArea area;
    private javax.swing.JLabel claveLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton mostrarClave;
    private javax.swing.JButton sigRonda;
    // End of variables declaration//GEN-END:variables


}