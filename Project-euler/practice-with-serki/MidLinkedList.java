public class MidLinkedList{
	public static void main(String[] args){
		LinkedList list = new LinkedList();		

		list.add(new LinkedList.Node("1"));
		list.add(new LinkedList.Node("2"));
		list.add(new LinkedList.Node("3"));
		list.add(new LinkedList.Node("4"));
		list.add(new LinkedList.Node("5"));
		list.add(new LinkedList.Node("6"));
		list.add(new LinkedList.Node("7"));
		list.add(new LinkedList.Node("8"));
		list.add(new LinkedList.Node("9"));
		list.add(new LinkedList.Node("10"));


		LinkedList.Node curNode = list.head();

		while(curNode != null){
			System.out.println(curNode.toString());
			curNode = curNode.next();
		}
		
		System.out.println("the middle value is : " + findMiddle(list).data().toString());
	}

	public static LinkedList.Node findMiddle(LinkedList list){
		LinkedList.Node middle = list.head();
		LinkedList.Node middleToMax = list.head();

		while(middleToMax.next() != null || middleToMax.next().next() != null){
			middle = middle.next();
		
			middleToMax = middleToMax.next().next();	
			
		}

		return middle;
	}
}