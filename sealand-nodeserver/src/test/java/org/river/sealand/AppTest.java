package org.river.sealand;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		String[] haha={"a","b","c","d"};
		String []hoho=Arrays.copyOfRange(haha, 4, 4);
		for(String tmp:hoho){
			System.out.println(tmp);
		}
	}
}
