package commons;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MessageUtils {
    public static void alertError(HttpServletResponse response, Exception e) throws IOException  {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.printf("<script>alert('%s');</script>", e.getMessage());
    }

    public static void go(HttpServletResponse response, String url, String target) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        target = target == null ? "self" : target;

        out.printf("<script>%s.location.replace('%s');</script>", target, url);
    }
}
