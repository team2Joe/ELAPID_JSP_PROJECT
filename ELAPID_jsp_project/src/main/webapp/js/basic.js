/**
 * 
 */
 

	
function navbtnlinkluggage() {

	location.href = "luggageList.do";
}
function navbtnlinkluggage2() {

	location.href = "luggageList.do";
}

function nnavbtnlinkbackpack() {
	
	location.href = "backpackList.do";
}

function navbtnlinkfunction() {
	
	location.href = "middleFunctionList.do";
}



function qnaregister() {
	
	var form = document.getElementById("qnaWriteForm");
	form.submit();
	
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
