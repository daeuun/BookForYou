<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
 .body1{
   width:1200px;    
   margin:auto;   
   }
.que{
	padding: 6px 12px;
    width: 300px;
    height: 170px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    resize: none;
    color: rgb(94, 94, 94); 
    font-size: 20px;
    margin: 20px;  
}
.quetitle{
	font-weight:bold;
	font-size:36px;
	margin: 160px 0 80px 100px;
}
.quelist{
	width:1200px;	
	text-align:center;	
	margin-left:100px;
}

.updateFAQList{
   	padding: 12px 9px;   
    background: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color:rgb(224, 224, 224); 
    box-sizing: border-box;  
    margin: 100px 0 0 1000px;
    text-type:bold;
 
}
.queTypeList{
	color: rgb(94, 94, 94); 
	font-size: 30px; 
	text-align: center; 
	line-height: 1.9em;
	padding: 6px 12px;
    width: 1000px;
    height:80px;   
    background: #fff;
    border: 1px solid #ccc;
    border-radius: 4px;  
    box-sizing: border-box;
    resize: none;
    margin-top:40px;
}


span{
display:inline-block;
}

.ListButton{		
		font-size: 19px; 
		color: rgb(64, 64, 64); 
		text-align: center; 
		line-height: 3em;
		border-radius: 4px; 
		background-color: rgb(252, 190, 52);
		width:120px;
		margin-top:300px;
		margin-left:550px;
		margin-bottom:200px;
	}
	.queTypeList>textarea{
	color: rgb(94, 94, 94); 	
    border: none;    
    font-size: 30px;
	width:800px;
	height:70px;
	resize:none;
	text-align:center;

	}
</style>

</head>
<body>
<jsp:include page="../menubar.jsp"/>
<div class="body1">
<div class="quetitle">문의 유형별 도움말</div>
<div class="quelist">
<div class="queTypeList" >결제/환불  <input type="checkbox"checked></div>
<div class="queTypeList" >쇼핑몰이용문의 <input type="checkbox"checked> </div>
<div class="queTypeList">사용자 계정 문의 <input type="checkbox"checked></div>
<div id="addList"></div>
<div class="queTypeList" id="add">목록 추가+</div>
</div>
<div class="updatebutton">
<span class="updateFAQList"><b>목록수정</b></span>
</div>


<div class="ListButton">목록으로</div>
</div>
<jsp:include page="../footer.jsp"/>
<script>
        $(function(){
            $("#add").click(function(){
           		var add=$("<div class='queTypeList'><textarea></textarea><input type='checkbox'checked></div>"); 
            		
               $("#addList").append(add);
            })
        })
    </script>
</body>
</html>