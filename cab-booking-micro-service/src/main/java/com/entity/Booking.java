package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookid;
@Column(unique=true)
private String emailid;
private String fromlocation;
private String tolocation;
private String typeofcab;
private float amount;
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getFromlocation() {
	return fromlocation;
}
public void setFromlocation(String fromlocation) {
	this.fromlocation = fromlocation;
}
public String getTolocation() {
	return tolocation;
}
public void setTolocation(String tolocation) {
	this.tolocation = tolocation;
}
public String getTypeofcab() {
	return typeofcab;
}
public void setTypeofcab(String typeofcab) {
	this.typeofcab = typeofcab;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}

}
