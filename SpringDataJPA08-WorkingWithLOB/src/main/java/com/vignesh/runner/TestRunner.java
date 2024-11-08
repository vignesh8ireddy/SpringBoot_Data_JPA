package com.vignesh.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vignesh.entity.MarriageSeeker1;
import com.vignesh.service.IEntityManagementService;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	IEntityManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name::");
		//String name=sc.next();
		String name="james gosling";
		
		System.out.println("enter address::");
		//String addrs=sc.next();
		String addrs="Los angeles";
		
		System.out.println("enter DOB (yyyy-MM-dd hh:mm:ss)::");
		//String dob=sc.next();
		//LocalDateTime ldob=LocalDateTime.parse(dob);
		LocalDateTime ldob=LocalDateTime.parse("1999-05-28T11:27:06");
		
		
		System.out.println(" enter gender:: Male/Female");
		//String gender=sc.next();
		String gender="male";
		
		System.out.println("enter photo file path::");
		//String photoPath=sc.next();
		String photoPath="C:/Users/math/Pictures/james golsing.jpg";
		
		System.out.println("enter resume file path::");
		//String resumePath=sc.next();
		String resumePath="C:/Users/math/Documents/JSE_JavaStandardEdition/new_kyle.txt";
		
		//create streams representing  photo file ,resume file
		//create byte[] and char[] having data
		FileInputStream fis=new FileInputStream(photoPath);
		byte[] photoContent=fis.readAllBytes();
		  
		 File file=new File(resumePath);
		 FileReader reader=new FileReader(resumePath);
		 char[] resumeContent=new char[(int) file.length()];
		 reader.read(resumeContent);
		
		//create Model/Entity class object
		 MarriageSeeker1 seeker=
				   new MarriageSeeker1(addrs, ldob, gender, photoContent, name, resumeContent);
		  
		  // save the object
		  try {
			  System.out.println(service.registerMarriageSeeker(seeker));
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
		  /*
		  //Load object operation
		 MarriageSeeker1 seeker=service.getMarriageSeekerById(1L);
		 System.out.println(seeker.getMid()+"  "+seeker.getName()+" "+seeker.getAddrs()+"  "+seeker.getDob());
		 byte[]  photoContent=seeker.getPhoto();
		 char[]  resumeContent=seeker.getResume();
		 //write the content to destination files
		 FileOutputStream fos=new FileOutputStream("retrieve_photo.jfif");
		 fos.write(photoContent);
		 fos.flush();
		 fos.close();
		  FileWriter writer=new FileWriter("retrieve_resume.txt");
		  writer.write(resumeContent);
		  writer.flush();
		  writer.close();
		  */

	}

}
