package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PrimeroFilter
 */
//@WebFilter(value = "/uno", initParams = {@WebInitParam(name="param", value = "valor")})

public class PrimeroFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -8029262242932200428L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public PrimeroFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

	 System.out.println("Antes de la cadena en el primer filtro");
		//Antes de la cadena
		chain.doFilter(request, response);
	System.out.println("Despues de la cadena en el primer filtro");
		//Despues de la cadena
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Este filtro tiene un parametro: " + fConfig.getInitParameter("param"));
		System.out.println("El valor del parametro del contexto es: " + fConfig.getServletContext().getInitParameter("parametername"));
	}

}
