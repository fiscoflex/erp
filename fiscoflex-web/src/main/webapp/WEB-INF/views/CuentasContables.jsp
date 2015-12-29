<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet" href="plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="plugins/daterangepicker/daterangepicker-bs3.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<link rel="stylesheet"
	href="http://static.jstree.com/3.0.2/assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="http://static.jstree.com/3.0.2/assets/dist/themes/default/style.min.css" />

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="index2.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<!-- logo for regular state and mobile devices --> <span
				class="logo-lg"><b>FiscoFlex</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">Usuario
									Demo</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image">
									<p>Usuario Demo</p></li>

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Perfil</a>
									</div>
									<div class="pull-right">
										<a href="logout" class="btn btn-default btn-flat">Salir</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<jsp:include page="Menu.jsp" flush="true" />
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Cuentas</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Dashboard</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<!-- Small boxes (Stat box) -->
				<div class="row">

					<!-- ./col -->
				</div>
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<section class="col-lg-7 connectedSortable">


						<!-- Chat box -->
						<div class="box box-success">
							<div class="box-header">
								<i class="fa fa-office"></i>
								<h3 class="box-title">Demo Cuentas Contables</h3>
								<div class="box-tools pull-right" data-toggle="tooltip"
									title="Status"></div>
							</div>
							<div class="btn-group">
								<button type="button"
									class="btn btn-default btn-sm dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									Acciones <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a onclick="demo_create();">Crear Cuenta</a></li>
									<li><a onclick="demo_rename();">Renombrar Cuenta</a></li>
									<li><a onclick="demo_delete();">Eliminar Cuenta</a></li>
								</ul>
							</div>

							<div class="box-body chat" id="chat-box">
								<!--
                <div class="row">
									<div class="col-md-4 col-sm-8 col-xs-8">
										<button type="button" onclick="demo_create();">Crear</button>
										<button type="button" onclick="demo_rename();">Cambiar
											Nombre</button>
										<button type="button" onclick="demo_delete();">Eliminar</button>
									</div>
								</div>
                -->
								<div id="ajax" class="demo"></div>
							</div>
						</div>

					</section>
					<!-- /.Left col -->
					<!-- right col (We are only adding the ID to make the widgets sortable)-->
					<section class="col-lg-5 connectedSortable">


						<!-- Formulario Crear Cuentas Contables -->
						<div class="box box-success" id="crearCuenta">
							<div class="box-header">
								<i class="fa fa-office"></i>
								<h3 class="box-title">Formulario Cuentas Contables</h3>
								<div class="box-tools pull-right" data-toggle="tooltip"
									title="Status"></div>
							</div>
							<form:form method="post" action="crearCuenta" id="crearCuenta"
								name="crearCuenta">

								<div class="col-xs-12">
									<label for="inputNombre">Nombre Cuenta</label> <input
										id="nombreCuenta" name="nombreCuenta" type="text"
										class="form-control" placeholder="Nombre">
								</div>
								<div class="col-xs-12">
									<label for="inputCuentaPadre">Cuenta Padre</label> <input
										id="cuentaPadre" name="cuentaPadre" type="text"
										class="form-control" placeholder="Cuenta Padre">
								</div>
								<div class="col-xs-12">
									<label for="inputNaturaleza">Naturaleza</label> <input
										id="naturaleza" name="naturaleza" type="text"
										class="form-control" placeholder="Naturaleza">
								</div>
								<div class="col-xs-12">
									<label for="inputEstadoFinanciero">Estado Financiero</label> <input
										id="estadoFinanciero" name="estadoFinanciero" type="text"
										class="form-control" placeholder="Estado Financiero">
								</div>
								<div class="col-xs-12">
									<label for="inputOrigen">Origen</label> <input id="origen"
										name="origen" type="text" class="form-control"
										placeholder="Origen">
								</div>

								<div class="col-xs-12">
									<label for="inputProfundidad">Profundidad</label> <input
										id="profundidad" name="profundidad" type="text"
										class="form-control" placeholder="Profundidad">
								</div>
								<div class="box-footer clearfix no-border"></div>
								<div class="box-footer clearfix no-border">
									<button class="btn btn-primary pull-left">
										<i class="fa fa-plus"></i>Guardar
									</button>
								</div>
							</form:form>

						</div>
						<!-- Formulario editar cuentas contables -->
						<div class="box box-success" id="editarCuenta"
							style="display: none;">
							<div class="box-header">
								<i class="fa fa-office"></i>
								<h3 class="box-title">Formulario Editar Cuentas Contables</h3>
								<div class="box-tools pull-right" data-toggle="tooltip"
									title="Status"></div>
							</div>
							<form:form method="post" action="editarCuenta" id="editarCuenta"
								name="editarCuenta">

								<div class="col-xs-12" style="display: none;">
									<label for="inputIdCuentaContable">Id Cuenta Contable</label> <input
										id="idCuentaContableE" name="idCuentaContableE" type="text"
										class="form-control" placeholder="Id Cuenta Contable">
								</div>

								<div class="col-xs-12" style="display: none;">
									<label for="inputCuentaPadreE">Cuenta Padre</label> <input
										id="cuentaPadreE" name="cuentaPadreE" type="text"
										class="form-control" placeholder="Cuenta Padre">
								</div>

								<div class="col-xs-12" style="display: none;">
									<label for="inputProfundidadE">Profundidad</label> <input
										id="profundidadE" name="profundidadE" type="text"
										class="form-control" placeholder="Profundidad">
								</div>

								<div class="col-xs-12">
									<label for="inputNombre">Nombre Cuenta</label> <input
										id="nombreCuentaE" name="nombreCuentaE" type="text"
										class="form-control" placeholder="Nombre">
								</div>

								<div class="col-xs-12">
									<label for="inputNaturaleza">Naturaleza</label> <input
										id="naturalezaE" name="naturalezaE" type="text"
										class="form-control" placeholder="Naturaleza">
								</div>

								<div class="col-xs-12">
									<label for="inputEstadoFinanciero">Estado Financiero</label> <input
										id="estadoFinancieroE" name="estadoFinancieroE" type="text"
										class="form-control" placeholder="Estado Financiero">
								</div>

								<div class="col-xs-12">
									<label for="inputOrigen">Origen</label> <input id="origenE"
										name="origenE" type="text" class="form-control"
										placeholder="Origen">
								</div>

								<div class="box-footer clearfix no-border"></div>
								<div class="box-footer clearfix no-border">
									<button class="btn btn-primary pull-left">
										<i class="fa fa-pencil"></i>Editar Cuenta Contable
									</button>
								</div>
							</form:form>

						</div>
					</section>
					<!-- right col -->
				</div>
				<!-- /.row (main row) -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.3.0
			</div>
			<strong>Copyright &copy; 2014-2015 <a
				href="http://almsaeedstudio.com">Almsaeed Studio</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li><a href="#control-sidebar-home-tab" data-toggle="tab"><i
						class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-user bg-yellow"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Frodo Updated His
										Profile</h4>
									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-envelope-o bg-light-blue"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Nora Joined Mailing
										List</h4>
									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-file-code-o bg-green"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Cron Job 254
										Executed</h4>
									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Update Resume <span class="label label-success pull-right">95%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-success"
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Laravel Integration <span
										class="label label-warning pull-right">50%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-warning"
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Back End Framework <span class="label label-primary pull-right">68%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-primary"
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>
						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked>
							</label>
							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Allow mail
								redirect <input type="checkbox" class="pull-right" checked>
							</label>
							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Expose author
								name in posts <input type="checkbox" class="pull-right" checked>
							</label>
							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->

						<h3 class="control-sidebar-heading">Chat Settings</h3>

						<div class="form-group">
							<label class="control-sidebar-subheading"> Show me as
								online <input type="checkbox" class="pull-right" checked>
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Turn off
								notifications <input type="checkbox" class="pull-right">
							</label>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<label class="control-sidebar-subheading"> Delete chat
								history <a href="javascript::;" class="text-red pull-right"><i
									class="fa fa-trash-o"></i></a>
							</label>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.4 -->
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.5 -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="plugins/morris/morris.min.js"></script>
	<!-- Sparkline -->
	<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="plugins/knob/jquery.knob.js"></script>
	<!-- daterangepicker -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
	<script src="plugins/daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script src="plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script
		src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="plugins/fastclick/fastclick.min.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/app.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="http://static.jstree.com/3.0.2/assets/jquery-1.10.2.min.js"></script>
	<script
		src="http://static.jstree.com/3.0.2/assets/jquery.address-1.6.js"></script>
	<script src="http://static.jstree.com/3.0.2/assets/dist/jstree.min.js"></script>

	<script>
		function demo_create() {

			document.getElementById("crearCuenta").style.display = "block";
			document.getElementById("editarCuenta").style.display = "none";
			var selectedNode = $('#ajax').jstree(true).get_selected('full',
					true);
			selectedNode = selectedNode[0];
			var id = selectedNode.id;
			document.getElementById("cuentaPadre").value = id;
		};

		function demo_rename() {

			document.getElementById("crearCuenta").style.display = "none";
			document.getElementById("editarCuenta").style.display = "block";

			var selectedNode = $('#ajax').jstree(true).get_selected('full',
					true);
			selectedNode = selectedNode[0];

			var id = selectedNode.id;
			var text = selectedNode.text;//texto del nodo seleccionado
			var estadoFinanciero = selectedNode.original.estadoFinanciero;
			var naturaleza = selectedNode.original.naturaleza;
			var origen = selectedNode.original.origen;
			var cuentaPadre = selectedNode.original.cuentaPadre;
			var profundidad = selectedNode.original.profundidad;

			document.getElementById("idCuentaContableE").value = id;
			document.getElementById("nombreCuentaE").value = text;
			document.getElementById("estadoFinancieroE").value = estadoFinanciero;
			document.getElementById("naturalezaE").value = naturaleza;
			document.getElementById("origenE").value = origen;
			document.getElementById("cuentaPadreE").value = cuentaPadre;
			document.getElementById("profundidadE").value = profundidad;
		};

		function demo_delete() {
			var borrar = confirm("Estas seguro de eliminar la cuenta seleccionada!!!");
			if (borrar) {
				var selectedNode = $('#ajax').jstree(true).get_selected('full',
						true);
				selectedNode = selectedNode[0];
				var id = selectedNode.id;
				$.ajaxSetup({
					statusCode : {
						200 : function() {
							location.href = "/fiscoflex/CuentasContables"
						}
					}
				});
				$.ajax({
					type : 'post',
					url : '/fiscoflex/eliminarCuenta',
					data : ({
						idCuenta : id
					})
				});
			}
		};

		$(function() {
			var to = false;
			$('#demo_q').keyup(function() {
				if (to) {
					clearTimeout(to);
				}
				to = setTimeout(function() {
					var v = $('#demo_q').val();
					$('#ajax').jstree(true).search(v);
				}, 250);
			});

			$("#ajax")
					.click(
							function(e) {
								var selectedNode = $('#ajax').jstree(true)
										.get_selected('full', true);
								selectedNode = selectedNode[0];
								var id = selectedNode.id;//id nodo seleccionado
								var text = selectedNode.text;//texto del nodo seleccionado
								var parent = selectedNode.parent;// id nodo padre del nodo seleccionado
								var estadoFinanciero = selectedNode.original.estadoFinanciero;
								var naturaleza = selectedNode.original.naturaleza;
								var origen = selectedNode.original.origen;
								//console.log(estadoFinanciero, naturaleza, origen);
							});

			var json = (function() {
				var json = [];
				var old = [];
				$
						.ajax({
							'async' : false,
							'url' : '/fiscoflex/cuentas',
							'dataType' : "json",
							'success' : function(data) {
								old = JSON.stringify(data);
								console.log(data);
								for (var i = 0; i < old.length; i++) {
									old = old.replace("\"idCuentaContable\":",
											"\"id\":");
									old = old.replace("\"nombreCuenta\":",
											"\"text\":");
									old = old.replace("\"cuentas\":",
											"\"children\":");
									json = JSON.parse(old);
								}
							}
						});
				return json;
			})();

			$('#ajax').jstree(
					{
						"core" : {
							"animation" : 0,
							"themes" : {
								"stripes" : true
							},
							'data' : json
						},
						"types" : {
							"#" : {
								"valid_children" : [ "root" ]
							},
							"root" : {
								"valid_children" : [ "default" ]
							},
							"default" : {
								"valid_children" : [ "default", "file" ]
							},
							"file" : {
								"icon" : "glyphicon glyphicon-file",
								"valid_children" : []
							}
						},
						"plugins" : [ "contextmenu", "dnd", "search", "state",
								"types" ], //"wholerow" 
						"contextmenu" : {
							"items" : function($node) {
								return {
									"Create" : {
										"label" : "Create cuenta contable",
										"action" : function(obj) {
											demo_create();
										}
									},
									"Rename" : {
										"label" : "Editar cuenta contable",
										"action" : function(obj) {
											demo_rename();
										}
									},
									"Delete" : {
										"label" : "Borrar cuenta contable",
										"action" : function(obj) {
											demo_delete();
										}
									}
								};
							}
						}
					});
		});
	</script>
</body>
</html>