import java.util.List;
import java.util.ArrayList;

/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    /* Question 1
     * 10-14-18 (hr)
     * 
     * Question 2
     * private Person[] people;
     * 
     * Question 4
     * It's often used in fields, constructors and methods.
     * 
     * Question 7 
     * 20 Strings objects are created
     * 
     * Question 9
     * It doesn't work, because we only have 24 hours and the 0 is included so when
     * we add the sign "=" we are including the number 24 so when we count from 0 to 24
     * it makes 25 hours and there's no 25 hours.
     * 
     * Question 17
     * If multiple hours have the same max count, this method only returns the first one.
     * 
     */
    
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    // Question 3
    private boolean[] vaccant;
    
    // Question 5
    public int[] counts;
    public boolean[] occupied;
    
    //Question 6
    public double[] reading;
    public String[] urls;
    // TicketMachine[] machines;
    
    //Question 8
    double[] prices;

    /**
     * Create an object to analyze hourly web accesses.
     */
    
    //Question 12
    public LogAnalyzer(String fileName)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        
        //Question12
        
        reader = new LogfileReader(fileName);
        
        //Question 5
        occupied = new boolean [5000];
        
        //Question 6
        reading = new double [60];
        urls = new String[90];
        //TicketMachine = new TicketMachine [5];
        
        // Question 8 
        prices = new double[50];
        
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        // Question 10
        int hour = 0;
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
        // Question 11
        double[] marks = {2.2,4.2,4.7,9.2,4.8};
        printGreater(marks,4.0);
    }
    //Question 11
    /** * Print all the values in the marks array that are greater than mean.
        * @param marks An array of mark values.
        * @param mean The mean (average) mark. */
        
    public void printGreater(double[] marks, double mean) { 
        for(int index = 0; index < marks.length; index++) {
            if(marks[index] > mean) {
                System.out.println(marks[index]);
            } 
        } 
    }
    // Question 13
    /** * Return the number of accesses recorded in the log file. */ 
    public int numberOfAccesses() { 
        int total = 0;
        for (int i = 0; i < hourCounts.length; i++) { 
            total += hourCounts[i]; 
        }
        return total;
    } 
    //Question 15 
    // for loop is better to use in this case
    public int busiestHour() {
        int maxHour = 0;
        int maxAccesses = hourCounts[0];

        for (int i = 1; i < hourCounts.length; i++) { 
            if (hourCounts[i] > maxAccesses) { 
                maxAccesses = hourCounts[i]; 
                maxHour = i; 
            }
        }

        return maxHour; 
    }
    //Question 16
    public int quietestHour() {
        int minHour = 0;  // Stores the hour with the least accesses
        int minAccesses = hourCounts[0];  // Start with the first hour’s accesses

        for (int i = 1; i < hourCounts.length; i++) { 
            if (hourCounts[i] < minAccesses) { 
                minAccesses = hourCounts[i]; 
                minHour = i; 
            }
        }

        return minHour; 
    }
    //Question 18
    public List<Integer> busiestHours() {
        int maxAccesses = 0;
        List<Integer> busiestHours = new ArrayList<>();

        // First loop: Find the max count
            for (int i = 0; i < hourCounts.length; i++) { 
                if (hourCounts[i] > maxAccesses) { 
                    maxAccesses = hourCounts[i]; 
                }
            }

        // Second loop: Collect all hours with the max count
            for (int i = 0; i < hourCounts.length; i++) { 
                if (hourCounts[i] == maxAccesses) { 
                    busiestHours.add(i);
                }
            }

        return busiestHours;
    }
}
