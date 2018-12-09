package test.dynamicbean;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chuanshi - 2018-12-09 19:48
 */
@ContextConfiguration(locations = {"classpath:dynamicbean.xml"})
public class DynamicBeanReaderTests extends AbstractJUnit4SpringContextTests {
    @Autowired
    private DynamicBeanReader dynamicBeanReader;

    @Test
    public void testLoadBean() {
        DataSourceDynamicBean dataSourceDynamicBean = new DataSourceDynamicBean("dataSource1");
        dataSourceDynamicBean.setDriverClassName("org.gjt.mm.mysql.Driver");
        dataSourceDynamicBean.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8");
        dataSourceDynamicBean.setUsername("pdd");
        dataSourceDynamicBean.setPassword("pdd");

        dynamicBeanReader.loadBean(dataSourceDynamicBean);

        DataSource s = (DataSource) applicationContext.getBean("dataSource1");
        try {
            PreparedStatement ps = s.getConnection().prepareStatement("select '数据库输出的数据' a from dual");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("a"));
            }
        } catch (SQLException e) {
            //TODO
        }
    }
}
