package view.produto;

import DAO.CategoriaProdutoDAO;
import DAO.ProdutoDAO;
import Model.ModelCategoriaProduto;
import Model.ProdutoModel;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JDialogCadastrarProduto extends javax.swing.JDialog 
{
    private Image image;
    private String imagemDB = "null.png";
    ArrayList<ModelCategoriaProduto> categorias;
    
    public JDialogCadastrarProduto(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        carregarCategorias();
        
        try 
        {
            image = ImageIO.read(getClass().getResource("/images/null.png"));
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            this.jComboBoxCategoria.addItem(item);
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
        jLabelDescricao = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelFoto = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonCadastrar = new javax.swing.JButton();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro");

        jLabelNome.setText("Nome:");

        jLabelDescricao.setText("Descrição:");

        jTextFieldNome.setMinimumSize(new java.awt.Dimension(64, 25));
        jTextFieldNome.setPreferredSize(new java.awt.Dimension(64, 25));
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setRows(4);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setText("Importar Foto");
        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFotoMouseClicked(evt);
            }
        });

        jLabelCategoria.setText("Categoria:");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        jComboBoxCategoria.setPreferredSize(new java.awt.Dimension(72, 25));

        jButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/check.png"))); // NOI18N
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.setMaximumSize(new java.awt.Dimension(102, 35));
        jButtonCadastrar.setMinimumSize(new java.awt.Dimension(102, 35));
        jButtonCadastrar.setPreferredSize(new java.awt.Dimension(90, 35));
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jLabelPreco.setText("Preço:");

        jTextFieldPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoKeyTyped(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitulo.setText("Cadastrar Produto");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addComponent(jLabelDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCategoria)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabelTitulo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPreco)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelTitulo)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldNome, jTextFieldPreco});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFotoMouseClicked
        try 
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Escolha a Imagem para Importar");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos de Imagens (*.PNG, *.JPG, *.JPEG)", "png", "jpg","jpeg"));

            int escolhido = fileChooser.showOpenDialog(null);

            if(escolhido == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                
                image = ImageIO.read(file);
                ImageIcon icon = new javax.swing.ImageIcon(image.getScaledInstance(jLabelFoto.getWidth(), jLabelFoto.getHeight(), Image.SCALE_SMOOTH));
                
                jLabelFoto.setIcon(icon);
                jLabelFoto.setText(null);
            }
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelFotoMouseClicked

    private void jTextFieldPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        String preco = jTextFieldPreco.getText();
        
        if(c == KeyEvent.VK_COMMA && preco.contains(","))
        {
            evt.consume();    
        }
        if(c == KeyEvent.VK_COMMA && jTextFieldPreco.getText().isBlank())
        {
            evt.consume();    
        }
        if(!Character.isDigit(c) && c != KeyEvent.VK_COMMA)
        {
            evt.consume();    
        }
    }//GEN-LAST:event_jTextFieldPrecoKeyTyped

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        // TODO add your handling code here:
        if(jTextFieldNome.getText().isBlank() || jTextAreaDescricao.getText().isBlank() || jTextFieldPreco.getText().isBlank() || jComboBoxCategoria.getSelectedIndex() < 1)
        {
            JOptionPane.showMessageDialog(this, "Selecione a categoria e preencha todos os campos");
            return;
        }
        
        String nome = jTextFieldNome.getText();
        String descricao = jTextAreaDescricao.getText();
        String preco = jTextFieldPreco.getText();
        
        if(preco.contains(","))
        {
            preco = preco.replace(",", ".");
        }
        
        int numero = 1;
        String nomeImagem = jTextFieldNome.getText(); //melhorar se der tempo
        
        if(nomeImagem.contains("/")) //tem mais de um caracter invalido
        {
            nomeImagem = nomeImagem.replace("/","");
        }
        
        String caminhoParaSalvar = System.getProperty("user.dir"); //pega até a pasta raiz
        caminhoParaSalvar += "\\src\\images\\";

        String caminhoCompleto = caminhoParaSalvar + nomeImagem + ".png";
        
        File outputfile = new File(caminhoCompleto);
        
        while (outputfile.exists()) 
        {
            nomeImagem = jTextFieldNome.getText() + " (" + String.valueOf(numero) + ")";
            outputfile = new File(caminhoParaSalvar + nomeImagem + ".png");
            System.out.println(outputfile);
            numero++;
        }
        
        try 
        {
            ImageIO.write((RenderedImage) image, "png", outputfile);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //imagemDB = "/images/"+nomeImagem+".png";
        imagemDB = nomeImagem+".png";

        
        ProdutoModel produto = new ProdutoModel();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(Double.parseDouble(preco));
        produto.setImagem(imagemDB);
        
        ModelCategoriaProduto categoriaProduto = categorias.get(jComboBoxCategoria.getSelectedIndex()-1);
        produto.setCategoriaProduto(categoriaProduto);
        
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto);
        
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso");
        limparTela();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        String nome = jTextFieldNome.getText();
        
        if(!Character.isLetterOrDigit(c))
        {
            if(c != KeyEvent.VK_SLASH && c != KeyEvent.VK_MINUS && c != KeyEvent.VK_SPACE && c != KeyEvent.VK_PERIOD)
            {
                evt.consume();        
            }
        }
    }//GEN-LAST:event_jTextFieldNomeKeyTyped

    private void limparTela()
    {
        jTextFieldNome.setText(null);
        jTextAreaDescricao.setText(null);
        jTextFieldPreco.setText(null);
        jLabelFoto.setIcon(null);
        jLabelFoto.setText("Importar Imagem");
        jComboBoxCategoria.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                JDialogCadastrarProduto dialog = new JDialogCadastrarProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
