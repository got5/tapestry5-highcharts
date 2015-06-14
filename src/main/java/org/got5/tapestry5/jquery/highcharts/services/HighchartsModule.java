package org.got5.tapestry5.jquery.highcharts.services;

import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.got5.tapestry5.jquery.highcharts.HighChartsSymbolConstants;

public class HighchartsModule {

	public static void contributeJavaScriptStackSource(
			MappedConfiguration<String, JavaScriptStack> configuration) {
		
		configuration.addInstance(
				HighChartsMainStack.STACK_ID,
				HighChartsMainStack.class);
		configuration.addInstance(
				HighChartsJqueryStack.STACK_ID,
				HighChartsJqueryStack.class);		
		configuration.addInstance(
				HighChartsExportStack.STACK_ID,
				HighChartsExportStack.class);
	}

	public static void contributeComponentClassResolver(
			Configuration<LibraryMapping> configuration) {
		configuration.add(new LibraryMapping("jquery-highcharts",
				"org.got5.tapestry5.jquery.highcharts"));
	}

	public static void contributeClasspathAssetAliasManager(
			MappedConfiguration<String, String> configuration) {
		configuration.add("tap-jquery-highcharts", "META-INF/modules/highcharts");
	}
	
	public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration)
    {
		
        configuration.add(HighChartsSymbolConstants.JQUERY_HIGHCHARTS_CORE_PATH, "classpath:META-INF/modules/highcharts");
        
    }
}
