<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Book Purchase E-commerce Platform">
    <title>mindKey</title>
    <link href="../css/styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="../img/mindkey_logo.png" type="image/png">
</head>

<body class="mk-login">
    <header>
        <div class="mk-logo">
            <img src="../img/mk.png" />
            <span class="mk-logo-text">mindKey</span>
        </div>
    </header>
    <div class="mk-main">
        <div class="mk-login-main">
            <div class="mk-lg-left">
                <p>leaders are readers</p>
            </div>
            <div class="mk-lg-right">
                <div class="mk-lg-bx">
                    <form action="/log" method="get">
                        <h1>Login</h1>
                        <h5 style="color:  #a1a0a0;text-align: center;">${success}</h5>
                        <h5 style="color: red;text-align: center;" >${failedMsg}</h5>
                        <div class="mk-lg-bx-ip">
                            <div class="mk-lg-bx-ipe">
                                <label>Email</label>
                                <input type="email" name="email" placeholder="Enter your usermail" />
                            </div>
                            <div class="mk-lg-bx-ipe">
                                <label>Password</label>
                                <input type="password" name="password" placeholder="Enter your password" />
                            </div>
                            <!-- <a href="#" class="mk-login-clk">Login</a> -->
                            <button type="submit" class="mk-login-clk">Login</button>
                    </form>
                </div>
                <p class="mk-cr-acc-p">Don't have account? <a href="register.jsp" class="mk-cr-acc-p-a">Create account</a></p>
            </div>
        </div>
    </div>
    </div>
    <footer>
        <p> &#169; Developed By Noorullah</p>
    </footer>

    <script type="text/javascript">

    </script>
</body>

</html>