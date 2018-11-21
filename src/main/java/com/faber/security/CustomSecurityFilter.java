package com.faber.security;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.connection.EnvironmentVariable;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
public class CustomSecurityFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        
        //Ignore custom security check for GET method
        if (req.getMethod().equals("GET")) {
            chain.doFilter(request, response);//pass to next filter
            return;
        }

        String origin = req.getHeader("origin");
        String referer = req.getHeader("referer");
        //Check if user connect from bot or none origin, none referrer method
        if (origin == null || origin.equals("") || referer == null || referer.equals("")) {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            servletResponse.sendError(403);//return forbidden status code
            return;
        }

        try {
            URL originURL = new URL(origin);
            URL refererURL = new URL(referer);
            //Check if client host, referrer connected from access host list
            if (EnvironmentVariable.getDomainAllowCORS().contains(originURL.getHost()) && EnvironmentVariable.getDomainAllowCORS().contains(refererURL.getHost())) {
                chain.doFilter(request, response);//pass to next filter
                return;
            }
        } catch (MalformedURLException ex) {

        }
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.sendError(403);
        chain.doFilter(request, response);//pass to next filter
    }
}
