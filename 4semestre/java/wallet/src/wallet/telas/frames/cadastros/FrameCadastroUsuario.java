package wallet.telas.frames.cadastros;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;
import wallet.aux.Helper;
import wallet.models.Usuario;
import wallet.telas.AreaDeTrabalho;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class FrameCadastroUsuario extends javax.swing.JInternalFrame {
    
    private Usuario _usuario = null;

    /**
     * Creates new form FrameCadastroUsuario
     */
    public FrameCadastroUsuario() {
        initComponents();
        
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnCadastrar.setEnabled(true);
        
        setTitle("Cadastro de Usuários");
    }
    
    public FrameCadastroUsuario(Usuario user)
    {
        this();
        
        preencherAlterar(user);
        
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCadastrar.setEnabled(false);
        
        setTitle("Edição de Usuários");
        
        _usuario = user;
    }
    
    private void preencherAlterar(Usuario user)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        txtCPF.setValue(user.getCPF());
        txtNome.setText(user.getNome());
        txtNascimento.setValue(df.format(user.getNascimento()));
        txtEmail.setText(user.getEmail());
        txtEndereco.setText(user.getEndereco());
        txtBairro.setText(user.getBairro());
        txtCEP.setValue(user.getCEP());
        txtCidade.setText(user.getCidade());
        cbbUF.setSelectedItem(user.getUF());
        txtRenda.setText(Double.toString(user.getRenda()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCPF = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblUF = new javax.swing.JLabel();
        lblRenda = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        txtNascimento = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtRenda = new wallet.aux.swing.text.JNumberFormatField();
        cbbUF = new javax.swing.JComboBox();
        lblExtraInfo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Usuários");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formCadastroUsuarioClose(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        lblCPF.setText("CPF");

        lblNome.setText("Nome");

        lblEmail.setText("Email");

        lblEndereco.setText("Endereço");

        lblBairro.setText("Bairro");

        lblCEP.setText("CEP");

        lblCidade.setText("Cidade");

        lblUF.setText("UF");

        lblRenda.setText("Renda");

        lblNascimento.setText("Nascimento");

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        try
        {
            javax.swing.text.MaskFormatter formatCPF = new javax.swing.text.MaskFormatter("###.###.###-##");

            txtCPF = new javax.swing.JFormattedTextField(formatCPF);
        }
        catch (Exception e)
        {
        }
        txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFFocusLost(evt);
            }
        });

        try
        {
            javax.swing.text.MaskFormatter formatNasc = new javax.swing.text.MaskFormatter("##/##/####");

            txtNascimento = new javax.swing.JFormattedTextField(formatNasc);
        }
        catch (Exception e)
        {
        }

        try
        {
            javax.swing.text.MaskFormatter formatCEP = new javax.swing.text.MaskFormatter("#####-###");

            txtCEP = new javax.swing.JFormattedTextField(formatCEP);
        }
        catch (Exception e)
        {
        }

        cbbUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEndereco)
                            .addComponent(lblCEP)
                            .addComponent(lblCPF)
                            .addComponent(lblNome)
                            .addComponent(lblEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCidade)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCidade))
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(lblBairro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblUF)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbUF, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                        .addComponent(lblNascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNome))
                                .addGap(209, 209, 209))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRenda)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrar)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(txtRenda, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExtraInfo)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(lblNascimento)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEP)
                    .addComponent(lblUF)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRenda)
                    .addComponent(txtRenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblExtraInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        setBounds(0, 0, 669, 349);
    }// </editor-fold>//GEN-END:initComponents

    private void formCadastroUsuarioClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formCadastroUsuarioClose
        JDesktopPane dsk = getDesktopPane();
        
        ((AreaDeTrabalho) dsk).fecharCadastroUsuario();
    }//GEN-LAST:event_formCadastroUsuarioClose

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (!EmailValidator.getInstance().isValid(txtEmail.getText().trim()))
        {
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusLost
        if (Helper.removerMascara(txtCPF.getText().trim()).length() > 6)
        {
            if (_usuario == null
                    && !Helper.validarCPF(Helper.removerMascara(txtCPF.getText().trim())))
            {
                JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro",
                                        JOptionPane.ERROR_MESSAGE);

                txtCPF.setValue("");
                txtCPF.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCPFFocusLost

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validarCadastro())
        {
            Usuario usuario = new Usuario();
            
            usuario.setCPF(txtCPF.getValue().toString());
            usuario.setNascimento(txtNascimento.getValue().toString());
            usuario.setNome(txtNome.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setEndereco(txtEndereco.getText());
            usuario.setBairro(txtBairro.getText());
            usuario.setCEP(txtCEP.getValue().toString());
            usuario.setCidade(txtCidade.getText());
            usuario.setUF(cbbUF.getSelectedItem().toString());
            usuario.setRenda(Double.parseDouble(txtRenda.getText().trim()
                .replaceAll("\\.", "").replaceAll(",", ".")));
            
            if (Usuario.existeUsuario(usuario.getCPF()))
            {
                Helper.mostrarMensagem("Cliente já existente!", Color.ORANGE, lblExtraInfo);
            }
            else
            {
                AreaDeTrabalho.setUsuario(usuario);
                
                Helper.mostrarMensagem("Cliente cadastrado com sucesso!", Color.GREEN, lblExtraInfo);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (validarCadastro())
        {
            if (!Usuario.existeUsuario(txtCPF.getValue().toString()))
            {
                Helper.mostrarMensagem("Cliente não existente!", Color.RED, lblExtraInfo);
            }
            else
            {
                Usuario usuario = _usuario;
            
                usuario.setCPF(txtCPF.getValue().toString());
                usuario.setNascimento(txtNascimento.getValue().toString());
                usuario.setNome(txtNome.getText());
                usuario.setEmail(txtEmail.getText());
                usuario.setEndereco(txtEndereco.getText());
                usuario.setBairro(txtBairro.getText());
                usuario.setCEP(txtCEP.getValue().toString());
                usuario.setCidade(txtCidade.getText());
                usuario.setUF(cbbUF.getSelectedItem().toString());
                usuario.setRenda(Double.parseDouble(txtRenda.getText().trim()
                    .replaceAll("\\.", "").replaceAll(",", ".")));
                
                Helper.mostrarMensagem("Cliente alterado com sucesso!", Color.GREEN, lblExtraInfo);
                
                setTitle("Cadastro de Usuários");
                
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                btnCadastrar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        AreaDeTrabalho.getUsuarios().remove(_usuario);
        
        Helper.mostrarMensagem("Cliente removido!", Color.RED, lblExtraInfo);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void limparFormulario()
    {
        
    }
    
    private boolean validarCadastro()
    {
        if (!Helper.validarCPF(txtCPF.getValue()))
        {
            Helper.mostrarMensagem("Informe um CPF", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtNascimento.getValue() == null)
        {
            Helper.mostrarMensagem("Informe a data de nascimento", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtNome.getText().trim().length() == 0)
        {
            Helper.mostrarMensagem("Informe o seu nome", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        // Não é necessário validar com Regex, pois se estiver errado ele apaga o campo.
        if (txtEmail.getText().trim().length() == 0)
        {
            Helper.mostrarMensagem("Informe o seu e-mail", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtEndereco.getText().trim().length() == 0)
        {
            Helper.mostrarMensagem("Informe o seu endereço", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtBairro.getText().trim().length() == 0)
        {
            Helper.mostrarMensagem("Informe o seu bairro", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtCEP.getValue() == null)
        {
            Helper.mostrarMensagem("Informe um CEP", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (txtCidade.getText().trim().length() == 0)
        {
            Helper.mostrarMensagem("Informe a cidade", Color.RED, lblExtraInfo);
            
            return false;
        }
        
        if (Double.parseDouble(txtRenda.getText().trim()
                .replaceAll("\\.", "").replaceAll(",", ".")) < 700)
        {
            Helper.mostrarMensagem("Renda deve ser maior do que R$ 720,00",
                    Color.RED, lblExtraInfo);
            
            return false;
        }
        
        Helper.mostrarMensagem("", lblExtraInfo);

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox cbbUF;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblExtraInfo;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRenda;
    private javax.swing.JLabel lblUF;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRenda;
    // End of variables declaration//GEN-END:variables
}
