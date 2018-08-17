package org.telecom.billingservice.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 资费实体类
 * @author wzc
 *
 */
@Entity
@Table(name="t_tariff_info")
@OptimisticLocking(type=OptimisticLockType.VERSION)
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TariffInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8452715378405135028L;
	/**资费ID*/
	@Id
	@Column(name="id")
	@GenericGenerator(name = "g.id", strategy = "identity")
	@GeneratedValue(generator="g.id")
	private long id;
	/**资费状态(资费状态  ， 0代表未开通   ，1代表已经开通，初始添加的资费状态为0)*/
	@Column(name="tariff_state")
	private int tariffState;
	/**资费名称*/
	@Column(name="tariff_name",length=20)
	private String tariffName;
	/**资费类型(资费类型：  1 代表包月  、  2 代表套餐   、 3  代表计时)*/
	@Column(name="tariff_type")
	private int tariffType; 
	/**基本时长*/
	@Column(name="base_time")
	private long baseTime;
	/**基本费用*/
	@Column(name="base_cost")
	private double baseCost;
	/**单位费用*/
	@Column(name="unit_cost")
	private double unitCost;
	/**资费描述*/
	@Column(name="cost_describle",length=50)
	
	private String costDescrible;
	/**资费开通时间*/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd ")
	@Column(name="strat_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date stratTime;
	/**资费创建时间*/
	@Column(name="create_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createTime;
	/**资费修改时间*/
	@Column(name="update_time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updateTime;
	/**版本*/
	@Version
	private int version;
	public TariffInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getTariffState() {
		return tariffState;
	}
	public void setTariffState(int tariffState) {
		this.tariffState = tariffState;
	}
	public String getTariffName() {
		return tariffName;
	}
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}
	public int getTariffType() {
		return tariffType;
	}
	public void setTariffType(int tariffType) {
		this.tariffType = tariffType;
	}
	public long getBaseTime() {
		return baseTime;
	}
	public void setBaseTime(long baseTime) {
		this.baseTime = baseTime;
	}
	public double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public String getCostDescrible() {
		return costDescrible;
	}
	public void setCostDescrible(String costDescrible) {
		this.costDescrible = costDescrible;
	}
	public Date getStratTime() {
		return stratTime;
	}
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/*public BusinessInfoBean getBusinessInfo() {
		return businessInfo;
	}
	public void setBusinessInfo(BusinessInfoBean businessInfo) {
		this.businessInfo = businessInfo;
	}*/
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	/*@Override
	public String toString() {
		return "TariffInfoBean [id=" + id + ", tariffState=" + tariffState + ", tariffName=" + tariffName
				+ ", tariffType=" + tariffType + ", baseTime=" + baseTime + ", baseCost=" + baseCost + ", unitCost="
				+ unitCost + ", costDescrible=" + costDescrible + ", stratTime=" + stratTime + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", businessInfo=" + businessInfo + ", version=" + version
				+ "]";
	}*/
	@Override
	public String toString() {
		return "TariffInfoBean [id=" + id + ", tariffState=" + tariffState + ", tariffName=" + tariffName
				+ ", tariffType=" + tariffType + ", baseTime=" + baseTime + ", baseCost=" + baseCost + ", unitCost="
				+ unitCost + ", costDescrible=" + costDescrible + ", stratTime=" + stratTime + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", version=" + version + "]";
	}
	
	
	
}
