
public class queue {

	/**
	 * @param args
	 */
	Stack in;
	Stack out;
	public queue() {
		// TODO Auto-generated method stub
		in = new Stack();
		out = new Stack();
	}

	public void add(Node n) {
		in.push(n);
	}
	
	public Node delete() {
		if (out.peek() == null) {
			//System.out.println("empty");
			while (in.peek() != null) {
				//System.out.println("emptys");
				Node t = in.pop();
				out.push(t);
				
			}
		}
		//System.out.println("qq");
		return out.pop();
	}
}
