package com.leopard.springcloud.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
public class XxlJobConfig {
    private Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);

    /**
     * 调度中心地址
     */
    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;

    /**
     * 调度中心认证token
     */
    @Value("${xxl.job.accessToken}")
    private String accessToken;

    /**
     * 执行器名字
     */
    @Value("${xxl.job.executor.appname}")
    private String appname;

    /**
     * 执行器地址
     */
//    @Value("${xxl.job.executor.address}")
//    private String address;

    /**
     * 执行器ip，默认本机
     */
    @Value("${xxl.job.executor.ip}")
    private String ip;

    /**
     * 执行器端口
     */
    @Value("${xxl.job.executor.port}")
    private int port;

    /**
     * 跑批日志路径
     */
    @Value("${xxl.job.executor.logpath}")
    private String logPath;

    /**
     * 跑批日志保留天数
     */
    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;


    /**
     * 配置初始化
     * @return
     * @author leo-zu 2020-10-28 21:29
     */
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
//        xxlJobSpringExecutor.setAddress(address);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);

        return xxlJobSpringExecutor;
    }

    /**
     * 针对多网卡、容器内部署等情况，可借助 "spring-cloud-commons" 提供的 "InetUtils" 组件灵活定制注册IP；
     *
     *      1、引入依赖：
     *          <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-commons</artifactId>
     *             <version>${version}</version>
     *         </dependency>
     *
     *      2、配置文件，或者容器启动变量
     *          spring.cloud.inetutils.preferred-networks: 'xxx.xxx.xxx.'
     *
     *      3、获取IP
     *          String ip_ = inetUtils.findFirstNonLoopbackHostInfo().getIpAddress();
     */


}