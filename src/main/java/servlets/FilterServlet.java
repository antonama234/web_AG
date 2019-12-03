package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "filter", urlPatterns = {"/admin/*"})
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (!session.getAttribute("role").equals("admin")) {
            servletRequest.getServletContext().getRequestDispatcher("/redirect.jsp").forward(request, response);
        } else if (session.getAttribute("role").equals("admin")) {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
