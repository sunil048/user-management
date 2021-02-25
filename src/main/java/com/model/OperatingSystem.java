/**
 * 
 */
package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sunil
 *
 * OperatingSystem.java Feb 24, 2021 4:07:05 PM
 */
@Entity
@Table(name="OS")
public class  OperatingSystem {
	
	@Id
	private Long refNo;
	private String osName;
	private String osVersion;
	private String vendor;
	private String osType;
	
	public Long getRefNo() {
		return refNo;
	}
	public void setRefNo(Long refNo) {
		this.refNo = refNo;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
	public String getOS() {
		return osName;
	}
	public void setOS(String oS) {
		osName = oS;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	
}
