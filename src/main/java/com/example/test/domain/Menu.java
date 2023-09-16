package com.example.test.domain;

/**
 * @author zlx
 * @date 2022/11/11 17:06
 */

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Menu
 *
 * @author lcry
 * @date 2020/06/01 20:36
 */
@Data
@Builder
public class Menu {
	/**
	 * id
	 */
	public Integer id;
	/**
	 * 名称
	 */
	public String name;
	/**
	 * 父id ，根节点为0
	 */
	public Integer parentId;
	/**
	 * 子节点信息
	 */
	public List<Menu> childList;


	public Menu(Integer id, String name, Integer parentId) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
	}

	public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.childList = childList;
	}

}
