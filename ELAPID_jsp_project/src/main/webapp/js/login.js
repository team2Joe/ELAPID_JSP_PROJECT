/**
 * 
 */

var originpwdcondition = document.getElementById("pwdcondition").className;
var originpwdcondition2 = document.getElementById("pwdcondition2").className;
var originidcondition = document.getElementById("idcondition").className;
var originemailcondition = document.getElementById("emailcondition").className;
var originnamecondition = document.getElementById("namecondition").className;
var originbirthcondition = document.getElementById("birthcondition").className;
var originaddresscondition = document.getElementById("addresscondition").className;

var idcheckresult = 2;

var registervalidate = 0;
var uidvalidate = 0;
var upasswordvalidate = 0;
var upassword2validate = 0;
var unamevalidate = 0;
var utelvalidate = 0;
var uemailvalidate = 0;
var ubirthvalidate = 0;
var uaddressvalidate = 0;
var idduplicatevalidate = 0;


function idduplicatecheck(){
	idformcheck()
	
	if(uidvalidate == 1){
		
	var uid = document.getElementById("userid").value;
	var uname = document.getElementById("inputName").value;
	var uemail = document.getElementById("inputEmail").value;
	var utel = document.getElementById("inputTel").value;
	location.href = "idCheck.do?uid=" + uid + "&uname=" + uname + "&uemail=" + uemail + "&utel=" + utel ;
	}else{
		alert("id 형식을 맞춰주세요 ")
		return false
	}
//	window.open("idCheck.do","아이디 중복 검사","width = 600, height = 400 , left = 800 , top = 300" );	
}
/*
function emailcheck(){
	
	var uemail = document.getElementById("inputEmail").value;
	var uname = document.getElementById("inputName").value;
	var uemail = document.getElementById("inputEmail").value;
	var utel = document.getElementById("inputTel").value;
	
	
	location.href = "emailCheck.do?uemail=" + uemail;
	
}
*/




function userdelete(){
	if (window.confirm("정말로 탈퇴하시겠습니까?")) {
		location.href="profileDelete.do";
}
	
}

function idformcheck(){
	
	var uid = document.getElementById("userid").value;
	//var regExpId = /^[a-z|A-Z|0-9]/
//	var regExpId = /[^a-zA-Z0-9]/g;
	var regExpId = /[^a-zA-Z]/;
//	var regExpId2 = /^[a-z]0-9]{6,12}$/g;
	var regExpId2 = /^(?=.*[a-zA-z])(?=.*[0-9]).{6,12}$/;
//	var regExpId3 = /^[0-9]{5,11}$/g;
	var idcondition = document.getElementById("idcondition");
	
	if(regExpId.test(uid.substr(0,1))){
		//alert("첫글 자 문자 ")
		idcondition.className += " text-danger";
		uidvalidate = 0;
	}else{
		
		if(!regExpId2.test(uid)){
		//alert("첫글 자 문자 ")
		uidvalidate = 0;
		idcondition.className += " text-danger";
		}else{
		
		uidvalidate = 1;
			
		idcondition.className = originidcondition;
		
	}

	}
	document.getElementById("idcheckcomment").value = "";
}

function passwordformcheck(){
	
	var upwd = document.getElementById("inputPassword").value;
	//var regExpId = /^[a-z|A-Z|0-9]/
	var regExpPwd = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
	
	var pwdcondition = document.getElementById("pwdcondition");
	
	if(!regExpPwd.test(upwd)){
		//alert("패스워드 조건 ")
		pwdcondition.className += " text-danger";		
		upasswordvalidate = 0;
		
	}else{
		upasswordvalidate = 1;
		pwdcondition.className = originpwdcondition;
	}
}

function passwordformcheck2(){
	
	var upwd = document.getElementById("inputPassword").value;
	var upwd2 = document.getElementById("inputPassword2").value;
	//var regExpId = /^[a-z|A-Z|0-9]/
	
	var pwdcondition2 = document.getElementById("pwdcondition2");
	
	if(upwd != upwd2){
		pwdcondition2.className += " text-danger";		
		upassword2validate = 0;
	}else{
		pwdcondition2.className = originpwdcondition2;
		upassword2validate = 1;
	}
}
function nameformcheck(){
	
	var uname = document.getElementById("inputName").value;
	var regExpName = /^[가-힣]*$/
	
	var namecondition = document.getElementById("namecondition");
	
	if(!regExpName.test(uname)){
		//alert("패스워드 조건 ")
		namecondition.className += " text-danger";	
		unamevalidate = 0;	
		
	}else{
		unamevalidate = 1;
		namecondition.className = "col-sm-6";
	}
}

