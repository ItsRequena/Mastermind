/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind.Interfaz;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mastermind.*;
/** 
 *
 * @author raulrodriguez-lr
 */
public class PartidaGUI extends javax.swing.JPanel {
    private String id2,login2;
    public Almacen storage ;
    private InterfazMastermind interfaz;
    private Usuario player1,player2;
    private int i=1;
    private int rondas;
    int points1=0;
    int points2=0;
    Partida match;
    /**
     * Creates new form Partida
     */
    public PartidaGUI(Almacen str, Usuario player1) throws IOException, ClassNotFoundException  {
        this.interfaz = new InterfazMastermind();
        storage=str;
        rondas=3;
        
        initComponents();
        this.player1=player1;
        if(player1.getAdministrador()==true||player1.getAdministrador()==true){
            cambiarRondas.setVisible(true);
            jTextRondas.setVisible(true);
            texto.setVisible(true);
            
        }
        else{ cambiarRondas.setVisible(false);
        jTextRondas.setVisible(false);
        cambiarRondas.setVisible(false);
        texto.setVisible(false);
        }
        sigronda.setVisible(false);
        resultados.setVisible(false);
        
    }
    public void setRondas(int aux){
    rondas=aux;
    }
    
    public Almacen getAlmacen(){
    return storage;
    }
       
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jIniciarPartida = new javax.swing.JButton();
        NPartida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaP1 = new javax.swing.JTextArea();
        P1 = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        P2 = new javax.swing.JLabel();
        VS = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaP2 = new javax.swing.JTextArea();
        sigronda = new javax.swing.JButton();
        resultados = new javax.swing.JButton();
        multiusos = new javax.swing.JLabel();
        cambiarRondas = new javax.swing.JButton();
        jTextRondas = new javax.swing.JTextField();
        texto = new javax.swing.JLabel();

