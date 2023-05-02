<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="100" scope="page" />
<c:remove var="num" />
page : ${pageScope.num}<br>