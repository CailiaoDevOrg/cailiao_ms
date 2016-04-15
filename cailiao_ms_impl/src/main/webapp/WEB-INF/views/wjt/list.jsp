<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>问卷模板列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以管理已经创建的问卷模板，或创建新的问卷模板.</p>
        <a class="btn btn-primary" id="createNewTemplateBtn">创建新模板</a><br/><br/>
        <div class="box box-body box-primary">
            <table id="wjTemplateTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>问卷名称</th>
                        <th>问卷描述</th>
                        <th>生效时间</th>
                        <th>失效时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="wjt_table_body">
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/wjt/wjt_list.js"></script>

