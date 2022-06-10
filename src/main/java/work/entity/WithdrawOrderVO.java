package work.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * @description: 提现订单相关VO
 * @author: zyb
 * @date: 2022/4/20 10:48
 */
@Data
public class WithdrawOrderVO {
    /**
     * 系统订单号
     */
    @JSONField(name = "withdrawal_id")
    private String withdrawalId;
    /**
     * 平台订单号
     */
    @JSONField(name = "out_order_no")
    private String outOrderNo;
    /**
     * 交易状态
     */
    private String status;
    /**
     * 原因描述
     */
    private String reason;
    /**
     * 创建时间
     */
    @JSONField(name = "created_at")
    private String createdAt;
    /**
     * 完成时间
     */
    @JSONField(name = "finished_at")
    private String finishedAt;
    /**
     * 金额
     */
    private Integer amount;
    /**
     * 平台手续费
     */
    @JSONField(name = "service_fee")
    private Integer serviceFee;
    /**
     * 业务类型
     */
    @JSONField(name = "business_type")
    private String businessType;
    /**
     * 电子账簿 ID
     */
    @JSONField(name = "balance_acct_id")
    private String balanceAcctId;
    /**
     * 银行附言
     */
    @JSONField(name = "bank_memo")
    private String bankMemo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 扩展字段
     */
    private Map<String, Object> extra;
    /**
     * 自定义参数
     */
    private Map<String, Object> metadata;
}
