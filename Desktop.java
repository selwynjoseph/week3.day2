package week3.day2;

public class Desktop implements Hardware, Software{

	public static void main(String[] args) {
		
		Desktop d=new Desktop();
		d.hardwareResources();
		d.softwareResources();

	}

	public void softwareResources() {
		
		System.out.println("Software Resources are eclipse, webex");
	}

	public void hardwareResources() {
		
		System.out.println("Hardware Resources are pc, laptop, mouse");
	}

}
