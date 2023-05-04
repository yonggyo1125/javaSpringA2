<%@ tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>사이트 제목...</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
        <script src="<c:url value='/js/common.js' />"></script>
    </head>
    <body>
        <main>
            <jsp:doBody />
        </main>
    </body>
</html>