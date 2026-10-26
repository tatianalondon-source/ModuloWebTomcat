import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Capturamos los datos enviados desde el formulario HTML mediante el método POST
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");

        // Mostramos una respuesta dinámica en el navegador
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del Registro</title>");
            out.println("</head>");
            out.println("<body style='font-family: Arial, sans-serif; margin: 40px;'>");
            out.println("<div style='border: 1px solid #28a745; padding: 20px; border-radius: 5px; width: 400px;'>");
            out.println("<h2 style='color: #28a745;'>¡Registro Exitoso!</h2>");
            out.println("<p><strong>Nombre recibido:</strong> " + nombre + "</p>");
            out.println("<p><strong>Correo recibido:</strong> " + correo + "</p>");
            out.println("<hr>");
            out.println("<p><em>Datos procesados mediante un Servlet de Java con método POST.</em></p>");
            out.println("<br><a href='index.jsp'>Volver al formulario</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para el registro de usuarios - SENA";
    }
}