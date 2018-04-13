package com.ipartek.formacion.nidea.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuarios;

/**
 * Application Lifecycle Listener implementation class
 * UsuariosConectadosListener
 *
 */
@WebListener
public class UsuariosConectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent session) {

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {

		if (se.getSession().getAttribute("uPublic") != null) {

			Usuarios u = (Usuarios) se.getSession().getAttribute("uPublic");

			ServletContext ctx = se.getSession().getServletContext();

			if (ctx.getAttribute("usuarios_conectados") != null) {
				HashMap<Integer, Usuarios> hmUsuarios = (HashMap<Integer, Usuarios>) ctx
						.getAttribute("usuarios_conectados");
				hmUsuarios.remove(u.getId());
				ctx.setAttribute("usuarios_conectados", hmUsuarios);
			}

		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {

		// comprobar que sea atributo == uPublic
		if ("uPublic".equals(event.getName())) {

			ServletContext ctx = event.getSession().getServletContext();
			HashMap<Integer, Usuarios> hmUsuarios = null;
			if (ctx.getAttribute("usuarios_conectados") == null) {
				hmUsuarios = new HashMap<Integer, Usuarios>();
			} else {
				hmUsuarios = (HashMap<Integer, Usuarios>) ctx.getAttribute("usuarios_conectados");
			}

			Usuarios u = (Usuarios) event.getValue();
			hmUsuarios.put(u.getId(), u);
			ctx.setAttribute("usuarios_conectados", hmUsuarios);

		}

		// contexto de la App
		// event.getSession().getServletContext()

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

}
