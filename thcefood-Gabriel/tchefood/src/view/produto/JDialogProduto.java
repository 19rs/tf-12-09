package view.produto;

import DAO.ItensPedidoDAO;
import DAO.ProdutoDAO;
import Model.ModelItensPedido;
import Model.ModelPedido;
import Model.ProdutoModel;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import org.jdesktop.swingx.prompt.PromptSupport;
import tablemodel.TableModelItensPedido;
import tablemodel.TableModelProduto;



public class JDialogProduto extends javax.swing.JDialog 
{
    private int id;
    private String nome; //pode ser local?
    private double preco;
    private double total;
    private int quantidade = 1;
    private int qtdeCaracteres = 0;
    private JTable tabela;
    private ModelPedido pedido;
    
    
    public JDialogProduto(java.awt.Frame parent, boolean modal, int id, ModelPedido pedido, JTable tabela) 
    {
        super(parent, modal);
        this.id = id;
        this.pedido = pedido;
        this.tabela = tabela;
        initComponents();
        carregarDados(id);
        this.setLocationRelativeTo(null);
    }

    private void carregarDados(int id)
    {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        ProdutoModel produto = produtoDAO.obterProdutoPorID(id);
        
        nome = produto.getNome();
        jLabelNome.setText(produto.getNome());
        
        jLabelDescricao.setText("<html><p>" +produto.getDescricao() + "</p></html>");
        
        preco = produto.getPreco();
        jLabelPreco.setText("R$" + String.format("%.2f", preco));
        
        
        jButtonAdicionar.setText("Adicionar             R$ " + String.format("%.2f",this.preco));
        
        try 
        {
            String caminhoImagem = produto.getImagem();
            
            Image img = ImageIO.read(getClass().getResource(caminhoImagem));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_SMOOTH));
            jLabelFoto.setIcon(icon);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTextAreaOpcionais = new javax.swing.JTextArea();
        jLabelDescricao = new javax.swing.JLabel();
        jButtonAdicionar = new javax.swing.JButton();
        jLabelPreco = new javax.swing.JLabel();
        jLabelAlgumComentario = new javax.swing.JLabel();
        jLabelTamanhoComentario = new javax.swing.JLabel();
        jButtonMais = new javax.swing.JButton();
        jButtonMenos = new javax.swing.JButton();
        jLabelQuantidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes do Produto");

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNome.setText("XIS Lombo");

        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tchefood/src/images/null.png"))); // NOI18N

