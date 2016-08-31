<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<c:set var="login" scope="session" value="${sessionScope.login}"/>
<c:set var="sname" scope="session" value="${sessionScope.userName}"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Los Pollos Hermanos</title>
    <spring:url value="/resources/images" var="CoreImages" />
    <spring:url value="/resources/css" var="CoreCSS" />
    <spring:url value="/resources/fonts" var="Fonts" />
    <link rel="shortcut icon" href="${CoreImages}/logo.png" >
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${CoreCSS}/navbar.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        @font-face
        {
            font-family: Burito;
            src: url('${Fonts}/JI Burrito.ttf');
        } 
    </style>
  </head>
<body>
    <nav class="navbar navbar-default" role="navigation" style="background-color: #fddb00">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a class="navbar-brand" href="${contextPath}" style="font-size: 35px; font-weight: bold; font-family: 'Burito', sans-serif;">Los Pollos Hermanos</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

      <c:choose>
      <c:when test="${not empty sessionScope.userName}">
        <ul class="nav navbar-nav navbar-right">
          <li><div class="navbar-form">
              <a href="${contextPath}/mycart" type="button" class="btn btn-danger">My Cart&nbsp;<span class="badge">${fn:length(cart.getList())}</span></a>
              </div></li>
          <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${sessionScope.userName}<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/user/myaccount">My Account</a></li>
                <li><a href="${pageContext.request.contextPath}/user/myorders">My orders</a></li>
                 <li><a href="user/faq">FAQ</a></li>
                <li class="divider"></li>
                <li><a href="${pageContext.request.contextPath}/userout">Logout</a>
</form></li>
      </ul>
        </c:when>
      <c:otherwise >
      <ul class="nav navbar-nav navbar-right">
      <li>
      <div class="navbar-form ">
      <a href="signup" type="submit" class="btn btn-danger">Sign Up</a>
      </div>
      </li>
      <li>
      <form class="navbar-form "  action="user" method="POST">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="username" name="userName">
          <input type="password" class="form-control" placeholder="password" name="password">     
        </div>
        <button type="submit" class="btn btn-danger">Sign In</button>
      </form>
      </li>
      </ul>
      </c:otherwise>
      </c:choose>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="row">
<div class="col-md-3" style="text-align: center;">
    <br/><br/><br/>
    <img src="${CoreImages}/logo.png" width="200">
</div>
<div class="col-md-6">
<div class="row">
       <nav class="navbar navbar-default" role="navigation" style="background-color: #cf112b; border-radius: 10px;">
  <div class="container-fluid" style="background-color: #cf112b; border-radius: 10px; ">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" style="background-color: #cf112b" id="bs-example-navbar-collapse-2">
      <ul class="nav navbar-nav" style="background-color: #cf112b">
        <li style="background-color: #cf112b"><a style="background-color: #fddb00; color: #cf112b; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif;" href="${contextPath}">ALL</a></li>
        <li><a style="color:white; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif; " href="${contextPath}/category/food">FOOD</a></li>
        <li><a style="color:white; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif; " href="${contextPath}/category/meals">MEALS</a></li>
        <li><a style="color:white; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif; " href="${contextPath}/category/beverage">BEVERAGE</a></li>
        <li><a style="color:white; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif;" href="${contextPath}/category/sweets">SWEETS</a></li>
        <li><a style="color:white; font-size: 24px; font-weight: bold; font-family: 'Burito', sans-serif;" href="${contextPath}/category/special">SPECIAL</a></li>

      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
                <div class="row">
                    <div class="row-fluid" style="text-align: center;"><h1><div style="font-family: 'Burito', sans-serif; font-weight: bold; color:#cf112b;">MY CART</div></h1><br></div>
                    <div class="row-fluid">
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" style="text-align: center;" role="alert">${message}</div>
                        </c:if>
                        <div class="col-md-1"></div>
                        <div class="col-md-10" style=" border: 0 none;">
                            <c:choose>
                            <c:when test="${empty cart.getList()}">
                                 <div class="alert alert-warning" role="alert">The shopping cart is empty</div>
                            </c:when>
                            <c:otherwise>

                            <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th></th>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Pieces</th>
                                    <th>Total Price</th>
                                    <th></th>
                                </tr>
                                <c:forEach var="item" items="${products}" varStatus="loop">  
                                    <tr>  
                                     <td><img src="${CoreImages}/${item.getProduct().getImage()}" width="50"></td>
                                     <td>${item.getProduct().getName()}</td>  
                                     <td>${item.getProduct().getPrice()}</td>  
                                     <td>
                                         <form action="${contextPath}/product/updatetocart" class="navbar-form">
                                            <input type="hidden" name="id" value="${item.getId()}">
                                            <div class="input-group">
                                            <input type="text" pattern="\d*" class="form-control" name="n" value="${item.getPcs()}" style="width:50px;">
                                            <span class="input-group-btn">
                                            <button type="submit" class="btn btn-default" value="update">Update</button>
                                            </span>
                                            </div>
                                        </form>
                                     </td>
                                     <td><fmt:formatNumber type="number" value="${item.getPcs()*item.getProduct().getPrice()}" />
                                     </td>
                                     <td>
                                         <form action="${contextPath}/product/removefromcart" class="navbar-form">
                                            <input type="hidden" name="id" value="${item.getId()}">
                                            <button type="submit" class="btn btn-default" value="remove">Remove</button>
                                        </form>
                                     </td> 

                                 </tr> 
                                </c:forEach>  
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><b>$<fmt:formatNumber type="number" value="${cart.TotalPrice()}"/></b></td>
                                </tr>
                            </table>
                            </div>
                            <br/>
                            <form action="${pageContext.request.contextPath}/checkout" method="post">
                            <h3><div style="font-family: 'Burito', sans-serif; font-weight: bold; color:#cf112b;">Delivery Details</div></h3>
                            <table class="table"> 
                                <tr>
                                     <td align="left" width="20%">Shipping Address: </td>
                                     <td align="left" width="20%"><input  class="form-control" name="address"></td>
                                     <c:if test="${not empty addresses}">
                                     <td align="left" width="20%">  
                                        <select class="form-control" name="address2">
                                            <c:forEach var="address" items="${addresses}" varStatus="loop">  
                                                <option value="${address}">${address}</option>
                                            </c:forEach>
                                        </select>
                                  </td>
                                     </c:if>
                                     </tr>
                                   <tr>    
                                   <td align="left" width="20%"><label for="payment">Payment Method :</label></td>
                                  <td align="left" width="20%">  
                                    <select class="form-control" name="payment">
                                  <option value="0">-</option>
                                   <option value="1">MasterCard</option>
                                   <option value="2">Visa</option>
                                   <option value="3">American Express</option>
                                   </select>
                                  </td>
                                   </tr>
                            </table>  
                            <div style="float: right;"><button type="submit" class="btn btn-default btn-lg" value="checkout">Check Out</button></div>
                            </form>
                            </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
               
                </div>
</div>
</div>
        <div class="col-md-3" style="text-align: center;">
    <br/><br/><br/>
    <img src="${CoreImages}/logo.png" width="200">
</div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </body>
</html>
