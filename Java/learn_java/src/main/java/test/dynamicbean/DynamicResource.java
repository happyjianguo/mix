package test.dynamicbean;

import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * org.springframework.core.io.Resource的实现类
 *
 * @author chuanshi - 2018-12-09 19:30
 */
public class DynamicResource implements Resource {
    private DynamicBean dynamicBean;

    public DynamicResource(DynamicBean dynamicBean) {
        this.dynamicBean = dynamicBean;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(dynamicBean.getXml().getBytes("UTF-8"));
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean isReadable() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public URL getURL() throws IOException {
        return null;
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return 0;
    }

    @Override
    public Resource createRelative(String s) throws IOException {
        return null;
    }

    @Override
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
