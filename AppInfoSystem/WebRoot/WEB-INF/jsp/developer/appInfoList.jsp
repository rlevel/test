<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div>
	<div class="clearfix"></div>
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						APP信息管理维护 <small><i class="fa fa-user"></i>${devUserSession.devname}</small>
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
					<!-- action="${path}/appInfo/appInfoList"  -->
					<form id="demo-form2" data-parsley-validate
						class="form-horizontal form-label-left">
						<input type="hidden" name="pageIndex" value="1" />
						<ul>
							<li><div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="first-name">软件名称 </label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="text" id="querysoftwareName"
											name="querysoftwareName" value="${querysoftwareName==null?'':querysoftwareName}"
											class="form-control col-md-7 col-xs-12">
									</div>
								</div></li>
							<li>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="querystatus" id="querystatus"
											class="form-control">
											<c:if test="${statusList!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${statusList}" var="dataDic">
												<option
													<c:if test="${dataDic.valueId==querystatus}">selected="selected"</c:if>
													value="${dataDic.valueId}">${dataDic.valueName==null?"":dataDic.valueName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</li>
							<li>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="queryflatformId" id="queryflatformId"
											class="form-control">
											<c:if test="${flatFormList!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${flatFormList}" var="dataDic">
												<option
													<c:if test="${dataDic.valueId==queryflatformId}">selected="selected"</c:if>
													value="${dataDic.valueId}">${dataDic.valueName==null?"":dataDic.valueName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</li>
							<li>

								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="querycategoryLevel1" id="querycategoryLevel1"
											class="form-control">
											<c:if test="${categorylevel1List!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${categorylevel1List}" var="appCa">
												<option
													<c:if test="${appCa.id==querycategoryLevel1}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName==null?"":appCa.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</li>
							<li>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="querycategoryLevel2" id="querycategoryLevel2"
											class="form-control">
											<c:if test="${result.data!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${result.data}" var="appCa">
												<option
													<c:if test="${appCa.id==querycategoryLevel2}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName==null?"":appCa.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</li>
							<li>
								<div class="form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<select name="querycategoryLevel3" id="querycategoryLevel3"
											class="form-control">
											<c:if test="${result.data!=null}"></c:if>
											<option value="">--请选择--</option>
											<c:forEach items="${result.data}" var="appCa">
												<option
													<c:if test="${appCa.id==querycategoryLevel3}">selected="selected"</c:if>
													value="${appCa.id}">${appCa.categoryName==null?"":appCa.categoryName}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</li>
							<li>
								<div class="form-group">
									<button class="btn btn-primary" type="submit">查询</button>
								</div>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="x_panel">
		<div class="x_title">
			<h2>

				<button type="button" class="btn btn-warning">
					<a href="${path}/appInfo/addAppInfo">新增APP基础信息</a>
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
										aria-label="Position: activate to sort column ascending">APK名称</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 80px;"
										aria-label="Office: activate to sort column ascending">软件大小(单位:M)</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 50px;"
										aria-label="Age: activate to sort column ascending">所属平台</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 200px;"
										aria-label="Start date: activate to sort column ascending">所属分类(一级分类,二级分类,三级分类)
									</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 80px;"
										aria-label="Salary: activate to sort column ascending">状态</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 60px;"
										aria-label="Salary: activate to sort column ascending">下载次数
									</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 86px;"
										aria-label="Salary: activate to sort column ascending">最新版本号
									</th>
									<th class="sorting" tabindex="0" aria-controls="datatable"
										rowspan="1" colspan="1" style="width: 150px;"
										aria-label="Salary: activate to sort column ascending">操作
									</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${appInfoList}" var="appinfo">
									<tr>
										<td>${appinfo.softwareName}</td>
										<td>${appinfo.APKName}</td>
										<td>${appinfo.softwareSize}</td>
										<td>${appinfo.flatformName}</td>
										<td>
											${appinfo.categorylevel1Name}-->${appinfo.categorylevel2Name}-->${appinfo.categorylevel3Name}
										</td>
										<td><span id="appInfoStatus${appinfo.id}">${appinfo.statusName}</span></td>
										<td>${appinfo.downloads}</td>
										<td>${appinfo.versionNo}</td>
										<td>
										<div class="btn-group">
												<button type="button" class="btn btn-primary">点击操作</button>
												<button type="button"
													class="btn btn-primary dropdown-toggle"
													data-toggle="dropdown" aria-expanded="false">
													<span class="caret"></span> <span class="sr-only">切换下拉菜单</span>
												</button>
												<ul class="dropdown-menu" role="menu">
													<!-- 	<li><a href="#">上架/下架/null</a></li> -->
													<li><c:choose>
															<c:when test="${appinfo.status==2 || appinfo.status==5}">
																<a class="saleSwichOpen" saleSwitch="open"
																appinfoid="${appinfo.id}"
																status="${appinfo.status}"
																appsoftwarename=${appinfo.softwareName } data-toggle="tooltip"
																title="恭喜,您的审核已经通过,您可以点击上架发布您的APP"
																 href="#">上架</a>
															</c:when>
															<c:when test="${appinfo.status==4 || appinfo.status==5}">
																<a id="saleSwichClose" href="#"	class="saleSwichClose" saleSwitch="close"
																appinfoid="${appinfo.id}"
																status="${appinfo.status}"
																appsoftwarename=${appinfo.softwareName } data-toggle="tooltip"
																title="您可以点击下架来停止发布您的APP,市场将不提供APP的下载"
																>下架</a>
															</c:when>
														</c:choose></li>
													<li><a class="addVersion" appinfoid="${appinfo.id}" href="#" data-toggle="tooltip"
														data-placement="top" title="新增APP版本信息"> <span
															class="glyphicon glyphicon-cog " aria-hidden="true"></span>新增版本
													</a></li>
													<li><a href="#" 
													class="modifyVersion"
													data-toggle="tooltip" 
													appinfoid="${appinfo.id }"
													versionid="${appinfo.versionId }"
													status="${appinfo.status }"
													statusname="${appinfo.statusName }"
														data-placement="top" title="修改APP版本信息"> <span
															class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改版本
													</a></li>
													<li class="divider"></li>
													
													<li>
													<!-- class="modifyAppinfo" -->
													<a href="${path}/appInfo/jumpmodify/${appinfo.id}" appinfoid="${appinfo.id}"
													status="${appinfo.status}"
													statusName="${appinfo.statusName}"
													
													data-toggle="tooltip"
														data-placement="top" title="修改APP版本信息"> <span
															class="glyphicon glyphicon-cog modifyAppinfo"
															aria-hidden="true"></span>修改
													</a></li>
													<li><a class="viewApp"
													 versionid="${appinfo.versionId }"
													status="${appinfo.status }"
													statusname="${appinfo.statusName }"
													 appinfoid="${appinfo.id}" href="#" data-toggle="tooltip"
														data-placement="top" title="查看APP基础信息以及全部版本信息"> <span
															class="glyphicon glyphicon-cog" aria-hidden="true"></span>查看
													</a></li>
													<li><a class="deleteApp" appinfoid="${appinfo.id}"
														appsoftweraName="${appinfo.softwareName }"
														href="#" data-toggle="tooltip"
														data-placement="top" title="删除APP基础信息以及全部版本信息"> <span
															class="glyphicon glyphicon-cog" aria-hidden="true"></span>删除
													</a></li>
												</ul>
											</div></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-5">
						<div class="dataTables_info" id="datatable_responsive_info"
							role="status" aria-live="polite">共${pages.totalCount}条记录
							${pages.currentPageNo }/${pages.totalPageCount} 页</div>
					</div>
					<div class="col-sm-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="datatable_responsive_paginate">
							<ul class="pagination">
								<c:if test="${pages.currentPageNo > 1}">
									<li class="paginate_button previous"><a
										href="javascript:page_nav(document.forms[0],1);"
										aria-controls="datatable" data-dt-idx="0" tabindex="0"> 首页</a></li>
									<li class="paginate_button"><a
										href="javascript:page_nav(document.forms[0],${pages.currentPageNo-1});"
										aria-controls="datatable_responsive" data-dt-idx="1"
										tabindex="0"> Previous</a></li>
								</c:if>
								<c:if test="${pages.currentPageNo < pages.totalPageCount}">
									<li class="paginate_button"><a
										href="javascript:page_nav(document.forms[0],${pages.currentPageNo+1});"
										aria-controls="datatable_responsive" data-dt-idx="1"
										tabindex="0">Next</a></li>
									<li class="paginate_button next"><a
										href="javascript:page_nav(document.forms[0],${pages.totalPageCount});"
										aria-controls="datatable_responsive" data-dt-idx="7"
										tabindex="0">尾页</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div></div>
<%@include file="common/footer.jsp"%>
<!-- <script type="text/javascript" src(引用外部js文件)="xxx.js" charset(设置编码格式)="utf-8"></script> -->
<script
	src="${pageContext.request.contextPath}/statics/localjs/roolpage.js"></script>
<script
	src="${pageContext.request.contextPath}/statics/localjs/appinfolist.js"></script>