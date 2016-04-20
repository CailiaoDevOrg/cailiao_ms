<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <div class="sidebar" id="scrollspy">
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="nav sidebar-menu">
            <li class="header">控制面板</li>
            <li class="active">
                <a href="javascript:void(0);" class="sidemenu" data-navigate="/main/dashboard.html"><i class="fa fa-circle-o"></i> 主面板</a>
            </li>
            <li class="treeview">
                <a href="javascript:void(0);"><i class="fa fa-circle-o"></i> 新闻与通知</a>
                <ul class="nav treeview-menu">
                    <li><a href="javascript:void(0);" class="sidemenu" data-navigate="/news/list.html">新闻中心</a></li>
                    <!--<li><a href="#">通知中心</a></li>
                    <li><a href="#">消息中心</a></li>-->
                </ul>
            </li>
            <!-- <li class="treeview">
                <a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 数据查询</a>
                <ul class="nav treeview-menu">
                    <li><a href="#">普通查询</a></li>
                    <li><a href="#">高级查询</a></li>
                </ul>
            </li> -->
            <li class="treeview">
                <a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 问卷模板管理</a>
                <ul class="nav treeview-menu">
                    <li><a href="javascript:void(0)" class="sidemenu" data-navigate="/wjt/create.html">新建问卷模板</a></li>
                    <li><a href="javascript:void(0)" class="sidemenu" data-navigate="/wjt/list.html">问卷模板列表</a></li>
                    <!--<li><a href="#">问卷回收监控</a></li>
                    <li><a href="#">问卷审核</a></li>
                    <li><a href="#">问卷查看</a></li>-->
                </ul>
            </li>
            <!--<li class="treeview">
                <a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 数据管理</a>
                <ul class="nav treeview-menu">
                    <li><a href="#">水泥厂信息管理</a></li>
                    <li><a href="#">系统邮箱管理</a></li>
                </ul>
            </li>-->
            <li class="treeview">
                <a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 用户管理</a>
                <ul class="nav treeview-menu">
                    <li><a href="javascript:void(0);" class="sidemenu" data-navigate="/user/list.html">用户列表</a></li>
                    <li><a href="javascript:void(0);" class="sidemenu" data-navigate="/user/create.html">创建用户</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="javascript:void(0)"><i class="fa fa-circle-o"></i> 权限管理</a>
                <ul class="nav treeview-menu">
                    <li><a href="javascript:void(0);">接口列表</a></li>
                    <li><a href="javascript:void(0);" class="sidemenu" data-navigate="/privilege/create.html">新建接口</a></li>
                    <li><a href="javascript:void(0);">角色列表</a></li>
                    <li><a href="javascript:void(0);">新建角色</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- /.sidebar -->
</aside>