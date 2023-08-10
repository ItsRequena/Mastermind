package mastermind.Interfaz;

import java.io.IOException;
import mastermind.*;

public class MisPartidas extends javax.swing.JPanel {
    Almacen storage;
    InterfazMastermind interfaz;
    Usuario player2;
    boolean completa;
    
    public MisPartidas(Almacen str,Usuario u, boolean completa) throws IOException, ClassNotFoundException {
        initComponents();
        interfaz = new InterfazMastermind();
        storage=str;
        player2=u;
        this.completa=completa;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        matchList = new javax.swing.JTextArea();

        jButton1.setText("Mostrar mis partidas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        matchList.setColumns(20);
        matchList.setRows(5);
        jScrollPane1.setViewportView(matchList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String aux="";
        
       if(completa == true){
            aux=storage.leerListaPartidas(player2,true);
            matchList.setText(aux);
                   }
       else if(completa == false){
            aux=storage.leerListaPartidas(player2,false);
            matchList.setText(aux);
       }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed
    public void setTexto (String s){
        matchList.setText(s);       
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea matchList;
    // End of variables declaration//GEN-END:variables
}
