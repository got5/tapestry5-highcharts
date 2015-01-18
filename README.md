HighCharts Component Library for Tapestry 5.3.3 and Tapestry5-jQuery 3.3.3

# How to write a custom graph
This component library only contains one basic Highcharts component. You can normally do everything with this simple component. You can also create your own HighCharts component, by extending this simple implementation. Thenonly thing important, is to override the getComponentOptions method, that will return the JSON object need for the initialization of your chart. 

Here is a new BarChart component extending the basic AbstractHighCharts class
```java
package org.got5.tapestry5.highcharts.test.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import org.got5.tapestry5.jquery.highcharts.components.AbstractHighCharts;

public class BarChart extends AbstractHighCharts implements ClientElement{
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)
	private String title;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)	
	private String subTitle;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.LITERAL)	
	private String yAxisTitle;	
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.PROP)	
	private JSONArray categories;
	
	@Property
	@Parameter(required=true, defaultPrefix=BindingConstants.PROP)	
	private JSONArray series;	
	
	
	
	
	@Override
	public JSONObject getComponentOptions() {
		
		JSONObject res= new JSONObject();
		
		JSONObject chart=new JSONObject();
		chart.put("renderTo", this.getClientId());
		chart.put("type", "column");
		res.put("chart", chart);
		
		res.put("title", new JSONObject("text", title));
		res.put("subtitle", new JSONObject("text", this.subTitle));
		JSONObject xAxis= new JSONObject();
		xAxis.put("categories", categories);
		res.put("xAxis", xAxis );
		
		JSONObject yAxis= new JSONObject();
		yAxis.put("min", 0);
		yAxis.put("title", new JSONObject("text", yAxisTitle));
		res.put("yAxis", yAxis);
		
		//JSONObject tooltip= new JSONObject();
		//tooltip.put("headerFormat", "<span style=\"font-size:10px\">{point.key}</span><table>");
		//tooltip.put("pointFormat", "<tr><td style=\"color:{series.color};padding:0\">{series.name}:</td><td style=\"padding:0\"><b>{point.y} mm</b></td></tr>");
		//tooltip.put("footerFormat", "</table>");
		//tooltip.put("shared", true);
		//tooltip.put("useHTML", true);
		//res.put("tooltip", tooltip);
		
		JSONObject plotOptions= new JSONObject();
		JSONObject column= new JSONObject();
		column.put("pointPadding", 0.2);
		column.put("borderWidth", 0);
		plotOptions.put("column", column);
		res.put("plotOptions", plotOptions);

		res.put("series", series);

		return res;
	}	

}
```


# Questions? Ideas? Comments?
* http://groups.google.com/group/tapestry5-jquery
