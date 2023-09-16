package com.example.test.domain;

import java.io.Serializable;

/**
 * Auto-generated: 2022-10-26 11:6:55
 * 人员基础信息
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PersonBasicInfoDTO implements Serializable{

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 个人唯一识别码(个人编号)
	 */
	private String personUniqueId;
	/**
	 * 社会保障号码
	 */
	private String socialSecurityNumber;
	/**
	 * 省人员识别号
	 */
	private String cardPersonId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 证件类型
	 */
	private String certificateType;
	/**
	 * 证件号码
	 */
	private String certificateNumber;
	/**
	 * 国籍/地区
	 */
	private String regionCode;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 出生日期
	 */
	private Long birthday;
	/**
	 * 户籍地址
	 */
	private String householdAddress;
	/**
	 * 公安库比对标识
	 */
	private String publicSecurityFlag;
	/**
	 * 业务核准标识
	 */
	private String approvalFlag;
	/**
	 * 核准经办人
	 */
	private String approvalOperator;
	/**
	 * 核准地市区划
	 */
	private String approvalOrgCode;
	/**
	 * 核准业务来源
	 */
	private String approvalBusiName;
	/**
	 * 核准经办时间
	 */
	private String approvalOperateTime;
	/**
	 * 合并注销标识
	 */
	private String cancelFlag;
	/**
	 * 重复标识
	 */
	private String repeatFlag;
	/**
	 * 操作序号
	 */
	private Long operateId;
	/**
	 * 分支事务ID
	 */
	private Long branchOperateId;
	/**
	 * 经办人
	 */
	private String operator;
	/**
	 * 经办时间
	 */
	private String operateTime;
	/**
	 * 经办人机构编码
	 */
	private String operateOrgCode;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 创建人机构编码
	 */
	private String createOrgCode;
	/**
	 * 统筹区编码
	 */
	private String socialPoolCode;
	/**
	 * 备注
	 */
	private String comments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonUniqueId() {
		return personUniqueId;
	}

	public void setPersonUniqueId(String personUniqueId) {
		this.personUniqueId = personUniqueId;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setCardPersonId(String cardPersonId) {
		this.cardPersonId = cardPersonId;
	}
	public String getCardPersonId() {
		return cardPersonId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}
	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionCode() {
		return regionCode;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSex() {
		return sex;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getNation() {
		return nation;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}
	public Long getBirthday() {
		return birthday;
	}

	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
	}
	public String getHouseholdAddress() {
		return householdAddress;
	}

	public void setPublicSecurityFlag(String publicSecurityFlag) {
		this.publicSecurityFlag = publicSecurityFlag;
	}
	public String getPublicSecurityFlag() {
		return publicSecurityFlag;
	}

	public void setApprovalFlag(String approvalFlag) {
		this.approvalFlag = approvalFlag;
	}
	public String getApprovalFlag() {
		return approvalFlag;
	}

	public void setApprovalOperator(String approvalOperator) {
		this.approvalOperator = approvalOperator;
	}
	public String getApprovalOperator() {
		return approvalOperator;
	}

	public void setApprovalOrgCode(String approvalOrgCode) {
		this.approvalOrgCode = approvalOrgCode;
	}
	public String getApprovalOrgCode() {
		return approvalOrgCode;
	}

	public void setApprovalBusiName(String approvalBusiName) {
		this.approvalBusiName = approvalBusiName;
	}
	public String getApprovalBusiName() {
		return approvalBusiName;
	}

	public void setApprovalOperateTime(String approvalOperateTime) {
		this.approvalOperateTime = approvalOperateTime;
	}
	public String getApprovalOperateTime() {
		return approvalOperateTime;
	}

	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}

	public void setRepeatFlag(String repeatFlag) {
		this.repeatFlag = repeatFlag;
	}
	public String getRepeatFlag() {
		return repeatFlag;
	}

	public void setOperateId(Long operateId) {
		this.operateId = operateId;
	}
	public Long getOperateId() {
		return operateId;
	}

	public void setBranchOperateId(Long branchOperateId) {
		this.branchOperateId = branchOperateId;
	}
	public Long getBranchOperateId() {
		return branchOperateId;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperator() {
		return operator;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateOrgCode(String operateOrgCode) {
		this.operateOrgCode = operateOrgCode;
	}
	public String getOperateOrgCode() {
		return operateOrgCode;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreator() {
		return creator;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateOrgCode(String createOrgCode) {
		this.createOrgCode = createOrgCode;
	}
	public String getCreateOrgCode() {
		return createOrgCode;
	}

	public void setSocialPoolCode(String socialPoolCode) {
		this.socialPoolCode = socialPoolCode;
	}
	public String getSocialPoolCode() {
		return socialPoolCode;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "PersonBasicInfoDTO{" +
				"id=" + id +
				", personUniqueId='" + personUniqueId + '\'' +
				", socialSecurityNumber='" + socialSecurityNumber + '\'' +
				", cardPersonId='" + cardPersonId + '\'' +
				", name='" + name + '\'' +
				", certificateType='" + certificateType + '\'' +
				", certificateNumber='" + certificateNumber + '\'' +
				", regionCode='" + regionCode + '\'' +
				", sex='" + sex + '\'' +
				", nation='" + nation + '\'' +
				", birthday=" + birthday +
				", householdAddress='" + householdAddress + '\'' +
				", publicSecurityFlag='" + publicSecurityFlag + '\'' +
				", approvalFlag='" + approvalFlag + '\'' +
				", approvalOperator='" + approvalOperator + '\'' +
				", approvalOrgCode='" + approvalOrgCode + '\'' +
				", approvalBusiName='" + approvalBusiName + '\'' +
				", approvalOperateTime='" + approvalOperateTime + '\'' +
				", cancelFlag='" + cancelFlag + '\'' +
				", repeatFlag='" + repeatFlag + '\'' +
				", operateId=" + operateId +
				", branchOperateId=" + branchOperateId +
				", operator='" + operator + '\'' +
				", operateTime='" + operateTime + '\'' +
				", operateOrgCode='" + operateOrgCode + '\'' +
				", creator='" + creator + '\'' +
				", createTime='" + createTime + '\'' +
				", createOrgCode='" + createOrgCode + '\'' +
				", socialPoolCode='" + socialPoolCode + '\'' +
				", comments='" + comments + '\'' +
				'}';
	}
}