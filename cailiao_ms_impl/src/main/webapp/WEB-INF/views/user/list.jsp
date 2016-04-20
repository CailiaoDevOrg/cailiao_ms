<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>用户列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以创建新用户.</p>
        <a class="btn btn-primary" id="createUserBtn">新建用户</a><br/><br/>
        <div class="box box-body box-primary">
            <table id="usersTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>帐号</th>
                        <th>描述</th>
                        <th>所在水泥厂</th>
                        <th>邮箱</th>
                        <th>角色</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/user/user_list.js"></script>

