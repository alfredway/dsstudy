package memory;

import java.nio.ByteBuffer;

public class MemoryUsage {

	private static int byteLen = 128;
	private static int sleepTime = 3000;
	
	public static void main(String[] args) throws InterruptedException {
		byte[] bytes = new byte[byteLen*1000*1000];
		bytes[0] = 1;
		bytes[1] = 2;
		System.out.println("allocate in memory, not the heap memory");
		Thread.sleep(sleepTime);
		ByteBuffer bb = ByteBuffer.allocateDirect(byteLen*1024*1024);
		
		bb.put(bytes);
		//flipÊÇ±ØÐëµÄ
		bb.flip();
		
		bytes = null;
		System.gc();
		System.out.println("after gc runs, the heap space will be freed!");
		Thread.sleep(sleepTime);
		byte[] newbytes = new byte[byteLen*1000*1000];
		
		bb.get(newbytes);
		System.out.println("read bytes from memory into heap!--" + newbytes[1]);
		Thread.sleep(sleepTime);
		
		bytes=null;
//		bb=null;
//		System.gc();
		System.out.println("end");
		Thread.sleep(10000);
	}
}
