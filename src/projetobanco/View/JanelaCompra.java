
package projetobanco.View;

import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import projetobanco.Controller.ControllerCompra;
import projetobanco.Model.Usuario;

/**
 *
 * @author Pedro Satoru
 */
public class JanelaCompra extends javax.swing.JFrame {
    
    private ControllerCompra control;
    private Usuario usuario;
    public JanelaCompra(Usuario usuario) {
        this.usuario=usuario;
        control = new ControllerCompra(this,this.usuario);
        initComponents();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JRadioButton getBtBit() {
        return btBit;
    }

    public void setBtBit(JRadioButton btBit) {
        this.btBit = btBit;
    }

    public JButton getBtComprar() {
        return btComprar;
    }

    public void setBtComprar(JButton btComprar) {
        this.btComprar = btComprar;
    }

    public JRadioButton getBtEth() {
        return btEth;
    }

    public void setBtEth(JRadioButton btEth) {
        this.btEth = btEth;
    }

    public JRadioButton getBtRip() {
        return btRip;
    }

    public void setBtRip(JRadioButton btRip) {
        this.btRip = btRip;
    }

    public JButton getBtSair() {
        return btSair;
    }

    public void setBtSair(JButton btSair) {
        this.btSair = btSair;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLbBtc() {
        return lbBtc;
    }

    public void setLbBtc(JLabel lbBtc) {
        this.lbBtc = lbBtc;
    }

    public JLabel getLbEth() {
        return lbEth;
    }

    public void setLbEth(JLabel lbEth) {
        this.lbEth = lbEth;
    }

    public JLabel getLbExp() {
        return lbExp;
    }

    public void setLbExp(JLabel lbExp) {
        this.lbExp = lbExp;
    }

   

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(JTextField txtValor) {
        this.txtValor = txtValor;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btBit = new javax.swing.JRadioButton();
        btRip = new javax.swing.JRadioButton();
        btEth = new javax.swing.JRadioButton();
        lbBtc = new javax.swing.JLabel();
        lbEth = new javax.swing.JLabel();
        lbExp = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btComprar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Qual moeda você deseja comprar?");

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

        lbBtc.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbBtc.setText("Valor bitcoin");

        lbEth.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbEth.setText("Valor Etherum");

        lbExp.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lbExp.setText("Valor rip");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Quantos reais deseja utilizar?");

        btComprar.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btComprar.setText("Comprar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btEth)
                                    .addComponent(btRip)
                                    .addComponent(btBit))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbBtc)
                                    .addComponent(lbEth)
                                    .addComponent(lbExp)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(btSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBtc)
                    .addComponent(btBit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEth)
                    .addComponent(lbEth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRip)
                    .addComponent(lbExp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btComprar)
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBitActionPerformed
      
    }//GEN-LAST:event_btBitActionPerformed

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
        control.comprarCriptomoeda(criptomoeda, valorReais);
        }catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao realizar a compra: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btComprarActionPerformed

    private void btEthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEthActionPerformed
        
    }//GEN-LAST:event_btEthActionPerformed

    private void btRipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRipActionPerformed
       
    }//GEN-LAST:event_btRipActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btBit;
    private javax.swing.JButton btComprar;
    private javax.swing.JRadioButton btEth;
    private javax.swing.JRadioButton btRip;
    private javax.swing.JButton btSair;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbBtc;
    private javax.swing.JLabel lbEth;
    private javax.swing.JLabel lbExp;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
