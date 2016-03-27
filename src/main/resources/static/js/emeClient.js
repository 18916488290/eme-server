;(function($, window, document,undefined) {

    //$clientURL = "http://localhost:8080/eme/";
      $clientURL = "/eme/api/";


    $.EMEClient = function (path,opt,callback) {
      var defaults = {
                    'url':        $clientURL+path,
                    'type':        'GET',
                    'dataType':    'json',
                    'contentType': 'application/json; charset=UTF-8',
                    'data':         {},
                     headers:      {} 
        };
     var options = $.extend({}, defaults, opt);
       $.ajax({
                    url:          options.url,
                    type:         options.type,
                    dataType:     options.dataType,
                    contentType:  options.contentType,
                    data:         options.data,
                    headers:      options.headers,
                    success: function(data, textStatus){
                         callback(data);

                       }
                 });


    };


     //0. 中心点
     $.getCenter = function(callback){
             $.EMEClient('getCenter',{},callback);
 
     };

     //1. 风险源标注
     $.getRiskSourcesMarkers = function(callback){
             $.EMEClient('getRiskSourcesMarkers',{},callback);
 
     };
     
     //1. 风险源标注
     $.getPullantSourcesMarkers = function(callback){
             $.EMEClient('getPullantSourcesMarkers',{},callback);
 
     };
     
     
     //1. 监测站标注
     $.getDetectStationMarkers = function(callback){
             $.EMEClient('getDetectStationMarkers',{},callback);
 
     };
     //1. 在线监测标注
     $.getCompanyMarkers = function(callback){
             $.EMEClient('getCompanyMarkers',{},callback);
 
     };
     
     //1.得到水环境
     $.getWaterEnv = function(waterEnvId, callback){
             $.EMEClient('getWaterEnv',{data:{"waterEnvId":waterEnvId}},callback);
 
     };
     
     
     //1.得到气环境
     $.getAirEnv = function(airEnvId, callback){
             $.EMEClient('getAirEnv',{data:{"airEnvId":airEnvId}},callback);
 
     };
     
     
     //1.得到10天前的X轴
     $.lastTenDaysCategories = function(callback){
             $.EMEClient('lastTenDaysCategories',{dataType:'text'},callback);
 
     };
     
     
})(jQuery, window, document);