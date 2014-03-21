package br.gov.serpro.treino.web;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.gov.serpro.treino.config.TreinoConfig;
import br.gov.serpro.treino.constant.Navigation;

public class AuthenticationFilter implements Filter {
	
	private static Logger log = Logger.getLogger(AuthenticationFilter.class);

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

		try {
			int sleep = (TreinoConfig.getDelay() * 1000)/2;
			Thread.sleep(sleep);
			log.debug("sleep:"  + sleep);
			log.debug(request);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			HttpSession session = httpRequest.getSession();
			String username = (String) session.getAttribute("username");
			log.debug("user: " + username);
			if (username != null && !username.equals("")) {
				chain.doFilter(request, response);
			} else {
				log.debug("redirect login");
				httpResponse.sendRedirect(httpRequest.getContextPath() + Navigation.LOGIN);
			}
		} catch (Exception e) {
			
		}

	}
	
 

	public void destroy() {

	}

}
