(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-67265df0"],{"0f55":function(e,t,i){"use strict";i("172c")},"163d":function(e,t,i){"use strict";var a=i("e7ad"),n=i("e042"),o=i("75c4"),s=i("1e5b"),r=i("94b3"),l=i("238a"),c=i("2ea2").f,d=i("dcb7").f,u=i("064e").f,p=i("777a").trim,f="Number",g=a[f],m=g,h=g.prototype,I=o(i("e005")(h))==f,v="trim"in String.prototype,y=function(e){var t=r(e,!1);if("string"==typeof t&&t.length>2){t=v?t.trim():p(t,3);var i,a,n,o=t.charCodeAt(0);if(43===o||45===o){if(i=t.charCodeAt(2),88===i||120===i)return NaN}else if(48===o){switch(t.charCodeAt(1)){case 66:case 98:a=2,n=49;break;case 79:case 111:a=8,n=55;break;default:return+t}for(var s,l=t.slice(2),c=0,d=l.length;c<d;c++)if(s=l.charCodeAt(c),s<48||s>n)return NaN;return parseInt(l,a)}}return+t};if(!g(" 0o1")||!g("0b1")||g("+0x1")){g=function(e){var t=arguments.length<1?0:e,i=this;return i instanceof g&&(I?l((function(){h.valueOf.call(i)})):o(i)!=f)?s(new m(y(t)),i,g):y(t)};for(var w,b=i("149f")?c(m):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),L=0;b.length>L;L++)n(m,w=b[L])&&!n(g,w)&&u(g,w,d(m,w));g.prototype=h,h.constructor=g,i("bf16")(a,f,g)}},"172c":function(e,t,i){},"4e8e":function(e,t,i){"use strict";i("ca93")},"73f3":function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"page"},[i("div",{staticStyle:{padding:"20px"}},[i("div",{style:{height:e.height-60+"px"}},[i("Split",{attrs:{value:"400",min:"400px"}},[i("div",{staticClass:"demo-split-pane",attrs:{slot:"left"},slot:"left"},[i("div",{staticClass:"tableList",staticStyle:{border:"1px solid #dcdee2"},style:{height:e.height-60+"px"}},[i("div",{staticClass:"splitTitle"},[e._v("\n                            组织架构\n                            "),i("div",{staticClass:"searchBtnList"},[i("Button",{staticStyle:{"margin-right":"10px"},attrs:{type:"primary",size:"small",icon:"ios-add-circle"},on:{click:e.showNew}},[e._v("新增公司")])],1)]),i("div",{staticClass:"splitBox",staticStyle:{padding:"0 20px"}},[[i("Tree",{staticClass:"demo-tree-render",attrs:{data:e.treeData,render:e.renderContent},on:{"on-select-change":e.treeChange}})]],2)])]),i("div",{staticClass:"demo-split-pane",attrs:{slot:"right"},slot:"right"},[i("div",{staticClass:"tableList",staticStyle:{border:"1px solid #dcdee2"},style:{height:e.height-60+"px"}},[i("div",{staticClass:"splitTitle"},[e._v("部门员工")]),i("div",{staticClass:"splitBox"},[e.isUser?[i("DepartmentUser",{attrs:{id:e.orgId}})]:e._e()],2)])])])],1)]),[i("Modal",{staticClass:"noContentPadding noHeaderModal",attrs:{"mask-closable":!1,width:"30",styles:{top:"5%"},title:"新增/修改账号"},on:{"on-cancel":e.hideModal},model:{value:e.isDetail,callback:function(t){e.isDetail=t},expression:"isDetail"}},[i("div",{staticClass:"modalTable"},[i("div",{staticClass:"detail",style:{maxHeight:e.height-200+"px",overflowY:"auto"}},[i("table",[i("tr",[i("td",[i("span",{staticClass:"request"},[e._v("*")]),e._v("公司名称：\n                                "),i("div",[i("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写公司名称"},model:{value:e.itemInfo.name,callback:function(t){e.$set(e.itemInfo,"name",t)},expression:"itemInfo.name"}})],1)])])])])]),i("div",{staticClass:"modalFooter",attrs:{slot:"footer"},slot:"footer"},[[i("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"default"},on:{click:e.hideModal}},[e._v("关闭")]),i("Button",{attrs:{type:"primary",disabled:e.disable},on:{click:e.saveAction}},[e._v("提交")])]],2)])],[i("Modal",{staticClass:"noContentPadding noHeaderModal",attrs:{"mask-closable":!1,width:"30",styles:{top:"5%"},title:"新增/修改账号"},on:{"on-cancel":e.hideModal},model:{value:e.isDept,callback:function(t){e.isDept=t},expression:"isDept"}},[i("div",{staticClass:"modalTable"},[i("div",{staticClass:"detail",style:{maxHeight:e.height-200+"px",overflowY:"auto"}},[i("table",[i("tr",[i("td",[i("span",{staticClass:"request"},[e._v("*")]),e._v("部门名称：\n                                "),i("div",[i("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写部门名称"},model:{value:e.deptItemInfo.name,callback:function(t){e.$set(e.deptItemInfo,"name",t)},expression:"deptItemInfo.name"}})],1)])])])])]),i("div",{staticClass:"modalFooter",attrs:{slot:"footer"},slot:"footer"},[[i("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"default"},on:{click:e.hideModal}},[e._v("关闭")]),i("Button",{attrs:{type:"primary",disabled:e.disable},on:{click:e.saveDepetAction}},[e._v("提交")])]],2)])]],2)},n=[],o=(i("cc57"),i("6d57"),function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",[i("div",{staticClass:"tableList"},[[i("Table",{attrs:{height:e.height-200,border:"",stripe:"",loading:e.isLoading,columns:e.columnsRealTime,data:e.realTimeDataList}})]],2),i("div",{staticClass:"pageWrap"},[[i("Page",{attrs:{total:e.count,"page-size":50,"page-size-opts":[50,100,150],"show-sizer":"",showTotal:""},on:{"on-change":e.pageSizeChange,"on-page-size-change":e.pageRowChange}})]],2)])}),s=[],r=(i("163d"),{name:"department",props:{parentItem:Object,orgId:Number},components:{},data:function(){return{userInfo:null,height:window.innerHeight,isLoading:!1,count:0,pageInfo:{pageIndex:1,pageSize:50},columnsRealTime:[{align:"center",title:"序号",type:"index",width:60},{title:"员工姓名",align:"center",key:"nickname"},{title:"手机号",align:"center",key:"mobile"},{title:"邮箱",align:"center",key:"email"},{title:"创建时间",align:"center",key:"create_time"}],realTimeDataList:[]}},methods:{pageSizeChange:function(e){var t=this;t.pageInfo.pageIndex=parseInt(e,10),t.getList(!0)},pageRowChange:function(e){var t=this;t.pageInfo.pageSize=parseInt(e,10),t.getList(!1)},getList:function(e){var t=this;1==e&&(t.isLoading=!0,t.pageInfo.pageIndex=0),t.axios({method:"get",url:t.$config.action.userList,params:{pageNum:t.pageInfo.pageIndex,pageSize:t.pageInfo.pageSize,orgId:t.orgId}}).then((function(e){t.realTimeDataList=e.data.list,t.count=e.data.total,"0"==e.data.code||("9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg)),t.isLoading=!1})).catch((function(e){console.log(e),t.isLoading=!1}))}},created:function(){},mounted:function(){var e=this,t=null,i=null;e.userInfo=e.$utility.getLocalStorage("userInfo"),e.getList(!0),e.$watch("orgId",(function(){clearTimeout(i),i=setTimeout((function(){e.getList(!0)}),200)}),{deep:!0}),window.onresize=function(){clearTimeout(t),t=setTimeout((function(){e.height=window.innerHeight}),500)}},beforeDestroy:function(){clearInterval(window.recordTime)}}),l=r,c=(i("0f55"),i("2c07")),d=Object(c["a"])(l,o,s,!1,null,null,null),u=d.exports,p={name:"user",components:{DepartmentUser:u},data:function(){return{split:.5,userInfo:null,userFuncInfo:null,height:window.innerHeight,isDetail:!1,isDept:!1,isUser:!1,disable:!1,isLoading:!1,userFuncCode:{},count:0,pageInfo:{pageIndex:1,pageSize:50},searchInfo:{userCode:"",userName:""},orgId:"",itemInfo:{fullname:"",id:0,name:"",pid:0},deptItemInfo:{fullname:"",id:0,name:"",pid:0},realTimeDataList:[],treeData:[]}},methods:{pageSizeChange:function(e){var t=this;t.pageInfo.pageIndex=parseInt(e,10),t.getList(!0)},pageRowChange:function(e){var t=this;t.pageInfo.pageSize=parseInt(e,10),t.getList(!1)},reflesh:function(){var e=this;e.getList(!0)},hideModal:function(){var e=this;e.isDetail=!1,e.isDept=!1},treeChange:function(e){var t=this;t.isUser=!1,setTimeout((function(){t.orgId=e[0]["id"],t.isUser=!0}),200)},getList:function(e){var t=this;1==e&&(t.isLoading=!0,t.pageInfo.pageIndex=0),t.axios({method:"get",headers:{token:t.userInfo.token},url:t.$config.action.orgList,params:{pageNum:1,pageSize:1e4}}).then((function(e){function i(e){var t=e;return t.filter((function(e){var i=t.filter((function(t){return e.id==t.pid}));return!(i.length>0)||(e.children=i),0==e.pid}))}t.realTimeDataList=e.data.list,t.count=e.data.total,t.treeData=[],t.realTimeDataList.forEach((function(e,i){0==e.pid?(t.realTimeDataList[i]["title"]=e.name,t.realTimeDataList[i]["id"]=e.id,t.realTimeDataList[i]["itemInfo"]=e,t.realTimeDataList[i]["expand"]=!0,t.realTimeDataList[i]["children"]=[],t.realTimeDataList[i]["render"]=function(e,t){var i=t.root,a=t.node,n=t.data;return window.vuePage.companyAttr(e,i,a,n)}):(t.realTimeDataList[i]["title"]=e.name,t.realTimeDataList[i]["id"]=e.id,t.realTimeDataList[i]["itemInfo"]=e,t.realTimeDataList[i]["expand"]=!0,t.realTimeDataList[i]["children"]=[])})),t.treeData=i(t.realTimeDataList),"0"==e.data.code?(t.realTimeDataList=e.data.list,t.count=e.data.total):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg),t.isLoading=!1})).catch((function(e){console.log(e),t.isLoading=!1}))},showNew:function(){var e=this;e.itemInfo={fullname:"",id:0,name:"",pid:0},e.isDetail=!0},showEdit:function(e){var t=this;for(var i in e)t.itemInfo[i]=e[i];t.isDetail=!0},saveAction:function(){var e=this;if(e.itemInfo.pid){if(0==e.itemInfo.name.length)return void e.$Message.error("请输入部门名称")}else if(0==e.itemInfo.name.length)return void e.$Message.error("请输入公司名称");e.disable=!0,e.axios({method:"post",headers:{token:e.userInfo.token},url:e.itemInfo.id?e.$config.action.orgEdit:e.$config.action.orgAdd,data:{id:e.itemInfo.id||"",fullname:e.itemInfo.fullname,name:e.itemInfo.name,pid:e.itemInfo.pid}}).then((function(t){"0"==t.data.code?(e.$Message.success("提交成功"),e.getList(!1),e.isDetail=!1,e.itemInfo={fullname:"",id:0,name:"",pid:0}):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg),e.disable=!1})).catch((function(t){console.log(t),e.disable=!1}))},saveDepetAction:function(){var e=this;0!=e.deptItemInfo.name.length?(e.disable=!0,e.axios({method:"post",headers:{token:e.userInfo.token},url:e.deptItemInfo.id?e.$config.action.orgEdit:e.$config.action.orgAdd,data:{id:e.deptItemInfo.id||"",fullname:e.deptItemInfo.fullname,name:e.deptItemInfo.name,pid:e.deptItemInfo.pid}}).then((function(t){"0"==t.data.code?(e.$Message.success("提交成功"),e.getList(!1),e.isDept=!1,e.deptItemInfo={fullname:"",id:0,name:"",pid:0}):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.msg),e.disable=!1})).catch((function(t){console.log(t),e.disable=!1}))):e.$Message.error("请输入部门名称")},deleteAction:function(e){var t=this;t.$Modal.confirm({title:"确定删除"+e.name+"?",onOk:function(){t.axios({method:"post",headers:{token:t.userInfo.token},url:t.$config.action.orgDelete,data:{id:e.id}}).then((function(e){"0"==e.data.code?(t.$Message.success("删除成功"),t.getList(!0)):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.msg)})).catch((function(e){console.log(e)}))}})},renderContent:function(e,t){var i=t.root,a=t.node,n=t.data;return e("span",{style:{display:"inline-block",width:"100%"}},[e("span",[e("Icon",{props:{type:"ios-paper-outline"},style:{marginRight:"8px"}}),e("span",n.title)]),e("span",{style:{display:"inline-block",float:"right",marginRight:"32px"}},[e("Button",{props:Object.assign({},{type:"default",size:"small"}),style:{marginRight:"8px",marginLeft:"20px"},on:{click:function(){window.vuePage.append(n)}}},"+"),e("Button",{props:Object.assign({},{type:"default",size:"small"},{icon:"ios-create-outline"}),style:{marginRight:"10px"},on:{click:function(){window.vuePage.editDepet(n)}}}),e("Button",{props:Object.assign({},{type:"default",size:"small"},{icon:"ios-remove"}),on:{click:function(){window.vuePage.remove(i,a,n)}}})])])},companyAttr:function(e,t,i,a){return e("span",{style:{display:"inline-block",width:"100%"}},[e("span",[e("Icon",{props:{type:"ios-folder-outline"},style:{marginRight:"8px"}}),e("span",a.title)]),e("span",{style:{display:"inline-block",float:"right",marginRight:"64px"}},[e("Button",{props:Object.assign({},{type:"primary",size:"small"}),style:{marginRight:"10px",marginLeft:"20px"},on:{click:function(){window.vuePage.append(a)}}},"+"),e("Button",{props:Object.assign({},{type:"warning",size:"small"},{icon:"ios-create-outline"}),style:{marginRight:"10px"},on:{click:function(){window.vuePage.edit(a)}}}),e("Button",{props:Object.assign({},{type:"error",size:"small"},{icon:"ios-remove"}),on:{click:function(){window.vuePage.remove(t,i,a)}}})])])},append:function(e){var t=this;t.deptItemInfo={fullname:"",id:0,name:"",pid:0},t.deptItemInfo.pid=e.itemInfo.id,t.isDept=!0},edit:function(e){var t=this;for(var i in e.itemInfo)t.itemInfo[i]=e.itemInfo[i];t.isDetail=!0},editDepet:function(e){var t=this;for(var i in e.itemInfo)t.deptItemInfo[i]=e.itemInfo[i];t.isDept=!0},remove:function(e,t,i){var a=this;a.deleteAction(i.itemInfo)}},created:function(){var e=this,t=null;window.vuePage=e,e.userInfo=e.$utility.getLocalStorage("userInfo"),e.userFuncInfo=e.$utility.getSessionStorage("userFuncInfo"),e.userFuncCode=e.$utility.getSessionStorage("userFuncCode"),e.getList(!0),e.isUser=!0,e.$watch("searchInfo",(function(){clearTimeout(t),t=setTimeout((function(){e.getList(!0)}),200)}),{deep:!0})},mounted:function(){var e=this,t=null;window.onresize=function(){clearTimeout(t),t=setTimeout((function(){e.height=window.innerHeight}),500)}},beforeDestroy:function(){clearInterval(window.recordTime)}},f=p,g=(i("4e8e"),Object(c["a"])(f,a,n,!1,null,null,null));t["default"]=g.exports},"777a":function(e,t,i){var a=i("e46b"),n=i("f6b4"),o=i("238a"),s=i("9769"),r="["+s+"]",l="​",c=RegExp("^"+r+r+"*"),d=RegExp(r+r+"*$"),u=function(e,t,i){var n={},r=o((function(){return!!s[e]()||l[e]()!=l})),c=n[e]=r?t(p):s[e];i&&(n[i]=c),a(a.P+a.F*r,"String",n)},p=u.trim=function(e,t){return e=String(n(e)),1&t&&(e=e.replace(c,"")),2&t&&(e=e.replace(d,"")),e};e.exports=u},9769:function(e,t){e.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},ca93:function(e,t,i){}}]);
//# sourceMappingURL=chunk-67265df0.b8d0b5dc.js.map