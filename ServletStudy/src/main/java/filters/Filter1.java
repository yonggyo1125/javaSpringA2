package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Filter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("Filter1 - 전");
        // 요청 URL에 매칭되는 다음 필터가 있는 경우 -> 다음 필터 호출
        // 없는 경우는 서블릿의 요청 메서드가 호출 -> 응답

        // filterChain.doFilter 전 : 요청 전 공통 처리

        // 요청 메서드가 post 일때 body 인코딩 UTF-8
        /** - 사용을 지양
        HttpServletRequest req = (HttpServletRequest) request;
        String method = req.getMethod();
        if (method.toUpperCase().equals("POST")) {
            req.setCharacterEncoding("UTF-8");
        }
        */

        filterChain.doFilter(new Filter1RequestWrapper(request), new Filter1ResponseWrapper(response));
        
        // filterChange.doFilter 후 : 응답 후 공통 처리
        //System.out.println("Filter1 - 후");
    }
}
