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
 * DatabaseEnvironment.java Feb 21, 2021 8:48:38 PM
 */

public class DatabaseInstance extends Application {

	private String instanceId;
	private String dbVendor;
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	public String getDbVendor() {
		return dbVendor;
	}
	public void setDbVendor(String dbVendor) {
		this.dbVendor = dbVendor;
	}
	
	
}
