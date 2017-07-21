<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Subscription" %><%--
  Created by IntelliJ IDEA.
  User: Prashant
  Date: 16-Jul-17
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <spring:url value="resources/css/dashboard.css" var="dashboardCss" />
    <link href="${dashboardCss}" rel="stylesheet" />


    <!-- Latest compiled and minified JavaScript -->
</head>
<body>
<div class="container">
    <div class="row head">
        <div class="col-md-2">
            <a class="head-icon" style="float: left; margin-top: 13px;">LINK
                SHARING</a>
        </div>
<a href="/logout" method="post">Logout</a>
        <div class="col-lg-offset-3 col-lg-5">
            <div class="row">
                <div class="col-lg-6 search">
                    <i class="fa fa-search" aria-hidden="true"></i> <input type="text"
                                                                           class="search_border " placeholder="search" /> <span
                        class="glyphicon glyphicon-remove-sign  cross"></span>
                </div>

                <div class="col-lg-1">
                    <i class="fa fa-comment head-icon" aria-hidden="true"
                       style="font-size: 26px;" data-toggle="modal" data-target="#CreateTopic"></i>
                </div>
                <div class="col-lg-1">
                    <i class="fa fa-envelope-o head-icon" aria-hidden="true"
                       style="font-size: 26px;" data-toggle="modal" data-target="#SendInvite"></i>
                </div>
                <div class="col-lg-1">
                    <i class="fa fa-link head-icon" aria-hidden="true"
                       style="font-size: 26px;" data-toggle="modal" data-target="#shareLink"></i>
                </div>
                <div class="col-lg-1">
                    <i class="fa fa-file-o head-icon" aria-hidden="true"
                       style="font-size: 26px;" data-toggle="modal" data-target="#shareDocument"></i>
                </div>
            </div>
        </div>
        <div class="col-lg-2">
            <div class="col-lg-1">
                <i class="fa fa-user head-icon" style="font-size: 26px;"
                   aria-hidden="true"></i>
            </div>
            <div class="col-lg-2">
                <button class="btn-xs drop_button dropdown-toggle head-btn"
                        data-placement="left" data-toggle="dropdown">
                    Uday <span class="caret"></span>
                </button>
                <ul class="dropdown-menu user-ul">
                    <li><a href="#">Profile</a></li>
                    <li><a href="#">Users</a></li>
                    <li><a href="#">Topic</a></li>
                    <li><a href="#">Post</a></li>
                    <li><a href="#">Logout</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="row row2">



        <div class="col-lg-5">
            <div class="row form">
                <div class="col-lg-12 i-div">

                    <div class="row">
                        <div class="col-lg-3">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-9">
                            <ul>
                                <% User userData = (User)request.getSession(true).getAttribute("userData");
                                %>

                                <li><span class="name-font"><%= userData.getUsername() %></span></li>
                                <li class="name-margin"><small>@<%= userData.getFirstname()%></small></li>

                            </ul>
                            <table class="Subscribe-table">
                                <tr class="table-head-row">
                                    <td>Subscription</td>
                                    <td>Topic</td>
                                </tr>
                                <tr>
                                    <td><a href="#"><%=(Long)request.getSession(true).getAttribute("subscription")%></a></td>
                                    <td><a href="#"><%=(Long)request.getSession(true).getAttribute("topics")%></a></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-lg-7">
            <div class="row form">
                <div class="col-lg-12 i-div">
                    <div class="row">
                        <div class="col-lg-12 subform">Inbox</div>
                    </div>
                    <div class="row">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-10">
                            <ul>
                                <li><span>Uday Pratap Singh</span> <small>@uday
                                    5min</small> <a class="a-right" href="#" class="anchor">Grails</a></li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Minima maxime quam architecto quo inventore harum ex
                                    magni, dicta impedit.</li>
                                <li class="li-a"><i class="fa fa-facebook-square" href="#"
                                                    aria-hidden="true"></i> <i class="fa fa-tumblr"
                                                                               aria-hidden="true"></i> <i class="fa fa-google-plus"
                                                                                                          aria-hidden="true"></i>
                                    <div class="li-div">
                                        <a href="#">Download</a> <a href="#">View full site</a>
                                        </nbsp>
                                        <a href="#">Mark as read</a> <a href="#">View Post</a>
                                    </div></li>

                            </ul>
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-2">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-10">
                            <ul>
                                <li><span>Uday Pratap Singh</span> <small>@uday
                                    5min</small> <a class="a-right" href="#" class="anchor">Grails</a></li>
                                <li>Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Minima maxime quam architecto quo inventore harum ex
                                    magni, dicta impedit.</li>
                                <li class="li-a"><i class="fa fa-facebook-square"
                                                    aria-hidden="true"></i> <i class="fa fa-tumblr"
                                                                               aria-hidden="true"></i> <i class="fa fa-google-plus"
                                                                                                          aria-hidden="true"></i>
                                    <div class="li-div">
                                        <a href="#">Download</a> <a href="#">View full site</a>
                                        </nbsp>
                                        <a href="#">Mark as read</a> <a href="#">View Post</a>
                                    </div></li>
                                <li><a href="#"></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <% List<Subscription> displaySub = (List)request.getSession(true).getAttribute("displaySub");
        %>
        <div class="col-lg-5 Subscribe-div-head">
            <div class="row form">
                <div class="col-lg-12 i-div">
                    <div class="row">
                        <div class="col-lg-12 subform">Subscription <a class="a-right">View All</a></div>
                    </div>


                    <%
                        int i=0;
                        for(Subscription sub:displaySub){

//                        User u = (User)request.getSession(true).getAttribute("userid");
                        int curUserId=2;
                        if(sub.getTopic().getUser().getUserid()==sub.getUser().getUserid())
                        {
                            if(sub.getUser().getUserid()==curUserId && i<5) {
                                i++;
                    %>

                    <div class="row">
                        <div class="col-lg-3">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-9">
                            <ul>
                                <li><a href="#" class="anchor">Grails</a></li>

                            </ul>
                            <table class="Subscribe-table">
                                <tr class="table-head-row">
                                    <td>@Uday</td>
                                    <td>Subscriptions</td>
                                    <td>Post</td>
                                </tr>
                                <tr>
                                    <td><a>Unsubscribe</a></td>
                                    <td>50</td>
                                    <td>30</td>
                                </tr>
                            </table>
                            <select>
                                <option>Serious</option>
                            </select>
                            <select>
                                <option>Delete</option>
                                <option>Edit</option>
                                <option>Private</option>
                            </select>
                            <i class="fa fa-envelope-o" aria-hidden="true"></i>
                            <i class="fa fa-file-o" aria-hidden="true"></i>
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </div>
                    </div>
                    <hr/>


                                <%

                            }
                        }
                        else{
                            if(sub.getUser().getUserid()==curUserId) {
                                %>

                    <div class="row">
                        <div class="col-lg-3">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-9">
                            <ul>
                                <li><a href="#" class="anchor">Grails</a></li>

                            </ul>
                            <table class="Subscribe-table">
                                <tr class="table-head-row">
                                    <td>@Uday</td>
                                    <td>Subscriptions</td>
                                    <td>Post</td>
                                </tr>
                                <tr>
                                    <td><a>Unsubscribe</a></td>
                                    <td>50</td>
                                    <td>30</td>
                                </tr>
                            </table>
                            <div class="Subscribe-div">
                                <select>
                                    <option>Serious</option>
                                </select>

                                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                            </div>
                            <br><br>
                        </div>
                    </div>




                                <%
                            }
                        }
                    %>




                    <%
                    }
                    %>




                </div>
            </div>

        </div>



       <%-- <div class="col-lg-5 share-div-head">
            <div class="row form">
                <div class="col-lg-12 i-div">
                    <div class="row">
                        <div class="col-lg-12 subform">Share Link (Pop up)</div>
                    </div>
                    <div class="row">

                        <form class="form-horizontal reg-form">

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Link*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" placeholder="Link" />
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Description*</label>
                                <div class="col-sm-8">
                                    <textarea  class="form-control" rows="4" placeholder="Description"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Topic*</label>
                                <div class="col-sm-8">
                                    <select>
                                        <option>Topic</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-offset-5 col-lg-8">
                                <button type="button" class=" btn-xs">Share</button>
                                <button type="button" class=" btn-xs">Cancel</button>
                            </div>
                            <br>
                            <br>
                        </form>


                    </div>
                </div>
            </div>
        </div>

