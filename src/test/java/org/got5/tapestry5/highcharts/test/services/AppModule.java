package org.got5.tapestry5.highcharts.test.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;
import org.got5.tapestry5.jquery.highcharts.services.HighchartsModule;

@SubModule(HighchartsModule.class)
public class AppModule {
	
	public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration)
    {
       
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
        
    }
	
}
