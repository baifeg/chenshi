package com.chenshi.family;

public enum LifeStatus
{
	ALIVE("����"), DEAD("�ѹ�");

	private String label;

	private LifeStatus(String label)
	{
		this.label = label;
	}

	public String getLabel()
	{
		return label;
	}
}
