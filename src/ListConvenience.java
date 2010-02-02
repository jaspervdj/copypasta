import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

class ListConvenience {
	
	public static int min(Collection<Integer> e)
	{
		if(e.size() == 0){
			return -1;
		}
		Iterator<Integer> it = e.iterator();
		int min = it.next();
		while(it.hasNext()){
			int next = it.next();
			if(next < min) min = next;
		}
		return min;
	}
	
	public static int min(int[] e)
	{
		if (e.length == 0){
			return -1;
		}
		int min = e[0];
		for (int i = 1; i<e.length; i++) {
			if(e[i] < min) min = e[i];
		}
		return min;
	}
	
	public static int max(Collection<Integer> e)
	{
		if(e.size() == 0){
			return -1;
		}
		Iterator<Integer> it = e.iterator();
		int max = it.next();
		while(it.hasNext()){
			int next = it.next();
			if(next > max) max = next;
		}
		return max;
	}
	
	public static int max(int[] e)
	{
		if (e.length == 0){
			return -1;
		}
		int max = e[0];
		for (int i = 1; i<e.length; i++) {
			if(e[i] > max) max = e[i];
		}
		return max;
	}
	
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
		
		Test.test("min([0:9])",min(list)== 0);
		Test.test("min([0:9])",min(arr)== 0);
	
	}
	
}