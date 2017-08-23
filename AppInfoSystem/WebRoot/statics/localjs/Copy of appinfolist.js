$("#querycategoryLevel1").change(function(){
	var level1= $(this).val();
	if(level1!="" && level1!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"categorylevelList.json",
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
				alert("加载二级分类失败")
			}
		})
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
	var querycategoryLevel2= $("querycategoryLevel2").val();
	if(querycategoryLevel2!="" && querycategoryLevel2!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"categorylevelList.json",
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
				alert("加载三级分类失败")
			}
		})
	}else{
		$("#querycategoryLevel3").html();
		var options = "<option value=''>--请选择--</option>"
		$("#querycategoryLevel3").html(options);
	}
});