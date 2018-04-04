package com.ipartek.formacion.nidea.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BackofficeFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, description = "Dejar pasar solo a los usuarios logeados", urlPatterns = {
				"/backoffice/*" })
public class BackofficeFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("BackofficeFilter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		if (null != session.getAttribute("usuario")) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			informacionPeticion(req);
			res.sendRedirect(req.getContextPath() + "/login");
		}

	}

	/**
	 * Mostramos por pantalla toda la informacion del usuario == Request
	 * 
	 * @param req
	 *            HttpServletRequest
	 */
	private void informacionPeticion(HttpServletRequest req) {
		System.out.println("*****************ACCESO NO PERMITIDO***********************");
		System.out.println("IP = " + req.getLocalAddr());
		System.out.println("PUERTO = " + req.getLocalPort());
		System.out.println("URI = " + req.getRequestURI());
		System.out.println("URL = " + req.getRequestURL());

		System.out.println("**********Encabezados***********");
		Enumeration<String> headerValues = req.getHeaderNames();
		String headerName = "";
		while (headerValues.hasMoreElements()) {
			headerName = headerValues.nextElement();
			System.out.println(headerName + "=" + req.getHeader(headerName));
		}

		System.out.println("**********Locales***********");

		System.out.println("***********************************************************");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("BackofficeFilter init");
	}

}
