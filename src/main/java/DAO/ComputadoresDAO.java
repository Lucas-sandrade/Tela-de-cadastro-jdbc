/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.lojainformatica.domain.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Andrade
 */
public class ComputadoresDAO {
    
    static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    static String login = "root";
    static String senha = "Lucas2000";
    
    public static boolean cadastrar(Computador obj){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("INSERT INTO computadores (MARCA,HD,PROCESSADOR) VALUES(?,?,?) "
                                    , PreparedStatement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setString(1, obj.getMarca());
            comandoSQL.setString(2, obj.getHD());
            comandoSQL.setString(3, obj.getProcessador());
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs != null){
                    while(rs.next()){
                        int idGerado = rs.getInt(1);
                        obj.setIdComputador(idGerado);
                    }
                }
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        
        
        return retorno;
    }//fim do método salvar
    
    
      public static ArrayList<Computador> listar(){
    
        ArrayList<Computador> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM computadores");
            
            //Passo 4 - Executar a CONSULTA
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
            
                while(rs.next()){
                    
                    int id = rs.getInt("ID_COMPUTADOR");
                    String marca = rs.getString("MARCA");
                    String hd = rs.getString("HD");
                    String processador = rs.getString("PROCESSADOR");
                    
                    Computador item = new Computador(id, marca, hd, processador );
                    
                    lista.add(item);
                    
                }
            
            }
            
        } catch (Exception e) {
            lista = null;
        }finally{
        
            if(conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        return lista;
    }//Fim do método listar
      
      
       public static ArrayList<Computador> buscarPorProcessador(String buscarProcessador){
    
        ArrayList<Computador> lista = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        ResultSet rs = null;
        
        try {
            
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = conexao.prepareStatement("SELECT * FROM computadores WHERE PROCESSADOR = ?");
            comandoSQL.setString(1, buscarProcessador);
            
            //Passo 4 - Executar a CONSULTA
            rs = comandoSQL.executeQuery();
            
            if(rs != null){
            
                while(rs.next()){
                    
                    int id = rs.getInt("ID_COMPUTADOR");
                    String marca = rs.getString("MARCA");
                    String hd = rs.getString("HD");
                    String processador = rs.getString("PROCESSADOR");
                    
                    Computador item = new Computador(id, marca, hd, processador );
                    
                    lista.add(item);
                    
                }
            
            }
            
        } catch (Exception e) {
            lista = null;
        }finally{
        
            if(conexao!=null){
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ComputadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        return lista;
    }
    
 public static boolean alterar(Computador obj){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("UPDATE computadores SET MARCA = ?, HD = ?, PROCESSADOR = ? WHERE ID_COMPUTADOR = ?"  );
            
         
            comandoSQL.setString(2, obj.getMarca());
            comandoSQL.setString(3, obj.getHD());
            comandoSQL.setString(4, obj.getProcessador());
            
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        
        
        return retorno;
    }
    
    
    public static boolean excluir(int idExcluir){
        
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement comandoSQL = null;
        
        try {
            //Receita de bolo para acessar o banco de dados
            //Passo 1 - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Passo 2 - Abrir a conexão com o banco
            conexao = DriverManager.getConnection(url, login, senha);
            
            //Passo 3 - Preparar o comando SQL
            comandoSQL = 
            conexao.prepareStatement("DELETE FROM computadores WHERE ID_COMPUTADOR = ?"  );
            
            comandoSQL.setInt(1, idExcluir);
            
            //Passo 4 - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = true;
            }
            
            
        } catch (ClassNotFoundException ex) {
            retorno = false;
        } catch (SQLException ex) {
            retorno = false;
        }
        
        
        return retorno;
    }       
       
       
       
       
       
}
