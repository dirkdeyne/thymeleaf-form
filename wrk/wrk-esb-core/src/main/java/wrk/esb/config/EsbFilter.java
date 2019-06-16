package wrk.esb.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsbFilter extends HttpFilter {

	private static final long serialVersionUID = 5529851383726405284L;

	private static final Logger logger = LoggerFactory.getLogger(EsbFilter.class);

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("filter request :" + request.getRequestURL());
		super.doFilter(request, response, chain);
	}

}
