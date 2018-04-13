<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="/jobs"><img id="navLogo" src="/CSS/img/omeleteLOGO.png" alt="Nav Logo"></a>

        </div>
        <form action="/jobs/search" method="GET" class="navbar-form navbar-left">
            <div class="input-group">
                <input type="text" class="form-control" name="searchQuery" id="searchQuery" placeholder="Search for...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="submit">Go!</button>
                </span>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">


            <c:if test="${sessionScope.user != null}">
                <li><a href="/profile?id=${user.id}"><span class="glyphicon glyphicon-user"></span> Profile </a></li>
                <li><a href="/jobs/post"><span class="glyphicon glyphicon-file"></span> Post Jobs</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-eject"></span> Logout</a></li>
            </c:if>

            <c:if test="${sessionScope.user == null}">
                <li><a href="/login"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                <li><a href="/register"><span class="glyphicon glyphicon-plus"></span> Sign Up</a></li>
            </c:if>

        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
