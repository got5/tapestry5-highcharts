package org.got5.tapestry5.highcharts.test.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;

@Import(stylesheet="context:css/samples.css")
public class PieChartSample {
	
	
	public JSONArray getSeries(){
		
		return
		new JSONArray(
				new JSONArray("Firefox", 45.0),
				new JSONArray("IE", 26.8),
				new JSONArray("Chrome", 12.8),
				new JSONArray("Safari", 8.5),
				new JSONArray("Opera", 6.2),
				new JSONArray("Others", 0.7)
		);
	}

}
