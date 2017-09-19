package cloud.assignment;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMap extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputStr = value.toString();
		//inputStr = inputStr.replace(".", " ");
		String[] lines = inputStr.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			// divide input string by line
			String filterLine = new String(lines[i].trim());

			// Get word from each line and combine two consequetive words
			String[] arrWords = filterLine.split(" ");
			for (String eachWord : arrWords) {
				if(!eachWord.trim().isEmpty()){
					Text outputKey = new Text(eachWord.trim());
					IntWritable outputValue = new IntWritable(1);
					context.write(outputKey, outputValue);
				}
			}
		}
		
	}

}