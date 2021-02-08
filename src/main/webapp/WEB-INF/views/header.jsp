<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="resources/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="resources/bootstrap/js/bootstrap.min.js"></script>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authentication  property="principal" var = "principal"/>
	
<nav class="navbar navbar-expand-lg navbar-inverse bg-dark">
  <a class="navbar-brand" href="#">User Management</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list">User</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="greet">hello</a>
      </li>
      <li class="nav-item dropdown"><a
         class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
         role="button" data-toggle="dropdown"aria-haspopup="true" 
         aria-expanded="false"> ${principal.username} </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a><br>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="logout">Logout</a>
        </div>
      </li>
    </ul>
  </div>
</nav>


