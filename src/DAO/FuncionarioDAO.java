/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConexaoBanco;
import Modelo.Funcionario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DarthVader
 */
public class FuncionarioDAO {
    private Connection connection;
    private String pesquisa;
    private boolean logar=false;

    public boolean isLogar() {
        return logar;
    }

    public void setLogar(boolean logar) {
        this.logar = logar;
    }
    
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    public FuncionarioDAO(){
         try {
            this.connection = new ConexaoBanco().Conecta();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao conectar!");
        }
    }
    public void adicionaFuncionario(Funcionario funcionario){ 
       
            String sql = "INSERT INTO funcionario(Nome,Endereco,Email,Telefone, Cargo,CPF, Data_nasc, Situacao, Salario, Login, Senha) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEndereco());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getCPF());
            stmt.setString(7, funcionario.getData_nasc());
            stmt.setString(8, funcionario.getSituacao());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setString(10, funcionario.getLogin());
            stmt.setString(11, funcionario.getSenha());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) { 
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar funcionario!\n Erro: " +u);
        } 
        // fim da inserção.
       
        }
    
    public List<Funcionario> ListaFunc() throws SQLException{

        List<Funcionario> listafunc = new ArrayList<>();

        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM funcionario");
        ResultSet resultado = stmt.executeQuery();
        
        while (resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setCod_func(resultado.getLong("Cod_Func"));
            funcionario.setCPF(resultado.getString("CPF"));
            funcionario.setNome(resultado.getString("Nome"));
            funcionario.setEndereco(resultado.getString("Endereco"));
            funcionario.setEmail(resultado.getString("Email"));
            funcionario.setCargo(resultado.getString("Cargo"));
            funcionario.setSituacao(resultado.getString("Situacao"));
            funcionario.setData_nasc(resultado.getString("Data_nasc"));
            funcionario.setTelefone(resultado.getString("Telefone"));
            funcionario.setSalario(resultado.getLong("Salario"));
            funcionario.setLogin(resultado.getString("Login"));
            funcionario.setSenha(resultado.getString("Senha"));
            listafunc.add(funcionario);
        }
        resultado.close();
        stmt.close();
        return listafunc;
    } // finaliza a criaçao da lista
    
    public void buscaFuncionario(Funcionario funcionario){
        PreparedStatement stmt;
        try { //busca pelo cpf
            stmt = this.connection.prepareStatement("SELECT * FROM funcionario where CPF = ?");
            stmt.setString(1, pesquisa);
            ResultSet resultado = stmt.executeQuery();
                  
            while(resultado.next()){
                funcionario.setCod_func(resultado.getLong("Cod_Func"));
                funcionario.setCPF(resultado.getString("CPF"));
                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setEndereco(resultado.getString("Endereco"));
                funcionario.setEmail(resultado.getString("Email"));
                funcionario.setCargo(resultado.getString("Cargo"));
                funcionario.setSituacao(resultado.getString("Situacao"));
                funcionario.setData_nasc(resultado.getString("Data_nasc"));
                funcionario.setTelefone(resultado.getString("Telefone"));
                funcionario.setSalario(resultado.getLong("Salario"));
                funcionario.setLogin(resultado.getString("Login"));
                funcionario.setSenha(resultado.getString("Senha"));
            
            }//fim do while
            resultado.close();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar busca pelo cpf!\n Erro: " +ex);
        }//catch
             
    }//fim do buscarFuncionario
    
    public List<Funcionario> ListaFuncB(String nome) throws SQLException{
        List<Funcionario> listafunc = new ArrayList<Funcionario>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM funcionario WHERE Nome LIKE ?");
        stmt.setString(1, "%"+nome+"%");
        ResultSet resultado = stmt.executeQuery();
        
        while (resultado.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setCod_func(resultado.getLong("Cod_Func"));
            funcionario.setCPF(resultado.getString("CPF"));
            funcionario.setNome(resultado.getString("Nome"));
            funcionario.setEndereco(resultado.getString("Endereco"));
            funcionario.setEmail(resultado.getString("Email"));
            funcionario.setCargo(resultado.getString("Cargo"));
            funcionario.setSituacao(resultado.getString("Situacao"));
            funcionario.setData_nasc(resultado.getString("Data_nasc"));
            funcionario.setTelefone(resultado.getString("Telefone"));
            funcionario.setSalario(resultado.getLong("Salario"));
            funcionario.setLogin(resultado.getString("Login"));
            funcionario.setSenha(resultado.getString("Senha"));
            listafunc.add(funcionario);
        }
        resultado.close();
        stmt.close();
        return listafunc;
    }//finaliza buscaNome

    public void alteraFunc(Funcionario funcionario){
        
        String sql = "UPDATE funcionario set Nome=?,Endereco=?,Email=?,Telefone=?,Cargo=?,CPF=?,Data_nasc=?,Situacao=?,Salario=?,Login=?, Senha=? WHERE Cod_Func=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEndereco());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getCPF());
            stmt.setString(7, funcionario.getData_nasc());
            stmt.setString(8, funcionario.getSituacao());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setString(10, funcionario.getLogin());
            stmt.setString(11, funcionario.getSenha());
            stmt.setString(12, pesquisa);
            stmt.execute();
            stmt.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar funcionario!\n Erro: " +ex);
        }// fim do try
        
    }//fim do alterarfuncionario
   public void buscaLogin(Funcionario funcionario, String login){
        PreparedStatement stmt;
        try {
            stmt = this.connection.prepareStatement("SELECT * FROM funcionario where Login=?");
            stmt.setString(1, login);
            ResultSet resultado = stmt.executeQuery();
                  
            while(resultado.next()){
                
                funcionario.setLogin(resultado.getString("Login"));
                funcionario.setSenha(resultado.getString("Senha"));
                funcionario.setSituacao(resultado.getString("Situacao"));
                funcionario.setCod_func(resultado.getLong("Cod_Func"));
            }//fim do while
          logar = true;        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao realizar login!\n Erro: " +ex);
        }//catch
             
    }//fim do buscarFuncionario
    
}
