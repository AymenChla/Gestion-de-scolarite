<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en"> 
<head>
	<meta charset="utf-8">
	<title>HarrisonHighSchool</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
	 <link rel="stylesheet" href="inc/css/bootstrap.min.css">
	<link rel="stylesheet" media="all" href="inc/css/style.css">
       
        
	<!-- Latest compiled and minified CSS -->


<!-- Optional theme -->

	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>	
	
    <%@include file = "header.jsp" %>
	
	<div class="content">
		<div class="container">

			<div class="main-content">
				<h1>Mes Annonces</h1>
         <c:forEach items="${requestScope.annonces}" var="annonce"  >
             <section class="posts-con">
                    <article>
                            <div class="current-date">
                                <p><c:out value="${annonce.getMonthName()}-${annonce.getYear()}"/></p>
                                    <p class="date"><c:out value="${annonce.getDay()}"/></p>
                            </div>
                            <div class="info">
                                    <h3><c:out value="${annonce.getTitreAnnonce()}" /></h3>
                                    <p class="info-line"><span class="time"><c:out value="${annonce.getTime()}" /></span><span class="place">Ensias</span></p>
                                    <p><c:out value="${annonce.getAnnonce()}" /></p>
                                  
                            </div>
                    </article>
            </section>      
         </c:forEach>
			</div>
		</div>
	</div>
        
        
        
	<div class="col-lg-4">
	</div>
	<div class="col-lg-4">
            
<nav aria-label="...">
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</nav>
            
</div>
	
	<%@include file = "footer.jsp" %>

</body>
</html>
