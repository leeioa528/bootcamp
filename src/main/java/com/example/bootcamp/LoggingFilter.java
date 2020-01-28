package com.example.bootcamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
class LoggingFilter implements javax.servlet.Filter {

	private final Log log = LogFactory.getLog(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	//go into servelet container befpre upi fp tp dos[atcjer servlet do this
	//peice of code
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Assert.isTrue(request instanceof HttpServletRequest,
				"this assumes you have an HTTP request");
		HttpServletRequest httpServletRequest = HttpServletRequest.class.cast(request);
		String uri = httpServletRequest.getRequestURI();
		this.log.info("new request for " + uri + ".");
		long time = System.currentTimeMillis();
		//we have process the request now send it down the chain
		chain.doFilter(request, response);
		long delta = System.currentTimeMillis() - time;
		this.log.info("request for " + uri + " took " + delta + "ms");
	}

	@Override
	public void destroy() {
	}

}
