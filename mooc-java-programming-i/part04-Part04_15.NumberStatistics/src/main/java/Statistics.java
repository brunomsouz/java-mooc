
public class Statistics {
    private int count;
    private int sum;
    
    public Statistics() {
        
    }
    
    public void addNumber(int number) {
        this.count += 1;
        this.sum += number;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public int sum() {
        return this.sum;
    }
    
    public double average() {
        if (this.count > 0) {
            return (double) this.sum / this.count;
        } else {
            return this.sum;
        }
    }
}
