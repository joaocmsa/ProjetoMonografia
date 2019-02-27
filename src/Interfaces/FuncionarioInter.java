/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.FuncionarioDAO;
import Modelo.Funcionario;
import ModeloTabela.TabelaFuncionario;
import java.sql.SQLException;
import java.text.ParseException;
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
public class FuncionarioInter extends javax.swing.JFrame {

    /**
     * Creates new form FuncionarioInter
     */
    FuncionarioDAO dao = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();
    TabelaFuncionario modelo = new TabelaFuncionario();

    public FuncionarioInter() {
        initComponents();

        jButtonAlterar.setEnabled(false);
        try {
            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            jTextFieldCPF.setFormatterFactory(new DefaultFormatterFactory(cpf));
            MaskFormatter tel = new MaskFormatter("(##) #####-####");
            jTextFieldTelefone.setFormatterFactory(new DefaultFormatterFactory(tel));
            MaskFormatter data = new MaskFormatter("##/##/####");
            jTextFieldDataNasc.setFormatterFactory(new DefaultFormatterFactory(data));

        } catch (ParseException ex) {
            Logger.getLogger(FornecedorInter.class.getName()).log(Level.SEVERE, null, ex);
        }

        jTableFuncionario.setModel(modelo);
        Tabela();
    }

