<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
<<<<<<< HEAD
            <a class="navbar-brand" href="/jobs"><img src="CSS/img/omeleteLOGO.png" alt="logo"></a>
=======
            <a class="navbar-brand" href="/jobs"><img class="logo" src="CSS/img/omeleteLOGO.png" alt="logo"></a>
>>>>>>> e4be279b137f65a17d65d3a841000ccc3d45ab0b
        </div>
        <ul class="nav navbar-nav navbar-right">


            <c:if test="${sessionScope.user != null}">
                <li><a href="/profile">Profile</a></li>
                <li><a href="/jobs/post">Post Jobs</a></li>
                <li><a href="/logout">Logout</a></li>
            </c:if>

            <c:if test="${sessionScope.user == null}">
                <li><a href="/login">Login</a></li>
                <li><a href="/register">Sign Up</a></li>
            </c:if>

        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
