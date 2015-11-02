package wallet.telas.frames;

import wallet.aux.Helper;
import wallet.aux.Password;
import wallet.dao.UsuarioDAO;
import wallet.models.Usuario;
import wallet.telas.TelaPrincipal;

/**
 * Classe de login.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 */
public class Login extends javax.swing.JFrame
{
    
    public Login()
    {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCPF = new javax.swing.JFormattedTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblErroAcesso = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jspSeparador = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login - Skuld");
        setLocation(new java.awt.Point(10, 50));

        try
        {
            javax.swing.text.MaskFormatter formatCPF = new javax.swing.text.MaskFormatter("###.###.###-##");

            txtCPF = new javax.swing.JFormattedTextField(formatCPF);
        }
        catch (Exception e)
        {
        }
        txtCPF.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCPFKeyReleased(evt);
            }
        });

        txtSenha.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });

        lblErroAcesso.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.setEnabled(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Ubuntu Light", 1, 40)); // NOI18N
        lblTitulo.setText("Skuld");

        btnCadastrar.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        btnCadastrar.setText("Criar conta");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jspSeparador)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblErroAcesso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrar)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)))
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspSeparador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErroAcesso)
                    .addComponent(btnCadastrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyReleased
        btnLogin.setEnabled(liberarBotaoLogin());
    }//GEN-LAST:event_txtCPFKeyReleased

    private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased
        btnLogin.setEnabled(liberarBotaoLogin());
    }//GEN-LAST:event_txtSenhaKeyReleased

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String cpf = txtCPF.getText().trim();
        
        char[] pwd = txtSenha.getPassword();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usuario = usuarioDAO.login(cpf, Password.getString(pwd));
        
        if (usuario != null)
        {
            TelaPrincipal tela = new TelaPrincipal(usuario);
            
            tela.setVisible(true);
            
            dispose();
        }
        else
        {
            lblErroAcesso.setText("Erro ao fazer login.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        CadastroUsuario cadUsuario = new CadastroUsuario(this);
        
        cadUsuario.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    private boolean liberarBotaoLogin()
    {        
        String cpf = Helper.removerMascara(txtCPF.getText().trim());
        
        char[] pwd = txtSenha.getPassword();
        
        return (Helper.validarCPF(cpf) && pwd.length >= 6);
    }
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JSeparator jspSeparador;
    private javax.swing.JLabel lblErroAcesso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
