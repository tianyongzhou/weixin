package com.tyz.weixin.model.event;

/**
 * @Version 1.0
 * @Author: tyz
 * @Description: 群发结果事件推送
 * @Date: 2017/12/26.
 * @Modified: tyz
 */
public class MassSendEndJobFinishEvent extends Event{
    private long MsgID; //	群发的消息ID
    /**
     * 群发的结构，为“send success”或“send fail”或“err(num)”。但send success时，也有可能因用户拒收公众号的消息、
     * 系统错误等原因造成少量用户接收失败。err(num)是审核失败的具体原因，可能的情况如下： err(10001), //涉嫌广告 err(20001),
     * //涉嫌政治 err(20004), //涉嫌社会 err(20002), //涉嫌色情 err(20006), //涉嫌违法犯罪 err(20008), //涉嫌欺诈 err(20013),
     * //涉嫌版权 err(22000), //涉嫌互推(互相宣传) err(21000), //涉嫌其他 err(30001)
     * // 原创校验出现系统错误且用户选择了被判为转载就不群发 err(30002) // 原创校验被判定为不能群发 err(30003)
     * // 原创校验被判定为转载文且用户选择了被判为转载就不群发
     */
    private String Status;
    private long TotalCount; //tag_id下粉丝数；或者openid_list中的粉丝数
    private long FilterCount; //过滤（过滤是指特定地区、性别的过滤、用户设置拒收的过滤，用户接收已超4条的过滤）后，准备发送的粉丝数，原则上，FilterCount = SentCount + ErrorCount
    private long SentCount; //发送成功的粉丝数
    private long ErrorCount; //	发送失败的粉丝数

    public long getMsgID() {
        return MsgID;
    }

    public void setMsgID(long msgID) {
        MsgID = msgID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public long getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(long totalCount) {
        TotalCount = totalCount;
    }

    public long getFilterCount() {
        return FilterCount;
    }

    public void setFilterCount(long filterCount) {
        FilterCount = filterCount;
    }

    public long getSentCount() {
        return SentCount;
    }

    public void setSentCount(long sentCount) {
        SentCount = sentCount;
    }

    public long getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(long errorCount) {
        ErrorCount = errorCount;
    }
}
