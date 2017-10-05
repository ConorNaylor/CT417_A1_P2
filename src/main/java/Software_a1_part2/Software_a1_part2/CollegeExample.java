package Software_a1_part2.Software_a1_part2;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import org.joda.time.DateTime;

import Software_a1.Software_a1.CourseProgramme;
import Software_a1.Software_a1.Module;
import Software_a1.Software_a1.Student;

public class CollegeExample 
{
	public static void main( String[] args )
	{
		//	Creating a few dates to use below.
		Date dob = new Date(10-10-1995);
		DateTime startDate = new DateTime(01-9-2014);
		DateTime endDate = new DateTime(01-6-2018);

		LinkedList<Student> Students = new LinkedList<Student>();
		LinkedList<CourseProgramme> courses = new LinkedList<CourseProgramme>();

		LinkedList<Student> tempListStu = new LinkedList<Student>();
		LinkedList<Module> tempListMod = new LinkedList<Module>();
		LinkedList<CourseProgramme> tempListCourse = new LinkedList<CourseProgramme>();

		//  Create Students 
		Student s1 = new Student("John", 18, dob);
		Student s2 = new Student("Alan", 19, dob );
		Student s3 = new Student("Peter", 18, dob);
		Student s4 = new Student("Jack", 19, dob);
		Student s5 = new Student("Conor", 20, dob);

		//  Adding Students to list
		Students.add(s1);
		Students.add(s2);
		Students.add(s3);
		Students.add(s4);
		Students.add(s5);

		//  Creating lists for students
		LinkedList <Student> mod1Students = new LinkedList<Student>();
		LinkedList <Student> mod2Students = new LinkedList<Student>();
		LinkedList <Student> mod3Students = new LinkedList<Student>();

		//  Adding students to lists
		mod1Students.add(s1);
		mod1Students.add(s2);
		mod2Students.add(s2);
		mod3Students.add(s3);

		//	Creating Module Instances 
		Module software = new Module("Software",mod1Students,"SW100");
		Module maths = new Module("Maths", mod2Students,"MT120");
		Module programming = new Module("Programming", mod3Students, "CT404");

		//  Adding extra student to module 1 - Software
		software.addStudent(s4);

		LinkedList <Module> eceModules = new LinkedList<Module>();
		LinkedList <Module> csitModules = new LinkedList<Module>();

		//	Adding Modules to list
		eceModules.add(software);
		eceModules.add(maths);
		csitModules.add(programming);
		//		csitModules.add(software);

		//  Creating Course Programmes
		CourseProgramme cp1 = new CourseProgramme("ECE", eceModules, startDate, endDate);
		CourseProgramme cp2 = new CourseProgramme("CS&IT",csitModules, startDate, endDate);

		//Add courses to list
		courses.add(cp1);
		courses.add(cp2);

		for(Student stu : Students) {
			for(CourseProgramme cp : courses) {
				for(Module mod : cp.getModules()) {
					if(mod.getList().contains(stu)) {
						if(!tempListStu.contains(stu)) {
							System.out.print("Name: " + stu.getName() + ". Has modules: " + mod.getName());
							tempListStu.add(stu);
							tempListMod.add(mod);
						}else if(!tempListMod.contains(mod)) {
							System.out.print(", " + mod.getName());
							tempListMod.add(mod);
						}
						if(!tempListCourse.contains(cp)) {
							tempListCourse.add(cp);
						}
					}
				}
			}
			if(!tempListCourse.isEmpty()) {
				System.out.print(". Is enrolled in course: ");
				for(CourseProgramme c : tempListCourse) {
					System.out.print(c.getName() + " ");
				}
			}
			else {
				System.out.println(stu.getName() + " is not enrolled in any course yet.");
			}
			tempListCourse.clear();
			System.out.println("\n");
		}
	}
}
