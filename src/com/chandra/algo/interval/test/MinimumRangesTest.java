/**
 * 
 */
package com.chandra.algo.interval.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chandra.algo.interval.MinimumRangeWithStack;

/**
 * @author chandra
 * @param <Range>
 *
 */
public class MinimumRangesTest<Range> {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.chandra.algo.interval.MinimumRangeWithStack#mergeRanges(com.chandra.algo.interval.Range[])}.
	 */
	@Test
	public final void testMergeRanges(){
		MinimumRangeWithStack.mergeRanges(null);
	}

}
