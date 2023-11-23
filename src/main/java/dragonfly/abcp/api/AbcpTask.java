package dragonfly.abcp.api;

//////////////////////////////////////////////////////////////////////
// for chinese. please refer to doc '...\docs\abcp.txt'
// Step 1: [client SDK] abcp_init. { load data, load camara, prepare service, ... }
// Step 2: [client SDK] abcp_get_meta_info. { fetch hardware information for biz }
// Step 3: [server SDK] init zimId for smile.
// Step 4: [client SDK] use zimId to smile, confirm who you are.
// Step 5: [server SDK] use smile result, to pay via alipay service
//////////////////////////////////////////////////////////////////////
// for setp 3, You need confirm which server API to use for your real sence
// smile for pay : https://opendocs.alipay.com/pre-open/20180402104715814204
// smile for pay : ZolozAuthenticationCustomerSmilepayInitializeRequest
// smile only : https://opendocs.alipay.com/pre-open/20171214171953173616/flivcu
// smile only : ZolozAuthenticationCustomerSmileliveInitializeRequest
//////////////////////////////////////////////////////////////////////

public interface AbcpTask {
  public void start(String serviceParam, IDragonFlyCallBack callBack);

  public void stop(String serviceParam, IDragonFlyCallBack callBack);
}