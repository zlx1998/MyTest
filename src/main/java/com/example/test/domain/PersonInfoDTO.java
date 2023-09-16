package com.example.test.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 人员基本信息封装
 * @author zlx
 * @date 2022/10/26 11:24
 */
public class PersonInfoDTO implements Serializable {

	private List<PersonBasicInfoDTO> personBasicInfoDTO;
	private List<PersonPubBusiInfoDTO> personPubBusiInfoDTO;

	public List<PersonBasicInfoDTO> getPersonBasicInfoDTO() {
		return personBasicInfoDTO;
	}

	public void setPersonBasicInfoDTO(List<PersonBasicInfoDTO> personBasicInfoDTO) {
		this.personBasicInfoDTO = personBasicInfoDTO;
	}

	public List<PersonPubBusiInfoDTO> getPersonPubBusiInfoDTO() {
		return personPubBusiInfoDTO;
	}

	public void setPersonPubBusiInfoDTO(List<PersonPubBusiInfoDTO> personPubBusiInfoDTO) {
		this.personPubBusiInfoDTO = personPubBusiInfoDTO;
	}

	@Override
	public String toString() {
		return "PersonInfoDTO{" +
				"personBasicInfoDTO=" + personBasicInfoDTO +
				", personPubBusiInfoDTO=" + personPubBusiInfoDTO +
				'}';
	}
}
