package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerBootstrapper extends AbstractHandler {

    private org.eclipse.jetty.server.Server _server;

    private static final MultipartConfigElement MULTI_PART_CONFIG = new MultipartConfigElement("c:/temp");

    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException,
            ServletException {

        if(!baseRequest.getMethod().equals("POST"))
            return;

        if(!baseRequest.getHeader("Content-Type").contains("form-data"))
            return;

        request.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, MULTI_PART_CONFIG);

        var eventData = request.getPart("eventData");

        var mapper = new ObjectMapper();

       var result = mapper.readValue(eventData.getInputStream(), decision.DecisionObj.class);

        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
    }

    void StartServer() throws Exception {
        this._server = new org.eclipse.jetty.server.Server(8080);
        this._server.setHandler(new ServerBootstrapper());

        this._server.start();
        this._server.join();
    }
}
