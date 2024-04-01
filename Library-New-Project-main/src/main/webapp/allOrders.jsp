<%@ page import="com.chainsys.library.model.User" %>
<%@ page import="com.chainsys.library.model.Order" %>
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
    <link href="../fonts/fontawesome/css/all.css" rel="stylesheet" />
    <link rel="icon" href="../img/mindkey_logo.png" type="image/png">
</head>

<body class="mk-ai">
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
                    <span>Ahamed</span>
                </div>
                <div class="mk-user-info-e">
                    <i class="fa-solid fa-envelope"></i>
                    <span>ahamednoorullah@gmail.com</span>
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
        <div class="mk-ao-main">
            <div class="mk-ao-l">
                <h4>
                    <a class="mk-ad-home" href="/adminHome" title="Home" class="mk-home-clk"><i class="fa fa-home"></i></a>
                    <i class="fa fa-swatchbook"></i> <span>All Orders</span>
                </h4>
                <% List<Order> order =(List<Order>) request.getAttribute("allOrder");
                        %>
                <div class="mk-ao-tb-main">
                    <div class="mk-ao-tb-hd">
                        <table>
                            <tr>
                                <th class="c1">Order ID</th>
                                <th class="c2">Name</th>
                                <th class="c3">Email</th>
                                <th class="c4">Address</th>
                                <th class="c5">Ph No</th>
                                <th class="c6">Book Name</th>
                                <th class="c7">Author</th>
                                <th class="c8">Price</th>
                                <th class="c9">Payment Type</th>
                            </tr>
                        </table>
                    </div>
                    <div class="mk-cr-ao-bd mk-scroll">
                        <table>
                            <% for(Order orders : order){ %>
                            <tr>
                                <td class="c1"><%=orders.getOrderId()%></td>
                                <td class="c2"><%=orders.getUserName()%></td>
                                <td class="c3"><%=orders.getEmail()%></td>
                                <td class="c4"><%=orders.getFullAdd()%></td>
                                <td class="c5"><%=orders.getPhoneNumber()%></td>
                                <td class="c6"><%=orders.getBookName()%></td>
                                <td class="c7"><%=orders.getAuthor()%></td>
                                <td class="c8"><%=orders.getPrice()%></td>
                                <td class="c9"><%=orders.getPaymentType()%></td>
                            </tr>
                            <%}%>
                            <!-- <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>

                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Noorullah</td>
                                <td class="c3">noorullah@gmail.com</td>
                                <td class="c4">95, Third street, Tambaram</td>
                                <td class="c5">9876543210</td>
                                <td class="c6">JAVA</td>
                                <td class="c7">Robert</td>
                                <td class="c8">320</td>
                                <td class="c9">COD</td>
                            </tr> -->
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <p> &#169; Developed By Noorullah</p>
    </footer>

    <script type="text/javascript">
           var mrclk = document.getElementById("mk-user-clk");
            mrclk.addEventListener('click', event => {
                (document.querySelector(".mk-user").classList.contains("active")) ? document.querySelector('.mk-user').classList.remove('active') : document.querySelector('.mk-user').classList.add('active');
                event.stopPropagation();
            });
    </script>
</body>

</html>