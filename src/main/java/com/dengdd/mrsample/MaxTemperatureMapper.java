package com.dengdd.mrsample;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	//@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		//0043011990999991950051518004+68750+023550FM-12+0382
		//          Year ^^^^
		//99999V0203201N00261220001CN9999999N9-00111+99999999999
		String line = value.toString();
		String year = line.substring(15, 19);
		String tmp = line.substring(87, 92);
		if (!missing(tmp)){
			int airTemperature = Integer.parseInt(line.substring(87, 92));
			context.write(new Text(year), new IntWritable(airTemperature));
		}
	}
	
	private boolean missing(String temp){
		return temp.equals("+9999");
	}

//	@Override
//	public void configure(JobConf arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void close() throws IOException {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> arg2, Reporter reporter)
//			throws IOException {
//		// TODO Auto-generated method stub
//		
//		String line = value.toString();
//		String year = line.substring(15, 19);
//		int airTemperature = Integer.parseInt(line.substring(87, 92));
//		//reporter.write(new Text(year), new IntWritable(airTemperature));
//		
//	}
}
