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
    <jsp:include page="/WEB-INF/partials/editPage.jsp" />
    <div class="container-fluid">


            <h3>Listings from ${user.rest_name}</h3>

            <c:forEach var="job" items="${jobs}">
                <div class="card">
                    <div class="card-body">
                        <a  href="/jobs/show?id=${job.id}"><h4 class="card-title">${job.title}</h4></a>
                        <h5 class="card-subtitle mb-2 text-muted">${job.rest_name}</h5>
                        <br>
                        <a href="/profile?id=${job.user_id}" class="card-link">More from ${job.rest_name}</a>
                    </div>
                    <div>
                        <form action="/delete" method="post">
                            <input hidden type="text" name="id" value="${job.id}">
                            <button>Delete</button>
                        </form>
                        <a class="btn btn-default btn-xs" href="#" role="button">Edit</a>
                    </div>
                </div>



            </c:forEach>
    </div>
    </div>

</body>
</html>

</html>