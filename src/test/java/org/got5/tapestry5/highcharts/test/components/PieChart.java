package org.got5.tapestry5.highcharts.test.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONLiteral;
import org.apache.tapestry5.json.JSONObject;
import org.got5.tapestry5.jquery.highcharts.components.AbstractHighCharts;

public class PieChart extends AbstractHighCharts implements ClientElement{
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String mainTitle;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String tooltipFormatter;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.PROP)
	private JSONArray dataSerie;
	
	
	@Override
	public JSONObject getComponentOptions() {
		
		JSONObject res= new JSONObject();
		
		JSONObject chart=new JSONObject();
		chart.put("renderTo", this.getClientId());
		chart.put("plotBackgroundColor", null);
		chart.put("plotBorderWidth", null);
		chart.put("plotShadow", false);
		res.put("chart", chart);
		
		JSONObject title=new JSONObject();
		title.put("text", mainTitle);
		res.put("title", title);
		
		JSONObject tooltip=new JSONObject();
		tooltip.put(
				"formatter", 
				new JSONLiteral(this.tooltipFormatter));
		res.put("tooltip", tooltip);
		
		JSONObject plotOptions= new JSONObject();
		JSONObject pie= new JSONObject();
		pie.put("allowPointSelect", true);
		pie.put("cursor", "pointer");
		JSONObject dataLabels= new JSONObject();
		dataLabels.put("enabled", true);
		dataLabels.put("format", "<b>{point.name}</b>: {point.y:.1f} %");
		dataLabels.put("style", new JSONObject("color", "(Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'"));
		pie.put("dataLabels", dataLabels);
		plotOptions.put("pie", pie);
		res.put("plotOptions", plotOptions);
		
		JSONArray series= new JSONArray();
		JSONObject serie1= new JSONObject();
		serie1.put("type", "pie");
		serie1.put("name", "Browser share");
		
		serie1.put("data", dataSerie);
		


		series.put(serie1);
		res.put("series", series);
		
		return res;
	}	

}
