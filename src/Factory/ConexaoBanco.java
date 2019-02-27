/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DarthVader
 */
public class ConexaoBanco {
    private static final String DriverDB = "com.mysql.jdbc.Driver";
    private static final String URLDB = "jdbc:mysql://localhost:3306/teste";//lembrar de colocar o nome do banco de dados
    private static final String UsuarioDB = "root";
    private static final String SenhaDB = "123";
    
        public Connection Conecta() throws ClassNotFoundException {
		 try {
                        Class.forName(DriverDB);
                        //JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
			return DriverManager.getConnection(URLDB, UsuarioDB, SenhaDB);
                        
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}