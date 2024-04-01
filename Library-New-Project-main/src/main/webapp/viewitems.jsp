<%@ page import="com.chainsys.library.model.Books" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Book Purchase E-commerce Platform">
    <title>mindKey</title>
    <link href="../css/styles.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="../img/mindkey_logo.png" type="image/png">
    <link href="../fonts/fontawesome/css/all.css" rel="stylesheet" />
</head>

<body class="mk-home">
    <header>
        <div class="mk-logo">
            <img src="../img/mk.png" />
            <span class="mk-logo-text">mindKey</span>
        </div>
        <div class="mk-user">
            <span id="mk-user-clk" class="mk-user-clk"><i class="fa-solid fa-user"></i></span>
            <div class="mk-user-info">
                <div class="mk-user-info-e">
                    <i class="fa-solid fa-user-tie"></i>
                    <span>${userobj.userName}</span>
                </div>
                <div class="mk-user-info-e">
                    <i class="fa-solid fa-envelope"></i>
                    <span>${userobj.email}</span>
                </div>
                <a href="login.jsp" style="text-decoration: none;">
                    <div class="mk-user-info-lo">
                        <i class="fa-solid fa-right-from-bracket"></i>
                        <span>Logout</span>
                    </div>
                </a>
            </div>
        </div>
    </header>
    <div class="mk-main">
        <div class="mk-pagehead mkclear">
            <div class="mk-nav">
                <a href="/userHome?uid=${userobj.id}" title="Home" class="mk-home-clk"><i class="fa fa-home"></i></a>
                <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Comics"><i class="fa fa-book-tanakh"></i><span>Comics</span></a>
                <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Historical"><i class="fa fa-book-atlas"></i><span>Historical</span></a>
                <div class="mk-more-mn">
                    <a id="mk-more-clk" href="#" title="More" class="mk-more-clk"><i class="fa fa-ellipsis"></i></a>
                    <div class="mk-more-dropdown">
                        <ul>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Course">
                            <li>Course</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Comics">
                            <li>Comics</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Historical">
                            <li>Historical</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Mystery">
                            <li>Mystery</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Science Fiction">
                            <li>Science Fiction</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Horror">
                            <li>Horror</li>
                        </a>
                        <a href="/bookCategory?uid=${userobj.id}&&bookCategory=Adventure">
                            <li>Adventure</li>
                        </a>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- <div class="mk-it-search-mn">
                <input type="text" id="mk-item-search" placeholder="Search here" onkeyup="searchItems()" />
                <i class="fa fa-search"></i>
            </div> -->

            <div class="mk-it-search-mn">
                <form action="/searchBook" method="get">
                    <input type="text" name="ch" id="mk-item-search" placeholder="Search here" />
                    <button type="submit" style="border: none;"><i class="fa fa-search"></i></button>
                    <input type="hidden" name="uid" value="${userobj.id}">
                </form>
            </div>

            <a href="/cartOut?uid=${userobj.id}" class="mk-add-cart-view"><i class="fa-solid fa-cart-plus"></i></a>
        </div>
        <% List<Books> allBooks =(List<Books>) request.getAttribute("bookCate");
                %>
        <div class="mk-it-mn mkclear mk-scroll">
            <div id="new" class="mk-ic-e mkclear">
                <h4 class="mk-ic-eh">${bookCategory}</h4>
                <div class="mk-ic-list">
                    <% for(Books books : allBooks){ %>
                    <div class="mk-it-li">
                        <div class="flip-card">
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <div class="mk-il-bk">
                                        <div class="mk-il-bkbx">
                                            <img src="../book/<%=books.getPhotoName()%>" />
                                            <h5><%=books.getBookName()%></h5>
                                        </div>
                                        <div class="mk-il-bkact mkclear">
                                            <div class="mk-il-bkactl">
                                                <i class="fa-solid fa-indian-rupee-sign"></i>
                                                <span><%=books.getPrice()%></span>
                                            </div>
                                            <div class="mk-il-bkactr">
                                                <i class="fa-solid fa-circle-info"></i>
                                                <span>Details</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="flip-card-back">
                                    <div class="mk-il-bk">
                                        <div class="mk-il-bkbx-back">
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Name :</span>
                                                <span class="mk-bk-dt-ec"><%=books.getBookName()%></span>
                                            </div>
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Author :</span>
                                                <span class="mk-bk-dt-ec"><%=books.getAuthor()%></span>
                                            </div>
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Published Year :</span>
                                                <span class="mk-bk-dt-ec"><%=books.getPublishedYear()%></span>
                                            </div>
                                        </div>
                                        <div class="mk-il-bkact mkclear">
                                            <a href="/cart?bid=<%=books.getBookId() %>&&uid=${userobj.id}">
                                            <div class="mk-add-cart">
                                                <i class="fa-solid fa-cart-plus"></i>
                                                <span>Add cart</span>
                                            </div></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%}%>
                    <!-- <div class="mk-it-li">
                        <div class="flip-card">
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <div class="mk-il-bk">
                                        <div class="mk-il-bkbx">
                                            <img src="../img/bk1.jpg" />
                                            <h5>IKIGAI</h5>
                                        </div>
                                        <div class="mk-il-bkact mkclear">
                                            <div class="mk-il-bkactl">
                                                <i class="fa-solid fa-indian-rupee-sign"></i>
                                                <span>500</span>
                                            </div>
                                            <div class="mk-il-bkactr">
                                                <i class="fa-solid fa-circle-info"></i>
                                                <span>Details</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="flip-card-back">
                                    <div class="mk-il-bk">
                                        <div class="mk-il-bkbx-back">
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Name :</span>
                                                <span class="mk-bk-dt-ec">IKIGAI</span>
                                            </div>
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Author :</span>
                                                <span class="mk-bk-dt-ec">Albert Einstein</span>
                                            </div>
                                            <div class="mk-bk-dt-e mkclear">
                                                <span class="mk-bk-dt-el">Published Year :</span>
                                                <span class="mk-bk-dt-ec">2000</span>
                                            </div>
                                        </div>
                                        <div class="mk-il-bkact mkclear">
                                            <div class="mk-add-cart">
                                                <i class="fa-solid fa-cart-plus"></i>
                                                <span>Add cart</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
        </div>
    </div>
    </div>
    <footer>
        <p> &#169; Developed By Noorullah</p>
    </footer>

    <script type="text/javascript">
        document.onclick = myClickHandler;
        function myClickHandler() {
            document.querySelector('.mk-more-mn').classList.remove('active');
            document.querySelector('.mk-user').classList.remove('active')
        }

        var mrclk = document.getElementById("mk-more-clk");
        mrclk.addEventListener('click', event => {
            (document.querySelector(".mk-more-mn").classList.contains("active")) ? document.querySelector('.mk-more-mn').classList.remove('active') : document.querySelector('.mk-more-mn').classList.add('active');
            event.stopPropagation();
        });

        var mrclk = document.getElementById("mk-user-clk");
        mrclk.addEventListener('click', event => {
            (document.querySelector(".mk-user").classList.contains("active")) ? document.querySelector('.mk-user').classList.remove('active') : document.querySelector('.mk-user').classList.add('active');
            event.stopPropagation();
        });

        function searchItems() {
            var input, filter, li, a, i, txtValue;
            input = document.getElementById("mk-item-search");
            filter = input.value.toUpperCase();
            li = document.querySelectorAll(".mk-it-li");
            for (i = 0; i < li.length; i++) {
                a = li[i].querySelectorAll(".mk-bk-dt-ec")[0];
                txtValue = a.textContent || a.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    li[i].style.display = "inline-block";
                } else {
                    li[i].style.display = "none";
                }
            }

            /*Parent hide if childs hidden*/
            var par = document.querySelectorAll(".mk-ic-e");
            for (j = 0; j < par.length; j++) {
                var chd = par[j].querySelectorAll(".mk-it-li");
                for (k = 0; k < chd.length; k++) {
                    if (!(isHidden(chd[k]))) {
                        par[j].style.display = "block";
                    } else {
                        par[j].style.display = "none";
                    }
                }
            }

        }

        function isHidden(el) {
            var style = window.getComputedStyle(el);
            return ((style.display === 'none') || (style.visibility === 'hidden'))
        }
    </script>
</body>

</html>