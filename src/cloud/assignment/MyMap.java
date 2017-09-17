package cloud.assignment;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMap extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputStr = value.toString();
		inputStr = inputStr.replace(".", " ");
		String[] arrWords = inputStr.split(" ");
		for (String eachWord : arrWords) {
			Text outputKey = new Text(eachWord.trim());
			IntWritable outputValue = new IntWritable(1);
			context.write(outputKey, outputValue);
		}
	}

}