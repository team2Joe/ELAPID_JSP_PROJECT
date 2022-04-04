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
	
	if(regExpId2.test(uid.substr(0,1))){
		alert("첫글 자 문자 ")
	}
	if(regExpId.test(uid)){
		alert("dqwd")
		form.id.select()
	}
}
function passwordformcheck(){
	
	var upwd = document.getElementById("inputPassword").value;
	//var regExpId = /^[a-z|A-Z|0-9]/
	var regExpPwd = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
	
	if(!regExpPwd.test(upwd)){
		alert("패스워드 조건 ")
	}

}

//https://rateye.tistory.com/468