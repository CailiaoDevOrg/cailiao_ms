<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>编辑用户信息<small></small></h1>
    </div>

    <div class="content body">
        <p class="lead">您可以在此处修改用户信息.</p>
        <a class="btn btn-primary btn-flat" id="showUserList">查看用户列表</a><br/><br/>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">修改用户信息</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="accountId">用户名</label>
                                <input type="text" class="form-control" id="accountId" value="${accountId}" readonly>
                            </div>
                            <div class="form-group">
                                <label for="description">描述</label>
                                <input type="text" class="form-control" id="description" placeholder="请输入相关描述信息">
                            </div>
                            <div class="form-group">
                                <label for="email">邮箱</label>
                                <input type="text" class="form-control" id="email" placeholder="请输入邮箱">
                            </div>
                            <div class="form-group">
                                <label for="status">选择用户状态</label>
                                <select class="form-control" id="status">
                                    <option value="1">激活</option>
                                    <option value="2">冻结</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="factoryId">选择用户所在水泥厂</label>
                                <select class="form-control" id="factoryId">
                                    <option value="-1">测试用水泥厂</option>
                                    <option value="1">1</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="roleList">选择用户角色</label>
                                <div id="roleList">
                                    
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary btn-flat" id="submit" value="更新用户信息">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/crypto/core-min.js"></script>
<script type="text/javascript" src="assets/crypto/md5-min.js"></script>
<script type="text/javascript" src="assets/custom/user/user_edit.js"></script>