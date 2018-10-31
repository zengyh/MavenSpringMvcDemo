package edu.mvcdemo.entity;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @编写人： yh.zeng
 * @编写时间：2018-9-15 上午12:31:27
 * @文件描述: todo
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BaseEntity {

	//主键ID
	public Long id;
	
	//创建人
	public String createdUser;
	
	//创建时间
	public Date createdDate;
	
	//修改人
	public String updatedUser;
	
	//修改时间
	public Date updatedDate;
	
	//记录是否有效
	public String isValid = "Y";
	
}
