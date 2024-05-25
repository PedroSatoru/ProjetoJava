/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobanco.View;

import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import projetobanco.Controller.ControllerCompra;
import projetobanco.DAO.Conexao;
import projetobanco.Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import projetobanco.Controller.ControllerVenda;
import projetobanco.Model.Cotacoes;

/**
 *
 * @author Pedro Satoru
 */
public class JanelaVenda extends javax.swing.JFrame {

  private Usuario usuario;
  private Cotacoes cotacoes;
  private ControllerVenda control;
  
    /**
     *
     * @param usuario
     * @param cotacoes
     * @throws SQLException
     */
    public JanelaVenda(Usuario usuario, Cotacoes cotacoes) throws SQLException {
        this.usuario=usuario;
        control = new ControllerVenda(this,this.usuario);
        this.cotacoes=cotacoes;

        initComponents();
    }

    /**
     *
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     */
    public Cotacoes getCotacoes() {
        return cotacoes;
    }

    /**
     *
     * @param cotacoes
     */
    public void setCotacoes(Cotacoes cotacoes) {
        this.cotacoes = cotacoes;
    }

    /**
     *
     * @return
     */
    public ControllerVenda getControl() {
        return control;
    }

    /**
     *
     * @param control
     */
    public void setControl(ControllerVenda control) {
        this.control = control;
    }

    /**
     *
     * @return
     */
    public JRadioButton getBtBit() {
        return btBit;
    }

    /**
     *
     * @param btBit
     */
    public void setBtBit(JRadioButton btBit) {
        this.btBit = btBit;
    }

    /**
     *
     * @return
     */
    public JButton getBtComprar() {
        return btComprar;
    }

    /**
     *
     * @param btComprar
     */
    public void setBtComprar(JButton btComprar) {
        this.btComprar = btComprar;
    }

    /**
     *
     * @return
     */
    public JRadioButton getBtEth() {
        return btEth;
    }

    /**
     *
     * @param btEth
     */
    public void setBtEth(JRadioButton btEth) {
        this.btEth = btEth;
    }

    /**
     *
     * @return
     */
    public JRadioButton getBtRip() {
        return btRip;
    }

    /**
     *
     * @param btRip
     */
    public void setBtRip(JRadioButton btRip) {
        this.btRip = btRip;
    }

    /**
     *
     * @return
     */
    public JButton getBtSair() {
        return btSair;
    }

    /**
     *
     * @param btSair
     */
    public void setBtSair(JButton btSair) {
        this.btSair = btSair;
    }

    /**
     *
     * @return
     */
    public JButton getBtValores() {
        return btValores;
    }

    /**
     *
     * @param btValores
     */
    public void setBtValores(JButton btValores) {
        this.btValores = btValores;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     *
     * @param jLabel1
     */
    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     *
     * @param jLabel5
     */
    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtValor() {
        return txtValor;
    }

    /**
     *
     * @param txtValor
     */
    public void setTxtValor(JTextField txtValor) {
        this.txtValor = txtValor;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btComprar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btBit = new javax.swing.JRadioButton();
        btRip = new javax.swing.JRadioButton();
        btEth = new javax.swing.JRadioButton();
        btValores = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btComprar.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btComprar.setText("Vender");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Qual moeda você deseja vender?");

        btBit.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btBit.setText("BITCOIN");
        btBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBitActionPerformed(evt);
            }
        });

        btRip.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btRip.setText("RIPPLE");
        btRip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRipActionPerformed(evt);
            }
        });

        btEth.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btEth.setText("ETHERUM");
        btEth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEthActionPerformed(evt);
            }
        });

        btValores.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btValores.setText("Ver Valores");
        btValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValoresActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Quantos moedas deseja utilizar?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btRip)
                                .addComponent(btBit))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btEth)
                                    .addGap(72, 72, 72)
                                    .addComponent(btValores))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel5)))
                            .addContainerGap(129, Short.MAX_VALUE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btBit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEth)
                    .addComponent(btValores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRip)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btComprar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        String criptomoeda = "";
        if (btBit.isSelected()) {
            criptomoeda = "Bitcoin";
        } else if (btEth.isSelected()) {
            criptomoeda = "Etherum";
        } else if (btRip.isSelected()) {
            criptomoeda = "Ripple";
        }

        double valorReais = Double.parseDouble(txtValor.getText());

        try {
            control.venderCriptomoeda(criptomoeda, valorReais);
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar a compra: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btComprarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBitActionPerformed

    }//GEN-LAST:event_btBitActionPerformed

    private void btRipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRipActionPerformed

    }//GEN-LAST:event_btRipActionPerformed

    private void btEthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEthActionPerformed

    }//GEN-LAST:event_btEthActionPerformed

    private void btValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValoresActionPerformed
        JOptionPane.showMessageDialog(this, "Valor de compra das moedas\n " +"Bitcoin: R$"+ cotacoes.getBtc() +"\n" + "Etherum: R$" +  cotacoes.getEth() + "\n" +  "Ripple: R$" + cotacoes.getXrp(), "Valores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btValoresActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaVenda().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btBit;
    private javax.swing.JButton btComprar;
    private javax.swing.JRadioButton btEth;
    private javax.swing.JRadioButton btRip;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btValores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
