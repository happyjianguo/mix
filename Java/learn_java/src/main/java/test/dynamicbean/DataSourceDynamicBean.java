package test.dynamicbean;

/**
 * 继承自DynamicBean，一个数据源的简单bean配置描述对象
 *
 * @author chuanshi - 2018-12-09 19:30
 */
public class DataSourceDynamicBean extends DynamicBean {
    private String driverClassName;

    private String url;

    private String username;

    private String password;

    public DataSourceDynamicBean(String beanName) {
        super(beanName);
    }

    @Override
    protected String getBeanXml() {
        StringBuffer xmlBuf = new StringBuffer();
        xmlBuf.append("<bean id=\"" + beanName + "\" class=\"org.apache.commons.dbcp2.BasicDataSource\" destroy-method=\"close\"")
                .append(" p:driverClassName=\"" + driverClassName + "\" ")
                .append(" p:url=\"" + url + "\"")
                .append(" p:username=\"" + username + "\"")
                .append(" p:password=\"" + password + "\"/>");
        return xmlBuf.toString();
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
