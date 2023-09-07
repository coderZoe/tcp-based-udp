package com.coderzoe.tcpbasedudp.tcp;

import lombok.Data;

/**
 * TCP数据报文头
 * @author yinhuasheng
 * @email yinhuasheng@unicloud.com
 * @date 2023/9/7 16:14
 */
@Data
public class TcpSegmentHeader {
    /**
     * 源端口  用于传输层的多路复用和多路分解
     */
    private short srcPort;
    /**
     * 目的端口  用于传输层的多路复用和多路分解
     */
    private short dstPort;
    /**
     * 序列号  用于实现流水线发送和重发
     */
    private int sequence;
    /**
     * ACK号  用于实现流水线发送和重发
     */
    private int ack;
    /**
     * 1. 首部长度 4 bit  TCP头部包含option字段 因此TCP头部是不定长的，首部长度是以32bit为单位来标识TCP首部长度的  因此最大头部长度 = 2^4 * 32 bit
     * 2. 保留 6 bit
     * 3. URG ACK PSH RST SYN FIN 状态标志字段
     *    ACK用于表示这是一个响应，上面的ack数据是有效的
     *    RST SYN和FIN用于TCP的连接和删除
     *
     */
    private byte[] headerAndSyncAck = new byte[2];
    /**
     * 窗口大小  用于TCP的流量控制
     */
    private short windowSize;
    /**
     * 校验位  避免比特传输出错
     */
    private short checksum;
    /**
     * 紧急指针
     */
    private short urgentPointer;
    /**
     * 可选字段
     */
    private byte[] option;
}
