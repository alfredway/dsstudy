package alfred.ds;

import java.util.List;

public class ListTest<T> {
	ListTest<T> next;
	T val;
	
	//尾插法用到的变量
	ListTest<T> tail;
	
	public ListTest(){
		this(null);
	}
	
	public ListTest(T next){
		this.val=next;
		this.next=null;
	}
	
	//头插入的方法
	public void addByHead(T val){
		if(this.val==null){
			this.val=val;
			this.next=null;
		}else{
			ListTest<T> newN=new ListTest<T>(val);
			if(this.next==null){
				this.next=newN;
			}else{
				newN.next=this.next;
				this.next=newN;
			}
		}
	}
	
	
	public void addByTail(T val){
		ListTest<T> tmpT=new ListTest<T>(val);
		if(this.val==null){
			this.val=val;
		}else if(this.next==null){
			this.next=this.tail.next=tmpT;
		}else{
			//尾插法的实现部分
			tail.next.next=tmpT;
			tail.next=tmpT;
		}
		
	}
	
	//将一个列表中的值反转
	public void reverseList(ListTest<String> list){
		
	}
	
	public void print(){
		ListTest<T> tmp=this;
		while(tmp!=null){
			System.out.print(tmp.val.toString()+">>");
			tmp=tmp.next;
		}
		System.out.println("\nthis is "+this.val);
	}
	
	public static void main(String[] args) {
		String[] strArr={"alfred","eric","daisy","vera","way"};
		ListTest<String> list=new ListTest<String>("hah");
		for(String s:strArr){
			list.addByHead(s);
		}
		list.print();
		list.clear();
		list.tail=new ListTest<String>();
		
		for(String s:strArr){
			list.addByTail(s);
		}
		list.print();

	}

	private void clear() {
		this.val=null;
		if(this.next!=null)
			this.next.clear();
		this.next=null;
		
	}
}
