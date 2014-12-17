<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

    <!--Stylesheets-->
    <link href="../themes/css/globalstyle.css" rel="stylesheet" type="text/css" />
    <link href="../themes/css/createeventstyle.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="../themes/css/jquery.timepicker.css" />
    <link rel="stylesheet" type="text/css" href="../themes/css/bootstrap-datepicker.css" />

    <!--Scripts-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
    <script type="text/javascript" src="../themes/js/jquery.geocomplete.js"></script>
    <script type="text/javascript" src="../themes/js/logger.js"></script>
    <script type="text/javascript" src="../themes/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="../themes/js/jquery.timepicker.js"></script>
    <script type="text/javascript" src="../themes/js/jquery.datepair.js"></script>

</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form id="form" name="login-form" class="login-form panel" action="add.do" method="POST" modelAttribute="event">

		<div class="header">
    		<h1>Event</h1>
    		<span>You can describe your event below, locations can be either geographical locations or names of places (clubs, restaurants, etc.).</span>
    	</div>
    
		<div class="content">
			<form:input path="title" name="event-title" type="text" class="input username" placeholder="Title" spellcheck="false"/>
            <form:textarea path="Description" name="description" class="input input-textarea" placeholder="Description"/>
            <p id="datetime-inputs">
            <form:input path="eventStartDate" type="datetime" class="date start input" placeholder="Date"/>
            <form:input path="eventStartTime" type="text" class="time start input" placeholder="Time"/> to
            <form:input path="eventEndDate" type="datetime" class="date end input" placeholder="Date"/>
            <form:input path="eventEndTime" type="text" class="time end input" placeholder="Time"/>
            </p>
            <input id="geo-lat" name="lat" type="hidden" value="" class="input"/>
            <input id="geo-lon" name="lng" type="hidden" value="" class="input"/>
            <input name="query" type="hidden" value="true" class="input">
            <form:input id="spring-lat" path="eventLocation.lat" name="lat" type="hidden" value="" class="input"/>
            <form:input id="spring-lon" path="eventLocation.lon" name="lng" type="hidden" value="" class="input"/>
    		<form:input path="eventLocation.placeName" id="geocomplete" name="location-name" type="text" class="input" placeholder="Home Location" spellcheck="false"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Create" class="button" />
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

            $('#datetime-inputs .time').timepicker({
                'showDuration': true,
                'timeFormat': 'g:ia'
            });

            $('#datetime-inputs .date').datepicker({
                'format': 'm/d/yyyy',
                'autoclose': true
            });

        //var dateTimePair = document.getElementById('datetime-inputs');
        //var datepair = new Datepair(dateTimePair);
        </script>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>