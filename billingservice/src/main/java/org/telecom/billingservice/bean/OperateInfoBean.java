package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 操作日志实体类 
 * @author wzc
 *
 */
@Entity
@Table(name="t_operate_info")
public class OperateInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6745701983986234596L;
	/**操作日志ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long  id;
	/**操作人员*/
	@Column(name="operator",length=20)
	private String operator;
	/**操作时间*/
	@Column(name="operator_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date operatorTime;
	/**操作模块(0-用户管理,1-资费管理,2-管理员管理,3-账单查询,4-账务查询,5-报表，6-前台日志、7-权限管理、8-用户自服务)*/
	@Column(name="operator_mode")
	private int operatorMode;
	/**操作类型(0 新增   1 修改   2 删除)*/
	@Column(name="operator_type")
	private int operatorType;
	/**数据对象*/
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	@JoinColumn(name="fk_data_id")
	private DataInfoBean dataInfo;
	public OperateInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	public int getOperatorMode() {
		return operatorMode;
	}
	public void setOperatorMode(int operatorMode) {
		this.operatorMode = operatorMode;
	}
	public int getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(int operatorType) {
		this.operatorType = operatorType;
	}
	public DataInfoBean getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(DataInfoBean dataInfo) {
		this.dataInfo = dataInfo;
	}
	@Override
	public String toString() {
		return "OperateInfoBean [id=" + id + ", operator=" + operator + ", operatorTime=" + operatorTime
				+ ", operatorMode=" + operatorMode + ", operatorType=" + operatorType + ", dataInfo=" + dataInfo + "]";
	}
	
	
}
