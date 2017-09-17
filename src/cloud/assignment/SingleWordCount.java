package cloud.assignment;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class SingleWordCount {

	public static void main(String[] args) throws Exception {
		
		Job count = Job.getInstance(new Configuration());
		
		count.setJarByClass(SingleWordCount.class);
		
		count.setOutputKeyClass(Text.class);
		count.setOutputValueClass(IntWritable.class);
		
		count.setMapperClass(MyMap.class);
		count.setReducerClass(MyReduce.class);

		count.setInputFormatClass(TextInputFormat.class);
		count.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(count, new Path(args[0]));
		FileOutputFormat.setOutputPath(count, new Path(args[1]));

		System.exit(count.waitForCompletion(true) ? 0 : 1);
	}

}
