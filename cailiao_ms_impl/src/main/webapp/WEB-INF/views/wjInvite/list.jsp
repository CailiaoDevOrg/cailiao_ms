<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head></head>
	<body>	
	<div class="content-wrapper">
		<input type="text" id="city" placeholder="请输入城市名称"><br>
		<button type="button" class="button button-primary" id="query"/>
		</div>
	<%-- <div class="content-wrapper">
		<input type="text" id="city" placeholder="请输入城市名称"><br>
		<button type="button" class="button button-primary" id="query"/>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>名称</th>
					<th>地址</th>
					<th>投产时间</th>
					<th>电话</th>
				</tr>
			</thead>
			<c:forEach var="dev" items="${Companys}">
				<tr>
					<td>${dev.name}</td>
					<td>${dev.address}</td>
					<td>${dev.startDate}</td>
					<td>${dev.phoneNumber}</td>

					<!--  	<div class="btn-group">
							<td><button id="detail" class="btn btn-primary btn-xs">详细信息</button></td>
						</div>
						<div class="btn-group">
							<td><button id="delete" class="btn btn-danger btn-xs">删除</button></td>
						</div>-->

					<div class="btn-group">
							<td><button id="${dev.id }" class="btn btn-primary btn-xs detail">详细信息</button>
							 
							 <button id="${dev.id}" class="btn btn-danger btn-xs aDeleteSampleItem" >删除</button>  
							</td>
						</div>
				</tr>
			</c:forEach>
		</table>
	</div>--%>
	<script>
		$('#query').bind('click',function(){
			var city = $('#city').val();	
			alert(city);
			$.ajax({
				url:'/company/getCompanyByAddress.html?address='+city,
			    method: 'GET',
			    contentType:'application/json',
			    success:function(data) {
			    	console.log(data);
			    }
			});
			
		})
	</script> 
</body>
</html>
