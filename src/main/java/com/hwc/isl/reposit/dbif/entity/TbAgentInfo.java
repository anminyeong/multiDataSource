package com.hwc.isl.reposit.dbif.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_AGENT_INFO")
public class TbAgentInfo {

	@Id
	@Column(name = "AGENT_ID")
	private String agentId;

	@Column(name = "AGENT_NAME")
	private String agentName;

	@Column(name = "AGENT_TYPE")
	private String agentType;

	@Column(name = "AGENT_KIND")
	private String agentKind;

	@Column(name = "DESCRIPT")
	private String desc;

	@Column(name = "REG_DATE")
	private String regDate;

	@Column(name = "REG_USER_ID")
	private String regUserId;

	@Column(name = "MOD_DATE")
	private String modDate;

	@Column(name = "MOD_USER_ID")
	private String modUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVER_ID")
	private TbServerInfo tbServerInfo;

	@PrePersist // 데이터 생성이 이루어질때 사전 작업
	public void prePersist() {
		this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.modDate = this.regDate;
	}

	@PreUpdate // 데이터 수정이 이루어질때 사전 작업
	public void preUpdate() {
		this.modDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
