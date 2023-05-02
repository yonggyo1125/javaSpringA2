<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
<c:forEach var="item" items="${items}">
    <li>
        ${item.subject} / ${item.poster}
    </li>
</c:forEach>
</ul>