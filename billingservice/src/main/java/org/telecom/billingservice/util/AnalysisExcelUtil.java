package org.telecom.billingservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.telecom.billingservice.bean.RoleInfoBean;
import org.telecom.billingservice.bean.UserInfoBean;

/**
 * 解析excel文件类
 * @author Deng
 *
 */
public class AnalysisExcelUtil {
    public static  List<UserInfoBean> readExcel(String excelName) throws IOException {
        List<UserInfoBean> users=new ArrayList<UserInfoBean>();
    	//将文件读入
    	InputStream in  = new FileInputStream(new File(excelName));
   	    //创建工作簿
    	XSSFWorkbook wb = new XSSFWorkbook(in); 
    	//读取第一个sheet
    	Sheet sheet = wb.getSheetAt(0);
    	int totalRow=sheet.getLastRowNum();
    	Row row=null;
    	//循环读取科目
    	for (int i = 1; i <=totalRow; i++) {
    		//获取第i行
        	row = sheet.getRow(i);
            //这里封装一个用户对象，对象里面包含了角色，默认为普通用户
        	UserInfoBean user=new UserInfoBean();
        	user.setUserName(row.getCell(0).toString());
        	user.setUserReallName(row.getCell(1).toString());
        	user.setUserGender("男".equals(row.getCell(2).toString())?0:1);
        	user.setUserID(row.getCell(3)+"");
        	user.setUserAdress(row.getCell(4).toString());
        	user.setUserEmail(row.getCell(5).toString());
        	user.setUserQQ(row.getCell(6)+"");
        	user.setUserTelphone(row.getCell(7)+"");
        	user.setUserPwd("123456");
        	user.setUserState(1);
        	
        	
        	//封装一个角色对象
        	RoleInfoBean role=new RoleInfoBean();
        	role.setRoleName(row.getCell(0).toString());
        	role.setRoleDescribe("用户");
        	role.setRoleType(2);
        	user.setRoleInfo(role);
        	
        	//添加进入list集合
        	users.add(user);
           
		}
    	return users;	
    }

}
