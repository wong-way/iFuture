package helper.constant;

/**
 * Created by DELL on 2017-08-15.
 */

public class Constant {
   //登录常量
   public final static int WRONG_PASSWORD=1;

   public final static int LOGIN_SUCCESS=0;
   //用户常量
   public final static int USER_NOT_EXIST=-1;

   public final static int USER_REGISTER_FAILED=1;
   public final static int USER_REGISTER_SUCCESS=0;
   public final static int USER_REGISTERED_REPEAT=2;
   //产品常量
   public final static int GET_PRODUCT_SUCCESS=0;
   public final static int GET_PRODUCT_FAIL=1;

   public final static int PRODUCT_NOT_EXIST=-1;
   //管理员常量
   public final static int ADMIN_NOT_EXIST=-1;
   public final static int ADMIN_REGISTER_FAILED=1;
   public final static int ADMIN_REGISTER_SUCCESS=0;
   public final static int ADMIN_REGISTERED_REPEAT=2;

   //学历常量
   public final static int ROLL_INSERT_SUCCESS=0;
   public final static int ROLL_INSERT_ERROR=1;
   public final static int ROLL_UPDATE_SUCCESS=0;
   public final static int ROLL_UPDATE_ERROR = 1;
   public final static int ROLL_DELETE_SUCCESS=0;
   public final static int ROLL_DELETE_ERROR =1;
   public final static int ROLL_GET_SUCCESS=0;
   public final static int ROLL_GET_ERROR=1;

   public final static int ROOL_NOT_EXIST=-1;
   public final static int ROLL_NOT_PASS=1;

   public final static int UNPASSROLL_NOT_EXSIT=-1;
   public final static int UNPASSROLL_QUERY_ERROR=1;
   public final static int UNPASSROLL_QUERY_SUCCESS=0;

   //信用分数常量
   public final static int RECORD_INSERT_SUCCESS=0;
   public final static int RECORD_INSERT_ERROR=1;
   public final static int RECORD_DELETE_SUCCESS=0;
   public final static int RECORD_DELETE_ERROR=1;
   public final static int RECORD_GET_SUCCESS=0;
   public final static int RECORD_GET_ERROR=1;

   //订单常量
   public final static int TMPORDER_INSERT_SUCCESS = 0;
   public final static int TMPORDER_INSERT_ERROR =1;
   public final static int TMPORDER_UPDATE_SUCCESS = 0;
   public final static int TMPORDER_UPDATE_ERROR =1;
   public final static int TMPORDER_DELETE_SUCCESS =0;
   public final static int TMPORDER_DELETE_ERROR =1;
   public final static int TMPORDER_GET_SUCCESS=0;
   public final static int TMPORDER_GET_ERROR=1;

   public final static int UNPAYTMPORDER_NOT_EXSIT=-1;
   public final static int UNPAYTMPORDER_QUERY_ERROR=1;
   public final static int UNPAYTMPORDER_QUERY_SUCCESS=0;

   public final static int VLDORDER_INSERT_SUCCESS=0;
   public final static int VLDORDER_INSERT_ERROR=1;
   public final static int VLDORDER_DELETE_SUCCESS=0;
   public final static int VLDORDER_DELETE_ERROR=1;
   public final static int VLDORDER_UPDATE_SUCCESS = 0;
   public final static int VLDORDER_UPDATE_ERROR=1;
   public final static int MONEY_NOT_PAYED =2;
   public final static int VLDORDER_GET_SUCCESS=0;
   public final static int VLDORDER_GET_ERROR=1;

   public final static int ORDER_NOT_EXIST=-1;

   //token
   public final static int TOKEN_NOT_EXIST=-1;
   public final static int TOKEN_NOT_MATCHED=1;
   public final static int TOKEN_EXPIRED_ERROR=2;

   //file
   public final static int FILE_UP_ERROR=2;
   public final static int FILE_TYPE_ERROR=1;
   public final static int FILE_UP_SUCCESS=0;
   public final static int FILE_DOWN_ERROR=2;
   public final static int FILE_NOT_FOUND=1;
   public final static int FILE_DOWN_SUCCESS=0;

}
