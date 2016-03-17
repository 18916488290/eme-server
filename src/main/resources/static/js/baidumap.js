var baiduMaps = function () {
	
    var mapBasic = function () {
        $.getCenter(function(data){
            map.centerAndZoom(new BMap.Point(data.lng,data.lat),12);
         });
	
    }

	var add_control=function (){
		
		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
		var mapType = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
		var overView = new BMap.OverviewMapControl();
		var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
		map.addControl(top_left_control);        
		map.addControl(top_left_navigation);  
		map.addControl(mapType);    
		map.addControl(overView);          //添加默认缩略地图控件
		map.addControl(overViewOpen);      //右下角，打开
	}

    var setMapEvent=function(){
        map.enableDragging();
   
      }
    
    
    
    // 用经纬度设置地图中心点
     var theLocation=function (map,sourceId,lng,lat){
		var new_point = new BMap.Point(lng,lat);
		map.panTo(new_point);   
		map.setZoom(13);
		map.clearOverlays(); 
		addMapOverlay(sourceId);
    }

   // Local search
    var localSearch = function(map,sourceId,lng,lat,s){
		var new_point = new BMap.Point(lng,lat);
		map.panTo(new_point);
		map.setZoom(13);
		map.clearOverlays(); 
		addMapOverlay(-1000);
		var circle = new BMap.Circle(new_point,5000,{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
	    map.addOverlay(circle);
	    var local =  new BMap.LocalSearch(map, {renderOptions: {map: map, autoViewport: false}});  
	    local.searchNearby(s,new_point,5000);
    }
       
   var addClickHandler=function(target,window){
       target.addEventListener("click",function(){
          window.open(target.getPosition());
       });
     }
   
    return {
        init: function (map) {
            mapBasic(map);
            add_control(map);
            setMapEvent(map);
        },
       theLocation:function(map,sourceId,lng,lat)
       {
    	   theLocation(map,sourceId,lng,lat);
       },
        localSearch:function(map,sourceId,lng,lat,s)
        {
        	localSearch(map,sourceId,lng,lat,s);
        },
        addClickHandler:function(target,window)
        {
        	addClickHandler(target,window);
        }

    };

}();