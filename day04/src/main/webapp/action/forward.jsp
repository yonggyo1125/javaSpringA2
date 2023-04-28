<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.*" %>
<%
    String param1 = URLEncoder.encode("한글", "UTF-8");
    String param2 = URLEncoder.encode("한글2", "UTF-8");
%>
<h1>forward.jsp</h1>
<jsp:forward page="target.jsp">
    <jsp:param name="param1" value="<%=param1%>" />
    <jsp:param name="param2" value="<%=param2%>" />
</jsp:forward>
