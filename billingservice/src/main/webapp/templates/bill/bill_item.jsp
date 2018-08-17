<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>电信</title>
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />

    <link type="text/css" rel="stylesheet" href="../../static/layui/css/layui.css" media="all" />


    <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
    <script type="text/javascript" src="../../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    

</head>
 <script language="javascript" type="text/javascript">
        //写入下拉框中的年份和月份
        function initialYearAndMonth()
        //写入最近3年
        {
            var yearObj = document.getElementById("selYears");
            var year = (new Date()).getFullYear();
            for (var i = 0; i <= 2; i++) {
                var opObj = new Option(year - i, year - i);
                yearObj.options[i] = opObj;
            }
            //写入 12 月
            var monthObj = document.getElementById("selMonths");
            var opObj = new Option("全部", "全部");
            monthObj.options[0] = opObj;
            for (var i = 1; i <= 12; i++) {
                var opObj = new Option(i, i);
                monthObj.options[i] = opObj;
            }
        }
    </script>
<body onload="initialYearAndMonth();">

<!--Logo区域结束-->
<jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>





<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
        <div class="layui-col-md12">

            <div class="active">
                用户名: &nbsp;&nbsp;
                <div class="layui-inline">
                    <input class="layui-input" name="username" id="nameReload" autocomplete="off">
                </div>

                账务账号:
                <div class="layui-inline">
                    <input class="layui-input" name="account" id="accountReload" autocomplete="off">
                </div>

                身份证:&nbsp;&nbsp;
                <div class="layui-inline">
                    <input class="layui-input" name="idcard" id="idcardReload" autocomplete="off">
                </div>
                <div class="layui-inline">
				    <label class="layui-label">年月</label>
				    <div class="layui-input-inline">
				      <select name="year" id="selYears">
				        
				      </select>
				    </div>
					    <div class="layui-input-inline">
					      <select name="old" id="selMonths">
					      
					      </select>
					    </div>
   				 </div>
                <button class="layui-btn so" data-type="reload" id="so">搜索</button>
             
            </div>
        </div>
        
        
            
      
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist" lay-filter="demo">

            </table>
        </div>
        
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自全宇宙最帅组的技术，最优秀的小哥哥，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)全宇宙最帅组集团公司 </span>
</div>
</body>
<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="show">查看总费用</a>
	    <a class="layui-btn layui-btn-xs" lay-event="add">添加</a>
	</script>
<script>
    layui.use('table', function() {
        var table = layui.table;


        table.render({
            elem: '#datalist'
            , width: 900
            , height: 400
            , url: '/billingservice/templates/bill/month'
            , page: true //开启分页
            , limit: 5
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'businessName', title: 'os账号', width: 160, sort: true,templet: '#bunsinessName'}
                , {field: 'userName', title: '账务账号', width: 160, sort: true, templet: '#username'}
                , {field: 'osTime', title: '时长', width: 80, sort: true, templet: '#osTime'}
                , {field: 'osCost', title: '费用', width: 80, sort: true, templet: '#osCost'}
                , {field: 'businessMonrth', title: '月', width: 120, sort: true,templet:"#businessMonrth"}
                , {field: 'businessYear', title: '年', width: 120, sort: true,templet:"#businessYear"}
                , {field: 'tariffName', title: '资费', width: 120, sort: true,templet:"#tariffName"}
                , {fixed: 'right', width: 100, align: 'center', toolbar: '#barDemo'}

            ]]
        })


        //监听工具条
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
           
            if (obj.event === 'add') {
                // /accountmag/delete?id="+JSON.stringify(data.id);
          
                var index = layui.layer.open({
                    title : "业务报表",
                    type : 2,
                    content : "/billingservice/templates/bill_list.jsp?userRealName="+data.userName+"&month="+data.businessMonrth+"&year="+data.businessYear,//弹出层页面
                    area: ['600px', '600px'],
                    success : function(layero, index){
                        var body = layui.layer.getChildFrame('body', index);
                        setTimeout(function(){
                            layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500)
                    }
                })

                
            } else if (obj.event === 'show') {
                console.info("show")
                layer.confirm('真的么', function(index) {
            	location.href="/billingservice/templates/bill/bill_list.jsp?userRealName="+data.userName+"&month="+data.businessMonrth+"&year="+data.businessYear;
                })
            }
        });



        //查询按钮获取查询框的值
        var $ = layui.$, active = {
            reload: function(){
                var reload1 = $('#accountReload');
                var reload2=$('#idcardReload');
                var reload3=$('#nameReload');
                table.reload('idTest', {
                    where: {
                        account:reload1.val(),
                        idcard:reload2.val(),
                        username:reload3.val()
                    }
                });
            }
        };

        $('.layui-btn so').on('click', function() {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

</script>
</html>
