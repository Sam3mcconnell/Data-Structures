package edu.ncsu.csc316.dsa.data;

import java.util.Comparator;

/**
 * Comparator for comparing Students based on GPA
 * @author Dr. King
 *
 */
public class StudentGPAComparator implements Comparator<Student> {

	/**
	 * Compares students based on GPA in descending order
	 */
	@Override
	public int compare(Student one, Student two) {
		if (Double.compare(one.getGpa(), two.getGpa()) == 0) {
			return one.compareTo(two);
		} else {
			return Double.compare(two.getGpa(), one.getGpa());
		}
	}

}
