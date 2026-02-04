import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html");

        // Common advanced CSS and animations for all responses
        String style = """
            <style>
                body {
                    font-family: 'Roboto', sans-serif;
                    background: linear-gradient(135deg, #1f4037, #99f2c8);
                    margin: 0;
                    padding: 0;
                    display: flex;
                    flex-direction: column;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    color: white;
                }
                h1 {
                    font-size: 3em;
                    margin-top: 20px;
                    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);
                    
                    animation: textGlow 1.5s infinite alternate;
                }
                p {
                    font-size: 1.5em;
                    background: rgba(255, 255, 255, 0.1);
                    padding: 15px;
                    border-radius: 10px;
                    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
                    margin: 20px;
                    animation: fadeIn 1s ease-in-out;
                }
                button {
                    font-size: 1em;
                    padding: 12px 30px;
                    margin: 10px;
                    background: linear-gradient(90deg, #ff7eb3, #ff758c);
                    border: none;
                    border-radius: 25px;
                    color: white;
                    cursor: pointer;
                    box-shadow: 0px 4px 10px rgba(255, 117, 140, 0.5);
                    transition: all 0.3s ease-in-out;
                    animation: buttonPulse 2s infinite;
                }
                button:hover {
                    transform: scale(1.1);
                    background: linear-gradient(90deg, #ff758c, #ff7eb3);
                    box-shadow: 0px 6px 15px rgba(255, 117, 140, 0.7);
                }
                .footer {
                    margin-top: 30px;
                    font-size: 1em;
                    color: rgba(255, 255, 255, 0.8);
                }
                @keyframes fadeIn {
                    from { opacity: 0; transform: translateY(20px); }
                    to { opacity: 1; transform: translateY(0); }
                }
                @keyframes textGlow {
                    from { text-shadow: 2px 2px 10px rgba(255, 255, 255, 0.4); }
                    to { text-shadow: 2px 2px 20px rgba(255, 255, 255, 0.8); }
                }
                @keyframes buttonPulse {
                    0% { transform: scale(1); }
                    50% { transform: scale(1.05); }
                    100% { transform: scale(1); }
                }
            </style>
        """;

        StringBuilder htmlResponse = new StringBuilder("<html><head>" + style + "</head><body>");

        if ("setIntegerHeader".equals(action))
        {
        
        	// Problem 1: Set Integer Header
            response.setIntHeader("Custom-Integer-Header", 1234567890);
            htmlResponse.append("<h1>Problem 1: Integer Header</h1>");
            htmlResponse.append("<p>Integer header <strong>'Custom-Integer-Header'</strong> has been set to <strong>1234567890</strong>.</p>");
        } 
        else if ("setStringHeader".equals(action))
        {
        
        	// Problem 2: Set String Header
            response.setHeader("Custom-String-Header", "HelloDuniya!");
            htmlResponse.append("<h1>Problem 2: String Header</h1>");
            htmlResponse.append("<p>String header <strong>'Custom-String-Header'</strong> has been set to <strong>'HelloDuniya!'</strong>.</p>");
        } 
        else if ("testContentType".equals(action))
        {
        
        	// Problem 3: Test Content-Type Header
            response.setIntHeader("Content-Type", 12345); // Incorrect usage
            response.setHeader("Content-Type", "text/html"); // Correct usage
            htmlResponse.append("<h1>Problem 3: Content-Type Header</h1>");
            htmlResponse.append("<p>Header <strong>'Content-Type'</strong> tested with incorrect and correct usage. Check browser developer tools for details.</p>");
        } 
        else if ("handleError".equals(action))
        {
        
        	// Problem 4: Error Handling
            try 
            {
                response.setHeader(null, "InvalidValue");
            }
            catch (IllegalArgumentException e) 
            {
                response.setContentType("text/html");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "<h1>Problem 4: Error Handling</h1><p>Invalid header name or value detected.</p>");
            }
            htmlResponse.append("<h1>Problem 4: Error Handling</h1>");
            htmlResponse.append("<p>Error handling completed successfully.</p>");
        } 
        else if ("testPerformance".equals(action))
        {
        
        	// Problem 5: Performance Testing
            long startTime = System.currentTimeMillis();
            response.setHeader("Custom-Header", "Value1");
            response.setIntHeader("Custom-Integer-Header", 98765);
            long endTime = System.currentTimeMillis();
            htmlResponse.append("<h1>Problem 5: Performance Testing</h1>");
            htmlResponse.append("<p>Headers set successfully. Execution time: <strong>" + (endTime - startTime) + "ms</strong>.</p>");
        }
        else
        {
        
        	// Default case for invalid action
            htmlResponse.append("<h1>Error</h1>");
            htmlResponse.append("<p>Invalid action! Please select a valid problem statement.</p>");
        }

        // Add footer
        htmlResponse.append("<div class='footer'>Experiment with advanced HTTP headers using the buttons provided.</div>");
        htmlResponse.append("</body></html>");
        response.getWriter().println(htmlResponse.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
