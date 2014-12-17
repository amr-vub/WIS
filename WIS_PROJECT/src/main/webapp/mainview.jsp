<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<!--Stylesheets-->
<link href="themes/css/mainviewstyle.css" rel="stylesheet" type="text/css" />
<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />

<!--Scripts-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script src="http://connect.soundcloud.com/sdk.js"></script>

<script>
var brooklyn = new google.maps.LatLng(40.6743890, -73.9455);
var MY_MAPTYPE_ID = 'custom_style';

function initialize() {
  var featureOpts = [
  {
    stylers: [
      { color: "#141e25" },
      { visibility: "off" }
    ]
  },{
    featureType: "water",
    stylers: [
      { visibility: "on" },
      { color: "#576e7e" }
    ]
  },{
    featureType: "water",
    elementType: "labels",
    stylers: [
      { visibility: "off" }
    ]
  },{
    featureType: "landscape",
    stylers: [
      { visibility: "on" },
      { color: "#dbdbdb" }
    ]
  },{
    featureType: "administrative.country",
    stylers: [
      { visibility: "on" },
      { weight: 0.4 },
      { color: "#010101" }
    ]
  },{
    featureType: "administrative.locality",
    stylers: [
      { visibility: "simplified" },
      { color: "#010101" }
    ]
  },{
    featureType: "road",
    stylers: [
      { visibility: "simplified" },
      { color: "#c4c4c4" }
    ]
  },{
    featureType: "road",
    elementType: "labels.text",
    stylers: [
      { visibility: "on" },
      { weight: 0.3 },
      { color: "#010101" }
    ]
  },{
    featureType: "road",
    elementType: "labels.icon",
    stylers: [
      { visibility: "off" }
    ]
  },{
  }
];

  var mapOptions = {
    zoom: 12,
    center: brooklyn,
    mapTypeControlOptions: {
      mapTypeIds: [google.maps.MapTypeId.ROADMAP, MY_MAPTYPE_ID]
    },
    disableDefaultUI: true,
    mapTypeId: MY_MAPTYPE_ID
  };

  window.map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var styledMapOptions = {
    name: 'Custom Style'
  };

  var customMapType = new google.maps.StyledMapType(featureOpts, styledMapOptions);

  window.map.mapTypes.set(MY_MAPTYPE_ID, customMapType);
}
</script>
</head>



