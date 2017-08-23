	$(function(){
	$("#APKName").bind("blur",function(){
		// ajax ��̨��֤,apkname�Ƿ����
		$.ajax({
			type:"GET",// ��������
			url:"../appInfo/apkexist.json",// �����URL
			data:{APKName:$("#APKName").val},// �������
			dataType:"json",// ajax�ӿ�(����url)���ص���������
			success:function(data){// data:���ص�json����(���ص�����)
				if(data.APKName=="empty"){
					alert("APKName����Ϊ��");
				}else if(data.APKName=="exist"){
					alert("APKName�Ѵ���,��һ��");
				}else if(data.APKName=="noexist"){
					alert("APKName����ʹ��");
				}
			},
			error:function(data){// ������ʱ���ܳ���404,505
				alert("�������!");
			}
		});
	});
	
	$.ajax({
		type:"GET",// ��������
		url:"../appInfo/dataDictionaryList.json",// �����URL
		data:{tcode:"APP_FLATFORM"},// �������
		dataType:"json",// ajax�ӿ�(����url)���ص���������
		success:function(data){// data:���ص�json����(���ص�����)
			$("flatformId").html();
			var options = "<option value=''>--��ѡ��--</option>"
				for(var i=0;i<data.lenth;i++){
					option +="<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>";
				}
				$("#flatformId").html(options);
		},
		error:function(data){// ������ʱ���ܳ���404,505
			alert("����ƽ̨�б�ʧ��!");
		}
	});
	
	$.ajax({
		//��������
		type:"GET",
		//�����URL
		url:"../appInfo/categoryLevelList.json",
		data:{pid:null},
		//���ص���������
		dataType:"json",
		success:function(data){//data:���ص�json����
			$("querycategoryLevel1").html("");
			var options = "<option value=''>--��ѡ��--</option>"
			for(var i=0;i<data.lenth;i++){
				option +="<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>";
			}
			$("#querycategoryLevel1").html(options);
		},
		error:function(data){//������ʱ���ܳ���404,505
			alert("����һ������ʧ��");
		}
	});
	$("#categoryLevel1").change(function(){
		var categoryLevel1= $("#categoryLevel1").val();
		if(categoryLevel1!="" && categoryLevel1!=null){
			$.ajax({
				//��������
				type:"GET",
				//�����URL
				url:"../appInfo/categoryLevelList.json",
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
					alert("���ض�������ʧ��");
				}
			});
		}else{
	//		var options = "<option value=\"\">--��ѡ��--</option>"
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
				url:"../appInfo/categorylevel1List.json",
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
					alert("������������ʧ��");
				}
			});
		}else{
			$("#querycategoryLevel3").html();
			var options = "<option value=''>--��ѡ��--</option>"
			$("#querycategoryLevel3").html(options);
		}
	});
	$("#back").on("click",function(){
		window.location.href="../appInfo/list"
	});
});

