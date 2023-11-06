package homies.goats.projet_jee.filters;

import homies.goats.projet_jee.model.UserEntity;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        if (httpRequest.getSession().getAttribute("authenticatedUser") == null) {
            if (!(requestURI.endsWith("/login") || requestURI.endsWith("/login.jsp"))){
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}
