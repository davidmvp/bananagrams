package edu.jhu.cs.dlu6.oose;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.Position;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterIllegalMoveEvent;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterModel;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterModelListener;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterTile;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterTileMovedEvent;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterTilePlayedEvent;

/**
 * This is class implements ShuffletterModel.
 * @author davidmvp23
 *
 */
public class MyShuffletterModel implements ShuffletterModel {

     /**
      ** A hash map to store all the tiles.
      **/

    private HashMap<Position, ShuffletterTile> alltiles;
    /**
    * A list to keep track of all tiles in the supply.
    */
    private List<ShuffletterTile> supply;
    /**
    * A list to keep track of all tiles in the bag.
    */
    private List<ShuffletterTile> bag;
    /**
    * A list of all listeners.
    */
    private List<ShuffletterModelListener> listeners;
    /**
     * * A set of words storing all the words in a set.
    */
    private Set<String> words = new HashSet<String>();
    /**
     * * hori, verti and isWild are all used to check wildTiles.
    */
    boolean isWild;
    private ArrayList<String> hori;
    private ArrayList<String> verti;
    /**
     * Constructor for myshuffletterModel.
     * @throws IOException
     */
    public  MyShuffletterModel() throws IOException{
        /**
         * * Initialize all the variables
        */
        this.listeners = new LinkedList<ShuffletterModelListener>();
        this.supply = new LinkedList<ShuffletterTile>();
        this.bag = new LinkedList<ShuffletterTile>();
        this.alltiles = new HashMap<Position, ShuffletterTile>();
        this.hori = new ArrayList<String>();
        this.verti = new ArrayList<String>();

        /**
         * Read the file and
         * */
        BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                this.words.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        /**
         * Make all the tiles and add them into bags.
         */
        
        /**
        for (int i = 0; i < 2; i++) {
            MyShuffletterTile t = new MyShuffletterTile('J');
            MyShuffletterTile t1 = new MyShuffletterTile('K');
            MyShuffletterTile t2 = new MyShuffletterTile('Q');
            MyShuffletterTile t3 = new MyShuffletterTile('X');
            MyShuffletterTile t4 = new MyShuffletterTile('Z');
            this.bag.add(t);
            this.bag.add(t1);
            this.bag.add(t2);
            this.bag.add(t3);
            this.bag.add(t4);
        }

        for (int i = 0; i < 3; i++) {
			MyShuffletterTile t = new MyShuffletterTile('F');
			MyShuffletterTile t1 = new MyShuffletterTile('H');
			MyShuffletterTile t2 = new MyShuffletterTile('M');
			MyShuffletterTile t3 = new MyShuffletterTile('P');
			MyShuffletterTile t4 = new MyShuffletterTile('V');
			MyShuffletterTile t5 = new MyShuffletterTile('W');
			MyShuffletterTile t6 = new MyShuffletterTile('Y');
			MyShuffletterTile t7 = new MyShuffletterTile('C');
			MyShuffletterTile t8 = new MyShuffletterTile('B');
			this.bag.add(t);
			this.bag.add(t1);
			this.bag.add(t2);
			this.bag.add(t3);
			this.bag.add(t4);
			this.bag.add(t5);
			this.bag.add(t6);
			this.bag.add(t7);
			this.bag.add(t8);
		}
		
		for (int i = 0; i < 4; i++) {
			MyShuffletterTile t = new MyShuffletterTile('G');
			this.bag.add(t);
		}
		
		for (int i = 0; i < 5; i++) {
			MyShuffletterTile t = new MyShuffletterTile('L');
			this.bag.add(t);
		}
		
		for (int i = 0; i < 6; i++) {
			MyShuffletterTile t = new MyShuffletterTile('D');
			MyShuffletterTile t1 = new MyShuffletterTile('S');
			MyShuffletterTile t2 = new MyShuffletterTile('U');
			this.bag.add(t);
			this.bag.add(t1);
			this.bag.add(t2);
		}
		
		for (int i = 0; i < 8; i++) {
			MyShuffletterTile t = new MyShuffletterTile('N');
			this.bag.add(t);
		}
		
		for (int i = 0; i < 9; i++) {
			MyShuffletterTile t = new MyShuffletterTile('T');
			MyShuffletterTile t1 = new MyShuffletterTile('R');
			this.bag.add(t);
			this.bag.add(t1);
		}
		
		for (int i = 0; i < 11; i++) {
			MyShuffletterTile t = new MyShuffletterTile('O');
			this.bag.add(t);
		}

		for (int i = 0; i < 12; i++) {
			MyShuffletterTile t = new MyShuffletterTile('I');
			this.bag.add(t);
		}

		for (int i = 0; i < 13; i++) {
			MyShuffletterTile t = new MyShuffletterTile('A');
			this.bag.add(t);
		}
		
		for (int i = 0; i < 18; i++) {
			MyShuffletterTile t = new MyShuffletterTile('E');
			this.bag.add(t);
		}

		MyShuffletterTile t = new MyShuffletterTile(' ');
		this.bag.add(t);
		/**
		 * Use collection.shuffle function shuffle the bag.
		 */
        /**
		Collections.shuffle(bag);
         **/
        MyShuffletterTile t = new MyShuffletterTile('H');
        MyShuffletterTile t1 = new MyShuffletterTile('I');
        MyShuffletterTile t2 = new MyShuffletterTile('H');
		//for (int i = 0; i < 21;i++) {
			//ShuffletterTile tile = bag.remove(0);
			//this.supply.add(tile);

		//}
        this.supply.add(t);
        this.supply.add(t1);
        this.bag.add(t2);

      
	}

