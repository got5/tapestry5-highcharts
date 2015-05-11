package org.got5.tapestry5.highcharts.test;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class HighchartsTest extends SeleniumTestCase{
	
	@Test
	public void testJSFile(){
		open("/BasicComponent");
		waitForHighChartsScript();
	}
	
	@Test
	public void testBarCharSample(){
		open("/BarChartSample");
		waitForHighChartsScript();
	}
	
	@Test
	public void testBasicComponent(){
		open("/CustomComponent");
		waitForHighChartsScript();	
	}
	
	@Test
	public void testLineChartComponent(){
		open("/LineChartSample");
		waitForHighChartsScript();	
	}
	
	@Test
	public void testPieChartComponent(){
		open("/PieChartSample");
		waitForHighChartsScript();	
	}
	
	private void waitForHighChartsScript(){
		new Wait() {
			
			@Override
			public boolean until() {
				return isElementPresent("//head/script[contains(@src,'highcharts.src.js')]");
			}
		}.wait("The HighCharts JavaScript file is missing.", 5000l);
	}
}
