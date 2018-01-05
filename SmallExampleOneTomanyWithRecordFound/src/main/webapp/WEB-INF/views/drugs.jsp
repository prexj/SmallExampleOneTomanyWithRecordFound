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
	var dn = $("#drugsname").val();
	var bt = $("#befortotal").val();
$.ajax({
    	   type: "post",
    	   url: "insertDataDrug",
    	   dataType: "json",  
    	   data:{ 
    		   drugsname: dn , 
    		   befortotal: bt , 
    		   },
    	   success: function(response){
    	   		alert(response)
    	  /*  alert('hi');  */
    	    if(response == 1 )
    	    		{
    	    			alert('Inserted Successfully');
    					showAll(); 
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
            url:"showAllDrugs",
            dataType: "json",
            success:function(response)
            { alert('response')
          	  var rows = '';
                $.each( response , function( index, item ) {
        	  	  	rows += '<tr><td>' + item.id + '</td>';
        	  	  	rows += '<td>' + item.drugsname + '</td>';
        	  	  	rows += '<td>' + item.befortotal + '</td>';
        	  	  	rows += '<td>' + item.aftertotal + '</td>';
        	  	  	/* rows += '<td>' + item.section + '</td>';*/
        	  	  	rows += '<td> Edit(' + item.id + ')</td>';
        	  		rows += '<td> Delete(' + item.id +  ')</td>'; 
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
	  <th> Id </th>
	  <th> Drugs Name </th>
	  <th> Befor Total </th>
	  <th> After Total </th>
	  <th> Action </th>
	</tr>
  </thead>
  <tbody id="tblProducts">
  
  </tbody>
</table> 
 <!-- <table>
  <thead>
  	<tr>
	  <th> Id </th>
	  <th> DepartmentName </th>
	</tr>
  </thead>
  <tbody id="tblProducts2">
  
  </tbody> 
</table>-->
	<table> 
		 <tr>
			<td>
				<label>Drugs Name</label>
			</td>
			<td>
				<input id="drugsname" type="text" name="drugsname" value=""/>
			</td>
		</tr> 
		<tr>
			<td>
				<label>Befor Total</label>
			</td>
			<td>
				<input id="befortotal" type="text" name="befortotal" value=""/>
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