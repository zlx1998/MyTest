package com.example.test.domain;

import java.io.Serializable;

/**
 * @author zhanglixiang
 * @date 2023/8/6 16:44
 */
public class Body implements Serializable {
	private String zzName;
	private String isLicensePdf;
	private String prSearch;
	private String ip;
	private String userNo;
	private String containJpg;
	private String userName;
	private String zzList;
	private String qrDate;
	private String cName;
	private String name;
	private String appKey;
	private String state;
	private String zzbh;

	public Body(String zzbh) {
		this.zzName = "RS07";
		this.isLicensePdf = "00";
		this.prSearch = "00";
		this.ip = "127.0.0.1";
		this.userNo = "";
		this.containJpg = "00";
		this.userName = "userName";
		this.zzList = "";
		this.qrDate = "";
		this.cName = "";
		this.name = "";
		this.appKey = "074d8e05054540c2bb5fb1ac67f665a0";
		this.state = "01";
		this.zzbh = zzbh;
	}

	public Body() {
	}

	public Body(String zzName, String isLicensePdf, String prSearch, String ip, String userNo, String containJpg, String userName, String zzList, String qrDate, String cName, String name, String appKey, String state, String zzbh) {
		this.zzName = zzName;
		this.isLicensePdf = isLicensePdf;
		this.prSearch = prSearch;
		this.ip = ip;
		this.userNo = userNo;
		this.containJpg = containJpg;
		this.userName = userName;
		this.zzList = zzList;
		this.qrDate = qrDate;
		this.cName = cName;
		this.name = name;
		this.appKey = appKey;
		this.state = state;
		this.zzbh = zzbh;
	}

	public String getZzName() {
		return zzName;
	}

	public void setZzName(String zzName) {
		this.zzName = zzName;
	}

	public String getIsLicensePdf() {
		return isLicensePdf;
	}

	public void setIsLicensePdf(String isLicensePdf) {
		this.isLicensePdf = isLicensePdf;
	}

	public String getPrSearch() {
		return prSearch;
	}

	public void setPrSearch(String prSearch) {
		this.prSearch = prSearch;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getContainJpg() {
		return containJpg;
	}

	public void setContainJpg(String containJpg) {
		this.containJpg = containJpg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getZzList() {
		return zzList;
	}

	public void setZzList(String zzList) {
		this.zzList = zzList;
	}

	public String getQrDate() {
		return qrDate;
	}

	public void setQrDate(String qrDate) {
		this.qrDate = qrDate;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZzbh() {
		return zzbh;
	}

	public void setZzbh(String zzbh) {
		this.zzbh = zzbh;
	}
}
