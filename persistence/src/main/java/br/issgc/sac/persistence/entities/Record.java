/**
 *
 */
package br.issgc.sac.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.GsonBuilder;

import br.issgc.sac.persistence.constants.BrazilStates;
import br.issgc.sac.persistence.entities.helpers.Motivation;
import br.issgc.sac.persistence.entities.helpers.RecordType;

/**
 * Represents a customer service record created by the attendant.
 *
 * @author dinhego
 *
 */
@Entity
@Table(name = "RECORDS")
public class Record implements DatabaseEntity {

	private static final long serialVersionUID = -8629603454732408832L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private RecordType type;

	@Enumerated(EnumType.STRING)
	@Column(length = 2)
	private BrazilStates clientState;

	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private Motivation customerMotivation;

	@Column(length = 512)
	private String details;

	/**
	 * @param id
	 * @param type
	 * @param clientState
	 * @param customerMotivation
	 * @param details
	 */
	public Record(long id, RecordType type, BrazilStates clientState, Motivation customerMotivation, String details) {
		super();
		this.id = id;
		this.type = type;
		this.clientState = clientState;
		this.customerMotivation = customerMotivation;
		this.details = details;
	}

	/**
	 * default no-arg
	 */
	public Record() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see br.issgc.sac.persistence.entities.DatabaseEntity#getId()
	 */
	@Override
	public Serializable getId() {
		return this.id;
	}

	public RecordType getType() {
		return this.type;
	}

	public BrazilStates getClientState() {
		return this.clientState;
	}

	public Motivation getCustomerMotivation() {
		return this.customerMotivation;
	}

	public String getDetails() {
		return this.details;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.clientState == null) ? 0 : this.clientState.hashCode());
		result = prime * result + ((this.customerMotivation == null) ? 0 : this.customerMotivation.hashCode());
		result = prime * result + ((this.details == null) ? 0 : this.details.hashCode());
		result = prime * result + (int) (this.id ^ (this.id >>> 32));
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Record)) {
			return false;
		}
		final Record other = (Record) obj;

		return other.hashCode() == this.hashCode();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(this);
	}

}
