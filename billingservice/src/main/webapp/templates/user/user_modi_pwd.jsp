<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>电信</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../static/styles/global_color.css" />
        <link rel="stylesheet" href="../../static/layui/css/layui.css" media="all">
        <link type="text/css" rel="stylesheet"href="../../static/styles/index1.css">
        <script src="../../static/js/index.js"></script>
        <script src="../../static/layui/layui.js"></script>
		<script src="../../static/js/jquery-3.3.1.min.js"></script>
    </head>
    <body>
   <jsp:include page="../nav/nav.jsp" flush="true"></jsp:include>

    <!--导航区域结束-->
        <div id="main">      
            
            <br>
            <br>
            
            <form class="layui-form" id="form1">
            
            <input type="hidden"  name="id" value="${userInfo.id}" / >
            
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">旧密码：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input type="password" name="oldPwd" id="oldPwd" lay-verify="required|oldPwd" autocomplete="on" 
                          placeholder="请输入原密码" class="layui-input">
                      </div>
                 </div>
                
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">新密码：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input type="password" name="newPwd" id="newPwd" lay-verify="required|newPwd" autocomplete="on" 
                          placeholder="请输入新密码" class="layui-input">
                      </div>
                 </div>
                
                <div class="layui-form-item layui-row">
                      <div class="layui-col-md2-offset2"><label class="layui-form-label" style="width: 120px">重复新密码：</label></div>
                      <div class="layui-input-block layui-col-md5">
                          <input type="password"  id="twoNewPwd" lay-verify="required|twoNewPwd" autocomplete="on" 
                          placeholder="请重复输入新密码" class="layui-input">
                      </div>
                 </div>
                
                <div class="layui-form-item layui-row">
                    <div class="layui-input-block layui-col-offset5">
                        <button class="layui-btn" lay-submit lay-filter="formDemo" style="margin-left: 250px">修改</button>
                        <a class="layui-btn"   layui-btn href="../index.jsp" >返回</a>
                    </div>
                </div>
            </form>  
        </div>
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
            	oldPwd: [/^[\w]{3,12}$/,'原密码为3到12位'],
            	newPwd: [/^[\w]{3,12}$/,'新密码必须3到12位，且不能出现空格'],
                twoNewPwd:function(value, item){
                	 if($("#newPwd").val()!=$("#twoNewPwd").val()){
                        return "两次输入密码不一致，请重新输入！";
                    }
                }

            });  
            /**
             * 通用表单提交(AJAX方式)
             */
            form.on('submit(formDemo)', function (data) {
				
            	$.post("/billingservice/templates/public/updatePwd", $("#form1").serialize(),function (info) {

            		console.log(info);

                     if (info == 0) {
                    	layer.msg("原密码错误！");
                    }else if(info == 1){
						//修改成功
						location.href= "/billingservice/templates/login.jsp";
                        }
                    
                },"json");

                return false;
            });
       });
    
               //回车键触发提交
               $("input").keydown(function(event){
                   if (event.keyCode == 13) {
                       document.getElementById("enterSubmit").click();
                   }
               })
    </script>
</html>
