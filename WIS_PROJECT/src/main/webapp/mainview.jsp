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
	<div id="map-canvas"></div>
	<div class="heading">ArtScout</div>

	<div id="object-view-wrapper">

		<script>
          $(document).ready(function(){
            $("#event-view").hide();
            $("#user-view").show();
            });
    	</script>

		<div id="event-view" class="event-view">
			<div class="general-data">
				<div class="edit-button">
					<a href="/WIS_PROJECT/editevent.do"><img class="button"
						src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="user-pic black-white" src="themes/images/ball2.png"
						alt="Error loading event picture." width="80" height="80">
				</div>
				<div class="name panel">Some Event</div>
				<div class="info panel">When you're scheduling a new Meetup
					Event for your Meetup Group's calendar, you'll want to include
					details about what your Meetup Group will be doing so everyone in
					your Meetup Group will know what they can expect when they're
					deciding whether or not to RSVP to that particular event.

					Describing your Meetup is your chance to really convey just how
					great your next Meetup is going to be. Some things you might want
					to include: What will you be doing at your Meetup? What will it be
					like? Will it be an activity? A discussion? A presentation? What's
					an interesting issue we'll discuss? Who's presenting? What will
					they present? Do members need to bring anything? Who should come?
					Are newcomers welcome? Who shouldn't come? What should a newcomer
					expect? Why should people come? How will members benefit from
					coming to your Meetup? How long will the Meetup be? Is it okay to
					arrive late? The more details you can provide, the more vivid the
					image of the event will be in the reader's mind. That mental image
					will entice them to attend. Don't worry: your description doesn't
					need to be long -- just make sure you hit the basics. And as a
					special bonus, your members will also see that you're an awesome,
					excited Organizer because you put in the energy to write such a
					thoughtful and detailed description.</div>
			</div>
		</div>

		<div id="user-view" class="user-view">
			<div class="general-data">
				<div class="edit-button">
					<a href="/WIS_PROJECT/edituser.do"><img class="button"
						src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="user-pic black-white" src="themes/images/clark"
						alt="Error loading profile picture." width="80" height="80">
						</div>

				<div class="name panel">Chris Clark</div>
			</div>
			<div class ="job-list">
				<script>
				</script>
				<!--<img id="calendar" class="job-icon button black-white" src="themes/images/calendaricon.png">-->
				<img id="artist-job" class="job-icon button black-white" src="themes/images/musicicon.png" /> 
				<img id="booker-job" class="job-icon button black-white" src="themes/images/bookicon.png" />
				<script>
		          $(document).ready(function(){
		            $("#artist-view").show();
		            $("#booker-view").hide();
		
		            $("#artist-job").click(function()
		              {
		              $("#artist-view").show();
		              $("#booker-view").hide();
		            });
		          });
		          $(document).ready(function(){
		            $("#booker-job").click(function()
		              {
		              $("#artist-view").hide();
		              $("#booker-view").show();
		            });
		          });
		        </script>

			</div>
			<div id="artist-view" class="job-data artist-profile">
				<div class="edit-button">
					<a href="/WIS_PROJECT/artistjob/1/edit.do"><img
						class="user-pic button" src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="job-pic" src="themes/images/ball2.png"
						alt="Error loading job picture." width="80" height="80">
				</div>
				<div class="info panel">
					<div class="name">Artist Alias</div>
					<div class="description">Clark's music is generally
						considered to fall under the genre of electronic music, although
						Clark himself finds this label ambiguous and describes Turning
						Dragon as a "techno album".[18] He often experiments with forms of
						degradation, distortion and decay associated with different
						mediums, employing techniques such as re-recording samples and
						field-recordings in different environments.[19] Describing such
						processing, he has said "What I tend to do is just jam stuff
						through as many boxes as I can, until everything sort of bleeds
						into itself and all its surrounding parts".[20] Clark plays the
						drums, and some of his material, especially Body Riddle features
						recordings of his drumming, often heavily re-sampled.[21]
						wfijewjiefwpjfe wefpjqwpifjqp wej jqwfepjiqwpfiejqpefwj Clark's
						music is generally considered to fall under the genre of
						electronic music, although Clark himself finds this label
						ambiguous and describes Turning Dragon as a "techno album".[18] He
						often experiments with forms of degradation, distortion and decay
						associated with different mediums, employing techniques such as
						re-recording samples and field-recordings in different
						environments.[19] Describing such processing, he has said "What I
						tend to do is just jam stuff through as many boxes as I can, until
						everything sort of bleeds into itself and all its surrounding
						parts".[20] Clark plays the drums, and some of his material,
						especially Body Riddle features recordings of his drumming, often
						heavily re-sampled.[21] wfijewjiefwpjfe wefpjqwpifjqp wej
						jqwfepjiqwpfiejqpefwj Clark's music is generally considered to
						fall under the genre of electronic music, although Clark himself
						finds this label ambiguous and describes Turning Dragon as a
						"techno album".[18] He often experiments with forms of
						degradation, distortion and decay associated with different
						mediums, employing techniques such as re-recording samples and
						field-recordings in different environments.[19] Describing such
						processing, he has said "What I tend to do is just jam stuff
						through as many boxes as I can, until everything sort of bleeds
						into itself and all its surrounding parts".[20] Clark plays the
						drums, and some of his material, especially Body Riddle features
						recordings of his drumming, often heavily re-sampled.[21]
						wfijewjiefwpjfe wefpjqwpifjqp wej jqwfepjiqwpfiejqpefwj</div>
					<br />
					<script>
	  					SC.initialize({
	  			 			client_id: 'cffc4fd2927c6518e338ac55965600fb'
	  						});
	
	  						var track_url = 'http://soundcloud.com/throttleclark/winter-linn';
	  						SC.oEmbed(track_url, { auto_play: true }, function(oEmbed) {
	  				  		console.log('oEmbed response: ' + oEmbed);
	  					});
  					</script>

					<iframe scrolling="no" class="player" frameborder="no"
						src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/174101571&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
				</div>
			</div>

			<div id="booker-view" class="job-data booker-profile">
				<div class="edit-button">
					<a href="/WIS_PROJECT/artistjob/1/edit.do"><img
						class="user-pic button" src="themes/images/editicon.png"
						alt="Error loading profile picture." width="20" height="20"></a>
				</div>
				<div class="image">
					<img class="job-pic" src="themes/images/ball.png"
						alt="Error loading job picture." width="80" height="80">
				</div>
				<div class="info panel">
					<div class="name">Warp Records</div>
					<div class="description">The first release (WAP1) was by
						Forgemasters (produced by Robert Gordon), whose limited 500 copy
						pressing of "Track With No Name" was financed by an Enterprise
						Allowance grant and distributed in a borrowed car. It set a trend
						for the early releases both in terms of sound, and the use of
						purple sleeves (designed by The Designers Republic). The follow-up
						was Nightmares on Wax's "Dextrous", which sold around 30,000
						copies. This led to greater commercial success; by its fifth
						release the label had its first Top 20 chart entry with LFO and
						their eponymous single, "LFO", which sold 130,000 copies and
						peaked at #12 in the UK Singles Chart in July 1990;[3] by
						coincidence, that same month another Warp act, Tricky Disco,
						reached #14 in the UK chart with another eponymous single, "Tricky
						Disco".[4] Warp's third record, "Testone" (1990) by Sweet Exorcist
						(Richard H. Kirk and Richard Barratt), defined Sheffield's bleep
						techno sound, by making playful use of sampled sounds from Yellow
						Magic Orchestra's "Computer Game" (1978) and the film Close
						Encounters of the Third Kind (1977).[5] The first album released
						was Sweet Exorcist's C.C.E.P. in 1991. In the same year Robert
						Gordon left Warp acrimoniously. Warp went on to release a series
						of singles and albums from 1992 under the Artificial Intelligence
						heading, a series of experimental electronic music releases by
						artists such as Aphex Twin (as Diceman and later Polygon Window),
						Autechre, B12, the Black Dog, Richie Hawtin and Alex Paterson (of
						The Orb). Initially all the album releases were gatefold sleeves
						and coloured vinyl, often with covers by The Designers Republic or
						Phil Wolstenholme. A VHS compilation of digitally animated music
						videos called Motion was released in conjunction with the second
						Artificial Intelligence compilation, and featured an early work by
						director David Slade.</div>

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
				<input id="search-string" type="text" class="input" placeholder="Who are you looking for?"/> 
				<input type="submit" name="submit" value="&#128269;" class="search-button button"/>


				<!--<input type="submit" name="submit" value="↓" class="advanced-button button" /> -->
			</div>

		</form>
		<div class="results panel">
			<p id="results-insert"></p>
			
			<script>
			$(document).ready(function(){

			    $('#search-form').submit(function(e) {
			    	var searchtermArtist = document.getElementById("search-string").value;
				   	 var searchType = document.getElementById("search-type").value;
				     var nbrResults = 5;
			       
			        //alert(searchType);
			        if(searchType == "Artist"){
				        $.get('${pageContext.request.contextPath}/search/artist/'+ nbrResults +'/'+ searchtermArtist +'.do', function(results) {
				        	results = JSON.parse(results); 
					       	 var resultHTML = "";
					         for(i=0; i<results.length; i++){
					           resultHTML += '<div class="result">';
					           resultHTML += '<div class="title">';
					           resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/mainview/user/' + results[i].artUser.userId + '.do ">'+results[i].aliase + '</a>';
					           resultHTML += '</div>';
					           resultHTML += '<div class="short-description">';
					           resultHTML += results[i].artLocation.placeName;
					           resultHTML += '</div>';
					           resultHTML += '</div>';
					         }
					         document.getElementById("results-insert").innerHTML = resultHTML;
				        });
			        }
			        if(searchType == "Booker"){
				        $.get('${pageContext.request.contextPath}/search/booker/'+ nbrResults +'/'+ searchtermArtist +'.do', function(results) {
				        	results = JSON.parse(results); 
				        	
					       	 var resultHTML = "";
					         for(i=0; i<results.length; i++){
					           resultHTML += '<div class="result">';
					           resultHTML += '<div class="title">';
					           resultHTML += '<a href="' + '${pageContext.request.contextPath}' + '/search/user/' + results[i].artUser.userId + '.do ">'+results[i].label + '</a>';
					           resultHTML += '</div>';
					           resultHTML += '<div class="short-description">';
					           resultHTML += results[i].description;
					           resultHTML += '</div>';
					           resultHTML += '</div>';
					         }
					         document.getElementById("results-insert").innerHTML = resultHTML;
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