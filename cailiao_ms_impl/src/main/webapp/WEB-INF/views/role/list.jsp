<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>角色列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以创建新的角色，也可以查看角色列表.</p>
        <a class="btn btn-primary btn-flat" id="createRoleBtn">新建角色</a><br/><br/>
        <div class="box box-body box-primary">
            <table id="roleTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>名字</th>
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

<script type="text/javascript" src="assets/custom/role/role_list.js"></script>

