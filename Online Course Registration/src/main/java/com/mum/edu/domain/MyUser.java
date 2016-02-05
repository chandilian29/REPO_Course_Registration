package com.mum.edu.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;

@Entity
public class MyUser {

    @Id
    @GeneratedValue
    private long id;
    @NotEmpty(message="Field should not be left empty")
    private String firstName;
    @NotEmpty
    private String lastName;
    private String address;
    private String phoneNo;
    private String uname;
    private String password;
    private String usertype;
    

    public MyUser() {
    }

    public MyUser(long id, String firstName, String lastName, String address, String phoneNo, String uname, String password,String usertype) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.uname = uname;
        this.password = password;
        this.usertype=usertype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    
    
   
}
