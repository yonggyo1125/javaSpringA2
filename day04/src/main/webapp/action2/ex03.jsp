<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.*" %>
<h1>ex03.jsp - 전</h1>

<%
    String param1 = URLEncoder.encode("값1", "UTF-8"); // %16진수%
    String param2 = URLEncoder.encode("값2", "UTF-8");
%>

<jsp:include page="include.jsp">
    <jsp:param name="key1" value="<%=param1%>" />
    <jsp:param name="key2" value="<%=param2%>" />
</jsp:include>

<h1>ex03.jsp - 후</h1>