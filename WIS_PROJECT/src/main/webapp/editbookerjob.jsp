<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
    <!--Stylesheets-->
    <link href="../../themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
    <link href="../../themes/css/bookerprofilestyle.css" rel="stylesheet" type="text/css" />
    <link href="../../themes/css/jquery.timepicker.css" rel="stylesheet" type="text/css" />
    <link href="../../themes/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css" />

</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="edit.do" method="POST" modelAttribute="bookerjob">

		<div class="header">
    		<h1>Booker Profile</h1>
    		<span>Supply us a brief description of your work. Entering a company name is optional.</span>
    	</div>

		<div class="content">
			<form:input path="Label" type="text" name="event-title" class="input" placeholder="Company name (optional)" spellcheck="false"/>
            <form:textarea path="Description" form="login-form" name="description" cols="35" wrap="soft" class="input input-textarea" placeholder="Description"/>
    		<form:input path ="bookerLocation.Lon" name="longitude" type="text" class="input longitude" placeholder="longitude" spellcheck="false"/>
    		<form:input path ="bookerLocation.Lat" name="latitude" type="text" class="input latitude" placeholder="latitude" spellcheck="false"/>
    		
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>