package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import decision.DecisionObj;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServerBootstrapper extends AbstractHandler {

    private org.eclipse.jetty.server.Server _server;

    private static final MultipartConfigElement MULTI_PART_CONFIG = new MultipartConfigElement("c:/temp");

    private static final String NOT_INCLUDED = "not included";

    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException,
            ServletException {

        if (!baseRequest.getMethod().equals("POST")) {
            baseRequest.setHandled(true);
            return;
        }

        if (!baseRequest.getHeader("Content-Type").contains("form-data")) {
            baseRequest.setHandled(true);
            return;
        }

        request.setAttribute(Request.__MULTIPART_CONFIG_ELEMENT, MULTI_PART_CONFIG);

        var eventData = request.getPart("eventData");

        var mapper = new ObjectMapper();

        DecisionObj result;

        try {
            result = mapper.readValue(eventData.getInputStream(), DecisionObj.class);
        } catch (Exception exc) {
            baseRequest.setHandled(true);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        var plate = result.Plate != null ? result.Plate.Number : NOT_INCLUDED;
        var timestamp = result.Timestamps != null ? result.Timestamps.BestFrame : NOT_INCLUDED;

        System.out.println(String.format("Plate: %s timestamp: %s", plate, timestamp));

        var parts = new ArrayList<Part>(request.getParts());

        saveFiles(parts.subList(1, parts.size()));

        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
    }

    private void saveFiles(Collection<Part> parts) {

    }

    void startServer() throws Exception {
        _server = new org.eclipse.jetty.server.Server(8080);
        _server.setHandler(new ServerBootstrapper());

        _server.start();
        _server.join();
    }
}
