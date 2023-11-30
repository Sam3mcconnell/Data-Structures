package edu.ncsu.csc316.dsa.data;

/**
 * A student is comparable and identifiable.
 * Students have a first name, last name, id number, 
 * number of credit hours, gpa, and unityID.
 * 
 * @author Dr. King
 *
 */
public class Student implements Comparable<Student>, Identifiable {
	
	/** The Student's first name */
	private String first;
	/** The Student's last name */
	private String last;
	/** The Student's id  */
	private int id;
	/** The Student's credit hours */
	private int creditHours;
	/** The Student's GPA  */
	private double gpa;
	/** The Student's unity id */
	private String unityID;
	
	/**
	 * This is the constructor for the student class. Constructs the student.
	 * @param first as the student's first name
	 * @param last as the student's last name
	 * @param id as the student's id
	 * @param creditHours as the students credit hours.
	 * @param gpa as the student's gpa 
	 * @param unityID as the students unity id. 
	 */
	public Student(String first, String last, int id, int creditHours, double gpa, String unityID) {
		setFirst(first);
		setLast(last);
		setId(id);
		setCreditHours(creditHours);
		setGpa(gpa);
		setUnityID(unityID);
	}
	
	/**
	 * Gets the student's first name
	 * @return the student's first name
	 */
	public String getFirst() {
		return first;
	}
	
	/**
	 * Sets the student's first name
	 * @param first as the student's first name
	 */
	public void setFirst(String first) {
		this.first = first;
	}
	
	/**
	 * Gets the student's last name
	 * @return the student's last name
	 */
	public String getLast() {
		return last;
	}
	
	/**
	 * Sets the student's last name
	 * @param last as the student's last name
	 */
	public void setLast(String last) {
		this.last = last;
	}
	
	/**
	 * gets the student's id
	 * @return the student's id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the student's id.
	 * @param id as the student's id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the studnet's credit hours
	 * @return the studnet's credit hours. 
	 */
	public int getCreditHours() {
		return creditHours;
	}
	
	/**
	 * Set the student credit hours
	 * @param creditHours as the student's credit hours.
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	/**
	 * Gets the student's gpa
	 * @return the student's gpa
	 */
	public double getGpa() {
		return gpa;
	}
	
	/**
	 * Sets the studnet's gpa.
	 * @param gpa as the student's gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	/**
	 * Gets the student's unity id.
	 * @return the student's unity id.
	 */
	public String getUnityID() {
		return unityID;
	}
	
	/**
	 * Sets the student's unity id.
	 * @param unityID as the unity id.
	 */
	public void setUnityID(String unityID) {
		this.unityID = unityID;
	}


	/**
	 * The hash code for the student class
	 * @return the hash.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + creditHours;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((unityID == null) ? 0 : unityID.hashCode());
		return result;
	}


	/**
	 * Figures out if the student has the same first, last, and id as 
	 * another student
	 * @param obj as the other student.
	 * @return true if the two students have what is described above.
	 */
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		if (getFirst().equals(other.getFirst()) && getLast().equals(other.getLast()) 
				&& getId() == other.getId()) {
			return true;
		}
		return false;
	}

	/**
	 * Compares one student to another.
	 * @param other as the other student
	 * @return the integer value of the comparison.
	 */
	@Override
	public int compareTo(Student other) {
		if (getLast().compareTo(other.getLast()) != 0) {
			return getLast().compareTo(other.getLast());
		} else if (getFirst().compareTo(other.getFirst()) != 0) {
			return getFirst().compareTo(other.getFirst());
		} else {
			return Integer.compare(getId(), other.getId());
		}
		
	}
	
	/**
	 * Puts the student into a usable string
	 * @return the student as a string.
	 */
	public String toString() {
		return getFirst() + "," + getLast() + "," + getId() + "," + getCreditHours() + "," + getGpa() + "," + getUnityID();
	}
	
	
}
