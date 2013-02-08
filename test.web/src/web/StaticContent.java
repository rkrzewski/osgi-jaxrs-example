package web;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;

@Component
public class StaticContent implements HttpContext {

	private BundleContext context;
	
	private HttpService httpService;

	@Activate
	public void start(BundleContext context) throws NamespaceException
	{
		this.context = context;
		httpService.registerResources("/", "/", this);
	}

	@Reference
	public void setHttpService(HttpService httpService)
	{
		this.httpService = httpService;
	}
	
	@Override
	public URL getResource(String name) {
		if(name.equals("/")) {
			return context.getBundle().getEntry("/index.html");
		} else {
			return context.getBundle().getEntry(name);
		}
	}

	@Override
	public String getMimeType(String name) {
		return null;
	}

	@Override
	public boolean handleSecurity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		return true;
	}
}
