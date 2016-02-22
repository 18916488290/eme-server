var baiduMaps = function () {
	
	var map;

    var mapBasic = function () {
    	map = new BMap.Map("baidumap");
    	map.centerAndZoom(new BMap.Point(120.94959,31.90506),13);
	
    }
    
	var markers = [
	     			{content:"南通市开发区春天花园",title:"南通市开发区春天花园",status:"4",imageOffset: {width:0,height:3},position:{lat:31.915359,lng:120.933574}},
	     			{content:"南通市开发区江山股份",title:"南通市开发区江山股份",status:"1",imageOffset: {width:0,height:3},position:{lat:32.064665,lng:120.523479}},
	     			{content:"南通市开发区宝灵化工",title:"南通市开发区宝灵化工",status:"4",imageOffset: {width:0,height:3},position:{lat:32.094665,lng:120.742954}},
	     			{content:"南通市开发区清华同方",title:"南通市开发区清华同方",status:"3",imageOffset: {width:0,height:3},position:{lat:32.039974,lng:120.868495}},
	     			{content:"南通市开发区东丽公司",title:"南通市开发区东丽公司",status:"1",imageOffset: {width:0,height:3},position:{lat:31.908287,lng:120.779054}},
	     			{content:"南通市开发区通协纺织",title:"南通市开发区通协纺织",status:"4",imageOffset: {width:0,height:3},position:{lat:32.046917,lng:120.909535}},
	     			{content:"南通市开发区东星皮革",title:"南通市开发区东星皮革",status:"4",imageOffset: {width:0,height:3},position:{lat:32.024461,lng:120.810403}}
	     		  ];
	  
	//创建richMarker地图标注
	 function addMapOverlay(){
		 
			for (var i = 0; i < markers.length; i++) {
				createMarker(i);
			}
	 }
	 function createMarker(i){
		 var color;
		 var marker;
		 var status_=markers[i].status;
		 if(status_=="1"){//正常
			 marker="level.png";
			 color="green";
		 }else if(status_=="2"){//离线
			 marker="level.png";
			 color="#7D7D7D";
		 }else if(status_=="3"){//故障
			 marker="level.png";
			 color="#FF8000";
		 }else if(status_=="4"){//超标
			 marker="level.png";
			 color="#FF0000";
		 }
	
		 var markerHtml = '<div style="position: absolute; margin: 0pt; padding: 0pt; width: 120px; height: 25px; left: -10px; top: -35px; overflow: hidden;">'
				+ '<img style="border:none;left:0px; top:0px; position:absolute;" src="img/mapimg/'+marker+'">';

		var pot = new BMap.Point(markers[i].position.lng,
				markers[i].position.lat);
		var richMarker = new BMapLib.RichMarker(markerHtml, pot, {
			"enableDragging" : false
		});	
		map.addOverlay(richMarker);//添加企业Marker标注
		
		richMarker.addEventListener("onclick",function(e) {
						var title = markers[i].title;
						var  infoWin= createInfoWindow(title);
						var position_=this.getPosition();
						infoWin.open(position_);
								
		});
	 }
	 function createInfoWindow(title){
		 var content = 'hello';
			var infoWindow = new BMapLib.SearchInfoWindow(map, content, {
				title: title, //标题
				offset: new BMap.Size(0,30),
				width: 200,//宽度
				height: 200, //高度
				panel : "panel", //检索结果面板
				enableAutoPan : true, //自动平移
				searchTypes :[
				]
			});
		return infoWindow;
	 }
   
    return {
        //main function to initiate map samples
        riskSourceMap: function () {
            mapBasic();
            addMapOverlay();

        }

    };

}();