(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-30a2f814"],{5286:function(e,t,a){},d8e3:function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"page"},[a("div",{staticClass:"searchWrap"},[a("div",{staticClass:"search"},[a("table",[a("tr",[a("td",[e._v("\n                          区域中文名称\n                        "),[a("Input",{staticStyle:{width:"150px"},attrs:{clearable:"",placeholder:"请输入区域中文名称"},model:{value:e.searchInfo.name,callback:function(t){e.$set(e.searchInfo,"name",t)},expression:"searchInfo.name"}})],e._v("\n                          区域英文名称\n                        "),[a("Input",{staticStyle:{width:"150px"},attrs:{clearable:"",placeholder:"请输入区域英文名称"},model:{value:e.searchInfo.e_name,callback:function(t){e.$set(e.searchInfo,"e_name",t)},expression:"searchInfo.e_name"}})],[a("div",{staticClass:"searchBtnList"},[a("Button",{attrs:{type:"primary",icon:"ios-add-circle"},on:{click:e.showNew}},[e._v("新增")]),a("Button",{attrs:{icon:"ios-refresh-circle"},on:{click:e.reflesh}},[e._v("重置")])],1)]],2)])])])]),a("div",{staticClass:"tableList"},[[a("Table",{attrs:{height:e.height-100,border:"",stripe:"",loading:e.isLoading,columns:e.columnsRealTime,data:e.realTimeDataList},scopedSlots:e._u([{key:"action",fn:function(t){var n=t.row;t.index;return[a("Button",{attrs:{type:"primary",size:"small"},on:{click:function(t){return e.showEdit(n)}}},[e._v("修改")]),e._v("  \n                    "),a("Button",{attrs:{type:"error",size:"small"},on:{click:function(t){return e.deleteAction(n)}}},[e._v("删除")])]}}])})]],2),a("div",{staticClass:"pageWrap"},[[a("Page",{attrs:{total:e.count,"page-size":50,"page-size-opts":[50,100,150],"show-sizer":"",showTotal:""},on:{"on-change":e.pageSizeChange,"on-page-size-change":e.pageRowChange}})]],2),[a("Modal",{staticClass:"noContentPadding noHeaderModal",attrs:{"mask-closable":!1,width:"30",styles:{top:"5%"},title:"角色录入"},on:{"on-cancel":function(t){e.isDetail=!1}},model:{value:e.isDetail,callback:function(t){e.isDetail=t},expression:"isDetail"}},[a("div",{staticClass:"modalTable"},[a("div",{staticClass:"detail"},[a("table",[a("tr",[a("td",[a("span",{staticClass:"request"},[e._v("*")]),e._v("区域中文名称：\n                                "),a("div",[a("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写区域中文名称"},model:{value:e.itemInfo.name,callback:function(t){e.$set(e.itemInfo,"name",t)},expression:"itemInfo.name"}})],1)])]),a("tr",[a("td",[e._v("\n                                区域英文名称：\n                                "),a("div",[a("Input",{staticStyle:{width:"100%"},attrs:{placeholder:"填写区域英文名称"},model:{value:e.itemInfo.e_name,callback:function(t){e.$set(e.itemInfo,"e_name",t)},expression:"itemInfo.e_name"}})],1)])])])])]),a("div",{staticClass:"modalFooter",attrs:{slot:"footer"},slot:"footer"},[[a("Button",{staticStyle:{"margin-right":"5px"},attrs:{type:"default"},on:{click:function(t){e.isDetail=!1}}},[e._v("关闭")]),a("Button",{attrs:{type:"primary",disable:e.disable},on:{click:e.saveAction}},[e._v("提交")])]],2)])]],2)},i=[],o=(a("cc57"),{name:"role",components:{},data:function(){return{userInfo:null,height:window.innerHeight,isModalLoading:!1,isDetail:!1,isFunction:!1,isInfo:!1,disable:!1,isLoading:!1,count:0,pageInfo:{pageIndex:0,pageSize:50},searchInfo:{id:0,counter_map:"",e_counter_map:"",e_gate_map:"",e_name:"",e_pickup_map:"",gate_map:"",name:"",pickup_map:""},itemInfo:{id:0,counter_map:"",e_counter_map:"",e_gate_map:"",e_name:"",e_pickup_map:"",gate_map:"",name:"",pickup_map:""},columnsRealTime:[{align:"center",title:"序号",type:"index",width:60},{title:"区域中文名称",align:"center",key:"name"},{title:"区域英文名称",align:"center",key:"e_name"},{title:"创建时间",align:"center",key:"create_time"},{title:"更新时间",align:"center",key:"update_time"},{align:"center",title:"操作",width:220,slot:"action"}],realTimeDataList:[]}},methods:{pageSizeChange:function(e){var t=this;t.pageInfo.pageIndex=parseInt(e,10),t.getList(!0)},pageRowChange:function(e){var t=this;t.pageInfo.pageSize=parseInt(e,10),t.getList(!1)},reflesh:function(){var e=this;e.getList(!0)},getList:function(e){var t=this;1==e&&(t.isLoading=!0,t.pageInfo.pageIndex=0),t.axios({method:"get",headers:{token:t.userInfo.token},url:t.$config.action.areaList,params:{pageNum:t.pageInfo.pageIndex,pageSize:t.pageInfo.pageSize,e_name:t.searchInfo.e_name,name:t.searchInfo.name}}).then((function(e){t.realTimeDataList=e.data.list,t.count=e.data.total,"0"==e.data.code?(t.realTimeDataList=e.data.data,t.count=e.data.count):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.message),t.isLoading=!1})).catch((function(e){console.log(e),t.isLoading=!1}))},showNew:function(){var e=this;e.itemInfo={id:0,counter_map:"",e_counter_map:"",e_gate_map:"",e_name:"",e_pickup_map:"",gate_map:"",name:"",pickup_map:""},e.isDetail=!0},showEdit:function(e){var t=this;for(var a in e)t.itemInfo[a]=e[a];t.isDetail=!0},showInfo:function(e){var t=this;for(var a in e)t.itemInfo[a]=e[a];t.isInfo=!0},saveAction:function(){var e=this;e.itemInfo.name?e.itemInfo.e_name?(e.disable=!0,e.axios({method:"post",headers:{token:e.userInfo.token},url:e.itemInfo.id?e.$config.action.areaEdit:e.$config.action.areaAdd,data:{id:e.itemInfo.id||0,counter_map:e.itemInfo.counter_map,e_counter_map:e.itemInfo.e_counter_map,e_gate_map:e.itemInfo.e_gate_map,e_name:e.itemInfo.e_name,e_pickup_map:e.itemInfo.e_pickup_map,gate_map:e.itemInfo.gate_map,name:e.itemInfo.name,pickup_map:e.itemInfo.pickup_map}}).then((function(t){"0"==t.data.code?(e.$Message.success("提交成功"),e.getList(!1),e.isDetail=!1,e.itemInfo={id:0,counter_map:"",e_counter_map:"",e_gate_map:"",e_name:"",e_pickup_map:"",gate_map:"",name:"",pickup_map:""}):"9003"==t.data.code?e.utility.loginTimeOut(e):e.$Message.error(t.data.message),e.disable=!1})).catch((function(t){console.log(t),e.disable=!1}))):e.$Message.error("请输入英文名称"):e.$Message.error("请输入中文名称")},deleteAction:function(e){var t=this;t.$Modal.confirm({title:"确定删除"+e.name+"?",onOk:function(){t.axios({method:"post",headers:{token:t.userInfo.token},url:t.$config.action.areaDelete,data:{id:e.id}}).then((function(e){"0"==e.data.code?(t.$Message.success("删除成功"),t.getList(!0)):"9003"==e.data.code?t.utility.loginTimeOut(t):t.$Message.error(e.data.message)})).catch((function(e){console.log(e)}))}})}},created:function(){var e=this,t=null;e.userInfo=e.$utility.getLocalStorage("userInfo"),e.getList(!0),e.$watch("searchInfo",(function(){clearTimeout(t),t=setTimeout((function(){e.getList(!0)}),200)}),{deep:!0})},mounted:function(){var e=this,t=null;window.onresize=function(){clearTimeout(t),t=setTimeout((function(){e.height=window.innerHeight}),500)}},beforeDestroy:function(){clearInterval(window.recordTime)}}),s=o,c=(a("f6db"),a("2c07")),r=Object(c["a"])(s,n,i,!1,null,null,null);t["default"]=r.exports},f6db:function(e,t,a){"use strict";a("5286")}}]);
//# sourceMappingURL=chunk-30a2f814.33df930c.js.map