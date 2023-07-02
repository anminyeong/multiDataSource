package com.hwc.isl.loader.dbif.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TN_CM_EQP")
public class TnCmISLAgent {

	@Id
	@Column(name = "EQP_NO")
	private String agentId;

	@Column(name = "PJT_ID")
	private String pjtId;

	@Column(name = "POLL_CYCLE_MSEC")
	private String pollCycleMsec;

	@Column(name = "MOD_DATE")
	private String modDate;

	@Column(name = "MOD_USER_ID")
	private String modUserId;

	@Column(name = "REG_DATE")
	private String regDate;

	@Column(name = "REG_USER_ID")
	private String regUserId;

	@Column(name = "USE_YN")
	private String useTn;
}
