/* JS */ gapi.loaded_4(function(_){var window=this;
var Rk=function(a,c,f,g,h){this.width=a;this.height=c;this.hg=f;this.wc=g;this.opacity=h},Sk=function(a,c,f,g){return new Rk(void 0==c?a.width:c,void 0==f?a.height:f,a.hg,a.wc,void 0==g?a.opacity:g)};Rk.prototype.equals=function(a){return this.width==a.width&&this.height==a.height&&this.hg==a.hg&&this.wc==a.wc&&this.opacity==a.opacity}; Rk.prototype.interpolate=function(a,c){var f=1-c;return new Rk(Math.round(this.width*f+a.width*c),Math.round(this.height*f+a.height*c),Math.round(this.hg*f+a.hg*c),Math.round(this.wc*f+a.wc*c),this.opacity*f+a.opacity*c)};
_.Tk=function(a){_.Oh.call(this,a);this.ye=new _.bi(this)};_.J(_.Tk,_.Qh);
_.nC=function(a){var c=Number(a.Ka(200,"widgetWidth","width")),f=Number(a.Ka(100,"widgetHeight","height")),g=a.Ka("auto","corner"),h=a.Ka({},"menuCss"),l=a.Ka(!0,"hideOnClick");a.YW=!!a.Ka(!0,"hideOnLeave");a.UV=!!a.Ka((0,_.Pk)(),"useCss3Transition");a.HX=!!a.Ka(!0,"allowOffset");var n=window.document.createElement("div");a.wc=n;var q=_.LH(a);q.parentNode.appendChild(n);var t=window.document.createElement("div");a.pb=t;n.appendChild(t);h.position="absolute";h.width=c+"px";h.height="0";h.border=h.border||
"1px solid #aaa";h.background=h.background||"#fff";h.zIndex=_.Uh(a);h.overflow="hidden";h.boxShadow=h.MozBoxShadow=h.webkitBoxShadow=h.boxShadow||"0 2px 2px rgba(0,0,0,0.3)";_.Mg(n,h);_.Mg(t,{left:"-1000px",top:"-1000px",position:"absolute",width:c+"px",height:f+"px"});a.KX=n.offsetWidth-c;a.LX=n.offsetHeight;h="auto"==g?["top","start"]:g.split("-");q=_.Eg(q);a.zv="bottom"==h[0];a.nT="right"==h[1]||"left"!=h[1]&&q;a.Ph=Uk(a,c,f,"auto"==g);a.TV=_.D.setTimeout((0,_.H)(a.$W,a),500);a.ye.Ei(n,"mouseover",
a.Yq);_.tr(a.ye,n,"mouseout",a.Xq,!1,a);l&&_.D.setTimeout((0,_.H)(function(){this.eS||this.ye.Ei(window.document,"click",this.zr)},a),0)};_.Tk.prototype.open=function(){_.nC(this);this.wb.qc(this.wc);this.wb.zh("resize",(0,_.H)(this.resize,this));this.wb.fg("showMenu",(0,_.H)(this.Is,this));var a=this.wb.methods;a.setHideOnLeave=(0,_.H)(this.Zq,this);a.displayStateCallback&&(this.xW=a.displayStateCallback,delete a.displayStateCallback);this.wb.Pa(this.pb,{height:"100%"});_.Xk(this,this.Ph)};
_.Tk.prototype.open=_.Tk.prototype.open;_.Tk.prototype.Oe=function(a){this.eS||(a=a||{},this.pb.style.left="0",this.pb.style.top="0",this.Na&&(_.Tf(this.Na),this.Na=null),this.TV&&(_.D.clearTimeout(this.TV),this.TV=null),Wk(this,(0,window.parseInt)(a.width,10)||(0,window.parseInt)(this.wb.width,10)||this.Ph.width,(0,window.parseInt)(a.height,10)||(0,window.parseInt)(this.wb.height,10)||this.Ph.height))};_.Tk.prototype.onready=_.Tk.prototype.Oe;
_.Tk.prototype.resize=function(a){this.eS||Wk(this,(0,window.isNaN)(+a.width)?this.Ph.width:+a.width,(0,window.isNaN)(+a.height)?this.Ph.height:+a.height)};_.Tk.prototype.close=function(){this.RV?NC(this):(this.PV=!0,KC(this))};_.Tk.prototype.close=_.Tk.prototype.close;_.Tk.prototype.Ka=function(a,c){for(var f,g=1,h=arguments.length;g<h&&(f=this.hg[arguments[g]],void 0===f);++g);return void 0!==f?f&&"object"==typeof f?(g={},_.Ht(g,f),g):f:a};
var Uk=function(a,c,f,g){var h=_.LH(a),l=_.Yg(h.offsetParent);l.right-=a.KX;l.bottom-=a.LX;if(g){var n=h.offsetLeft;g=n+c<l.right;n=n+h.offsetWidth-c>=l.left;a.nT=a.nT?!g||n:!g&&n;n=h.offsetTop;g=n+f<l.bottom;n=n+h.offsetHeight-f>=l.top;a.zv=a.zv?!g||n:!g&&n}return new Rk(c,f,Vk(a.nT,h.offsetLeft,h.offsetWidth,c,l.left,l.right),Vk(a.zv,h.offsetTop,h.offsetHeight,f,l.top,l.bottom),1)},Vk=function(a,c,f,g,h,l){return a?(a=c+f,Math.min(l-a,Math.max(h+g-a,0))):Math.max(h-c,Math.min(l-c-g,0))},Wk=function(a,
c,f){a.wb.rb().style.width=c+"px";a.wb.rb().style.height=f+"px";a.pb.style.width=c+"px";a.pb.style.height=f+"px";c=a.HX?Uk(a,c,f,!1):Sk(a.QV,c,f);a.Ph=c;a.Za||ZC(a,c)};_.k=_.Tk.prototype;_.k.Zq=function(a){this.YW=!!a};_.k.Yq=function(){!this.Za&&this.Zc&&(_.D.clearTimeout(this.Zc),this.Zc=null)};
_.k.Xq=function(a){if(!(this.Za||this.Zc||!this.YW||a.relatedTarget&&_.Yf(this.wc,a.relatedTarget))){var c=_.Lg(this.wc);a=a.clientY>c.top&&a.clientY<c.top+c.height?0:300;this.Zc=_.D.setTimeout((0,_.H)(this.SV,this),a)}};_.k.zr=function(a){_.Th(this.wc,a)||this.SV()};_.k.Is=function(a){this.show(!!a||void 0===a)};_.k.show=function(a){a?!this.eS&&this.RV&&(this.Za=this.RV=!1,_.Xk(this,this.Ph)):this.SV()};
_.Xk=function(a,c){Yk(a,Sk(c,void 0,0,0));_.D.setTimeout((0,_.H)(function(){this.Za||(this.Ph=c,this.UV&&_.Nk(this.wc,"width 350ms cubic-bezier(.23, .50, .32, 1),height 350ms cubic-bezier(.23, .50, .32, 1),left 350ms cubic-bezier(.23, .50, .32, 1),top 350ms cubic-bezier(.23, .50, .32, 1),opacity 350ms cubic-bezier(.23, .50, .32, 1)"),ZC(this,c),this.xC(!0,!1),this.gS&&(_.D.clearTimeout(this.gS),this.PV=!1),this.gS=_.D.setTimeout((0,_.H)(this.xC,this,!0,!0),350))},a),0)};
_.Tk.prototype.SV=function(){this.Za||KC(this)};
var KC=function(a){a.Za||(a.xC(!1,!1),ZC(a,Sk(a.QV,void 0,0,0)),a.Za=!0,a.gS&&_.D.clearTimeout(a.gS),a.gS=_.D.setTimeout((0,_.H)(function(){this.RV=!0;this.PV?(NC(this),this.PV=!1):(this.UV&&_.Nk(this.wc,""),this.wc.visibility="hidden",this.wc.left="-1000px",this.wc.top="-1000px");this.xC(!1,!0)},a),350))},NC=function(a){a.eS=!0;_.eh(a.ye);a.ye=null;a.Zc&&(_.D.clearTimeout(a.Zc),a.Zc=null);a.Cg&&(_.D.clearTimeout(a.Cg),a.Cg=null);_.Tf(a.wc);a.wc=null;_.Tf(_.LH(a));a.pb=null;a.Na=null};
_.Tk.prototype.xC=function(a,c){var f=this.xW;f&&_.D.setTimeout(function(){f(a,c)},0)};_.Tk.prototype.$W=function(){this.Na=window.document.createElement("div");this.Na.style.width=this.Na.style.height="100%";this.Na.style.position="absolute";this.Na.style.background="url(//ssl.gstatic.com/ui/v1/activityindicator/loading_gs.gif) no-repeat "+(this.Ph.width-19)/2+"px "+(this.Ph.height-19)/2+"px";this.wc.appendChild(this.Na)};
var ZC=function(a,c){if(!a.Za)if(a.UV)Yk(a,c);else{var f=(0,_.pa)()-20+350;a.Cg&&_.D.clearTimeout(a.Cg);a.ZW(a.QV,c,f)}},Yk=function(a,c){var f=a.wc,g=_.LH(a);f.style.left=a.nT?g.offsetLeft+g.offsetWidth+c.hg-c.width+"px":g.offsetLeft+c.hg+"px";f.style.width=c.width+"px";f.style.top=a.zv?g.offsetTop+g.offsetHeight+c.wc-c.height+"px":g.offsetTop+c.wc+"px";f.style.height=c.height+"px";_.Ag(f,c.opacity);a.QV=c}; _.Tk.prototype.ZW=function(a,c,f){this.Cg=null;if(!this.eS&&!a.equals(c)){var g=(0,_.pa)();g>=f?Yk(this,c):(Yk(this,a.interpolate(c,1-Math.pow(1-Math.min(1-(f-g)/350,1),3))),this.Cg=_.D.setTimeout((0,_.H)(this.ZW,this,a,c,f),20))}};

_.hA["slide-menu"]=function(a){var c=new _.Tk(_.FC(a)),f=new _.Zh(c);c.open=function(){};_.nC(c);a.attributes={height:"100%"};a.where=c.pb;a.onClose=function(){c.close()};a.onRestyle=function(a){if(a){var f=!1;a.hasOwnProperty("showMenu")&&(c.Is(a.showMenu),f=!0);a.hasOwnProperty("setHideOnLeave")&&(c.Zq(a.setHideOnLeave),f=!0);f||c.resize(a)}};a.onCreate=function(a){a.ci=function(){return this.Zf("openerIframe")};f.wb=c.wb=a;a.qc(c.wc);a.register("_ready",(0,_.H)(c.Oe,c),_.Vz);c.xW=function(c,f){!a.Ma()&& a.ds([c,f])};_.Xk(c,c.Ph);f.open()}};

});
// Google Inc.
