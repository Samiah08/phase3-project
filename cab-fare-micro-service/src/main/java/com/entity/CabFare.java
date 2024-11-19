package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class CabFare {
	
@Id
private int cf;
private String fromlocation;
private String tolocation;
private String typeofcab;
private float amount;
public int getCf() {
	return cf;
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
public void setCf(int cf) {
	this.cf = cf;
}


}
