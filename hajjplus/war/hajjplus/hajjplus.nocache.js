function hajjplus(){var N='',ec='\n-',mb='" for "gwt:onLoadErrorFn"',kb='" for "gwt:onPropertyErrorFn"',qb='"><\/script>',sb='#',Zb='-\n',fc='-><\/scr',Wb='.cache.js\\"><\/scr" + "ipt>");',ub='/',Mb=':',eb='::',$='<html><head><\/head><body><\/body><\/html>',Xb='<scr',pb='<script id="',hb='=',tb='?',jb='Bad handler "',Tb='DOMContentLoaded',Lb="GWT module 'hajjplus' may need to be (re)compiled",Nb='GWTC-compressed.css',rb='SCRIPT',Sb='Upload.css',nb='__gwt_marker_hajjplus',vb='base',ob='baseUrl',R='begin',Q='bootstrap',xb='clear.cache.gif',gb='content',Vb='document.write("<script src=\\"',Jb='end',ac='evtGroup: "loadExternalRefs", millis:(new Date()).getTime(),',cc='evtGroup: "moduleStartup", millis:(new Date()).getTime(),',Fb='gecko',Gb='gecko1_8',S='gwt.codesvr=',T='gwt.hosted=',U='gwt.hybrid',lb='gwt:onLoadErrorFn',ib='gwt:onPropertyErrorFn',fb='gwt:property',O='hajjplus',db='hajjplus::',Z='head',Y='hosted_xsiframe.html?hajjplus',Rb='href',Eb='ie6',Db='ie8',V='iframe',wb='img',gc='ipt>',Yb='ipt><!-',ab='javascript',W='javascript:""',Ob='link',Ub='loadExternalRefs',bb='meta',_b='moduleName:"hajjplus", sessionId:window.__gwtStatsSessionId, subSystem:"startup",',Ib='moduleStartup',Cb='msie',cb='name',zb='opera',X='position:absolute; width:0; height:0; border:none; left: -1000px; top: -1000px; !important',Pb='rel',Bb='safari',_='script',Kb='selectingPermutation',P='startup',Qb='stylesheet',bc='type: "end"});',dc='type: "moduleRequested"});',Hb='unknown',yb='user.agent',Ab='webkit',$b='window.__gwtStatsEvent && window.__gwtStatsEvent({';var k=window,l=document,m=k.__gwtStatsEvent?function(a){return k.__gwtStatsEvent(a)}:null,n=k.__gwtStatsSessionId?k.__gwtStatsSessionId:null,o,p,q,r=N,s={},t=[],u=[],v=[],w=0,x,y;m&&m({moduleName:O,sessionId:n,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:R});if(!k.__gwt_stylesLoaded){k.__gwt_stylesLoaded={}}if(!k.__gwt_scriptsLoaded){k.__gwt_scriptsLoaded={}}function z(){var b=false;try{var c=k.location.search;return (c.indexOf(S)!=-1||c.indexOf(T)!=-1)&&c.indexOf(U)==-1}catch(a){}z=function(){return b};return b}
function A(){if(o&&(!q&&(z()||p))){q=l.createElement(V);q.src=W;q.id=O;q.style.cssText=X;q.tabIndex=-1;document.body.appendChild(q);setTimeout(function(){if(z()){q.contentWindow.location.replace(r+Y)}else{B(p)}})}}
function B(a){var b=q.contentDocument;if(!b){b=q.contentWindow.document}var c=b.getElementsByTagName(Z)[0];if(!c){b.write($);c=b.getElementsByTagName(Z)[0]}var d=b.createElement(_);d.language=ab;d.text=a;c.appendChild(d);c.removeChild(d)}
function C(){var b=document.getElementsByTagName(bb);for(var c=0,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(cb),g;if(f){f=f.replace(db,N);if(f.indexOf(eb)>=0){continue}if(f==fb){g=e.getAttribute(gb);if(g){var h,i=g.indexOf(hb);if(i>=0){f=g.substring(0,i);h=g.substring(i+1)}else{f=g;h=N}s[f]=h}}else if(f==ib){g=e.getAttribute(gb);if(g){try{y=eval(g)}catch(a){alert(jb+g+kb)}}}else if(f==lb){g=e.getAttribute(gb);if(g){try{x=eval(g)}catch(a){alert(jb+g+mb)}}}}}}
function D(){var e,f=nb,g;if(s[ob]){r=s[ob];return}l.write(pb+f+qb);g=l.getElementById(f);e=g&&g.previousSibling;while(e&&e.tagName!=rb){e=e.previousSibling}function h(a){var b=a.lastIndexOf(sb);if(b==-1){b=a.length}var c=a.indexOf(tb);if(c==-1){c=a.length}var d=a.lastIndexOf(ub,Math.min(c,b));return d>=0?a.substring(0,d+1):N}
;if(e&&e.src){r=h(e.src)}if(r==N){var i=l.getElementsByTagName(vb);if(i.length>0){r=i[i.length-1].href}else{r=h(l.location.href)}}else if(r.match(/^\w+:\/\//)){}else{var j=l.createElement(wb);j.src=r+xb;r=h(j.src)}if(g){g.parentNode.removeChild(g)}}
function H(a){var b=u[a](),c=t[a];if(b in c){return b}var d=[];for(var e in c){d[c[e]]=e}if(y){y(a,d,b)}throw null}
u[yb]=function(){var b=navigator.userAgent.toLowerCase();var c=function(a){return parseInt(a[1])*1000+parseInt(a[2])};if(b.indexOf(zb)!=-1){return zb}else if(b.indexOf(Ab)!=-1){return Bb}else if(b.indexOf(Cb)!=-1){if(document.documentMode>=8){return Db}else{var d=/msie ([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){var e=c(d);if(e>=6000){return Eb}}}}else if(b.indexOf(Fb)!=-1){var d=/rv:([0-9]+)\.([0-9]+)/.exec(b);if(d&&d.length==3){if(c(d)>=1008)return Gb}return Fb}return Hb};t[yb]={gecko:0,gecko1_8:1,ie6:2,ie8:3,opera:4,safari:5};hajjplus.onScriptDownloaded=function(a){p=a;A()};hajjplus.onScriptInstalled=function(a){hajjplus.onScriptInstalled=null;if(z()){q.contentWindow.__gwt_getProperty=H}a(x,O,r,w);m&&m({moduleName:O,sessionId:n,subSystem:P,evtGroup:Ib,millis:(new Date).getTime(),type:Jb})};hajjplus.installCode=B;C();D();m&&m({moduleName:O,sessionId:n,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:Kb});var I;if(!z()){try{alert(Lb);return;var J=I.indexOf(Mb);if(J!=-1){w=I.substring(J+1);I=I.substring(0,J)}}catch(a){return}}var K;function L(){if(!o){o=true;if(!__gwt_stylesLoaded[Nb]){var a=l.createElement(Ob);__gwt_stylesLoaded[Nb]=a;a.setAttribute(Pb,Qb);a.setAttribute(Rb,r+Nb);l.getElementsByTagName(Z)[0].appendChild(a)}if(!__gwt_stylesLoaded[Sb]){var a=l.createElement(Ob);__gwt_stylesLoaded[Sb]=a;a.setAttribute(Pb,Qb);a.setAttribute(Rb,r+Sb);l.getElementsByTagName(Z)[0].appendChild(a)}A();if(l.removeEventListener){l.removeEventListener(Tb,L,false)}if(K){clearInterval(K)}}}
if(l.addEventListener){l.addEventListener(Tb,function(){L()},false)}var K=setInterval(function(){if(/loaded|complete/.test(l.readyState)){L()}},50);m&&m({moduleName:O,sessionId:n,subSystem:P,evtGroup:Q,millis:(new Date).getTime(),type:Jb});m&&m({moduleName:O,sessionId:n,subSystem:P,evtGroup:Ub,millis:(new Date).getTime(),type:R});var M=N;if(!z()){M=Vb+r+I+Wb}l.write(Xb+Yb+Zb+$b+_b+ac+bc+$b+_b+cc+dc+M+ec+fc+gc)}
hajjplus();