/**
 * 
 */
package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sunil
 *
 * Machine.java Feb 24, 2021 5:54:02 PM
 */

@Entity
@Table(name="Machines")
public class Machine implements Serializable{
	
	@Id
	private Long ref_no;
	private String machineName;
	private String machineType;//VM/Desktop/Container
	private String machineIPAddress;
	private String machineMACAddress;
	private String ramSize;
	private String vmVendor;
	
	public Machine() {
	}
	
	
	
	public String getMachineType() {
		return machineType;
	}



	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}



	public String getMachineIPAddress() {
		return machineIPAddress;
	}



	public void setMachineIPAddress(String machineIPAddress) {
		this.machineIPAddress = machineIPAddress;
	}



	public String getMachineMACAddress() {
		return machineMACAddress;
	}



	public void setMachineMACAddress(String machineMACAddress) {
		this.machineMACAddress = machineMACAddress;
	}



	public String getRamSize() {
		return ramSize;
	}



	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}



	public String getVmVendor() {
		return vmVendor;
	}



	public void setVmVendor(String vmVendor) {
		this.vmVendor = vmVendor;
	}



	public Long getRef_no() {
		return ref_no;
	}


	public void setRef_no(Long ref_no) {
		this.ref_no = ref_no;
	}


	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	
}

