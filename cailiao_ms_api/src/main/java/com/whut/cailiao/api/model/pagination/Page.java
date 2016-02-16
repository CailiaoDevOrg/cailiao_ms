package com.whut.cailiao.api.model.pagination;

import java.io.Serializable;
import java.util.List;

/**
 * 分页
 * 
 * @author niuyang
 *
 * @param <T>
 */
public class Page<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;
    /** 页面数据列表 */
    private List<T> list;
    /** 第几页 */
    private int currentPage;
    /** 共几页 */
    private int totalPage;
    /** 每页显示的记录数 */
    private int rowNum;
    /** 总记录数 */
    private int totalNum;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

}
