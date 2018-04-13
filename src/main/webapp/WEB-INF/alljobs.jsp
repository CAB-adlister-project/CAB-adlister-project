<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="${user.rest_name} Profile" />
    </jsp:include>

</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container-fluid">

    <h1 class="text-center">Listings from ${user.rest_name}</h1>
    <hr>

        <c:forEach var="job" items="${jobs}">
                    <a  href="/jobs/show?id=${job.id}"><h4 class="text-center">${job.title}</h4></a>
    <hr>
                </div>
                <div>

        </c:forEach>
    </div>
</div>
</div>

</body>
</html>

</html>