<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en"> 
<head>
        
	<meta charset="utf-8">
	<title>EnsiasHighSchool</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
        <link rel="stylesheet" media="all" href="inc/css/style.css">
      
	<style type="text/css">
		
		#slide1{
			background: url(inc/images/pic_slide.jpg) no-repeat 50% 50%;
			background-size: cover;
			height: 600px;
		}
		#slide2{
			background: url(inc/images/pic_slide1.jpg) no-repeat 50% 50%;
			background-size: cover;
			height: 600px;
		}
		#slide3{
			background: url(inc/images/pic_slide2.jpg) no-repeat 50% 50%;
			background-size: cover;
			height: 600px;
		}
	</style>

</head>
<body>
     <%@include file = "header.jsp" %>

   	<!-- / header -->
	
	<div class="slider">
		<ul class="bxslider">
			<li id="slide1">
				<div class="container">
					<div class="info">
						<h2>Easy Ensias Class 2017<br><span>depuit 1992</span></h2>
						
					</div>
				</div>
				<!-- / content -->
			</li>
			<li id="slide2">
				<div class="container">
					<div class="info">
						
					</div>
				</div>
				<!-- / content -->
			</li>
			<li id="slide3">
				<div class="container">
					<div class="info">
						
					</div>
				</div>
				<!-- / content -->
			</li>
		</ul>
		<div class="bg-bottom"></div>
	</div>
	
	<section class="posts">
		<div class="container">
			<article>
				<div class="pic"><img width="121" src="inc/images/2.png" alt=""></div>
				<div class="info">
					<h3>Formation Ensias</h3>
					<p>La formation à l’ENSIAS vise à transmettre aux élèves, l’esprit d’excellence, l’esprit d’entreprise et d’innovation, l’esprit d’ouverture en équilibrant savoirs, compétences et expériences dans le domaine des technologies de l’information.</p>
				</div>
			</article>
			<article>
				<div class="pic"><img width="121" src="inc/images/3.png" alt=""></div>
				<div class="info">
					<h3>Ensiastes</h3>
					<p>Fondée en 1992, l'École Nationale Supérieure d'Informatique et d'Analyse des Systèmes (ENSIAS) est l'un des dix établissements de l'Université Mohammed V – Souissi. C'est une grande école d'ingénieurs spécialisée en Technologies de l'Information et de la Communication. Elle a pour missions la formation d'ingénieurs d'état et la recherche en vue du développement technologique et économique du Maroc.</p>
				</div>
			</article>
		</div>
		<!-- / container -->
	</section>

	<section class="news">
		<div class="container">
                    <h2>dernières annonces</h2>
                    
                        <c:forEach items="${requestScope.annonces}" var="annonce" begin="0" end="1" >
			<article>
				<div class="pic"><img src="inc/images/1.png" alt=""></div>
				<div class="info">
                                    <h4><c:out value="${annonce.getTitreAnnonce()}" /> </h4>
					<p class="date"><c:out value="${annonce.getFullDate()}" /></p>
					<p><c:out value="${annonce.getAnnonce()}" /></p>
					
				</div>
			</article>
			<br>
                        </c:forEach>
                        
			
                        
			<div class="btn-holder">
				<a class="btn" href="Annonce">Annonce News</a>
			</div>
		</div>
		<!-- / container -->
	</section>
	<br><br><br><br>
	<div class="container">
		<a href="#fancy" class="info-request">
			<span class="holder">
				<span class="title">CONTACTER ADMINISTRATION</span>
				<span class="text">Do you have some questions? Fill the form and get an answer!</span>
			</span>
			<span class="arrow"></span>
		</a>
	</div>
        
        <%@include file = "footer.jsp" %>

	
</body>
</html>
