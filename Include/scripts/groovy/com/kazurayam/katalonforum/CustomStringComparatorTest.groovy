package com.kazurayam.katalonforum

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4.class)
public class CustomStringComparatorTest {

	private CustomStringComparator instance
	
	@Before
	void setup() {
		instance = new CustomStringComparator()
		instance.setVerbose(true)
	}
	
	@Ignore
	@Test
	void testCompare_AA1_AA1() {
		def v = instance.compare("AA-1","AA-1")
		assertTrue(v == 0)
	}
	
	@Ignore
	@Test
	void testCompare_AA1_AA2() {
		def v = instance.compare("AA-1","AA-2")
		assertTrue("actual v is " + v, v < 0)
	}
	
	@Ignore
	@Test
	void testCompare_AA2_AA10() {
		def v = instance.compare("AA-2","AA-10")
		assertTrue("actual v is " + v, v < 0)
	}
	
	@Ignore
	@Test
	void testCompare_AA2_AA10_rev() {
		def v = instance.compare("AA-10","AA-2")
		assertTrue("actual v is " + v, v > 0)
	}
	
	@Test
	void testCompare_AA2_AAx1() {
		def v = instance.compare("AA-1", "AA-1 (1)")
		assertTrue("actual v is " + v, v < 0)	
	}
	
	@Test
	void testCompare_AA1x2_AA1x10() {
		def v = instance.compare("AA-1 (2)","AA-1 (10)")
		assertTrue("actual v is " + v, v < 0)
	}
	
}
