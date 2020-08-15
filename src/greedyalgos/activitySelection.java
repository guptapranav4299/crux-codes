package greedyalgos;

public class activitySelection {

	public static void printMaxActivities(int start[], int finish[], int n) {
		int i, j;
		System.out.println("Following activities are selected:" + n);

//		first activity is selected 
		i = 0;
		System.out.print(i + " ");

//		iterate through rest of activities
		for (j = 1; j < n; j++) {

//If this activity has start time greater than orequal to the finish time  
//of previously selected activity, then select it 
			if (start[j] >= finish[j]) {
				System.out.print(j + " ");
				i = j;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    int s[] =  {1, 3, 0, 5, 8, 5}; 
	    int f[] =  {2, 4, 6, 7, 9, 9}; 
	    int n = s.length; 
	         
	    printMaxActivities(s, f, n); 
	}

}
