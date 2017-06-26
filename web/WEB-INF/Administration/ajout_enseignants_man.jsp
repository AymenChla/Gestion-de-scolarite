<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="inc/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="inc/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder insteainc/d of downloading all of them to reduce the load. -->
    <link href="inc/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="skin-blue">
    <div class="wrapper">
      
      <%@ include file="header.jsp" %>inc/

      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            General Form Elements
            <small>Preview</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Forms</a></li>
            <li class="active">General Elements</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-6">
              <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header">
                  <h3 class="box-title">Quick Example</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
                <form enctype="multipart/form-data" role="form" method="post" action="Enseignant?page=insert" >
                  <div class="box-body">
                    <div class="form-group">
                      <label for="nom">Nom</label>
                      <input name="nom"  type="text" class="form-control" id="nom" placeholder="nom">
                    </div>
                    <div class="form-group">
                      <label for="nom">Prenom</label>
                      <input name="prenom" type="text" class="form-control" id="prenom" placeholder="prenom">
                    </div>
                    <div class="form-group">
                      <label for="date_naissance">Date de naissance</label>
                      <input name="date" type="date" class="form-control" id="date_naissance">
                    </div>
                     <div class="form-group">
                      <label for="email">Email</label>
                      <input name="email" type="email" class="form-control" id="email" placeholder="email">
                    </div>
                    <div class="form-group">
                      <label for="tel">Tél</label>
                      <input name="tel" type="tel" class="form-control" id="tel" placeholder="tel">
                    </div>
                    <div class="form-group">
                      <label for="adresse">Adresse</label>
                      <input name="adresse" type="text" class="form-control" id="adresse" placeholder="adresse">
                    </div>
                    <div class="form-group">
                      <label for="specialites">Spécialités</label>
                      <input name="specialites" type="text" class="form-control" id="specialites" placeholder="specialités">
                    </div>  
                    <div class="form-group">
                      <label for="departement">Département</label>
                      <select class="form-control" id="departement" name="dept">
                              <option>Génie Logiciel</option>
                              <option> Web and Mobile Engineering</option>
                              <option>Informatique et Aide à la Décision</option>
                              <option>Langues et Communication</option>
                              <option>Réseaux de Communication</option>
                              <option>Ingénierie des Systèmes Embarqués</option>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="password">Mot de passe</label>
                      <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <label for="photo">Photo</label>
                      <input name="photo" type="file" id="photo">
                      <p class="help-block">Example block-level help text here.</p>
                    </div>
                  </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form>
              </div><!-- /.box -->


            </div><!--/.col (left) -->
           
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>
    </div><!-- ./wrapper -->

     <!-- jQuery 2.1.3 -->
    <script src="inc/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="inc/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='inc/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="inc/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="inc/dist/js/demo.js" type="text/javascript"></script>
  </body>
</html>