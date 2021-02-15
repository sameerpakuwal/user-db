<%--<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--<link rel="stylesheet" href="/resources/css/forgot-password.css">--%>
<%--<script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<script type="text/javascript" src="/resources/js/jquery-3.5.1.min.js"></script>--%>
<%--<!------ Include the above in your HEAD tag ---------->--%>

<style>

</style>
<div class="form-gap"></div>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3><i class="fa fa-lock fa-4x"></i></h3>
                        <h3 style="font-size:14px; color:#538b01; font-weight:bold; font-style:italic">${sent}</h3>
                        <h3 style="font-size:14px; color:#538b01; font-weight:bold; font-style:italic">${error}</h3>
                        <h2 class="text-center">Forgot Password?</h2>
                        <p>You can reset your password here.</p>
                        <p>${msg}</p>
                        <div class="panel-body">

                            <form id="register-form" action="/forgot_password" autocomplete="off" class="form" method="post">

                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input id="email" name="email" placeholder="email address" class="form-control"  type="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                </div>

                                <input type="hidden" class="hide" name="token" id="token" value="">
                            </form>



                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
