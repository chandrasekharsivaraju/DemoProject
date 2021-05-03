public class sample {

	String s= "chadra";
	public static void main(String args[])
	{
		sample obj = new sample();
		
		System.out.println(obj.s);
		obj.s = obj.s.concat("test");
		obj.testFunction(obj.s);
		System.out.println(obj.s);
	}
	
	public void testFunction(String s)
	{
		s=s.concat("sekhar");
		System.out.println(s);
	}
}
