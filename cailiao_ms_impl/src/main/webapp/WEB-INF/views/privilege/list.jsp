<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>接口列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以创建新的接口，也可以查看接口列表.</p>
        <a class="btn btn-primary btn-flat" id="createPrivilegeBtn">新建接口</a><br/><br/>
        <div class="box box-body box-primary">
            <table id="privilegeTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>url</th>
                        <th>method</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/privilege/privilege_list.js"></script>

