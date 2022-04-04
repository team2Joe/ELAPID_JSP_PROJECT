/**
 * 
 */
 
 function idcheck(){
	
	var uid = document.getElementById("userid").value;
	
	
	location.href = "idCheck.do?uid=" + uid;
	
}

function idformcheck(){
	
	var uid = document.getElementById("userid").value;
	//var regExpId = /^[a-z|A-Z|0-9]/
	var regExpId = /[^a-zA-Z0-9]/g;
	
	
	var regExpId2 = /[^a-zA-Z]/;
	
	if(regExpId2.test(uid)){
		alert("첫글 자 문자 ")
	}
	
	
	if(regExpId.test(uid)){
		alert("dqwd")
		form.id.select()
	}
/*	var i;
	for( i=0;i<uid.legnth;i++){
		if(!regExpId.test(uid.substr(0))){
			alert("문자나 숫자만 넣아라")		
		}
	}
*/	
}