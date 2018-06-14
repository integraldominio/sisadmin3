package com.idomine.admin.web.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LineChartBean {
 
    protected List<Integer> simpleList;
     
    public List<Integer> getSimpleList() {
        return simpleList;
    }            
     
    public LineChartBean() {
        reload();
    }
 
    private void reload() {
        simpleList = new ArrayList<>();
         
        Random r = new Random();
        for (int i = 2000; i < 2010; i++) {
            simpleList.add(r.nextInt(500) + 800);    
        }  
    }
}