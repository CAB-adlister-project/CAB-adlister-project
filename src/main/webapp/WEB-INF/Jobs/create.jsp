<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">

        <h1>Create a new Post</h1>
        <form action="/jobs/post" method="post">

            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

            <div class="form-group">
                <label for="job_cat">
                    <select name="job_cat" id="job_cat">
                        <option value="null">Job Category</option>
                        <option value="Bar">Bar</option>
                        <option value="Server">Server</option>
                        <option value="FOH Manager">FOH Manager</option>
                        <option value="BOH Manager">BOH Manager</option>
                        <option value="Cook">Cook</option>
                        <option value="Dishwasher">Dishwasher</option>
                        <option value="Baking/Pastry">Baking/Pastry</option>
                    </select>
                </label>
            </div>



            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