--%>

        <div class="col-lg-5 Subscribe-div-head">
            <div class="row form">
                <div class="col-lg-12 i-div">
                    <div class="row">
                        <div class="col-lg-12 subform">Trending Topics</div>
                    </div>

                    <div class="row">
                        <div class="col-lg-3">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-9">
                            <ul>
                                <li><a href="#" class="anchor">Grails</a></li>

                            </ul>
                            <table class="Subscribe-table">
                                <tr class="table-head-row">
                                    <td>@Uday</td>
                                    <td>Subscriptions</td>
                                    <td>Post</td>
                                </tr>
                                <tr>
                                    <td><a>Subscribe</a></td>
                                    <td>50</td>
                                    <td>30</td>
                                </tr>
                            </table>


                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-lg-3">
                            <img class="img-responsive" src="user.png" alt="dummy">
                        </div>
                        <div class="col-lg-9">
                            <ul>
                                <li>
                                    <input type="text" value="Grails" style="width: 130px" />
                                    <div style="display: inline;">
                                        <button type="button" class=" btn-xs" style="width: 60px">Save</button>
                                        <button type="button" class=" btn-xs" style="width: 60px">Cancel</button>
                                    </div>
                                </li>

                            </ul>
                            <table class="Subscribe-table">
                                <tr class="table-head-row">
                                    <td>@Uday</td>
                                    <td>Subscriptions</td>
                                    <td>Post</td>
                                </tr>
                                <tr>
                                    <td><a>Unsubscribe</a></td>
                                    <td>50</td>
                                    <td>30</td>
                                </tr>
                            </table>
                            <select>
                                <option>Serious</option>
                            </select>
                            <select>
                                <option>Delete</option>
                                <option>Edit</option>
                                <option>Private</option>
                            </select>
                            <i class="fa fa-envelope-o" aria-hidden="true"></i>
                            <i class="fa fa-file-o" aria-hidden="true"></i>
                            <i class="fa fa-trash" aria-hidden="true"></i>
                        </div>
                    </div>
                    <br>

                </div>
            </div>

        </div>

        <!--Share Link-->
        <!--Share Link Modal-->
        <div id="shareLink" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Share Link (Pop up)</h4>
                    </div>

                    <div class="modal-body">
                        <form >
                            <div class="form-group">
                                <label class="sr-only">Link</label>
                                <input class="form-control" type="text" placeholder="Link" id="link" />
                           </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left" >Description*</label>

                                <textarea  class="form-control" rows="4" placeholder="Description" id="descriptionLink"></textarea>

                            </div>

                            <div class="form-group">
                                <select name='topic' id="topicLink">
                                    <c:forEach items="${topicname}" var="topicname">
                                        <option value="${topicname}">${topicname}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="form-group">
                                <input type="button" name="Share" id="shareLinkBtn" class="btn btn-primary"/>
                                <input type="button" name="Cancel" id="cancelLinkBtn" data-dismiss="modal" class="btn btn-primary"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!--Share Document Modal-->
        <div id="shareDocument" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Share Document (Pop up)</h4>
                    </div>

                    <div class="modal-body">
                        <form >
                            <div class="form-group">
                                <label class="sr-only">Document</label>
                                <input class="form-control" type="file" name="document" id="document"/>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Description*</label>

                                    <textarea  class="form-control" rows="4" placeholder="Description" id="description"></textarea>

                            </div>

                            <div class="form-group">
                                <select name='topic' id="topicDocument">
                                    <c:forEach items="${topicname}" var="topicname">
                                        <option value="${topicname}">${topicname}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="form-group">
                                <input type="submit" name="Share" id="shareDocumentBtn" class="btn btn-primary"/>
                                <input type="submit" name="Cancel" id="cancel1" data-dismiss="modal" class="btn btn-primary"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
  <%--      <div class="col-lg-5 ">
            <div class="row form">
                <div class="col-lg-12 i-div">
                    <div class="row">
                        <div class="col-lg-12 subform">Share Document (Pop up)</div>
                    </div>
                    <div class="row">

                        <form class="form-horizontal reg-form">

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Document*</label>
                                <div class="col-sm-8">
                                    <input class="form-control" type="text" placeholder="Link" />
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Description*</label>
                                <div class="col-sm-8">
                                    <textarea  class="form-control" rows="4" placeholder="Description"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-3 font-normal" for="email" style="text-align: left">Topic*</label>
                                <div class="col-sm-8">
                                    <select>
                                        <option>Topic</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-lg-offset-5 col-lg-8">
                                <button type="button" class=" btn-xs">Share</button>
                                <button type="button" class=" btn-xs">Cancel</button>
                            </div>
                            <br>
                            <br>
                        </form>


                    </div>
                </div>
            </div>
        </div>--%>

        <%--Send Invitation Modal--%>

        <div id="SendInvite" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Send Invitation (Pop up)</h4>
                    </div>

                    <div class="modal-body">
                        <form >
                        <div class="form-group">
                            <label class="sr-only">Name</label>
                            <input class="form-control" type="email" placeholder="Email" id="email" />    </div>

                            <div class="form-group">
                                <select name='topic' id="topic">
                                    <c:forEach items="${topicname}" var="topicname">
                                            <option value="${topicname}">${topicname}</option>
                                      </c:forEach>
                                </select>

                            </div>
                            <div class="form-group">
                                <input type="submit" name="Send Invite" id="invite" class="btn btn-primary"/>
                                <input type="submit" name="Cancel" id="cancel" data-dismiss="modal" class="btn btn-primary"/>
                            </div>
                        </form>
                    </div>
              </div>
            </div>
        </div>


        <!-- Create Topic Modal -->
        <div id="CreateTopic" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Create Topic(Pop up)</h4>
                    </div>

                    <div class="modal-body">
                        <form >
                        <div class="form-group">
                            <label class="sr-only">Name</label>
                            <input class="form-control" type="text" placeholder="Name" id="name" name="name" />
                        </div>
                         <div class="form-group">
                            <select name="visibility" id="visibility">
                                <option value="PUBLIC">Public</option>
                                <option value="PRIVATE">Private</option>
                            </select>
                        </div>
                       <div class="form-group">
                            <input type="button" name="insert" id="insert" class="btn btn-primary"/>
                        </div>
                        </form>
                    </div>
              </div>
            </div>
        </div>


    </div>
</div>

<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<spring:url value="resources/js/dashboard.js" var="dashboardJs" />
<script src="${dashboardJs}"></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
        href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        rel="stylesheet">

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script>
/*
    $(document).ready(function(){
        $("#insert").click(function(e){
            var id=$(this).attr('id')
            var name = $('#name').val();
            var visibility=$('#visibility').val();
            $.post("/topic",
                {
                    name: name,
                    visibility: visibility
                },
                function(data){
                    alert('added');
                    var obj = JSON.parse(data);
                    alert("Data: " + obj.res );
                    location.reload();
                });
        });
    });

*/


</script>
</body>
</html>