<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>HarrisonHighSchool</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="inc/css/bootstrap.min.css">
        <link rel="stylesheet" media="all" href="inc/css/style.css">
        <link rel="stylesheet" href="inc/css/bootstrap-theme.min.css">
        <script src="inc/js/bootstrap.min.js" ></script>

</head>
<body>	
    <%@include file = "header.jsp" %>
	 <div class="container">
             
             
<form class="well form-horizontal" action="Poster" method="post"  id="contact_form">
<fieldset>

<!-- Form Name -->
<legend>Poster des Annonce</legend>


<!-- Text input-->


<!-- Text input-->
      
<div class="form-group">
  <label class="col-md-4 control-label">Titre Annonce</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="titreAnnonce" placeholder="Titre Annonce" class="form-control" type="text">
    </div>
  </div>
</div>

<!-- Select Basic -->
   
<div class="form-group"> 
  <label class="col-md-4 control-label">filière</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="filiere" class="form-control selectpicker" >
      <option value="IWIM" >IWIM</option>
      <option value="GL" >GL</option>
      <option value="IeL" >IeL</option>
      <option value="SSI" >SSI</option>
      <option value="eMBI" >eMBI</option>
      <option value="ISEM" >ISEM</option>
    </select>
  </div>
</div>
</div>

<div class="form-group"> 
  <label class="col-md-4 control-label">Semester</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="semester" class="form-control selectpicker" >
      <option value="1" >1</option>
      <option value="2" >2</option>
      <option value="3" >3</option>
      <option value="4" >4</option>
      <option value="5" >5</option>
      <option value="6" >6</option>

    </select>
  </div>
</div>
</div>




<!-- radio checks -->
 <div class="form-group">
                        <label class="col-md-4 control-label">Afficher a toute les filier</label>
                        <div class="col-md-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="toute" value="yes" /> Yes
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="toute" value="no" /> No
                                </label>
                            </div>
                        </div>
                    </div>

<!-- Text area -->
  
<div class="form-group">
  <label class="col-md-4 control-label"> Annonce</label>
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
        	<textarea class="form-control" name="annonce" placeholder=" Description"></textarea>
  </div>
  </div>
</div>

<!-- Success message -->
<div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Thanks for contacting us, we will get back to you shortly.</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Poster<span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>

</fieldset>
</form>
</div>
    </div><!-- /.container -->
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

    <script src="inc/js/index.js"></script>
	
	<div class="content">
		<div class="container">

			<div class="main-content">
				<h1>Annonces Poster</h1>  
                            
                             
                                <c:forEach items="${requestScope.annonceList}" var="annonceList" varStatus="status" >
                                        <section class="posts-con">
                                               <article>
                                                       <div class="current-date">
                                                           <p><c:out value="${annonceList.getMonthName()}-${annonceList.getYear()}"/></p>
                                                               <p class="date"><c:out value="${annonceList.getDay()}"/></p>
                                                       </div>
                                                       <div class="info">
                                                               <h3><c:out value="${annonceList.getTitreAnnonce()}" /></h3>
                                                               <p class="info-line"><span class="time"><c:out value="${annonceList.getTime()}" /></span><span class="place"><c:if test="${!empty(requestScope.filiereList.get(status.count-1))  }"><c:out value = "${requestScope.filiereList.get(status.count-1).getNomFormation() } Semester :${requestScope.filiereList.get(status.count-1).getSemester() }"/></c:if><c:if test="${empty(requestScope.filiereList.get(status.count-1))}">Publique</c:if></span></p>
                                                               <p><c:out value="${annonceList.getAnnonce()}" /></p>

                                                       </div>
                                               </article>
                                       </section>    
                                                               
                                  </c:forEach>
                                
                                
                                
                               
                                
			</div>
			
			<!-- / sidebar -->
	
		</div>
		<!-- / container -->
	</div>
	<div class="col-lg-4">
	</div>
	<div class="col-lg-4">
	<nav aria-label="Page navigation">
            <ul class="pager">
                <li><a href="?page=${requestScope.page-1 > 0 ? requestScope.page-1:1}">Previous</a></li>
                <li><a href="?page=${requestScope.page+1 <= requestScope.maxPage ? requestScope.page+1 : requestScope.page}">Next</a></li>
            </ul>
        </nav>
</div>

        <%@include file = "footer.jsp" %>
</body>
</html>
