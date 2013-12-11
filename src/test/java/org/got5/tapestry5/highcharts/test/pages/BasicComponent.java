package org.got5.tapestry5.highcharts.test.pages;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

public class BasicComponent {
	
	@Inject
	private JavaScriptSupport javascript;
	
	
	
	private JSONObject getExportOptions(){
		
		JSONObject opt = new JSONObject();
		opt.put("width", 500);
		opt.put("height", 250);
		
		return opt;		
	}
	
	
	public JSONObject getOptions(){
		JSONObject opt = new JSONObject();
		opt.put("text", "Source: WorldClimate.com");
		opt.put("x", -20);
		
		JSONObject high = new JSONObject();
		high.put("subtitle", opt);
		high.put("exporting", getExportOptions());
		
		return high;
	}
	
	@AfterRender
	public void afterRender(){
		javascript.addInitializerCall(InitializationPriority.EARLY, "basicComponent", new JSONObject());
		javascript.addInitializerCall("documentation", new JSONObject());
	}
}