	@Override
	public void addListener(ShuffletterModelListener arg0) {

		this.listeners.add(arg0);

	}

	@Override
	public void endRound() {
		
		if (supply.size() != 0) {
			System.out.println("dig deeerepr");
			ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Supply is not empty");
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.illegalMoveMade(invalid);
			}
			return;
		}
		Set<Position> d = alltiles.keySet();
		Iterator<Position> it = d.iterator();
		Position start = it.next();
		Queue<Position> q = new LinkedList<Position>();
		LinkedList<Position> v = new LinkedList<Position>();
		v.add(start);
		q.add(start);
		/**
		 * Use BFS to see if all the tiles are connected.
		 */
		while (q.isEmpty() == false) {
			Position t = q.peek();
			int x = t.getX();
			int y = t.getY();
			q.remove();
			Position n1 = new Position(x-1,y);
			Position n2 = new Position(x+1,y);
			Position n3 = new Position(x,y-1);
			Position n4 = new Position(x,y+1);
			if (alltiles.containsKey(n1) && !v.contains(n1)) {
				v.add(n1);
				q.add(n1);
			}
			if (alltiles.containsKey(n2) && !v.contains(n2)) {
				v.add(n2);
				q.add(n2);
			}
			if (alltiles.containsKey(n3) && !v.contains(n3)) {
				v.add(n3);
				q.add(n3);
			}
			if (alltiles.containsKey(n4) && !v.contains(n4)) {
				v.add(n4);
				q.add(n4);
			}
			
		}
		/**
		 * Check if all tiles are all connected if not, call listener.
		 */
		if (v.size() != alltiles.size()) {
			ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Tiles are not connected");
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.illegalMoveMade(invalid);
			}
			return;
		}
		/**
		 * Check validity of each word.
		 */
		if (checkWords() == false) {
			return;
		}
		/**
		 * If bag size is 0, it mean game is over.
		 */
		if (bag.size() == 0) {
			this.isGameOver();
			return;
		}
		/** 
		 * Move a tile from the bag and put it into supply.
		 */
		ShuffletterTile tile = bag.remove(0);
		supply.add(tile);
		for (ShuffletterModelListener listener : this.listeners)
		{
			listener.roundEnded();
		}
		return;
	}

	/** 
	 * Check the validity of words.
	 * @return true or false.
	 */
	public boolean checkWords() {
		boolean b = false;
		isWild = false;
		hori = new ArrayList<String>();
		verti = new ArrayList<String>();
		boolean h = horizontal();
		if (h == false) {
			return false;
		}
		boolean v = vertical();
		if (v == false) {
			return false;
		}
		/** 
		 * This case checks if a wild tile is being used by two words.
		 */
		for (int i = 0; i < hori.size(); i++) {
			if (verti.contains(hori.get(i))) {
				b = true;
				return true;
			}
		}
		/**
		 * This checks if a wild tile is only used by one word.
		 */
		if (b == false && isWild == true) {
			ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Ilegal words: wildtile can not give us a valid word");
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.illegalMoveMade(invalid);
			}
			return false;
		}
		/**
		 * Return true if none of the cases above happen.
		 */
		return true;
	}
	/**
	 * This method is to check the validity of 
	 * horizontal words.
	 * @return true if true, false other wise.
	 */
	public boolean horizontal() {
		int x = 0;
		int y = 0;
		Iterator<Position> it = alltiles.keySet().iterator();
		while (it.hasNext()) {
			/**
			 * boolean used to see when we reached the beginning
			 * of a word.
			 */
			boolean bool = true;
			Position p = it.next();
			while (bool) {
			    x = p.getX();
			    y = p.getY();
			    Position temp = new Position(x-1,y);
			
			    if (alltiles.containsKey(temp)) {
			    	p = temp;
			    }	
			    else {
			    	bool = false;
			    }
			}
			String s = alltiles.get(p).getLetter() + "";
			boolean boo = true;
			while (boo) {
				Position temp1 = new Position(x+1,y);
				if (alltiles.containsKey(temp1)) {
					s = s + alltiles.get(temp1).getLetter();
					x = x+1;
				}
				else {
					boo = false;
					if (s.contains(" ")) {
						if (handleWild(s,0) == false) {
							return false;
						}
					}
					else {
						Iterator<String> ite = words.iterator();
						while (ite.hasNext()) {
							String str = ite.next();
							if (str.equalsIgnoreCase(s)) {
								break;
							}
						}
						if (ite.hasNext() == false) {
							ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Illegal word:" + s);
							for (ShuffletterModelListener listener : this.listeners)
							{
								listener.illegalMoveMade(invalid);
							}
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	/**
	 * This method checks all vertical words are valid.
	 * Logic is very similar to horizontal.
	 * @return true if true, false otherwise.
	 */
	public boolean vertical() {
		int x = 0;
		int y = 0;
		Iterator<Position> it = alltiles.keySet().iterator();
		while (it.hasNext()) {
			boolean bool = true;
			Position p = it.next();
			while (bool) {
				x = p.getX();
				y = p.getY();
				Position temp = new Position(x,y+1);
			
				if (alltiles.containsKey(temp)) {
					p = temp;
				}
				else {
					bool = false;
				}
			}
		
			String s = alltiles.get(p).getLetter() + "";
			boolean boo = true;
			while (boo) {
				Position temp1 = new Position(x,y-1);
				if (alltiles.containsKey(temp1)) {
					s = s + alltiles.get(temp1).getLetter();
					y = y-1;
				}
				else {
					boo = false;
					if (s.contains(" ")) {
						if (handleWild(s,1) == false) {
							return false;
						}
					}
					else {
						Iterator<String> ite = words.iterator();
						while (ite.hasNext()) {
							String str = ite.next();
							if (str.equalsIgnoreCase(s)) {
								break;
							}
						}
						if (ite.hasNext() == false) {
							ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Illegal word:" + s);
							for (ShuffletterModelListener listener : this.listeners)
							{
								listener.illegalMoveMade(invalid);
							}
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	@Override
	public String getAuthorName() {
		return "DA LU";
	}

	@Override
	public int getBagCount() {
		return bag.size();
	}

	@Override
	public Set<String> getLegalWords() {
		return words;
	}

	@Override
	public List<ShuffletterTile> getSupplyContents() {
		return supply;
	}

	@Override
	public ShuffletterTile getTile(Position arg0) {
		return alltiles.get(arg0);
	}

	@Override
	public Collection<Position> getTilePositions() {
		return alltiles.keySet();
	}

	@Override
	public boolean isGameOver() {
		if (bag.size() == 0 && supply.size() ==0) {
			/**
			 * Call listener if game is indeed over.
			 */
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.gameEnded();
			}
		return true;
		}
		else {
			return false;
		}	
	}
	/** 
	 * This method is to handle wild tiles.
	 * @param s String.
	 * @param a 0 for horizontal, 1 for vertical.
	 * @return
	 */
	public boolean handleWild(String s,int a) {
		boolean b = false;
		isWild = true;
		Iterator<String> ite = words.iterator();
		int x = s.indexOf(" ");
		
		while (ite.hasNext()) {
			String str = ite.next();
			if (str.length() == s.length()) {
				StringBuilder word = new StringBuilder(str);
				String c = str.substring(x, x+1) + "";
				word.setCharAt(x, ' ');
				str = word.toString();
				if (str.equalsIgnoreCase(s)) {
					if (a ==0) {
						hori.add(c);
					}
					else if (a==1) {
						verti.add(c);
					}
					b = true;
				}
			}
		}
		if ( b == true) return true;
		ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Illegal word:" + s);
		for (ShuffletterModelListener listener : this.listeners)
		{
			listener.illegalMoveMade(invalid);
		}
		return false;
	}
	@Override
	public void move(Position arg0, Position arg1) {
		/**
		 * If position arg0 has no tiles, it is
		 * an illegal move, then call listeners.
		 */
		if (!alltiles.containsKey(arg0)) {
			
			ShuffletterIllegalMoveEvent invalid = new ShuffletterIllegalMoveEvent("Illegal move");
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.illegalMoveMade(invalid);
			}
		}
		
		else {
			ShuffletterTile tile = alltiles.get(arg0);
			ShuffletterTileMovedEvent event = new ShuffletterTileMovedEvent(arg0, arg1, tile);
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.tileMoved(event);
			}
			if (!alltiles.containsKey(arg1)) {
				alltiles.remove(arg0);
				alltiles.put(arg1, tile);
				return;
			}
			ShuffletterTile tile1 = alltiles.get(arg1);
			alltiles.put(arg0, tile1);
			alltiles.put(arg1, tile);
		}
	}

	@Override
	public void play(ShuffletterTile arg0, Position arg1) {
		/**
		 * If it is an illegal move, call all the listeners.
		 */
		if (alltiles.containsKey(arg1)) {
			
			ShuffletterIllegalMoveEvent event = new ShuffletterIllegalMoveEvent("Illegal move");
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.illegalMoveMade(event);
			}
		}
		else {
			ShuffletterTilePlayedEvent event = new ShuffletterTilePlayedEvent(arg1,arg0);
			for (ShuffletterModelListener listener : this.listeners)
			{
				listener.tilePlayed(event);
			}
			alltiles.put(arg1,arg0 );
			supply.remove(arg0);
			}
	}

	@Override
	public void removeListener(ShuffletterModelListener arg0) {
		
		this.listeners.remove(arg0);
		
	}
}
