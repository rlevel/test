<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
				<!-- top tiles -->
				<div class="row tile_count">
					<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
						<div class="count">欢迎你:</div>
						<span class="count_top"><i class="fa fa-user"></i></span> <span
							class="count_bottom"><i class="green"> ${suser.devname }</i></span>
					</div>
					<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
						<div class="count">角色</div>
						<span class="count_top"><i class="fa fa-user"></i></span> <span
							class="count_bottom"><i class="green">${suser.devinfo }</i></span>
					</div>
				</div>
				<!-- /top tiles -->
				<br />
				<div class="row">
					<div class="col-md-8 col-sm-8 col-xs-12">
						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12"></div>
						</div>
						<div class="row">
							<!-- Start to do list -->
							<div class="col-md-6 col-sm-6 col-xs-12"></div>
							<!-- End to do list -->
							<!-- start of weather widget -->
							<div class="col-md-6 col-sm-6 col-xs-12"></div>
							<!-- end of weather widget -->
						</div>
					</div>
				</div>
<%@include file="common/footer.jsp"%>		
