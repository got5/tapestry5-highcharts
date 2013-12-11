package org.got5.tapestry5.highcharts.test.components;

import org.apache.tapestry5.annotations.Import;
import org.got5.tapestry5.jquery.highcharts.components.AbstractHighCharts;


@Import(library="${jquery.highcharts.core.path}/modules/exporting.src.js")
public class PrintableComponent  extends AbstractHighCharts {

}
