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
    
<script type="text/javascript">
   
    $(document).ready(function() {
      
   // Get search results Artists
      $('#searchFormArtist').submit(function(e) {
    	var nbrResults =3;
        var searchtermArtist = searchFormArtist.elements["searchterm"].value;
        $.get('${pageContext.request.contextPath}/search/artist/'+ nbrResults +'/'+ searchtermArtist +'.do', function(results) {
       		results = JSON.parse(results); 
       		$('#searchResponseArtist').text(results[0].aliase);
        });
        e.preventDefault(); // prevent actual form submit
      });
   
   // Get search results Bookers
      $('#searchFormBooker').submit(function(e) {
    	var nbrResults =3;
        var searchtermBooker = searchFormBooker.elements["searchterm"].value;
        $.get('${pageContext.request.contextPath}/search/artist/'+ nbrResults +'/'+ searchtermBooker +'.do', function(results) {
       		results = JSON.parse(results); 
       		$('#searchResponseBooker').text(results[0].aliase);
        });
        e.preventDefault(); // prevent actual form submit
      });
   
    });
       
  </script>

</body>
</html>