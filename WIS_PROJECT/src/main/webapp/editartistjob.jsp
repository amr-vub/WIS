<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
    <!--Stylesheets-->
    <link href="../themes/css/globalstyle.css" rel="stylesheet" type="text/css"/>
    <link href="../themes/css/artistprofilestyle.css" rel="stylesheet" type="text/css"/>
    <link href="../themes/css/jquery.timepicker.css" rel="stylesheet" type="text/css"/>
    <link href="../themes/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
	
	<!--Script references-->
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
 	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
 	<script type="text/javascript" src="../themes/js/jquery.geocomplete.js"></script>
 	<script type="text/javascript" src="../themes/js/logger.js"></script>
 	
</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="edit.do" method="POST" modelAttribute="artistjob">

		<div class="header">
    		<h1>Artist Profile</h1>
    		<span>Supply us a brief description of your work. Entering an artist alias is optional. You can supply a soundcloud link to embed a player in your artist profile.</span>
    	</div>
    
    	<div class="map_canvas"></div>
		<div class="content">
			<form:input path="Aliase" type="text" name="title" class="input" placeholder="Alias (optional)" spellcheck="false"/>
            <form:textarea path="description" name="description" class="input input-textarea" placeholder="Description"/>
            <form:input path="SondCloudLink" type="text" name="soundcloud-link" class="input" placeholder="Soundcloud link (optional)" spellcheck="false"/>
            <form:input id="geocomplete" path ="ArtLocation.placeName" name="LocationName" type="text" class="input locationName" placeholder="Home Location" spellcheck="false"/>
    		<input id="geo-lat" name="lat" type="hidden" value="" class="input"/>
            <input id="geo-lon" name="lng" type="hidden" value="" class="input"/>
            <input name="query" type="hidden" value="true" class="input">
            <form:input id="spring-lat" path="ArtLocation.lat" name="lat" type="hidden" value="" class="input"/>
            <form:input id="spring-lon" path="ArtLocation.lon" name="lng" type="hidden" value="" class="input"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>
    	<script>    	
        $(function(){
          $("#geocomplete").geocomplete(
        		  {
        			types: ["geocode"],
        		  	details: "form"
        		  });
        });
      	</script>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>