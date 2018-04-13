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
                <div id="delete">
                        <a  href="/jobs/show?id=${job.id}"><h4 class="card-title">${job.title}</h4></a>
                        <form action="/delete" method="post">
                            <input hidden type="text" name="id" value="${job.id}">
                            <button id="deleteBtn" type="submit"> <span class="glyphicon glyphicon-remove"></span></button>
                        </form>
                </div>
                </div>
                <br>
            </c:forEach>
    </div>
    </div>
    </div>

</body>
</html>

</html>