// map function for application to count the number of
// requests per project per hour 
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.net.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WikiProjectMapper
  extends Mapper<LongWritable, Text, Text, LongWritable> {
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
        String line = value.toString();
        String[] tokens = line.split("\\s");
        String projectName = new String();
        long numRequests = 0;

        if (tokens.length > 2) {
           // get the project name field
	    projectName = tokens[0] + " " +tokens[4] ; 

           // get the number of requests field
	    numRequests = Long.parseLong(tokens[2]); 

           // output the key, value pairs where the key is a combination of
           // project name and datetime and the value is number of requests
           context.write(new Text(projectName), new LongWritable(numRequests));
	}  
   }
}
