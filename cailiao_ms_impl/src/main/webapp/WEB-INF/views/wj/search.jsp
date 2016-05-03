<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>问卷查询<small></small></h1>
    </div>
    
    <div class="content body">
        <p class="lead">您可以对问卷进行查询.</p>
        <a class="btn btn-primary btn-flat" id="search">查询</a><br/><br/>
        <div class="box box-primary">
             <div class="box-header with-border">
                 <h3 class="box-title">选择搜索条件</h3>
             </div>
             <div class="box-body">
                 <div class="form-group">
                     <input type="checkbox" name="searchCondition" value="jbxx" id="jbxxCb" /> 基本信息
                     <input type="checkbox" name="searchCondition" value="zyxh" id="zyxhCb" /> 资源消耗
                     <input type="checkbox" name="searchCondition" value="nyxh" id="nyxhCb" /> 能源消耗
                     <input type="checkbox" name="searchCondition" value="fqpf" id="fqpfCb" /> 废气排放
                     <input type="checkbox" name="searchCondition" value="zysb" id="zysbCb" /> 主要设备
                 </div>
                 <input type="hidden" id="wjtId" value="${wjtId}"/>
             </div>
        </div>
        
        <div class="row">
            <div class="searchCondition">

            </div>
        </div>
        
    </div>
</div>

<script type="text/javascript" src="assets/custom/wj/wj_search.js"></script>

