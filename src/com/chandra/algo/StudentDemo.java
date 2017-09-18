package com.chandra.algo;

public class StudentDemo {
	private String name;
	private int rollNo;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public static void changeStudent(StudentDemo sd){
		sd.setName("Sam");
		sd.setRollNo(453);
		return ;
	}
	
	public static void main(String[] args) {
		StudentDemo sd1 = new StudentDemo();
		sd1.setName("Chandra");
		sd1.setRollNo(123);
		changeStudent(sd1);
		System.out.println("Student Details - "+sd1.getName()+":-"+sd1.getRollNo());
	}

}
