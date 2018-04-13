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
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">${job.title}</h4>
                <h5 class="card-subtitle mb-2 text-muted">${job.rest_name}</h5>
                <a  href="/jobs/show?id=${job.id}" class="card-link">View Job</a>
                <br>
                <a href="/profile?id=${job.user_id}" class="card-link">More from ${job.rest_name}</a>
            </div>
        </div>

    </c:forEach>
</div>
</body>
</html>
