package projetobanco.View;

import projetobanco.Model.Usuario;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projetobanco.Controller.ControllerMenu;
import projetobanco.DAO.Conexao;
import projetobanco.DAO.UsuarioDAO;
import projetobanco.Model.Usuario;
import projetobanco.View.JanelaLogin;
import projetobanco.View.JanelaMenu;
import projetobanco.View.JanelaSaldo;
import java.sql.PreparedStatement;
import projetobanco.Model.Cotacoes;

/**
 *
 * @author Pedro Satoru
 */
public class JanelaMenu extends javax.swing.JFrame {

    private Usuario usuario;
    private Cotacoes cotacoes;

    private ControllerMenu control = new ControllerMenu(this);
    /**
     * Creates new form JanelaMenu
     * @param usuario
     */
    public JanelaMenu(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        System.out.println(usuario);
        labelNome.setText(usuario.getNome());
        control.abrirMenu();
        atualizarCotacoes();
    }

   private void atualizarCotacoes() {
       //atualiza as cotações ao abrir a janela de menu
       Conexao conexao = new Conexao();
        String query = "SELECT * FROM criptomoedas";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                double btc = rs.getDouble("btc");
                double eth = rs.getDouble("eth");
                double xrp = rs.getDouble("xrp");
                cotacoes = new Cotacoes(btc, eth, xrp);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma cotação encontrada no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar cotações do banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        btSaldo = new javax.swing.JButton();
        btExtrato = new javax.swing.JButton();
        btDeposito = new javax.swing.JButton();
        btSaque = new javax.swing.JButton();
        btCompra = new javax.swing.JButton();
        btVenda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Bem vindo:");

        labelNome.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        labelNome.setText("Nome");

        btSaldo.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btSaldo.setText("Saldo");
        btSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaldoActionPerformed(evt);
            }
        });

        btExtrato.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btExtrato.setText("Extrato");
        btExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExtratoActionPerformed(evt);
            }
        });

        btDeposito.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btDeposito.setText("Deposito");
        btDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositoActionPerformed(evt);
            }
        });

        btSaque.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btSaque.setText("Saque");
        btSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaqueActionPerformed(evt);
            }
        });

        btCompra.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btCompra.setText("Compra");
        btCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraActionPerformed(evt);
            }
        });

        btVenda.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btVenda.setText("Venda");
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("O que deseja fazer hoje?");

        btSair.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
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
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(btSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNome)
                .addContainerGap(192, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNome))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSaldo)
                    .addComponent(btExtrato))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDeposito)
                    .addComponent(btSaque))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCompra)
                    .addComponent(btVenda))
                .addGap(18, 18, 18)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaldoActionPerformed
        //passa a janela o usuario que fez login
        Conexao conexao = new Conexao();
        try {
        Connection conn = conexao.getConnection(); // Supondo que você tenha um método para obter a conexão
        JanelaSenhaSaque js = new JanelaSenhaSaque(usuario);
        js.setVisible(true);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro de conexão ao abrir a janela de saldo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_btSaldoActionPerformed

    private void btDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositoActionPerformed
        JanelaDeposito jd = new JanelaDeposito(this.usuario);
        jd.setVisible(true);
    }//GEN-LAST:event_btDepositoActionPerformed

    private void btSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaqueActionPerformed
        JanelaSaque jsa =new JanelaSaque(this.usuario);
        jsa.setVisible(true);
    }//GEN-LAST:event_btSaqueActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExtratoActionPerformed
        JanelaExtrato je = null;
        try {
            je = new JanelaExtrato(this.usuario);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        je.setVisible(true);
        
    }//GEN-LAST:event_btExtratoActionPerformed

    private void btCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraActionPerformed
        JanelaCompra jc = null;
        try {
            jc = new JanelaCompra(this.usuario, this.cotacoes);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jc.setVisible(true);
        
    }//GEN-LAST:event_btCompraActionPerformed

    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        JanelaVenda jv = null;
        try {
            jv = new JanelaVenda(this.usuario, this.cotacoes);
        } catch (SQLException ex) {
            Logger.getLogger(JanelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jv.setVisible(true);
    }//GEN-LAST:event_btVendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCompra;
    private javax.swing.JButton btDeposito;
    private javax.swing.JButton btExtrato;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSaldo;
    private javax.swing.JButton btSaque;
    private javax.swing.JButton btVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelNome;
    // End of variables declaration//GEN-END:variables
}
