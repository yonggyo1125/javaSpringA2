package filters;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter2 - 전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter2 - 후");

    }
}
