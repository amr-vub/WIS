<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
    <!--Stylesheets-->
    <link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css"/>
    <link href="themes/css/artistprofilestyle.css" rel="stylesheet" type="text/css"/>
    <link href="themes/css/jquery.timepicker.css" rel="stylesheet" type="text/css"/>
    <link href="themes/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>

</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="edit.do" method="POST" modelAttribute="artistJob">

		<div class="header">
    		<h1>Artist Profile</h1>
    		<span>Supply us a brief description of your work. Entering an artist alias is optional. You can supply a soundcloud link to embed a player in your artist profile.</span>
    	</div>
    
    	<div class="map_canvas"></div>
		<div class="content">
			<form:input path="Aliase" type="text" name="title" class="input" placeholder="Alias (optional)" spellcheck="false"/>
            <form:textarea path="Description" form="login-form" name="description" cols="35" wrap="soft" class="input input-textarea" placeholder="Description"/>
            <form:input path="SondCloudLink" type="text" name="soundcloud-link" class="input" placeholder="Soundcloud link (optional)" spellcheck="false"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>