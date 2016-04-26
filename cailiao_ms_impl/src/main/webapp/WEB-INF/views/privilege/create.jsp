<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新建接口<small></small></h1>
    </div>

    <div class="content body">
        <p class="lead">您可以创建新的REST访问接口.</p>
        <a class="btn btn-primary btn-flat" id="showInterfaceList">查看接口列表</a><br/><br/>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">填写接口信息</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="url">接口地址</label>
                                <input type="text" class="form-control" id="url" placeholder="请输入REST接口的url">
                            </div>
                            <div class="form-group">
                                <label for="method">方法类型</label>
                                <div id="method">
                                    <input type="checkbox" value="GET" name="method"> GET
                                    <input type="checkbox" value="POST" name="method"> POST
                                    <input type="checkbox" value="PUT" name="method"> PUT
                                    <input type="checkbox" value="DELETE" name="method"> DELETE
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description">接口描述</label>
                                <input type="text" class="form-control" id="description" placeholder="请输入接口的描述信息">
                            </div>
                        </div>
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary btn-flat" id="submit" value="创建">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/privilege/privilege_create.js"></script>