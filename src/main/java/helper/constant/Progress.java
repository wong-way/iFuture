package helper.constant;

/**
 * Created by DELL on 2017-09-12.
 */
public class Progress {
    //订单进度
    public final static int ORDER_SUBMITED = 1;
    public final static int ORDER_AUDITING = 2;
    public final static int ORDER_TO_BE_PAY = 3;
    public final static int ORDER_PROCESSING = 4;
    public final static int ORDER_COMPLETED = 5;
    public final static int ORDER_CANCELLED = 6;
    public final static int ORDER_APPLY_REFUND = 7;
    public final static int ORDER_REFUND_PROCESSING = 8;
    public final static int ORDER_REFUND_SUCCESS = 9;
    //理赔进度
    public final static int CLAIM_SUBMITED=1;
    public final static int CLAIM_AUDITING=2;
    public final static int CLAIM_AUDITING_SUCCESS=3;
    public final static int CLAIM_AUDITING_FAIL=4;
    public final static int CLAIM_PROCESSING=5;
    public final static int CLAIM_SUCCESS=6;

    //管理员类型
    public final static int REGISTER_DATA_AUDIT=1;
    public final static int ORDER_DATA_AUDIT=2;
    public final static int CLAIM_DATA_AUDIT=3;
    public final static int CLAIM_STATUS_UPDATE=4;
    public final static int ORDER_STATUS_UPDATE=5;

    //产品类型
    public final static int POSTGRADUATE_RECOMMENDATION=1;
    public final static int POSTGRADUATE_EXAMINATION=2 ;
    public final static int OBTAIN_EMPLOYMENT=3;



}
