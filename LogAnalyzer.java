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
     * 
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
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
        
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
    }
}
