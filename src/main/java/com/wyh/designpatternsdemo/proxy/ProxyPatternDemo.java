package com.wyh.designpatternsdemo.proxy;

/**
 * 代理模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/12 8:58 上午
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        MyLogger myLogger = new MyLogger();
        Proxy proxy = new Proxy(myLogger);
        proxy.log();
    }


    public interface Log{
        void log();
    }

    public static class MyLogger implements Log {
        @Override
        public void log() {
            System.out.println("打印日志");
        }
    }


    public static class Proxy implements Log {

        private Log log;

        public Proxy(Log log){
            this.log = log;
        }

        @Override
        public void log() {
            System.out.println("打印日志前置处理");
            log.log();
            System.out.println("打印日志后置处理");
        }
    }
}
