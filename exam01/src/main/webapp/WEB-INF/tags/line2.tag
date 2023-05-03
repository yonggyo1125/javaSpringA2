<%@ tag body-content="empty" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="attrs" %>
<%-- attrs가 EL 속성으로 추가 (Map<String, String>), 속성은 pageContext  --%>
<div style="color: ${attrs.color};">
<%
    Map<String, String> attrs = (Map<String, String>)jspContext.getAttribute("attrs");
    int size = Integer.parseInt(attrs.get("size"));

    for (int i = 0; i < size; i++) {
        out.write("-");
    }

%>
</div>
<%-- ${attrs.size} / ${attrs.color} --%>
