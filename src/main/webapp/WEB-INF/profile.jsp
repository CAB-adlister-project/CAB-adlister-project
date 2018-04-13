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

        <div class="ads">
            <c:forEach var="job" items="${jobs}">
                <div class="card">
                    <div class="card-body">
                        <a  href="/jobs/show?id=${job.id}"><h4 class="card-title">${job.title}</h4></a>
                    </div>
                    <div>
                        <form action="/delete" method="post">
                            <input hidden type="text" name="id" value="${job.id}">
                            <button class="btn btn-danger">Delete</button>
                        </form>
                        <%--<a class="btn btn-default btn-xs" href="/editPost" role="button">Edit</a>--%>
                    </div>
                </div>
            </c:forEach>
    </div>
    </div>
    </div>

</body>
</html>

</html>