(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4d0ab3bc"],{"01c9":function(e,t,i){"use strict";i("3a43")},"17b9":function(e,t,i){"use strict";i.r(t);var o=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"page"},[i("div",{staticClass:"searchWrap"},[i("div",{staticClass:"search"},[i("table",[i("tr",[i("td",[e._v("\n                          标题\n                        "),[i("Input",{staticStyle:{width:"150px"},attrs:{clearable:"",placeholder:"请输入标题"},model:{value:e.searchInfo.roleName,callback:function(t){e.$set(e.searchInfo,"roleName",t)},expression:"searchInfo.roleName"}})],[i("div",{staticClass:"searchBtnList"},[i("Button",{attrs:{type:"primary",icon:"ios-add-circle"},on:{click:e.showNew}},[e._v("新增")]),i("Button",{attrs:{icon:"ios-refresh-circle"},on:{click:e.reflesh}},[e._v("重置")])],1)]],2)])])])]),i("div",{staticClass:"tableList"},[[i("Table",{attrs:{height:e.height-100,border:"",stripe:"",loading:e.isLoading,columns:e.columnsRealTime,data:e.realTimeDataList},scopedSlots:e._u([{key:"action",fn:function(t){var o=t.row;t.index;return[i("Button",{attrs:{type:"primary",size:"small"},on:{click:function(t){return e.showEdit(o)}}},[e._v("修改")]),e._v("  \n                    "),i("Button",{attrs:{type:"error",size:"small"},on:{click:function(t){return e.deleteAction(o)}}},[e._v("删除")])]}}])})]],2),i("div",{staticClass:"pageWrap"},[[i("Page",{attrs:{total:e.count,"page-size":50,"page-size-opts":[50,100,150],"show-sizer":"",showTotal:""},on:{"on-change":e.pageSizeChange,"on-page-size-change":e.pageRowChange}})]],2),[i("Modal",{staticClass:"noContentPadding noHeaderModal",attrs:{"mask-closable":!1,width:"30",styles:{top:"5%"},title:"角色录入"},on:{"on-cancel":function(t){e.isDetail=!1}},model:{value:e.isDetail,callback:function(t){e.isDetail=t},expression:"isDetail"}},[i("div",{staticClass:"modalTable"},[i("div",{staticClass:"detail"},[i("table",[i("tr",[i("td",[i("span",{staticClass:"request"},[e._v("*")]),e._v("名称：\n                                "),i("div",[i("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写名称"},model:{value:e.itemInfo.roleName,callback:function(t){e.$set(e.itemInfo,"roleName",t)},expression:"itemInfo.roleName"}})],1)])]),i("tr",[i("td",[i("span",{staticClass:"request"},[e._v("*")]),e._v("英文名称：\n                                "),i("div",[i("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写英文名称"},model:{value:e.itemInfo.roleCode,callback:function(t){e.$set(e.itemInfo,"roleCode",t)},expression:"itemInfo.roleCode"}})],1)])]),i("tr",[i("td",[e._v("\n                                所属栏目：\n                                "),i("div",[[i("Select",{staticStyle:{width:"100%"},attrs:{clearable:"",placeholder:"选择所属栏目"}})]],2)])]),i("tr",[i("td",[e._v("\n                                链接：\n                                "),i("div",[i("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写链接"},model:{value:e.itemInfo.roleDesc,callback:function(t){e.$set(e.itemInfo,"roleDesc",t)},expression:"itemInfo.roleDesc"}})],1)])])])])]),i("div",{staticClass:"modalFooter",attrs:{slot:"footer"},slot:"footer"},[[i("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"default"},on:{click:function(t){e.isDetail=!1}}},[e._v("关闭")]),i("Button",{attrs:{type:"primary",disable:e.disable},on:{click:e.saveAction}},[e._v("提交")])]],2)])]],2)},n=[],a=(i("8dee"),{name:"role",components:{},data:function(){return{userInfo:null,height:window.innerHeight,isModalLoading:!1,isDetail:!1,isFunction:!1,isInfo:!1,disable:!1,isLoading:!1,count:0,pageInfo:{pageIndex:0,pageSize:50},searchInfo:{companyId:"",roleName:""},itemInfo:{id:"",companyId:"",roleName:"",roleCode:"",roleDesc:"",isValid:1,isPublic:1,createUserId:"",modifyUserId:""},columnsRealTime:[{align:"center",title:"序号",type:"index",width:60},{title:"标题",align:"center",key:"roleName"},{title:"英文标题",align:"center",key:"roleName"},{title:"所属栏目",align:"center",key:"roleName"},{title:"所属区域",align:"center",key:"roleName"},{title:"链接",align:"center",key:"roleName"},{title:"创建时间",align:"center",key:"createTime"},{title:"更新时间",align:"center",key:"modifyTime"},{align:"center",title:"操作",width:220,slot:"action"}],realTimeDataList:[],companyList:[],roleFunctionPageInfo:{count:0,pageNum:1,pageSize:20,roleId:"",companyId:""},roleFunctionColumsList:[{type:"selection",width:60,align:"center"},{title:"公司名称",align:"center",key:"companyName",width:250},{title:"角色名称",align:"center",key:"roleName"},{title:"功能名称",align:"center",key:"functionName"}],roleFunctionTableRowList:[],functionsTableRowList:[],selectFunction:[],selectRoleFunction:[]}},methods:{pageSizeChange:function(e){var t=this;t.pageInfo.pageIndex=parseInt(e,10),t.getList(!0)},pageRowChange:function(e){var t=this;t.pageInfo.pageSize=parseInt(e,10),t.getList(!1)},reflesh:function(){var e=this;e.getList(!0)},getList:function(e){var t=this;1==e&&(t.isLoading=!0,t.pageInfo.pageIndex=0),t.axios({method:"post",headers:t.$utility.setHeader(t.$config.service.permissionService),url:t.$config.action.getRoleList,data:t.$qs.stringify({pageNum:t.pageInfo.pageIndex,pageSize:t.pageInfo.pageSize,companyId:t.searchInfo.companyId,roleName:encodeURI(t.searchInfo.roleName)})}).then((function(e){"200"==e.data.code?(t.realTimeDataList=e.data.data,t.count=e.data.count):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg),t.isLoading=!1})).catch((function(e){console.log(e),t.isLoading=!1}))},showNew:function(){var e=this;e.itemInfo={id:"",companyId:"",roleName:"",roleCode:"",roleDesc:"",isValid:1,isPublic:1,createUserId:"",modifyUserId:""},e.itemInfo.companyId=e.companyList[0]?e.companyList[0]["id"]:"",e.isDetail=!0},showEdit:function(e){var t=this;for(var i in e)t.itemInfo[i]=e[i];t.isDetail=!0},showInfo:function(e){var t=this;for(var i in e)t.itemInfo[i]=e[i];t.isInfo=!0},saveAction:function(){var e=this;e.itemInfo.companyId?0!=e.itemInfo.roleName.trim().length?0!=e.itemInfo.roleCode.trim().length?(e.disable=!0,e.axios({method:"post",headers:e.$utility.setHeader(e.$config.service.permissionService),url:e.$config.action.saveRole,data:e.$qs.stringify({id:e.itemInfo.id||0,companyId:e.itemInfo.companyId,roleName:encodeURI(e.itemInfo.roleName),roleCode:encodeURI(e.itemInfo.roleCode),roleDesc:encodeURI(e.itemInfo.roleDesc),isValid:e.itemInfo.isValid,isPublic:e.itemInfo.isPublic,createUserId:e.userInfo["id"],modifyUserId:e.userInfo["id"]})}).then((function(t){"200"==t.data.code?(e.$Message.success("提交成功"),e.getList(!1),e.isDetail=!1,e.itemInfo={id:"",companyId:"",roleName:"",roleCode:"",roleDesc:"",isValid:1,isPublic:1,createUserId:"",modifyUserId:""}):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg),e.disable=!1})).catch((function(t){console.log(t),e.disable=!1}))):e.$Message.error("请输入角色编码"):e.$Message.error("请输入角色名称"):e.$Message.error("请选择公司")},deleteAction:function(e){var t=this;t.$Modal.confirm({title:"确定删除"+e.roleName+"?",onOk:function(){t.axios({method:"post",headers:t.$utility.setHeader(t.$config.service.permissionService),url:t.$config.action.delRole,data:t.$qs.stringify({ids:e.id,modifyUserId:t.userInfo["id"]})}).then((function(e){"200"==e.data.code?(t.$Message.success("删除成功"),t.getList(!0)):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg)})).catch((function(e){console.log(e)}))}})},getCompanyList:function(){var e=this;e.axios({method:"post",headers:e.$utility.setHeader(e.$config.service.companyService),url:e.$config.action.getCompanyList,data:e.$qs.stringify({pageNum:1,pageSize:1e3})}).then((function(t){"200"==t.data.code?(e.companyList=t.data.data,e.searchInfo.companyId=e.userInfo.companyId):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg)})).catch((function(e){console.log(e)}))},showRoleFunctions:function(e){var t=this;t.roleFunctionPageInfo.companyId=e.companyId,t.roleFunctionPageInfo.roleId=e.id,t.isFunction=!0,t.getFunctionsDataList(),t.getRoleFunctionsDataList(!0)},roleFunctionsPageSizeChange:function(e){var t=this;t.roleFunctionPageInfo.pageNum=parseInt(e,10),setTimeout((function(){t.getRoleFunctionsDataList(!1)}),200)},roleFunctionsPageRowChange:function(e){var t=this;t.roleFunctionPageInfo.pageSize=parseInt(e,10),setTimeout((function(){t.getRoleFunctionsDataList(!1)}),200)},getRoleFunctionsDataList:function(e){var t=this;1==e&&(t.roleFunctionPageInfo.pageNum=1),t.isModalLoading=!0,t.axios({method:"post",headers:t.$utility.setHeader(t.$config.service.permissionService),url:t.$config.action.getRoleFunctionList,data:t.$qs.stringify({pageNum:t.roleFunctionPageInfo.pageNum,pageSize:t.roleFunctionPageInfo.pageSize,companyId:t.roleFunctionPageInfo.companyId,roleId:t.roleFunctionPageInfo.roleId})}).then((function(e){"200"==e.data.code?(t.roleFunctionTableRowList=e.data.data,t.roleFunctionPageInfo.count=e.data.count):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg),t.isModalLoading=!1})).catch((function(e){console.log(e),t.isModalLoading=!1}))},getSuper:function(e,t){for(var i=this,o=0,n=e.length;o<n;o++){if(e[o]["id"]==t){i.selectFunction.push(t),e[o]["checked"]=!0;break}i.getSuper(e[o]["children"],t)}},setChecked:function(){for(var e=this,t=0,i=e.roleFunctionTableRowList.length;t<i;t++)e.getSuper(e.functionsTableRowList,e.roleFunctionTableRowList[t]["functionId"])},selectFunctionsChange:function(e){for(var t=this,i=[],o=0,n=e.length;o<n;o++)i.push(e[o]["id"]);t.selectFunction=i},formatFunctions:function(e){var t=this,i=JSON.stringify(e).replace(/(subFunctionList)/g,"children").replace(/(functionName)/g,"title").replace(/isValid/g,"expand");t.functionsTableRowList=JSON.parse(i),console.log(t.functionsTableRowList),t.setChecked()},getFunctionsDataList:function(e){var t=this;t.functionsTableRowList=[],t.axios({method:"post",headers:t.$utility.setHeader(t.$config.service.permissionService),url:t.$config.action.getFunctionTreeList,data:t.$qs.stringify({pageNum:1,pageSize:1e5})}).then((function(e){"200"==e.data.code?t.formatFunctions(e.data.data):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg)})).catch((function(e){console.log(e)}))},uploadFunctionDataToServer:function(){var e=this;e.axios({method:"post",headers:e.$utility.setHeader(e.$config.service.permissionService),url:e.$config.action.saveRoleFunction,data:e.$qs.stringify({roleId:e.roleFunctionPageInfo.roleId,companyId:e.roleFunctionPageInfo.companyId,functionIds:e.selectFunction.join(","),createUserId:e.userInfo["id"],modifyUserId:e.userInfo["id"]})}).then((function(t){"200"==t.data.code?e.getRoleFunctionsDataList(!0):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg)})).catch((function(e){console.log(e)}))},selectRoleFunctionsChange:function(e){for(var t=this,i=[],o=0,n=e.length;o<n;o++)i.push(e[o]["id"]);t.selectRoleFunction=i},deleteRoleFunctions:function(){var e=this;e.isModalLoading=!0,e.axios({method:"post",headers:e.$utility.setHeader(e.$config.service.permissionService),url:e.$config.action.delRoleFunction,data:e.$qs.stringify({ids:e.selectRoleFunction.join(","),modifyUserId:e.userInfo["id"]})}).then((function(t){"200"==t.data.code?e.getRoleFunctionsDataList(!0):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg)})).catch((function(e){console.log(e)}))}},created:function(){var e=this,t=null;e.userInfo=e.$utility.getLocalStorage("userInfo"),e.getCompanyList(),e.$watch("searchInfo",(function(){clearTimeout(t),t=setTimeout((function(){e.getList(!0)}),200)}),{deep:!0})},mounted:function(){var e=this,t=null;window.onresize=function(){clearTimeout(t),t=setTimeout((function(){e.height=window.innerHeight}),500)}},beforeDestroy:function(){clearInterval(window.recordTime)}}),s=a,c=(i("01c9"),i("c701")),r=Object(c["a"])(s,o,n,!1,null,null,null);t["default"]=r.exports},"3a43":function(e,t,i){}}]);
//# sourceMappingURL=chunk-4d0ab3bc.acc5cd7f.js.map