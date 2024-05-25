
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
import projetobanco.Model.Cotacoes;

/**
 *
 * @author Pedro Satoru
 */
public class JanelaCompra extends javax.swing.JFrame {
    
    private ControllerCompra control;
    private Usuario usuario;
    private Cotacoes cotacoes;
    
    /**
     *
     * @param usuario
     * @param cotacoes
     * @throws SQLException
     */
    public JanelaCompra(Usuario usuario, Cotacoes cotacoes) throws SQLException {
        this.usuario=usuario;
        this.cotacoes=cotacoes;
        control = new ControllerCompra(this,this.usuario);
       
        initComponents();
        
        
    }

    /**
     *
     * @return
     */
    public ControllerCompra getControl() {
        return control;
    }

    /**
     *
     * @param control
     */
    public void setControl(ControllerCompra control) {
        this.control = control;
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
    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    /**
     *
     * @param buttonGroup1
     */
    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btBit = new javax.swing.JRadioButton();
        btRip = new javax.swing.JRadioButton();
        btEth = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btComprar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        btValores = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Qual moeda você deseja comprar?");

        buttonGroup1.add(btBit);
        btBit.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btBit.setText("BITCOIN");
        btBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBitActionPerformed(evt);
            }
        });

        buttonGroup1.add(btRip);
        btRip.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btRip.setText("RIPPLE");
        btRip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRipActionPerformed(evt);
            }
        });

        buttonGroup1.add(btEth);
        btEth.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btEth.setText("ETHERUM");
        btEth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEthActionPerformed(evt);
            }
        });

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

        btValores.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btValores.setText("Ver Valores");
        btValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValoresActionPerformed(evt);
            }
        });

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
                            .addGap(0, 339, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btEth)
                                    .addGap(72, 72, 72)
                                    .addComponent(btValores))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel5)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 218, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
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
                .addGap(18, 18, 18)
                .addComponent(btSair)
                .addContainerGap(21, Short.MAX_VALUE))
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
    }this.dispose();

    }//GEN-LAST:event_btComprarActionPerformed

    private void btEthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEthActionPerformed
        
    }//GEN-LAST:event_btEthActionPerformed

    private void btRipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRipActionPerformed
       
    }//GEN-LAST:event_btRipActionPerformed

    private void btValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValoresActionPerformed
        JOptionPane.showMessageDialog(this, "Valor de compra das moedas\n " +"Bitcoin: R$"+ cotacoes.getBtc() +"\n" + "Etherum: R$" +  cotacoes.getEth() + "\n" +  "Ripple: R$" + cotacoes.getXrp(), "Valores", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btValoresActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btBit;
    private javax.swing.JButton btComprar;
    private javax.swing.JRadioButton btEth;
    private javax.swing.JRadioButton btRip;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btValores;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
