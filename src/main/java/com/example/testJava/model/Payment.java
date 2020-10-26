package com.example.testJava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="public.log_nle_api01")
@EntityListeners(AuditingEntityListener.class)
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "id_request_booking", sequenceName = "id_request_booking_seq", allocationSize = 1)
	private String id;

	@Column(name = "id_platform", length = 20)
	private String idPlatform;

	@Column(name = "nama_platform",length = 20)
	private String namaPlatform;
	
	@Column(name = "doc_type",length = 20)
	private String docType;
	
	@Column(name = "term_of_payment",length = 5)
	private String termOfPayment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdPlatform() {
		return idPlatform;
	}

	public void setIdPlatform(String idPlatform) {
		this.idPlatform = idPlatform;
	}

	public String getNamaPlatform() {
		return namaPlatform;
	}

	public void setNamaPlatform(String namaPlatform) {
		this.namaPlatform = namaPlatform;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getTermOfPayment() {
		return termOfPayment;
	}

	public void setTermOfPayment(String termOfPayment) {
		this.termOfPayment = termOfPayment;
	}
	
	
}
