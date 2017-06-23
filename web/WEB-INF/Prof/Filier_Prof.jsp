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


</head>
<body>	
	 <%@include file = "header.jsp" %>
	
<div class="col-lg-2">
	</div>
	<div class="col-lg-12">
	
<div class="jumbotron">
<div class="container">
<ol class="breadcrumb">
  <li><a href="home">Accueil</a></li>
  <li class="active">Filières</li>
</ol>

<div class="panel panel-info">
  <!-- Default panel contents -->
  <div class="panel-heading">FILIÈRES OFFERTES</div>
  <div class="panel-body">
    <p>A partir de l’année universitaire 2014 - 2015, L’ENSIAS propose cinq filières de formation d’ingénieurs.
    Les études ont une durée de trois ans. <br> La première année est un tronc commun suivi par tous les élèves-ingénieurs.
    <br>La deuxième et la troisième année sont réservées à la spécialisation au sein des filières offertes.<br> Il est également possible de suivre la troisième année dans des établissements partenaires étrangers.
    <br>Les élèves-ingénieurs de l’ENSIAS effectuent au moins trois stages en entreprise ou dans des laboratoires de recherche en 1ère année, 2ème année et 3ème année.
        L’ENSIAS offre à ses élèves six spécialisations et six Semesters:</p>
  </div>

  <!-- Table -->
  <table class="table">
  <tr>
    <th>FILIÈRE : SEMESTER</th>
    <th>Les Etudiants</th>
    
  </tr>
   
  <c:forEach items="${requestScope.filiereList}" var="filiere"  >
  <tr>
    <td><c:out value="${filiere.getNomFormation()}:S${filiere.getSemester()}"/></td>
    <td><a href="Message">Lien</a></td>
  </tr>
      
  </c:forEach>
  
  </table>
</div>
  
</div>
</div>
<div class="col-lg-2">
</div>
<br><br><br>
	<%@include file = "footer.jsp" %>
</body>
</html>
