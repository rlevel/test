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
					alert("加载二级失败");
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
				var options = "<option value=''>--请选择--</option>";
					for(var i=0;i<data.data.length;i++){
						var j ="<option value='"+data.data[i].id+"'>"+data.data[i].categoryName+"</option>";
						$("#querycategoryLevel3").append(j);
					}
			},
			error:function(data){//当访问时可能出现404,505
				alert(data)
			}
		})
	}else{
		$("#querycategoryLevel3").html();
		var options = "<option value=''>--请选择--</option>"
		$("#querycategoryLevel3").html(options);
	}
});
	
	
/*	$("#back").on("click",function(){
		window.location.href="../appInfo/list"
	});
	
	var logoPicPath = $("#logoPicPath").val();
	
	var id = $("#id").val();
	if(logoPicPath==null || logoPicPath==""){
		${"#uploadfile"}.show();
	}else{
		$("#logoFile").append("<p><img src='"+logoPicPath+"?m="+Math.random()+"' width='100px'>")
		+"&nbsp;&nbsp;<a href=\"javascript:onclick=delfile('"+id+"');\">删除</a></p>");
	}*/
	
	/*function delfile(id){
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
	}*/
