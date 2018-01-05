<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<title>Insert title here</title>
 <script type="text/javascript">
function searchAjaxData(){
	var departmentName = $("#departmentName").val();
	//var country = $("#country").val();
$.ajax({
    	   type: "POST",
    	   url: "searchData",
    	   dataType: "json", 
    	  /*  async: false, */ 
    	   data:{ departmentName: departmentName },
    	   success: function(response){
    		   alert(response);
    		   var rows = '';
               $.each( response , function( index, item ) {
       	  	  	rows += '<tr><td>' + item.departmentId + '</td>';
       	  	  	rows += '<td>' + item.departmentName + '</td></tr>';
       	  		if(item.departmentName == departmentName){
       	  			
       	  			adddataAjaxData(item.departmentId);
       	  		}else{
       	  			
       	  		}
       	  	  });
       	  	  $('#tblProducts2').html(rows);
    	   		
    	   },
    	   error: function(){      
    	    alert('Error while request..');
    	   }
    	  });
}
function insertAjaxData(){
	/* alert('hi'); */
	/* var departmentId = $("#departmentId").val();   */
	var fn = $("#firstname").val();
	var pd = $("#provideDrug").val();
	var dn= $("#drugsname").val();
	/* var section = $("#section").val();
	var departmentName = $("#departmentName").val(); */
	//var country = $("#country").val();
	//searchAjaxData();
$.ajax({
    	   type: "post",
    	   url: "insertDataDoctor",
    	   dataType: "json",  
    	   data:{ 
    		   FirstName: fn , 
    		   ProvideDrug: pd ,
    		   drugsname : dn
    		   },
    	   success: function(response){
    	   		alert(response)
    	  /*  alert('hi');  */
    	    if(response == 1 )
    	    		{
    	    			alert('Inserted Successfully');
    					//showAll(); 
    	    	}
    	   },
    	   error: function(){      
    	    alert('Error while request..');
    	   }
    	  });
}
function showAll(){
    $.ajax({
            type:"GET",
            url:"showAll",
            dataType: "json",
            success:function(response)
            { alert('response')
          	  var rows = '';
                $.each( response , function( index, item ) {
        	  	  	rows += '<tr><td>' + item.id + '</td>';
        	  	  	rows += '<td>' + item.parent.id + '</td>';
        	  	  	rows += '<td>' + item.firstname + '</td>';
        	  	  	rows += '<td>' + item.parent.lastname + '</td>';
        	  	  	/* rows += '<td>' + item.section + '</td>';
        	  	  	rows += '<td>' + item.department.departmentName + '</td>'; */
        	  		/* rows += '<td>' + item.university.country + '</td>'; */
        	  	  });
        	  	  $('#tblProducts').html(rows);
            },
            error:function(xmlHttpRequest, textStatus, errorThrown)
            {
                   alert("error");
            }
    });
}

</script>   
</head>
<body>
<%@ include file ="header.jsp" %>
<button type="button"
onclick="showAll();">
showAll</button>
 <table>
  <thead>
  	<tr>
	  <th> ParentId </th>
	  <th> Id </th>
	  <th> FirstName </th>
	  <th> LastName </th>
	</tr>
  </thead>
  <tbody id="tblProducts">
  
  </tbody>
</table> 
 <table>
  <thead>
  	<tr>
	  <th> Id </th>
	  <th> DepartmentName </th>
	</tr>
  </thead>
  <tbody id="tblProducts2">
  
  </tbody> 
</table> 
 <!-- <form action="addData" method="post">  --> 
	<table>
		 <tr>
			<td>
				<label>FirstName</label>
			</td>
			<td>
				<input id="firstname" type="text" name="FirstName" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<label>DrugName</label>
			</td>
			<td>
				<input id="drugsname" type="text" name="drugsname" value=""/>
			</td>
		</tr> 
		<tr>
			<td>
				<label>provideDrug</label>
			</td>
			<td>
				<input id="provideDrug" type="text" name="provideDrug" value=""/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="submit" onclick="insertAjaxData();" value ="Insert" /><!-- onclick="insertAjaxData();" --> 
			</td>
		</tr>
	</table>
  <!-- </form>   -->
</body>
</html>