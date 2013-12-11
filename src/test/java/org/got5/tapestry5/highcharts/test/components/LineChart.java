package org.got5.tapestry5.highcharts.test.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONLiteral;
import org.apache.tapestry5.json.JSONObject;
import org.got5.tapestry5.jquery.highcharts.components.AbstractHighCharts;

public class LineChart extends PrintableComponent implements ClientElement{

	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String mainTitle;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String yAxisTitle;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.PROP)
	private JSONArray xAxisCategories;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String toolTipFormaterFunction;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.PROP)
	private JSONArray series;
	
	
	@Override
	public JSONObject getComponentOptions() {
		
		JSONObject res= new JSONObject();
		
		JSONObject chart= new JSONObject();
		chart.put("renderTo", this.getClientId());
		chart.put("type", "line");
		chart.put("marginRight", 130);
		chart.put("marginBottom", 25);
		res.put("chart", chart);
		
		JSONObject title= new JSONObject();
		title.put("text", "Monthly Average Temperature");
		title.put("x", -20);
		res.put("title", title);
		
		JSONObject xAxis= new JSONObject();
		xAxis.put("categories", this.xAxisCategories);
		res.put("xAxis", xAxis);
		
		JSONObject yAxis= new JSONObject();
		JSONObject yAxis_title= new JSONObject();
		yAxis_title.put("title", this.yAxisTitle);
		JSONObject yAxis_plotLines_content=new JSONObject();
		yAxis_plotLines_content.put("value", 0);
		yAxis_plotLines_content.put("width", 1);
		yAxis_plotLines_content.put("color", "#808080");
		JSONArray yAxis_plotLines= new JSONArray(yAxis_plotLines_content);
		yAxis.put("title", yAxis_title);
		yAxis.put("plotLines", yAxis_plotLines);
		res.put("yAxis", yAxis);
		
		JSONObject tooltip= new JSONObject();
		tooltip.put("formatter", new JSONLiteral(toolTipFormaterFunction));
		res.put("tooltip", tooltip);
		
		JSONObject legend= new JSONObject();
		legend.put("layout","vertical");
		legend.put("align","right");
		legend.put("verticalAlign","top");
		legend.put("x",-10);
		legend.put("y",100);
		legend.put("borderWidth",0);
		res.put("legend", legend);
		
		res.put("series", series);
		
		return res;
	}
	

	
	
	
	
	
	
	
	
	
	

}
