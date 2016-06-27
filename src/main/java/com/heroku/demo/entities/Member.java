
package com.heroku.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="members")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Member.countAll", query="SELECT COUNT(x) FROM Member x" )
} )
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="firstname", length=80)
    private String     firstname ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="birthdate")
    private Date       birthdate ;
    
    @Column(name="phone", length=40)
    private String     phone        ;
    
    @Column(name="name", length=121)
    private String     name  ;

    @Column(name="lastname", length=255)
    private String     lastname ;

    @Column(name="email", length=80)
    private String     email ;

    @Column(name="memberid", length=256)
    private String     memberid;
    
    public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public Member update(Member a) {
		this.id = a.id;
		this.phone = a.phone;
		this.name = a.name;
		return a;
	}

	//----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Member() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }
    public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : phone ( varchar ) 
    public void setPhone( String phone ) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }


    //--- DATABASE MAPPING : name ( varchar ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

}
