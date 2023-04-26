package filters;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

public class Filter1RequestWrapper extends HttpServletRequestWrapper {

    public Filter1RequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);

        // 요청 전 공통 기능
        HttpServletRequest req = (HttpServletRequest) request;
        String method = req.getMethod().toUpperCase();
        if (method.equals("POST")) {
            try {
                req.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);

        if (value != null) {
            value = value.toUpperCase();
        }

        return value;
    }
}
