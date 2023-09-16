package com.example.test.domain;

import java.io.Serializable;

/**
 * Auto-generated: 2022-10-26 11:6:55
 * 人员综合业务信息
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PersonPubBusiInfoDTO implements Serializable {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 个人唯一识别码(个人编号)
	 */
	private String personUniqueId;
	/**
	 * 户籍性质
	 */
	private String householdType;
	/**
	 * 学历
	 */
	private String educationLevel;
	/**
	 * 职称专业
	 */
	private String professionalType;
	/**
	 * 职称级别
	 */
	private String professionalLevel;
	/**
	 * 职业（工种）
	 */
	private String skillType;
	/**
	 * 技能等级（职业资格等级）
	 */
	private String skillLevel;
	/**
	 * 政治面貌
	 */
	private String politicalAffiliation;
	/**
	 * 生存状态
	 */
	private String deathFlag;
	/**
	 * 死亡日期
	 */
	private String deathDate;
	/**
	 * 居住地址
	 */
	private String address;
	/**
	 * 移动电话号码
	 */
	private String mobile;
	/**
	 * 户籍号
	 */
	private String householdNumber;
	/**
	 * 户籍地行政区划
	 */
	private String householdStateCode;
	/**
	 * 死亡核准来源
	 */
	private String deathApprovalSource;
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
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public String getPersonUniqueId() {
		return personUniqueId;
	}

	public void setPersonUniqueId(String personUniqueId) {
		this.personUniqueId = personUniqueId;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}
	public String getHouseholdType() {
		return householdType;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getEducationLevel() {
		return educationLevel;
	}

	public void setProfessionalType(String professionalType) {
		this.professionalType = professionalType;
	}
	public String getProfessionalType() {
		return professionalType;
	}

	public void setProfessionalLevel(String professionalLevel) {
		this.professionalLevel = professionalLevel;
	}
	public String getProfessionalLevel() {
		return professionalLevel;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	public String getSkillType() {
		return skillType;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getSkillLevel() {
		return skillLevel;
	}

	public void setPoliticalAffiliation(String politicalAffiliation) {
		this.politicalAffiliation = politicalAffiliation;
	}
	public String getPoliticalAffiliation() {
		return politicalAffiliation;
	}

	public void setDeathFlag(String deathFlag) {
		this.deathFlag = deathFlag;
	}
	public String getDeathFlag() {
		return deathFlag;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public String getDeathDate() {
		return deathDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile() {
		return mobile;
	}

	public void setHouseholdNumber(String householdNumber) {
		this.householdNumber = householdNumber;
	}
	public String getHouseholdNumber() {
		return householdNumber;
	}

	public void setHouseholdStateCode(String householdStateCode) {
		this.householdStateCode = householdStateCode;
	}
	public String getHouseholdStateCode() {
		return householdStateCode;
	}

	public void setDeathApprovalSource(String deathApprovalSource) {
		this.deathApprovalSource = deathApprovalSource;
	}
	public String getDeathApprovalSource() {
		return deathApprovalSource;
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

	@Override
	public String toString() {
		return "PersonPubBusiInfoDTO{" +
				"id=" + id +
				", personUniqueId='" + personUniqueId + '\'' +
				", householdType='" + householdType + '\'' +
				", educationLevel='" + educationLevel + '\'' +
				", professionalType='" + professionalType + '\'' +
				", professionalLevel='" + professionalLevel + '\'' +
				", skillType='" + skillType + '\'' +
				", skillLevel='" + skillLevel + '\'' +
				", politicalAffiliation='" + politicalAffiliation + '\'' +
				", deathFlag='" + deathFlag + '\'' +
				", deathDate='" + deathDate + '\'' +
				", address='" + address + '\'' +
				", mobile='" + mobile + '\'' +
				", householdNumber='" + householdNumber + '\'' +
				", householdStateCode='" + householdStateCode + '\'' +
				", deathApprovalSource='" + deathApprovalSource + '\'' +
				", operateId=" + operateId +
				", branchOperateId=" + branchOperateId +
				", operator='" + operator + '\'' +
				", operateTime='" + operateTime + '\'' +
				", operateOrgCode='" + operateOrgCode + '\'' +
				", creator='" + creator + '\'' +
				", createTime='" + createTime + '\'' +
				", createOrgCode='" + createOrgCode + '\'' +
				", socialPoolCode='" + socialPoolCode + '\'' +
				'}';
	}
}