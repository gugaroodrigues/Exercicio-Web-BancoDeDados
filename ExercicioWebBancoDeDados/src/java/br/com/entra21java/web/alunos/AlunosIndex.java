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
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gus
 */
@WebServlet(urlPatterns = "/alunos")
public class AlunosIndex extends HttpServlet {

    private PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AlunoBean> alunos = new AlunoDao().obterTodos();
        out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Lista Alunos</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/ListaWeb00/bootstrap/css/bootstrap.css'>");
        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container-fluid'>");
        out.println("<nav class='navbar navbar-expand-lg navbar-light bg-light'>");
        out.println("<a class='navbar-brand' href=ListaWeb00/login>Inicio</a>");
        out.println("<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNavAltMarkup' aria-controls='navbarNavAltMarkup' aria-expanded='false' aria-label='Toggle navigation'>");
        out.println("<span class='navbar-toggler-icon'></span>");
        out.println("</button>");
        out.println("<div class='collapse navbar-collapse' id='navbarNavAltMarkup'>");
        out.println("<div class='navbar-nav'>");
        out.println("<a class='nav-item nav-link active' href='ListaWeb00/alunos'>Alunos <span class='sr-only'>(current)</span></a>");
        out.println("<a class='nav-item nav-link' href='ListaWeb00/alunos/cadastrar'>Cadastrar</a>");
        out.println("<form class='form-inline'>");
        out.println("<input class='form-control mr-sm-2' type='search' placeholder='Pesquisar Aluno' aria-label='Search'>");
        out.println("<button class='btn btn-outline-success my-2 my-sm-0' type='submit'>Buscar</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div> ");
        out.println("</nav>");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<h3 class='text-center'>Alunos</h3>");
        out.println("</div>");
        out.println("</div>");
        gerarTabela(alunos);
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    private void gerarTabela(List<AlunoBean> alunos) {
        out.print("<div class='row mtx-3 justify-content-md-center'>");
        out.print("<div class='col-md-8'>");
        
        out.println("<table class='table table-striped table-hover' >");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Matricula</th>");
        out.println("<th>Nome</th>");
        out.println("<th>Nota - 1 </th>");
        out.println("<th>Nota - 2 </th>");
        out.println("<th>Nota - 3 </th>");
        out.println("<th>Media nota </th>");
        out.println("<th>Frequencia</th>");
        out.println("<th>Estado</th>");

        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (AlunoBean aluno : alunos) {
            out.println("<tr>");
            out.println("<td>" + aluno.getMatricula() + "</td>");
            out.println("<td>" + aluno.getNome() + "</td>");
            out.println("<td>" + aluno.getNota1() + "</td>");
            out.println("<td>" + aluno.getNota2() + "</td>");
            out.println("<td>" + aluno.getNota3() + "</td>");
            out.println("<td>" + aluno.getMediaNota() + "</td>");
            out.println("<td>" + aluno.getFrequencia() + "</td>");
            out.println("<td>");

            out.println("</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");

        }

    }

}
/*<table>
        <thead>
          <tr>
              <th>Name</th>
              <th>Item Name</th>
              <th>Item Price</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Alvin</td>
            <td>Eclair</td>
            <td>$0.87</td>
          </tr>
          <tr>
            <td>Alan</td>
            <td>Jellybean</td>
            <td>$3.76</td>
          </tr>
          <tr>
            <td>Jonathan</td>
            <td>Lollipop</td>
            <td>$7.00</td>
          </tr>
        </tbody>
      </table>*/
