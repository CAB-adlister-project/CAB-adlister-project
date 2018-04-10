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

        ${sessionScope.user.jobs}

    </div>

</body>
</html>
