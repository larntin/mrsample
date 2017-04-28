package com.dengdd.mrsample;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

public class MaxTemperatureDriverTest {
	
	@Test
	public void test() throws Exception {
		
		// In test env, custom one conf of Standalone Mode using Configuration
		Configuration conf = new Configuration();
		
		conf.set("fs.defaultFS", "file:///");
		conf.set("mapred.job.tracker", "local");

		Path input = new Path("src/main/resources/data/sample.txt");
		Path output = new Path("output");
		
		FileSystem fs = FileSystem.getLocal(conf);
		fs.delete(output, true);
		
		MaxTemperatureDriver driver = new MaxTemperatureDriver();
		driver.setConf(conf);
		
		int exitCode = driver.run(new String[] { input.toString(), output.toString()});
		//assertThat(exitCode, is(0));
	}
	
}
