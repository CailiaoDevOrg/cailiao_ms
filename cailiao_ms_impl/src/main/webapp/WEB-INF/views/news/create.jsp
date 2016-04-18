<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新建新闻<small></small></h1>
    </div>

    <div class="content body">
        <p class="lead">您可以创建新闻，新闻会按照创建时间和优先级进行显示.</p>
        <a class="btn btn-primary" id="showNewsList">查看新闻列表</a><br/><br/>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">填写新闻信息</h3>
                    </div>
                    <form role="form">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="title">标题</label>
                                <input type="text" class="form-control" id="title" placeholder="请输入新闻标题">
                            </div>
                            <div class="form-group">
                                <label for="content">内容</label>
                                <input type="text" class="form-control" id="content" placeholder="请输入新闻内容">
                            </div>
                            <div class="form-group">
                                <label for="url">跳转地址</label>
                                <input type="text" class="form-control" id="url" placeholder="请输入新闻点击跳转地址">
                            </div>
                            <div class="form-group">
                                <label for="level">重要等级</label>
                                <select class="form-control" id="level">
                                    <option value="3">重要</option>
                                    <option value="2">临时</option>
                                    <option value="1">普通</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="beginTime">生效时间</label>
                                <input type="text" class="form-control form_datetime" id="beginTime" placeholder="请选择新闻生效时间" readonly>
                            </div>
                            <div class="form-group">
                                <label for="endTime">失效时间</label>
                                <input type="text" class="form-control form_datetime" id="endTime" placeholder="请选择新闻失效时间" readonly>
                            </div>
                        </div>
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary" id="submit" value="发布">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/news/news_create.js"></script>