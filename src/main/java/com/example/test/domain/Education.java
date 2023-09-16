package com.example.test.domain;

import java.io.Serializable;

/**
 * 学历
 *
 * @author zlx
 * @date 2022/6/16 11:15
 */
public class Education implements Serializable {
	/**
	 * 个人编号 BAC001
	 */
	private String bac001;
	/**
	 * 学历层次（本科、专科、硕士研究生、博士研究生）CC
	 */
	private String cc;
	/**
	 * 入学日期 RXRQ
	 */
	private String rxrq;
	/**
	 * 学历学制 XXXS
	 */
	private String xxxs;
	/**
	 * 姓名 XM
	 */
	private String xm;
	/**
	 * 证书编号 ZSBH
	 */
	private String zsbh;
	/**
	 * 毕业日期 BYRQ
	 */
	private String byrq;
	/**
	 * 证件号码 ZJHM
	 */
	private String zjhm;
	/**
	 * 专业名称 ZYMC
	 */
	private String zymc;
	/**
	 * 院校名称 YXMC
	 */
	private String yxmc;
	/**
	 * 学制 XZ
	 */
	private String xz;
	/**
	 * 学业结束类型 XYJSLX
	 */
	private String xyjslx;
	/**
	 * 字段属性（业务核准、外联核准）ZDSX
	 */
	private String zdsx;

	public String getBac001() {
		return bac001;
	}

	public void setBac001(String bac001) {
		this.bac001 = bac001;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getRxrq() {
		return rxrq;
	}

	public void setRxrq(String rxrq) {
		this.rxrq = rxrq;
	}

	public String getXxxs() {
		return xxxs;
	}

	public void setXxxs(String xxxs) {
		this.xxxs = xxxs;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZsbh() {
		return zsbh;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	public String getByrq() {
		return byrq;
	}

	public void setByrq(String byrq) {
		this.byrq = byrq;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getYxmc() {
		return yxmc;
	}

	public void setYxmc(String yxmc) {
		this.yxmc = yxmc;
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getXyjslx() {
		return xyjslx;
	}

	public void setXyjslx(String xyjslx) {
		this.xyjslx = xyjslx;
	}

	public String getZdsx() {
		return zdsx;
	}

	public void setZdsx(String zdsx) {
		this.zdsx = zdsx;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Education{");
		sb.append(", BAC001='").append(bac001).append('\'');
		sb.append(", CC=").append(cc);
		sb.append(", RXRQ='").append(rxrq).append('\'');
		sb.append(", XXXS=").append(xxxs);
		sb.append(", XM=").append(xm);
		sb.append(", ZSBH='").append(zsbh).append('\'');
		sb.append(", BYRQ=").append(byrq);
		sb.append(", ZJHM=").append(zjhm);
		sb.append(", ZYMC='").append(zymc).append('\'');
		sb.append(", YXMC='").append(yxmc).append('\'');
		sb.append(", XZ='").append(xz).append('\'');
		sb.append(", XYJSLX='").append(xyjslx).append('\'');
		sb.append(", ZDSX='").append(zdsx).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