<body>
	<div id="map-canvas"></div>
	<div class="heading"><a href="${pageContext.request.contextPath}/mainview/home.do">ArtScout</a></div>

	<div id="object-view-wrapper">

		<script>
          $(document).ready(function(){
        	  google.maps.event.addDomListener(window, 'load', initialize);
        	  $.get('${pageContext.request.contextPath}/mainview/event/checkViewType.do', function(check) {
              	check = JSON.parse(check);
              	eventView = check;
              	if(check){
                    $("#event-view").show();
                    $("#user-view").hide();
                    $("#search-action").show();
              	}
              	else{
              		 $("#event-view").hide();
              		 $("#search-action").hide();
                     $("#user-view").show();
              	}
              });

       	 	 $.get('${pageContext.request.contextPath}/mainview/event/getEvent.do', function(event) {
 	        	event = JSON.parse(event);
 	        	document.getElementById("event-name").innerHTML = event.title;
 	        	document.getElementById("event-content").innerHTML = event.description;
             });
            $.get('${pageContext.request.contextPath}/mainview/user/getUser.do', function(user) {
	        	user = JSON.parse(user);
	        	document.getElementById("user-name").innerHTML = user.fname + " " + user.lname;
            });
            $.get('${pageContext.request.contextPath}/mainview/user/getArtist.do', function(artists) {
            	artists = JSON.parse(artists);
            	if(typeof artists !== 'undefined' && artists.length > 0){
            		//window.map.setCenter(new google.maps.LatLng(10,10));
    	        	document.getElementById("artist-name").innerHTML = artists[0].aliase;
    	        	document.getElementById("artist-description").innerHTML = artists[0].description;
    	        	$("#artist-add").hide();
    	        	document.getElementById("soundcloud-player").setAttribute("src", artists[0].sondCloudLink);
    	        	
    	        	var eventList = artists[0].events;
    	        	resultHTML = '';
    	        	for(i=0; i<eventList.length; i++){
				           resultHTML += '<div class="calendar-item">';
				           resultHTML += '<div class="title">';
				           //resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/mainview/artist/' + results[i].artUser.userId + '.do ">'+results[i].aliase + '</a>';				         
				           resultHTML += eventList[i].title;
				           resultHTML += '</div>';
				           resultHTML += '<div class="short-description">';
				           resultHTML += eventList[i].eventStartDate;
				           resultHTML += '</div>';
				           resultHTML += '</div>';
				         }    	        	
    	        	document.getElementById("calendar-list").innerHTML = resultHTML;
            	} else{
            		$("#artist-job").hide();
		            $("#artist-view").hide();
            	}
            });
            $.get('${pageContext.request.contextPath}/mainview/user/getBooker.do', function(bookers) {
            	bookers = JSON.parse(bookers);
            	if(typeof bookers !== 'undefined' && bookers.length > 0){
    	        	document.getElementById("booker-name").innerHTML = bookers[0].label;
    	        	document.getElementById("booker-description").innerHTML = bookers[0].description;
    	        	$("#booker-add").hide();
            	}else{
            		$("#booker-job").hide();
		            $("#booker-view").hide();
            	}
            })
            $.get('${pageContext.request.contextPath}/mainview/user/checkSelf.do', function(check) {
            	check = JSON.parse(check);
            	if(check){
            		$("#artist-edit").show();   
            		$("#user-edit").show(); 
            	}
            	else{
            		$("#artist-edit").hide();
            		$("#user-edit").hide(); 
            	}
            });
          });
    	</script>

		<div id="event-view" class="event-view">
			<div class="general-data">
				<div class="edit-button">
					<a href="/WIS_PROJECT/event/1/edit.do"><img class="button"
						src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="user-pic black-white" src="themes/images/ball2.png"
						alt="Error loading event picture." width="80" height="80">
				</div>
				<div id="event-name" class="name panel">Event title</div>
				<div id="event-content" class="info panel">Event description</div>
			</div>
		</div>

		<div id="user-view" class="user-view">
			<div class="general-data">
				<div id="user-edit" class="edit-button">
					<a href="/WIS_PROJECT/edituser.do"><img class="button"
						src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="user-pic black-white" src="themes/images/clark"
						alt="Error loading profile picture." width="80" height="80">
						</div>

				<div id="user-name" class="name panel">Real name</div>
			</div>

			<div class ="job-list">
				<script>
				</script>
				
				<!-- Tab buttons -->
				<img id="calendar" class="job-icon button black-white" src="themes/images/calendaricon.png">
				<a href="/WIS_PROJECT/artistjob/add.do"><img id="artist-add" class="job-icon alt-button black-white" src="themes/images/musicicon.png" /></a> 
				<a href="/WIS_PROJECT/bookerjob/add.do"><img id="booker-add" class="job-icon alt-button black-white" src="themes/images/bookicon.png" /></a>
				<img id="artist-job" class="job-icon button black-white" src="themes/images/musicicon.png" /> 
				<img id="booker-job" class="job-icon button black-white" src="themes/images/bookicon.png" />
				
				<script>
					$(document).ready(function() {
						$("#artist-view").hide();
						$("#booker-view").hide();
						$("#calendar-view").show();

						$("#artist-job").click(function() {
							$("#artist-view").show();
							$("#booker-view").hide();
							$("#calendar-view").hide();
						});
						$("#booker-job").click(function() {
							$("#artist-view").hide();
							$("#booker-view").show();
							$("#calendar-view").hide();
						});
						$("#calendar").click(function() {
							$("#artist-view").hide();
							$("#booker-view").hide();
							$("#calendar-view").show();
						});
					});
				</script>

			</div>
			<div id="artist-view" class="job-data artist-profile">
				<div id="artist-edit" class="edit-button">
					<a href="/WIS_PROJECT/artistjob/edit.do"><img
						class="user-pic button" src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="job-pic" src="themes/images/ball2.png"
						alt="Error loading job picture." width="80" height="80">
				</div>
				<div class="info panel">
					<div id="artist-name" class="name">Artist alias</div>
					<div id="artist-description" class="description">Artist description</div>
					<br />
					<script>
	  					SC.initialize({
	  			 			client_id: 'cffc4fd2927c6518e338ac55965600fb'
	  						});
	  						var track_url = '';
	  						SC.oEmbed(track_url, { auto_play: true }, function(oEmbed) {
	  				  		console.log('oEmbed response: ' + oEmbed);
	  					});
  					</script>
					<iframe id="soundcloud-player" scrolling="no" class="player" frameborder="no"
						src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/174101571&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
				</div>
			</div>

			<div id="booker-view" class="job-data booker-profile">
				<!-- <div class="edit-button">
					<a href="/WIS_PROJECT/artistjob/1/edit.do"><img
						class="user-pic button" src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>-->
				<div class="edit-button">
					<a href="/WIS_PROJECT/event/add.do"><img
						class="button" src="themes/images/bookicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="job-pic" src="themes/images/ball.png"
						alt="Error loading job picture." width="80" height="80">
				</div>
				<div class="info panel">
					<div id="booker-name" class="name">Booker label</div>
					<div id="booker-description" class="description">Booker description</div>
				</div>
			</div>
			
			<div id="calendar-view" class="job-data calendar">
				<div class="info panel">
					<div id="calendar-title" class="name">Calendar</div>
					<div id="calendar-list" class="description">Not subscribed to any events.</div>
				</div>
			</div>
			
		</div>

	</div>

	<div id="search-view-wrapper">

		<form id="search-form" name="search-form" class="search-form panel">
			<div class="search-type"></div>
			<div class="basic">
				
				<select id="search-type" class="input wide">
					<option>Artist</option>
					<option>Booker</option>
					<option>Event</option>
				</select> 
				<select id="search-action" class="input wide">
					<option>Search</option>
					<option>Book</option>
				</select> 
				<input id="search-string" type="text" class="input" placeholder="Who are you looking for?"/> 
				<input type="submit" name="submit" value="Search" class="search-button button"/>


				<!--<input type="submit" name="submit" value="↓" class="advanced-button button" /> -->
			</div>

		</form>
		<div class="results panel">
			<p id="results-insert"></p>
			
			<script>
			document.getElementById("search-type").onchange = function(){
				if(document.getElementById("search-type").value=="Artist"){
					document.getElementById("search-action").disabled = false;
				}else{
					document.getElementById("search-action").value="Search";
					document.getElementById("search-action").disabled = true;
				}
			}
			$(document).ready(function(){

			    $('#search-form').submit(function(e) {
			    	 var searchterm = document.getElementById("search-string").value;
				   	 var searchType = document.getElementById("search-type").value;
				   	 var searchAction = document.getElementById("search-action").value;
				     var nbrResults = 5;
			       
			        //alert(searchType);
			        if(searchType == "Artist"){
				        $.get('${pageContext.request.contextPath}/search/artist/'+ nbrResults +'/'+ searchterm +'.do', function(results) {
				        	results = JSON.parse(results); 
					       	 var resultHTML = "";
					       	if(results.length == 0){
					       	   resultHTML += '<div class="result">';
					           resultHTML += '<div class="title">';
					           resultHTML += 'No matches foud.';
					           resultHTML += '</div>';
					           resultHTML += '</div>';
					       	 }else{
						         for(i=0; i<results.length; i++){
						           resultHTML += '<div class="result">';
						           resultHTML += '<div class="title">';
						           if(searchAction == "Search"){
						        	   resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/mainview/artist/' + results[i].artUser.userId + '.do ">'+results[i].aliase + '</a>';   
						           }else{
						        	   resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/search/subscribeartist/' + results[i].artistJobID + '.do ">'+results[i].aliase + '</a>';   
						           }
						           resultHTML += '</div>';
						           resultHTML += '<div class="short-description">';
						           resultHTML += results[i].artLocation.placeName;
						           resultHTML += '</div>';
						           resultHTML += '</div>';
						         }
					         }
					         document.getElementById("results-insert").innerHTML = resultHTML;
					         window.scrollTo(0,document.body.scrollHeight);
				        });
			        }
			        if(searchType == "Booker"){
				        $.get('${pageContext.request.contextPath}/search/booker/'+ nbrResults +'/'+ searchterm +'.do', function(results) {
				        	results = JSON.parse(results); 
				        	
					       	 var resultHTML = "";
					       	if(results.length == 0){
						       	   resultHTML += '<div class="result">';
						           resultHTML += '<div class="title">';
						           resultHTML += 'No matches foud.';
						           resultHTML += '</div>';
						           resultHTML += '</div>';
						       	 }else{
					         for(i=0; i<results.length; i++){
					           resultHTML += '<div class="result">';
					           resultHTML += '<div class="title">';
					           resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/mainview/booker/' + results[i].bookerUser.userId + '.do ">'+results[i].label + '</a>';
					           resultHTML += '</div>';
					           resultHTML += '<div class="short-description">';
					           resultHTML += results[i].bookerLocation.placeName;
					           resultHTML += '</div>';
					           resultHTML += '</div>';
					         }}
					         document.getElementById("results-insert").innerHTML = resultHTML;
					         window.scrollTo(0,document.body.scrollHeight);
				        });
			        }
			        if(searchType == "Event"){
				        $.get('${pageContext.request.contextPath}/search/event/'+ nbrResults +'/'+ searchterm +'.do', function(results) {
				        	results = JSON.parse(results); 
					       	 var resultHTML = "";
					       	if(results.length == 0){
						       	   resultHTML += '<div class="result">';
						           resultHTML += '<div class="title">';
						           resultHTML += 'No matches foud.';
						           resultHTML += '</div>';
						           resultHTML += '</div>';
						       	 }else{
					         for(i=0; i<results.length; i++){
					           resultHTML += '<div class="result">';
					           resultHTML += '<div class="title">';
					           resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/mainview/event/' + results[i].eventID + '.do ">'+results[i].title + '</a>';
					           resultHTML += '</div>';
					           //resultHTML += '<div class="short-description">';
					           //resultHTML += results[i].bookerLocation.placeName;
					           //resultHTML += '</div>';
					           resultHTML += '</div>';
					         }}
					         document.getElementById("results-insert").innerHTML = resultHTML;
					         window.scrollTo(0,document.body.scrollHeight);
				        });
			        }
			        
			        
			        e.preventDefault(); // prevent actual form submit
			     });
		     });
			</script>
		</div>
	</div>

	<div class="gradient"></div>

</body>
</html>