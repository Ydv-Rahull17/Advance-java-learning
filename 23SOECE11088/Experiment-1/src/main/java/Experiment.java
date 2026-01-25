import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Experiment")
public class Experiment extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Experiment() {
        super();
    }

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Generate HTML response
        response.getWriter().println("""
            <html>
            <head>
                <style>%s</style>
                <title>Experiment Servlet</title>
            </head>
            <body>
                <div class='form-container'>Welcome to Servlet tutorial</div>
            </body>
            </html>
        """.formatted(getCSS()));
    }

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Generate HTML response
        response.getWriter().println("""
            <html>
            <head>
                <style>%s</style>
                <title>Experiment Servlet</title>
            </head>
            <body>
                <div class='form-container'>Welcome to J2EE tutorial</div>
            </body>
            </html>
        """.formatted(getCSS()));
    }

    // Method to provide inline CSS for styling the response
    private String getCSS() {
        return """
            body {
                font-family: Arial, sans-serif;
                background-color: blue;
                margin: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .form-container {
                background: white;
                color: #FF0000; /* Changed color to red */
                padding: 20px 30px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                text-align: center;
                font-size: 24px;
            }
        """;
    }

    }
