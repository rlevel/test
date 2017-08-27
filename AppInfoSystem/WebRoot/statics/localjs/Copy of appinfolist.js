$("#querycategoryLevel1").change(function(){
	var level1= $(this).val();
	if(level1!="" && level1!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"../appInfo/categoryLevelList.json",
			data:{"pid":level1},
			//返回的数据类型
			dataType:"json",
			success:function(data){//data:返回的json对象
				$("#querycategoryLevel2").html("");
				var options = "<option value=''>--请选择--</option>"
				for(var i=0;i<data.data.length;i++){
					var j ="<option value='"+data.data[i].id+"'>"+data.data[i].categoryName+"</option>";
					$("#querycategoryLevel2").append(j);
				}
			},
			error:function(data){//当访问时可能出现404,505
				alert("加载二级分类失败");
			}
		});
	}else{
		$("#querycategoryLevel2").html();
		var options = "<option value=''>--请选择--</option>"
		$("#querycategoryLevel2").html(options);
	}
	$("#querycategoryLevel3").html();
	var options = "<option value=''>--请选择--</option>"
	$("#querycategoryLevel3").html(options);
});
$("#querycategoryLevel2").change(function(){
	var querycategoryLevel2= $("#querycategoryLevel2").val();
	if(querycategoryLevel2!="" && querycategoryLevel2!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"../appInfo/categoryLevelList.json",
			data:{"pid":querycategoryLevel2},
			//返回的数据类型
			dataType:"json",
			success:function(data){//data:返回的json对象
				$("#querycategoryLevel3").html("");
				var options = "<option value=''>--请选择--</option>"
					for(var i=0;i<data.data.length;i++){
						var j ="<option value='"+data.data[i].id+"'>"+data.data[i].categoryName+"</option>";
						$("#querycategoryLevel3").append(j);
					}
				/*//$("#querycategoryLevel2").html("");
				var options = "<option value=''>--请选择--</option>"
				for(var i=0;i<data.data.length;i++){
					var j ="<option value='"+data.data[i].id+"'>"+data.data[i].categoryname+"</option>";
					$("#querycategoryLevel2").append(j);
				}*/
			},
			error:function(data){//当访问时可能出现404,505
				alert("加载三级分类失败")
			}
		})
	}else{
		$("#querycategoryLevel3").html();
		var options = "<option value=''>--请选择--</option>"
		$("#querycategoryLevel3").html(options);
	}
});

$(".modifyAppinfo").on("click",function(){
	var obj=$(this);
	var status = obj.attr("status");
	if(status=="1" ||status=="3"){//待审核,审核未通过-->修改
		window.location.href="appinfomodify?id="+obj.attr("appinfoid");
	}else{
		alert("APP状态为<"+obj.attr("statusName")+">,不许修改");
	}
});

$(".addVersion").on("click",function(){
	var obj = $(this);
	window.location.href="appversionadd?id="+obj.attr("appinfoid");
});

$(".modifyVersion").on("click",function(){
	var obj = $(this);
	var status = obj.attr("status");
	var versionid = obj.attr("versionid");
	var appinfoid = obj.attr("appinfoid");
	if(status=="1" || !versionid==""){
		if(versionid==null || versionid==""){
			alert("无版本,不能改");
		}else{
			window.location.href="appversionmodify?vid="+versionid+"&aid="+appinfoid;
		}
		
	}else{
		alert("状态为<"+obj.attr("statusname")+">,不能修改");
	}
	
});

$(".viewApp").on("click",function(){
	var obj = $(this);
	var id = +obj.attr("appinfoid");
	var status = obj.attr("status");
	var versionid = obj.attr("versionid");
	var appinfoid = obj.attr("appinfoid");
	window.location.href="appview?id="+id+"&vid="+versionid+"&aid="+appinfoid;
});

$(".deleteApp").on("click",function(){
	var obj = $(this);
	if(confirm("你确定要删除<"+obj.attr("appsoftweraName")+">及其所有版本吗")){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"../appInfo/delapp.json",
			data:{"id":obj.attr("appinfoid")},
			//返回的数据类型
			dataType:"json",
			success:function(data){//data:返回的json对象
				if(data.delResult=="true"){
					alery("删除成功");
					obj.parents("tr").remove();
					/*window.location.href="/appInfo/appInfoList"*/
				}else if(data.delResult=="false"){
					alert("<"+obj.attr("appsoftweraName")+">删除失败");
				}else if(data.delResult=="notexist"){
					alert("<"+obj.attr("appsoftweraName")+">不存在")
				}
			},
			error:function(data){//当访问时可能出现404,505
				alert("对不起")
			}
		});
	}
});

$(document).on("click",".saleSwichOpen,.saleSwichClose",function(){
	var obj = $(this);
	var appId = obj.attr("appinfoid");
	var status = obj.attr("status");
	$.ajax({
		//请求类型
		type:"POST",
		//请求的URL
		url:"../appInfo/sale.json",
		data:{"valueId":appId,"status":status},
		//返回的数据类型
		dataType:"json",
		success:function(data){//data:返回的json对象
			if(data=='success'){
				location.reload(true);
			}
			
		}
	});
});

var saleSwitchAjax = function(appId,obj){
	$.ajax({
		type:"POST",
		url:"../appInfo/sale.json",
		data:{"appId":appId},
		dataType:"json",
		success:function(data){
			if(data.errorCode=='0'){
				if(data.resultMsg=='success'){
					if("open" == obj.attr("saleSwitch")){
						$("#appInfoStatus"+obj.attr("appinfoid")).html("已上架");
						obj.className="saleSwichClose";
						obj.html("下架");
						obj.attr("saleSwitch","close");
						$("#appInfoStatus"+obj.attr("appinfoid")).css({
							'background':'green',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus"+obj.attr("appinfoid")).hide();
						
						$("#appInfoStatus"+obj.attr("appinfoid")).slideDown(300);
					}else if("close" == obj.attr("saleSwitch")){
						$("#appInfoStatus"+obj.attr("appinfoid")).html("已下架");
						obj.className="saleSwichClose";
						obj.html("上架");
						obj.attr("saleSwitch","open");
						$("#appInfoStatus"+obj.attr("appinfoid")).css({
							'background':'red',
							'color':'#fff',
							'padding':'3px',
							'border-radius':'3px'
						});
						$("#appInfoStatus"+obj.attr("appinfoid")).hide();
						
						$("#appInfoStatus"+obj.attr("appinfoid")).slideDown(300);
					}
				}else if(data.resultMsg=='failed'){
					if("open"==obj.attr("saleSwitch")){
						alert("<"+obj.attr("appsoftwarename")+">的<上架操作失败>");
					}else if("close"== obj.attr("saleSwitch")){
						alert("<"+obj.attr("appsoftwarename")+">的<下架操作失败>");
					}
				}
			}else{
				alert("不知道你在做什么,很奇怪");
			}
		},
		error:function(data){
			if("open"==obj.attr("saleSwitch")){
				alert("<"+obj.attr("appsoftwarename")+">的<上架操作失败>");
			}else if("close"== obj.attr("saleSwitch")){
				alert("<"+obj.attr("appsoftwarename")+">的<下架操作失败>");
			}
		}
	});
}