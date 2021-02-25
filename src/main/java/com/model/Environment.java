/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Sunil
 *
 * Environment.java Feb 21, 2021 8:45:15 PM
 */
@Entity
@Table(name="ENVIRONMENTS")
public class Environment implements Serializable {

	@Id
	private Long refNo;
	private String envId;
	private String name;
	private String createdDate;
	private String createdBy;
	private String upDatedDate;
	private String updatedBY;
	private String userName;
	private String password;
	
	public Environment() {
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	private Machine machine;
	
	@OneToOne(cascade=CascadeType.ALL)
	private OperatingSystem os;
	
	//@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	//@JoinColumn(name="env_ref")
   // @JoinColumn(name = "name", insertable = false, nullable = false, updatable = false, referencedColumnName="env_ref")
	/*@JoinTable(name = "ENVIRONMENTS", joinColumns = {
	        @JoinColumn(name = "OBJID") }, inverseJoinColumns = {
	                //@JoinColumn(name = "name", referencedColumnName = "name", nullable = false, insertable = false, updatable = false),
	                @JoinColumn(name = "envRef", referencedColumnName = "env_ref", nullable = false, insertable = false, updatable = false)
	                })*/
	//private List<Application> applications;
	
	/*public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}*/
	public OperatingSystem getOs() {
		return os;
	}
	public void setOs(OperatingSystem os) {
		this.os = os;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRefNo() {
		return refNo;
	}
	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
	public String getEnvId() {
		return envId;
	}
	public void setEnvId(String envId) {
		this.envId = envId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpDatedDate() {
		return upDatedDate;
	}
	public void setUpDatedDate(String upDatedDate) {
		this.upDatedDate = upDatedDate;
	}
	public String getUpdatedBY() {
		return updatedBY;
	}
	public void setUpdatedBY(String updatedBY) {
		this.updatedBY = updatedBY;
	}
	
}
