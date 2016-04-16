<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新闻列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以创建新闻，新闻会按照创建时间和优先级进行显示.</p>
        <a class="btn btn-primary" id="createNewTemplateBtn">新建新闻</a><br/><br/>
        <div class="box box-body box-primary">
            <table id="newsTable" class="table table-hover table-responsive">
                <thead>
                    <tr>
                        <th>标题</th>
                        <th>新闻等级</th>
                        <th>生效时间</th>
                        <th>失效时间</th>
                        <th>发布时间</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="news_table_body">
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/news/news_list.js"></script>

