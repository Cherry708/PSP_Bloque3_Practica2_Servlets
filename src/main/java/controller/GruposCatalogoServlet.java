package controller;

import model.GestorConsultas;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "gruposCatalogoServlet", value = "/grupos-catalogo-servlet")
public class GruposCatalogoServlet extends HttpServlet {
    private GestorConsultas gestorConsultas = new GestorConsultas();
    private String[] autores = gestorConsultas.listaAutores();
    private String inicio = "/";

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Tienda de discos</h1>\n");
        out.println("<ul>");
        for (int i = 0; i<autores.length; i++){
            out.println("<li>"+autores[i]+"</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
