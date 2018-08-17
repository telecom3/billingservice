<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>电信</title>
        <link type="text/css" rel="stylesheet" media="all" href="../static/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../static/styles/global_color.css" />
        <link rel="stylesheet" href="../static/layui/css/layui.css" media="all">
        <script src="../static/layui/layui.js"></script>
        <style>
            .layui-form{
                width: 450px;
                height: 200px;
            }
           .layui-card{
               margin-top: 5%;
               margin-left: 30%;
               opacity: 0.7;
               width: 600px;
               height: 400px;
           }
            .sj{
                float: right;
                line-height: 36px;
            }

        </style>
    </head>
    <body class="index">




    <div class="layui-card">
        <div class="layui-card-body">

            <div class="clear box  login">

                <br>
                <h1 class="layui-elip" style="text-align: center;color: blue;">用&nbsp;&nbsp;户&nbsp;&nbsp;登&nbsp;&nbsp;录</h1>
                <br>

                <form class="layui-form" action="/billingservice/templates/public/login" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" lay-verify="uname" required
                                   placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div><br>

                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                        <div class="layui-input-block">
                            <input type="password" name="pwd" lay-verify="" required
                                   placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div><br>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <a href="" class="sj" >手机验证登录</a>
                        </div>

                    </div>
                    <div class="layui-form-item layui-col-md-offset3">
                        <label class="layui-form-label"></label>
                        <button class="layui-btn layui-btn-lg btn-center" type="submit">登录</button>
                    </div>


                </form>

    </div>
        </div>
    </div>

    </body>
    <script>
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(formDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                return false;
            });
        });
    </script>
</html>
