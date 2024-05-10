/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetobanco.View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import projetobanco.Controller.ControllerCadastro;

/**
 *
 * @author Pedro Satoru
 */
public class JanelaCriaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form JanelaCriaUsuario
     */
    public JanelaCriaUsuario() {
        initComponents();
        controller = new ControllerCadastro(this);
    }

    public JButton getBtCriaUsuario() {
        return btCriaUsuario;
    }

    public void setBtCriaUsuario(JButton btCriaUsuario) {
        this.btCriaUsuario = btCriaUsuario;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getLabelNome() {
        return labelNome;
    }

    public void setLabelNome(JLabel labelNome) {
        this.labelNome = labelNome;
    }

    public JTextField getTxtEntrada_cpf() {
        return txtEntrada_cpf;
    }

    public void setTxtEntrada_cpf(JTextField txtEntrada_cpf) {
        this.txtEntrada_cpf = txtEntrada_cpf;
    }

    public JTextField getTxtEntrada_nome() {
        return txtEntrada_nome;
    }

    public void setTxtEntrada_nome(JTextField txtEntrada_nome) {
        this.txtEntrada_nome = txtEntrada_nome;
    }

    public JTextField getTxtEntrada_senha() {
        return txtEntrada_senha;
    }

    public void setTxtEntrada_senha(JTextField txtEntrada_senha) {
        this.txtEntrada_senha = txtEntrada_senha;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        txtEntrada_cpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEntrada_senha = new javax.swing.JTextField();
        btCriaUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada_nome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNome.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        labelNome.setText("Nome Completo:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel2.setText("Senha:");

        btCriaUsuario.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btCriaUsuario.setText("Criar Usuário");
        btCriaUsuario.setToolTipText("");
        btCriaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriaUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel3.setText("CPF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtEntrada_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEntrada_cpf)
                                    .addComponent(txtEntrada_senha)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btCriaUsuario)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEntrada_nome)
                        .addGap(2, 2, 2))
                    .addComponent(labelNome))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEntrada_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntrada_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(49, 49, 49)
                .addComponent(btCriaUsuario)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCriaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriaUsuarioActionPerformed
        controller.salvarUsuario();
        this.dispose();
    }//GEN-LAST:event_btCriaUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(JanelaCriaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaCriaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaCriaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaCriaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaCriaUsuario().setVisible(true);
//            }
//        });
//    }
private ControllerCadastro controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCriaUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField txtEntrada_cpf;
    private javax.swing.JTextField txtEntrada_nome;
    private javax.swing.JTextField txtEntrada_senha;
    // End of variables declaration//GEN-END:variables
}
