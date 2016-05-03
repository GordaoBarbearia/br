package DAO;

import java.sql.*;

import javax.swing.JOptionPane;



/*
 * Classe para abrir ou fechar a conex�o com o banco de dados
 */
public class Conexao {
	private Connection conexao;

	// metodo que retornar a conex�o
	public Connection abreConexao() throws Exception {
		
		// String para pegar o caminho da pasta raiz do projeto.
		String caminho = System.getProperty("user.dir");	
		//driver de conex�o para o SQLite
		Class.forName("org.sqlite.JDBC");
		// Abrindo a conex�o com o banco de dados, que encontra-se na pasta raiz do projeto, na sub-pasta "bd"
		conexao = DriverManager.getConnection("jdbc:sqlite:"+caminho+"\\bd\\BD_GORDAO.db");
		conexao.setAutoCommit(false);
		conexao.setAutoCommit(true);
		
		return conexao;
	}

	//metodo para fechar uma conex�o
	public void fechaConexao() {
			try {
			conexao.close();
			//JOptionPane.showMessageDialog(null, "banco fechado");
		} catch (SQLException fecha) {
			//JOptionPane.showMessageDialog(null, "N�o foi possivel " + "fechar o banco de dados: " + fecha);
		}

	}
}

	

