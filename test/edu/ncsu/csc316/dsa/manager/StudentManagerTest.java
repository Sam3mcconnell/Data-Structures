package edu.ncsu.csc316.dsa.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.sorter.InsertionSorter;
import edu.ncsu.csc316.dsa.sorter.Sorter;

public class StudentManagerTest {

	private StudentManager sm;
	private StudentManager sm2;
	
	@Before
	public void setUp() {
		sm = new StudentManager("input/student_ascendingID.csv");
		Sorter<Student> s = new InsertionSorter<Student>(new StudentGPAComparator());
		sm2 = new StudentManager("input/student_randomOrder.csv", s);
	}
	
	@Test
	public void testSort() {
		Student[] sorted = sm.sort();
		assertEquals("Tanner", sorted[0].getFirst());
		assertEquals("Roxann", sorted[1].getFirst());
		assertEquals("Shanti", sorted[2].getFirst());
		assertEquals("Dante", sorted[3].getFirst());
		assertEquals("Cristine", sorted[4].getFirst());
		assertEquals("Ara", sorted[5].getFirst());
		assertEquals("Lewis", sorted[6].getFirst());
		assertEquals("Charlene", sorted[7].getFirst());
		assertEquals("Amber", sorted[8].getFirst());
		assertEquals("Lacie", sorted[9].getFirst());
		assertEquals("Idalia", sorted[10].getFirst());
		assertEquals("Tyree", sorted[11].getFirst());
		assertEquals("Evelin", sorted[12].getFirst());
		assertEquals("Alicia", sorted[13].getFirst());
		assertEquals("Loise", sorted[14].getFirst());
		assertEquals("Nichole", sorted[15].getFirst());
	}

	@Test
	public void testSortWithAlgorithm() {
		Student[] sorted = sm2.sort();
		assertEquals("Nichole", sorted[0].getFirst());
		assertEquals("Alicia", sorted[1].getFirst());
		assertEquals("Charlene", sorted[2].getFirst());
		assertEquals("Cristine", sorted[3].getFirst());
		assertEquals("Dante", sorted[4].getFirst());
		assertEquals("Lacie", sorted[5].getFirst());
		assertEquals("Idalia", sorted[6].getFirst());
		assertEquals("Ara", sorted[7].getFirst());
		assertEquals("Loise", sorted[8].getFirst());
		assertEquals("Tanner", sorted[9].getFirst());
		assertEquals("Amber", sorted[10].getFirst());
		assertEquals("Roxann", sorted[11].getFirst());
		assertEquals("Tyree", sorted[12].getFirst());
		assertEquals("Evelin", sorted[13].getFirst());
		assertEquals("Shanti", sorted[14].getFirst());
		assertEquals("Lewis", sorted[15].getFirst());
		
	}

}
