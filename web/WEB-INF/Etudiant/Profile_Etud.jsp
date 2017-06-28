<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--[if IE 8]> <html class="ie8 oldie" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
	<title>Profile</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">

	<link rel="stylesheet" href="inc/css/bootstrap.min.css">
	<link rel="stylesheet" media="all" href="inc/css/style1.css">

	<meta charset="UTF-8">
	<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif}
</style>
	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
</head>
<body>


    <%@include file="header.jsp" %>


<!-- Page Container -->
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">

            <img src="ImageServlet?role=enseignant" style="width:100%" alt="Avatar" width="500px" height="333px">
          <div class="w3-display-bottomleft w3-container w3-text-black">
              <h2><c:out value="${requestScope.enseignant.getNomEnseignant()}"/></h2>
          </div>
        </div>
        <div class="w3-container">
          <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-teal"></i>Professeur</p>
          <p><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-teal"></i><c:out value="${requestScope.enseignant.getAdresseEnseignant()}"/></p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-teal"></i><c:out value="${requestScope.enseignant.getEmailEnseignant()}"/></p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-teal"></i><c:out value="${requestScope.enseignant.getTelEnseignant()}"/></p>
          <hr>

          <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-teal"></i>Specialités</b></p>
          <c:forTokens items="${requestScope.enseignant.getSpecialiteEnseignant()}" delims="," var="specialite">
                <p><c:out value="${specialite}"/></p>
          </c:forTokens>
          <br>

          <p class="w3-large w3-text-theme"><b><i class="fa fa-globe fa-fw w3-margin-right w3-text-teal"></i>Departement</b></p>
          <p><c:out value="${requestScope.enseignant.getDepartementEnseignant()}"/></p>

                 
          <br>
        </div>
      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card-2 w3-white w3-margin-bottom">

     <div class="w3-container w3-card-2 w3-white">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Module enseigné</h2>
        <c:forEach items="${requestScope.mapFiliereModule}" var="set">
            <div class="w3-container">
                <h5 class="w3-opacity"><b><c:out value="${set.key.getNomModule()}" /></b></h5>
                <h6 class="w3-text-teal"><i class="fa fa-calendar fa-fw w3-margin-right"></i><c:out value="${set.key.getYear()}" /></h6>
                <p><c:out value="${set.value}" /></p>
              <hr>
            </div>
        </c:forEach>
      </div>
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-teal"></i>Modifier information</h2>
     <form method="post" action="Profile">
        <div class="w3-container">
          
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Nom</span>
                          <input name="nom" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getNomEnseignant()}"/>">
			</div>
        </div>
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Prenom</span>
			  <input name="prenom" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getPrenomEnseignant()}"/>">
			</div>
        </div>
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Email</span>
			  <input name="email" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getEmailEnseignant()}"/>">
			</div>
          
		
		  
        </div>
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Adresse</span>
			  <input name="adresse" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getAdresseEnseignant()}"/>">
			</div>
         	  
        </div>
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Tel</span>
                          <input name="tel" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getTelEnseignant()}"/>">
			</div>
          
		
		  
        </div>   
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Spécialités</span>
			  <input name="specialites" type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" value="<c:out value="${requestScope.enseignant.getSpecialiteEnseignant()}"/>">
			</div>
          
		
		  
        </div>
        <div class="w3-container">
         <div class="input-group">
			  <span class="input-group-addon" id="basic-addon3">Département</span>
                          <c:set var="dept" value="${requestScope.enseignant.getDepartementEnseignant()}" />
                          <select class="form-control" name="departement" >
                              <option <c:if test="${dept == 'Génie Logiciel'}" >selected</c:if>>Génie Logiciel</option>
                              <option <c:if test="${dept == 'Web and Mobile Engineering'}" >selected</c:if>>Web and Mobile Engineering</option>
                              <option <c:if test="${dept == 'Informatique et Aide à la Décision'}" >selected</c:if>>Informatique et Aide à la Décision</option>
                              <option <c:if test="${dept == 'Langues et Communication'}" >selected</c:if>>Langues et Communication</option>
                              <option <c:if test="${dept == 'Réseaux de Communication'}" >selected</c:if>>Réseaux de Communication</option>
                              <option <c:if test="${dept == 'Ingénierie des Systèmes Embarqués'}" >selected</c:if>>Ingénierie des Systèmes Embarqués</option>
                          </select>
			</div>
          
		
		  
        </div>   
        <button type="submit" class="btn btn-default">Submit</button>
    </form>

   

    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->
</div>




	<%@include file="footer.jsp" %>

	
</body>
</html>

