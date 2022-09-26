package com.mengjq.assignmentsubmission_spring.util;

import lombok.Getter;

/**
 * return result status information class uniformly
 *
 */
@Getter
public enum ResultCodeEnum {

//    SUCCESS(200,"成功"),
//    FAIL(201, "失败"),
//    SERVICE_ERROR(2012, "服务异常"),
//    ILLEGAL_REQUEST( 204, "非法请求"),
//    PAY_RUN(205, "支付中"),
//    ARGUMENT_VALID_ERROR(206, "参数校验错误"),
//
//    LOGIN_ERROR(207, "用户名或密码错误"),
//    LOGIN_AUTH(208, "未登陆"),
//    PERMISSION(209, "没有权限"),
//    SECKILL_NO_START(210, "秒杀还没开始"),
//    SECKILL_RUN(211, "正在排队中"),
//    SECKILL_NO_PAY_ORDER(212, "您有未支付的订单"),
//    SECKILL_FINISH(213, "已售罄"),
//    SECKILL_END(214, "秒杀已结束"),
//    SECKILL_SUCCESS(215, "抢单成功"),
//    SECKILL_FAIL(216, "抢单失败"),
//    SECKILL_ILLEGAL(217, "请求不合法"),
//    SECKILL_ORDER_SUCCESS(218, "下单成功"),
//    COUPON_GET(220, "优惠券已经领取"),
//    COUPON_LIMIT_GET(221, "优惠券已发放完毕"),
//    //2022-02-22
//    LOGIN_CODE(222,"长时间未操作,会话已失效,请刷新页面后重试!"),
//    CODE_ERROR(223,"验证码错误!"),
//    TOKEN_ERROR(224,"Token无效!")
//    ;

    SUCCESS(200,"Success"),
    FAIL(201, "Failed"),
    SERVICE_ERROR(2012, "Service Exceptions"),
    ILLEGAL_REQUEST( 204, "Illegal Request"),
    PAY_RUN(205, "Paying"),
    ARGUMENT_VALID_ERROR(206, "Parameter Verify Error"),
    LOGIN_ERROR(207, "userName or Password was incorrect."),
    LOGIN_AUTH(208, "not Log in"),
    PERMISSION(209, "No Permit access"),

    SECKILL_NO_START(210, "Seckill has not yet begun."),
    SECKILL_RUN(211, "Be queuing"),
    SECKILL_NO_PAY_ORDER(212, "You have unpaied order."),
    SECKILL_FINISH(213, "Seckill merchandise Has been sell out."),
    SECKILL_END(214, "Seckill has been finish"),
    SECKILL_SUCCESS(215, "Seckill has been success"),
    SECKILL_FAIL(216, "Seckill has been failed"),
    SECKILL_ILLEGAL(217, "the request is invalid"),
    SECKILL_ORDER_SUCCESS(218, "checkout success"),
    COUPON_GET(220, "Coupons have been claimed"),
    COUPON_LIMIT_GET(221, "Coupons have been distributed out"),

    //2022-02-22
    LOGIN_CODE(222,"no operation for a long time, the session is invalid,please refresh page and retry!"),
    CODE_ERROR(223,"verification code invalid!"),
    TOKEN_ERROR(224,"Token invaild!")
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
