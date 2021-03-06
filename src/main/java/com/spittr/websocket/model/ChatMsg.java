package com.spittr.websocket.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spittr.user.model.User;

/**
 * 聊天消息存储实体
 * @author janke
 *
 */
@Entity
@Table(name="chatMsg")
@JsonIgnoreProperties({"isRecived", "tmRecived"})
public class ChatMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967729241464217970L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String chatID;
	
	// sender 
	@ManyToOne
	@JoinColumn(name="sender", nullable=false)
	private User sender;

	// reciver 的 uName
	@Column(nullable=false)
	private String reciver;
	
	// sender 的 nName
	@Column(nullable=false)
	private String nSender;
	
	@Column(nullable=false)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date time;
	
	@Column(nullable=false)
	private Long senderId;
	
	@Column(nullable=false)
	private Long reciverId;
	
	@Column(nullable=false)
	private boolean isRecived;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date tmRecived;
	
	public ChatMsg() {
		// TODO Auto-generated constructor stub
	}
	
	public ChatMsg(User sender, User reciver, SendMsg sendMsg) {
		this(sendMsg.getMsgID(), sender, sender.getNname(), reciver.getUname(), reciver.getNname(), sendMsg.getMessage(), new Date(), sender.getUid(), reciver.getUid(), false, null);
	}
	
	public ChatMsg( String chatID, User sender, String nSender, String reciver, String nReciver, String content, Date time, Long senderId,
			Long reciverId, Boolean isRecived, Date tmRecived) {
		super();
		this.chatID = chatID;
		this.sender = sender;
		this.nSender = nSender;
		this.reciver = reciver;
		this.content = content;
		this.time = time;
		this.senderId = senderId;
		this.reciverId = reciverId;
		this.isRecived = isRecived;
		this.tmRecived = tmRecived;
	}

	
	
	public String getChatID() {
		return chatID;
	}

	public void setChatID(String chatID) {
		this.chatID = chatID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getReciverId() {
		return reciverId;
	}

	public void setReciverId(Long reciverId) {
		this.reciverId = reciverId;
	}

	public Boolean getIsRecived() {
		return isRecived;
	}

	public void setIsRecived(Boolean isRecived) {
		this.isRecived = isRecived;
	}

	public Date getTmRecived() {
		return tmRecived;
	}

	public void setTmRecived(Date tmRecived) {
		this.tmRecived = tmRecived;
	}
	
	public String getnSender() {
		return nSender;
	}

	public void setnSender(String nSender) {
		this.nSender = nSender;
	}

	public void setRecived(boolean isRecived) {
		this.isRecived = isRecived;
	}

	@Override
	public String toString() {
		return "ChatMsg [id = "+  id +",  chatID=" + chatID + ", sender=" + sender + ", reciver=" + reciver + ", content=" + content
				+ ", time=" + time + ", senderId=" + senderId + ", reciverId=" + reciverId + ", isRecived=" + isRecived
				+ ", tmRecived=" + tmRecived + "]";
	}
}
