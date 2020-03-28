package edu.osu.cse5234.util;

public class CreateDB {

	public static void main(String[] args) throws Exception {
		Class.forName("org.h2.Driver").newInstance();
		//Connection conn = DriverManager.getConnection("jdbc:h2:" + "C:\Users\reidster\Documents\workspace\cse5234\h2db\MySkiLift", "sa", "");
		System.out.println("Database MySkiLift has been created!");
	}
}
