<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>新闻列表<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以创建新闻，新闻会按照创建时间和优先级进行显示.</p>
        <a class="btn btn-primary btn-flat" id="createNewsBtn">新建新闻</a><br/><br/>
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
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    
    <!-- Modal -->
    <div class="modal fade" id="detailModal" tabindex="-1" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">新闻详情</h4>
                </div>
                <div class="modal-body" id="detailModalBody">
                    <form role="form">
                        <div class="form-group">
                            <label for="modalTitle">标题</label>
                            <input type="text" class="form-control" id="modalTitle" readonly>
                        </div>
                        <div class="form-group">
                            <label for="modalContent">内容</label>
                            <input type="text" class="form-control" id="modalContent" readonly>
                        </div>
                        <div class="form-group">
                            <label for="modalPublishedTime">发布时间</label>
                            <input type="text" class="form-control" id="modalPublishedTime" readonly>
                        </div>
                        <div class="form-group">
                            <label for="modalBeginTime">生效时间</label>
                            <input type="text" class="form-control" id="modalBeginTime" readonly>
                        </div>
                        <div class="form-group">
                            <label for="modalEndTime">失效时间</label>
                            <input type="text" class="form-control" id="modalEndTime" readonly>
                        </div>
                        <div class="form-group">
                            <label for="modalUrl">url</label>
                            <input type="text" class="form-control" id="modalUrl" readonly>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/news/news_list.js"></script>

