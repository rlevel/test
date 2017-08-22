$("#queryCategoryLevel1").change(function(){
	var level1= $(this).val();
	if(level1!="" && level1!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"categoryLevelList.json",
			data:{pid:level1},
			//返回的数据类型
			dataType:"json",
			success:function(data){//data:返回的json对象
				$("queryCategoryLevel2").html("");
				var options = "<option value=''>--请选择--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel2").html(options);
			},
			error:function(data){//当访问时可能出现404,505
				alert("加载二级分类失败")
			}
		})
	}else{
		$("#queryCategoryLevel2").html();
		var options = "<option value=''>--请选择--</option>"
		$("#queryCategoryLevel2").html(options);
	}
	$("#queryCategoryLevel3").html();
	var options = "<option value=''>--请选择--</option>"
	$("#queryCategoryLevel3").html(options);
});
$("#queryCategoryLevel2").change(function(){
	var queryCategoryLevel2= $(queryCategoryLevel2).val();
	if(queryCategoryLevel2!="" && queryCategoryLevel2!=null){
		$.ajax({
			//请求类型
			type:"GET",
			//请求的URL
			url:"categoryLevelList.json",
			data:{pid:level1},
			//返回的数据类型
			dataType:"json",
			success:function(data){//data:返回的json对象
				$("queryCategoryLevel3").html("");
				var options = "<option value=\"\">--请选择--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel3").html(options);
			},
			error:function(data){//当访问时可能出现404,505
				alert("加载三级分类失败")
			}
		})
	}else{
		$("#queryCategoryLevel3").html();
		var options = "<option value=\"\">--请选择--</option>"
		$("#queryCategoryLevel3").html(options);
	}
});