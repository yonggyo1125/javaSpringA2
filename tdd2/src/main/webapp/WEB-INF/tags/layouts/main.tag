<%@ tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <main><jsp:doBody /></main>
    </body>
</html>