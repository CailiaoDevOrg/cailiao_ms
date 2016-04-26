<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>系统参数控制<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以查看,刷新及更新系统相关参数.</p>
        <div class="box box-body box-primary">
            <table class="table table-hover table-responsive">
                <tr>
                    <th>#</th>
                    <th>说明</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>刷新系统ACL，一般用于增加或删除访问接口的情况</td>
                    <td><button class="btn btn-primary btn-xs btn-flat" id="refreshACL">刷新ACL列表</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>退出所有当前登录的用户</td>
                    <td><button class="btn btn-primary btn-xs btn-flat" id="signOutAll">退出登录用户</button></td>
                </tr>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/ctrl/sysparam.js"></script>

