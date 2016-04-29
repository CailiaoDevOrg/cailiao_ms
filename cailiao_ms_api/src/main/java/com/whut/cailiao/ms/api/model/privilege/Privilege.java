package com.whut.cailiao.ms.api.model.privilege;

import java.io.Serializable;

/**
 * Created by gammaniu on 16/4/18.
 */
public class Privilege implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String url; // 请求
    private String method; // 请求方法

    private String description;

    public Privilege() {
    }

    public Privilege(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Privilege{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Privilege privilege = (Privilege) o;

        if (!url.equals(privilege.url) && url.matches(privilege.url)) return false;
        return method.equalsIgnoreCase(privilege.method);
    }

    @Override
    public int hashCode() {
        int result = url.hashCode();
        result = 31 * result + method.hashCode();
        return result;
    }

    public static void main(String[] args) {
        String str = "/wjt/getWJT/3.html";
        boolean matches = str.matches("/wjt/getWJT/[1,2].html");
        System.out.println(matches);
    }
}
