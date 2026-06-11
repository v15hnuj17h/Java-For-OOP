// Expected Output:
// Marks: 85 90 78 92 88
// Highest: 92
// Lowest : 78
// Average: 86.6

public class ArrayStatistics{
    public static void main(String[] args){
        int[] marksheet = {85,90,78,92,88};
        int highest = marksheet[0];
        int lowest = marksheet[0];
        int total=highest;
        System.out.print("Marks: "+highest);
        for (int i=0; i<marksheet.length-1;i++){
            System.out.print(" "+marksheet[i+1]);
            if(marksheet[i]<marksheet[1+i]){
                highest = marksheet[1+i];
                lowest = marksheet[i];
            }
            total+=marksheet[i+1];
        }
        double average = (double)total/marksheet.length;
        System.out.printf("\nHighest: "+highest+"\n");
        System.out.println("Lowest: "+lowest);
        System.out.println("Average: "+average);
    }
}