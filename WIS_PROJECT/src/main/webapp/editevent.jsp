<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

    <!--Stylesheets-->
    <link href="css/globalstyle.css" rel="stylesheet" type="text/css" />
    <link href="css/createeventstyle.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="css/jquery.timepicker.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.css" />

    <!--Scripts-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&amp;libraries=places"></script>
    <script type="text/javascript" src="themes/js/jquery.geocomplete.js"></script>
    <script type="text/javascript" src="themes/js/logger.js"></script>
    <script type="text/javascript" src="themes/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="themes/js/jquery.timepicker.js"></script>
    <script type="text/javascript" src="themes/js/jquery.datepair.js"></script>

</head>

<!--Content-->
<body>

<div class="heading">ArtScout</div>
    
<div id="wrapper">
	<form:form name="login-form" class="login-form panel" action="edit.do" method="POST" modelAttribute="event">

		<div class="header">
    		<h1>Event</h1>
    		<span>You can describe your event below, locations can be either geographical locations or names of places (clubs, restaurants, etc.).</span>
    	</div>
    
		<div class="content">
			<form:input path="title" name="event-title" type="text" class="input username" placeholder="Title" spellcheck="false"/>
            <form:textarea path="description" form="login-form" name="description" cols="35" wrap="soft" class="input input-textarea" placeholder="Description"/>
            <p id="datetime-inputs">
                <form:input path="startDate" type="text" class="date start input" placeholder="Date"/>
                <form:input path="startTime" type="text" class="time start input" placeholder="Time"/> to
                <form:input path="endDate" type="text" class="date end input" placeholder="Date"/>
                <form:input path="endTime" type="text" class="time end input" placeholder="Time"/>
            </p>
    		<input id="geocomplete" name="location" type="text" class="input" placeholder="Home Location" spellcheck="false"/>
    	</div>
    
    	<div class="footer">
    		<input type="submit" name="submit" value="Create" class="button" />
    	</div>
    	
    	<script>
  	    $(function(){
	        $("#geocomplete").geocomplete({
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

        var dateTimePair = document.getElementById('datetime-inputs');
        var datepair = new Datepair(dateTimePair);
        </script>

	</form:form>
</div>

<div class="gradient"></div>

</body>
</html>