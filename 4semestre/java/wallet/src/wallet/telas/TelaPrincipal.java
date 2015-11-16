package wallet.telas;

import javax.swing.JFrame;
import wallet.models.Usuario;

/**
 * Tela principal para abertura da janela.
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class TelaPrincipal extends javax.swing.JFrame
{
    public static Usuario USER = null;

    public TelaPrincipal()
    {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public TelaPrincipal(Usuario usuario)
    {
        this();
        
        USER = usuario;
        
        this.setTitle(getUsuario().getPrimeiroNome() + " "
                + getUsuario().getSegundoNome() + " - Skuld");
    }
    
    private Usuario getUsuario()
    {
        return USER;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new wallet.telas.AreaDeTrabalho();
        mnbMenu = new javax.swing.JMenuBar();
        jmnCadastro = new javax.swing.JMenu();
        jmiUsuario = new javax.swing.JMenuItem();
        jmiCartao = new javax.swing.JMenuItem();
        jmnConsulta = new javax.swing.JMenu();
        jmiUsuarioCons = new javax.swing.JMenuItem();
        jmiCartaoCons = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wallet!");
        setMinimumSize(new java.awt.Dimension(800, 400));
        setName("frmWallet"); // NOI18N
        setSize(new java.awt.Dimension(300, 300));
        getContentPane().add(dskPrincipal, java.awt.BorderLayout.CENTER);

        jmnCadastro.setText("Cadastros");

        jmiUsuario.setText("Usuário");
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiUsuario);

        jmiCartao.setText("Cartão de Cartão");
        jmiCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCartaoActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiCartao);

        mnbMenu.add(jmnCadastro);

        jmnConsulta.setText("Consultas");

        jmiUsuarioCons.setText("Usuários");
        jmiUsuarioCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioConsActionPerformed(evt);
            }
        });
        jmnConsulta.add(jmiUsuarioCons);

        jmiCartaoCons.setText("Cartões");
        jmiCartaoCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCartaoConsActionPerformed(evt);
            }
        });
        jmnConsulta.add(jmiCartaoCons);

        mnbMenu.add(jmnConsulta);

        setJMenuBar(mnbMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioActionPerformed
        dskPrincipal.abrirCadastroUsuario();
    }//GEN-LAST:event_jmiUsuarioActionPerformed

    private void jmiCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCartaoActionPerformed
        dskPrincipal.abrirCadastroCartao();
    }//GEN-LAST:event_jmiCartaoActionPerformed

    private void jmiUsuarioConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuarioConsActionPerformed
        dskPrincipal.abrirConsultaUsuario();
    }//GEN-LAST:event_jmiUsuarioConsActionPerformed

    private void jmiCartaoConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCartaoConsActionPerformed
        dskPrincipal.abrirConsultaCartao();
    }//GEN-LAST:event_jmiCartaoConsActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private wallet.telas.AreaDeTrabalho dskPrincipal;
    private javax.swing.JMenuItem jmiCartao;
    private javax.swing.JMenuItem jmiCartaoCons;
    private javax.swing.JMenuItem jmiUsuario;
    private javax.swing.JMenuItem jmiUsuarioCons;
    private javax.swing.JMenu jmnCadastro;
    private javax.swing.JMenu jmnConsulta;
    private javax.swing.JMenuBar mnbMenu;
    // End of variables declaration//GEN-END:variables
}
