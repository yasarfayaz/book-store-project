<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Book Purchase E-commerce Platform">
    <title>mindKey</title>
    <link href="../css/styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="../img/mindkey_logo.png" type="image/png">
    <script src="JS/register.js" defer></script>
</head>

<body class="mk-register">
    <header>
        <div class="mk-logo">
            <img src="../img/mk.png" />
            <span class="mk-logo-text">mindKey</span>
        </div>
    </header>
    <div class="mk-main">
        <div class="mk-register-main">
            <div class="mk-rg-left">
                <p class="mk-rg-left-p">Hello ! Welcome To mindKey</p>
                <p class="mk-rg-left-p2">Get the key to unlock your mind here...</p>
                <div class="mk-rg-left-bg">
                </div>
            </div>
            <div class="mk-rg-right">
                <div class="mk-rg-bx">
                    <form id="form" action="/addUser" method="get">
                        <h1>Sign Up</h1>
                        <h5 style="color: green;">${success}</h5>
                        <h5 style="color: red;">${failed}</h5>
                        <div class="mk-rg-bx-ip">
                            <div class="mk-rg-bx-ipe">
                                <label>Name</label>
                                <input type="text" id="inputName" name="userName" placeholder="Enter your username" />
                                <div class="error"></div>
                            </div>
                            <div class="mk-rg-bx-ipe">
                                <label>Email</label>
                                <input type="text" id="inputEmail" name="email" placeholder="Enter your email" />
                                <div class="error"></div>
                            </div>
                            <div class="mk-rg-bx-ipe">
                                <label>Password</label>
                                <input type="password" id="inputPassword" name="password" placeholder="Enter your password" />
                                <div class="error"></div>
                            </div>
                            <div class="mk-rg-bx-ipe">
                                <label>Phone Number</label>
                                <input type="number" id="inputphoneNumber" name="phoneNumber" placeholder="Enter your phone number" />
                                <div class="error"></div>
                            </div>
                            <button type="submit" class="mk-register-clk">Sign Up</button>
                            <!-- <a href=""  class="mk-register-clk">Sign Up</a> -->
                            <p class="mk-lg-acc-p">Already have an account? <a href="login.jsp" class="mk-cr-acc-p-a">Login</a></p>
                    </form>
                    
                </div>
                
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