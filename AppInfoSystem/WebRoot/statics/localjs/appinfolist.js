$("#queryCategoryLevel1").change(function(){
	var level1= $(this).val();
	if(level1!="" && level1!=null){
		$.ajax({
			//��������
			type:"GET",
			//�����URL
			url:"categoryLevelList.json",
			data:{pid:level1},
			//���ص���������
			dataType:"json",
			success:function(data){//data:���ص�json����
				$("queryCategoryLevel2").html("");
				var options = "<option value=''>--��ѡ��--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel2").html(options);
			},
			error:function(data){//������ʱ���ܳ���404,505
				alert("���ض�������ʧ��")
			}
		})
	}else{
		$("#queryCategoryLevel2").html();
		var options = "<option value=''>--��ѡ��--</option>"
		$("#queryCategoryLevel2").html(options);
	}
	$("#queryCategoryLevel3").html();
	var options = "<option value=''>--��ѡ��--</option>"
	$("#queryCategoryLevel3").html(options);
});
$("#queryCategoryLevel2").change(function(){
	var queryCategoryLevel2= $(queryCategoryLevel2).val();
	if(queryCategoryLevel2!="" && queryCategoryLevel2!=null){
		$.ajax({
			//��������
			type:"GET",
			//�����URL
			url:"categoryLevelList.json",
			data:{pid:level1},
			//���ص���������
			dataType:"json",
			success:function(data){//data:���ص�json����
				$("queryCategoryLevel3").html("");
				var options = "<option value=\"\">--��ѡ��--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
				}
				$("#queryCategoryLevel3").html(options);
			},
			error:function(data){//������ʱ���ܳ���404,505
				alert("������������ʧ��")
			}
		})
	}else{
		$("#queryCategoryLevel3").html();
		var options = "<option value=\"\">--��ѡ��--</option>"
		$("#queryCategoryLevel3").html(options);
	}
});