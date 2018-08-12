package org.telecom.billingservice.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;  

public class ChooseDataSource extends AbstractRoutingDataSource {  
 
    @Override  
    protected Object determineCurrentLookupKey() {  
        return HandleDataSource.getDataSource();  
    }  
      
} 
