//Name: Nithinee Trironnarith
//ID: 6288055
//Section: 2


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	private double number;
	private ArrayList<Double> kal;
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator(double number)
	{
		//******INSERT YOUR CODE HERE***********
		this.number = number;
		kal  = new ArrayList<>();
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		kal.add(number);
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kal.size() != 0){
			kal.remove(0);
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(kal.size() != 0){
			kal.remove(kal.size()-1);
		}
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		if(kal != null) {
			double sum = 0;
			for (double value : kal) {
				sum += value;
			}
			return sum;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		double avg = 0;
		if(kal != null){
			avg = this.getSum()/kal.size();
			return avg;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		if(kal.size()>=2){
			double x=0;
			double mean = getAvg();
			for(int i=0;i<kal.size();i++){
				x = ((kal.get(i)-mean)*(kal.get(i)-mean))+x;
			}
			x = x/kal.size();
			x = Math.sqrt(x);
			return x;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		double max=0;
		if(kal.size() != 0){
			for(int i=0;i<kal.size();i++){
				if(max<kal.get(i)){
					max = kal.get(i);
				}
			}
			return max;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		double min=getMax();
		if(kal.size() != 0){
			for(int i=0;i<kal.size();i++){
				if(min>kal.get(i)){
					min = kal.get(i);
				}
			}
			return min;
		}
		return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double[] fmax = new double[k];
		if(k<=kal.size()){
			for (int i=0;i<k;i++){
				double maxk = 0;
				for(int j=0;j<kal.size();j++){
					if(maxk < kal.get(j)&&fmax[0]!=kal.get(j)&&fmax[1]!=kal.get(j)){
						maxk = kal.get(j);
					}
				}
				fmax[i] = maxk;
			}
			return fmax;
		}
		return null;
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double[] fmin = new double[k];
		if(k<=kal.size()){
			for (int i=0;i<k;i++){
				double mink = getMax();
				for(int j=0;j<kal.size();j++){
					if(mink > kal.get(j)&&fmin[0]!=kal.get(j)&&fmin[1]!=kal.get(j)){
						mink = kal.get(j);
					}
				}
				fmin[i] = mink;
			}
			return fmin;
		}
		return null;
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.print("DATA["+kal.size()+"]:[");

		for(int i = 0;i<kal.size();i++){
			System.out.print(kal.get(i));
			if(i<kal.size()-1){
				System.out.print(", ");
			}
		}
		System.out.println("]");
		//**************************************
	}
}
