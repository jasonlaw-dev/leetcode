import java.util.Iterator;

/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  boolean hasPeeked = false;
	int currValue;
	Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
      this.iterator = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    if (this.hasPeeked) {
      return this.currValue;
    }
    hasPeeked = true;
    this.currValue = this.iterator.next();
		return this.currValue;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (this.hasPeeked) {
      this.hasPeeked = false;
      return this.currValue;
    }
    return this.iterator.next();
	}
	
	@Override
	public boolean hasNext() {
    return this.hasPeeked || this.iterator.hasNext();
	}
}
// @lc code=end

