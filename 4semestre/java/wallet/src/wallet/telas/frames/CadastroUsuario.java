package wallet.telas.frames;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.Timer;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.json.JSONException;
import org.json.JSONObject;
import wallet.aux.Helper;
import wallet.aux.JSON;
import wallet.aux.Password;
import wallet.dao.EnderecoDAO;
import wallet.dao.UsuarioDAO;
import wallet.models.Endereco;
import wallet.models.Usuario;

/**
 * Tela de cadastro de usuário via login.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @authro Leandro Cazarini
 */
public class CadastroUsuario extends JFrame
{
    private static JFrame ROOT = null;
    
    public CadastroUsuario()
    {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    public CadastroUsuario(JFrame root)
    {
        this();
        
        ROOT = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstEstados = new LinkedList<>();
        txtPrimeiroNome = new javax.swing.JTextField();
        lblPrimeiroNome = new javax.swing.JLabel();
        txtSegundoNome = new javax.swing.JTextField();
        lblSegundoNome = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        txtNascimento = new javax.swing.JFormattedTextField();
        lblNascimento = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        lblCEP = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        cbbUF = new javax.swing.JComboBox();
        lblUF = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        lblSenha = new javax.swing.JLabel();
        txtSenhaConfirma = new javax.swing.JPasswordField();
        lblSenhaConfirma = new javax.swing.JLabel();
        btnCEPBuscar = new javax.swing.JButton();
        jspSeparador = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        lblErroCadastro = new javax.swing.JLabel();
        txtRenda = new wallet.aux.swing.text.JNumberFormatField();
        lblRenda = new javax.swing.JLabel();

        lstEstados = Arrays.asList(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO" });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar nova conta - Skuld");
        setMaximumSize(new java.awt.Dimension(510, 460));
        setMinimumSize(new java.awt.Dimension(510, 460));
        setPreferredSize(new java.awt.Dimension(510, 460));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(txtPrimeiroNome);
        txtPrimeiroNome.setBounds(20, 50, 150, 27);

        lblPrimeiroNome.setText("Primeiro Nome");
        getContentPane().add(lblPrimeiroNome);
        lblPrimeiroNome.setBounds(20, 20, 103, 17);
        getContentPane().add(txtSegundoNome);
        txtSegundoNome.setBounds(190, 50, 150, 27);

        lblSegundoNome.setText("Segundo Nome");
        getContentPane().add(lblSegundoNome);
        lblSegundoNome.setBounds(190, 20, 107, 17);

        try
        {
            javax.swing.text.MaskFormatter formatCPF = new javax.swing.text.MaskFormatter("###.###.###-##");

            txtCPF = new javax.swing.JFormattedTextField(formatCPF);
        }
        catch (Exception e)
        {
        }
        getContentPane().add(txtCPF);
        txtCPF.setBounds(360, 120, 120, 27);

        lblCPF.setText("CPF");
        getContentPane().add(lblCPF);
        lblCPF.setBounds(360, 90, 27, 17);

        try
        {
            javax.swing.text.MaskFormatter formatNasc = new javax.swing.text.MaskFormatter("##/##/####");

            txtNascimento = new javax.swing.JFormattedTextField(formatNasc);
        }
        catch (Exception e)
        {
        }
        getContentPane().add(txtNascimento);
        txtNascimento.setBounds(360, 50, 120, 27);

        lblNascimento.setText("Nascimento");
        getContentPane().add(lblNascimento);
        lblNascimento.setBounds(360, 20, 120, 17);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(20, 120, 320, 27);

        lblEmail.setText("Email");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(20, 90, 37, 17);

        try
        {
            javax.swing.text.MaskFormatter formatCEP = new javax.swing.text.MaskFormatter("#####-###");

            txtCEP = new javax.swing.JFormattedTextField(formatCEP);
        }
        catch (Exception e)
        {
        }
        getContentPane().add(txtCEP);
        txtCEP.setBounds(20, 260, 88, 27);

        lblCEP.setText("CEP");
        getContentPane().add(lblCEP);
        lblCEP.setBounds(20, 230, 28, 17);
        getContentPane().add(txtLogradouro);
        txtLogradouro.setBounds(190, 260, 290, 27);

        lblLogradouro.setText("Logradouro");
        getContentPane().add(lblLogradouro);
        lblLogradouro.setBounds(190, 230, 82, 17);
        getContentPane().add(txtBairro);
        txtBairro.setBounds(20, 330, 150, 27);

        lblBairro.setText("Bairro");
        getContentPane().add(lblBairro);
        lblBairro.setBounds(20, 300, 42, 17);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(190, 330, 210, 27);

        lblCidade.setText("Cidade");
        getContentPane().add(lblCidade);
        lblCidade.setBounds(190, 300, 48, 17);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstEstados, cbbUF);
        bindingGroup.addBinding(jComboBoxBinding);

        getContentPane().add(cbbUF);
        cbbUF.setBounds(420, 330, 55, 27);

        lblUF.setText("UF");
        getContentPane().add(lblUF);
        lblUF.setBounds(420, 300, 18, 17);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(20, 190, 150, 27);

        lblSenha.setText("Senha");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(20, 160, 43, 17);
        getContentPane().add(txtSenhaConfirma);
        txtSenhaConfirma.setBounds(190, 190, 150, 27);

        lblSenhaConfirma.setText("Confirme a senha");
        getContentPane().add(lblSenhaConfirma);
        lblSenhaConfirma.setBounds(190, 160, 130, 17);

        btnCEPBuscar.setText("Ir");
        btnCEPBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEPBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCEPBuscar);
        btnCEPBuscar.setBounds(110, 260, 60, 27);
        getContentPane().add(jspSeparador);
        jspSeparador.setBounds(20, 380, 470, 20);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(400, 400, 90, 27);
        getContentPane().add(lblErroCadastro);
        lblErroCadastro.setBounds(20, 400, 300, 20);
        getContentPane().add(txtRenda);
        txtRenda.setBounds(360, 190, 120, 27);

