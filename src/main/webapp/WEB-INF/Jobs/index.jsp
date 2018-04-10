<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Jobs" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the jobs!</h1>

    <c:forEach var="job" items="${jobs}">
        <div class="col-md-6">
            <h2>${job.title}</h2>
            <h3>${job.rest_name}</h3>
            <p>${job.description}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
