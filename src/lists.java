
public class lists {

	/**
	 * @param args
	 */
	list head;
	public lists() {
		head = new list();

	}
	
	public void add(int i) {
		list p = head;
		while (p.next != null) {
			p = p.next;
		}
		list l = new list(i);
		p.next = l;
	}
	
	public void print() {
		list p = head;
		while (p.next != null) {
			p = p.next;
			System.out.println(p.data);
		}
	}
	
	
	public void addlist(lists l) {
		list p = l.head;
		list p1 = this.head;
		boolean c = false;
		while (p.next != null || p1.next != null) {
			p = p.next;
			p1 = p1.next;
			int an = p.data + p1.data;
			//System.out.println("ee " + an);
			if (c == true) {
				an = an + 1;
				c = false;
			}
			if (an >= 10) {
				an = an - 10;
				c = true;
			}
			
			System.out.println(an);
		}
		if ( c == true) {
			System.out.println(1);
		}
	}

}
