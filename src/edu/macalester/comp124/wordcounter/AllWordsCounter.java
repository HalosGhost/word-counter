package edu.macalester.comp124.wordcounter;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;

    SingleWordCounter [] counters = new SingleWordCounter[MAX_WORDS];

    /**
     * @return number of words
     */
    public int getNumWords() {
        int wordCountAccumulator = 0;
        for ( SingleWordCounter currentWord : counters ) {
            if ( currentWord != null ) wordCountAccumulator++;
        }

        return wordCountAccumulator;
    }
	
	/**
	 * Increment the count for the specified word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        int n = this.getNumWords();
        for (int i = 0; i < n; i++) {
            if ( counters[i].wordMatches(word) ) {
                counters[i].incrementCount();
                return;
            }
        }

        counters[n] = new SingleWordCounter(word);
        counters[n].incrementCount();
	}
	
	/**
	 * Return the count for the particular word.
     *
	 * @param word
	 * @return the found count for passed word
	 */
	public int getCount(String word) {
        int n = this.getNumWords();
        for (int i = 0; i < n; i++) {
            if ( counters[i].wordMatches(word) ) return counters[i].getCount();
        }

        return 0;
	}
	
	/**
	 * @return An array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords() {
        int n = getNumWords();
        String [] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = counters[i].getWord();
        }

        return words;
	}
}
