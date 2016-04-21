<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新建角色<small></small></h1>
    </div>

    <div class="content body">
        <p class="lead">您可以创建新的角色.</p>
        <a class="btn btn-primary" id="showRoleList">查看角色列表</a><br/><br/>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">填写角色信息</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="name">名称</label>
                                <input type="text" class="form-control" id="name" placeholder="请输入角色名称">
                            </div>
                            <div class="form-group">
                                <label for="description">角色描述</label>
                                <input type="text" class="form-control" id="description" placeholder="请输入角色描述信息">
                            </div>
                            <div class="form-group">
                                <label for="privilegeList">访问接口</label>
                                <div id="privilegeList">
                                    <!--<input type="checkbox" value="GET" name="privilege"> GET
                                    <input type="checkbox" value="POST" name="privilege"> POST
                                    <input type="checkbox" value="PUT" name="privilege"> PUT
                                    <input type="checkbox" value="DELETE" name="privilege"> DELETE-->
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary" id="submit" value="创建">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/role/role_create.js"></script>