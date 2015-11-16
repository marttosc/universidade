package wallet.telas.frames.consultas;

import javax.swing.JDesktopPane;
import wallet.dao.UsuarioDAO;
import wallet.models.Usuario;
import wallet.telas.AreaDeTrabalho;

/**
 * Consultar clientes.
 * 
 * @author Gustavo Marttos
 * @author Jordana Nogueira
 * @author Leandro Cazarini
 */
public class FrameConsultaUsuario extends javax.swing.JInternalFrame
{
    public FrameConsultaUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstUsuarios = new UsuarioDAO().listar();
        spaUsuarios = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int row, int colum)
            {
                return false;
            }
        };

        lstUsuarios = org.jdesktop.observablecollections.ObservableCollections.observableList(lstUsuarios);

        setClosable(true);
        setTitle("Consulta de Usuário");
        setMinimumSize(new java.awt.Dimension(669, 352));
        setPreferredSize(new java.awt.Dimension(669, 352));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formConsultaUsuarioClose(evt);
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

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstUsuarios, tbUsuarios);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cpf}"));
        columnBinding.setColumnName("CPF");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${primeiroNome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${segundoNome}"));
        columnBinding.setColumnName("Sobrenome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nascimento}"));
        columnBinding.setColumnName("Nascimento");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${email}"));
        columnBinding.setColumnName("Email");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${renda}"));
        columnBinding.setColumnName("Renda");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        spaUsuarios.setViewportView(tbUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formConsultaUsuarioClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formConsultaUsuarioClose
        JDesktopPane dsk = getDesktopPane();
        
        ((AreaDeTrabalho) dsk).fecharConsultaUsuario();
    }//GEN-LAST:event_formConsultaUsuarioClose

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        /**
         * Quando clicar duas vezes em uma determinada linha da coluna,
         * habilita a tela de edição (FrameCadastroUsuario) com as informações
         * que vieram através do usuário resgatado da tabela.
         */
        if (evt.getClickCount() > 1)
        {
            Usuario usuario = lstUsuarios.get(tbUsuarios.getSelectedRow());
            
            JDesktopPane p = getDesktopPane();

            ((AreaDeTrabalho) p).abrirCadastroUsuario(usuario);
            ((AreaDeTrabalho) p).fecharConsultaUsuario();
        }
    }//GEN-LAST:event_tbUsuariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<Usuario> lstUsuarios;
    private javax.swing.JScrollPane spaUsuarios;
    private javax.swing.JTable tbUsuarios;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
