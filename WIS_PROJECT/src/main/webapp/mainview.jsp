<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
   
<!--Stylesheets-->
<link href="themes/css/mainviewstyle.css" rel="stylesheet" type="text/css" />
<link href="themes/css/globalstyle.css" rel="stylesheet" type="text/css" />

<!--Scripts-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
   
<script>
var map;
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

  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var styledMapOptions = {
    name: 'Custom Style'
  };

  var customMapType = new google.maps.StyledMapType(featureOpts, styledMapOptions);

  map.mapTypes.set(MY_MAPTYPE_ID, customMapType);
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>



<body>
<!--<div id="map-canvas"></div>-->
    

<div class="heading">ArtScout</div>

<div id="search-view-wrapper">

	<form name="search-form" class="search-form panel" action="" method="post">
      <div class="search-type">
        <label>
          <select>
              <option selected> Select Box </option>
              <option>Artist</option>
              <option>Booker</option>
          </select>
        </label>
      </div>
    	<div class="basic">
		    <input path="searchString" name="search-string" type="text" class="input" placeholder="Who are you looking for?" />
    	  <input type="submit" name="submit" value="Search" class="search-button button" />
    	  <!--<input type="submit" name="submit" value="↓" class="advanced-button button" /> -->
    	</div>
    	<!--
    	<div class="advanced">
    		<label for="search-type">Area</label>
			<input name="username" type="text" class="input" placeholder="Berlin" id="search-type" />
    	</div>
		-->
	</form>

</div>

<div id="object-view-wrapper">

		<div class="object-view">	
			<div class="general-data">
				<div class="image">
					<img class = "user-pic" src="images/clark" alt="Error loading profile picture." width="80" height="80">
				</div>
				<div class="name panel">
					Chris Clark
				</div>

			</div>
			<div class="job-list">
				<img src="images/ball2.png" alt="Smiley face" width="40" height="40" style="border-radius: 10px;">
				<img src="images/ball2.png" alt="Smiley face" width="40" height="40" style="border-radius: 10px;">
				<img src="images/ball3.png" alt="Smiley face" width="40" height="40" style="border-radius: 10px;">
			</div>
			<div class="job-data">
				<div class ="image">
					<img class = "job-pic" src="images/bg.jpg" alt="Error loading job picture." width="80" height ="80">
				</div>
				<div class="name panel">
					Artist Alias
				</div>
				<div class="info panel">Clark's music is generally considered to fall under the genre of electronic music, although Clark himself finds this label ambiguous and describes Turning Dragon as a "techno album".[18] He often experiments with forms of degradation, distortion and decay associated with different mediums, employing techniques such as re-recording samples and field-recordings in different environments.[19] Describing such processing, he has said "What I tend to do is just jam stuff through as many boxes as I can, until everything sort of bleeds into itself and all its surrounding parts".[20] Clark plays the drums, and some of his material, especially Body Riddle features recordings of his drumming, often heavily re-sampled.[21]

				<script src="http://connect.soundcloud.com/sdk.js"></script>
				<script>
					SC.initialize({
			 			client_id: 'cffc4fd2927c6518e338ac55965600fb'
						});

						var track_url = 'http://soundcloud.com/throttleclark/winter-linn';
						SC.oEmbed(track_url, { auto_play: true }, function(oEmbed) {
				  		console.log('oEmbed response: ' + oEmbed);
					});
				</script>

				<iframe width="100%" height="200" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/174101571&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
				</div>
			</div>
		

		</div>

</div>

<div class="gradient"></div>

</body>
</html>