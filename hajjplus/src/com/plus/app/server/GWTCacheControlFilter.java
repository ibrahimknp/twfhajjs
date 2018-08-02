package com.plus.app.server;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * {@link Filter} to add cache control headers for GWT generated files to ensure
 * that the correct files get cached.
 *
 * @author See Wah Cheng
 * @created 24 Feb 2009
 */
public class GWTCacheControlFilter implements Filter {

	private static Logger log = Logger.getLogger( GWTCacheControlFilter.class );

 public void destroy() {
	 System.out.println("Destroy: "+new Date());
	 log.error("Destroy "+new Date());
	 
	 
 }

 public void init(FilterConfig config) throws ServletException {
	 System.out.println("Init : "+new Date());
	 log.error("Init "+new Date());
	 try
	 {

		 //Login_Session_Wrapper meta = new Login_Session_Wrapper();
		// meta.setLogin_Session(new Login_Session(null));
		// Login_Session_ServiceImpl impl = new Login_Session_ServiceImpl();
		 //impl.save(meta);		
	} catch (Exception e) {
		// TODO: handle exception
		log.error(e);
	}
 }

 public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
   ServletException {

  HttpServletRequest httpRequest = (HttpServletRequest) request;
  String requestURI = httpRequest.getRequestURI();

  //System.out.println("Filter : "+new Date()+"\n"+requestURI);
  //log.error("Destroy "+new Date()+"\n"+requestURI);

  if (requestURI.contains(".nocache.")) {
   Date now = new Date();
   HttpServletResponse httpResponse = (HttpServletResponse) response;
   httpResponse.setDateHeader("Date", now.getTime());
   // one day old
   httpResponse.setDateHeader("Expires", now.getTime() - 86400000L);
   httpResponse.setHeader("Pragma", "no-cache");
   httpResponse.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
  }

  	filterChain.doFilter(request, response);
 }
}