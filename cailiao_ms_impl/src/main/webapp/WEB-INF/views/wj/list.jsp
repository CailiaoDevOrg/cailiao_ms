<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>回收问卷列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以对已经回收的问卷进行查看与审核,<font color="red">建议审核之后刷新问卷列表，使问卷状态生效</font>.</p>
        <a class="btn btn-primary btn-flat" id="gobackToWJTPage">返回问卷模板列表</a> 
        <a class="btn btn-success btn-flat" id="refreshList">刷新列表</a><br/><br/>
        <!--<div class="form-group">
            <label for="statusSelect">选择要查看的问卷状态</label>
            <div id="statusSelect">
                <input type="checkbox" name="statusSelect">已提交但未审核<br/>
                <input type="checkbox" name="statusSelect">审核通过
            </div>
        </div>-->
        <div class="box box-body box-primary">
            <table id="wjTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>填写人</th>
                        <th>提交时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <input type="hidden" id="wjtId" value="${wjtId}">
    </div>
</div>

<script type="text/javascript" src="assets/custom/wj/wj_list.js"></script>

