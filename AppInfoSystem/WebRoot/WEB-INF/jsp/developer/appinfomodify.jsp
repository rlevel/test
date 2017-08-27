<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					修改APP基础信息<small>${devUserSession.devname}</small>应用简介的属性名
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="fa fa-wrench"></i></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Settings 1</a></li>
							<li><a href="#">Settings 2</a></li>
						</ul></li>
					<li><a class="close-link"><i class="fa fa-close"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				<form modelAttribute="appInfos" data-parsley-validate action="${path}/appInfo/appinfomodify" method="post" enctype="multipart/form-data" class="form-horizontal form-label-left">
					<input type="hidden" name="id" id="id" value="${appInfo.id}"/>
					<%-- <f:hidden path="id"/> --%>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">软件名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" name="softwareName" id="softwareName"
								class="form-control col-md-7 col-xs-12" value="${appInfo.softwareName }">
						</div>
					</div>
					<div class="form-group">
						<label  class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">APK名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="APKName" name= "APKName"
								class="form-control col-md-7 col-xs-12" value="${appInfo.APKName}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">支持ROM&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" id="supportROM" name="supportROM"
								class="form-control col-md-7 col-xs-12" value="${appInfo.supportROM}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" id="interfaceLanguage" name="interfaceLanguage"
							for="first-name">界面语言&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name"
								class="form-control col-md-7 col-xs-12" value="${appInfo.interfaceLanguage}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">软件大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="softwareSize" id="softwareSize"
								class="form-control col-md-7 col-xs-12" value="${appInfo.softwareSize }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">下载次数&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="downloads" id="downloads"
								class="form-control col-md-7 col-xs-12" value="${appInfo.downloads }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">所属平台&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<!-- <input type="text" id="first-name" class="form-control col-md-7 col-xs-12"> -->
							<select id="heard" class="form-control" required="required" name="flatformId" id="flatformId">
								<c:if test="${flatFormList!=null}"></c:if>
								<option value="">--请选择--</option>
								<c:forEach items="${flatFormList}" var="dataDic">
									<option
										<c:if test="${dataDic.valueId==appInfo.flatformId}">selected="selected"</c:if>
										value="${dataDic.valueId}">${dataDic.valueName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					
					
					<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="hidden" value="${appInfo.categoryLevel1}" id="cl1"/>
										<select name="querycategoryLevel1" id="querycategoryLevel1"
											class="form-control">
											<c:if test="${categorylevel1List!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${categorylevel1List}" var="appCa">
												<option
													<c:if test="${appCa.id==appInfo.categoryLevel1}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
					<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="hidden" value="${appInfo.categoryLevel2}" id="cl2"/>
										<select name="querycategoryLevel1" id="querycategoryLevel1"
											class="form-control">
											<c:if test="${categorylevel2List!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${categorylevel2List.data}" var="appCa">
												<option
													<c:if test="${appCa.id==appInfo.categoryLevel2}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName}</option>
											</c:forEach>
											
										</select>
									</div>
								</div> 
					<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="hidden" value="${appInfo.categoryLevel3}" id="cl3"/>
										<select name="querycategoryLevel1" id="querycategoryLevel1"
											class="form-control">
											<c:if test="${categorylevel3List==null}">
											<option value="">--请选择--</option>
											</c:if>
											<c:forEach items="${categorylevel3List.data}" var="appCa">
												<option
													<c:if test="${appCa.id==appInfo.categoryLevel3}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div> 
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">APP状态&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<!-- 传数字到后台 value -->
							<input type="hidden" name="status" id="status" value="1"/>${appInfo.statusName}
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">应用简介&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id= "appInfos" name= "appInfos"
								class="form-control col-md-7 col-xs-12" value="${appInfo.appInfos}">${appInfo.appInfos}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">LOGO图片&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" id="logoPicPath" name="logoPicPath" value="${appInfo.logoPicPath}"/>
							<input type="hidden" id="logoLocPath" name="logoLocPath" value="${appInfo.logoLocPath}"/>
							<div id="uploadfile" style="display:none">
							<input type="file" id="attach" name="attach"
								class="form-control col-md-7 col-xs-12"><p>
								<span style="color:red;font-weight:bold;">*注:1.大小不得超过500k,2.图片格式:jsp...4个</span></p>
							</div>
							<div id="logoFile"><img alt="..." src="${appInfo.logoPicPath}"></div>
								${fileUploadError }
						</div>
					</div>
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<button type="button" onclick="history.go(-1)" class="btn btn-dark" >返回</button>
							<button id="back" class="btn btn-primary" type="reset">重填</button>
							<button type="submit" class="btn btn-success">提交</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp"%>

<script
	src="${pageContext.request.contextPath}/statics/localjs/appinfomodify.js"></script>