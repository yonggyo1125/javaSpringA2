<%@ tag body-content="empty" %>
<%@ attribute name="size" type="java.lang.Integer" %>
<%@ attribute name="scope" %>
<%
    if (scope.equals("page")) {
        jspContext.setAttribute("size", size);
    } else if (scope.equals("request")) {
        request.setAttribute("size", size);
    }
%>

