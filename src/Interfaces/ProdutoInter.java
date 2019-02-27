package Interfaces;

import DAO.EstoqueDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Factory.ConexaoBanco;
import Modelo.Estoque;
import Modelo.Produto;
import ModeloTabela.TabelaProduto;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.BrownSugar;
import com.jgoodies.looks.plastic.theme.DarkStar;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.jgoodies.looks.plastic.theme.DesertGreen;
import com.jgoodies.looks.plastic.theme.DesertYellow;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import com.jgoodies.looks.plastic.theme.ExperienceRoyale;
import com.jgoodies.looks.plastic.theme.LightGray;
import com.jgoodies.looks.plastic.theme.SkyBlue;
import com.jgoodies.looks.plastic.theme.SkyBluer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ProdutoInter extends javax.swing.JFrame {

    /**
     * Creates new form ProdutoInter
     */
    TabelaProduto modelo = new TabelaProduto();
    ProdutoDAO daoproduto = new ProdutoDAO();
    Produto produto = new Produto();
    Estoque estoque = new Estoque();
    EstoqueDAO daoestoque = new EstoqueDAO();
    VendaDAO daovenda = new VendaDAO();
    
    public ProdutoInter() {

        initComponents();
        Connection connection;

        jTableProduto.setModel(modelo);
        Tabela();

        try {
            //realiza o preenchimento do combobox fornecedor.
            String sql = "SELECT * FROM fornecedor ORDER BY Nome_Fantasia";
            connection = new ConexaoBanco().Conecta();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            jComboBoxFornecedor.removeAllItems();
            resultado.first();

            do {
                jComboBoxFornecedor.addItem(resultado.getString("Nome_Fantasia"));
            } while (resultado.next());
            resultado.close();
            stmt.close();

            String sqle = "SELECT * FROM fabricante ORDER BY Nome_Fab";
            connection = new ConexaoBanco().Conecta();
            PreparedStatement stmte = connection.prepareStatement(sqle);
            ResultSet resultados = stmte.executeQuery();
            jComboBoxFab.removeAllItems();
            resultados.first();

            do {
                jComboBoxFab.addItem(resultados.getString("Nome_Fab"));
            } while (resultados.next());
            resultados.close();
            stmte.close();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar!\n" + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer busca!\n" + ex);
        }
    }//fim ProdutoInter();

    public void Tabela() {

        try {
            for (Produto produto : daoproduto.ListaProd()) {
                modelo.addRow(produto);
            }
            jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableProduto.getColumnModel().getColumn(0).setResizable(false);
            jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(465);
            jTableProduto.getColumnModel().getColumn(1).setResizable(false);
            jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableProduto.getColumnModel().getColumn(2).setResizable(false);
            jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableProduto.getColumnModel().getColumn(3).setResizable(false);
            jTableProduto.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableProduto.getColumnModel().getColumn(4).setResizable(false);
            jTableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableProduto.setRowHeight(22);
            jTableProduto.setAutoResizeMode(jTableProduto.AUTO_RESIZE_OFF);

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Tabela2() {

        try {
            for (Produto produto : daoproduto.ListaProdB()) {
                modelo.addRow(produto);
            }
            jTableProduto.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableProduto.getColumnModel().getColumn(0).setResizable(false);
            jTableProduto.getColumnModel().getColumn(1).setPreferredWidth(465);
            jTableProduto.getColumnModel().getColumn(1).setResizable(false);
            jTableProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableProduto.getColumnModel().getColumn(2).setResizable(false);
            jTableProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableProduto.getColumnModel().getColumn(3).setResizable(false);
            jTableProduto.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableProduto.getColumnModel().getColumn(4).setResizable(false);
            jTableProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableProduto.setRowHeight(22);
            jTableProduto.setAutoResizeMode(jTableProduto.AUTO_RESIZE_OFF);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNomeProd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFab = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldQuantMin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxFornecedor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldValorCompra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldValorVenda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonGravar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de cadastro de produtos");
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Código:");

        jTextFieldCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoFocusLost(evt);
            }
        });
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Nome:");

        jTextFieldNomeProd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldNomeProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Fabricante:");

        jComboBoxFab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxFab.setMaximumRowCount(5);
        jComboBoxFab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Quantidade mínima:");

        jTextFieldQuantMin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Fornecedor:");

        jComboBoxFornecedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxFornecedor.setMaximumRowCount(5);
        jComboBoxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFornecedorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Valor de compra: R$");

        jTextFieldValorCompra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorCompra.setToolTipText("Utilize o ponto(.) para separar o real dos centavos. EX: 0.99");
        jTextFieldValorCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorCompraActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Valor de venda: R$");

        jTextFieldValorVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorVenda.setToolTipText("Utilize o ponto(.) para separar o real dos centavos. EX: 0.99");
        jTextFieldValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorVendaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Descrição:");

        jTextFieldDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel10.setText("Cadastro de produtos");

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Magnify-32.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonPesquisarMousePressed(evt);
            }
        });
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldQuantMin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDescricao)))
                        .addGap(10, 10, 10))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldQuantMin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxFab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonGravar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Disk-32.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Edit-32.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-32.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/download.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Produtos cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jTableProduto.setAutoCreateRowSorter(true);
        jTableProduto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduto);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(916, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorVendaActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
        // validação de campos, verificar se não estão vazios.
        if ((jTextFieldNomeProd.getText().isEmpty()) || (jTextFieldQuantMin.getText().isEmpty())
            || (jTextFieldDescricao.getText().isEmpty()) || (jTextFieldValorCompra.getText().isEmpty())
            || (jTextFieldValorVenda.getText().isEmpty()) || (jTextFieldCodigo.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Os campos não podem estar em branco!");
        } else {
            daoproduto.setPesquisa(jTextFieldCodigo.getText());
            long cod = Long.parseLong(jTextFieldCodigo.getText());
            daoproduto.buscaProdutoCod(produto);
            long codig = produto.getCod_Prod();

            if (cod == codig) {//validação para nao cadastrar codigos iguais
                JOptionPane.showMessageDialog(null, "Este código já esta cadastrado!"
                        + "\nCódigo cadastrado como: " + produto.getNome_Prod());
                daoproduto.setPesquisa("");
                jTextFieldCodigo.grabFocus();
            } else {
                try {
                    Connection con = new ConexaoBanco().Conecta();
                    
                    PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor where Nome_Fantasia = ?");
                    stmt.setString(1, (String) jComboBoxFornecedor.getSelectedItem());
                    ResultSet resultado = stmt.executeQuery();
                    resultado.first();

                    PreparedStatement stmte = con.prepareStatement("SELECT * FROM fabricante where Nome_Fab = ?");
                    stmte.setString(1, (String) jComboBoxFab.getSelectedItem());
                    ResultSet resultados = stmte.executeQuery();
                    resultados.first();

                    int codfab = resultados.getInt("Cod_Fab");
                    long codfornc = resultado.getLong("Cod_Fornc");
                    
                    BigDecimal Compra, Venda;
                    Compra = new BigDecimal(jTextFieldValorCompra.getText());
                    Venda = new BigDecimal(jTextFieldValorVenda.getText());
                    long codigo = Long.parseLong(jTextFieldCodigo.getText());
                    long quantidade = Long.parseLong(jTextFieldQuantMin.getText());
                    estoque.setProduto_Nome_Prod(jTextFieldNomeProd.getText());
                    produto.setCod_Forn(codfornc);
                    produto.setCod_Prod(codigo);
                    produto.setNome_Prod(jTextFieldNomeProd.getText());
                    produto.setDescricao(jTextFieldDescricao.getText());
                    produto.setQuant_minima(quantidade);
                    produto.setValor_Compra(Compra);
                    produto.setValor_Venda(Venda);
                    produto.setCod_Fab(codfab);
                    // Adiciona o novo produto no estoque com a quatidade 0.
                    estoque.setCod_func(9);
                    estoque.setProduto_Cod_Prod(codigo);
                    estoque.setQuantidade(0);
                    /**
                     * instanciar a classe ProdutoCRUD pacote dao e criar seu
                     * objeto, para fazer a inserção das informações no banco de
                     * dados
                     */

                    daoproduto.adicionaProduto(produto);

                    daoestoque.AdicionaEstoque(estoque);

                    resultado.close();
                    resultados.close();
                    stmt.close();
                    stmte.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar!\n Erro:" + ex);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!\n Erro:" + ex);
                }
            }
            // Realiza a limpeza dos campos após a inserção.    
            jTextFieldNomeProd.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldQuantMin.setText("");
            jTextFieldValorCompra.setText("");
            jTextFieldValorVenda.setText("");
            jTextFieldCodigo.setText("");

        }//fim do else

        modelo.atualiza();
        jTableProduto.setModel(modelo);
        Tabela();
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        // Realiza a limpeza dos campos. 
        jButtonGravar.setEnabled(true);
        jButtonAlterar.setEnabled(false);

        jTextFieldCodigo.setText("");
        jTextFieldNomeProd.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldQuantMin.setText("");
        jTextFieldValorCompra.setText("");
        jTextFieldValorVenda.setText("");
        
        modelo.atualiza();
        jTableProduto.setModel(modelo);
        Tabela();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        // validação de campos, verificar se não estão vazios.
        if ((jTextFieldNomeProd.getText().isEmpty()) || (jTextFieldQuantMin.getText().isEmpty())
                || (jTextFieldDescricao.getText().isEmpty()) || (jTextFieldValorCompra.getText().isEmpty())
                || (jTextFieldValorVenda.getText().isEmpty()) || (jTextFieldCodigo.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos nao podem estar em branco!");
        } else {
            try {
                // Instancia a classe produto no pacote modelo e cria o objeto produto, inserindo valores nas suas variaveis.
                Connection con = new ConexaoBanco().Conecta();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor where Nome_Fantasia = ?");
                stmt.setString(1, (String) jComboBoxFornecedor.getSelectedItem());
                ResultSet resultado = stmt.executeQuery();
                resultado.first();

                PreparedStatement stmte = con.prepareStatement("SELECT * FROM fabricante where Nome_Fab = ?");
                stmte.setString(1, (String) jComboBoxFab.getSelectedItem());
                ResultSet resultados = stmte.executeQuery();
                resultados.first();

                long codfab = resultados.getLong("Cod_Fab");
                long codfornc = resultado.getLong("Cod_Fornc");
                BigDecimal Compra, Venda;
                Compra = new BigDecimal(jTextFieldValorCompra.getText());
                Venda = new BigDecimal(jTextFieldValorVenda.getText());
                long codigo = Long.parseLong(jTextFieldCodigo.getText());
                long quantidade = Long.parseLong(jTextFieldQuantMin.getText());

                produto.setCod_Forn(codfornc);
                produto.setCod_Prod(codigo);
                produto.setNome_Prod(jTextFieldNomeProd.getText());
                produto.setDescricao(jTextFieldDescricao.getText());
                produto.setQuant_minima(quantidade);
                produto.setValor_Compra(Compra);
                produto.setValor_Venda(Venda);

                /**
                 * instanciar a classe ProdutoCRUD pacote dao e criar seu
                 * objeto, para fazer a inserção das informações no banco de
                 * dados
                 */
                daoproduto.setPesquisa(jTextFieldCodigo.getText());
                daoproduto.alteraProduto(produto);
                JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");

                resultado.close();
                resultados.close();
                stmt.close();
                stmte.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // Realiza a limpeza dos campos após a inserção.    
        jTextFieldNomeProd.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldQuantMin.setText("");
        jTextFieldValorCompra.setText("");
        jTextFieldValorVenda.setText("");
        jTextFieldCodigo.setText("");
        jButtonGravar.setEnabled(true);
        jButtonAlterar.setEnabled(!true);

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTextFieldValorCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorCompraActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFornecedorActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNomeProd.getText().isEmpty() && jTextFieldCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Para realizar uma busca digite o nome"
                    + " ou o código do produto!");
        } else if (!jTextFieldNomeProd.getText().isEmpty()) {//pesquisa por nome
            daoproduto.setPesquisa(jTextFieldNomeProd.getText());
            modelo.atualiza();
            jTableProduto.setModel(modelo);
            Tabela2();
            
            jButtonAlterar.setEnabled(true);
            jButtonGravar.setEnabled(false);
        } else if (!jTextFieldCodigo.getText().isEmpty()) {//pesquisa por código
            try {

                daoproduto.setCods(Long.parseLong(jTextFieldCodigo.getText()));
                daoproduto.buscaProdutoCod(produto);

                String cod, compra, venda, quant, fornecedor, fabricante;
                cod = String.valueOf(produto.getCod_Prod());
                compra = String.valueOf(produto.getValor_Compra());
                venda = String.valueOf(produto.getValor_Venda());
                quant = String.valueOf(produto.getQuant_minima());
                long forn = produto.getCod_Forn();
                long fab = produto.getCod_Fab();

                JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");

                Connection con = new ConexaoBanco().Conecta();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor where Cod_Fornc = ?");
                stmt.setLong(1, forn);
                ResultSet resultado = stmt.executeQuery();
                resultado.first();
                fornecedor = resultado.getString("Nome_Fantasia");

                PreparedStatement stmte = con.prepareStatement("SELECT * FROM fabricante where Cod_Fab = ?");
                stmte.setLong(1, fab);
                ResultSet resultados = stmte.executeQuery();
                resultados.first();

                fabricante = resultados.getString("Nome_Fab");

                jComboBoxFab.setSelectedItem(fabricante);
                jComboBoxFornecedor.setSelectedItem(fornecedor);
                jTextFieldCodigo.setText(cod);
                jTextFieldNomeProd.setText(produto.getNome_Prod());
                jTextFieldDescricao.setText(produto.getDescricao());
                jTextFieldQuantMin.setText(quant);
                jTextFieldValorCompra.setText(compra);
                jTextFieldValorVenda.setText(venda);
                
                jButtonAlterar.setEnabled(true);
                jButtonGravar.setEnabled(false);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            }//fim do catch
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonPesquisarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPesquisarMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonPesquisarMousePressed

    private void jTableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutoMouseClicked
        // TODO add your handling code here:

        if (jTableProduto.getSelectedRow() != -1) {

            jTextFieldNomeProd.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldQuantMin.setText("");
            jTextFieldValorCompra.setText("");
            jTextFieldValorVenda.setText("");
            jTextFieldCodigo.setText("");

            try {

                daoproduto.setCods((long)jTableProduto.getValueAt(jTableProduto.getSelectedRow(), 0));
                daoproduto.buscaProdutoCod(produto);

                String cod, compra, venda, quant, fornecedor, fabricante;
                cod = String.valueOf(produto.getCod_Prod());
                compra = String.valueOf(produto.getValor_Compra());
                venda = String.valueOf(produto.getValor_Venda());
                quant = String.valueOf(produto.getQuant_minima());
                long forn = produto.getCod_Forn();
                long fab = produto.getCod_Fab();

                Connection con = new ConexaoBanco().Conecta();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor where Cod_Fornc = ?");
                stmt.setLong(1, forn);
                ResultSet resultado = stmt.executeQuery();
                resultado.first();
                fornecedor = resultado.getString("Nome_Fantasia");

                PreparedStatement stmte = con.prepareStatement("SELECT * FROM fabricante where Cod_Fab = ?");
                stmte.setLong(1, fab);
                ResultSet resultados = stmte.executeQuery();
                resultados.first();

                fabricante = resultados.getString("Nome_Fab");

                jComboBoxFab.setSelectedItem(fabricante);
                jComboBoxFornecedor.setSelectedItem(fornecedor);
                jTextFieldCodigo.setText(cod);
                jTextFieldNomeProd.setText(produto.getNome_Prod());
                jTextFieldDescricao.setText(produto.getDescricao());
                jTextFieldQuantMin.setText(quant);
                jTextFieldValorCompra.setText(compra);
                jTextFieldValorVenda.setText(venda);

                jButtonAlterar.setEnabled(true);
                jButtonGravar.setEnabled(false);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoInter.class.getName()).log(Level.SEVERE, null, ex);
            }//fim do catch 
        }

    }//GEN-LAST:event_jTableProdutoMouseClicked

    private void jTextFieldCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoFocusLost

    }//GEN-LAST:event_jTextFieldCodigoFocusLost

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ProdutoInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoInter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxFab;
    private javax.swing.JComboBox<String> jComboBoxFornecedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldNomeProd;
    private javax.swing.JTextField jTextFieldQuantMin;
    private javax.swing.JTextField jTextFieldValorCompra;
    private javax.swing.JTextField jTextFieldValorVenda;
    // End of variables declaration//GEN-END:variables
}
