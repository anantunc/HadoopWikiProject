// reduce function for application to count the number of
// requests per project per hour 
import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.String.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.util.*;
import org.apache.hadoop.mapreduce.Reducer;

public class WikiProjectReducer
  extends Reducer<Text, LongWritable, Text, LongWritable> {
  @Override
  public void reduce(Text key, Iterable<LongWritable> values, Context context)
      throws IOException, InterruptedException {

      long count = 0;
      // iterate through all the values (count == 1) with a common key
      for (LongWritable value : values) {
          count = count + value.get();
      }
     context.write(key, new LongWritable(count));
  }
}