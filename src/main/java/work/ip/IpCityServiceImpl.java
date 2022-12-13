package work.ip;

import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description: ip地址获取服务类
 * @author: zyb
 * @date: 2022/12/13 10:58
 */
@Service
public class IpCityServiceImpl implements IpCityService {
    private Searcher searcher;

    @Override
    public String getIpAddress(String ip) {
        if ("127.0.0.1".equals(ip) || ip.startsWith("192.168")) {
            return "局域网 ip";
        }
        if (searcher == null) {
            try {
                File file = ResourceUtils.getFile("classpath:ipdb/ip2region.xdb");
                String dbPath = file.getPath();
                searcher = Searcher.newWithFileOnly(dbPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String region = null;
        String errorMessage = null;
        try {
            region = searcher.search(ip);
        } catch (Exception e) {
            errorMessage = e.getMessage();
            if (errorMessage != null && errorMessage.length() > 256) {
                errorMessage = errorMessage.substring(0, 256);
            }
            e.printStackTrace();
        }
        return region;
    }


}
