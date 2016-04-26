<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新建问卷模板<small></small></h1>
    </div>

    <div class="content body">
        <p class="lead">您可以创建新的问卷模板.</p>
        <a class="btn btn-primary btn-flat" id="showWjTemplateList">查看模板列表</a><br/><br/>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">填写模板信息</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="name">问卷模板名称</label>
                                <input type="text" class="form-control" id="name" placeholder="请输入模板名称">
                            </div>
                            <div class="form-group">
                                <label for="desc">问卷模板描述</label>
                                <input type="text" class="form-control" id="desc" placeholder="问卷模板描述">
                            </div>
                            <div class="form-group">
                                <label for="beginTime">生效时间</label>
                                <input type="text" class="form-control form_datetime" id="beginTime" placeholder="问卷生效时间" readonly>
                            </div>
                            <div class="form-group">
                                <label for="endTime">失效时间</label>
                                <input type="text" class="form-control form_datetime" id="endTime" placeholder="问卷失效时间" readonly>
                            </div>
                            <div class="form-group">
                                <label for="pageUrl">pageUrl</label>
                                <input type="text" class="form-control" id="pageUrl" placeholder="页面Url">
                            </div>
                        </div>
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary btn-flat" id="submit" value="提交">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/wjt/wjt_create.js"></script>