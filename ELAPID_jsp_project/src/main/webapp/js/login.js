/**
 * 
 */
 
 function idcheck(){
	
	var uid = document.getElementById("userid").value;
	
	
	location.href = "idCheck.do?uid=" + uid;
	
}