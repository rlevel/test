function loadCategoryLevel(pid,cl,categoryLevel){
	$.ajax({
		type:"GET",//请求类型
		url:"../appInfo/categoryLevelList.json",//请求的URL
		data:{"pid":pid},
		dataType:"json",//返回的数据类型
		success:function(data){
			$("#"+categoryLevel).html("");
			var options = "<option value=\"\">--请选择--</option>";
			for(var i=0;i<data.data.length;i++){	
				if(cl!=null && cl!=undifined && data.data[i].id==cl){
					var j ="<option selected='selected' value='"+data.data[i].id+"'>"+data.data[i].categoryName+"</option>"
				}else{
					var j ="<option value='"+data.data[i].id+"'>"+data.data[i].categoryName+"</option>"
				}
				
			}
			$("#"+categoryLevel).append(j);
		},
		error:function(data){//当访问时可能出现404,505
			alert("加载分类列表失败");
		}
	});
}



$(function(){
	var cl1 = $("#cl1").val();
	var cl2 = $("#cl2").val();
	var cl3 = $("#cl3").val();
	//一级
	loadCategoryLevel(null,cl1,"categoryLevel1");
	//动态加载二级分类列表
	loadCategoryLevel(cl1,cl2,"categoryLevel2");
	//动态加载三级分类列表
	loadCategoryLevel(cl2,cl3,"categoryLevel3");
	//联动效果,动态加载二级分类列表
	$("#categoryLevel1").change(function(){
		var categoryLevel1=$("#categoryLevel1").val();
		if(categoryLevel1!='' && categoryLevel1!=null){
			loadCategoryLevel(categoryLevel1,cl2,"categoryLevel2");
		}else{
			$("#categoryLevel2").html("");
			var options="<option value=''>--请选择--</option>";
			$("#categoryLevel2").append(options);
		}
		$("#categoryLevel3").html("");
		var options="<option value=''>--请选择--</option>";
		$("#categoryLevel3").append(options);
	});
	//联动效果,动态加载二级分类列表
	$("#categoryLevel2").change(function(){
		var categoryLevel2=$("#categoryLevel2").val();
		if(categoryLevel2!='' && categoryLevel2!=null){
			loadCategoryLevel(categoryLevel2,cl3,"categoryLevel3");
		}else{
			$("#categoryLevel3").html("");
			var options="<option value=''>--请选择--</option>";
			$("#categoryLevel3").append(options);
		}
	});
	$("#back").on("click",function(){
		window.location.href="../appInfo/list"
	});
	
	var logoPicPath = $("#logoPicPath").val();
	var id = $("#id").val();
	if(logoPicPath==null || logoPicPath==""){
		${"#uploadfile"}.show();
	}else{
		$("#logoFile").append("<p><img src='"+logoPicPath+"?m="+Math.random()+"' width='100px'>")
		+"&nbsp;&nbsp;<a href=\"javascript:onclick=delfile('"+id+"');\">删除</a></p>");
	}
	
	function delfile(id){
		$.ajax({
			type:"GET",//请求类型
			url:"../appInfo/delfile.json",//请求的URL
			data:{"id":id,flag:'logo'},
			dataType:"json",//返回的数据类型
			success:function(data){
				if(data.result=="success"){
					alert("删除成功");
					$("#uploadfile").show();
					$("#logoFile").html('');
				}else if(data.result=="failed"){
					alert("删除失败");
				}
			},
			error:function(data){//当访问时可能出现404,505
				alert("请求错误");
			}
				
		});
	}
	
	/*$.ajax({
		type:"GET",//请求类型
		url:"../appInfo/dataDictionaryList.json",//请求的URL
		data:{"tcode":"APP_FLATFORM"},
		dataType:"json",//返回的数据类型
		success:function(data){//data:返回的json对象
			var fid = $("fid").val();
			$("#flatformId").html("");
			var options = "<option value=''>--请选择--</option>"
			for(var i=0;i<data.data.length;i++){
				if(fid!=null && fid!=undifined && data.data[i].valueId==fid){
					var j ="<option selected='selected' value='"+data.data[i].valueId+"'>"
					+data.data[i].valueName+"</option>"
				}else{
					var j ="<option value='"+data.data[i].valueId+"'>"+data.data[i].valueName+"</option>"
				}
				$("#flatformId").append(j);
			}
		},
		error:function(data){//当访问时可能出现404,505
			alert("加载平台列表失败")
		}*/
})