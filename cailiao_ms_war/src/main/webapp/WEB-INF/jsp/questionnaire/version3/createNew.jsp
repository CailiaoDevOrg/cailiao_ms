<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<h3 class="sub-header">新建问卷</h3>
<form>
	<div class="form-group">
		<label for="questionnaireName">问卷名称</label> 
		<input type="text" class="form-control" id="questionnaireName" placeholder="问卷名称">
	</div>
	<div class="form-group">
		<label for="jspPageUrl">JSP页面</label> 
        <input type="text" class="form-control" id="jspPageUrl" placeholder="请填写jsp页面的url">
	</div>
	
	<button type="submit" class="btn btn-default">Submit</button>
</form>