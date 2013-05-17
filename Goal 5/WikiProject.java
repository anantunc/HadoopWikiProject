// main function for application to count the number of
// requests per project per hour 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WikiProject {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: WikiProject <input path> <output path>");
      System.exit(-1);
    }
    //define the job to the JobTracker
    Job job = new Job();
    job.setJarByClass(WikiProject.class);
    job.setJobName("Wiki Project");
    job.setReduceSpeculativeExecution(false);

    // set the input and output paths (passed as args)
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    // set the Mapper and Reducer classes to be called   
    job.setMapperClass(WikiProjectMapper.class);
    job.setReducerClass(WikiProjectReducer.class);

    // set the format of the keys and values
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(LongWritable.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(LongWritable.class);

    // set the number of reduce tasks
    job.setNumReduceTasks(20);

    // submit the job and wait for its completion    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}