function delfile(id){
	$.ajax({
		type:"GET",// ��������
		url:"../appInfo/defile.json",// �����URL
		data:{"id":id,flag:'apk'},// �������
		dataType:"json",// ajax�ӿ�(����url)���ص���������
		success:function(data){// data:���ص�json����(���ص�����)
			success:function(data){
				if(data.result=="success"){
					alert("ɾ���ɹ�");
					$("#uploadfile").show();
					$("#apkFile").html('');
				}else if(data.result=="failed"){
					alert("ɾ��ʧ��");
				}
			},
			error:function(data){//������ʱ���ܳ���404,505
				alert("�������");
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
		$("#apkFile").append("<a href=\"javascript:;\" onclick=\"delfile('"+id+"');\">ɾ��</a></p>");
	}

});