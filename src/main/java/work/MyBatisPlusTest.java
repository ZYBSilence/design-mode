package work;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @description:
 * @author: zyb
 * @date: 2021/10/22 13:22
 */
public class MyBatisPlusTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:lo:3306/test", "root", "root")
                .globalConfig(builder -> {
                    builder.author("zyb") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\idea_project\\design-mode\\src\\main\\java\\work\\entity"); // 指定输出目录
                })
//                .packageConfig(builder -> {
//                    builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
//                })
                .strategyConfig(builder -> {
                    builder.addInclude("datatable20200101"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
