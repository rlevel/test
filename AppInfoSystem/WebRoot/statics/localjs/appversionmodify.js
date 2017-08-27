function delfile(id){
	$.ajax({
		type:"GET",// 请求类型
		url:"../appInfo/defile.json",// 请求的URL
		data:{"id":id,flag:'apk'},// 请求参数
		dataType:"json",// ajax接口(请求url)返回的数据类型
		success:function(data){// data:返回的json对象(返回的数据)
			success:function(data){
				if(data.result=="success"){
					alert("删除成功");
					$("#uploadfile").show();
					$("#apkFile").html('');
				}else if(data.result=="failed"){
					alert("删除失败");
				}
			},
			error:function(data){//当访问时可能出现404,505
				alert("请求错误");
			}
		}	
	});
}

$(function(){
	$("#back").on("click",function(){
		window.location.href="../appInfo/list"
	});
	var downloadLink = $("#downloadLink").val();
	var id = $("#id").val();
	var apkFileName= $("#apkFileName").val();
	if(downloadLink==null || downloadLink==""){
		$("#uploadfile").show();
	}else{
		$("#apkFile").append("<a href=\"javascript:;\" onclick=\"delfile('"+id+"');\">删除</a></p>");
	}

});