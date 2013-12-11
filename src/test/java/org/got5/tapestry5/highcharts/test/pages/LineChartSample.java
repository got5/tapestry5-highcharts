package org.got5.tapestry5.highcharts.test.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

@Import(stylesheet="context:css/samples.css")
public class LineChartSample {
	
	
	public JSONArray getCategories(){
		return new JSONArray(
				"Jan", "Feb", "Mar", "Apr", "May", "Jun",
				"Jul", "Aug","Sep", "Oct", "Nov", "Dec"
		);
	}
	
	public JSONArray getSeries(){
		
		JSONObject serie1= new JSONObject();
		serie1.put("name", "Tokyo");
		serie1.put("data", new JSONArray(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6));
		JSONObject serie2= new JSONObject();
		serie2.put("name", "New York");
		serie2.put("data", new JSONArray(-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5));	
		JSONObject serie3= new JSONObject();
		serie3.put("name", "Berlin");
		serie3.put("data", new JSONArray(-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0));
		
		return new JSONArray(serie1, serie2, serie3);		
	}

}
