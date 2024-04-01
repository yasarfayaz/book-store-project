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
                <link href="../fonts/fontawesome/css/all.css" rel="stylesheet" />
                <link rel="icon" href="../img/mindkey_logo.png" type="image/png">
            </head>

            <body class="mk-ai right-active">
                <header>
                    <div class="mk-logo">
                        <img src="../img/mk.png" />
                        <span class="mk-logo-text">mindKey</span>
                    </div>
                </header>
                <div class="mk-main">
                    <div class="mk-ai-main">
                        <div class="mk-ai-l">
                            <h4>
                                <i class="fa fa-swatchbook"></i> <span>Books</span>
                                <a href="#" id="mk-add-book-open-clk" class="mk-add-book-open-clk"><i
                                        class="fa fa-plus"></i></a>
                            </h4>
                            <% List<Books> book =(List<Books>) request.getAttribute("book_list");
                                    %>
                                    <div class="mk-ai-tb-main">
                                        <div class="mk-ai-tb-hd">
                                            <table>
                                                <tr>
                                                    <th class="c1">Image</th>
                                                    <th class="c2">Name</th>
                                                    <th class="c3">Author</th>
                                                    <th class="c4">Price</th>
                                                    <th class="c5">Category</th>
                                                    <th class="c6">Status</th>
                                                    <th class="c7">Year</th>
                                                    <th class="c8">Instock</th>
                                                    <th class="c9"></th>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="mk-cr-ai-bd mk-scroll">
                                            <table>
                                                <% for(Books books : book){ %>
                                                    <tr>
                                                        <td class="c1"><img src="../book/<%=books.getPhotoName()%>" />
                                                        </td>
                                                        <td class="c2">
                                                            <%=books.getBookName()%>
                                                        </td>
                                                        <td class="c3">
                                                            <%=books.getAuthor()%>
                                                        </td>
                                                        <td class="c4"><i class="fa fa-indian-rupee-sign"></i>
                                                            <%=books.getPrice()%>
                                                        </td>
                                                        <td class="c5">
                                                            <%=books.getBookCategory()%>
                                                        </td>
                                                        <td class="c6">
                                                            <%=books.getStatus()%>
                                                        </td>
                                                        <td class="c7">
                                                            <%=books.getPublishedYear()%>
                                                        </td>
                                                        <td class="c8">
                                                            <%=books.getQtyInstock()%>
                                                        </td>
                                                        <td class="c9"><a
                                                                href="/updateBooks?id=<%=books.getBookId() %>"><i
                                                                    class="fa fa-pen"></i></a><a
                                                                href="/deleteBook?id=<%=books.getBookId() %>"><i
                                                                    class="fa fa-trash-can"></i></a></td>
                                                    </tr>
                                                    <%}%>
                                                        <!-- <tr>
                                <td class="c1"><img src="../img/bk1.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i> 500</td>
                                <td class="c5">New Arrival</td>
                                <td class="c6">Active</td>
                                <td class="c7">2000</td>
                                <td class="c8">30</td>
                                <td class="c9"><a href="#"><i class="fa fa-pen"></i></a><a href="#"><i
                                            class="fa fa-trash-can"></i></a></td>
                            </tr>
                            <tr>
                                <td class="c1"><img src="../img/bk2.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i> 500</td>
                                <td class="c5">New Arrival</td>
                                <td class="c6">Active</td>
                                <td class="c7">2000</td>
                                <td class="c8">30</td>
                                <td class="c9"><a href="#"><i class="fa fa-pen"></i></a><a href="#"><i
                                            class="fa fa-trash-can"></i></a></td>
                            </tr>
                            <tr>
                                <td class="c1"><img src="../img/bk1.jpg" /></td>
                                <td class="c2">Relativity - The Special And General Theory</td>
                                <td class="c3">Albert Einstein</td>
                                <td class="c4"><i class="fa fa-indian-rupee-sign"></i> 500</td>
                                <td class="c5">New Arrival</td>
                                <td class="c6">Active</td>
                                <td class="c7">2000</td>
                                <td class="c8">30</td>
                                <td class="c9"><a href="#"><i class="fa fa-pen"></i></a><a href="#"><i
                                            class="fa fa-trash-can"></i></a></td>
                            </tr> -->
                                            </table>
                                        </div>
                                    </div>
                        </div>
                        <% Books books=(Books) request.getAttribute("bookFound"); %>
                        <div class="mk-ai-overlay"></div>
                        <form action="/updateBookData" method="get">
                            <div class="mk-ai-r">
                                <div class="mk-ai-r-main">
                                    <!-- <h4>Add Books<a href="#" class="mk-add-book-save"><i class="fa-solid fa-floppy-disk"></i></a></h4> -->
                                    <h4>Update Books<button class="mk-add-book-save" type="submit"><i
                                                class="fa-solid fa-floppy-disk"></i></button></h4>
                                    <div class="mk-ai-bx-ip  mk-scroll">
                                        <div class="mk-ai-bx-ipe">
                                            <label>Book Id</label>
                                            <input type="number" name="bookId" value="<%=books.getBookId()%>" placeholder="Enter book name" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Book Name</label>
                                            <input type="text" name="bookName" value="<%=books.getBookName()%>" placeholder="Enter book name" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Author</label>
                                            <input type="text" name="author" value="<%=books.getAuthor()%>" placeholder="Enter author name" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Price</label>
                                            <input type="number" name="price" value="<%=books.getPrice()%>" placeholder="Enter price" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Published Year</label>
                                            <input type="text" name="publishedYear" value="<%=books.getPublishedYear()%>" placeholder="Enter year" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Quantity</label>
                                            <input type="text" name="qtyInstock" value="<%=books.getQtyInstock()%>" placeholder="Enter quantity" />
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Category</label>
                                            <select name="bookCategory">
                                                <option>Course</option>
                                                <option>Comics</option>
                                                <option>Historical</option>
                                                <option>Mystery</option>
                                                <option>Science Fiction</option>
                                                <option>Horror</option>
                                                <option>Adventure</option>
                                            </select>
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Status</label>
                                            <select name="status">
                                                <option>Active</option>
                                                <option>Inactive</option>
                                            </select>
                                        </div>
                                        <div class="mk-ai-bx-ipe">
                                            <label>Upload</label>
                                            <label for="mk-upd-img">
                                                <div class="mk-file-upload">
                                                    <i class="fa-solid fa-cloud-arrow-up"></i>
                                                    <span id="mk-upd-img-name"><%=books.getPhotoName()%></span>
                                                    <input id="mk-upd-img" name="photoName" value="<%=books.getPhotoName()%>" type="file" />
                                                </div>
                                            </label>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <footer>
                    <p> &#169; Developed By Noorullah</p>
                </footer>

                <script type="text/javascript">
                    var imgupd = document.getElementById("mk-upd-img");
                    var imgn = document.getElementById("mk-upd-img-name");
                    imgupd.addEventListener("change", function (e) {
                        var fileName = e.target.files[0].name;
                        imgn.innerHTML = fileName;
                    });


                    var rightpanelopen = document.getElementById("mk-add-book-open-clk");
                    rightpanelopen.addEventListener('click', event => {
                        (document.querySelector(".mk-ai").classList.contains("right-active")) ? document.querySelector('.mk-ai').classList.remove('right-active') : document.querySelector('.mk-ai').classList.add('right-active');
                        event.stopPropagation();
                    });
                </script>
            </body>

            </html>