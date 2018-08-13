/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alunos;

import br.com.entra21java.bean.AlunoBean;
import br.com.entra21java.dao.AlunoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gus
 */
public class AlunoStore {
   @WebServlet(urlPatterns = "/alunos/store")
public class AlunosStore extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlunoBean aluno = new AlunoBean();
        aluno.setNome(req.getParameter("nome"));
        aluno.setMatricula(req.getParameter("matricula"));
        aluno.setNota1(Double.parseDouble(req.getParameter("nota1")));
        aluno.setNota2(Double.parseDouble(req.getParameter("nota2")));
        aluno.setNota3(Double.parseDouble(req.getParameter("nota3")));
        aluno.setMediaNota(Double.parseDouble(req.getParameter("media")));
        aluno.setFrequencia(Byte.parseByte(req.getParameter("frequencia")));
        aluno.setEstado(req.getParameter("estado"));
        int codigo = new AlunoDao().adicionar(aluno);
        PrintWriter out = resp.getWriter();
        out.print("Cadastro realizado");
        if(codigo > 0){
            resp.sendRedirect("/ListaWeb00/alunos");
        }
    }

    }
}
