package com.dengdd.mrsample;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class SMSCDRReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws java.io.IOException, InterruptedException {
		int sum = 0;
		for (IntWritable value : values) {
			sum += value.get();
		}
		context.write(key, new IntWritable(sum));
	}
}