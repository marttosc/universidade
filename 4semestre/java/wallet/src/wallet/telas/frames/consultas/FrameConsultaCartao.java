package wallet.telas.frames.consultas;

import javax.swing.JDesktopPane;
import wallet.dao.CartaoDAO;
import wallet.models.Cartao;
import wallet.telas.AreaDeTrabalho;

/**
 * Tela de consulta dos cartões.
 * @author Gustavo Marttos
 */
public class FrameConsultaCartao extends javax.swing.JInternalFrame
{
    
    public FrameConsultaCartao()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstCartao = new CartaoDAO().listar();
        spaCartoes = new javax.swing.JScrollPane();
        tblCartoes = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int colum)
            {
                return false;
            }
        };

        setClosable(true);
        setTitle("Consulta de Cartão");
        setMinimumSize(new java.awt.Dimension(669, 352));
        setPreferredSize(new java.awt.Dimension(669, 352));
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

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstCartao, tblCartoes);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${usuario.primeiroNome} ${usuario.segundoNome}"));
        columnBinding.setColumnName("Responsável");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${numero}"));
        columnBinding.setColumnName("Número");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bandeira.descricao}"));
        columnBinding.setColumnName("Bandeira");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cvc}"));
        columnBinding.setColumnName("CVC");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${mesValidade}/${anoValidade}"));
        columnBinding.setColumnName("Validade");
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tblCartoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartoesMouseClicked(evt);
            }
        });
        spaCartoes.setViewportView(tblCartoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaCartoes, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaCartoes, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        JDesktopPane dsk = getDesktopPane();
        
        ((AreaDeTrabalho) dsk).fecharConsultaCartao();
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblCartoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartoesMouseClicked
        /**
        * Quando clicar duas vezes em uma determinada linha da coluna,
        * habilita a tela de edição (FrameCadastroCartao) com as informações
        * que vieram através do cartão resgatado da tabela.
        */
        if (evt.getClickCount() > 1)
        {
            Cartao cartao = lstCartao.get(tblCartoes.getSelectedRow());

            JDesktopPane p = getDesktopPane();

            ((AreaDeTrabalho) p).abrirCadastroCartao(cartao);
            ((AreaDeTrabalho) p).fecharConsultaCartao();
        }
    }//GEN-LAST:event_tblCartoesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<Cartao> lstCartao;
    private javax.swing.JScrollPane spaCartoes;
    private javax.swing.JTable tblCartoes;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
