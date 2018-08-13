/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entra21java.web.alunos;

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
@WebServlet(urlPatterns = "/alunos/cadastrar")
public class AlunoCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cadastro aluno</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/Lista/bootstrap/css/bootstrap.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        out.println("<form action='/ListaWeb00/alunos/store method='post' onsubmit='validarFormulario()'>");
        out.println("	<div id='div-campo-nome' class=' form-group'>");
        out.println("<label for='campo-nome'>Nome<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='text' class='form-control' id='campo-nome' name='nome' required='required' onfocusout='validarCampoNome()'></div>");
        out.println("<div class='form-group' id='div-campo-matricula'>");
        out.println("<label for='campo-matricula'>Numero da matricula<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-matricula' name='matricula' required='required' onfocusout='validadarCampoMatricula()'></div>");
        out.println("<div class='row'>");
        out.println("<div class='col'>");
        out.println("<div class='form-group' id='div-campo-nota1'>");
        out.println("<label for='campo-nota1'>Nota -1 <span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-nota1' name='nota1' required='required' onfocusout='validadarNota1()' placeholder='Ex: 6.4'>");
        out.println("</div>");
        out.println("<div class='col'>");
        out.println("<div class='form-group' id='div-campo-nota2'>");
        out.println("<label for='campo-nota2'>Nota -2 <span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-nota2' name='nota2' required='required' onfocusout='validadarNota2()' placeholder='Ex: 9.8'>");
        out.println("</div>");
        out.println("<div class='col'>");
        out.println("<div class='form-group' id='div-campo-nota3'>");
        out.println("<label for='campo-nota3'>Nota -3 <span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-nota3' name='nota3' required='required' onfocusout='validadarNota3()' placeholder='Ex: 10'>");
        out.println("</div>");
        out.println("<div class='col'>");
        out.println("<div class='form-group' id='div-campo-nota4'>");
        out.println("<label for='campo-nota4'>Nota -4 <span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-nota4' name='nota4' required='required' onfocusout='validadarNota4()' placeholder='Ex: 7.0'>");
        out.println("</div>");
        out.println("<label for='campo-frequencia'>Frequência<span class='text-danger font-weight-bold'>*</span></label>");
        out.println("<input type='number' class='form-control' id='campo-frequencia' name='frequencia' required='required' onfocusout='validarCampoFrequencia()'></div>");
        out.println("<input class='btn btn-outline-secondary' type='submit' value='Cadastrar'>");
        out.println("<form action='/ListaWeb00/alunos/store' method='post'>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

}
