/**

 
 var GoogleAuth; // Google Auth object.
function initClient() {
  gapi.client.init({
      'apiKey': 'AIzaSyCIBppIVpF54yqf14obcIwSXFNpzO91pSE',
      'clientId': '246093648725-rl5r5kcmpm4vh48r4k1l2rferndnjohm.apps.googleusercontent.com',
      'scope': 'https://www.googleapis.com/auth/drive.metadata.readonly',
      'discoveryDocs': ['https://www.googleapis.com/discovery/v1/apis/drive/v3/rest']
  }).then(function () {
      GoogleAuth = gapi.auth2.getAuthInstance();

      // Listen for sign-in state changes.
      GoogleAuth.isSignedIn.listen(updateSigninStatus);
  });
}
function init() {
	  gapi.load('auth2', function() {
		
	  });
	}


function onSignIn() {

		initClient();
		
	var profile = gapi.auth2.getAuthInstance().currentUser.get().getBasicProfile();
		id = profile.getId();
		username = profile.getName()
		img = profile.getImageUrl()
		email = profile.getEmail()
		alert('로그인 완료');
		
		post_to_url( "http://localhost:8080/ELAPID_jsp_project/main.do", {'username': username, 'email': email, 'img': img})
}
*/

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

