package test.protostuff;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列化/反序列化例子
 */
public class ProtostuffTest {

    private long userTime;

    public static void main(String[] args) {
        ProtostuffTest protostuffTest = new ProtostuffTest();
        List<Products> productsList = new ArrayList<Products>();
        Products p1 = new Products();
        p1.setS1("Joshua");
        p1.setB1(true);
        Products p2 = new Products();
        p2.setS1("Hello");
        p2.setB1(false);
        productsList.add(p1);
        productsList.add(p2);

        // 序列化
        List<byte[]> serProducts = protostuffTest.serializeProtoStuffProductsList(productsList);
        System.out.println(serProducts.toString());
        System.out.println(protostuffTest.userTime);

        // 反序列化
        List<Products> unserProducts = new ArrayList<Products>();
        unserProducts = protostuffTest.deserializeProtoStuffDataListToProductsList(serProducts);
        for (Products products : unserProducts) {
            System.out.println(products.toString());
        }
        System.out.println(protostuffTest.userTime);
    }

    /**
     * 序列化对象
     *
     * @param pList
     * @return
     */
    public List<byte[]> serializeProtoStuffProductsList(List<Products> pList) {
        if (pList == null || pList.size() <= 0) {
            return null;
        }

        long start = System.currentTimeMillis();
        List<byte[]> bytes = new ArrayList<byte[]>();
        Schema<Products> schema = RuntimeSchema.getSchema(Products.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(4096);
        byte[] protostuff = null;
        for (Products p : pList) {
            try {
                protostuff = ProtostuffIOUtil.toByteArray(p, schema, buffer);
                bytes.add(protostuff);
            } finally {
                buffer.clear();
            }
        }
        long end = System.currentTimeMillis();
        this.userTime = end - start;
        return bytes;
    }

    public List<Products> deserializeProtoStuffDataListToProductsList(List<byte[]> bytesList) {
        if (bytesList == null || bytesList.size() <= 0) {
            return null;
        }

        long start = System.currentTimeMillis();
        Schema<Products> schema = RuntimeSchema.getSchema(Products.class);
        List<Products> list = new ArrayList<Products>();
        for (byte[] bs : bytesList) {
            Products product = new Products();
            ProtostuffIOUtil.mergeFrom(bs, product, schema);
            list.add(product);
        }
        long end = System.currentTimeMillis();
        this.userTime = end - start;
        return list;
    }
}
