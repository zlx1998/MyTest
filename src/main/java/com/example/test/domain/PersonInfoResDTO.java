package com.example.test.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2022-10-26 11:6:55
 * 人员基本信息返回
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class PersonInfoResDTO implements Serializable {

	private Boolean bizSuccess;
	private String errorCode;
	private String message;
	private String operateId;
	private List<PersonInfoDTO> personInfoDTOList;
	public void setBizSuccess(boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}
	public boolean getBizSuccess() {
		return bizSuccess;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorCode() {
		return errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	public void setOperateId(String operateId) {
		this.operateId = operateId;
	}
	public String getOperateId() {
		return operateId;
	}

	public void setBizSuccess(Boolean bizSuccess) {
		this.bizSuccess = bizSuccess;
	}

	public List<PersonInfoDTO> getPersonInfoDTOList() {
		return personInfoDTOList;
	}

	public void setPersonInfoDTOList(List<PersonInfoDTO> personInfoDTOList) {
		this.personInfoDTOList = personInfoDTOList;
	}

	@Override
	public String toString() {
		return "PersonInfoResDTO{" +
				"bizSuccess=" + bizSuccess +
				", errorCode='" + errorCode + '\'' +
				", message='" + message + '\'' +
				", operateId='" + operateId + '\'' +
				", personInfoDTOList=" + personInfoDTOList +
				'}';
	}
}