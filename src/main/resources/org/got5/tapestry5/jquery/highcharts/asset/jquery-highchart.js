(function( $ ) {
	
	T5.extendInitializers(function(){
		
		function highcharts(spec){
			var params = {};
			var extra = $("#" + spec.id).data('highcharts');
			if(extra) {
				params = extra;
			}
			
			$.extend(params, spec.opt);
			
			chart = new Highcharts.Chart(params);
			
			 $("#" + spec.id).removeData('highcharts');
		}
		
		return {
			highcharts : highcharts
		}
		
	});
}) ( jQuery );