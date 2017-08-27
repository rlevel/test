<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					查看APP基础信息<small>${devUserSession.devname}</small>应用简介的属性名
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
							<input type="text" name="softwareName" id="softwareName" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.softwareName }">
						</div>
					</div>
					<div class="form-group">
						<label  class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">APK名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="APKName" name= "APKName" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.APKName}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">支持ROM&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" id="supportROM" name="supportROM" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.supportROM}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" id="interfaceLanguage" name="interfaceLanguage"
							for="first-name">界面语言&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.interfaceLanguage }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">软件大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="softwareSize" id="softwareSize" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.softwareSize }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">下载次数&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name" name="downloads" id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.downloads }">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">所属平台&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" name="downloads" id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.flatformName}">
						</div>
					</div>
					
					
					
					<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所属分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name" name="downloads" id="downloads" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appInfo.categorylevel1Name}-->${appInfo.categorylevel2Name}-->${appInfo.categorylevel3Name}">
						</div>
								</div>
				<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">APP状态&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<!-- 传数字到后台 value -->
							<input type="hidden" name="status" id="status" value="1"/>待审核
							<!-- <input type="text" id="first-name" class="form-control col-md-7 col-xs-12"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">应用简介&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id= "appInfos" name= "appInfos" readonly="readonly"
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
				</form>
			</div>
		</div>
	</div>
</div>

<div class="x_panel">
		<div class="x_title">
			<h2>
				<input type="hidden" value="There is no getter for property named 'modiFyBy' in 'class cn.appsys.pojo.AppVersion'"/>
				<button type="button" class="btn btn-warning">
					<a href="${path}/appInfo/addAppInfo">修改APP版本信息</a><small>${devUserSession.devname}</small>
				</button>
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

			<div id="datatable_wrapper"
				class="dataTables_wrapper form-inline dt-bootstrap no-footer">
				<div class="row">
					<div class="col-sm-6">
						<div class="dataTables_length" id="datatable_length"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table id="datatable"
							class="table table-striped table-bordered dataTable no-footer"
							role="grid" aria-describedby="datatable_info">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 159px;"
										aria-sort="ascending"
										aria-label="Name: activate to sort column descending">软件名称</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 200px;"
										aria-label="Position: activate to sort column ascending">版本号</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 90px;"
										aria-label="Office: activate to sort column ascending">软件大小(单位:M)</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 80px;"
										aria-label="Salary: activate to sort column ascending">发布状态</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 86px;"
										aria-label="Salary: activate to sort column ascending">APK文件下载
									</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 86px;"
										aria-label="Salary: activate to sort column ascending">最新更新时间
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appVersionList}" var="appVersion" varStatus="status">
									<tr>
										<td>${appVersion.appName}</td>
										<td>${appVersion.versionNo}</td>
										<td>${appVersion.versionSize}</td>
										<td>${appVersion.publishStatusName}</td>
										<td>
											<a href="${appVersion.downloadLink}">${appVersion.apkFileName}</a>
										</td>
										<td><fm:formatDate value="${appVersion.modifyDate}" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="common/footer.jsp"%>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appversionmodify.js"></script>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appinfomodify.js"></script>