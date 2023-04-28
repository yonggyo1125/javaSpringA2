<%@ page contentType="text/html; charset=utf-8" %>
<h1>include.jsp</h1>
<%
    String key1 = request.getParameter("key1");
    String key2 = request.getParameter("key2");

    out.write("key1=" + key1 + "<br>");
    out.write("key2=" + key2 + "<br>");

%>