package org.alma.servletcloudrun;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
public class ServletApplication {
    public static void main(String[] args) {
    	
    
        Integer port = 8080;
 

        Server server = new Server(port);

        ServletContextHandler servletHandler = new ServletContextHandler(NO_SESSIONS);
        servletHandler.addServlet(PubSubServlet.class, "");
        ConnectionPoolContextListener contextListener = new ConnectionPoolContextListener();
        servletHandler.addEventListener(contextListener);
    
        server.setHandler(servletHandler);

        try {
        
            server.start();
            server.join();
        } catch (Exception ex) {
        	ex.printStackTrace();
            System.exit(1);
        } finally {
            server.destroy();
        }	
    }
}
