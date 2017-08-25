<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
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
	
	<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					修改最新版本信息
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
				<form id="demo-form2" data-parsley-validate action="${path}/appInfo/addversionmodifysave" method="post" enctype="multipart/form-data"
					class="form-horizontal form-label-left">
					<input type="hidden" id="appId" name="appId" value="${appVersion.appId}">
					<input type="hidden" id="id" name="id" value="${appVersion.id}">
					
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">版本号&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" name="versionNo" id="versionNo" readonly="readonly"
								class="form-control col-md-7 col-xs-12" value="${appVersion.versionNo}">
						</div>
					</div>
					<div class="form-group">
						<label  class="control-label col-md-3 col-sm-3 col-xs-12"
							for="number">版本大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="versionSize" name= "versionSize" required="required"
								data-validate-minmax="10,500"
								class="form-control col-md-7 col-xs-12" placeholder="请输入版本大小,单位为Mb" value="${appVersion.versionSize}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="select">发布状态&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" id="publishStatus" name="publishStatus" value="3"
								class="form-control col-md-7 col-xs-12">预发布
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12" id="interfaceLanguage" name="interfaceLanguage"
							for="textarea">版本简介&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id="versionInfo" name="versionInfo" required="required" 
							class="control-label col-md-3 col-sm-3 col-xs-12"
							value="${appVersion.versionInfo}"
							></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">apk文件&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
						<input type="hidden" id="downloadLink" name="downloadLink" value="${appVersion.downloadLink }"/>
						<input type="hidden" id="apkLocPach" name="apkLocPach" value="${appVersion.apkLocPath }"/>
						<input type="hidden" id="apkFileName" name="apkFileName" value="${appVersion.apkFileName }"/>
							<div id="uploadfile" style="display:none">
							<input type="file" id="attach" name="attach"
								class="form-control col-md-7 col-xs-12"><p>
								<span style="color:red;font-weight:bold;">*注:1.大小不得超过500m,2.文件类型:apk...4个</span></p>
							</div>
							<div id="apkFile"></div>
								${fileUploadError }
						</div>
					</div>
					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<button class="btn btn-primary" type="button">Cancel</button>
							<button id="back" class="btn btn-primary" type="reset">Reset</button>
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp"%>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appversionmodify.js"></script>