        jTextAreaOpcionais.setColumns(20);
        jTextAreaOpcionais.setLineWrap(true);
        jTextAreaOpcionais.setRows(5);
        jTextAreaOpcionais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaOpcionaisKeyTyped(evt);
            }
        });
        jScrollPane.setViewportView(jTextAreaOpcionais);
        PromptSupport.setPrompt("Ex: tirar a cebola, maionese à parte, etc.", jTextAreaOpcionais);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, jTextAreaOpcionais);

        jLabelDescricao.setText("<html><p>Pão, hamburguer, ovo, presunto, queijo, milho, ervilha, alface, tomate e maionese.</p></html>");
        jLabelDescricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDescricao.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jButtonAdicionar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionar.setText("Adicionar            R$ 19,90");
        jButtonAdicionar.setBorderPainted(false);
        jButtonAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAdicionarMouseExited(evt);
            }
        });
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabelPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPreco.setForeground(new java.awt.Color(51, 153, 0));
        jLabelPreco.setText("Valor: R$ 19,90");

        jLabelAlgumComentario.setText("Algum comentário?");

        jLabelTamanhoComentario.setText("0/140");

        jButtonMais.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonMais.setText("+");
        jButtonMais.setBorderPainted(false);
        jButtonMais.setContentAreaFilled(false);
        jButtonMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisActionPerformed(evt);
            }
        });

        jButtonMenos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonMenos.setText("-");
        jButtonMenos.setBorderPainted(false);
        jButtonMenos.setContentAreaFilled(false);
        jButtonMenos.setEnabled(false);
        jButtonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosActionPerformed(evt);
            }
        });

        jLabelQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelQuantidade.setText("1");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonMenos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMais)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelFoto)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPreco)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanelLayout.createSequentialGroup()
                                    .addComponent(jLabelAlgumComentario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelTamanhoComentario))
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFoto)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPreco)
                        .addGap(27, 27, 27)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAlgumComentario)
                            .addComponent(jLabelTamanhoComentario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonMais)
                        .addComponent(jButtonMenos)
                        .addComponent(jLabelQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseEntered
        // TODO add your handling code here:
        jButtonAdicionar.setBackground(new java.awt.Color(255, 102, 102));
    }//GEN-LAST:event_jButtonAdicionarMouseEntered

    private void jButtonAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAdicionarMouseExited
        // TODO add your handling code here:
        jButtonAdicionar.setBackground(new java.awt.Color(255, 51, 51));
    }//GEN-LAST:event_jButtonAdicionarMouseExited

    private void jButtonMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisActionPerformed
        // TODO add your handling code here:
        this.quantidade++;
        this.atualizarTotal();
    }//GEN-LAST:event_jButtonMaisActionPerformed

    private void jButtonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosActionPerformed
        // TODO add your handling code here:
        this.quantidade--;
        this.atualizarTotal();
    }//GEN-LAST:event_jButtonMenosActionPerformed

    private void jTextAreaOpcionaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaOpcionaisKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar(); //MELHORAR ESSE CODIGO, BAGUNÇADO
        
        if(qtdeCaracteres == 140)
        {
            if(c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
            {
               jTextAreaOpcionais.setEditable(true); 
            }
            else
            {
               jTextAreaOpcionais.setEditable(false);  
               return;
            }
        }
        
        if(Character.isAlphabetic(c) || Character.isDigit(c) || c == KeyEvent.VK_SPACE) 
        {
            this.qtdeCaracteres = jTextAreaOpcionais.getText().length()+1;
        }
        else if(c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
        {
            this.qtdeCaracteres = jTextAreaOpcionais.getText().length();
        }
        else
        {
            evt.consume();
        }
            jLabelTamanhoComentario.setText(qtdeCaracteres + "/140");
            jLabelTamanhoComentario.updateUI();
            System.out.println(qtdeCaracteres);
    }//GEN-LAST:event_jTextAreaOpcionaisKeyTyped

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        //aqui criar o item do pedido
        //ItensPedidoDAO itensPedidoDAO = new ItensPedidoDAO();
        ModelItensPedido itemPedido = new ModelItensPedido();
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        itemPedido.setProdutoId(produtoDAO.obterProdutoPorID(id));
        
        itemPedido.setPedidoId(pedido);
        
        itemPedido.setQuantidade(quantidade);
        itemPedido.setOpcional(jTextAreaOpcionais.getText());
        
        //itensPedidoDAO.salvar(itemPedido);
        ItensPedidoDAO.salvar(itemPedido);
        
        //JDialogPedidoCardapio.itemsPedido.add(itemPedido);
        this.dispose();
        
        TableModelItensPedido tableModel = new TableModelItensPedido(ItensPedidoDAO.carregarItensDoPedido(pedido.getId()));
        tabela.setModel(tableModel);
        
        //atualizarTabela();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void atualizarTotal()
    {
        this.total = preco * quantidade;
        jLabelQuantidade.setText(String.valueOf(quantidade));
        jButtonAdicionar.setText("Adicionar             R$ " + String.format("%.2f",this.total)); //Meio Gambiarra, depois arrumo
        
        pedido.setTotal(pedido.getTotal() + total);
        
        if(quantidade == 1)
        {
            jButtonMenos.setEnabled(false);
        }
        else
        {
            jButtonMenos.setEnabled(true);
        }
    }
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
            java.util.logging.Logger.getLogger(JDialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                /*jDialogProduto dialog = new jDialogProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() 
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) 
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonMais;
    private javax.swing.JButton jButtonMenos;
    private javax.swing.JLabel jLabelAlgumComentario;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelTamanhoComentario;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jTextAreaOpcionais;
    // End of variables declaration//GEN-END:variables
}