    public void Tabela() {

        try {

            jTableFuncionario.setModel(modelo);
            for (Funcionario funcionario : dao.ListaFunc()) {
                modelo.addRow(funcionario);
            }

            jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTableFuncionario.getColumnModel().getColumn(0).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTableFuncionario.getColumnModel().getColumn(1).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTableFuncionario.getColumnModel().getColumn(2).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTableFuncionario.getColumnModel().getColumn(3).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableFuncionario.getColumnModel().getColumn(4).setResizable(false);
            jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableFuncionario.setRowHeight(22);
            jTableFuncionario.setAutoResizeMode(jTableFuncionario.AUTO_RESIZE_OFF);

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioInter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Tabela2(String nome) {

        try {

            jTableFuncionario.setModel(modelo);
            for (Funcionario funcionario : dao.ListaFuncB(nome)) {
                modelo.addRow(funcionario);
            }

            jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(75);
            jTableFuncionario.getColumnModel().getColumn(0).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTableFuncionario.getColumnModel().getColumn(1).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTableFuncionario.getColumnModel().getColumn(2).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(95);
            jTableFuncionario.getColumnModel().getColumn(3).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTableFuncionario.getColumnModel().getColumn(4).setResizable(false);
            jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTableFuncionario.setRowHeight(22);
            jTableFuncionario.setAutoResizeMode(jTableFuncionario.AUTO_RESIZE_OFF);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioInter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCod_Func = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNome_Func = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldSituacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCargo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldSalario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDataNasc = new javax.swing.JFormattedTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldCPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButtonGravar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setPreferredSize(new java.awt.Dimension(710, 277));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setText("Cadastro de funcionários");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Código:");

        jTextFieldCod_Func.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldCod_Func.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCod_Func.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("CPF:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nome:");

        jTextFieldNome_Func.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldNome_Func.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextFieldTelefone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Endereço:");

        jTextFieldEndereco.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Situação:");

        jTextFieldSituacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldSituacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSituacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSituacaoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("E-mail:");

        jTextFieldLogin.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setText("Login:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Senha:");

        jPasswordFieldSenha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPasswordFieldSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Cargo:");

        jTextFieldCargo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldCargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setText("Salário: R$");

        jTextFieldSalario.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldSalario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Data de nascimento:");

        jTextFieldDataNasc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDataNasc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jTextFieldCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextFieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Telefone:");

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Magnify-32.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setToolTipText("");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCod_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCod_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNome_Func, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonGravar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Disk-32.png"))); // NOI18N
        jButtonGravar.setText("Gravar");
        jButtonGravar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-Edit-32.png"))); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Report-32.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setToolTipText("");
        jButtonLimpar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonVoltar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButtonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/download.png"))); // NOI18N
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Funcionários cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        jTableFuncionario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFuncionario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(916, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here
        // validação de campos, verificar se não estão vazios.
        if ((jTextFieldNome_Func.getText().isEmpty()) || (jTextFieldCPF.getText().isEmpty()) || (jTextFieldTelefone.getText().isEmpty())
                || (jTextFieldEndereco.getText().isEmpty()) || (jTextFieldCargo.getText().isEmpty()) || (jTextFieldEmail.getText().isEmpty())
                || (jTextFieldDataNasc.getText().isEmpty()) || (jTextFieldSalario.getText().isEmpty()) || (jTextFieldLogin.getText().isEmpty()) || (jPasswordFieldSenha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "os campos nao podem estar em branco!");
        } else {
            // Instancia um objeto da classe funcionario e insere valores nas variaveis.

            double salario = Double.parseDouble(jTextFieldSalario.getText());

            funcionario.setCPF(jTextFieldCPF.getText());
            funcionario.setNome(jTextFieldNome_Func.getText());
            funcionario.setEndereco(jTextFieldEndereco.getText());
            funcionario.setEmail(jTextFieldEmail.getText());
            funcionario.setCargo(jTextFieldCargo.getText());
            funcionario.setSituacao(jTextFieldSituacao.getText());
            funcionario.setData_nasc(jTextFieldDataNasc.getText());
            funcionario.setTelefone(jTextFieldTelefone.getText());
            funcionario.setSalario(salario);
            funcionario.setLogin(jTextFieldLogin.getText());
            funcionario.setSenha(jPasswordFieldSenha.getText());
            /**
             * instanciar a classe FuncionarioCRUD do pacote CRUD e cria seu
             * objeto, para fazer a inserção das informações no banco de dados
             */
            FuncionarioDAO adiciona = new FuncionarioDAO();

            adiciona.adicionaFuncionario(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário " + jTextFieldNome_Func.getText() + " inserido com sucesso! ");
        }

        // Realiza a limpeza dos campos após a inserção.    
        jTextFieldCPF.setText("");
        jTextFieldNome_Func.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCargo.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldDataNasc.setText("");
        jTextFieldSalario.setText("");
        jTextFieldSituacao.setText("");
        jPasswordFieldSenha.setText("");
        jTextFieldLogin.setText("");
        modelo.atualiza();
        jTableFuncionario.setModel(modelo);
        Tabela();
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
        // Realiza a limpeza dos campos após a inserção.    
        jTextFieldCPF.setText("");
        jTextFieldCod_Func.setText("");
        jTextFieldNome_Func.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCargo.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldDataNasc.setText("");
        jTextFieldSalario.setText("");
        jTextFieldSituacao.setText("");
        jPasswordFieldSenha.setText("");
        jTextFieldLogin.setText("");

        jButtonGravar.setEnabled(!false);
        jButtonAlterar.setEnabled(!true);
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTableFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionarioMouseClicked
        // TODO add your handling code here:
        if (jTableFuncionario.getSelectedRow() != -1) {
            jTextFieldCPF.setText("");
            jTextFieldNome_Func.setText("");
            jTextFieldEndereco.setText("");
            jTextFieldEmail.setText("");
            jTextFieldCargo.setText("");
            jTextFieldTelefone.setText("");
            jTextFieldDataNasc.setText("");
            jTextFieldSalario.setText("");
            jTextFieldSituacao.setText("");

            dao.setPesquisa(jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 2).toString());
            dao.buscaFuncionario(funcionario);
            String cod, cpf, tel, sala;
            cod = String.valueOf(funcionario.getCod_func());
            sala = String.valueOf(funcionario.getSalario());

            jTextFieldCod_Func.setText(cod);
            jTextFieldCPF.setText(funcionario.getCPF());
            jTextFieldNome_Func.setText(funcionario.getNome());
            jTextFieldEndereco.setText(funcionario.getEndereco());
            jTextFieldEmail.setText(funcionario.getEmail());
            jTextFieldCargo.setText(funcionario.getCargo());
            jTextFieldTelefone.setText(funcionario.getTelefone());
            jTextFieldDataNasc.setText(funcionario.getData_nasc());
            jTextFieldSalario.setText(sala);
            jTextFieldSituacao.setText(funcionario.getSituacao());
            jPasswordFieldSenha.setText(funcionario.getSenha());
            jTextFieldLogin.setText(funcionario.getLogin());

            jButtonGravar.setEnabled(false);
            jButtonAlterar.setEnabled(true);
        }

    }//GEN-LAST:event_jTableFuncionarioMouseClicked

    private void jTextFieldSituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSituacaoActionPerformed

    private void jTextFieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPFActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        String cpf = "   .   .   -  ";
        if (jTextFieldNome_Func.getText().isEmpty() && jTextFieldCPF.getText().equals(cpf)) {
            
            JOptionPane.showMessageDialog(null, "Para realizar uma busca digite o CPF ou o nome do funcionário!");
            jTextFieldCPF.grabFocus();
            
        } else if (!jTextFieldCPF.getText().equals(cpf)) {

            dao.setPesquisa(jTextFieldCPF.getText());
            dao.buscaFuncionario(funcionario);
            String cod, tel, sala;
            cod = String.valueOf(funcionario.getCod_func());
            sala = String.valueOf(funcionario.getSalario());

            JOptionPane.showMessageDialog(null, "Busca efetuada com sucesso!");

            jTextFieldCod_Func.setText(cod);
            jTextFieldNome_Func.setText(funcionario.getNome());
            jTextFieldEndereco.setText(funcionario.getEndereco());
            jTextFieldEmail.setText(funcionario.getEmail());
            jTextFieldCargo.setText(funcionario.getCargo());
            jTextFieldTelefone.setText(funcionario.getTelefone());
            jTextFieldDataNasc.setText(funcionario.getData_nasc());
            jTextFieldSalario.setText(sala);
            jTextFieldSituacao.setText(funcionario.getSituacao());
            jPasswordFieldSenha.setText(funcionario.getSenha());
            jTextFieldLogin.setText(funcionario.getLogin());

            jButtonGravar.setEnabled(false);
            jButtonAlterar.setEnabled(true);
            
        } else if (!jTextFieldNome_Func.getText().isEmpty()) {
            modelo.atualiza();
            jTableFuncionario.setModel(modelo);
            Tabela2(jTextFieldNome_Func.getText());

        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        // validação de campos, verificar se não estão vazios.
        if ((jTextFieldNome_Func.getText().isEmpty()) || (jTextFieldCPF.getText().isEmpty()) || (jTextFieldTelefone.getText().isEmpty())
            || (jTextFieldEndereco.getText().isEmpty()) || (jTextFieldCargo.getText().isEmpty()) || (jTextFieldEmail.getText().isEmpty())
            || (jTextFieldDataNasc.getText().isEmpty()) || (jTextFieldSalario.getText().isEmpty()) || (jTextFieldLogin.getText().isEmpty()) || (jPasswordFieldSenha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "os campos nao podem estar em branco!");
        } else {
            // Instancia um objeto da classe funcionario e insere valores nas variaveis.

            double salario = Double.parseDouble(jTextFieldSalario.getText());

            funcionario.setCPF(jTextFieldCPF.getText());
            funcionario.setNome(jTextFieldNome_Func.getText());
            funcionario.setEndereco(jTextFieldEndereco.getText());
            funcionario.setEmail(jTextFieldEmail.getText());
            funcionario.setCargo(jTextFieldCargo.getText());
            funcionario.setSituacao(jTextFieldSituacao.getText());
            funcionario.setData_nasc(jTextFieldDataNasc.getText());
            funcionario.setTelefone(jTextFieldTelefone.getText());
            funcionario.setSalario(salario);
            funcionario.setLogin(jTextFieldLogin.getText());
            funcionario.setSenha(jPasswordFieldSenha.getText());
            /**
            * instanciar a classe FuncionarioCRUD do pacote CRUD e cria seu
            * objeto, para fazer a atualização das informações no cadastro
            */
            dao.setPesquisa(jTextFieldCod_Func.getText());
            dao.alteraFunc(funcionario);
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso! ");
        }

        // Realiza a limpeza dos campos após a inserção.
        jTextFieldCPF.setText("");
        jTextFieldNome_Func.setText("");
        jTextFieldEndereco.setText("");
        jTextFieldEmail.setText("");
        jTextFieldCargo.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldDataNasc.setText("");
        jTextFieldSalario.setText("");
        jTextFieldSituacao.setText("");
        jButtonGravar.setEnabled(!false);
        jButtonAlterar.setEnabled(!true);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(FuncionarioInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioInter().setVisible(true);
            }
        });
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JFormattedTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCod_Func;
    private javax.swing.JFormattedTextField jTextFieldDataNasc;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome_Func;
    private javax.swing.JTextField jTextFieldSalario;
    private javax.swing.JTextField jTextFieldSituacao;
    private javax.swing.JFormattedTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
