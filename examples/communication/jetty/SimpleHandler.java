package communication.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleHandler extends AbstractHandler {

	public void handle(String target, Request baseRequest, 
	        HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");		
        response.setStatus(HttpServletResponse.SC_OK);        
        response.getWriter().println("<h1>Hello World</h1>");
        baseRequest.setHandled(true);

	}

}
