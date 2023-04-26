package filters;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter1");

        // 요청 URL에 매칭되는 다음 필터가 있는 경우 -> 다음 필터 호출
        // 없는 경우는 서블릿의 요청 메서드가 호출 -> 응답
        filterChain.doFilter(request, response);
    }
}
