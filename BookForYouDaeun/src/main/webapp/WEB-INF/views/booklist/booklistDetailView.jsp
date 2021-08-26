<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- 부트스트랩에서 제공하고 있는 스타일 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <!-- 부트스트랩에서 제공하고 있는 스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <!--awesome icons--> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/69851f8880.js"></script>
    <style>
        @import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
        body{font-family: "Noto Sans KR", sans-serif !important;}
        div{box-sizing: border-box;}
        .wrap{width: 1500px; margin:0 auto;}
        a{text-decoration:none;}
        li{list-style:none;}

        /**글쓰기내용전체area*/
        .content{width:900px; padding:30px; margin:auto;}
        .content_area{margin-top:50px;}

        /*카테고리select*/
        .select_item{font-size:12px; color:#fff; background:rgb(252, 190, 52); padding:2px 5px; border-radius:5px;}
        /*제목전체area*/
        .title-wrap{width:100%; margin:15px 0;}
        /*제목텍스트*/
        .title_item{display:inline-block; font-size:20px; margin-right:15px; margin-bottom:20px;}
        .title_tool a, .title_tool span{font-size:12px; color:#bebebe;}

        /**작성자area*/
        .writer_area{padding:5px 0;}
        .writer_nickname{color:#000 !important; font-size:15px !important; text-decoration:none !important; margin-left:10px;}
        .writer_nickname:hover{color:#000; text-decoration:none;}
        #thumb_img{border-radius: 70%; overflow: hidden;}
        
        /**작성일/조회수*/
        .content_info_date, .content_info_views{color:#9c9c9c !important; font-size:13px !important;}
        .content_info_views{margin-left: 15px;}

        /**에디터area*/
        .content_viewer{width:100%; margin:100px 0; font-size:14px;}
        .viewer_item{overflow:hidden; height:auto;}

        /**책정보area*/
        .book_area{position:relative; width:720px; height:310px; margin:auto; padding:50px; border:1px solid rgb(252, 190, 52); border-radius:10px;}
        .book_area a:hover{color:#000; text-decoration:none;}
        .book_area-wrap{display:flex; height:210px; text-decoration:none;}
        /*책이미지*/
        .book_img{margin-right:40px;}
        #bookImage{width:170px; height:220px;}
        /*책정보내용area*/
        .book_info-wrap{width:75%;}
        .book_title{font-size:18px; font-weight:500; color:rgb(236, 87, 59);}
        .book_content{width:100%; height:100px; padding: 20px 0 90px 0; font-size:13px; color:rgb(90, 90, 90);}
        .book_writer, .book_stars{font-size:13px; color:rgb(90, 90, 90);}

        /**좋아요/스크랩area*/
        .like_area{position:relative; width:100%; height:200px; margin:100px 0; text-align:center;}
        #btn_like, #btn_scrap{
            width: 140px; height: 40px;
            background:#fff; 
            border:none; border-radius: 14px;
            box-shadow:0 2px 5px 0 rgba(104, 104, 104, 0.19);
            font-size:14px;
            line-height: 30px;
            margin: 0 10px;
        }
        #btn_num{color:rgb(236, 87, 59); font-weight:600; font-size:15px;}

        /**독서록area*/
        .booklist_area{margin:0 auto; width: 700px;}
        .writer_nick_info span{font-size: 20px; font-weight:500; margin-left: 10px;}
        .booklist_box{display:flex; margin-top: 30px;}
        .booklist_title{font-size: 16px; font-weight:500;}
        .booklist_content{font-size:13px; padding:10px 0 18px 0;}
        .booklist_date, .booklist_like{font-size:12px; color: #4e4e4e;}
        /*독서록목록box*/
        .booklist_item_l, .booklist_item_r{padding:30px 40px; margin: 0 10px; height: 230px;}
        .booklist_item_l{background:rgb(255, 242, 214); box-shadow:0 2px 5px 0 rgba(233, 233, 233, 0.19);}
        .booklist_item_r{background:#fff; box-shadow:0 2px 5px 0 rgba(94, 94, 94, 0.19);}
        
        /**댓글area*/
        #reply_area{border-top:1px solid #ebebeb; height:1000px; margin-top: 150px;}
        /*댓글갯수*/
        .reply_info{padding:20px 0; font-size:20px; font-weight:500;}
        .reply_count{color:rgb(252, 190, 52); margin-left:20px;}
        /*댓글입력area*/
        .reply-input{border:1px solid #dedede; border-radius:5px; padding:10px;}
        .reply_content{width:760px; height:40px; resize:none; vertical-align:middle; border:none;} 
        textarea::placeholder {font-size:14px;}
        textarea:focus{outline: none;}
        .replyBtn{border:none; border-radius:6px; padding:5px 10px; color:#fff; background:rgb(252, 190, 52);}

        /**li개별댓글area*/
        .comment-wrap{padding-top:10px;}
        .comment_area{display:flex; padding:10px 0; border-top:1px solid #f1f1f1;}
        /*좌측:프로필이미지*/
        #comment_thumb_img{border-radius:70%; overflow:hidden;}
        /*우측:댓글내용*/
        .comment_box{margin-left:15px; font-size:15px;}
        /*닉네임*/
        .comment_nickname{color:#000; font-weight:500;} 
        .comment_nickname:hover{text-decoration:none; color:#000;}
        /*내용*/
        .comment_text_box{margin:10px 0;}
        /*작성일/신고*/
        .comment_info_box, .comment_info_box a{font-size:13px; color:#9c9c9c; margin-top:10px;}
        .comment_info_box a:hover{text-decoration:none;}
        /*작성일*/
        .comment_info_date{margin-right:10px;}
        
        /*답글*/
        .btn_recomment{margin-top:5px; font-size:13px; color:#9c9c9c;} .btn_recomment:hover{color:#9c9c9c; text-decoration:none;}
        .comment_area-recomment{padding-left:46px;}
        /*대댓글입력칸*/
        .recomment_content{width:675px;}
        
        /*댓글페이징*/
        #paging-wrap{width:fit-content; margin:auto; font-size:14px;}
        .page-link, .page-link:hover{color:rgb(252, 190, 52);}
		
		#reportBtn{margin-left:15px; font-size:13px; padding:0; color:#9c9c9c; border:none; background:#fff; text-decoration:none;}
        #reportText{width:100%; height:300px; resize:none; text-aline:center; border-color:#9c9c9c; border-radius:2px; margin-top:10px;}
        .reportR{margin:20px 0;}
        </style>
</head>
<body>

	<jsp:include page="../common/menubar.jsp"/>

    <div class="wrap">

        <div class="content">
            <div class="content_area">
                <!--제목-->
                <div class="title_area">
                    <div class="title-wrap">
                        <span class="title_item">${ bl.blTitle }</span>
                        <span class="title_tool">
                        
                        <c:if test="${ loginUser.memNickname eq bl.blWriter }">
                            <a onclick="postFormSubmit(1);">수정</a>
                            <span>|</span>
                            <a onclick="postFormSubmit(2);">삭제</a>
                        </span>
                    </div>
                </div>
                
	                <form id="postForm" action="" method="post">
	                	<!--글번호-->
	                	<input type="hidden" id="blNo" name="blNo" value="${ bl.blNo }">
	                </form>
                </c:if>
                
                <script>
                	// 수정,삭제 스크립트
                	function postFormSubmit(num){
                		if(num == 1){ // 수정하기 클릭
                			$("#postForm").attr("action", "updateForm.bl").submit();
                		}else{ // 삭제하기 클릭
                			$("#postForm").attr("action", "delete.bl").submit();
                		}
                	}
                </script>

                <!--작성자-->
                <div class="writer_area">
                    <a href="" class="writer_thumb">
                        <img src="resources/adminCommon/images/person.png" width="30" height="30" id="thumb_img">
                    </a>
                    <div class="writer_nick_box" style="display:inline-block;">
                        <div class="writer_nick_info">
                            <a id="blWriter" href="" class="writer_nickname">${ bl.blWriter }</a>
                        </div>
                    </div>
                </div>

                <!--작성일/조회수/신고하기-->
                <div class="content_info_box">
                    <span class="content_info_date">${ bl.blCdate }</span>
                    <span class="content_info_views">조회수 ${ bl.blCount }</span>
                    <a data-toggle="modal" href="#myModal" id="reportBtn">신고</a>
                </div>
                
                <!------- Modal ------->
			    <!-- 신고 클릭 시 뜨는 모달 -->
			    <div class="modal fade" id="myModal"> <!-- 사용자 지정 부분① : id명 -->
			    	<div class="modal-dialog modal-lg">
			    		<div class="modal-content">
			    		<!-- Modal Header -->
			    		<div class="modal-header">
			    			<h4 class="modal-title">신고하기</h4>
			    			<button type="button" class="close" data-dismiss="modal">&times;</button> 
			    		</div>
			    		<!-- Modal Body -->
			    		<div class="modal-body">
			    			<div class="reportTitle">
			    				<span style="color:#000; font-size:15px;">제목 : </span>
			    				<span style="color:#000; font-size:15px;">${ bl.blTitle }</span>
			    			</div>
			    			<div>
			    				<span style="color:#000; font-size:15px;">작성자 : </span>
			    				<span style="color:#000; font-size:15px;">${ bl.blWriter }</span>
			    			</div>
			    			<input type="hidden" name="memNo" value="${ loginUser.memNo }"><!--신고자 회원번호-->
			    			<input type="hidden" name="reportRefNo" value="${ bl.blNo }"><!--신고 글번호-->
			    			<input type="hidden" name="reportLink"><!--신고 글링크-->
			    			<input type="hidden" name="reportType" value="2"><!--게시판 유형-->
					        <div class="reportR">
			    				<div>신고사유</div>
				    				<textarea id="reportText" name="reportContent"></textarea>
				    				<input type="file" id="upfile" class="form-control-file border" name="upfile">
			    			</div>
			    		</div>
			    		<!-- Modal footer -->
			    		<div class="modal-footer">
			    			<button type="button" class="btn btn_choose" id="reportBl">신고하기</button>
			    		</div>
			    		</div>
			    	</div>
			    </div> <!-- 모달끝 -->
				
				<script>
				$(function(){
					
					$('#reportBl').click(function(){
						
						let memNo = ${loginUser.memNo}; // 신고자 회원번호
						let reportContent = $('textarea[name=reportContent]').val(); // 신고내용
						let reportRefNo = $('input[name=reportRefNo]').val(); // 신고글번호
						let reportType = $('input[name=reportType]').val(); // 게시글타입
						
						let url = window.location.href; // 현재 글 링크
						if(url != null){
							$('input[name=reportLink]').val(url);
						}
						let reportLink = $('input[name=reportLink]').val();
						
						let formData = new FormData();
						formData.append("memNo", memNo);
						formData.append("reportContent", reportContent);
						formData.append("reportRefNo", reportRefNo);
						formData.append("reportType", reportType);
						formData.append("reportLink", reportLink);
						let upfile = $("input[name='upfile']");
						let files = upfile[0].files;
						
						for(var i=0; i<files.length; i++){
							formData.append("upfile", files[i]);
							console.log(formData.get("upfile"));
						}
						
			        	if($("#reportContent").val() != ""){
			        		if(formData.append("upfile", files[i]) == null){ // 첨부파일없음
					        	 $.ajax({
					        		url:"insertReport.bl",
					        		type:"post",
					    			data:{
					    				memNo: memNo,
					    				reportContent: reportContent,
					    				reportRefNo: reportRefNo,
					    				reportType: reportType,
					    				reportLink: reportLink
					    			},success:function(result){
					        			if(result == "success"){
					        				alert("독서록을 신고했습니다.");
					        				location.reload();
					        			}else{
					        				alert("독서록을 신고하지 못했습니다.");
					        			}
					        		},error : function(jqXHR, textStatus, errorThrown){ 
					        			console.log(jqXHR); 
					        			console.log(textStatus); 
					        			console.log(errorThrown); 
					        		}
					        	});
			        		}else{ // 있음
			        			$.ajax({
					        		url:"insertReport.bl",
					        		processData: false,
									contentType: false,
					        		type:"post",
					    			data:formData
					    			,success:function(result){
					        			if(result == "success"){
					        				alert("독서록을 신고했습니다.");
					        				location.reload();
					        			}else{
					        				alert("독서록을 신고하지 못했습니다.");
					        			}
					        		},error : function(jqXHR, textStatus, errorThrown){ 
					        			console.log(jqXHR); 
					        			console.log(textStatus); 
					        			console.log(errorThrown); 
					        		}
					        	});
			        		}
			        	}
					})
				
				})
					
					
					
				</script>
				
                <!--에디터글내용area-->
                <div class="article_content_area">
                    <div class="content_viewer">
                        <div class="viewer_item">
                            ${ bl.blContent }
                        </div>
                    </div>
                </div>

                <!--책정보-->
                <div class="book_area">
                    <a href="" class="book_area-wrap">
                        <span class="book_img">
                            <img src="${ bk.introChangeName }" alt="" id="bookImage">
                        </span>
                        <div class="book_info-wrap">
                        	<input type="hidden" id="bkNo" name="bkNo" value="${ bk.bkNo }">
                            <div class="book_title">${ bk.bkTitle }</div>
                            <div class="book_content">${ bk.bkIntroduce }</div>
                            <div class="book_writer">${ bk.writerName }</div>
                            <div class="make_star">
	                    		<input type="hidden" id="blRate" name="blRate" value="${ bl.blRate }">
						        <div class="rating" data-rate="#" id="starRating">
						            <i class="fas fa-star"></i>
						            <i class="fas fa-star"></i>
						            <i class="fas fa-star"></i>
						            <i class="fas fa-star"></i>
						            <i class="fas fa-star"></i>	
						        </div>
					    	</div>
                        </div>
                    </a>
                </div>
                
                <script>
             	// 별점
    			$(function(){
    				var star = $('input[name=blRate]').val();
    				console.log(star);
    				$(' .make_star i ').css( {color:'#dedede'});
                    $(' .make_star i:nth-child(-n+ ' + star + ')').css({color:'rgb(252, 190, 52)'});
    			})
                </script>
				  
                <!--좋아요/스크랩-->
                <div class="like_area">
                    <div class="like-wrap">
                        <button id="btn_like" type="button">
                            	좋아요
                            <span id="btn_num">${ bl.blLike }</span>
                        </button>
                        <button id="btn_scrap" type="button" onclick="location.href='clipping.bl?blNo=${bl.blNo}&memNo=${loginUser.memNo}'">
                            	스크랩
                            <span id="btn_num">${ bl.blScrap }</span>
                        </button>
                    </div>
                </div>
				
                <!--작성자의 독서록area-->
                <div class="booklist_area">
                    <div class="writer_box">
                        <div class="writer_nick_info">
                            <img src="" width="36" height="36" id="thumb_img">
                            <span>바다요정쿠키님의 독서록</span>
                        </div>
                    </div>
                    <div class="booklist_box">
                        <div class="booklist_item_l">
                            <div class="booklist_title">
                                동산에는 사랑의 풀이 돋고 이상의 꽃이 피고 희망의
                            </div>
                            <div class="booklist_content">
                                원대하고 그들은 피가 더운지라 실현에 대한 자신과 용기가 있다 그러므로 그들은 이상의 보배를 ... 
                            </div>
                            <div class="booklist_date">2021.06.30</div>
                            <div class="booklist_like">
                                <img src="" alt="" style="width: 20px; height: 20px;">
                                좋아요<span>333</span>
                            </div>
                        </div>
                        <div class="booklist_item_r">
                            <div class="booklist_title">
                                동산에는 사랑의 풀이 돋고 이상의 꽃이 피고 희망의
                            </div>
                            <div class="booklist_content">
                                원대하고 그들은 피가 더운지라 실현에 대한 자신과 용기가 있다 그러므로 그들은 이상의 보배를 ... 
                            </div>
                            <div class="booklist_date">2021.06.30</div>
                            <div class="booklist_like">
                                <img src="" alt="" style="width: 20px; height: 20px;">
                                좋아요<span>333</span>
                            </div>
                        </div>
                    </div>
                </div>
               
                <!--댓글-->
                <div id="reply_area">
                    <!--댓글갯수-->
                    <div class="reply_info">
                    	댓글<span id="reply_count"></span>
                    </div>
                    <!--댓글작성창-->
                    <div class="reply-input">
                        <div class="reply-text">
                        	<input type="hidden" name="depth" value="1">
        					<input type="hidden" name="reply_refno" value="0">
                            <textarea class="reply_content" id="replyContent" cols="20" rows="1" placeholder="기분 좋은 댓글은 작성자에게 힘이 됩니다 :)"></textarea>
                            <button type="submit" class="replyBtn" onclick="addReply();">등록</button>
                        </div>
                        <div class="reply-img">
                            <img src="" alt="" style="width:20px; height:20px;">
                        </div>
                    </div>
                    <!--댓글목록area-->
                    <ul id="replyArea"><!-- 댓글 ajax결과 --></ul>
                </div>

            </div>
        </div>
    </div>
            
	<script>
		$(function(){
			selectReplyList();
		});
		
		// 댓글 리스트 조회용 ajax
		function selectReplyList(){
			$.ajax({
				url:"rlistAjax.bl",
				data:{blNo:${bl.blNo}},
				success: function(list){
					$("#reply_count").text(list.length);
						
	 				var result = "";
	 				var subResult = "";
	 				
					for(var i in list){
	 					
	 					if(list[i].replyRefNo == 0){ // 참조하는 댓글 == 0
	  					result +=
	  						// 원댓글
	                          '<li id="" class="comment-wrap">' +
	                              '<div class="comment_area">' +
	                                  '<a href="" class="comment_thumb"><img src="" width="36" height="36" id="comment_thumb_img"></a>' +
	                                  '<input type="hidden" id="reNo" name="replyNo" value="' + list[i].replyNo + '">' +
	                                  '<input type="hidden" name="replyRefNo" value ="'+ list[i].replyRefNo +'">' +
	                                  '<div class="comment_box">' +
	                                      '<div class="comment_nick_box"><div class="comment_nick_info"><a id="" href="" class="comment_nickname">' + list[i].memNo + '</a></div></div>' +
	                                      '<div class="comment_text_box"><p class="comment_text_view"><span class="text_comment">' + list[i].replyContent + '</span></p></div>' +
	                                      '<div class="CommentItemImage" style="display:none;"><a href="" role="button" class="comment_image_link"><img alt="" class="image" src="" width="150px" height="150px"></a></div>' +
	                                      '<div class="comment_info_box"><span class="comment_info_date">' + list[i].replyCdate + '</span>' + '<a href="" class="btn_report">신고</a></div>' +
	                                      '<div class="recomment_box"><div id="recomment_report" class="recomment_report"><button id="addRecomment">답글쓰기</button></div></div>' +
	                                  '</div>' +
	                              '</div>' +
	                               
	                              // 대댓글 작성창
	                              '<div class="reply-input" id="popup" style="display:none;">' +
                                  '<div class="reply-text">' +
	                                  '<input type="hidden" name="depth" value="2">' +
	                  				  '<input type="hidden" name="reply_refno" value="' + list[i].replyNo + '">' +
	                                      '<textarea class="reply_content" id="recoContent" cols="20" rows="1" placeholder="기분 좋은 댓글은 작성자에게 힘이 됩니다 :)"></textarea>' +
	                                      '<button type="submit" class="replyBtn" onclick="addReco();">등록</button>' +
	                                      '<button id="removeRecomment">취소</button>' +
                                  '</div>' +
                                  '</div>' +
	                         '</li>' +
	                         '<div class="subReply' + list[i].replyNo + '"></div>'
	 					}	
						$("#replyArea").html(result);
						
						// 대댓글버튼
						$("button[id='addRecomment']").click(function(){
							$('#popup').show();
						});
						$("button[id='removeRecomment']").click(function(){
							$('#popup').hide();
						});
						
						
							
						if(list[i].replyRefNo != 0){ // 참조하는 댓글 != 0
							subResult +=
								// 대댓글
	                            '<li id="" class="comment-wrap comment_area-recomment">' +
	                                '<div class="comment_area">' +
	                                    '<a href="" class="comment_thumb"><img src="" width="36" height="36" id="comment_thumb_img"></a>' +
	                                    '<input type="hidden" id="replyNo" name="replyNo" value="' + list[i].replyNo + '">' +
	                                    '<input type="hidden" name="replyRefNo" value ="'+ list[i].replyRefNo +'">' +
	                                    '<div class="comment_box">' +
	                                        '<div class="comment_nick_box"><div class="comment_nick_info"><a id="" href="" class="comment_nickname">' + list[i].memNo + '</a></div></div>'+
	                                        '<div class="comment_text_box"><p class="comment_text_view"><span class="text_comment">' + list[i].replyContent + '</span></p></div>'+
	                                        '<div class="CommentItemImage" style="display:none;"><a href="" role="button" class="comment_image_link"><img alt="" class="image" src="" width="150px" height="150px"></a></div>' +
	                                        '<div class="comment_info_box"><span class="comment_info_date">' + list[i].replyCdate + '</span><a href="" class="btn_report">신고</a></div>' +
	                                        '<div class="recomment_box"><div id="recomment_report" class="recomment_report"><a href="javascript:void(0)" id="addRecomment" onclick="addBtn();">답글쓰기</a></div></div>' +
	                                    '</div>' +
	                                '</div>' + 
	                            '</li>' +
	                            '<div class="subReply' + list[i].replyNo + '"></div>'
	 					}
						$(".subReply"+list[i].replyRefNo).html(subResult);
	 				}// for문끝
					
				},error: function(jqXHR, textStatus, errorThrown){ 
					console.log(jqXHR); 
					console.log(textStatus); 
					console.log(errorThrown); 
				}
			})
		};
		
		// 댓글 작성용 ajax
		function addReply(){
			if($("#replyContent").val().trim().length != 0){
				$.ajax({
					url:"rinsertAjax.bl",
					dataType:'text',
					data:{
						memNo:${loginUser.memNo},
						refPost:$("input[name=blNo]").val(),
						replyContent:$("#replyContent").val(),
						replyRefNo:$("input[id=replyNo]").val(),
						depth:$("input[name=depth]").val()
					},success: function(status){
						if(status == "success"){
							selectReplyList();
							$("#replyContent").val("");
						}
					},error: function(jqXHR, textStatus, errorThrown){ 
			  			console.log(jqXHR); 
			  			console.log(textStatus); 
			  			console.log(errorThrown); 
			  		}
				})
			}
		};
		
		// 대댓글 작성용 ajax
		function addReco(){
			if($("#recoContent").val().trim().length != 0){
				$.ajax({
					url:"recoinsertAjax.bl",
					dataType:'text',
					data:{
						memNo:${loginUser.memNo},
						refPost:$("input[name=boNo]").val(),
						replyContent:$("#recoContent").val(),
						replyRefNo:$("#reNo").val(),
						depth:$("input[name=depth]").val()
					},success: function(status){ 
						
						if(status == "success"){
							console.log('success:성공');
							selectReplyList();
							$("#replyContent").val("");
						}else if(status == "fail"){
							console.log('success:실패');
						}else{
							console.log('success:데이터오류?' + data);
						}
						
					},error: function(request,status,error){ 
						console.log("code = "+ request.status + " message = " + request.responseText + " error = " + error);
			  		}
				})
			}
		}
	</script>
            




    <jsp:include page="../common/footer.jsp"/>

</body>
</html>