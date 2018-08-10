/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gus
 */
public class Conexao {
    private static final String HOST = "jdbc:mysql://localhost/exemplo_web_01";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String  CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;
        
    public static Connection obterConexao(){
        try{
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
            return conexao;
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return null;
       
    }
    
    public static void fecharConexao() {
        try{
            conexao.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