function emailformcheck(){
	
	var uemail = document.getElementById("inputEmail").value;
	var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
	var emailcondition = document.getElementById("emailcondition");
	
	if(!regExpEmail.test(uemail)){
		//alert("패스워드 조건 ")
		emailcondition.className += " text-danger";		
		uemailvalidate = 0;
		
	}else{
		uemailvalidate = 1;
		emailcondition.className = "col-sm-6 ";
	}
}
function telformcheck(){
	
	var utel = document.getElementById("inputTel").value;
	var regExpEmail = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
	
	var telcondition = document.getElementById("telcondition");
	
	if(!regExpEmail.test(utel)){
		//alert("패스워드 조건 ")
		telcondition.className += " text-danger";		
		utelvalidate = 0;
		
	}else{
		utelvalidate = 1;
		telcondition.className = "col-sm-6 ";
	}
}
function birthformcheck(){
	
	//var ubirtyear = document.getElementById("inputBirthYear").value;
	var ubirthmonth = document.getElementById("inputBirthMonth").value;
	var ubirthday = document.getElementById("inputBirthDay").value;
	var regExpBirthMonth = /^(0[0-9]|1[0-2])$/;
	var regExpBirthDay = /^(0[1-9]|[1-2][0-9]|3[0-1])$/;
	
	var birthcondition = document.getElementById("birthcondition");
	
	if(!regExpBirthMonth.test(ubirthmonth) || !regExpBirthDay.test(ubirthday) ){
		//alert("패스워드 조건 ")
		birthcondition.className += " text-danger";		
		ubirthvalidate = 0;
		
	}else{
		ubirthvalidate = 1;
		birthcondition.className = "col-sm-6 ";
	}
}
function modbirthformcheck(){
	
	var ubirthyear = document.getElementById("inputBirthYear").value;
	var ubirthmonth = document.getElementById("inputBirthMonth").value;
	var ubirthday = document.getElementById("inputBirthDay").value;
	var regExpBirthMonth = /^(0[0-9]|1[0-2])$/;
	var regExpBirthDay = /^(0[1-9]|[1-2][0-9]|3[0-1])$/;
	var regExpBirthYear = /^(19[0-9][0-9]|20\d{2})$/;
	
	var birthcondition = document.getElementById("birthcondition");
	
	if(!regExpBirthMonth.test(ubirthmonth) || !regExpBirthDay.test(ubirthday) || !regExpBirthYear.test(ubirthyear) ){
		//alert("패스워드 조건 ")
		birthcondition.className += " text-danger";		
		ubirthvalidate = 0;
		
	}else{
		ubirthvalidate = 1;
		birthcondition.className = "col-sm-6 ";
	}
}
function addressformcheck(){
	
	//var ubirtyear = document.getElementById("inputBirthYear").value;
	var addrDetail = document.getElementById("addrDetail").value;
	var zipNo = document.getElementById("zipNo").value;
	
	var addresscondition = document.getElementById("birthcondition");
	
	if(addrDetail == "" || zipNo == "" ){
		//alert("패스워드 조건 ")
		addresscondition.className += " text-danger";		
		uaddressvalidate = 0;
		
	}else{
		uaddressvalidate = 1;
		addresscondition.className = originaddresscondition;
	}
}

function registercheck(){
	addressformcheck();
	passwordformcheck()
	passwordformcheck2()
	nameformcheck()
	emailformcheck()
	telformcheck()
	birthformcheck()
	addressformcheck()
	
	var form = document.getElementById("registerForm");
	var idcheck = document.getElementById("idcheckresult").value;
	var idcheckcomment = document.getElementById("idcheckcomment").value;
	
	if(idcheckcomment == ""){
		alert("id 중복 체크를 해주세요")
		
	}else if(idcheck >= 1 ){
		alert("아이디 중복입니다")
	}else if(upasswordvalidate == 0){
		alert("비밀번호 형식을 확인해주세요")
		
	}else if(upassword2validate == 0){
		alert("비밀번호가 동일한지 확인해주세요")
		
	}else if(unamevalidate == 0 || document.getElementById("inputName").value == ""){
		alert("이름 형식을 확인해주세요")
		
	}else if(utelvalidate == 0){
		alert("휴대폰 형식을 확인해주세요")
		
	}else if(uemailvalidate == 0){
		alert("이메일 형식을 확인해주세요")
		
	}else if(ubirthvalidate == 0){
		alert("생년월일 형식을 확인해주세요")
		
	}else if(uaddressvalidate == 0){
		alert("주소 형식을 확인해주세요")
		
	}else{
		registervalidate = 1;
		form.submit();
		
	}
}
function modifycheck(){
	passwordformcheck()
	passwordformcheck2()
	emailformcheck()
	telformcheck()
	birthformcheck()
	
	var form = document.getElementById("usermodifyForm");
	
	if(upasswordvalidate == 0){
		alert("비밀번호 형식을 확인해주세요")
		
	}else if(upassword2validate == 0){
		alert("비밀번호가 동일한지 확인해주세요")
		
	}else if(utelvalidate == 0){
		alert("휴대폰 형식을 확인해주세요")
		
	}else if(uemailvalidate == 0){
		alert("이메일 형식을 확인해주세요")
		
	}else if(ubirthvalidate == 0){
		alert("생년월일 형식을 확인해주세요")
		
	}else{
		form.submit();
		
	}
}

function registerAddCheck(){
	
	nameformcheck();
	telformcheck();
	
	
	var form = document.getElementById("registerAddForm");
	var addrDetail = document.getElementById("addrDetail").value;
	
	if(unamevalidate == 0 || document.getElementById("inputName").value == ""){
		alert("이름 형식을 확인해주세요")
		
	}else if(utelvalidate == 0){
		alert("휴대폰 형식을 확인해주세요")
		
	}else if(addrDetail == ""){
		alert("주소를 입력해주세요")
		
	}else{
		form.submit();

		
	}	
	
}

function registerModifyCheck(){
	
	nameformcheck();
	telformcheck();
	
	
	var form = document.getElementById("registerModifyForm");
	var addrDetail = document.getElementById("addrDetail").value;
	
	if(unamevalidate == 0 || document.getElementById("inputName").value == ""){
		alert("이름 형식을 확인해주세요")
		
	}else if(utelvalidate == 0){
		alert("휴대폰 형식을 확인해주세요")
		
	}else if(addrDetail == ""){
		alert("주소를 입력해주세요")
		
	}else{
		form.submit();

		
	}	
	
}
	
	/*
registervalidate
uidvalidate
upasswordvalidate
upassword2validate
unamevalidate 
utelvalidate 
uemailvalidate 
ubirthvalidate
	*/
	//var ubirtyear = document.getElementById("inputBirthYear").value;



//https://rateye.tistory.com/468