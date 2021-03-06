	$(function(){
	$("#APKName").bind("blur",function(){
		// ajax 后台验证,apkname是否存在
		$.ajax({
			type:"GET",// 请求类型
			url:"../appInfo/apkexist.json",// 请求的URL
			data:{APKName:$("#APKName").val},// 请求参数
			dataType:"json",// ajax接口(请求url)返回的数据类型
			success:function(data){// data:返回的json对象(返回的数据)
				if(data.APKName=="empty"){
					alert("APKName不能为空");
				}else if(data.APKName=="exist"){
					alert("APKName已存在,换一个");
				}else if(data.APKName=="noexist"){
					alert("APKName可以使用");
				}
			},
			error:function(data){// 当访问时可能出现404,505
				alert("请求错误!");
			}
		});
	});
	
	$.ajax({
		type:"GET",// 请求类型
		url:"../appInfo/dataDictionaryList.json",// 请求的URL
		data:{tcode:"APP_FLATFORM"},// 请求参数
		dataType:"json",// ajax接口(请求url)返回的数据类型
		success:function(data){// data:返回的json对象(返回的数据)
			$("flatformId").html();
			var options = "<option value=''>--请选择--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>";
				}
				$("#flatformId").html(options);
		},
		error:function(data){// 当访问时可能出现404,505
			alert("加载平台列表失败!");
		}
	});
	
	$.ajax({
		//请求类型
		type:"GET",
		//请求的URL
		url:"../appInfo/categoryLevelList.json",
		data:{pid:null},
		//返回的数据类型
		dataType:"json",
		success:function(data){//data:返回的json对象
			$("querycategoryLevel1").html("");
			var options = "<option value=''>--请选择--</option>"
			for(var i=0;i<data.lenth;i++){
				option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
			}
			$("#querycategoryLevel1").html(options);
		},
		error:function(data){//当访问时可能出现404,505
			alert("加载一级分类失败");
		}
	});
	$("#categoryLevel1").change(function(){
		var categoryLevel1= $("#categoryLevel1").val();
		if(categoryLevel1!="" && categoryLevel1!=null){
			$.ajax({
				//请求类型
				type:"GET",
				//请求的URL
				url:"../appInfo/categoryLevelList.json",
				data:{pid:level1},
				//返回的数据类型
				dataType:"json",
				success:function(data){//data:返回的json对象
					$("querycategoryLevel2").html("");
					var options = "<option value=''>--请选择--</option>"
					for(var i=0;i<data.lenth;i++){
						option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
					}
					$("#querycategoryLevel2").html(options);
				},
				error:function(data){//当访问时可能出现404,505
					alert("加载二级分类失败");
				}
			});
		}else{
	//		var options = "<option value=\"\">--请选择--</option>"
			$("#querycategoryLevel2").html();
			var options = "<option value=''>--请选择--</option>"
			$("#querycategoryLevel2").html(options);
		}
		$("#querycategoryLevel3").html();
		var options = "<option value=''>--请选择--</option>"
		$("#querycategoryLevel3").html(options);
	});
	$("#querycategoryLevel2").change(function(){
		var querycategoryLevel2= $("querycategoryLevel2").val();
		if(querycategoryLevel2!="" && querycategoryLevel2!=null){
			$.ajax({
				//请求类型
				type:"GET",
				//请求的URL
				url:"../appInfo/categorylevel1List.json",
				data:{pid:level1},
				//返回的数据类型
				dataType:"json",
				success:function(data){//data:返回的json对象
					$("querycategoryLevel3").html("");
					var options = "<option value=''>--请选择--</option>"
					for(var i=0;i<data.lenth;i++){
						option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
					}
					$("#querycategoryLevel3").html(options);
				},
				error:function(data){//当访问时可能出现404,505
					alert("加载三级分类失败");
				}
			});
		}else{
			$("#querycategoryLevel3").html();
			var options = "<option value=''>--请选择--</option>"
			$("#querycategoryLevel3").html(options);
		}
	});
	$("#back").on("click",function(){
		window.location.href="../appInfo/list"
	});
});

