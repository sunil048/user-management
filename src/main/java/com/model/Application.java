/**
 * 
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sunil
 *
 * Application.java Feb 21, 2021 11:44:18 PM
 */
@Entity
@Table(name="APPLICATIONS")
public class Application {
	@Id
	private Long id;
	private String appName;
	private String appType;
	private String envName;
	@Column(name="env_ref")
	private Long envRef;
	private String installedPath;
	private String username;
	private String password;
	private String port;
	private String url;
	private String instanceName;
	
	
	
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	/*@ManyToOne
	@JoinColumn(name="env_ref",nullable = false, insertable = false, updatable = false)
	private Environment environment;
	
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}*/
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Long getEnvRef() {
		return envRef;
	}
	public void setEnvRef(Long envRef) {
		this.envRef = envRef;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/*public String getEnv() {
		return env;
	}
	public void setEnv(String env) {
		this.env = env;
	}*/
	public String getInstalledPath() {
		return installedPath;
	}
	public void setInstalledPath(String installedPath) {
		this.installedPath = installedPath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	
}
