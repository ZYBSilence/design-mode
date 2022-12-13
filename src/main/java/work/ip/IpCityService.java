package work.ip;

/**
 * @description: ip地址获取服务类
 * @author: zyb
 * @date: 2022/12/13 10:59
 */
public interface IpCityService {
    /**
     * 获取ip所属地
     * @param ip IP地址
     * @return ip所属地
     */
    String getIpAddress(String ip);
}
