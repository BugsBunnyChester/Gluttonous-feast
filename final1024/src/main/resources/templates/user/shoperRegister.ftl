<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/user/shoRegister">
                        <div class="form-group">
                            <label>手机号码</label>
                            <input name="phoneNumber" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="userLastName" type="text" class="form-control"  />
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="number" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>再次输入密码</label>
                            <input name="password_again" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>身份证号码</label>
                            <input name="IDcdNumber" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>真实姓名</label>
                            <input name="trueName" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>e-mail</label>
                            <input name="emil" type="text" class="form-control" />
                        </div>

                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>

</body>
</html>