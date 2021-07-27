package ar.com.educacionit.domain;

import java.io.Serializable;

public abstract class Entity {

	public abstract void setId(Serializable id);
	public abstract Serializable getId();
}
