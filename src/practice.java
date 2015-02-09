import java.util.ArrayList;


public class practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		queue q = new queue();
		q.add(n);
		q.add(n1);
		q.add(n2);
		q.add(n3);
		System.out.println(q.delete().data);
		System.out.println(q.delete().data);
		System.out.println(q.delete().data);
		System.out.println(q.delete().data);
		System.out.println("ss");
		
	}

}
