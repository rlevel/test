$("#querycategoryLevel1").change(function(){
	var level1= $(this).val();
	if(level1!="" && level1!=null){
		$.ajax({
			//��������
			type:"GET",
			//�����URL
			url:"categorylevelList.json",
			data:{pid:level1},
			//���ص���������
			dataType:"json",
			success:function(data){//data:���ص�json����
				$("querycategoryLevel2").html("");
				var options = "<option value=''>--��ѡ��--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
				}
				$("#querycategoryLevel2").html(options);
			},
			error:function(data){//������ʱ���ܳ���404,505
				alert("���ض�������ʧ��")
			}
		})
	}else{
		$("#querycategoryLevel2").html();
		var options = "<option value=''>--��ѡ��--</option>"
		$("#querycategoryLevel2").html(options);
	}
	$("#querycategoryLevel3").html();
	var options = "<option value=''>--��ѡ��--</option>"
	$("#querycategoryLevel3").html(options);
});
$("#querycategoryLevel2").change(function(){
	var querycategoryLevel2= $("querycategoryLevel2").val();
	if(querycategoryLevel2!="" && querycategoryLevel2!=null){
		$.ajax({
			//��������
			type:"GET",
			//�����URL
			url:"categorylevelList.json",
			data:{pid:level1},
			//���ص���������
			dataType:"json",
			success:function(data){//data:���ص�json����
				$("querycategoryLevel3").html("");
				var options = "<option value=''>--��ѡ��--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
				}
				$("#querycategoryLevel3").html(options);
			},
			error:function(data){//������ʱ���ܳ���404,505
				alert("������������ʧ��")
			}
		})
	}else{
		$("#querycategoryLevel3").html();
		var options = "<option value=''>--��ѡ��--</option>"
		$("#querycategoryLevel3").html(options);
	}
});