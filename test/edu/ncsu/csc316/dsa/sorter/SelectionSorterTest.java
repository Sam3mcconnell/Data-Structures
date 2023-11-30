package edu.ncsu.csc316.dsa.sorter;

import static org.junit.Assert.*; 

import org.junit.Test;

import edu.ncsu.csc316.dsa.data.Student;
import edu.ncsu.csc316.dsa.data.StudentGPAComparator;
import edu.ncsu.csc316.dsa.data.StudentIDComparator;

public class SelectionSorterTest {

	@Test
	public void testSortStudent() {
		Sorter<Student> s = new SelectionSorter<Student>(new StudentIDComparator());
		Student sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		Student sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 2.0, "twoUnityID");
		Student sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		Student sFour = new Student("FourFirst", "FourLast", 4, 4, 4.0, "fourUnityID");
		Student sFive = new Student("FiveFirst", "FiveLast", 5, 5, 5.0, "fiveUnityID");
		
		Student[] studentArray1 = {sOne, sTwo, sThree, sFour, sFive};
		Student[] studentArray2 = {sFive, sFour, sThree, sTwo, sOne};
		Student[] studentArray3 = {sFour, sOne, sFive, sThree, sTwo};
		
		s.sort(studentArray1);
		assertEquals("OneFirst", studentArray1[0].getFirst());
		assertEquals("TwoFirst", studentArray1[1].getFirst());
		assertEquals("ThreeFirst", studentArray1[2].getFirst());
		assertEquals("FourFirst", studentArray1[3].getFirst());
		assertEquals("FiveFirst", studentArray1[4].getFirst());
		
		s.sort(studentArray2);
		assertEquals("OneFirst", studentArray2[0].getFirst());
		assertEquals("TwoFirst", studentArray2[1].getFirst());
		assertEquals("ThreeFirst", studentArray2[2].getFirst());
		assertEquals("FourFirst", studentArray2[3].getFirst());
		assertEquals("FiveFirst", studentArray2[4].getFirst());
		
		s.sort(studentArray3);
		assertEquals("OneFirst", studentArray3[0].getFirst());
		assertEquals("TwoFirst", studentArray3[1].getFirst());
		assertEquals("ThreeFirst", studentArray3[2].getFirst());
		assertEquals("FourFirst", studentArray3[3].getFirst());
		assertEquals("FiveFirst", studentArray3[4].getFirst());
		
	}
	
	@Test
	public void testSortStudentGPA() {
		Sorter<Student> s = new SelectionSorter<Student>(new StudentGPAComparator());
		Student sOne = new Student("OneFirst", "OneLast", 1, 1, 1.0, "oneUnityID");
		Student sTwo = new Student("TwoFirst", "TwoLast", 2, 2, 0.2, "twoUnityID");
		Student sThree = new Student("ThreeFirst", "ThreeLast", 3, 3, 3.0, "threeUnityID");
		Student sFour = new Student("FourFirst", "FourLast", 4, 4, 2.2, "fourUnityID");
		Student sFive = new Student("FiveFirst", "FiveLast", 5, 5, 2.4, "fiveUnityID");
		
		Student[] studentArray1 = {sOne, sTwo, sThree, sFour, sFive};
		Student[] studentArray2 = {sFive, sFour, sThree, sTwo, sOne};
		Student[] studentArray3 = {sFour, sOne, sFive, sThree, sTwo};
		
		s.sort(studentArray1);
		assertEquals("ThreeFirst", studentArray1[0].getFirst());
		assertEquals("FiveFirst", studentArray1[1].getFirst());
		assertEquals("FourFirst", studentArray1[2].getFirst());
		assertEquals("OneFirst", studentArray1[3].getFirst());
		assertEquals("TwoFirst", studentArray1[4].getFirst());
		
		s.sort(studentArray2); 
		assertEquals("ThreeFirst", studentArray2[0].getFirst());
		assertEquals("FiveFirst", studentArray2[1].getFirst());
		assertEquals("FourFirst", studentArray2[2].getFirst());
		assertEquals("OneFirst", studentArray2[3].getFirst());
		assertEquals("TwoFirst", studentArray2[4].getFirst());
		
		s.sort(studentArray3);
		assertEquals("ThreeFirst", studentArray3[0].getFirst());
		assertEquals("FiveFirst", studentArray3[1].getFirst());
		assertEquals("FourFirst", studentArray3[2].getFirst());
		assertEquals("OneFirst", studentArray3[3].getFirst());
		assertEquals("TwoFirst", studentArray3[4].getFirst());
	}

}
