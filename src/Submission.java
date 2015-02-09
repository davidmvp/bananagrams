import java.io.File;




	/**
	 * @param args
	 */
	
		public class Submission {
		    /** The actual content the student submitted */
		    private File content;
		    private int daysLate;
		    private int baseScore = 50; /** Set the base score to 50 */

		    /** Calculates the total number of points the student received, without
		        taking late days into account */
		    public Submission(int d) {
		    	daysLate = d;
		    }
		    public int baseScore() {
		        /* ... */
		    	return baseScore;
		    }
		    
		    public int getDaysLate() {
		        return daysLate;
		    }

		    /** Calculates the number of points the student received, counting
		        lateness */
		    public int finalScore() {
		        if (daysLate > 5) {
		           // Submissions over 5 days late are not accepted
		           return 0;
		        }
		        // Submissions receive a 10 point penalty for each day late and cannot
		        // score below 0.
		        return Math.max(baseScore() - 10 * getDaysLate(), 0);
		    }

		    /* ... */

		    /** Returns the contents of the assignment as a string. May be called as
		        many times as necessary. Written in response to a followup to
		        https://piazza.com/class/hz5bcympkht1t2?cid=153 */
		    public String getContent() {
		        String con = "Welcome!";
		    	return con;
		    }
		}
		        

	


