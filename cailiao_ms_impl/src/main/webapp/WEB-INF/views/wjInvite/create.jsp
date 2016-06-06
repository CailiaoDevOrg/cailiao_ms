<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="content-wrapper">
    <div class="content-header">
        <h1>主面板<small>快捷访问</small></h1>
    </div>
    
    <div class="content body">
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">登记已发问卷厂家</h3>
                    </div>
                    <form role="form" class="row">
                        <div class="box-body">
                            <div class="form-group">
                                <span class="col-md-2" style="text-align:right">区域：</span><select id="area" style="width:300px;"></select>
                            </div>
                            <div class="form-group">
                               <span class="col-md-2" style="text-align:right">省份：</span> <select id="province_select" style="width:300px;">
                                </select>
                            </div>
                            <div class="form-group">
                                <span class="col-md-2" style="text-align:right">市区：</span> <select id="city_select" style="width:300px;">
                                </select>
                            </div>
                            <div class="form-group">
                               <span class="col-md-2" style="text-align:right">水泥厂：</span> <select id="company_select" style="width:300px;">
                                </select>
                            </div>
                            <div class="form-group">
                                <span class="col-md-2" style="text-align:right">问卷版本</span><select id="wj_version" style="width:300px;"></select>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2" style="text-align:right">
                                    <input type="button" class="btn btn-primary btn-flat" id="submit" value="提交">
                                </div>
                             </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="assets/custom/wjInvite/wjInvite_create.js"></script>
