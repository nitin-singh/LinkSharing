<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>


    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified JavaScript -->
    <spring:url value="resources/css/home.css" var="homeCss" />
    <link href="${homeCss}" rel="stylesheet" />
    <spring:url value="resources/js/home.js" var="homeJs" />
    <script src="${homeJs}"></script>
   </head>
<body>

<div class="container">
    <div class="row head ">
        <div class="col-lg-4">
            <div class="row">
                <div class="col-lg-2">
                    <a href="home.jsp"><img class="img-responsive logo"
                                             src="logo.jpg"/></a>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
        </div>
        <div class="col-lg-4">
            <div class="col-lg-8 search">
                <i class="fa fa-search" aria-hidden="true"></i>
                <input type="text" class="search_border " 	placeholder="search" />
                <span class="glyphicon glyphicon-remove-sign  cross"></span>
            </div>
            <div class="col-lg-4">
            </div>
        </div>
    </div>
    <div class="row row2">
        <div class="col-lg-7" >
            <div class="row ">
                <div class="col-lg-10 form">
                    <div class="row">
                        <div class="col-lg-12 subform">
                            Recent Shares
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="dummy_profil.jpg" alt="dummy">
                        </div>
                        <div class="col-lg-10">
                            <ul >
                                <li><span>Uday Pratap Singh</span> <small>@uday 5min</small> <a href="#" class="anchor">Grails</a></li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</li>
                                <li><i class="fa fa-facebook-square" href="#" aria-hidden="true"></i> <i class="fa fa-tumblr" aria-hidden="true"></i> <i class="fa fa-google-plus" aria-hidden="true"></i> <a href="#">View Post</a></li>

                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="dummy_profil.jpg" alt="dummy">
                        </div>
                        <div class="col-lg-10">
                            <ul >
                                <li><span>Uday Pratap Singh</span> <small>@uday 5min</small> <a href="#" class="anchor">Grails</a></li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</li>
                                <li><i class="fa fa-facebook-square" aria-hidden="true"></i> <i class="fa fa-tumblr" aria-hidden="true"></i> <i class="fa fa-google-plus" aria-hidden="true"></i> <a href="#">View Post</a></li>
                                <li> <a href="#"></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- LogIn-->


        <div class="col-lg-5 formRight" >
            <div class="row form-group">
                <div class="col-lg-12">
                    <div class="row" >
                        <div class="col-lg-12 subform">
                            LogIn
                        </div>
                    </div>

                    <div class="row">

                        <form class="form-horizontal reg-form" action="/login" method="post">
                            <h4>${msg}</h4>
                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Email/Username*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="Username" id="email"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="password" style="text-align: left">Password*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="password" name="Password" id="password"/>
                                </div>
                            </div>


                        <div class="col-lg-offset-3 col-lg-8 text">

                            <a href="/forgotpass" class="pull-left" ><u>forgot password</u></a>
                            <button type="submit" class=" btn-xs">LogIn</button>
                        </div>
                        </form>

                    </div>


                </div>
            </div>
        </div>
    </div>

    <!--  Register  -->
    <div class="row row3">
        <div class="col-lg-7" >
            <div class="row ">
                <div class="col-lg-10 form">
                    <div class="row heading">
                        <div class="col-lg-8 subform">
                            Top posts
                        </div>
                        <div class="col-lg-4 subform">
                            <button class="btn-xs drop_button dropdown-toggle" data-placement="left" data-toggle="dropdown" id="menu1">Select
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Today</a></li>
                                <li><a href="#">Week</a></li>
                                <li><a href="#">Month</a></li>
                                <li><a href="#">Year</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-2	">
                            <img class="img-responsive" src="images.dummy_profil.jpg" alt="dummy">
                        </div>
                        <div class="col-lg-10">
                            <ul >
                                <li><span>Uday Pratap Singh</span> <small>@uday 5min</small> <a href="#" class="anchor">Grails</a></li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minima maxime quam architecto quo inventore harum ex magni, dicta impedit.</li>
                                <li><i class="fa fa-facebook-square" aria-hidden="true"></i> <i class="fa fa-tumblr" aria-hidden="true"></i> <i class="fa fa-google-plus" aria-hidden="true"></i><a href="#">View Post</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <h3>${msg}</h3>
        <div class="col-lg-5 formRight" >
            <div class="row form-group">
                <div class="col-lg-12">
                    <div class="row" >
                        <div class="col-lg-12 subform">
                            Register
                        </div>
                    </div>

                    <div class="row">

                        <form class="form-horizontal reg-form" action="/registration" method="post" enctype="multipart/form-data" >

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left" >First Name*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="firstname" required="true" />
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Last Name*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="lastname" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Email*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="email" name="email"  required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Username*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" name="username" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Password*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="password" id="pass" name="password_" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Confirm Password*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="password" id="cnfrmPass" name="cnfrmPassword" required="true"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Photo</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="file" name="photo"/>
                                </div>
                            </div>
                            <button type="submit" class=" btn-xs" onclick="return check()">Register</button>
                        </form>
                  </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
<%--<script src="resources/js/home.js" ></script>--%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</body>
</html>