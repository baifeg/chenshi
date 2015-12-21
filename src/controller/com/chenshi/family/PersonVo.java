package com.chenshi.family;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.chenshi.spring.SpringHelper;

public class PersonVo
{
	private Long id;

	@NotEmpty(message = "姓名不能为空")
	private String name;

	private String iteraryName;

	private Date birthday;

	@NotNull(message = "必须选择一个父节点")
	private Long parentId;

	private String description;

	private String operator;

	@NotNull(message = "生命状态不能为空")
	private LifeStatus lifeStatus;

	private Date deathday;

	public Person toEntity()
	{
		PersonService service = SpringHelper.getApplicationContext().getBean(PersonService.class);
		Person person = new Person();
		person.setBirthday(birthday);
		person.setName(name);
		person.setIteraryName(iteraryName);
		person.setLifeStatus(lifeStatus);
		Person parent = service.getById(parentId);
		person.setParent(parent);
		person.setDeathday(deathday);
		person.setDescription(description);
		person.setOperator(operator);
		return person;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the iteraryName
	 */
	public String getIteraryName()
	{
		return iteraryName;
	}

	/**
	 * @param iteraryName the iteraryName to set
	 */
	public void setIteraryName(String iteraryName)
	{
		this.iteraryName = iteraryName;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday()
	{
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId()
	{
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId)
	{
		this.parentId = parentId;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the operator
	 */
	public String getOperator()
	{
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator)
	{
		this.operator = operator;
	}

	/**
	 * @return the lifeStatus
	 */
	public LifeStatus getLifeStatus()
	{
		return lifeStatus;
	}

	/**
	 * @param lifeStatus the lifeStatus to set
	 */
	public void setLifeStatus(LifeStatus lifeStatus)
	{
		this.lifeStatus = lifeStatus;
	}

	/**
	 * @return the deathday
	 */
	public Date getDeathday()
	{
		return deathday;
	}

	/**
	 * @param deathday the deathday to set
	 */
	public void setDeathday(Date deathday)
	{
		this.deathday = deathday;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PersonVo [id=" + id + ", name=" + name + ", iteraryName=" + iteraryName
				+ ", birthday=" + birthday + ", parentId=" + parentId + ", description="
				+ description + ", operator=" + operator + ", lifeStatus=" + lifeStatus
				+ ", deathday=" + deathday + "]";
	}
}
