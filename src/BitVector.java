import java.util.BitSet;
class BitVector {
	
	private BitSet bitset;
	
	public BitVector(){
		bitset = new BitSet();
	}
	
	public boolean contains(int n)
	{
		return bitset.get(n);
	}
	
	public void add(int n)
	{
		bitset.set(n);
	}
	
	public void remove(int n)
	{
		bitset.set(n,false);
	}
	
}