

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class Bootstrap {

	public static void main(String[] args) throws Exception {
		System.out.println("Launch http://localhost:8080/");

		Server server = new Server(8080);

		WebAppContext context = new WebAppContext();
		context.setDescriptor("/WEB-INF/web.xml");
		context.setResourceBase("./src/main/webapp");
		context.setContextPath("/");
		context.setParentLoaderPriority(true);
		
		context.setConfigurationClasses(new String[] {
				"org.mortbay.jetty.webapp.WebInfConfiguration",
				"org.mortbay.jetty.webapp.WebXmlConfiguration",
				"org.mortbay.jetty.webapp.JettyWebXmlConfiguration",
				"org.mortbay.jetty.webapp.TagLibConfiguration",
				"org.mortbay.jetty.plus.webapp.EnvConfiguration",
		});

		server.setHandler(context);
		
		server.start();
		server.join();
	}

}
