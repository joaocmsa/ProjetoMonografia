/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.EstoqueDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Modelo.Estoque;
import Modelo.Produto;
import ModeloTabela.TabelaEstoqueB;
import ModeloTabela.TabelaItensVenda;
import Modelo.Venda;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author DarthVader
 */
public class RealizaVendaInter extends javax.swing.JFrame {

    /**
     * Creates new form VendaInter
     */
    TabelaItensVenda modelovenda = new TabelaItensVenda();
    TabelaEstoqueB modelo = new TabelaEstoqueB();
    Estoque estoque = new Estoque();
    EstoqueDAO daoestoque = new EstoqueDAO();
    ProdutoDAO daoproduto = new ProdutoDAO();
    Produto produto = new Produto();
    VendaDAO daovenda = new VendaDAO();
    Venda venda = new Venda();
    long codvenda;

    public RealizaVendaInter() {

        initComponents();
        daovenda.CriaVenda();
        daovenda.PegaVenda(venda);
        codvenda = venda.getCod_Venda();
        daovenda.setPesquisa(codvenda);
        jTableProdutos.setModel(modelo);
        jTableListaProd.setModel(modelovenda);
        jTextFieldTotalvenda.setText("0");
        jTextFieldCodigo.setText(String.valueOf(codvenda));

        try {
            MaskFormatter data = new MaskFormatter("##/##/####");
            jTextFieldData.setFormatterFactory(new DefaultFormatterFactory(data));

        } catch (ParseException ex) {
            Logger.getLogger(RealizaVendaInter.class.getName()).log(Level.SEVERE, null, ex);
        }
        GregorianCalendar a = new GregorianCalendar();
        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        
        
        jTextFieldData.setText("00/00/0000");

    }

