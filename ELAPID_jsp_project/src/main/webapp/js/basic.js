/**
 * 
 */
 
 
 
 
function test(){
	
		location.href = "test.do";
}
function selectedCartOrder(){
	var form = document.getElementById("cart");
	form.action= "selectedReadInCart.do";
	form.submit();
	
}
	
function navbtnlinkluggage() {

	location.href = "luggageList.do";
}

function navbtnlinkbackpack() {
	
	location.href = "backpackList.do";
}

function navbtnlinkfunction() {
	
	location.href = "middleFunctionList.do";
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

