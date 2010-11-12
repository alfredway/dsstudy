package alfred.test;

public class TestIdea implements Cloneable{

	int i;
	int j;
	
	


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}



	public static void main(String[] args) throws CloneNotSupportedException {
		TestIdea ti1=new TestIdea();
		ti1.i=2;
		TestIdea ti2=(TestIdea)ti1.clone();
		System.out.println(ti1.i+"-"+ti2.i);
		
		ti2.i=4;
		System.out.println(ti1.i+"-"+ti2.i);
	}
}