    public void TabelaProd() {

        try {

            jTableProdutos.setModel(modelo);

            for (Estoque estoque : daoestoque.ListaEstoqueSelecionado()) {
                modelo.addRow(estoque);
            }

            jTableProdutos.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTableProdutos.getColumnModel().getColumn(0).setResizable(false);
            jTableProdutos.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableProdutos.getColumnModel().getColumn(1).setResizable(false);
            jTableProdutos.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableProdutos.getColumnModel().getColumn(2).setResizable(false);
            jTableProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableProdutos.setAutoResizeMode(jTableProdutos.AUTO_RESIZE_OFF);

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioInter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TabelaItens() {

        try {

            jTableListaProd.setModel(modelovenda);

            for (Venda venda : daovenda.ListaProduto()) {
                modelovenda.addRow(venda);
            }

            jTableListaProd.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTableListaProd.getColumnModel().getColumn(0).setResizable(false);
            jTableListaProd.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTableListaProd.getColumnModel().getColumn(1).setResizable(false);
            jTableListaProd.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTableListaProd.getColumnModel().getColumn(2).setResizable(false);
            jTableListaProd.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTableListaProd.getColumnModel().getColumn(3).setResizable(false);
            jTableListaProd.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTableListaProd.getColumnModel().getColumn(4).setResizable(false);
            jTableListaProd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableListaProd.setAutoResizeMode(jTableListaProd.AUTO_RESIZE_OFF);

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioInter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldValorUni = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaProd = new javax.swing.JTable();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodProduto = new javax.swing.JTextField();
        jButtonRemItem = new javax.swing.JButton();
        jButtonAddItem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTotalvenda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonFinalizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldProdutoPesquisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela para realizar vendas");
        setBackground(new java.awt.Color(51, 51, 255));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nome do produto:");

        jTextFieldProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProdutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Quantidade vendida:");

        jTextFieldQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Valor Unitário:");

        jTextFieldValorUni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorUni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldValorUni.setEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Detalhamento da venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableListaProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableListaProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListaProd.setRowHeight(22);
        jScrollPane1.setViewportView(jTableListaProd);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        jLabelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelCodigo.setText("Código do produto:");

        jTextFieldCodProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldCodProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodProdutoFocusLost(evt);
            }
        });

        jButtonRemItem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButtonRemItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Delete-32.png"))); // NOI18N
        jButtonRemItem.setText("Remover item");
        jButtonRemItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRemItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemItemActionPerformed(evt);
            }
        });

        jButtonAddItem.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButtonAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Add-32.png"))); // NOI18N
        jButtonAddItem.setText("Adicionar Item");
        jButtonAddItem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldProduto)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jButtonRemItem, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodProduto))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldValorUni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código da venda:");

        jTextFieldCodigo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTextFieldCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCodigo.setToolTipText("");
        jTextFieldCodigo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data da venda:");

        jTextFieldTotalvenda.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTextFieldTotalvenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTotalvenda.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Total:");

        jTextFieldData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel7.setText("Realizar venda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCodigo))
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldTotalvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTotalvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButtonFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Disk-32.png"))); // NOI18N
        jButtonFinalizar.setText("Gravar");
        jButtonFinalizar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/download.png"))); // NOI18N
        jButtonCancelar.setText("Voltar");
        jButtonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Pesquisas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jButtonPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Magnify-32.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Resultado da pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jTableProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableProdutos.setRowHeight(22);
        jTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProdutos);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Nome do produto:");

        jTextFieldProdutoPesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldProdutoPesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTextFieldProdutoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldProdutoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        setSize(new java.awt.Dimension(966, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:

        try {
            for (Venda venda : daovenda.ListaProduto()) {

                daovenda.pegacodigo(venda.getNome_Prod());

                long quantidadep = venda.getQuant_vend();
                estoque.setQuantidade(quantidadep);
                daoestoque.setPesquisa(daovenda.getPesquisa2());
                daoestoque.EntradaProduto(estoque);

                daovenda.ExcluirProduto();

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cancelar venda!\n Erro: " + ex);
        }
        daovenda.ExcluirVenda();
        dispose();

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        if (jTextFieldProdutoPesquisa.getText().isEmpty()) {
            daoestoque.setPesquisar(jTextFieldProdutoPesquisa.getText());
            modelo.atualiza();
            jTableProdutos.setModel(modelo);
            TabelaProd();
        } else {
            daoestoque.setPesquisar(jTextFieldProdutoPesquisa.getText());
            modelo.atualiza();
            jTableProdutos.setModel(modelo);
            TabelaProd();
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProdutoActionPerformed

    private void jTextFieldCodProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodProdutoFocusLost
        // TODO add your handling code here:
        if (jTextFieldCodProduto.getText().isEmpty()) {

        } else {
            daoproduto.setCods(Long.parseLong(jTextFieldCodProduto.getText()));
            daoproduto.buscaProdutoCod(produto);
            long codigo = produto.getCod_Prod();
            if (codigo == 0) {
                JOptionPane.showMessageDialog(null, "Codigo: " + codigo + ", não esta cadastrado!");
                jTextFieldCodProduto.grabFocus();
            } else {
                String v = String.valueOf(produto.getValor_Venda());
                jTextFieldProduto.setText(produto.getNome_Prod());
                jTextFieldValorUni.setText(v);
            }
        }


    }//GEN-LAST:event_jTextFieldCodProdutoFocusLost

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        // TODO add your handling code here:
        if (jTextFieldQuantidade.getText().isEmpty() || jTextFieldCodProduto.getText().isEmpty()) {
            if (jTextFieldQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite a quantidade do produto!");
                jTextFieldQuantidade.grabFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Digite o código do produto!");
                jTextFieldCodProduto.grabFocus();
            }

        } else {
            long quantidadep = Long.parseLong(jTextFieldQuantidade.getText());

            estoque.setQuantidade(quantidadep);
            daoestoque.setPesquisa(Long.parseLong(jTextFieldCodProduto.getText()));
            daoestoque.SaidaProduto(estoque);
            int vend = daoestoque.getVenda();

            if (vend == 2) {

                BigDecimal valor = new BigDecimal(jTextFieldValorUni.getText());
                BigDecimal quant = new BigDecimal(jTextFieldQuantidade.getText());
                BigDecimal sub;
                BigDecimal total = new BigDecimal(jTextFieldTotalvenda.getText());

                sub = valor.multiply(quant);
                total = total.add(sub);

                venda.setNome_Prod(jTextFieldProduto.getText());
                venda.setQuant_vend(Long.parseLong(jTextFieldQuantidade.getText()));
                venda.setCod_Prod(Long.parseLong(jTextFieldCodProduto.getText()));
                venda.setCod_Venda(codvenda);
                venda.setValor_uni(Double.parseDouble(jTextFieldValorUni.getText()));
                venda.setSub_total(sub);
                daovenda.AdicionaProduto(venda);
                jTextFieldTotalvenda.setText(String.valueOf(total));

                modelovenda.atualiza();
                jTableListaProd.setModel(modelovenda);
                TabelaItens();

            }
            modelo.atualiza();
            jTableProdutos.setModel(modelo);
            TabelaProd();
            jTextFieldCodProduto.setText("");
            jTextFieldProduto.setText("");
            jTextFieldQuantidade.setText("");
            jTextFieldValorUni.setText("");
        }
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jButtonRemItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemItemActionPerformed
        // TODO add your handling code here:
        if (jTableListaProd.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Para remover um item, selecione a linha desejada da tabela!");
        } else if (jTableListaProd.getSelectedRow() != -1) {

            String nome = jTableListaProd.getValueAt(jTableListaProd.getSelectedRow(), 0).toString();
            BigDecimal sub = new BigDecimal(jTableListaProd.getValueAt(jTableListaProd.getSelectedRow(), 4).toString());
            BigDecimal total = new BigDecimal(jTextFieldTotalvenda.getText());

            total = total.subtract(sub);

            daovenda.pegacodigo(nome);

            long quantidadep = (long) jTableListaProd.getValueAt(jTableListaProd.getSelectedRow(), 3);
            estoque.setQuantidade(quantidadep);
            daoestoque.setPesquisa(daovenda.getPesquisa2());
            daoestoque.EntradaProduto(estoque);

            daovenda.ExcluirProduto();

            jTextFieldTotalvenda.setText(String.valueOf(total));
            modelovenda.atualiza();
            jTableListaProd.setModel(modelovenda);
            TabelaItens();

            modelo.atualiza();
            jTableProdutos.setModel(modelo);
            TabelaProd();
        }
    }//GEN-LAST:event_jButtonRemItemActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        // TODO add your handling code here:

        String y = "00/00/0000";
        if (jTextFieldData.getText().equals(y)) {
            JOptionPane.showMessageDialog(null, "Digite o dia da venda!");
            jTextFieldData.grabFocus();
        } else {

            BigDecimal total = new BigDecimal(jTextFieldTotalvenda.getText());
            daovenda.mudaData(jTextFieldData.getText());
            venda.setData_Venda(daovenda.getData_certa());
            venda.setValor_Total(total);

            daovenda.AtualizaVenda(venda);

            PgmVenda paga = new PgmVenda(this);
            paga.setVisible(true);
        }
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    private void jTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProdutosMouseClicked
        // TODO add your handling code here:

        if (jTableProdutos.getSelectedRow() != -1) {

            jTextFieldCodProduto.setText("");
            jTextFieldValorUni.setText("");
            jTextFieldProduto.setText("");

            daoproduto.pegacod(jTableProdutos.getValueAt(jTableProdutos.getSelectedRow(), 0).toString());
            daoproduto.buscaProdutoCod(produto);

            String cod, venda;
            cod = String.valueOf(produto.getCod_Prod());
            venda = String.valueOf(produto.getValor_Venda());

            jTextFieldCodProduto.setText(cod);
            jTextFieldValorUni.setText(venda);
            jTextFieldProduto.setText(produto.getNome_Prod());

            jTextFieldQuantidade.grabFocus();
            jTextFieldQuantidade.setText("");
        }

    }//GEN-LAST:event_jTableProdutosMouseClicked

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
            java.util.logging.Logger.getLogger(RealizaVendaInter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizaVendaInter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizaVendaInter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizaVendaInter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizaVendaInter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableListaProd;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldCodProduto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldProduto;
    private javax.swing.JTextField jTextFieldProdutoPesquisa;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldTotalvenda;
    private javax.swing.JTextField jTextFieldValorUni;
    // End of variables declaration//GEN-END:variables
}
