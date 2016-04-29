package com.whut.cailiao.ms.api.model.pagination;

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
    /** 每页显示的记录数 */
    private int pageSize;
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

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

}
