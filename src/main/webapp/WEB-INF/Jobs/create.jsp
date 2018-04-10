<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <h1>Create a new Ad for ${sessionScope.user}</h1>
        <form action="/jobs/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

            <h4>Make your restaurant easier to find by selecting categories of what ${sessionScope.user} is hiring for. Make your restaurant stand out!</h4>
            <div class="btn-group-toggle category" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <input type="checkbox" id="foh" checked autocomplete="off">Front of House
                    <input type="checkbox" id="sous" checked autocomplete="off">Sous Chef
                    <input type="checkbox" id="chef"checked autocomplete="off">Executive Chef
                    <input type="checkbox" id="manager" checked autocomplete="off">Manager
                </label>
            </div>

            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
