<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link type="text/css"rel="stylesheet"href="../static/layui/css/layui.css" media="all">
    <script type="text/javascript"src="../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript"src="../static/layui/layui.js"></script>
    <style type="text/css">
        .demoTable {
            margin-top: 10%;
            text-align: center;
        }

        .layui-col-md10 {
            text-align: center;
        }

    </style>
</head>
<body>
<div class="demoTable">
    用户名:
    <div class="layui-inline">
        <input class="layui-input" name="keyword" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>


<div class="layui-row">
    <div class="layui-col-md-offset1">
        <div class="layui-col-md10">
            <table class="layui-table" id="idTest" lay-filter="demo"></table>
        </div>
    </div>
</div>

<div class="layui-row">
    <div class="layui-col-md-offset1">
        <div class="layui-col-md10">
            <a onclick="add()" class="layui-btn">添加</a>
        </div>
    </div>
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use('table', function() {
        var table = layui.table;

        table.render({
            elem: '#idTest'
            ,width: 892
            ,height: 332
            ,url:'/accountmag/main'
            ,page: true //开启分页
            ,limit: 10
            ,cols: [[ //表头
                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'accountName', title: '账户名', width:80, sort: true}
                ,{field: 'birthday', title: '生日', width:160, sort: true,templet:'#birthday'}
                ,{field: 'createTime', title: '创建时间', width:160, sort: true,templet:'#createTime'}
                ,{field: 'updateTime', title: '修改时间', width:160,sort: true,templet:'#updateTime'}
                ,{field: 'money', title: '金额', width: 80, sort: true}
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
        });





        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除行么', function(index) {

                    location.href="<%=request.getContextPath()%>/accountmag/delete?id="+JSON.stringify(data.id);
                });
            } else if (obj.event === 'edit') {
                var index = layui.layer.open({
                    title : "编辑用户",
                    type : 2,
                    content : "update.jsp?id=" + data.id,//弹出层页面
                    area: ['400px', '400px'],
                    success : function(layero, index){
                        var body = layui.layer.getChildFrame('body', index);
                        setTimeout(function(){
                            layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500)
                    }
                })

            }
        });


        //查询按钮获取查询框的值
        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');
                table.reload('idTest', {
                    where: {
                        keyword: demoReload.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function() {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });


    //添加方法
    function add() {
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "add.jsp",//弹出层页面
            area: ['500px', '500px'],
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)


            }
        })
    }
</script>

<!--时间格式化-->
<script src="/bicycle_sharing_ssh/static/js/date-format.js" type="text/javascript" charset="utf-8"></script>
<script id="createTime" type="text/html">
    {{#
    var date = new Date();
    date.setTime(d.createTime);
    return date.Format("yyyy-MM-dd hh:mm:ss");
    }}
</script>
<script id="updateTime" type="text/html">
    {{#
    var date = new Date();
    date.setTime(d.updateTime);
    return date.Format("yyyy-MM-dd hh:mm:ss");
    }}
</script>
<script id="birthday" type="text/html">
    {{#
    var date = new Date();
    date.setTime(d.birthday);
    return date.Format("yyyy-MM-dd");
    }}
</script>

</body>
</html>