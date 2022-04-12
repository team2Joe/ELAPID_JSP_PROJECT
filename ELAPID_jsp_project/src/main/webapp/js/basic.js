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

