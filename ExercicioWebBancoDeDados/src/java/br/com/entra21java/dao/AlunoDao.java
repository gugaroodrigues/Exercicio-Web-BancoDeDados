/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.dao;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.database.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gus
 */
public class AlunoDao {
    
   /* public List<AlunoBean> validarCadastro(){
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos_web WHERE nome = ?, senha = ?";
    }*/

    public List<AlunoBean> obterTodos() {
        List<AlunoBean> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos_web";
        try {
            Statement st = ConexaoFactory.obterConexao().createStatement();
            st.execute(sql);
            ResultSet resultSet = st.getResultSet();
            while (resultSet.next()) {
                AlunoBean aluno = new AlunoBean();
                aluno.setId(resultSet.getInt("id"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setMatricula(resultSet.getString("matricula"));
                aluno.setNota1(resultSet.getDouble("nota1"));
                aluno.setNota2(resultSet.getDouble("nota2"));
                aluno.setNota3(resultSet.getDouble("nota3"));
                aluno.setFrequencia(resultSet.getByte("frequencia"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao();
        }
        return alunos;
    }

    public int adicionar(AlunoBean aluno) {
        String sql = "INSERT INTO  alunos_web (nome, matricula, nota1, nota2, nota3, frequencia) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = ConexaoFactory.obterConexao().prepareStatement(sql, java.sql.PreparedStatement.RETURN_GENERATED_KEYS);
            int quantidade = 1;
            ps.setString(quantidade++, aluno.getNome());
            ps.setString(quantidade++, aluno.getMatricula());
            ps.setDouble(quantidade++, aluno.getNota1());
            ps.setDouble(quantidade++, aluno.getNota2());
            ps.setDouble(quantidade++, aluno.getNota3());
            ps.setByte(quantidade++, aluno.getFrequencia());

            ps.execute();
            ResultSet resultSet = ps.getGeneratedKeys();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao();
        }
        return -1;
    }

    public boolean alterar(AlunoBean aluno) {
        Connection conexao = ConexaoFactory.obterConexao();
        String sql = "UPDATE alunos_web SET nome = ?, matricula = ?, nota1 = ?, nota2 = ?, nota3 = ?, frequencia = ? WHERE id = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.setDouble(3, aluno.getNota1());
            ps.setDouble(4, aluno.getNota2());
            ps.setDouble(5, aluno.getNota3());
            ps.setInt(6, aluno.getFrequencia());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.fecharConexao();
        }

        return false;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM alunos_web WHERE id = ?";
        
            try {
                PreparedStatement ps = ConexaoFactory.obterConexao().prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
                
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoFactory.fecharConexao();
            }
        return false;
    }

}
