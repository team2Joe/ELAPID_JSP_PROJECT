/**
 * 
 */
 
function go() {
    var a = document.insertForm.qc_name.value;
    var f = document.insertForm.pq_title.value;
    var q = document.insertForm.pq_content.value;
    
    var form = document.getElementById("qnaWriteForm");
    
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
	
function navbtnlinkluggage() {

	location.href = "luggageList.do";
}

function navbtnlinkbackpack() {
	
	location.href = "backpackList.do";
}

function nnavbtnlinkfunction() {
	
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

