function movePageWirte(){
	location.href = "boardWrite.jsp";
}

function movePageWirte_DL(){
	location.href = "downloadWrite.jsp";
}

function movePageIndex(){
	location.href = "/";
}

function movePageBoardList(){
	location.href = "http://localhost/view/board/boardList.jsp";
}
function movePageBoardList_DL(){
	location.href = "http://localhost/view/board/downloadList.jsp";
}

function movePageReply(article_id, title){
	location.href = "boardReply.jsp?article_id=" + article_id + "&title=" + title + "";
}