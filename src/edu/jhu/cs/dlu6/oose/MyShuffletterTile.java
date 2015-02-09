package edu.jhu.cs.dlu6.oose;
import edu.jhu.cs.oose.fall2014.shuffletter.iface.ShuffletterTile;


public class MyShuffletterTile implements ShuffletterTile{

	/**
	 *  The letter this tile is holding.
	 */
	private char letter = 0;
	
	/**
	 * It sets its character to l.
	 * @param l
	 */
	public MyShuffletterTile(char l) {
		letter = l;
	}
	@Override
	public char getLetter() {
		
		return letter;
	}

	@Override
	public boolean isWild() {
		
		if (letter == ' ') 
			return true;
		else
			return false;
	}

}
