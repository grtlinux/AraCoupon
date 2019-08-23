<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<title>bootstrap3-01 Page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- latest compiled and minified CSS
	-->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<!-- JQuery library
	-->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- JQuery compiled JavaScript
	-->
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<!-- my css
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<link rel="stylesheet" href="/bootstrap3/css/bootstrap.css">
<link rel="stylesheet" href="/bootstrap3/css/ara2.ara.codingBooster5.v01.css">
-->
<body>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- jumbotron -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="hide">
		<div class="jumbotron text-center">
			<h1>My First Bootstrap Page</h1>
			<p>Resize this responsive page to see the effect!!</p>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<h3>Column 1</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
				</div>
				<div class="col-sm-4">
					<h3>Column 2</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
				</div>
				<div class="col-sm-4">
					<h3>Column 3</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
				</div>
			</div>
		</div>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Image</h2>
		<p>The .img-responsive class makes the image scale nicely to the parent element (resize the browser window to see the effect):</p>
		<!-- img-responsive
		<img class="img-responsive" src="/bootstrap3/images/img_chania.jpg" alt="Chania" width="920" height="346">
		-->
		<img src="/bootstrap3/images/img_chania.jpg" alt="Chania" width="920" height="346">
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- embed-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Aspect ratio 4:3</h2>
		<div class="embed-responsive embed-responsive-4by3">
			<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tgbNymZ7vqY"></iframe>
		</div>

		<h2>Aspect ratio 16:9</h2>
		<div class="embed-responsive embed-responsive-16by9">
			<iframe class="embed-responsive-item" src="https://www.youtube.com/embed/tgbNymZ7vqY"></iframe>
		</div>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Alert Links</h2>
		<p>Add the alert-link class to any links inside the alert box to create "matching colored links".</p>
		<div class="alert alert-success alert-dismissible fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Success!</strong> You should <a href="#" class="alert-link">read this message</a>. fade in
		</div>
		<div class="alert alert-info alert-dismissible fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Info!</strong> You should <a href="#" class="alert-link">read this message</a>. fade in
		</div>
		<div class="alert alert-warning alert-dismissible fade in">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Warning!</strong> You should <a href="#" class="alert-link">read this message</a>. fade in
		</div>
		<div class="alert alert-danger alert-dismissible">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			<strong>Danger!</strong> You should <a href="#" class="alert-link">read this message</a>.
		</div>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Button Styles</h2>
		<button type="button" class="btn">Basic</button>
		<button type="button" class="btn btn-default">Default</button>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-link">Link</button>
		<h2>Button Tags</h2>
		<a href="#" class="btn btn-info" role="button">Link Button</a>
		<button type="button" class="btn btn-info">Button</button>
		<input type="button" class="btn btn-info" value="Input Button">
		<input type="submit" class="btn btn-info" value="Submit Button">
		<h2>Button Sizes</h2>
		<button type="button" class="btn btn-primary btn-lg">Large</button>
		<button type="button" class="btn btn-primary btn-md">Medium</button>
		<button type="button" class="btn btn-primary btn-sm">Small</button>
		<button type="button" class="btn btn-primary btn-xs">XSmall</button>
		<h2>Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-block">Button 1</button>
		<button type="button" class="btn btn-default btn-block">Button 2</button>

		<h2>Large Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-lg btn-block">Button 1</button>
		<button type="button" class="btn btn-default btn-lg btn-block">Button 2</button>

		<h2>Small Block Level Buttons</h2>
		<button type="button" class="btn btn-primary btn-sm btn-block">Button 1</button>
		<button type="button" class="btn btn-default btn-sm btn-block">Button 2</button>
		<h2>Button States</h2>
		<button type="button" class="btn btn-primary">Primary Button</button>
		<button type="button" class="btn btn-primary active">Active Primary</button>
		<button type="button" class="btn btn-primary disabled">Disabled Primary</button>
		<h2>Button Group</h2>
		<p>The .btn-group class creates a button group:</p>
		<div class="btn-group">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h2>Button Groups - Set Sizes</h2>
		<p>Add class .btn-group-* to size all buttons in a button group.</p>
		<h3>Large Buttons:</h3>
		<div class="btn-group btn-group-lg">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h3>Default Buttons:</h3>
		<div class="btn-group">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h3>Small Buttons:</h3>
		<div class="btn-group btn-group-sm">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h3>Extra Small Buttons:</h3>
		<div class="btn-group btn-group-xs">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h2>Vertical Button Group</h2>
		<p>Use the .btn-group-vertical class to create a vertical button group:</p>
		<div class="btn-group-vertical">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<button type="button" class="btn btn-primary">Sony</button>
		</div>
		<h2>Justified Button Groups</h2>
		<p>To span the entire width of the screen, use the .btn-group-justified class:</p>
		<div class="btn-group btn-group-justified">
			<a href="#" class="btn btn-primary">Apple</a>
			<a href="#" class="btn btn-primary">Samsung</a>
			<a href="#" class="btn btn-primary">Sony</a>
		</div>
		<h2>Justified Button Groups</h2>
		<div class="btn-group btn-group-justified">
			<div class="btn-group">
				<button type="button" class="btn btn-primary">Apple</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary">Samsung</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary">Sony</button>
			</div>
		</div>
		<h2>Nesting Button Groups</h2>
		<p>Nest button groups to create drop down menus:</p>
		<div class="btn-group">
			<button type="button" class="btn btn-primary">Apple</button>
			<button type="button" class="btn btn-primary">Samsung</button>
			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
				Sony <span class="caret"></span></button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">Tablet</a></li>
					<li><a href="#">Smartphone</a></li>
				</ul>
			</div>
		</div>
	</div>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Glyphicon Examples</h2>
		<p>Envelope icon: <span class="glyphicon glyphicon-envelope"></span></p>
		<p>Envelope icon as a link:
			<a href="#"><span class="glyphicon glyphicon-envelope"></span></a>
		</p>
		<p>Search icon: <span class="glyphicon glyphicon-search"></span></p>
		<p>Search icon on a button:
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
		</p>
		<p>Search icon on a styled button:
			<button type="button" class="btn btn-info">
				<span class="glyphicon glyphicon-search"></span> Search
			</button>
		</p>
		<p>Print icon: <span class="glyphicon glyphicon-print"></span></p>
		<p>Print icon on a styled link button:
			<a href="#" class="btn btn-success btn-lg">
				<span class="glyphicon glyphicon-print"></span> Print
			</a>
		</p>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Badges</h2>
		<a href="#">News <span class="badge">5</span></a><br>
		<a href="#">Comments <span class="badge">10</span></a><br>
		<a href="#">Updates <span class="badge">2</span></a>
		<h2>Badges on Buttons</h2>
		<button type="button" class="btn btn-primary">Primary <span class="badge">7</span></button>
		<button type="button" class="btn btn-success">Success <span class="badge">3</span></button>
		<button type="button" class="btn btn-danger">Danger <span class="badge">5</span></button>
		<h2>Labels</h2>
		<h1>Example <span class="label label-default">New</span></h1>
		<h2>Example <span class="label label-default">New</span></h2>
		<h3>Example <span class="label label-default">New</span></h3>
		<h4>Example <span class="label label-default">New</span></h4>
		<h5>Example <span class="label label-default">New</span></h5>
		<h6>Example <span class="label label-default">New</span></h6>
		<h2>Contextual Label Classes</h2>
		<p>Contextual classes can be used to color the label.</p>
		<span class="label label-default">Default Label</span>
		<span class="label label-primary">Primary Label</span>
		<span class="label label-success">Success Label</span>
		<span class="label label-info">Info Label</span>
		<span class="label label-warning">Warning Label</span>
		<span class="label label-danger">Danger Label</span>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Basic Progress Bar</h2>
		<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
				<span class="sr-only">70% Complete</span>
			</div>
		</div>
		<h2>Progress Bar With Label</h2>
		<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
				70%
			</div>
		</div>
		<h2>Colored Progress Bars</h2>
		<p>The contextual classes colors the progress bars:</p>
		<div class="progress">
			<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
				40% Complete (success)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%">
				50% Complete (info)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width:60%">
				60% Complete (warning)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
				70% Complete (danger)
			</div>
		</div>
		<h2>Striped Progress Bars</h2>
		<p>The .progress-bar-striped class adds stripes to the progress bars:</p>
		<div class="progress">
			<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
				40% Complete (success)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:50%">
				50% Complete (info)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-warning progress-bar-striped" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width:60%">
				60% Complete (warning)
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width:70%">
				70% Complete (danger)
			</div>
		</div>
		<h2>Animated Progress Bar</h2>
		<p>The .active class animates the progress bar:</p>
		<div class="progress">
			<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:40%">
				40%
			</div>
		</div>
		<h2>Stacked Progress Bars</h2>
		<p>Create a stacked progress bar by placing multiple bars into the same div with class .progress:</p>
		<div class="progress">
			<div class="progress-bar progress-bar-success" role="progressbar" style="width:40%">
				Free Space
			</div>
			<div class="progress-bar progress-bar-warning" role="progressbar" style="width:10%">
				Warning
			</div>
			<div class="progress-bar progress-bar-danger" role="progressbar" style="width:20%">
				Danger
			</div>
		</div>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Pagination</h2>
		<p>The .pagination class provides pagination links:</p>
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
		<h2>Pagination - Active State</h2>
		<p>Add class .active to let the user know which page he/she is on:</p>
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li class="active"><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
		<h2>Pagination - Disabled State</h2>
		<p>Add class .disabled if a page for some reason is disabled:</p>
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li class="disabled"><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
		<h2>Pagination - Sizing</h2>
		<p>Add class .pagination-lg for larger blocks or .pagination-sm for smaller blocks.</p>

		<p>Large:</p>
		<ul class="pagination pagination-lg">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>

		<p>Default:</p>
		<ul class="pagination pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>

		<p>Small:</p>
		<ul class="pagination pagination-sm">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
		<h2>Breadcrumbs</h2>
		<p>The .breadcrumb class indicates the current page's location within a navigational hierarchy:</p>
		<ul class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Private</a></li>
			<li><a href="#">Pictures</a></li>
			<li class="active">Vacation</li>
		</ul>
		<h2>Pager</h2>
		<p>The .pager class provides previous and next buttons (links):</p>
		<ul class="pager">
			<li><a href="#">Previous</a></li>
			<li><a href="#">Next</a></li>
		</ul>
		<h2>Pager</h2>
		<p>The .previous and .next classes align each link to the sides of the page:</p>
		<ul class="pager">
			<li class="previous"><a href="#">Previous</a></li>
			<li class="next"><a href="#">Next</a></li>
		</ul>
	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Basic List Group</h2>
		<ul class="list-group">
			<li class="list-group-item">First item</li>
			<li class="list-group-item">Second item</li>
			<li class="list-group-item">Third item</li>
		</ul>
		<h2>List Group With Badges</h2>
		<ul class="list-group">
			<li class="list-group-item">New <span class="badge">12</span></li>
			<li class="list-group-item">Deleted <span class="badge">5</span></li>
			<li class="list-group-item">Warnings <span class="badge">3</span></li>
		</ul>
		<h2>List Group With Linked Items</h2>
		<div class="list-group">
			<a href="#" class="list-group-item">First item</a>
			<a href="#" class="list-group-item">Second item</a>
			<a href="#" class="list-group-item">Third item</a>
		</div>
		<h2>Active Item in a List Group</h2>
		<div class="list-group">
			<a href="#" class="list-group-item active">First item</a>
			<a href="#" class="list-group-item">Second item</a>
			<a href="#" class="list-group-item">Third item</a>
		</div>
		<h2>List Group With a Disabled Item</h2>
		<div class="list-group">
			<a href="#" class="list-group-item disabled">First item</a>
			<a href="#" class="list-group-item">Second item</a>
			<a href="#" class="list-group-item">Third item</a>
		</div>
		<h2>List Group With Contextual Classes</h2>
		<ul class="list-group">
			<li class="list-group-item list-group-item-success">First item</li>
			<li class="list-group-item list-group-item-info">Second item</li>
			<li class="list-group-item list-group-item-warning">Third item</li>
			<li class="list-group-item list-group-item-danger">Fourth item</li>
		</ul>

		<h2>Linked Items With Contextual Classes</h2>
		<p>Move the mouse over the linked items to see the hover effect:</p>
		<div class="list-group">
			<a href="#" class="list-group-item list-group-item-success">First item</a>
			<a href="#" class="list-group-item list-group-item-info">Second item</a>
			<a href="#" class="list-group-item list-group-item-warning">Third item</a>
			<a href="#" class="list-group-item list-group-item-danger">Fourth item</a>
		</div>
		<h2>List Group With Custom Content</h2>
		<div class="list-group">
			<a href="#" class="list-group-item active">
				<h4 class="list-group-item-heading">First List Group Item Heading</h4>
				<p class="list-group-item-text">List Group Item Text</p>
			</a>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Second List Group Item Heading</h4>
				<p class="list-group-item-text">List Group Item Text</p>
			</a>
			<a href="#" class="list-group-item">
				<h4 class="list-group-item-heading">Third List Group Item Heading</h4>
				<p class="list-group-item-text">List Group Item Text</p>
			</a>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Basic Panel</h2>
		<div class="panel panel-default">
			<div class="panel-body">A Basic Panel</div>
		</div>
		<h2>Panel Heading</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Panel Heading</div>
			<div class="panel-body">Panel Content</div>
		</div>
		<h2>Panel Footer</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Panel Heading</div>
			<div class="panel-body">Panel Content</div>
			<div class="panel-footer">Panel Footer</div>
		</div>
		<h2>Panel Group</h2>
		<p>The panel-group class clears the bottom-margin. Try to remove the class and see what happens.</p>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">Panel Header</div>
				<div class="panel-body">Panel Content</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Panel Header</div>
				<div class="panel-body">Panel Content</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">Panel Header</div>
				<div class="panel-body">Panel Content</div>
			</div>
		</div>
		<h2>Panels with Contextual Classes</h2>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">Panel with panel-default class</div>
				<div class="panel-body">Panel Content</div>
			</div>

			<div class="panel panel-primary">
				<div class="panel-heading">Panel with panel-primary class</div>
				<div class="panel-body">Panel Content</div>
			</div>

			<div class="panel panel-success">
				<div class="panel-heading">Panel with panel-success class</div>
				<div class="panel-body">Panel Content</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">Panel with panel-info class</div>
				<div class="panel-body">Panel Content</div>
			</div>

			<div class="panel panel-warning">
				<div class="panel-heading">Panel with panel-warning class</div>
				<div class="panel-body">Panel Content</div>
			</div>

			<div class="panel panel-danger">
				<div class="panel-heading">Panel with panel-danger class</div>
				<div class="panel-body">Panel Content</div>
			</div>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
	<h2>Dropdowns</h2>
	<p>The .dropdown class is used to indicate a dropdown menu.</p>
	<p>Use the .dropdown-menu class to actually build the dropdown menu.</p>
	<p>To open the dropdown menu, use a button or a link with a class of .dropdown-toggle and data-toggle="dropdown".</p>
	<div class="dropdown">
		<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>The .divider class is used to separate links inside the dropdown menu with a thin horizontal line:</p>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li class="divider"></li>
			<li><a href="#">About Us</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>The .dropdown-header class is used to add headers inside the dropdown menu:</p>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li class="dropdown-header">Dropdown header 1</li>
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li class="divider"></li>
			<li class="dropdown-header">Dropdown header 2</li>
			<li><a href="#">About Us</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>The .active class adds a blue background color to the active link.</p>
	<p>The .disabled class disables a dropdown item (grey text color).</p>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Tutorials
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="#">Normal</a></li>
			<li class="disabled"><a href="#">Disabled</a></li>
			<li class="active"><a href="#">Active</a></li>
			<li><a href="#">Normal</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>Add the .dropdown-menu-right class to .dropdown-menu to right-align the dropdown menu:</p>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
		<span class="caret"></span></button>
		<ul class="dropdown-menu dropdown-menu-right">
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li class="divider"></li>
			<li><a href="#">About Us</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>The .dropup class makes the dropdown menu expand upwards instead of downwards:</p>
	<div class="dropup">
		<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Dropup Example
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li class="divider"></li>
			<li><a href="#">About Us</a></li>
		</ul>
	</div>
	<h2>Dropdowns</h2>
	<p>The .dropdown class is used to indicate a dropdown menu.</p>
	<p>Use the .dropdown-menu class to actually build the dropdown menu.</p>
	<div class="dropdown">
		<button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Tutorials
		<span class="caret"></span></button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">HTML</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">CSS</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">JavaScript</a></li>
			<li role="presentation" class="divider"></li>
			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">About Us</a></li>
		</ul>
	</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Simple Collapsible</h2>
		<p>Click on the button to toggle between showing and hiding content.</p>
		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Simple collapsible</button>
		<div id="demo" class="collapse">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		</div>
		<h2>Simple Collapsible</h2>
		<a href="#demo" class="btn btn-info" data-toggle="collapse">Simple collapsible</a>
		<div id="demo" class="collapse">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		</div>
		<h2>Simple Collapsible</h2>
		<p>Click on the button to toggle between showing and hiding content.</p>
		<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Simple collapsible</button>
		<div id="demo" class="collapse in">
			Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
			quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
		</div>
		<h2>Collapsible Panel</h2>
		<p>Click on the collapsible panel to open and close it.</p>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse1">Collapsible panel</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">Panel Body</div>
					<div class="panel-footer">Panel Footer</div>
				</div>
			</div>
		</div>
		<h2>Collapsible List Group</h2>
		<p>Click on the collapsible panel to open and close it.</p>
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" href="#collapse1">Collapsible list group</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<ul class="list-group">
						<li class="list-group-item">One</li>
						<li class="list-group-item">Two</li>
						<li class="list-group-item">Three</li>
					</ul>
					<div class="panel-footer">Footer</div>
				</div>
			</div>
		</div>
		<h2>Accordion Example</h2>
		<p><strong>Note:</strong> The <strong>data-parent</strong> attribute makes sure that all collapsible elements under the specified parent will be closed when one of the collapsible item is shown.</p>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Collapsible Group 1</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in">
					<div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Collapsible Group 2</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Collapsible Group 3</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
					quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
				</div>
			</div>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h3>Inline List</h3>
		<ul class="list-inline">
			<li><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h3>Tabs</h3>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<br>
		<p><strong>Note:</strong> This example shows how to create a basic navigation tab. It is not toggleable/dynamic yet (you can't click on the links to display different content)- see the last example in the Bootstrap Tabs and Pills Tutorial to find out how this can be done.</p>
		<h3>Tabs With Dropdown Menu</h3>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Submenu 1-1</a></li>
					<li><a href="#">Submenu 1-2</a></li>
					<li><a href="#">Submenu 1-3</a></li>
				</ul>
			</li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h3>Pills</h3>
		<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h3>Vertical Pills</h3>
		<p>Use the .nav-stacked class to vertically stack pills:</p>
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h3>Vertical Pills</h3>
		<div class="row">
			<div class="col-md-3">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="col-md-3">
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-md-3">
				<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			</div>
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Menu 1</a></li>
					<li><a href="#">Menu 2</a></li>
					<li><a href="#">Menu 3</a></li>
				</ul>
			</div>
			<div class="clearfix visible-lg"></div>
		</div>
		<h3>Pills With Dropdown Menu</h3>
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#">Home</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Submenu 1-1</a></li>
					<li><a href="#">Submenu 1-2</a></li>
					<li><a href="#">Submenu 1-3</a></li>
				</ul>
			</li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h3>Centered Tabs</h3>
		<p>To center/justify the tabs and pills, use the .nav-justified class. Note that on screens that are smaller than 768px, the list items are stacked (content will remain centered).</p>
		<ul class="nav nav-tabs nav-justified">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<br>
		<h3>Centered Pills</h3>
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Menu 1</a></li>
			<li><a href="#">Menu 2</a></li>
			<li><a href="#">Menu 3</a></li>
		</ul>
		<h2>Dynamic Tabs</h2>
		<p>To make the tabs toggleable, add the data-toggle="tab" attribute to each link. Then add a .tab-pane class with a unique ID for every tab and wrap them inside a div element with class .tab-content.</p>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
			<li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
			<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>HOME</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>Menu 1</h3>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>Menu 2</h3>
				<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>Menu 3</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
			</div>
		</div>
		<h2>Dynamic Pills</h2>
		<p>To make the tabs toggleable, add the data-toggle="pill" attribute to each link. Then add a .tab-pane class with a unique ID for every tab and wrap them inside a div element with class .tab-content.</p>
		<ul class="nav nav-pills">
			<li class="active"><a data-toggle="pill" href="#home">Home</a></li>
			<li><a data-toggle="pill" href="#menu1">Menu 1</a></li>
			<li><a data-toggle="pill" href="#menu2">Menu 2</a></li>
			<li><a data-toggle="pill" href="#menu3">Menu 3</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>HOME</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>Menu 1</h3>
				<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>Menu 2</h3>
				<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>Menu 3</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
			</div>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>

		<div class="container">
			<h3>Basic Navbar Example</h3>
			<p>A navigation bar is a navigation header that is placed at the top of the page.</p>
		</div>
	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>

		<div class="container">
			<h3>Inverted Navbar</h3>
			<p>An inverted navbar is black instead of gray.</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul>
					</li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>

		<div class="container">
			<h3>Navbar With Dropdown</h3>
			<p>This example adds a dropdown menu for the "Page 1" button in the navigation bar.</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Page 1-1</a></li>
							<li><a href="#">Page 1-2</a></li>
							<li><a href="#">Page 1-3</a></li>
						</ul>
					</li>
					<li><a href="#">Page 2</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
		</nav>

		<div class="container">
			<h3>Right Aligned Navbar</h3>
			<p>The .navbar-right class is used to right-align navigation bar buttons.</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul>
				<button class="btn btn-danger navbar-btn">Button</button>
			</div>
		</nav>

		<div class="container">
			<h2>Navbar Button</h2>
			<p>Use the navbar-btn class on a button to vertically align (same padding as links) it inside the navbar.</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
				</ul>
				<form class="navbar-form navbar-left" action="/action_page.php">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" name="search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</nav>

		<div class="container">
			<h3>Navbar Forms</h3>
			<p>Use the .navbar-form class to vertically align form elements (same padding as links) inside the navbar.</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
				</ul>
				<form class="navbar-form navbar-left" action="/action_page.php">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</nav>

		<div class="container">
			<h3>Navbar Forms</h3>
			<p>Use the .navbar-form class to vertically align form elements (same padding as links) inside the navbar.</p>
			<p>The .input-group class is a container to enhance an input by adding an icon, text or a button in front or behind it as a "help text".</p>
			<p>The .input-group-btn class attaches a button next to an input field. This is often used as a search bar:</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<ul class="nav navbar-nav">
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
			</ul>
			<p class="navbar-text">Some text</p>
		</nav>

		<div class="container">
			<h3>Navbar Text</h3>
			<p>Use the .navbar-text class to vertical align any elements inside the navbar that are not links (ensures proper padding).</p>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>

		<div class="container" style="margin-top:50px">
			<h3>Fixed Navbar</h3>
			<div class="row">
				<div class="col-md-4">
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
				</div>
				<div class="col-md-4">
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
				</div>
				<div class="col-md-4">
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
					<p>A fixed navigation bar stays visible in a fixed position (top or bottom) independent of the page scroll.</p>
				</div>
			</div>
		</div>

		<h1>Scroll this page to see the effect</h1>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse navbar-fixed-bottom">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Page 1</a></li>
					<li><a href="#">Page 2</a></li>
					<li><a href="#">Page 3</a></li>
				</ul>
			</div>
		</nav>

		<div class="container">
			<h3>Fixed Bottom Navbar</h3>
			<div class="row">
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="clearfix visible-lg"></div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="clearfix visible-lg"></div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="clearfix visible-lg"></div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="col-md-3">
					<p>The .navbar-fixed-bottom class makes the navigation bar stay at the bottom.</p>
				</div>
				<div class="clearfix visible-lg"></div>
			</div>
		</div>

	</div>

	<div class="container hide">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li class="dropdown">
							<a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Page 1-1</a></li>
								<li><a href="#">Page 1-2</a></li>
								<li><a href="#">Page 1-3</a></li>
							</ul>
						</li>
						<li><a href="#">Page 2</a></li>
						<li><a href="#">Page 3</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="container">
			<h3>Collapsible Navbar</h3>
			<p>In this example, the navigation bar is hidden on small screens and replaced by a button in the top right corner (try to re-size this window).
			<p>Only when the button is clicked, the navigation bar will be displayed.</p>
		</div>

	</div>

	<div class="container show">

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- BS Forms -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Vertical (basic) form</h2>
		<form action="/action_page.php">
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="remember"> Remember me</label>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<h2>Inline form</h2>
		<p>Make the viewport larger than 768px wide to see that all of the form elements are inline, left aligned, and the labels are alongside.</p>
		<form class="form-inline" action="/action_page.php">
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="remember"> Remember me</label>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<h2>Inline form with .sr-only class</h2>
		<p>Make the viewport larger than 768px wide to see that all of the form elements are inline, left aligned, and the labels are alongside.</p>
		<form class="form-inline" action="/action_page.php">
			<div class="form-group">
				<label class="sr-only" for="email">Email:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter email"	name="email">
			</div>
			<div class="form-group">
				<label class="sr-only" for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="remember"> Remember me</label>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<h2>Horizontal form</h2>
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="remember"> Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Form control: input</h2>
		<p>The form below contains two input elements; one of type text and one of type password:</p>
		<form>
			<div class="form-group">
				<label for="usr">Name:</label>
				<input type="text" class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label>
				<input type="password" class="form-control" id="pwd">
			</div>
		</form>
		<h2>Form control: textarea</h2>
		<p>The form below contains a textarea for comments:</p>
		<form>
			<div class="form-group">
				<label for="comment">Comment:</label>
				<textarea class="form-control" rows="5" id="comment"></textarea>
			</div>
		</form>
		<h2>Form control: checkbox</h2>
		<p>The form below contains three checkboxes. The last option is disabled:</p>
		<form>
			<div class="checkbox">
				<label><input type="checkbox" value="">Option 1</label>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" value="">Option 2</label>
			</div>
			<div class="checkbox disabled">
				<label><input type="checkbox" value="" disabled>Option 3</label>
			</div>
		</form>
		<h2>Form control: inline checkbox</h2>
		<p>The form below contains three inline checkboxes:</p>
		<form>
			<label class="checkbox-inline">
				<input type="checkbox" value="">Option 1
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" value="">Option 2
			</label>
			<label class="checkbox-inline">
				<input type="checkbox" value="">Option 3
			</label>
		</form>
		<h2>Form control: radio buttons</h2>
		<p>The form below contains three radio buttons. The last option is disabled:</p>
		<form>
			<div class="radio">
				<label><input type="radio" name="optradio" checked>Option 1</label>
			</div>
			<div class="radio">
				<label><input type="radio" name="optradio">Option 2</label>
			</div>
			<div class="radio disabled">
				<label><input type="radio" name="optradio" disabled>Option 3</label>
			</div>
		</form>
		<h2>Form control: inline radio buttons</h2>
		<p>The form below contains three inline radio buttons:</p>
		<form>
			<label class="radio-inline">
				<input type="radio" name="optradio" checked>Option 1
			</label>
			<label class="radio-inline">
				<input type="radio" name="optradio">Option 2
			</label>
			<label class="radio-inline">
				<input type="radio" name="optradio">Option 3
			</label>
		</form>
		<h2>Form control: select</h2>
		<p>The form below contains two dropdown menus (select lists):</p>
		<form>
			<div class="form-group">
				<label for="sel1">Select list (select one):</label>
				<select class="form-control" id="sel1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
				<br>
				<label for="sel2">Mutiple select list (hold shift to select more than one):</label>
				<select multiple class="form-control" id="sel2">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
		</form>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Horizontal form with static control</h2>
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<p class="form-control-static">someone@example.com</p>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
		<h3>Input Groups</h3>
		<p>The .input-group class is a container to enhance an input by adding an icon, text or a button in front or behind it as a "help text".</p>
		<p>The .input-group-addon class attaches an icon or help text next to the input field.</p>

		<form>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				<input id="email" type="text" class="form-control" name="email" placeholder="Email">
			</div>
			<div class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				<input id="password" type="password" class="form-control" name="password" placeholder="Password">
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon">Text</span>
				<input id="msg" type="text" class="form-control" name="msg" placeholder="Additional Info">
			</div>
		</form>
		<br>

		<p>It can also be used on the right side of the input:</p>
		<form>
			<div class="input-group">
				<input id="email" type="text" class="form-control" name="email" placeholder="Email">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			</div>
			<div class="input-group">
				<input id="password" type="password" class="form-control" name="password" placeholder="Password">
				<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			</div>
		</form>
		<h1>Input Group Button</h1>
		<p>The .input-group class is a container to enhance an input by adding an icon, text or a button in front or behind it as a "help text".</p>
		<p>The .input-group-btn class attaches a button next to an input field. This is often used as a search bar:</p>
		<form action="/action_page.php">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search" name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
				</div>
			</div>
		</form>
		<h2>Horizontal form: control states</h2>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="col-sm-2 control-label">Focused</label>
				<div class="col-sm-10">
					<input class="form-control" id="focusedInput" type="text" value="Click to focus...">
				</div>
			</div>
			<div class="form-group">
				<label for="disabledInput" class="col-sm-2 control-label">Disabled</label>
				<div class="col-sm-10">
					<input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here..." disabled>
				</div>
			</div>
			<fieldset disabled>
				<div class="form-group">
					<label for="disabledTextInput" class="col-sm-2 control-label">Disabled input and select list (Fieldset disabled)</label>
					<div class="col-sm-10">
						<input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
					</div>
				</div>
				<div class="form-group">
					<label for="disabledSelect" class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<select id="disabledSelect" class="form-control">
							<option>Disabled select</option>
						</select>
					</div>
				</div>
			</fieldset>
			<div class="form-group has-success has-feedback">
				<label class="col-sm-2 control-label" for="inputSuccess">Input with success and glyphicon</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputSuccess">
					<span class="glyphicon glyphicon-ok form-control-feedback"></span>
				</div>
			</div>
			<div class="form-group has-warning has-feedback">
				<label class="col-sm-2 control-label" for="inputWarning">Input with warning and glyphicon</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputWarning">
					<span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
				</div>
			</div>
			<div class="form-group has-error has-feedback">
				<label class="col-sm-2 control-label" for="inputError">Input with error and glyphicon</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputError">
					<span class="glyphicon glyphicon-remove form-control-feedback"></span>
				</div>
			</div>
		</form>
		<h2>Inline form: control states</h2>
		<form class="form-inline">
			<div class="form-group">
				<label for="focusedInput">Focused</label>
				<input class="form-control" id="focusedInput" type="text">
			</div>
			<div class="form-group">
				<label for="inputPassword">Disabled</label>
				<input class="form-control" id="disabledInput" type="text" disabled>
			</div>
			<div class="form-group has-success has-feedback">
				<label for="inputSuccess2">Input with success</label>
				<input type="text" class="form-control" id="inputSuccess2">
				<span class="glyphicon glyphicon-ok form-control-feedback"></span>
			</div>
			<div class="form-group has-warning has-feedback">
				<label for="inputWarning2">Input with warning</label>
				<input type="text" class="form-control" id="inputWarning2">
				<span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
			</div>
			<div class="form-group has-error has-feedback">
				<label for="inputError2">Input with error</label>
				<input type="text" class="form-control" id="inputError2">
				<span class="glyphicon glyphicon-remove form-control-feedback"></span>
			</div>
		</form>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
	<h2>Input Sizing</h2>
	<p>The form below shows input elements with different heights using .input-lg and .input-sm:</p>
	<form>
		<div class="form-group">
			<label for="inputdefault">Default input</label>
			<input class="form-control" id="inputdefault" type="text">
		</div>
		<div class="form-group">
			<label for="inputlg">input-lg</label>
			<input class="form-control input-lg" id="inputlg" type="text">
		</div>
		<div class="form-group">
			<label for="inputsm">input-sm</label>
			<input class="form-control input-sm" id="inputsm" type="text">
		</div>
		<div class="form-group">
			<label for="sel1">Default select list</label>
			<select class="form-control" id="sel1">
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</div>
		<div class="form-group">
			<label for="sel2">input-lg</label>
			<select class="form-control input-lg" id="sel2">
				<option>1</option>
				<option>2</option>
				<option>3</option>
			</select>
		</div>
		<div class="form-group">
			<label for="sel3">input-sm</label>
			<select class="form-control input-sm" id="sel3">
				<option>1</option>
				<option>2</option>
				<option>3</option>
			</select>
		</div>
	</form>
	<h2>Input Sizing</h2>
	<p>You can quickly size labels and form controls within a Horizontal form by adding .form-group-lg or .form-group-sm to the div class="form-group" element:</p>
	<form class="form-horizontal">
		<div class="form-group form-group-lg">
			<label class="col-sm-2 control-label" for="lg">form-group-lg</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" id="lg">
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-sm-2 control-label" for="sm">form-group-sm</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" id="sm">
			</div>
		</div>
	</form>
	<h1>Input Group Size</h1>
	<p>The .input-group class is a container to enhance an input by adding an icon, text or a button in front or behind it as a "help text".</p>
	<p>Use the .input-group-lg if you want a large input group:</p>
	<form>
		<div class="input-group input-group-lg">
			<input type="text" class="form-control" placeholder="Search">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			</div>
		</div>
	</form>
	<br>

	<p>Use the .input-group-sm if you want a small input group:</p>
	<form>
		<div class="input-group input-group-sm">
			<input type="text" class="form-control" placeholder="Search">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			</div>
		</div>
	</form>
	<h2>Column Sizing</h2>
	<p>The form below shows input elements with different widths using different .col-xs-* classes:</p>
	<form>
		<div class="form-group row">
			<div class="col-xs-2">
				<label for="ex1">col-xs-2</label>
				<input class="form-control" id="ex1" type="text">
			</div>
			<div class="col-xs-3">
				<label for="ex2">col-xs-3</label>
				<input class="form-control" id="ex2" type="text">
			</div>
			<div class="col-xs-4">
				<label for="ex3">col-xs-4</label>
				<input class="form-control" id="ex3" type="text">
			</div>
		</div>
	</form>
	<h2>Help text</h2>
	<p>Use the .help-block class to add a block level help text in forms:</p>
	<form>
		<div class="form-group">
			<label for="pwd">Password:</label>
			<input type="password" class="form-control" id="pwd" placeholder="Enter password">
			<span class="help-block">This is some help text that breaks onto a new line and may extend more than one line.</span>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Media Object</h2>
		<p>Use the "media-left" class to left-align a media object. Text that should appear next to the image, is placed inside a container with class="media-body".</p>
		<p>Tip: Use the "media-right" class to right-align the media object.</p><br>

		<!-- Left-aligned media object -->
		<div class="media">
			<div class="media-left">
				<img src="img_avatar1.png" class="media-object" style="width:60px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">Left-aligned</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<hr>

		<!-- Right-aligned media object -->
		<div class="media">
			<div class="media-body">
				<h4 class="media-heading">Right-aligned</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
			<div class="media-right">
				<img src="img_avatar1.png" class="media-object" style="width:60px">
			</div>
		</div>
		<h2>Media Object</h2>
		<p>The media object can also be top, middle or bottom-aligned with the "media-top", "media-middle" or "media-bottom" class:</p><br>
		<div class="media">
			<div class="media-left media-top">
				<img src="img_avatar1.png" class="media-object" style="width:80px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">Media Top</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<hr>
		<div class="media">
			<div class="media-left media-middle">
				<img src="img_avatar1.png" class="media-object" style="width:80px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">Media Middle</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<hr>
		<div class="media">
			<div class="media-left media-bottom">
				<img src="img_avatar1.png" class="media-object" style="width:80px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">Media Bottom</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
		<h2>Nested Media Objects</h2>
		<p>Media objects can also be nested (a media object inside a media object):</p><br>
		<div class="media">
			<div class="media-left">
				<img src="img_avatar1.png" class="media-object" style="width:45px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">John Doe <small><i>Posted on February 19, 2016</i></small></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

				<!-- Nested media object -->
				<div class="media">
					<div class="media-left">
						<img src="img_avatar2.png" class="media-object" style="width:45px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">John Doe <small><i>Posted on February 19, 2016</i></small></h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

						<!-- Nested media object -->
						<div class="media">
							<div class="media-left">
								<img src="img_avatar3.png" class="media-object" style="width:45px">
							</div>
							<div class="media-body">
								<h4 class="media-heading">John Doe <small><i>Posted on February 19, 2016</i></small></h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
		<h2>Nested Media Objects</h2>
		<p>Media objects can also be nested (a media object inside a media object):</p><br>
		<div class="media">
			<div class="media-left">
				<img src="img_avatar1.png" class="media-object" style="width:45px">
			</div>
			<div class="media-body">
				<h4 class="media-heading">John Doe <small><i>Posted on February 19, 2016</i></small></h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

				<!-- Nested media object -->
				<div class="media">
					<div class="media-left">
						<img src="img_avatar2.png" class="media-object" style="width:45px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">John Doe <small><i>Posted on February 20, 2016</i></small></h4>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>

						<!-- Nested media object -->
						<div class="media">
							<div class="media-left">
								<img src="img_avatar3.png" class="media-object" style="width:45px">
							</div>
							<div class="media-body">
								<h4 class="media-heading">John Doe <small><i>Posted on February 21, 2016</i></small></h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
							</div>
						</div>

					</div>

					<!-- Nested media object -->
					<div class="media">
						<div class="media-left">
							<img src="img_avatar4.png" class="media-object" style="width:45px">
						</div>
						<div class="media-body">
							<h4 class="media-heading">Jane Doe <small><i>Posted on February 20, 2016</i></small></h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						</div>
					</div>

				</div>
			</div>

			<!-- Nested media object -->
			<div class="media">
				<div class="media-left">
					<img src="img_avatar5.png" class="media-object" style="width:45px">
				</div>
				<div class="media-body">
					<h4 class="media-heading">Jane Doe <small><i>Posted on February 19, 2016</i></small></h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
				</div>
			</div>

		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Carousel Example</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="la.jpg" alt="Los Angeles" style="width:100%;">
				</div>

				<div class="item">
					<img src="chicago.jpg" alt="Chicago" style="width:100%;">
				</div>

				<div class="item">
					<img src="ny.jpg" alt="New york" style="width:100%;">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<h2>Carousel Example</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">

				<div class="item active">
					<img src="la.jpg" alt="Los Angeles" style="width:100%;">
					<div class="carousel-caption">
						<h3>Los Angeles</h3>
						<p>LA is always so much fun!</p>
					</div>
				</div>

				<div class="item">
					<img src="chicago.jpg" alt="Chicago" style="width:100%;">
					<div class="carousel-caption">
						<h3>Chicago</h3>
						<p>Thank you, Chicago!</p>
					</div>
				</div>

				<div class="item">
					<img src="ny.jpg" alt="New York" style="width:100%;">
					<div class="carousel-caption">
						<h3>New York</h3>
						<p>We love the Big Apple!</p>
					</div>
				</div>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<h2>Modal Example</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<p>Some text in the modal.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<h2>Small Modal</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Small Modal</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<p>This is a small modal.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<h2>Large Modal</h2>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Modal Header</h4>
					</div>
					<div class="modal-body">
						<p>This is a large modal.</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<div class="container">
			<h3>Tooltip Example</h3>
			<a href="#" data-toggle="tooltip" title="Hooray!">Hover over me</a>
		</div>

		<script>
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();
		});
		</script>
		<h3>Tooltip Example</h3>
		<p>The data-placement attribute specifies the tooltip position.</p>
		<ul class="list-inline">
			<li><a href="#" data-toggle="tooltip" data-placement="top" title="Hooray!">Top</a></li>
			<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="Hooray!">Bottom</a></li>
			<li><a href="#" data-toggle="tooltip" data-placement="left" title="Hooray!">Left</a></li>
			<li><a href="#" data-toggle="tooltip" data-placement="right" title="Hooray!">Right</a></li>
		</ul>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">
		<div class="container">
			<h3>Popover Example</h3>
			<a href="#" data-toggle="popover" title="Popover Header" data-content="Some content inside the popover">Toggle popover</a>
		</div>

		<script>
		$(document).ready(function(){
				$('[data-toggle="popover"]').popover();
		});
		</script>
		<h3>Popover Example</h3>
		<ul class="list-inline">
			<li><a href="#" title="Header" data-toggle="popover" data-placement="top" data-content="Content">Top</a></li>
			<li><a href="#" title="Header" data-toggle="popover" data-placement="bottom" data-content="Content">Bottom</a></li>
			<li><a href="#" title="Header" data-toggle="popover" data-placement="left" data-content="Content">Left</a></li>
			<li><a href="#" title="Header" data-toggle="popover" data-placement="right" data-content="Content">Right</a></li>
		</ul>
		<h3>Popover Example</h3>
			<a href="#" title="Dismissible popover" data-toggle="popover" data-trigger="focus" data-content="Click anywhere in the document to close this popover">Click me</a>
		<h3>Popover Example</h3>
		<a href="#" title="Header" data-toggle="popover" data-content="Some content">Click Me</a><br>
		<a href="#" title="Header" data-toggle="popover" data-trigger="hover" data-content="Some content">Hover over me</a>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- scrollspy, affix, filter -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container-fluid show">
		<h1>Hello World!</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row">
			<div class="col-xs-9 col-md-7" style="background-color:red;">.col-xs-9 .col-md-7</div>
			<div class="col-xs-3 col-md-5" style="background-color:lavender;">.col-xs-3 .col-md-5</div>
		</div>
		<div class="row">
			<div class="col-xs-6 col-md-10" style="background-color:lavenderblush;">.col-xs-6 .col-md-10</div>
			<div class="col-xs-6 col-md-2" style="background-color:lightgrey;">.col-xs-6 .col-md-2</div>
		</div>
		<div class="row" style="background-color:lightcyan;">
			<div class="col-xs-6">.col-xs-6</div>
			<div class="col-xs-6">.col-xs-6</div>
		</div>
		<h1>Hello World!</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row">
			<div class="col-xs-7 col-sm-6 col-lg-8" style="background-color:red;">.col-xs-7 .col-sm-6 .col-lg-8</div>
			<div class="col-xs-5 col-sm-6 col-lg-4" style="background-color:lavender;">.col-xs-5 .col-sm-6 .col-lg-4</div>
		</div>
		<div class="row">
			<div class="col-xs-6 col-sm-8 col-lg-10" style="background-color:lavenderblush;">.col-xs-6 .col-sm-8 .col-lg-10</div>
			<div class="col-xs-6 col-sm-4 col-lg-2" style="background-color:lightgrey;">.col-xs-6 .col-sm-4 .col-lg-2</div>
		</div>
		<div class="row" style="background-color:lightcyan;">
			<div class="col-xs-6">.col-xs-6</div>
			<div class="col-xs-6">.col-xs-6</div>
		</div>
		<h1>Hello World!</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row">
			<div class="col-sm-8" style="background-color:lavender;">.col-sm-8
				<div class="row">
					<div class="col-sm-6" style="background-color:lightcyan;">.col-sm-6</div>
					<div class="col-sm-6" style="background-color:lightgray;">.col-sm-6</div>
				</div>
			</div>
			<div class="col-sm-4" style="background-color:lavenderblush;">.col-sm-4</div>
		</div>
		<h1>Hello World!</h1>
		<div class="row">
			<div class="col-xs-6 col-sm-3" style="background-color:lavender;">
				Column 1<br>
				Resize the browser window to see the effect. Also try to remove the div clearfix line and see what happens.
			</div>
			<div class="col-xs-6 col-sm-3" style="background-color:lavenderblush;">Column 2</div>
			<!-- Add clearfix for only the required viewport -->
			<div class="clearfix visible-xs"></div>
			<div class="col-xs-6 col-sm-3" style="background-color:lightcyan;">Column 3</div>
			<div class="col-xs-6 col-sm-3" style="background-color:lightgray;">Column 4</div>
		</div>
		<h1>Offsetting Columns</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row" style="background-color:lavender;">
			<div class="col-sm-5 col-md-6" style="background-color:lightgray;">.col-sm-5 .col-md-6</div>
			<div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0" style="background-color:lightcyan;">.col-sm-5 .col-sm-offset-2 .col-md-6 .col-md-offset-0</div>
		</div>
		<h1>Push and Pull</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row">
			<div class="col-sm-4 col-sm-push-8" style="background-color:lavender;">.col-sm-4 .col-sm-push-8</div>
			<div class="col-sm-8 col-sm-pull-4" style="background-color:lavenderblush;">.col-sm-8 .col-sm-pull-4</div>
		</div>
		<h1>Visible</h1>
		<p>Resize the browser window to see the effect.</p>
		<div class="row">
			<div class="col-xs-4 col-sm-4" style="background-color:lightgray;">.col-xs-4 .col-sm-4</div>
			<div class="         col-sm-4 hidden-xs" style="background-color:lavenderblush;">.col-sm-4 .hidden-xs</div>
			<div class="col-xs-8 col-sm-4" style="background-color:lavender;">.col-xs-8 .col-sm-4</div>
		</div>

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container show">

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container show">

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container show">

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container show">

	</div>

	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container show">

	</div>




	<br><br><br><br>
	<br><br><br><br>
	<br><br><br><br>


	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- img-responsive -->
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////// -->
	<div class="container hide">

	</div>


</body>
</html>





