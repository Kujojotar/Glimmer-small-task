package com.example.demo.util;

import java.util.List;

import java.util.ArrayList;

/**
 * @author james
 * 一个简单的逻辑分页助手
 */
public class LogicPagingHelper {
    private List<?> list;
    //list中记录的条数
    private int totalRecords;
    //每一页条目的大小
    private int pageSize;
    //页数的总数
    private int pageNums;
    private List<Object> showList;

    public LogicPagingHelper(List<?> list,int pageSize){
        this.list=list;
        this.pageSize=pageSize;
        if(pageSize<=0){
            //Why 11?He is a good b♂y.
            pageSize=11;
        }
        showList=new ArrayList<>();
        totalRecords=list.size();
        pageNums=totalRecords%pageSize==0?totalRecords/pageSize:(totalRecords/pageSize)+1;
    }

    public List<Object> showPageContent(int page){
        if(page<=0||page>pageNums){
            return null;
        }
        showList.removeAll(showList);
        Object e;
        for(int i=(page-1)*pageSize;i<page*pageSize&&i<totalRecords;i++){
            e=list.get(i);
            showList.add(e);
        }
        return showList;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNums() {
        return pageNums;
    }

    public void setList(List<?> list,int newSize) {
        this.list=list;
        this.pageSize=newSize;
        if(pageSize<=0){
            //Why 11?He is a good b♂y.
            pageSize=11;
        }
        totalRecords=list.size();
        pageNums=totalRecords%newSize==0?totalRecords/newSize:(totalRecords/newSize)+1;
    }
}

class test{
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<Integer>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        LogicPagingHelper helper=new LogicPagingHelper(integers,4);
        System.out.println(helper.showPageContent(1));
        System.out.println(helper.showPageContent(2));
        System.out.println(helper.showPageContent(3));
    }
}
