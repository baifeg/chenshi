package com.chenshi.family;

public enum LifeStatus
{
	ALIVE("ÔÚÊÀ"), DEAD("ÒÑ¹Ê");

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
