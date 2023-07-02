package com.hwc.isl.loader.dbif.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TN_CM_EQP")
public class TnCmEqp {
	
	@Id
	@Column(name = "EQP_NO")
	private String eqpNo;
	
	@Column(name = "SYS_CODE")
	private String sysCode;
	
	@Column(name = "PJT_ID")
	private String pjtId;
}
