<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
    <title>Search</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	 <a href="/WIS_PROJECT/login.do">Login</a> 
	 <a href="/WIS_PROJECT/register.do">Register</a> 
	 <a href="/WIS_PROJECT/edituser.do">Edit User Profile</a> 
	 <a href="/WIS_PROJECT/artistjob/add.do">Add Artist Job</a> 
	 <a href="/WIS_PROJECT/artistjob/1/edit.do">Edit Artist Job 1</a> 
	 <a href="/WIS_PROJECT/event/add.do">Add Event</a> 
	 <a href="/WIS_PROJECT/event/1/edit.do">Edit Event 1</a> 
	 <a href="/WIS_PROJECT/bookerjob/add.do">Add BookerJob</a> 
	 <a href="/WIS_PROJECT/bookerjob/1/edit.do">Edit BookerJob 1</a> 
	 <a href="/WIS_PROJECT/logout.do">Logout</a> 

    <h2>Search Artist</h2>
    <form id="searchFormArtist">
      <label for="searchInput">Search Artist: </label>
      <input type="text" name="searchterm" id="searchterm" />
      <input type="submit" value="start search" /> <br /><br/>
    </form>
    Search results:
    <div id="searchResponseArtist"> </div>
    <br/>
    
    <h2>Search Booker</h2>
    <form id="searchFormBooker">
      <label for="searchInput">Search Booker: </label>
      <input type="text" name="searchterm" id="searchterm" />
      <input type="submit" value="start search" /> <br /><br/>
    </form>
    Search results:
    <div id="searchResponseBooker"> </div>
    <br/>
    
    <h2>Add Ranking (enter ranking)</h2>
    <form id="addRanking">
      <label for="rankInput">Rate Artist </label>
      <input type="text" name="ranking" id=ranking />
      <input type="submit" value="rank artist" /> <br /><br/>
    </form>
    
    new Ranking:
    <div id="newranking"> </div>
    <br/>
    
    <h2>Get user</h2>
    <form id="getuser">
      <label for="getuser">get user </label>

      <input type="submit" value="get user" /> <br /><br/>
    </form>
    
    user:
    <div id="user"> </div>
    <br/>
    
    <h2>Get artistjobs</h2>
    <form id="getartistjob">
      <label for="getartistjob">get aristjobs </label>

      <input type="submit" value="get artistjobs" /> <br /><br/>
    </form>
    
    user:
    <div id="artistjob"> </div>
    <br/>
    
<script type="text/javascript">
   
    $(document).ready(function() {
      
   // Get search results Artists
      $('#searchFormArtist').submit(function(e) {
    	var nbrResults =3;
        var searchtermArtist = searchFormArtist.elements["searchterm"].value;
        $.get('${pageContext.request.contextPath}/search/artist/'+ nbrResults +'/'+ searchtermArtist +'.do', function(results) {
       		results = JSON.parse(results); 
       		$('#searchResponseArtist').text("placename" + results[0].artLocation.placeName);
        });
        e.preventDefault(); // prevent actual form submit
      });
   
   // Get search results Bookers
      $('#searchFormBooker').submit(function(e) {
    	var nbrResults =3;
        var searchtermBooker = searchFormBooker.elements["searchterm"].value;
        $.get('${pageContext.request.contextPath}/search/booker/'+ nbrResults +'/'+ searchtermBooker +'.do', function(results) {
       		results = JSON.parse(results); 
       		$('#searchResponseBooker').text("result1: " + results[0].label + "result2:" + results[1].label + "result2:" + results[2].label);
        });
        e.preventDefault(); // prevent actual form submit
      });
   
   // Get search results Bookers
      $('#addRanking').submit(function(e) {
    	var ranking = addRanking.elements["ranking"].value;
        var artistjobid = 1;
        $.get('${pageContext.request.contextPath}/search/rank/'+ artistjobid +'/'+ ranking +'.do', function(results) {
       		results = JSON.parse(results); 
       		$('#newranking').text("result: " + results);
        });
        e.preventDefault(); // prevent actual form submit
      });
   
   
      $('#getuser').submit(function(e) {
        var artistjobid = 1;
        $.get('${pageContext.request.contextPath}/search/user.do', function(results) {
       		results = JSON.parse(results); 
       		$('#user').text("user: " + results);
        });
        e.preventDefault(); // prevent actual form submit
      });
      
      $('#getartistjob').submit(function(e) {
          $.get('${pageContext.request.contextPath}/search/getartistjobs.do', function(results) {
         		results = JSON.parse(results); 
         		$('#artistjob').text("artistjob: " + results);
          });
          e.preventDefault(); // prevent actual form submit
        });
   
    });
       
  </script>

</body>
</html>



<%-- 
      Searching within radius works the same way but with the following paths 
   		/search/booker/'+nbrResults+'/'+searchterm+'/'+lon+'/'+lat+'/'+radiuskm+'.do'
   		/search/artist/'+nbrResults+'/'+searchterm+'/'+lon+'/'+lat+'/'+radiuskm+'.do'
   		/search/event/'+nbrResults+'/'+searchterm+'/'+lon+'/'+lat+'/'+radiuskm+'.do'
  --%>

