package com.yichen.logstudy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author Qiuxinchao
 * @date 2022/11/17 9:19
 * @describe MDC ThreadContext 测试
 */
public class ThreadContextTest {

    /**
     * slf4j
     */
//    private static Logger log = LoggerFactory.getLogger(ThreadContextTest.class);

    /**
     * log4j2
     */
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        threadContextTest();
        System.out.println("=====================================================分割线======================================================");
        mdcTest();
        System.out.println("=====================================================分割线======================================================");
    }

    /**
     * 测试打印日志
     */
    private static void threadContextTest(){
        ThreadContext.push(UUID.randomUUID().toString());
        log.debug("Message 1");
        log.debug("Message 2");
        ThreadContext.pop();
    }

    /**
     * MDC打印日志
     */
    private static void mdcTest(){
        MDC.put("uuid", UUID.randomUUID().toString());
        log.debug("Message 1");
        log.debug("Message 2");
        MDC.clear();
    }


}
