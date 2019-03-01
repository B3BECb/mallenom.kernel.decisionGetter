package app;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServerBootstrapper extends AbstractHandler {

    private org.eclipse.jetty.server.Server _server;

    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World</h1>");
    }

    void StartServer() throws Exception {
        this._server = new org.eclipse.jetty.server.Server(50064);
        this._server.setHandler(new ServerBootstrapper());

        this._server.start();
        this._server.join();
    }
}
