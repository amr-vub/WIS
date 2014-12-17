<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
 
    <!--Stylesheets-->
    <link href="../themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
    <link href="../themes/css/bookerprofilestyle.css" rel="stylesheet" type="text/css" />
    <link href="../themes/css/jquery.timepicker.css" rel="stylesheet" type="text/css" />
    <link href="../themes/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css" />

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
	<form:form id="form" name="login-form" class="login-form panel" action="add.do" method="POST" modelAttribute="bookerjob">

		<div class="header">
    		<h1>Booker Profile</h1>
    		<span>Supply us a brief description of your work. Entering a company name is optional.</span>
    	</div>

		<div class="content">
			<form:input path="Label" type="text" name="event-title" class="input" placeholder="Company name (optional)" spellcheck="false"/>
            <form:textarea path="description" name="description" cols="35" wrap="soft" class="input input-textarea" placeholder="Description"/>
    		<form:input id="geocomplete" path ="bookerLocation.placeName" name="LocationName" type="text" class="input locationName" placeholder="Home Location" spellcheck="false"/>
    		<input id="geo-lat" path="bookerLocation.lat" name="lat" type="hidden" value="" class="input"/>
            <input id="geo-lon" path="bookerLocation.lon" name="lng" type="hidden" value="" class="input"/>
            <input name="query" type="hidden" value="true" class="input">
            <form:input id="spring-lat" path="bookerLocation.lat" name="lat" type="hidden" value="" class="input"/>
            <form:input id="spring-lon" path="bookerLocation.lon" name="lng" type="hidden" value="" class="input"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Submit" class="button"/>
    	</div>
    	<script>
    	$('#form').submit(function ()
    			{
    				var lat = $('#geo-lat').val();
    			    $('#spring-lat').val(lat);
    			    var lon = $('#geo-lon').val();
    			    $('#spring-lon').val(lon);
    			    $('#form').submit();
    			    return false;
    			});
    	$(function(){
	        $("#geocomplete").geocomplete({
	        	details: "form",
          		types: ["geocode", "establishment"]});
      	    });
        </script>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>