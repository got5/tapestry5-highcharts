package org.got5.tapestry5.highcharts.test.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

@Import(stylesheet="context:css/samples.css")
public class BarChartSample {
	
	
	public JSONArray getCategories(){
		return new JSONArray("Jan","Feb","Mar");
	}
	
	public JSONArray getSeries(){
		JSONObject serie1= new JSONObject();
		serie1.put("name", "Tokyo");
		serie1.put("data", new JSONArray(49.9, 71.5, 106.4));
		JSONObject serie2= new JSONObject();
		serie2.put("name", "New York");
		serie2.put("data", new JSONArray(83.6, 78.8, 98.5));		
		JSONObject serie3= new JSONObject();
		serie3.put("name", "London");
		serie3.put("data", new JSONArray(48.9, 38.8, 39.3));	

		return new JSONArray(serie1, serie2, serie3);
	}


}
