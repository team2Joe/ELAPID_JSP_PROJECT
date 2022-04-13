/**

 
*/



function checkFile(){
	var form = document.getElementById("uploadform");
	var upload1 = form.fileName1;
	var ext = upload1.value;

	if(ext.length >= 1 && !(ext.substring(ext.length-3) == 'jpg' || ext.substring(ext.length-3) == 'jpeg' || ext.substring(ext.length-3) == 'png' )){
		alert("jpg, jpeg, png 파일만 업로드 가능")
		return false
	}
	form.submit();
}


function init() {
	gapi.load('auth2', function() {
		gapi.auth2.init();
	})
}

function onSignIn(googleUser) {
	init();
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
	id = profile.getId();
	username = profile.getName()
	img = profile.getImageUrl()
	email = profile.getEmail()
	
	document.getElementById("gname").value = username
	document.getElementById("gimg").value = img
	document.getElementById("gemail").value = email
	alert('로그인 완료');
	
	var form = document.getElementById("gform");
	form.submit();
//	post_to_url( "http://localhost:8080/ELAPID_jsp_project/googleLogin.do", {'username': username, 'email': email, 'img': img})
  
}
function signOut() {
	init();
	alert("로그아웃");
	
  var auth2 = gapi.auth2.getAuthInstance();
  auth2.signOut().then(function () {
    console.log('User signed out.');
  });
  
  	window.location.href = 'googleLogout.do';
	
  
}
function post_to_url(path, params, method='post'){
	const form = document.createElement('form');
	form.method = method;
	form.action = path;
	
	for(const key in params){
		if(params.hasOwnProperty(key)) {
			const hiddenField = document.createElement('input');
			hiddenField.type = 'hidden';
			hiddenField.name = 'key';
			hiddenField.value = params[key];
			form.appendChild(hiddenField);
		}
		
	}
	document.body.appendChild(form);
	form.submit();
}


function go() {
    var a = document.insertForm.qc_name.value;
    var f = document.insertForm.pq_title.value;
    var q = document.insertForm.pq_content.value;
    
    var form = document.getElementById("qnaWriteForm");
    //
	var upload1 = form.fileName1;
	var ext = upload1.value;


    
    //
    if (a == "선택") {
        alert("문의 유형을 선택해주세요.");
        document.insertForm.qc_name.focus();
      	return false;
    }else if (f == "") {
        alert("제목을 입력해주세요.");
        document.insertForm.pq_title.focus();
        return;
    }else if (q == "") {
        alert("내용을 입력해주세요.");
        document.insertForm.pq_content.focus();
        return;
    }else{
		if(ext.length >= 1 && !(ext.substring(ext.length-3) == 'jpg' || ext.substring(ext.length-3) == 'jpeg' || ext.substring(ext.length-3) == 'png' )){
		alert("jpg, jpeg, png 파일만 업로드 가능")
		return false
		}
    	form.submit();
    }
    
} 

function test(){
	
		location.href = "test.do";
}
function selectedCartOrder(){
	var form = document.getElementById("cart");
	form.action= "selectedReadInCart.do";
	form.submit();
	
}

// 캐리어 전체 리스트	
function navbtnlinkluggage() {

	location.href = "luggageList.do";
}

// 백팩 전체 리스트	
function navbtnlinkbackpack() {
	
	location.href = "backpackList.do";
}

// 주오기능 전체 리스트	
function navbtnlinkfunction() {
	
	location.href = "middleFunctionList.do";
}


function nullcheck() {
	
}

function qnaregister() {
	
	location.href = "questionList.do";
}
	



function qnawrite() {

	location.href = "questionWriteForm.do";
}
function qnamodify() {
		var form = document.getElementById("contentForm");
	form.submit();
}

function qnadelete() {
	var form = document.getElementById("contentForm");
	form.action = "questionDelete.do";
	form.submit();
//	location.href = "questionDelete.do";
}

