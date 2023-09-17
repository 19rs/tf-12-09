package view.produto;

import DAO.CategoriaProdutoDAO;
import DAO.ProdutoDAO;
import Model.ModelCategoriaProduto;
import Model.ProdutoModel;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import tablemodel.TableModelProduto;
import org.jdesktop.swingx.prompt.PromptSupport;


public class JDialogGerenciarProduto extends javax.swing.JDialog 
{
    
    private String filtroCategoria = "%";
    private String filtroNome = "%";
    private Double filtroPrecoInicial = null;
    private Double filtroPrecoFinal = null;
    ArrayList<ModelCategoriaProduto> categorias;
    
    public JDialogGerenciarProduto(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        jTableProdutos.setModel(initTable());
        carregarCategorias();
        ajustarTamanhoTabela();
        this.setLocationRelativeTo(null);
    }
    
    private TableModelProduto initTable() 
    {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        return new TableModelProduto(produtoDAO.consultar());
    }

    public void ajustarTamanhoTabela() //ver depois
    {
        jTableProdutos.setRowHeight(25);
        
        TableColumn colunaID = jTableProdutos.getColumnModel().getColumn(0);
        colunaID.setPreferredWidth(80);
        colunaID.setMaxWidth(100);
        
        TableColumn colunaPreco = jTableProdutos.getColumnModel().getColumn(5);
        colunaPreco.setPreferredWidth(80);
        colunaPreco.setMaxWidth(100);

        atualizarTamanhoTabela();
    }
    
    public void atualizarTamanhoTabela()
    {
        Dimension size = new Dimension(500, jTableProdutos.getRowCount() * jTableProdutos.getRowHeight());
        jTableProdutos.setPreferredScrollableViewportSize(size);
        jTableProdutos.setPreferredSize(size);
    }

