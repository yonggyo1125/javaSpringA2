<%@ page contentType="text/html; charset=utf-8" %>
<h1>ex03.jsp - 전</h1>

<jsp:include page="include.jsp">
    <jsp:param name="key1" value="값1" />
    <jsp:param name="key2" value="값2" />
</jsp:include>

<h1>ex03.jsp - 후</h1>