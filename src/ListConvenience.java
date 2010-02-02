import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

class ListConvenience {
	
	public static int sum(Collection<Integer> e)
	{
		int sum = 0;
		
		Iterator<Integer> it = e.iterator();
		while(it.hasNext()){
			sum += it.next();
		}
		return sum;
	}	
	
	public static int sum(int[] arr)
	{
		int sum = 0;
		for (int i = 0; i<arr.length; i++) {
			sum+= arr[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] arr = new int[9];
		for (int i =0; i< 9; i++) {
			arr[i] = i;
			list.add(i);
		}
		Test.test("sum([0:9])",sum(list) == 36);
		Test.test("sum([0:9])",sum(arr) == 36);
	}
	
}