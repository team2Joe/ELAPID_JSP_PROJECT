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
function navbtnlinkluggage2() {

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

	location.href = "questionContentView.do";
}
