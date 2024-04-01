<%@ page import="com.chainsys.library.model.Books" %>
<%@ page import="com.chainsys.library.model.User" %>
<%@ page import="com.chainsys.library.model.Cart" %>
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

<body class="mk-home">
    <header>
        <div class="mk-logo">
            <img src="../img/mk.png" />
            <span class="mk-logo-text">mindKey</span>
        </div>
    </header>
    <div class="mk-main">
        <div class="mk-cart-main mkclear">
            <div class="mk-cr-l">
                <h4><i class="fa fa-cart-arrow-down"></i> <span>My cart</span></h4>
                <div class="mk-cr-tb-main">
                    <div class="mk-cr-tb-hd">
                        <table>
                            <tr>
                                <th colspan="2" class="c1">Book</th>
                                <th class="c2">Author</th>
                                <th class="c3">Price</th>
                                <th class="c4"></th>
                            </tr>
                        </table>
                    </div>
                    <div class="mk-cr-tb-bd mk-scroll">
                        <%
    List<Cart> cart =(List<Cart>) request.getAttribute("cart");
        %>
                        <table> <% 
                        double totalPrice = 0.0;
                        for(Cart carts : cart){
                           totalPrice += carts.getTotalPrice();
                            %>
                            <tr>
                                <td class="c1"><img src="../book/<%=carts.getPhotoName()%>" /></td>
                                <td class="c2"><%=carts.getBookName()%></td>
                                <td class="c3"><%=carts.getAuthor()%></td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i><span><%=carts.getPrice()%></span></td>
                                <td class="c5"><a href="/removeBook?cid=<%=carts.getCartId() %>&&uid=<%=carts.getUserId() %>"><i class="fa fa-trash-can"></i></a></td>
                            </tr>
                            <%}%>
                            <!-- <tr>
                                <td class="c1"><img src="../img/bk2.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i><span>500</span></td>
                                <td class="c5"><i class="fa fa-trash-can"></i></td>
                            </tr>
                            <tr>
                                <td class="c1"><img src="../img/bk2.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i><span>500</span></td>
                                <td class="c5"><i class="fa fa-trash-can"></i></td>
                            </tr>
                            <tr>
                                <td class="c1"><img src="../img/bk2.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i><span>500</span></td>
                                <td class="c5"><i class="fa fa-trash-can"></i></td>
                            </tr> -->
                        </table>
                    </div>
                </div>
            </div>
            <div class="mk-cr-r">
                <div class="mk-cr-orderdetails">
                    <h4>Order Summary</h4>
                    <div class="mkclear mk-cr-ode">
                        <span class="mk-cr-olbl">Sub Total</span>
                        <span class="mk-cr-oc">
                            <i class="fa fa-indian-rupee-sign"></i><span><%=totalPrice %></span>
                        </span>
                    </div>
                    <div class="mkclear mk-cr-ode">
                        <span class="mk-cr-olbl">Discount</span>
                        <span class="mk-cr-oc">
                            <i class="fa fa-indian-rupee-sign"></i><span>100</span>
                        </span>
                    </div>
                    <div class="mkclear mk-cr-ode">
                        <span class="mk-cr-olbl">Tax</span>
                        <span class="mk-cr-oc">
                            <i class="fa fa-indian-rupee-sign"></i><span>100</span>
                        </span>
                    </div>
                    <div class="mkclear mk-cr-ode">
                        <span class="mk-cr-olbl">Shipping</span>
                        <span class="mk-cr-oc"><span class="mk-f">Free</span></span>
                    </div>
                    <div class="mkclear mk-cr-ode mk-t">
                        <span class="mk-cr-olbl">Total</span>
                        <span class="mk-cr-oc">
                            <i class="fa fa-indian-rupee-sign"></i><span><%=totalPrice %></span>
                        </span>
                    </div>
                    <div class="mkclear mk-cr-ode">
                        <a href="#" id="mk-cr-checkout" class="mk-cr-checkout">Proceed to Checkout</a>
                        <a href="/userHome?uid=${userobj.id}" class="mk-cr-contshp">Continue Shopping</a>
                    </div>
                    <div class="mkclear mk-cr-ode mk-cr-deldate">
                        <span class="mk-e">Estimated Delivery by </span><span class="mk-d">10 April, 2024</span>
                    </div>
                </div>
                <div class="mk-coup">
                    <h4>Have a coupon?</h4>
                    <input type="text" placeholder="Coupon Code" />
                    <a href="#">Apply</a>
                </div>
            </div>
        </div>
    </div>
    <div class="mk-pop">
        <div id="mk-pop-overlay" class="mk-overlay"></div>
        <div class="mk-content">
            <h4>Delivery Details <a href="#" id="mk-pop-close"><i class="fa fa-xmark"></i></a></h4>
            <form action="/order" method="get">
                <input type="hidden" value="${userobj.id}" name="id">
            <div class="mk-cr-bx-ip mkclear">
                <div class="mk-cr-bx-ipe">
                    <label>Name</label>
                    <input type="text" value="${userobj.userName}" name="name" placeholder="Enter your username" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Email</label>
                    <input type="text" value="${userobj.email}" name="email" placeholder="Enter your email" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Phone Number</label>
                    <input type="number" value="${userobj.phoneNumber}" name="phoneNumber" placeholder="Enter your phone number" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Address</label>
                    <input type="text" name="address" placeholder="Enter your address" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Landmark</label>
                    <input type="text" name="landmark" placeholder="Enter your landmark" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>City</label>
                    <input type="text" name="city" placeholder="Enter your city" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>State</label>
                    <input type="text" name="state" placeholder="Enter your state" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Pincode</label>
                    <input type="number" name="pincode" placeholder="Enter your pincode" />
                </div>
                <div class="mk-cr-bx-ipe">
                    <label>Payment Mode</label>
                    <span class="mk-cod-opt">
                        <i class="fa fa-house-circle-check"></i>
                        <span class="mk-cod">Cash On Delivery</span>
                    </span>
                </div>

            </div>
            <div class="mkclear mk-order-conf-main">
                <span class="mk-order-conf-tl">Total <i class="fa fa-indian-rupee-sign"></i><span><%=totalPrice %></span></span>
               <!-- <a href="#" class="mk-cr-order-clk">Checkout</a>-->
                <button class="mk-cr-order-clk" type="submit">Checkout</button>
            </div>
        </div>
        </form>
    </div>
    <footer>
        <p> &#169; Developed By Noorullah</p>
    </footer>

    <script type="text/javascript">
        var checkout = document.getElementById("mk-cr-checkout");
        checkout.addEventListener('click', event => {
            (document.querySelector(".mk-pop").classList.contains("active")) ? document.querySelector('.mk-pop').classList.remove('active') : document.querySelector('.mk-pop').classList.add('active');
            event.stopPropagation();
        });

        var popcloseclk = document.getElementById("mk-pop-close");
        popcloseclk.addEventListener('click', event => {
            document.querySelector('.mk-pop').classList.remove('active');
            event.stopPropagation();
        });

        var popcloseclk = document.getElementById("mk-pop-overlay");
        popcloseclk.addEventListener('click', event => {
            document.querySelector('.mk-pop').classList.remove('active');
            event.stopPropagation();
        });
    </script>
</body>

</html>