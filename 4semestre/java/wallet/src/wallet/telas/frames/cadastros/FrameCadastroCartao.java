package wallet.telas.frames.cadastros;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDesktopPane;
import wallet.aux.Helper;
import wallet.dao.BandeiraDAO;
import wallet.dao.CartaoDAO;
import wallet.dao.UsuarioDAO;
import wallet.models.Bandeira;
import wallet.models.Cartao;
import wallet.models.Usuario;
import wallet.telas.AreaDeTrabalho;

/**
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class FrameCadastroCartao extends javax.swing.JInternalFrame
{
    private static Cartao Cartao = null;

    public FrameCadastroCartao() {
        initComponents();
        
        setTitle("Cadastro de Cartões");
        
        cbbUsuario.setSelectedIndex(-1);
        cbbBandeira.setSelectedIndex(-1);
        
        txtNumeroCartao.setEnabled(true);
        cbbBandeira.setEnabled(true);
    }
    
    public FrameCadastroCartao(Cartao cartao)
    {
        this();
        
        setTitle("Edição de Cartões");
        
        txtNumeroCartao.setEnabled(false);
        cbbBandeira.setEnabled(false);
        
        FrameCadastroCartao.Cartao = cartao;
        
        preencher();
    }
    
    /**
     * Retorna o cartão a ser editado.
     * @return Cartão a ser editado.
     */
    public Cartao getCartao()
    {
        return FrameCadastroCartao.Cartao;
    }
    
    /**
     * Preenche o formulário ao editar um cartão.
     */
    private void preencher()
    {
        Cartao cartao = getCartao();

        cbbUsuario.setSelectedItem(cartao.getUsuario());
        txtNumeroCartao.setText(cartao.getNumero());
        txtCVC.setText(String.format("%03d", cartao.getCvc()));
        cbbBandeira.setSelectedItem(cartao.getBandeira());
        cbbDataMes.setSelectedItem(cartao.getMesValidade());
        cbbDataAno.setSelectedItem(cartao.getAnoValidade());
        
        String strLimite = Double.toString(cartao.getLimite());
        
        if (strLimite.substring(strLimite.length() - 1).equals("0"))
        {
            strLimite += "0";
        }
        
        txtLimite.setText(strLimite);
    }
    
    /**
     * Limpa o formulário ao excluir um cartão.
     */
    private void limpar()
    {
        cbbUsuario.setSelectedIndex(-1);
        txtNumeroCartao.setText("");
        txtCVC.setText("");
        cbbBandeira.setSelectedIndex(-1);
        cbbDataMes.setSelectedIndex(-1);
        cbbDataAno.setSelectedIndex(-1);
        txtLimite.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstUsuarios = new UsuarioDAO().listar();
        rdrUsuario = new wallet.aux.swing.renderer.UsuarioRenderer();
        lstBandeiras = new BandeiraDAO().listar();
        rdrBandeira = new wallet.aux.swing.renderer.BandeiraRenderer();
        lblNumeroCartao = new javax.swing.JLabel();
        cbbBandeira = new javax.swing.JComboBox();
        lblBandeira = new javax.swing.JLabel();
        lblDataValidade = new javax.swing.JLabel();
        cbbDataMes = new javax.swing.JComboBox();
        cbbDataAno = new javax.swing.JComboBox();
        lblCodigoVerificaçao = new javax.swing.JLabel();
        btExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        lblLimite = new javax.swing.JLabel();
        txtLimite = new wallet.aux.swing.text.JNumberFormatField();
        txtNumeroCartao = new javax.swing.JFormattedTextField();
        txtCVC = new javax.swing.JFormattedTextField();
        lblResponsavel = new javax.swing.JLabel();
        jspCartao = new javax.swing.JSeparator();
        lblErroCadastro = new javax.swing.JLabel();
        cbbUsuario = new javax.swing.JComboBox();

        rdrBandeira.setText("bandeiraRenderer1");

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Cartão");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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
        getContentPane().setLayout(null);

        lblNumeroCartao.setText("Número do cartão");
        getContentPane().add(lblNumeroCartao);
        lblNumeroCartao.setBounds(200, 30, 126, 17);

        cbbBandeira.setRenderer(rdrBandeira);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstBandeiras, cbbBandeira);
        bindingGroup.addBinding(jComboBoxBinding);

        getContentPane().add(cbbBandeira);
        cbbBandeira.setBounds(20, 130, 160, 27);

        lblBandeira.setText("Bandeira");
        getContentPane().add(lblBandeira);
        lblBandeira.setBounds(20, 100, 62, 17);

        lblDataValidade.setText("Data de validade");
        getContentPane().add(lblDataValidade);
        lblDataValidade.setBounds(200, 100, 114, 17);

        cbbDataMes.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 }));
        getContentPane().add(cbbDataMes);
        cbbDataMes.setBounds(200, 130, 60, 27);

        cbbDataAno.setModel(new javax.swing.DefaultComboBoxModel(new Integer[] { 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025 }));
        getContentPane().add(cbbDataAno);
        cbbDataAno.setBounds(270, 130, 70, 27);

        lblCodigoVerificaçao.setText("CVC");
        getContentPane().add(lblCodigoVerificaçao);
        lblCodigoVerificaçao.setBounds(380, 30, 29, 17);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btExcluir);
        btExcluir.setBounds(280, 200, 70, 27);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar);
        btSalvar.setBounds(361, 200, 70, 27);

        lblLimite.setText("Limite");
        getContentPane().add(lblLimite);
        lblLimite.setBounds(360, 100, 42, 17);
        getContentPane().add(txtLimite);
        txtLimite.setBounds(360, 130, 71, 27);

        try
        {
            javax.swing.text.MaskFormatter formatCartao = new javax.swing.text.MaskFormatter("#### #### #### ####");

            txtNumeroCartao = new javax.swing.JFormattedTextField(formatCartao);
        }
        catch (Exception e)
        {
        }
        txtNumeroCartao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroCartaoKeyReleased(evt);
            }
        });
        getContentPane().add(txtNumeroCartao);
        txtNumeroCartao.setBounds(200, 60, 158, 27);

        try
        {
            javax.swing.text.MaskFormatter formatCVC = new javax.swing.text.MaskFormatter("###");

            txtCVC = new javax.swing.JFormattedTextField(formatCVC);
        }
        catch (Exception e)
        {
        }
        getContentPane().add(txtCVC);
        txtCVC.setBounds(380, 60, 50, 27);

        lblResponsavel.setText("Responsável");
        getContentPane().add(lblResponsavel);
        lblResponsavel.setBounds(20, 30, 90, 17);
        getContentPane().add(jspCartao);
        jspCartao.setBounds(20, 180, 410, 10);
        getContentPane().add(lblErroCadastro);
        lblErroCadastro.setBounds(20, 200, 250, 20);

        cbbUsuario.setRenderer(rdrUsuario);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstUsuarios, cbbUsuario);
        bindingGroup.addBinding(jComboBoxBinding);

        getContentPane().add(cbbUsuario);
        cbbUsuario.setBounds(20, 60, 160, 27);

        bindingGroup.bind();

        setBounds(0, 0, 461, 276);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        JDesktopPane cartao = getDesktopPane();
        ((AreaDeTrabalho) cartao).fecharCadastroCartao();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validar())
        {
            CartaoDAO cartaoDao = new CartaoDAO();
            
            Cartao cartao = getCartao();
            
            if (cartao == null)
            {
                cartao = new Cartao();
                
                cartao.setNumero(txtNumeroCartao.getText().trim());
                cartao.setBandeira((Bandeira) cbbBandeira.getSelectedItem());
            }
            
            cartao.setCvc(Integer.parseInt(txtCVC.getText().trim()));
            cartao.setMesValidade((Integer) cbbDataMes.getSelectedItem());
            cartao.setAnoValidade((Integer) cbbDataAno.getSelectedItem());
            cartao.setUsuario((Usuario) cbbUsuario.getSelectedItem());
            cartao.setLimite(Helper.getDouble(txtLimite.getText()));
            
            if (cartao.getId() > 0)
            {
                if (cartaoDao.atualizar(cartao))
                {
                    Helper.mostrarMensagem("Cartão atualizado com sucesso!",
                            Color.GREEN, lblErroCadastro);
                }
                else
                {
                    Helper.mostrarMensagem("Não foi possível atualizar o cartão.",
                            Color.ORANGE, lblErroCadastro);
                }
            }
            else
            {
                if (cartaoDao.inserir(cartao))
                {
                    Helper.mostrarMensagem("Cartão cadastrado com sucesso!",
                            Color.GREEN, lblErroCadastro);
                }
                else
                {
                    Helper.mostrarMensagem("Não foi possível cadastrar o cartão.",
                            Color.ORANGE, lblErroCadastro);
                }
            }
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void txtNumeroCartaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroCartaoKeyReleased
        String numero = txtNumeroCartao.getText().trim().replaceAll(" ", "");

        Pattern patternVisa = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?");
        Matcher matcherVisa = patternVisa.matcher(numero);

        Pattern patternMaster = Pattern.compile("^5[1-5][0-9]{14}");
        Matcher matcherMaster = patternMaster.matcher(numero);

        Pattern patternAmex = Pattern.compile("^3[47][0-9]{13}");
        Matcher matcherAmex = patternAmex.matcher(numero);

        Pattern patternDiners = Pattern.compile("^3(?:0[0-5]|[68][0-9])[0-9]{11}");
        Matcher matcherDiners = patternDiners.matcher(numero);

        if (matcherVisa.matches())
        {
            cbbBandeira.setSelectedItem(new BandeiraDAO().getByDescription("Visa"));
        }
        else if (matcherMaster.matches())
        {
            cbbBandeira.setSelectedItem(new BandeiraDAO().getByDescription("Master"));
        }
        else if (matcherAmex.matches())
        {
            cbbBandeira.setSelectedItem(new BandeiraDAO().getByDescription("American"));
        }
        else if (matcherDiners.matches())
        {
            cbbBandeira.setSelectedItem(new BandeiraDAO().getByDescription("Diners"));
        }
    }//GEN-LAST:event_txtNumeroCartaoKeyReleased

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (getCartao() != null)
        {
            CartaoDAO cartaoDao = new CartaoDAO();
            Cartao cartao = getCartao();
            
            if (cartaoDao.excluir(cartao))
            {
                Helper.mostrarMensagem("Cartão excluída com sucesso!",
                            Color.GREEN, lblErroCadastro);
                
                limpar();
            }
            else
            {
                Helper.mostrarMensagem("Não foi possível excluir o cartão.",
                            Color.ORANGE, lblErroCadastro);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    /**
     * Valida o formulário conforme a regra de negócio.
     * @return Se o formulário está OK.
     */
    private boolean validar()
    {
        CartaoDAO cartaoDao;
        Cartao cartao;
        
        Usuario responsavel = (Usuario) cbbUsuario.getSelectedItem();
        String numero = txtNumeroCartao.getText().trim().replaceAll(" ", "");
        String cvc = txtCVC.getText().trim();
        Bandeira bandeira = (Bandeira) cbbBandeira.getSelectedItem();
        Integer mes = (Integer) cbbDataMes.getSelectedItem();
        Integer ano = (Integer) cbbDataAno.getSelectedItem();
        
        double limite = Helper.getDouble(txtLimite.getText());
        
        if (responsavel == null)
        {
            Helper.mostrarMensagem("Informe o responsável.",
                    Color.RED, lblErroCadastro);
            
            cbbUsuario.requestFocus();
            
            return false;
        }
        
        if (numero.equals(""))
        {
            Helper.mostrarMensagem("Informe o número do cartão.",
                    Color.RED, lblErroCadastro);
            
            txtNumeroCartao.requestFocus();
            
            return false;
        }
        else
        {
            cartaoDao = new CartaoDAO();
            
            cartao = cartaoDao.getByNumero(txtNumeroCartao.getText().trim());
            
            if (cartao != null && getCartao() == null)
            {
                Helper.mostrarMensagem("Cartão já cadastrado.",
                        Color.RED, lblErroCadastro);
            
                txtNumeroCartao.requestFocus();

                return false;
            }
        }
        
        if (cvc.equals(""))
        {
            Helper.mostrarMensagem("Informe o código de segurança.",
                    Color.RED, lblErroCadastro);
            
            txtCVC.requestFocus();
            
            return false;
        }
        
        if (bandeira == null)
        {
            Helper.mostrarMensagem("Informe a bandeira do cartão.",
                    Color.RED, lblErroCadastro);
            
            cbbBandeira.requestFocus();
            
            return false;
        }
        
        if (mes == null || mes == 0)
        {
            Helper.mostrarMensagem("Informe o mês de validade.",
                    Color.RED, lblErroCadastro);
            
            cbbDataMes.requestFocus();
            
            return false;
        }
        
        if (ano == null || ano == 0)
        {
            Helper.mostrarMensagem("Informe o ano de validade.",
                    Color.RED, lblErroCadastro);
            
            cbbDataAno.requestFocus();
            
            return false;
        }
        
        double maxLimite = responsavel.getRenda() * 0.4;
        double minLimite = maxLimite * 0.045;
        
        if (limite == 0)
        {
            Helper.mostrarMensagem("Limite mínimo: R$ " + minLimite + ".",
                    Color.RED, lblErroCadastro);
            
            txtLimite.requestFocus();
            
            return false;
        }
        else if (limite > maxLimite)
        {
            Helper.mostrarMensagem("Limite máximo: R$ " + maxLimite + ".",
                    Color.RED, lblErroCadastro);
            
            txtLimite.requestFocus();
            
            return false;
        }
        
        Helper.mostrarMensagem("", lblErroCadastro);
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbbBandeira;
    private javax.swing.JComboBox cbbDataAno;
    private javax.swing.JComboBox cbbDataMes;
    private javax.swing.JComboBox cbbUsuario;
    private javax.swing.JSeparator jspCartao;
    private javax.swing.JLabel lblBandeira;
    private javax.swing.JLabel lblCodigoVerificaçao;
    private javax.swing.JLabel lblDataValidade;
    private javax.swing.JLabel lblErroCadastro;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblNumeroCartao;
    private javax.swing.JLabel lblResponsavel;
    private java.util.List<Bandeira> lstBandeiras;
    private java.util.List<Usuario> lstUsuarios;
    private wallet.aux.swing.renderer.BandeiraRenderer rdrBandeira;
    private wallet.aux.swing.renderer.UsuarioRenderer rdrUsuario;
    private javax.swing.JFormattedTextField txtCVC;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JFormattedTextField txtNumeroCartao;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
