<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />

    <%--// obtaining inputs for text area so they dont disappear when an incorrect input or field is submitted--%>
    <% String username = request.getParameter("username");
        if (username == null) username = "";

        String email = request.getParameter("email");
        if (email == null) email = "";

        String rest_name = request.getParameter("rest_name");
        if (rest_name == null) rest_name = "";
    %>

    <div class="container">
        <div class="job">
        <h1 class="text-center">Sign Up!</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="<%=username%>">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="<%=email%>">
            </div>
            <div class="form-group">
                <label for="rest_name">Restaurant</label>
                <input id="rest_name" name="rest_name" class="form-control" type="text" value="<%=rest_name%>">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>

            <div class="form-group">
                <label for="rest_cat">
                    <select name="rest_cat" id="rest_cat">
                        <option value="null">Please Select A Category</option>
                        <option value="bar">Bar</option>
                        <option value="grill">Grill</option>
                        <option value="steakhouse">Steak House</option>
                        <option value="texmex">Tex Mex</option>
                        <option value="sushi">Sushi</option>
                        <option value="italian">Italian</option>
                    </select>
                </label>
            </div>

            <input type="submit" class="btn btn-primary btn-block">
        </form>



        <%--// list through error messages and display the correct one--%>
        <c:if test="${sessionScope.listOfErrors.size() > 0}">
            <div id="errors" class="alert alert-danger">
                <p>Unable to register user!</p>
                <ul>
                    <c:forEach var="message" items="${listOfErrors}">
                        <li><c:out value="${message}"></c:out></li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        </div>
    </div>
</body>
</html>
