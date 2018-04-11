<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <jsp:include page="/WEB-INF/partials/editPage.jsp" />
    <div class="container-fluid">
        <h1>${sessionScope.user.username} Profile Page!</h1>
        <%--<img src="${image path for the company logo}}" alt="logo">--%>
            <h3>Here are a list of all your job listings.</h3>

        <c:forEach var="ad" items="${jobs}">

            <div class="col-md-6">
                <a href="/jobs/show?id=${job.id}">
                    <c:choose>
                        <c:when test='${ad.url != null && ad.url.trim() != ""}'>
                            <img style="float: left; margin-right: 5px; margin-top: 5px;" class="img-rounded"
                                 src="${ad.url}" alt="${ad.title}" width="50" height="50">
                        </c:when>
                        <c:otherwise>
                            <img style="float: left; margin-right: 5px; margin-top: 5px;" class="img-rounded"
                                 src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
                                 alt="Generic placeholder image" width="50" height="50">
                        </c:otherwise>
                    </c:choose>

                    <h2>${ad.title}</h2>
                </a>
                <p>${ad.description}</p>

                <div>
                    <form action="/delete" method="post">
                        <input hidden type="text" name="id" value="${ad.id}">
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