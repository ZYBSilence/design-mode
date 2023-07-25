package work;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @description:
 * @author: zyb
 * @date: 2023/7/20 14:53
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        // 创建布隆过滤器，预计插入 1000 个元素，误判率为 0.01
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.01);

        // 添加元素
        bloomFilter.put("hello");
        bloomFilter.put("world");

        // 判断元素是否存在
        System.out.println(bloomFilter.mightContain("hello"));
        System.out.println(bloomFilter.mightContain("world"));
        System.out.println(bloomFilter.mightContain("java"));
    }
}
