<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>电信</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
        <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
        <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
        <script src="../../static/layui/layui.js"></script>
        <script src="../../static/js/index.js"></script>
        <script src="../../static/js/jquery-3.3.1.min.js"></script>
        <script src="../../static/js/dateFormat.js"></script>
  
        
    </head>
    <body>
 <jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

 <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <h2 style="margin-left: 380px">个人信息</h2>
            <form class="layui-form" action="/billingservice/templates/user/updateTel" method="post">
                
                <input type="hidden"  name="id" value="${userInfo.id}" / >
                
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">管理员账号：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input readonly="readonly" type="text" name="userName" id="userName" lay-verify="required|username" value="${userInfo.userName} "  class="layui-input">
                      </div>
                 </div>
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">身份证：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input readonly="readonly" type="text" name="userID" lay-verify="required|username" value="${userInfo.userID} "  class="layui-input">
                      </div>
                 </div>
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">姓名：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input readonly="readonly" type="text" name="userReallName" lay-verify="required|username"  value="${userInfo.userReallName }" class="layui-input">
                      </div>
                 </div>
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">电话：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input  type="text" name="userTelphone" lay-verify="required|phone" autocomplete="on" value="${userInfo.userTelphone }" class="layui-input">
                      </div>
                 </div>
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">邮箱：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input readonly="readonly"  type="text" name="userEmail" lay-verify="required|username" value="${userInfo.userEmail }"  class="layui-input">
                      </div>
                 </div>
                <div class="layui-form-item layui-row">
                    <div class="layui-input-block layui-col-offset5">
                        <button class="layui-btn" style="margin-left: 250px">修改</button>
                        <button class="layui-btn"><a href="../index.jsp" style="color:white">返回</a></button>
                    </div>
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
    <script src="../../static/layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
    <script>
        layui.use('element', function(){
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

            //监听导航点击
            element.on('nav(demo)', function(elem){
                //console.log(elem)
                layer.msg(elem.text());
            });
        });
        
        
        layui.use(['layer','upload','form'],function() {
            var layer = layui.layer,
            form = layui.form;
            /**
             * 通用表单验证
             */
            form.verify({
                
                phone: [/^[1][3,4,5,7,8][0-9]{9}$/,'手机号为11位']
            }); 
            
        
       })
    
               //回车键触发提交
               $("input").keydown(function(event){
                   if (event.keyCode == 13) {
                       document.getElementById("enterSubmit").click();
                   }
               });
    </script>
</html>
