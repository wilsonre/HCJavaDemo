
package com.heroku.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="contact", schema="salesforce" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Contact.countAll", query="SELECT COUNT(x) FROM Contact x" )
} )
public class Contact implements Serializable {

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
    @Column(name="createddate")
    private Date       createddate  ;

    @Column(name="isdeleted")
    private Boolean    isdeleted    ;

    @Column(name="_hc_err", length=2147483647)
    private String     hcErr        ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="birthdate")
    private Date       birthdate ;
    
    @Column(name="phone", length=40)
    private String     phone        ;
    
    @Column(name="name", length=121)
    private String     name  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="systemmodstamp")
    private Date       systemmodstamp ;
    
    @Column(name="accountId", length=18)
    private String     accountid ;

    @Column(name="_hc_lastop", length=255)
    private String     hcLastop ;

    @Column(name="lastname", length=255)
    private String     lastname ;

    @Column(name="sfid", length=18)
    private String     sfid         ;

    @Column(name="email", length=80)
    private String     email ;

    public Contact update(Contact a) {
		this.id = a.id;
		this.hcErr = a.hcErr;
		this.hcLastop = a.hcLastop;
		this.isdeleted = a.isdeleted;
		this.createddate = a.createddate;
		this.sfid = a.sfid;
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
    public Contact() {
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
    //--- DATABASE MAPPING : _hc_err ( text ) 
    public void setHcErr( String hcErr ) {
        this.hcErr = hcErr;
    }
    public String getHcErr() {
        return this.hcErr;
    }

    //--- DATABASE MAPPING : _hc_lastop ( varchar ) 
    public void setHcLastop( String hcLastop ) {
        this.hcLastop = hcLastop;
    }
    public String getHcLastop() {
        return this.hcLastop;
    }

    //--- DATABASE MAPPING : isdeleted ( bool ) 
    public void setIsdeleted( Boolean isdeleted ) {
        this.isdeleted = isdeleted;
    }
    public Boolean getIsdeleted() {
        return this.isdeleted;
    }

    //--- DATABASE MAPPING : createddate ( timestamp ) 
    public void setCreateddate( Date createddate ) {
        this.createddate = createddate;
    }
    public Date getCreateddate() {
        return this.createddate;
    }

    //--- DATABASE MAPPING : sfid ( varchar ) 
    public void setSfid( String sfid ) {
        this.sfid = sfid;
    }
    public String getSfid() {
        return this.sfid;
    }

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

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
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
