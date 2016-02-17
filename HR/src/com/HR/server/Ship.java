package com.HR.server;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Sequence;
import javax.jdo.annotations.Extension;
import javax.jdo.annotations.SequenceStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@Sequence(name = "jdo1", datastoreSequence = "jdothat", strategy = SequenceStrategy.NONTRANSACTIONAL,extensions = @Extension(vendorName = "datanucleus", key="key-cache-size", value="1"))

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Ship {
	
	 //GreetingServiceImpl greeting = new GreetingServiceImpl();
	 //GetUser GetUser = new GetUser();
	  @PrimaryKey
		//  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
		//  private Long id;
		  @Persistent
		  private String id ;
		  @Persistent
		  private String username ;
		  @Persistent
		  private String fullName ;
		  @Persistent
		  private String address ;
	      @Persistent
		  private String address2;
		  @Persistent
		  private String postcode ;
		  @Persistent
		  private String tel ;
		  @Persistent
		  private String email ;
		  @Persistent
		  private String isActive ;		   
	      @Persistent
		  private String flag1;
		  @Persistent
		  private String flag2 ;
		  @Persistent
		  private String flag3 ;
		  @Persistent
		  private String country;
		  @Persistent
		  private String state ;
		 
		  private Date createDate;
		  public Ship() {
				this.createDate = new Date();	
				}
		  
		  
		  public Ship(String idRaw, String userName, String image, String bio, String website, String full_name) {
			  
			  this.id=idRaw;
			  this.username=userName;
			  this.createDate=new Date();
			  //this.image=image;
			  this.flag1="down";
			  this.flag2="down";
			  this.flag3="down";
			  //this.bio=bio;
			  //this.website=website;
			  this.fullName=full_name;
			  this.state="";
			  this.country="malaysia";
			  
			  //if (GetUser.detectZero()==0){
			 //this.number=0;
			//  }
			//  else {
				//  this.number=GetUser.updateNumber2()+1;
				  
			 // }
		  }

	public Ship(String id, String username) {
		
		this.id=id;
		this.username=username;
		}


	public Ship(String id, String username, String fullname, String bio,
			int follow, int followedBy, String website, int media,
			String flag1, String flag2, String flag3) {
		
		this.id=id;
		  this.username=username;
		  this.fullName=fullname;
		 // this.bio=bio;
		  //this.follows=follow;
		  //this.followedBy=followedBy;
		 // this.website=website;
		 // this.media=media;
		  
		  this.flag1=flag1;
		  this.flag2=flag2;
		  this.flag3=flag3;
		  
	}


	public Ship(String id, String username, int number) {
		
this.id=id;
this.username=username;
//this.number=number;
	}


	public Ship(String id) {
 this.id=id;
	}


	public String id() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public String username() {
		// TODO Auto-generated method stub
		return this.username;
	}


	public void updateFlag1(String up) {

		this.flag1=up;
		
	}
	
	public void updateBio(String bio){
		
		//this.bio=bio.substring(1, bio.length()-1);
	}
	
	public void updateWebsite(String website){
		
	//	this.website=website.substring(1, website.length()-1);
	}
	
	public void updateFullName (String fullName){
		
		this.fullName=fullName.substring(1, fullName.length()-1);
	}

	public void updateMedia(int media){
		
	//	this.media=media;
	}
	
	public void updateFollows(int follow){
		
		//this.follows=follow;
	}
	
public void updateFollowedBy(int followedBy){
		
	//	this.followedBy=followedBy;
	}

	public void updateFlag2(String up) {
		this.flag2=up;		
	}


	public void updateFlag3(String up) {
		this.flag3=up;		
		
	}


	public String fullname() {
		// TODO Auto-generated method stub
		return fullName;
	}


	//public String bio() {
		// TODO Auto-generated method stub
	//	return bio;
	//}


//	public int follow() {
		// TODO Auto-generated method stub
	//	return follows;
//	}


	//public int followedBy() {
		// TODO Auto-generated method stub
		//return followedBy;
	//}


//	public int media() {
		// TODO Auto-generated method stub
	//	return media;
	//}
//

	//public String website() {
		// TODO Auto-generated method stub
	//	return website;
	//}


	public String flag1() {
		// TODO Auto-generated method stub
		return flag1;
	}


	public String flag2() {
		// TODO Auto-generated method stub
		return flag2;
	}


	public String flag3() {
		// TODO Auto-generated method stub
		return flag3;
	}


	public void updateNumber(int i) {
	//	this.number=i;		
	}


	//public int number() {
		// TODO Auto-generated method stub
	//	return number;
	//}


	public void number(int i) {

	//	this.number=i;
		
	}


	public void updateState(String state) {
		this.state=state;		
	}


	public void updateCountry(String string) {
		this.country="malaysia";		
	}


	

}