    private void carregarCategorias() 
    {
        categorias = new ArrayList<>();
        
        categorias = CategoriaProdutoDAO.obterTodasCategorias();
        
        for(int i = 0; i < categorias.size(); i++) 
        {
            String idCategoria = String.valueOf(categorias.get(i).getId());
            String descricao = categorias.get(i).getDescricao();
            String item = idCategoria + " - " + descricao;
            this.jComboBoxCategoriaProduto.addItem(item);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();
        jComboBoxCategoriaProduto = new javax.swing.JComboBox<>();
        jTextFieldFiltrarNomeDescricaoProduto = new javax.swing.JTextField();
        jButtonLimparFiltrosProduto = new javax.swing.JButton();
        jTextFieldPrecoInicialProduto = new javax.swing.JTextField();
        jTextFieldPrecoFinalProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");
        setMinimumSize(new java.awt.Dimension(1000, 680));
        setPreferredSize(new java.awt.Dimension(1000, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Consultar Produtos");
        jLabelTitulo.setMinimumSize(new java.awt.Dimension(1000, 680));
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 6, 400, -1));

        jScrollPane.setPreferredSize(new java.awt.Dimension(1000, 550));

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Categoria", "Foto", "Nome", "Descrição", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProdutos.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jTableProdutos.setPreferredSize(new java.awt.Dimension(800, 200));
        jTableProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jTableProdutos);
        if (jTableProdutos.getColumnModel().getColumnCount() > 0) {
            jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        getContentPane().add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 120, 950, 500));

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/paper.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setMaximumSize(new java.awt.Dimension(72, 25));
        jButtonEditar.setMinimumSize(new java.awt.Dimension(90, 25));
        jButtonEditar.setPreferredSize(new java.awt.Dimension(90, 25));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 90, -1, 25));

        jButtonDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clean.png"))); // NOI18N
        jButtonDeletar.setText("Deletar");
        jButtonDeletar.setMaximumSize(new java.awt.Dimension(90, 25));
        jButtonDeletar.setMinimumSize(new java.awt.Dimension(72, 25));
        jButtonDeletar.setPreferredSize(new java.awt.Dimension(90, 25));
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        jComboBoxCategoriaProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por Categoria" }));
        jComboBoxCategoriaProduto.setMinimumSize(new java.awt.Dimension(65, 22));
        jComboBoxCategoriaProduto.setPreferredSize(new java.awt.Dimension(65, 25));
        jComboBoxCategoriaProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaProdutoItemStateChanged(evt);
            }
        });
        jComboBoxCategoriaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategoriaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 190, -1));

        jTextFieldFiltrarNomeDescricaoProduto.setPreferredSize(new java.awt.Dimension(64, 25));
        jTextFieldFiltrarNomeDescricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFiltrarNomeDescricaoProdutoKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldFiltrarNomeDescricaoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 240, -1));
        PromptSupport.setPrompt("Por Nome ou Descrição", jTextFieldFiltrarNomeDescricaoProduto);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextFieldFiltrarNomeDescricaoProduto);

        jButtonLimparFiltrosProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tchefood/src/icon/filtro-limpo.png"))); // NOI18N
        jButtonLimparFiltrosProduto.setText("Limpar");
        jButtonLimparFiltrosProduto.setPreferredSize(new java.awt.Dimension(90, 25));
        jButtonLimparFiltrosProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparFiltrosProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLimparFiltrosProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 90, -1, -1));

        jTextFieldPrecoInicialProduto.setPreferredSize(new java.awt.Dimension(64, 25));
        jTextFieldPrecoInicialProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoInicialProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoInicialProdutoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldPrecoInicialProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 80, -1));
        PromptSupport.setPrompt("Preço Inicial", jTextFieldPrecoInicialProduto);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextFieldPrecoInicialProduto);

        jTextFieldPrecoFinalProduto.setPreferredSize(new java.awt.Dimension(64, 25));
        jTextFieldPrecoFinalProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoFinalProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoFinalProdutoKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldPrecoFinalProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 90, 80, -1));
        PromptSupport.setPrompt("Preço Final", jTextFieldPrecoFinalProduto);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextFieldPrecoFinalProduto);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = jTableProdutos.getSelectedRow();
        
        if(linhaSelecionada == -1)
        {
            JOptionPane.showMessageDialog(this, "Nenhum produto Selecionado");
            return;
        }
        
        Object idObjeto = jTableProdutos.getValueAt(linhaSelecionada, 0);
        int id = (int) idObjeto;
        
        JDialogEditarProduto jDialogEditarProduto = new JDialogEditarProduto(null, true, id, jTableProdutos);
        jDialogEditarProduto.setVisible(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = jTableProdutos.getSelectedRow();
        
        if(linhaSelecionada == -1)
        {
            JOptionPane.showMessageDialog(this, "Nenhum produto Selecionado"); //depois verificar se tem selecionado e ativar o botao
            return;
        }

        int opcao = JOptionPane.showConfirmDialog(this, "Confirma a exclusão do produto?", "Excluir", JOptionPane.YES_NO_OPTION);
        
        if(opcao == JOptionPane.YES_OPTION)
        {
            ProdutoDAO produtoDAO = new ProdutoDAO();
            
            Object idObjeto = jTableProdutos.getValueAt(linhaSelecionada, 0);
            int id = (int) idObjeto;
            
            ProdutoModel produto = produtoDAO.obterProdutoPorID(id);
            
            produtoDAO.deletar(produto);
            JOptionPane.showMessageDialog(this, "Produto Excluído");    
            
            
            this.limparFiltros();
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jComboBoxCategoriaProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaProdutoItemStateChanged
        //this.filtrar();
        //System.out.println("Filtrou Categoria");
    }//GEN-LAST:event_jComboBoxCategoriaProdutoItemStateChanged

    private void jTextFieldFiltrarNomeDescricaoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFiltrarNomeDescricaoProdutoKeyReleased
        this.filtrar();
    }//GEN-LAST:event_jTextFieldFiltrarNomeDescricaoProdutoKeyReleased

    private void jButtonLimparFiltrosProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparFiltrosProdutoActionPerformed
        this.limparFiltros();
    }//GEN-LAST:event_jButtonLimparFiltrosProdutoActionPerformed

    private void jTextFieldPrecoInicialProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoInicialProdutoKeyReleased
        char c = evt.getKeyChar();
        
        if(Character.isDigit(c))
        {
            this.filtrar();
        }
    }//GEN-LAST:event_jTextFieldPrecoInicialProdutoKeyReleased

    private void jTextFieldPrecoFinalProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoFinalProdutoKeyReleased
        char c = evt.getKeyChar();
        
        if(Character.isDigit(c))
        {
            this.filtrar();
        }
    }//GEN-LAST:event_jTextFieldPrecoFinalProdutoKeyReleased

    private void jTextFieldPrecoInicialProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoInicialProdutoKeyTyped
        char c = evt.getKeyChar();
        
        String preco = jTextFieldPrecoInicialProduto.getText();
        
        if(c == KeyEvent.VK_COMMA && preco.contains(","))
        {
            evt.consume();    
        }
        if(c == KeyEvent.VK_COMMA && jTextFieldPrecoInicialProduto.getText().isBlank())
        {
            evt.consume();    
        }
        if(!Character.isDigit(c) && c != KeyEvent.VK_COMMA)
        {
            evt.consume();    
        }
    }//GEN-LAST:event_jTextFieldPrecoInicialProdutoKeyTyped

    private void jTextFieldPrecoFinalProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoFinalProdutoKeyTyped
        char c = evt.getKeyChar();
        
        String preco = jTextFieldPrecoInicialProduto.getText();
        
        if(c == KeyEvent.VK_COMMA && preco.contains(","))
        {
            evt.consume();    
        }
        if(c == KeyEvent.VK_COMMA && jTextFieldPrecoInicialProduto.getText().isBlank())
        {
            evt.consume();    
        }
        if(!Character.isDigit(c) && c != KeyEvent.VK_COMMA)
        {
            evt.consume();    
        }
    }//GEN-LAST:event_jTextFieldPrecoFinalProdutoKeyTyped

    private void jComboBoxCategoriaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaProdutoActionPerformed
        // TODO add your handling code here:
        this.filtrar();
    }//GEN-LAST:event_jComboBoxCategoriaProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(JDialogGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                JDialogGerenciarProduto dialog = new JDialogGerenciarProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonLimparFiltrosProduto;
    private javax.swing.JComboBox<String> jComboBoxCategoriaProduto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldFiltrarNomeDescricaoProduto;
    private javax.swing.JTextField jTextFieldPrecoFinalProduto;
    private javax.swing.JTextField jTextFieldPrecoInicialProduto;
    // End of variables declaration//GEN-END:variables



    private void filtrar()
    {
        if(jComboBoxCategoriaProduto.getSelectedIndex() > 0)
        {
            int idDaCategoria = categorias.get(jComboBoxCategoriaProduto.getSelectedIndex() -1 ).getId(); //pq começa em 0 o array

            filtroCategoria = String.valueOf(idDaCategoria);
        }
        else
        {
            filtroCategoria = "%";
        }
        if(!jTextFieldFiltrarNomeDescricaoProduto.getText().isBlank())
        {
            //filtroNome = "%" + jTextFieldFiltrarNomeProduto.getText() + "%";
            filtroNome = jTextFieldFiltrarNomeDescricaoProduto.getText();
        }
        else
        {
            filtroNome = "%";
        }
        
        if(!jTextFieldPrecoInicialProduto.getText().isBlank())
        {
            String precoInicial = jTextFieldPrecoInicialProduto.getText();
            if(precoInicial.contains(","))
            {
                precoInicial = precoInicial.replace(",", ".");
            }
            filtroPrecoInicial = Double.valueOf(precoInicial);
        }
        else
        {
            filtroPrecoInicial = null;
        }
        if(!jTextFieldPrecoFinalProduto.getText().isBlank())
        {
            String precoFinal = jTextFieldPrecoFinalProduto.getText();
            if(precoFinal.contains(","))
            {
                precoFinal = precoFinal.replace(",", ".");
            }
            filtroPrecoFinal = Double.valueOf(precoFinal);
        }
        else
        {
            filtroPrecoFinal = null;
        }
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        TableModelProduto tableModel = new TableModelProduto(produtoDAO.filtrarProdutos(filtroCategoria, filtroNome, filtroPrecoInicial, filtroPrecoFinal));
        jTableProdutos.setModel(tableModel);

        //atualizarTamanhoTabela();
        ajustarTamanhoTabela();
    }
    
    private void limparFiltros()
    {
        jComboBoxCategoriaProduto.setSelectedIndex(0);
        jTextFieldFiltrarNomeDescricaoProduto.setText(null);
        jTextFieldPrecoInicialProduto.setText(null);
        jTextFieldPrecoFinalProduto.setText(null);
        filtroCategoria = "%";
        filtroNome = "%";
        filtroPrecoInicial = null;
        filtroPrecoFinal = null;

        ProdutoDAO produtoDAO = new ProdutoDAO();
        TableModelProduto tableModel = new TableModelProduto(produtoDAO.consultar());
        jTableProdutos.setModel(tableModel);

        ajustarTamanhoTabela();
    }
}
