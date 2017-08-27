<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<div class="x_title">
					<h2>
						查看并审核APP基础信息<small>${userSession.username}</small>
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

				<h2>
					APP基础信息<small>${userSession.username}</small>
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
				<form modelAttribute="appInfos" data-parsley-validate
					action="${path}/check/appinfocheck" method="post"
					enctype="multipart/form-data"
					class="form-horizontal form-label-left">
					<input type="hidden" name="id" id="id" value="${appInfo.id}" />
					<%-- <f:hidden path="id"/> --%>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">软件名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" name="softwareName" id="softwareName"
								readonly="readonly" class="form-control col-md-7 col-xs-12"
								value="${appInfo.softwareName }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">APK名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="APKName" name="APKName"
								readonly="readonly" class="form-control col-md-7 col-xs-12"
								value="${appInfo.APKName}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">支持ROM&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" id="supportROM"
								name="supportROM" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.supportROM}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							id="interfaceLanguage" name="interfaceLanguage" for="first-name">界面语言&nbsp;<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.interfaceLanguage }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">软件大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="softwareSize"
								id="softwareSize" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.softwareSize }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">下载次数&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="downloads"
								id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.downloads }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">所属平台&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" name="downloads"
								id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.flatformName}">
						</div>
					</div>



					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12">所属分类</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" name="downloads"
								id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="${appInfo.categorylevel1Name}-->${appInfo.categorylevel2Name}-->${appInfo.categorylevel3Name}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">APP状态&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<!-- 传数字到后台 value -->
							<input type="hidden" name="status" id="status" value="1" />待审核
							<!-- <input type="text" id="first-name" class="form-control col-md-7 col-xs-12"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">应用简介&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id="appInfo" name="appInfo" readonly="readonly"
								class="form-control col-md-7 col-xs-12"
								value="">${appInfo.appInfos}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">LOGO图片&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" id="logoPicPath" name="logoPicPath"
								value="${appInfo.logoPicPath}" /> <input type="hidden"
								id="logoLocPath" name="logoLocPath"
								value="${appInfo.logoLocPath}" />
							<div id="uploadfile" style="display:none">
								<input type="file" id="attach" name="attach"
									class="form-control col-md-7 col-xs-12">
								<p>
									<span style="color:red;font-weight:bold;">*注:1.大小不得超过500k,2.图片格式:jsp...4个</span>
								</p>
							</div>
							<div id="logoFile"><img alt="..." src="${appInfo.logoPicPath}"></div>
							${fileUploadError }
						</div>
					</div>
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<button id="statuss" name="statuss" value="2"
								class="btn btn-success" type="submit">审核通过</button>
							<button id="statuss" name="statuss" value="3"
								class="btn btn-success" type="submit">审核不通过</button>
							<button id="back" class="btn btn-primary" type="button">返回</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>最新版本信息</h2>
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
				<form id="demo-form2" data-parsley-validate
					action="${path}/appInfo/addversionmodifysave" method="post"
					enctype="multipart/form-data"
					class="form-horizontal form-label-left">
					<input type="hidden" id="appId" name="appId"
						value="${appVersion.appId}"> <input type="hidden" id="id"
						name="id" value="${appVersion.id}">

					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">版本号&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" name="versionNo" id="versionNo"
								readonly="readonly" class="form-control col-md-7 col-xs-12"
								value="${appVersion.versionNo}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="number">版本大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="versionSize" name="versionSize"
								required="required" readonly="readonly"
								data-validate-minmax="10,500"
								class="form-control col-md-7 col-xs-12"
								placeholder="请输入版本大小,单位为Mb" value="${appVersion.versionSize}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="select">发布状态&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" id="publishStatus" name="publishStatus"
								value="3" class="form-control col-md-7 col-xs-12">预发布
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							id="interfaceLanguage" name="interfaceLanguage"
							for="textarea">版本简介&nbsp;<span
							class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id="versionInfo" name="versionInfo" required="required"
								class="control-label col-md-3 col-sm-3 col-xs-12"
								readonly="readonly" value="">${appVersion.versionInfo}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">apk文件&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" id="downloadLink" name="downloadLink"
								value="${appVersion.downloadLink }" /> <input type="hidden"
								id="apkLocPach" name="apkLocPach"
								value="${appVersion.apkLocPath }" /> <input type="hidden"
								id="apkFileName" name="apkFileName"
								value="${appVersion.apkFileName }" />
							<div id="uploadfile" style="display:none">
								<input type="file" id="attach" name="attach"
									class="form-control col-md-7 col-xs-12">
								<p>
									<span style="color:red;font-weight:bold;">*注:1.大小不得超过500m,2.文件类型:apk...4个</span>
								</p>
							</div>
							<div id="apkFile"><p>${appVersion.apkFileName}</div>
							${fileUploadError }
						</div>
					</div>
					<div class="ln_solid"></div>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="common/footer.jsp"%>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appversionmodify.js"></script>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appinfomodify.js"></script>