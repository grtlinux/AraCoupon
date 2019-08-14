package kr.co.arajeju.aracoupon3.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import kr.co.arajeju.aracoupon3.util.Flag;

@Component
public class SimpleCORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (Flag.flag) System.out.println("\t>>>>> KANG-20190622: SimpleCORSFilter....");
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		res.setHeader("Access-Control-Allow-Origin", "*");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
