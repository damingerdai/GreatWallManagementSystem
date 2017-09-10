<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/index" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <title>长城内部流程管理系统</title>
    <tags:style></tags:style>
<body>
    <nav>
        <div id="Head">
            <div id="Head_logo">
                <div id="LOGO_left"></div>
                <div id="LOGO"><img src="img/LoginImg/toplogo.png" /></div>
                <div id="LOGO_End"></div>
            </div>
            <div id="Head_right">
                <table height="88">
                    <tr><td colspan="2"></td></tr>
                    <tr>
                        <td id="TimeArea"><div id="ShowTime"></div></td>
                        <td id="BottonArea">
                            <div id="right_begin"></div>
                            <div id="right_back">
                                <table>
                                    <tr>
                                        <td align="center" style="width: 16px">
                                            <span class="ui-write person"></span>
                                        </td>
                                        <td align="center">admin，您好！
                                            <!--
                                            <script >
                                              document.write(tr+"，您好！");
                                            </script>
                                            -->
                                        </td>
                                        <td align="center" style="width:18px"><img src="img/images/yline.jpg" /></td>
                                        <td align="center" style="width: 16px">
                                            <span class="ui-write power"></span>
                                        </td>
                                        <td align="center">
                                            <a style="color: #ffffff; background-color: Transparent"  href="login.html" target="_parent">退出系统</a>
                                        </td>
                                    </tr>
                                </table>

                            </div>
                            <div id="right_end"></div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </nav>

    <div id="Menu" >
        <ul id="MenuUl">

            <li class="level1">
                <div onClick="menuClick(this);" class="level1Sty">
                    <table id="MenuTop">
                        <tr>
                            <td width="24"><img src="img/MenuImg/Menutitle_left.jpg"/></td>
                            <td>导航菜单</td>
                            <td width="24"><img src="img/MenuImg/Menutitle_right.jpg"/></td>
                        </tr>
                    </table>
                </div>
                <ul style="display: none;"class="MenuLevel2">
                </ul>
            </li>

            <!--人事管理-->
            <li class="level1" id="HR" >
                <div onClick="menuClick(this);"  class="level1Style">
                    <table id="MenuTitle">
                        <tr>
                            <td width="62" align="right"><img src="img/MenuImg/icon1.jpg"/></td>
                            <td>人事管理</td>
                            <td width="62"></td>
                        </tr>
                    </table>
                    <img src="img/images/bottonline.jpg" />
                </div>
                <ul style="display:none;" class="MenuLevel2">
                    <li class="level2">
                        <a target="desktop" href="personnel department/personInfo_Add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增员工个人信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/personInfo_revise.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改员工个人信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/staffattendance_add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>维护员工考勤记录</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/staffattendance_count.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>考勤记录</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/Department_Add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增部门信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/Department_List.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改部门信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="personnel department/PersonTransfer_Choice.HTML"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记人员调动情况</div></a>
                    </li>
                </ul>
            </li>

            <!--车辆管理-->

            <li class="level1" ID="LG" >
                <div onClick="menuClick(this);"class="level1Style">
                    <table id="MenuTitle"><tr>
                        <td width="62" align="right"><img src="img/MenuImg/icon3.jpg"/></td>
                        <td>车辆管理</td>
                        <td width="62" ></td>
                    </tr></table>
                    <img src="img/images/bottonline.jpg" />
                </div>
                <ul style="display:none;" class="MenuLevel2">
                    <li class="level2">
                        <a target="desktop" href="car/AddParking.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增车位信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="car/ReviseParking_List.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改车位信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="car/AddcarNum.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>新增车辆信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="car/CarInfo_List.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改车辆信息</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="car/CarUseInfo_Add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记车辆使用情况</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="car/CarUseInfo_Query.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询车辆使用情况</div></a>
                    </li>
                </ul>
            </li>

            <!--办公用品-->
            <li class="level1" ID="AD" >
                <div onClick="menuClick(this);"class="level1Style">
                    <table id="MenuTitle">
                        <tr>
                            <td width="62" align="right"><img src="img/MenuImg/icon2.jpg"/></td>
                            <td>办公用品</td>
                            <td width="62" ></td>
                        </tr>
                    </table>
                    <img src="img/images/bottonline.jpg" />
                </div>

                <ul style="display:none;" class="MenuLevel2">
                    <li class="level2">
                        <a target="desktop" href="Office Stationery/BuyOfficeStationery.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>购买办公用品登记</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="Office Stationery/ReceiveDepartment.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>登记办公用品使用情况 </div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="Office Stationery/CheckInventory.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询办公用品库存</div></a>
                    </li>
                </ul>
            </li>

            <!--我的信息-->
            <li class="level1">
                <div onClick="menuClick(this);"class="level1Style">
                    <table id="MenuTitle">
                        <tr>
                            <td width="62" align="right"><img src="img/MenuImg/icon4.jpg"/></td>
                            <td>个人信息</td>
                            <td width="62" ></td>
                        </tr>
                    </table>
                    <img src="img/images/bottonline.jpg" />
                </div>

                <ul style="display:none;" class="MenuLevel2">
                    <li class="level2">
                        <a target="desktop" href="PersonnalInfo/Addresslist_add.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>维护个人通讯录</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="PersonnalInfo/Addresslist_Query.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>查询通讯录</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="PersonnalInfo/WorkRecord.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>填写工作记录</div></a>
                    </li>
                    <li class="level2">
                        <a target="desktop" href="PersonnalInfo/RevisePassword.html"><div class="level2Style"><img src="img/MenuImg/MenuIcon.png" class="Icon"/>修改个人通讯密码</div></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <div style="margin-left: 230px">
        test
    </div>
    <tags:js></tags:js>
</body>
</html>
