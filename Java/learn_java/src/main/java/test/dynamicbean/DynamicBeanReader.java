package test.dynamicbean;

/**
 * bean动态加载接口
 *
 * @author chuanshi - 2018-12-09 19:30
 */
public interface DynamicBeanReader {

    /**
     * 动态加载bean
     *
     * @param dynamicBean
     */
    public void loadBean(DynamicBean dynamicBean);
}
