package controller;

import model.GestorConsultas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BuscarDiscoGrupoServlet", value = "/buscar-disco-grupo")
public class BuscarDiscoGrupoServlet extends HttpServlet {
    private GestorConsultas gestorConsultas = new GestorConsultas();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String nombreAutor = request.getParameter("nombreAutor");
        String autores[] = gestorConsultas.buscaAutor(nombreAutor);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Tienda de discos</h1>\n");
        out.println("<h2>Resultado de la búsqueda</h2");

        if (autores.length == 0){
            out.println("<p>No hay autores</p>");
        } else {
            String autor = "";
            for (int i = 0; i < autores.length; i++){
                autor += autores[i];
                out.println("<p>"+autor+"</p>");
            }
        }

        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