        lblRenda.setText("Renda");
        getContentPane().add(lblRenda);
        lblRenda.setBounds(360, 160, 49, 17);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (ROOT != null)
        {
            ROOT.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCEPBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEPBuscarActionPerformed
        String cep = txtCEP.getText().trim();
        
        if (cep.length() < 8)
        {
            txtLogradouro.setText("");
            txtBairro.setText("");
            txtCidade.setText("");
            cbbUF.setSelectedIndex(-1);

            txtCEP.requestFocus();
        }
        else
        {
            cepInfo(cep);
        }
    }//GEN-LAST:event_btnCEPBuscarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (validar())
        {
            UsuarioDAO usuarioDao = new UsuarioDAO();
            Usuario usuario = new Usuario();
            
            usuario.setPrimeiroNome(txtPrimeiroNome.getText().trim());
            usuario.setSegundoNome(txtSegundoNome.getText().trim());
            usuario.setNascimento(txtNascimento.getValue().toString());
            usuario.setEmail(txtEmail.getText().trim());
            usuario.setCpf(txtCPF.getValue().toString());
            usuario.setSenha(Password.getPassword(Password.getString(
                    txtSenha.getPassword()), false));
            usuario.setRenda(Helper.getDouble(txtRenda.getText()));
            usuario.setCriadoEm(new Date());
            usuario.setAtualizadoEm(new Date());
            
            // Verifica se o endereço existe, senão cadastra também.
            
            EnderecoDAO enderecoDao = new EnderecoDAO();
        
            Endereco endereco = enderecoDao.getByCep(txtCEP.getText().trim());
            
            if (endereco == null)
            {
                endereco = new Endereco();
                
                endereco.setCep(txtCEP.getText().trim());
                endereco.setLogradouro(txtLogradouro.getText().trim());
                endereco.setBairro(txtBairro.getText().trim());
                endereco.setLocalidade(txtCidade.getText().trim());
                endereco.setUf(cbbUF.getSelectedItem().toString());
                
                if (!enderecoDao.inserir(endereco))
                {
                    System.err.println("Endereço não cadastrado.");
                }
            }
            else
            {
                enderecoDao.atualizar(endereco);
            }
            
            usuario.setEndereco(endereco);
            
            if (usuarioDao.inserir(usuario))
            {
                btnCadastrar.setEnabled(false);

                Helper.mostrarMensagem("Conta cadastrada com sucesso! Aguarde...",
                        Color.GREEN, lblErroCadastro);
                
                Timer timer = new Timer(2000, (ActionEvent e) -> {
                    this.dispose();

                    formWindowClosing(null);
                });
                
                timer.setRepeats(false);
                timer.start();
            }
            else
            {
                Helper.mostrarMensagem("Não foi possível cadastrar sua conta.",
                        Color.ORANGE, lblErroCadastro);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cepInfo(String cep)
    {
        EnderecoDAO enderecoDao = new EnderecoDAO();
        
        Endereco endereco = enderecoDao.getByCep(cep);
        
        if (endereco == null)
        {
            try
            {
                JSONObject info = JSON.lerJsonViaUrl("http://cep.correiocontrol.com.br/"
                    + cep.replaceAll("[\\-]", "")
                    + ".json");

                txtLogradouro.setText(info.get("logradouro").toString());
                txtBairro.setText(info.get("bairro").toString());
                txtCidade.setText(info.get("localidade").toString());
                cbbUF.setSelectedItem(info.get("uf"));
            }
            catch (JSONException e)
            {
                txtLogradouro.setText("");
                txtBairro.setText("");
                txtCidade.setText("");
                cbbUF.setSelectedIndex(-1);

                txtCEP.setText("");
                txtCEP.requestFocus();
            }
        }
        else
        {
            txtLogradouro.setText(endereco.getLogradouro());
            txtBairro.setText(endereco.getBairro());
            txtCidade.setText(endereco.getLocalidade());
            cbbUF.setSelectedItem(endereco.getUf());
        }
    }
    
    private boolean validar()
    {
        UsuarioDAO usuarioDao;
        Usuario usuario;
                    
        String primeiroNome = txtPrimeiroNome.getText().trim();
        String segundoNome = txtSegundoNome.getText().trim();
        Object nascimento = txtNascimento.getValue();
        String email = txtEmail.getText().trim();
        Object cpf = txtCPF.getValue();
        char[] senha = txtSenha.getPassword();
        char[] senhaConf = txtSenhaConfirma.getPassword();
        double renda = Helper.getDouble(txtRenda.getText());
        String cep = txtCEP.getText().trim();
        String logradouro = txtLogradouro.getText().trim();
        String bairro = txtBairro.getText().trim();
        String localidade = txtCidade.getText().trim();
        String uf = cbbUF.getSelectedItem().toString().trim();
        
        if (primeiroNome.equals(""))
        {
            Helper.mostrarMensagem("Informe seu primeiro nome.",
                    Color.RED, lblErroCadastro);
            
            txtPrimeiroNome.requestFocus();
            
            return false;
        }
        
        if (segundoNome.equals(""))
        {
            Helper.mostrarMensagem("Informe seu segundo nome.",
                    Color.RED, lblErroCadastro);
            
            txtSegundoNome.requestFocus();
            
            return false;
        }
        
        if (nascimento == null)
        {
            Helper.mostrarMensagem("Informe sua data de nascimento.",
                    Color.RED, lblErroCadastro);
            
            txtNascimento.requestFocus();
            
            return false;
        }
        else
        {
            try
            {
                if (!DateValidator.getInstance().isValid(nascimento.toString(),
                        "dd/MM/yyyy"))
                {
                    throw new ParseException("", ERROR);
                }

                Date nasc = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento.toString());
                Calendar cal = Calendar.getInstance();
                
                cal.setTime(nasc);
                
                LocalDate hoje = LocalDate.now();
                LocalDate data = LocalDate.of(cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                
                Period p = Period.between(data, hoje);
                
                if (p.getYears() < 18)
                {
                    Helper.mostrarMensagem("É necessário ser maior de idade.",
                            Color.RED, lblErroCadastro);
            
                    txtNascimento.requestFocus();

                    return false;
                }
            }
            catch (ParseException | DateTimeException e)
            {
                System.err.println("Data inválida.");
                
                Helper.mostrarMensagem("Data de nascimento inválida.",
                        Color.RED, lblErroCadastro);
            
                txtNascimento.requestFocus();

                return false;
            }
        }
        
        if (!EmailValidator.getInstance().isValid(email))
        {
            Helper.mostrarMensagem("Informe um email válido.",
                    Color.RED, lblErroCadastro);
            
            txtEmail.requestFocus();
            
            return false;
        }
        else
        {
            usuarioDao = new UsuarioDAO();
            
            usuario = usuarioDao.getByEmail(email);
            
            if (usuario != null)
            {
                Helper.mostrarMensagem("Email já cadastrado.",
                        Color.RED, lblErroCadastro);
            
                txtEmail.requestFocus();

                return false;
            }
        }
        
        if (!Helper.validarCPF(cpf))
        {
            Helper.mostrarMensagem("Informe um CPF válido.",
                    Color.RED, lblErroCadastro);
            
            txtCPF.requestFocus();
            
            return false;
        }
        else
        {
            usuarioDao = new UsuarioDAO();
            
            usuario = usuarioDao.getByCpf(cpf.toString().trim());
            
            if (usuario != null)
            {
                Helper.mostrarMensagem("CPF já cadastrado.",
                        Color.RED, lblErroCadastro);
            
                txtCPF.requestFocus();

                return false;
            }
        }
        
        if (senha.length < 6)
        {
            Helper.mostrarMensagem("A senha deve possuir 6 ou mais caracteres.",
                    Color.RED, lblErroCadastro);
            
            txtSenha.requestFocus();
            
            return false;
        }
        else if (!Password.getString(senha).trim().equals(
                Password.getString(senhaConf).trim()) || senhaConf.length < 6)
        {
            Helper.mostrarMensagem("Confirme a sua senha.",
                    Color.RED, lblErroCadastro);
            
            txtSenhaConfirma.requestFocus();
            
            return false;
        }
        
        if (renda < 700)
        {
            Helper.mostrarMensagem("Informe uma renda superior a R$ 700,00.",
                    Color.RED, lblErroCadastro);
            
            txtRenda.requestFocus();
            
            return false;
        }
        
        if (cep.length() == 1)
        {
            Helper.mostrarMensagem("Informe um CEP válido.",
                    Color.RED, lblErroCadastro);
            
            txtCEP.requestFocus();
            
            return false;
        }
        
        if (logradouro.equals(""))
        {
            Helper.mostrarMensagem("Informe o logradouro.",
                    Color.RED, lblErroCadastro);
            
            txtLogradouro.requestFocus();
            
            return false;
        }
        
        if (bairro.equals(""))
        {
            Helper.mostrarMensagem("Informe o bairro.",
                    Color.RED, lblErroCadastro);
            
            txtBairro.requestFocus();
            
            return false;
        }
        
        if (localidade.equals(""))
        {
            Helper.mostrarMensagem("Informe a cidade.",
                    Color.RED, lblErroCadastro);
            
            txtCidade.requestFocus();
            
            return false;
        }
        
        if (uf.equals(""))
        {
            Helper.mostrarMensagem("Informe o UF.",
                    Color.RED, lblErroCadastro);
            
            cbbUF.requestFocus();
            
            return false;
        }
        
        Helper.mostrarMensagem("", lblErroCadastro);
        
        return true;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCEPBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cbbUF;
    private javax.swing.JSeparator jspSeparador;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErroCadastro;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblPrimeiroNome;
    private javax.swing.JLabel lblRenda;
    private javax.swing.JLabel lblSegundoNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenhaConfirma;
    private javax.swing.JLabel lblUF;
    private java.util.List<String> lstEstados;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtPrimeiroNome;
    private javax.swing.JTextField txtRenda;
    private javax.swing.JTextField txtSegundoNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenhaConfirma;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
