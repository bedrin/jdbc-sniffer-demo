<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">

<jsp:include page="fragments/staticFiles.jsp"/>

<body>
<style>
div.wikipedia {
    display: none;
}
</style>
<div class="container">
    <jsp:include page="fragments/bodyHeader.jsp"/>
    <h2><fmt:message key="welcome"/></h2>

    <spring:url value="/resources/images/pets.png" htmlEscape="true" var="petsImage"/>
    <img src="${petsImage}"/>

    <div class="wikipedia">
        <c:out value="${article}" escapeXml="false"/>
    </div>
    <script>
        $("div.wikipedia").html($("div.wikipedia table")[0].outerHTML);
        $("div.wikipedia").css('display','block');
    </script>

    <jsp:include page="fragments/footer.jsp"/>

</div>
</body>

</html>
