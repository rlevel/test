<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					新增APP基础信息<small>${devUserSession.devname}</small>
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
				<form id="demo-form2" data-parsley-validate action="${path}/appInfo/appinfoaddsave" method="post" enctype="multipart/form-data"
					class="form-horizontal form-label-left">
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">软件名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" name="softwarename" id="softwarename"
								class="form-control col-md-7 col-xs-12" placeholder="请输入软件名称">
						</div>
					</div>
					<div class="form-group">
						<label  class="control-label col-md-3 col-sm-3 col-xs-12"
							for="name">APK名称&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="APKName" name= "APKName"
								class="form-control col-md-7 col-xs-12" placeholder="请输入APK名称" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">支持ROM&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name"
								class="form-control col-md-7 col-xs-12" placeholder="请输入支持的ROM">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">界面语言&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="text" id="first-name"
								class="form-control col-md-7 col-xs-12" placeholder="请输入软件支持的界面语言">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">软件大小&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name"
								class="form-control col-md-7 col-xs-12" placeholder="请输入软件大小,单位为Mb">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">下载次数&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="number" id="first-name"
								class="form-control col-md-7 col-xs-12" placeholder="请输入下载次数">
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
										<c:if test="${dataDic.valueid==queryflatformId}">selected="selected"</c:if>
										value="${dataDic.valueid}">${dataDic.valuename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					
					
					<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类&nbsp;<span class="required">*</span></label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select name="querycategoryLevel1" id="querycategoryLevel1"
									class="form-control">
									<c:if test="${categorylevel1List!=null}"></c:if>
									<option value="">--请选择--</option>
									<c:forEach items="${categorylevel1List}" var="appCa">
										<option
											<c:if test="${appCa.id==querycategoryLevel1}">selected="selected"</c:if>
											value="${appCa.id}">${appCa.categoryname}</option>
									</c:forEach>
								</select>
							</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">二级分类&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<select id="heard" class="form-control" required="">
								<c:if test="${categorylevel2List!=null}"></c:if>
								<option value="">--请选择--</option>
								<c:forEach items="${categorylevel2List}" var="appCa">
									<option
										<c:if test="${appCa.id==querycategoryLevel2}">selected="selected"</c:if>
										value="${appCa.id}">${appCa.categoryname}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">三级分类&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<select id="heard" class="form-control" required="">
								<c:if test="${categorylevel3List!=null}"></c:if>
								<option value="">--请选择--</option>
								<c:forEach items="${categorylevel3List}" var="appCa">
									<option
										<c:if test="${appCa.id==querycategoryLevel3}">selected="selected"</c:if>
										value="${appCa.id}">${appCa.categoryname}</option>
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
							<input type="hidden" name="status" id="status" value="1"/>待审核
							<!-- <input type="text" id="first-name" class="form-control col-md-7 col-xs-12"> -->
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">应用简介&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<textarea id= "appInfo" name= "appInfo"
								class="form-control col-md-7 col-xs-12" placeholder="请输入本软件的相关信息,本信息作为软件的详细信息进行软件介绍"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 col-sm-3 col-xs-12"
							for="first-name">LOGO图片&nbsp;<span class="required">*</span>
						</label>
						<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="file" id="first-name"
								class="form-control col-md-7 col-xs-12">
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
<script src="${pageContext.request.contextPath}/statics/localjs/appinfoadd.js"></script>