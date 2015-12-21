package com.chenshi.family;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Person
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String iteraryName;

	@Column
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "PARENTID")
	private Person parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Person> children = new HashSet<>();

	@Column
	private Timestamp updatedAt;

	@Column
	private Timestamp createdAt;

	@Column
	private String description;

	@Column
	private String operator;

	@Enumerated(EnumType.STRING)
	private LifeStatus lifeStatus;

	@Column
	@Temporal(TemporalType.DATE)
	private Date deathday;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id)
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
	 * @return the parent
	 */
	public Person getParent()
	{
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Person parent)
	{
		this.parent = parent;
	}

	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt()
	{
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt)
	{
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt()
	{
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt)
	{
		this.createdAt = createdAt;
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

	/**
	 * @return the children
	 */
	public Set<Person> getChildren()
	{
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Set<Person> children)
	{
		this.children = children;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", iteraryName=" + iteraryName
				+ ", birthday=" + birthday + ", parent=" + parent.getName() + ", updatedAt="
				+ updatedAt + ", createdAt=" + createdAt + ", description=" + description
				+ ", operator=" + operator + ", lifeStatus=" + lifeStatus + ", deathday=" + deathday
				+ "]";
	}
}
