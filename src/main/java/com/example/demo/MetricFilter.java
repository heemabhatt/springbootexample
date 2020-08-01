package com.example.demo;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

public class MetricFilter implements Filter {
	private MetricService metricService;

	public void init(FilterConfig config) throws ServletException {
		metricService = (MetricService) WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext()).getBean("metricService");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest) request);
		String req = httpRequest.getMethod() + " " + httpRequest.getRequestURI();

		chain.doFilter(request, response);

		int status = ((HttpServletResponse) response).getStatus();
		metricService.increaseCount(req, status);
	}
}