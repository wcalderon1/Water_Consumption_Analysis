import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

public class WaterConsumptionMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
    private Text waterCharge = new Text();

    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {

        if (key.get() == 0) return;


        String[] tokens = value.toString().trim().split("\\s+");
        if (tokens.length >= 2) {
            try {
                int consumption = Integer.parseInt(tokens[0]);
                String charge = tokens[1];
                waterCharge.set(charge);
                output.collect(waterCharge, new IntWritable(consumption));
            } catch (NumberFormatException e) {
            }
        }
    }
}
