

<div>
    <h2>Reset Your Password</h2>
</div>
<p>${not_match}</p>
<p>${crietria_match}</p>

<form action="/reset_password" method="post" style="max-width: 350px; margin: 0 auto;">
    <input type="text" name="token" value="${token}" />
    <div class="border border-secondary rounded p-3">
        <div>
            <p>
                <input type="password" name="password1"  class="form-control"
                       placeholder="Enter your new password" required autofocus />
            </p>
            <p>
                <input type="password" name="password2" class="form-control" placeholder="Confirm your new password"/>
            </p>
            <p class="text-center">
                <input type="submit" value="Change Password" class="btn btn-primary" />
            </p>
        </div>

        <p style="font-size:14px; color:#538b01; font-weight:bold; font-style:italic"> "Please make sure you have at least 8 characters including one uppercase, one special character @#$%^&+=>")</p>
    </div>
</form>
