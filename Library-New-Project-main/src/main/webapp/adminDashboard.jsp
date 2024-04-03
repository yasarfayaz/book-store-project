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

    <% List<Order> order =(List<Order>) request.getAttribute("allOrder");
            %>
    <% int orderCount=0;
		for (Order orderlist : order) {
			orderCount++;
		}%>
        <% int orderPendind = orderCount-26; %>
    <div class="mk-main">
        <div class="mk-ds-main">
            <div class="mk-ds-l">
                <div class="mk-ds-tp mkclear">
                    <div class="mk-e-bx mx-total-order">
                        <h4>Total Order</h4>
                        <span><%=orderCount %></span>
                    </div>
                    <div class="mk-e-bx mx-pending-order">
                        <h4>Pending Order</h4>
                        <span><%=orderPendind %></span>
                    </div>
                    <div class="mk-e-bx mx-delivered-order">
                        <h4>Delivered</h4>
                        <span><%=orderCount-orderPendind %></span>
                    </div>
                    <a href="/allBooks">
                    <div class="mk-e-bx mx-add-book">
                        <i class="fa fa-circle-plus"></i>
                        <div>Add Books</div>
                    </div>
                    </a>
                </div>

                <!----------------------------Orders--------------------------->
                
                <h4 class="mk-allord">Orders</h4>
                <div class="mk-ds-tb-main">
                    <div class="mk-ds-tb-hd">
                        <table>
                            <tr>
                                <th class="c1">Order ID</th>
                                <th class="c2">Book Name</th>
                                <th class="c3">Author</th>
                                <th class="c4">Delivery Address</th>
                            </tr>
                        </table>
                    </div>
                    <div class="mk-cr-ds-bd mk-scroll">
                        <table>
                            <% int countOrder =1; 
                            for(Order orders : order){ %>
                            <tr>
                                <td class="c1"><%=orders.getOrderId()%></td>
                                <td class="c2"><%=orders.getBookName()%></td>
                                <td class="c3"><%=orders.getAuthor()%></td>
                                <td class="c4"><%=orders.getFullAdd()%></td>
                            </tr>
                            <% countOrder++;
        if(countOrder==5){
            break;
        }
                        }%>
                            <!-- <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4">95, Third Street , Virudhunagar</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4">95, Third Street , Virudhunagar</td>
                            </tr>
                            <tr>
                                <td class="c1">BOOK-ORD-001</td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4">95, Third Street , Virudhunagar</td>
                            </tr> -->
                        </table>
                    </div>
                    <div class="mk-vao"><a href="/allOrders">View All orders</a></div>
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