        jIniciarPartida.setText("INICIAR PARTIDA");
        jIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarPartidaActionPerformed(evt);
            }
        });

        NPartida.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        NPartida.setText("           PARTIDA  ");
        NPartida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        areaP1.setColumns(20);
        areaP1.setRows(5);
        jScrollPane1.setViewportView(areaP1);

        P1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N

        P2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N

        VS.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        areaP2.setColumns(20);
        areaP2.setRows(5);
        jScrollPane2.setViewportView(areaP2);

        sigronda.setText("Siguiente ronda  ");
        sigronda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigrondaActionPerformed(evt);
            }
        });

        resultados.setText("RESULTADOS");
        resultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadosActionPerformed(evt);
            }
        });

        cambiarRondas.setText("Cambiar rondas");
        cambiarRondas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarRondasActionPerformed(evt);
            }
        });

        texto.setText("Introduce el número de rondas que desee jugar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(multiusos, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sigronda)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jIniciarPartida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(VS, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(234, 234, 234))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextRondas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cambiarRondas))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(texto)
                                        .addGap(6, 6, 6))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(85, 85, 85))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(361, 361, 361))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jIniciarPartida)
                    .addComponent(NPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(VS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextRondas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiarRondas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(P2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(resultados)
                        .addComponent(sigronda))
                    .addComponent(multiusos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    //Boton de iniciar partida e inicio de sesion del jugador 2
    private void jIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarPartidaActionPerformed
        try{
            cambiarRondas.setVisible(false);
            jTextRondas.setVisible(false);
            texto.setVisible(false);

            Rival rival = new Rival();
            JOptionPane.showConfirmDialog(this,rival,"",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE);
            Usuario rivalUsuario = new Usuario(rival.getUsuario(),rival.getContraseña());
            if (rival.getUsuario().equals(player1.getNombre()) && (rival.getContraseña().equals(player1.getClave()))){
                 JOptionPane.showMessageDialog(this, "No puedes jugar contra ti mismo");
            }else{
                if (storage.ExisteNombreClave(rivalUsuario)==true){

                    player2 = storage.IdentificarUsuario(rivalUsuario);
                    JOptionPane.showMessageDialog (null,"¡Se ha identificado al jugador 2 con exito");
                    jIniciarPartida.setVisible(false);
                    VS.setText(player1.getNombre()+"  VS  "+player2.getNombre());
                    P1.setText(player1.getNombre());
                    P2.setText(player2.getNombre()); 
                    match =new Partida(rondas);
                    match.setJugador1(player1);
                    match.setJugador2(player2);

                     match.JugarPartidaGUI(areaP1,areaP2,fecha,multiusos,NPartida,i);

                     sigronda.setVisible(true);
                     jIniciarPartida.setVisible(false);                
                }else{
                    JOptionPane.showMessageDialog(this, "El usuario no esta registrado, deber registralo primero");
                }
            }
        }catch (NullPointerException ex){
              //System.out.println("NullPointerException");
              JOptionPane.showMessageDialog(this, "Se canceló la partida");
            }
    }//GEN-LAST:event_jIniciarPartidaActionPerformed

    private void sigrondaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigrondaActionPerformed
            try{
                i++;
                if(i<rondas+1){
                     match.JugarPartidaGUI(areaP1,areaP2,fecha,multiusos,NPartida,i);

                }
                else if(i==(rondas+1)){
                    sigronda.setVisible(false);
                    resultados.setVisible(true);
                }
            }catch (NullPointerException ex){
                System.out.println("pointNullException");
            }
    }//GEN-LAST:event_sigrondaActionPerformed

    private void resultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadosActionPerformed
        points1=match.getPuntosP1();
        points2=match.getPuntosP2();
        JOptionPane.showMessageDialog(null,(player1.getNombre()+" ha hecho "+points1+" y "+player2.getNombre()+" ha hecho "+points2));
        player1.setPartidas_jugadas(player1.getPartidas_jugadas()+1);
        player2.setPartidas_jugadas(player2.getPartidas_jugadas()+1);
        player1.setPuntos_anotados(player1.getPuntos_anotados()+points1);
        player1.setPuntos_encajados(player1.getPuntos_encajados()+points2);
        player2.setPuntos_anotados(player2.getPuntos_anotados()+points2);
        player2.setPuntos_encajados(player2.getPuntos_encajados()+points1);
        if(points1>points2){
            player1.setPartidas_ganadas(player1.getPartidas_ganadas()+1);
            player2.setPartidas_perdidas(player2.getPartidas_perdidas()+1);
            multiusos.setText("Fin de la partida\nEL GANADOR ES "+player1.getNombre());
        }
        else if(points1<points2){
            player2.setPartidas_ganadas(player2.getPartidas_ganadas()+1);
            player1.setPartidas_perdidas(player1.getPartidas_perdidas()+1);
            multiusos.setText("Fin de la partida\nEL GANADOR ES "+player2.getNombre());
        }
        else{
            JOptionPane.showMessageDialog(null,"Habeis quedado empate");
        }
        double porcentajeP1=(player1.getPartidas_ganadas()*100)/player1.getPartidas_jugadas();
        double porcentajeP2=(player2.getPartidas_ganadas()*100)/player2.getPartidas_jugadas();
        player1.setPorcentaje_victorias(porcentajeP1);
        player2.setPorcentaje_victorias(porcentajeP2);
        storage.addPartida(match); 
        
    }//GEN-LAST:event_resultadosActionPerformed

    private void cambiarRondasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarRondasActionPerformed
        String aux=jTextRondas.getText();
        setRondas(Rondas(aux));
    }//GEN-LAST:event_cambiarRondasActionPerformed
public int Rondas(String str){
    
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
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NPartida;
    private javax.swing.JLabel P1;
    private javax.swing.JLabel P2;
    private javax.swing.JLabel VS;
    private javax.swing.JTextArea areaP1;
    private javax.swing.JTextArea areaP2;
    private javax.swing.JButton cambiarRondas;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jIniciarPartida;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextRondas;
    private javax.swing.JLabel multiusos;
    private javax.swing.JButton resultados;
    private javax.swing.JButton sigronda;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables

    

}
