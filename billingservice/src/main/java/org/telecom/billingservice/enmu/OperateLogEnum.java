package org.telecom.billingservice.enmu;
/**
 * 操作日志操作类型枚举类
 * @author liuyangliang
 *
 */
public enum OperateLogEnum {
	/**
	 * SAVE值为0:保存
	 * UPDATE值为1:修改
	 * DELETE值为2:删除
	 */
	SAVE(0),UPDATE(1),DELETE(2);
	/** 类型对应数*/
	private int type;
	
	private OperateLogEnum(int type){
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
	
}
