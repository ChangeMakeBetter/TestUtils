package file;

public class Step2PanelSettings {

  private int maxHoldCount = 0;
  private int initialRecords = 1;
  private int rowHeight = 32;
  private int lineNoWidth = 32;
  private int inputCodeNameWidth = 250;
  private int priceUnitWidth = 100;
  private int quantityWidth = 0;
  private int discountWidth = 55;
  private int amountWidth = 0;

  private String inputCodePattern = ".*";
  private String pricePattern = "^\\d{1,5}(\\.\\d{1,2})?$";
  private String quantityPattern = "^\\d{1,5}(\\.\\d{1,3})?$";
  private String amountPattern = "^\\d{1,5}(\\.\\d{1,2})?$";
  private String discountPattern = "^\\d{1,3}(\\.\\d{1,2})?$";
  /**
   * 当Goods.isWeightUnit()==false时使用这个表达式检验输入的数量
   */
  private String pcsQuantityPattern = "^\\d{1,5}$";
  /**
   * 是否启用pcsQuantityPattern
   */
  private boolean enablePcsQuantity = false;

  private String priorView = "retail.step1Panel";
  private String nextView = "retail.step3Panel";
  /**
   * 促销附赠界面，JPOS-2469
   */
  private String giftView = "retail.giftsPanel";

  /**
   * 如果值为message:retail.step2Panel.table.quantity_unit的值, 则输入码后停到数量
   */
  private String nextStopToInputCode = "";

  private boolean hasRetailHelper = true;
  private int retailHelperHeight = 80;
  /**
   * 销售助手内容分隔符
   */
  private String retailHelperSeparator = "\\n";

  /**
   * 是否显示输入码
   */
  private boolean showingInputCode = false;

  private boolean useProductHelper = true;
  private boolean useProductHelperOnlyWhenNotExist = true;

  private boolean hasScaleDisplay = false;

  private boolean showingAssistant = false;

  /**
   * 是否使用营业员行
   */
  private boolean showLineAssistant = false;

  /**
   * 营业员行.默认营业员code
   */
  private String lineAssistantCode;

  /**
   * 商品行营业员默认使用已录营业员
   */
  private boolean autoSetAssistant = true;

  private boolean mustGetWeigth = false;

  private boolean showInvalidInputPromptBox = false;

  private boolean autoMergeSameProduct = false;

  /**
   * 自动合并相同时提示栏显示时间(毫秒)
   */
  private int autoMergeSameProductTipTime = 2000;

  private int creditCount = 0;

  private boolean canChangeMember = false;

  private boolean canHandInputMemberCode = true;

  private boolean showRtlPrc = false;

  private boolean showFavAmount = false;

  /**
   * 是否显示条码
   */
  private boolean showBarCode = false;

  /**
   * 是否使用手工单品折扣功能
   */
  private boolean useManualDiscount = true;

  /**
   * 展示折扣率（【单价】与【原价】的比率）
   */
  private boolean showDiscountRate = false;

  private boolean canImportPrizeGoods = false;

  /**
   * 打开钱箱,是否必须经办人登录
   */
  private boolean openCashdrawMustLogin = false;

  /**
   * 是否可导入赠品
   */
  private boolean useInputGifts = false;

  /**
   * 是否使用选择面板
   */
  private boolean hasProductSelect = false;

  /**
   * 能否使用输入法
   */
  private boolean enableInputMethods = false;

  private boolean canInitAssistant = false;

  /**
   * 收银员对话框类型:0=默认(查询模式,输入代码查询确认);1=无查询,一次性列出所有收银员,选择模式;2=查询选择模式,以(员工代码或名称）,进行模糊查询并能进行选择
   */
  private int assistantDialogType = 0;

  /**
   * 可变价,输入含金额或数量条码,光标是否定位到新行
   */
  private boolean priceVariableAndNotNormalLineSwitchToNextLine = false;

  /**
   * 空白行显示营业员
   */
  private boolean blankLineShowAssistant = false;

  /**
   * 查询,使用多选导入模式
   */
  private boolean useQueryProductMultiImportMode = false;

  /**
   * 计重,是否新增自动读取设置重量
   */
  private boolean autoSetWeightQty = false;

  private boolean useUnPromFunction = false;

  /**
   * 是否显示细类
   */
  private boolean showSort = false;

  private boolean showProductPicture = false;

  /**
   * 是否显示详细的会员信息
   */
  private boolean showMemberSummary = false;

  private boolean canHandinProductCode = true;
  private boolean useMemberRegister = false;

  private boolean showProgressDialog = true;

  private boolean memberTitleShowVoucherCode = false;

  /**
   * 是否显示上笔销售
   */
  private boolean showLastOrder = false;

  /**
   * 挂账交易的有效时间
   */
  private int maxHoldHour = 0;

  /**
   * 是否自动触发促销码界面
   */
  private boolean autoShowPromotionCouponUi = true;

  private boolean showInvQty = false;

  /**
   * 销售单存在在线付款方式(已付),不能退出界面.
   */
  private boolean checkHasOnlinePayment = false;
  /**
   * 是否显示，鼎力云券，销售帮助信息
   */
  private boolean showUpowerVoucherHelper = false;

  /**
   * 是否启用限时销售
   */
  private boolean enableGoodsSaleLimit = false;

  /**
   * 限时类别代码
   */
  private String limitedSortCode;

  /**
   * 限时商品时间 示例：14:30-17:30,19:00-24:00,
   */
  private String limitedTime;

  /**
   * 是否启用商品类别互斥
   */
  private boolean enableGoodsSortCodeLimit = false;
  /**
   * 商品类别互斥代码,以(;)分隔
   */
  private String limitedGoodsSort = "";

  /**
   * 是否启用客群信息收集
   */
  private boolean enableCollectCustomerGroups = false;

  /**
   * 单笔销售金额控制,单位元, 0不控制
   */
  private int saleAmountLimit = 0;

  /**
   * 展示会员基本信息面板
   */
  private boolean showFaceMemberInfoPanel = false;

  /**
   * 展示会员消费喜好分析面板
   */
  private boolean showFaceMemberPreferenceAnalysisPanel = false;

  private boolean showTokenPrc = false;

  /**
   * 检查主商品单价是否为0
   */
  private boolean checkGoodsPrice = false;

  // [是否控制]负库存不能销售。不是[允许负库存能销售]
  private boolean allowNegativeInvQty = false;

  /**
   * 挂账时是否使用备注
   */
  private boolean useHoldMemo = false;

  /**
   * 销售(非券交易)原始金额可以为零
   */
  private boolean saleAmountZeroCheck = true;

  /**
   * 是否使用隐藏或显示商品选择面板按键
   */
  private boolean useShowOrHideProductSelect = false;

  /**
   * 修改商品数据后光标定位到新行
   */
  private boolean modifyDataToNewLine = false;
  /**
   * 展示会员提示信息
   */
  private boolean showMemberPromptMsg = false;

  /**
   * 展示会员备注信息|JPOS-31326
   */
  private boolean showMemberRemark = true;

  /**
   * 按读秤时光标在末行则将重量读给上一行称重商品|JPOS-19049
   */
  private boolean useGetWeightToLastLine = false;

  /**
   * 高亮展示商品名称品牌代码(;分隔)
   */
  private String highlightProductBrandCodes = "";

  /**
   * 进入销售时允许存在皮重
   */
  private boolean allowTareWeight = true;

  /**
   * 进入销售时校验电子秤净重|JPOS-31021
   */
  private boolean checkScaleNetWeight = false;

  /**
   * 显示环保金
   */
  private boolean showEnvironmentalTax = false;

  /**
   * 显示环保金汇总
   */
  private boolean showTotalEnvironmentalTax = false;

  /**
   * 外送订单标题提示
   */
  private String outboundOrderTitleHint = "外送订单(不积分不发券)";

  /**
   * 合并所有列展示商品代码名称规格
   */
  private boolean showCodeNameWithAllColumn = false;

  /**
   * 标题栏行信息面板左对齐
   */
  private boolean titleLineDisplayPanelLeftAlign = false;

  /**
   * 标题栏上笔销售提示信息
   */
  private String titleLastOrderHint = "";

  /**
   * 挂账操作需要弹框确认
   */
  private boolean useHoldTip = true;

  /**
   * 生鲜条码控制件数取实际件数
   */
  private boolean useSkuCount = false;

  /**
   * 会员生日提醒信息
   */
  private String memberBirthInfo = "";

  /**
   * 使用标签字段
   */
  private boolean useCautionLabel = false;

  /**
   * 启用商品手工折扣原因
   */
  private boolean useStoreDiscountReason = false;

  /**
   * 启用流水号加密显示
   */
  private boolean enableFlowNoEncrypt = false;

  /**
   * 启用ERP商品快捷键
   */
  private boolean useErpGdShortcutKey = false;

  /**
   * 经办人登录设置使用卡模式
   */
  private boolean useLoginByCardPattern = false;
  /**
   * 使用权限控制重打小票
   */
  private boolean usePrintPermissionControl = false;
  /**
   * 客户自提发货提货码前缀
   */
  private String distributeOrderSelfTakeCodePrefix = "";

  /**
   * 商品负库存校验
   */
  private boolean goodsNegateInvCheck = false;

  /**
   * 展示营业员
   */
  private boolean showCashier = false;

  /**
   * 单头营业员必填
   */
  private boolean orderAssistantCheck = false;
  /**
   * 校验挂账权限
   */
  private boolean needCheckHoldTranPermission = false;

  public boolean getShowTokenPrc() {
    return showTokenPrc;
  }

  public void setShowTokenPrc(boolean showTokenPrc) {
    this.showTokenPrc = showTokenPrc;
  }

  public boolean getEnableCollectCustomerGroups() {
    return enableCollectCustomerGroups;
  }

  public void setEnableCollectCustomerGroups(boolean enableCollectCustomerGroups) {
    this.enableCollectCustomerGroups = enableCollectCustomerGroups;
  }

  public boolean getEnableGoodsSaleLimit() {
    return enableGoodsSaleLimit;
  }

  public void setEnableGoodsSaleLimit(boolean enableGoodsSaleLimit) {
    this.enableGoodsSaleLimit = enableGoodsSaleLimit;
  }

  public String getLimitedSortCode() {
    return limitedSortCode;
  }

  public void setLimitedSortCode(String limitedSortCode) {
    this.limitedSortCode = limitedSortCode;
  }

  public String getLimitedTime() {
    return limitedTime;
  }

  public void setLimitedTime(String limitedTime) {
    this.limitedTime = limitedTime;
  }

  public boolean enableLimitSale() {
    return !(!getEnableGoodsSaleLimit() || limitedSortCode == null || limitedSortCode.isEmpty() || limitedTime == null
      || limitedTime.isEmpty());
  }

  public boolean getShowLastOrder() {
    return showLastOrder;
  }

  public void setShowLastOrder(boolean showLastOrder) {
    this.showLastOrder = showLastOrder;
  }

  public boolean getMemberTitleShowVoucherCode() {
    return memberTitleShowVoucherCode;
  }

  public void setMemberTitleShowVoucherCode(boolean memberTitleShowVoucherCode) {
    this.memberTitleShowVoucherCode = memberTitleShowVoucherCode;
  }

  public boolean getCanHandinProductCode() {
    return canHandinProductCode;
  }

  public void setCanHandinProductCode(boolean canHandinProductCode) {
    this.canHandinProductCode = canHandinProductCode;
  }

  public boolean getShowMemberSummary() {
    return showMemberSummary;
  }

  public void setShowMemberSummary(boolean showMemberSummary) {
    this.showMemberSummary = showMemberSummary;
  }

  public boolean getShowProductPicture() {
    return showProductPicture;
  }

  public void setShowProductPicture(boolean showProductPicture) {
    this.showProductPicture = showProductPicture;
  }

  public boolean getCanHandInputMemberCode() {
    return canHandInputMemberCode;
  }

  public void setCanHandInputMemberCode(boolean canHandInputMemberCode) {
    this.canHandInputMemberCode = canHandInputMemberCode;
  }

  public boolean getShowSort() {
    return showSort;
  }

  public void setShowSort(boolean showSort) {
    this.showSort = showSort;
  }

  public boolean getUseUnPromFunction() {
    return useUnPromFunction;
  }

  public void setUseUnPromFunction(boolean useUnPromFunction) {
    this.useUnPromFunction = useUnPromFunction;
  }

  public boolean getAutoSetWeightQty() {
    return autoSetWeightQty;
  }

  public void setAutoSetWeightQty(boolean autoSetWeightQty) {
    this.autoSetWeightQty = autoSetWeightQty;
  }

  public boolean getUseQueryProductMultiImportMode() {
    return useQueryProductMultiImportMode;
  }

  public void setUseQueryProductMultiImportMode(boolean useQueryProductMultiImportMode) {
    this.useQueryProductMultiImportMode = useQueryProductMultiImportMode;
  }

  public boolean getBlankLineShowAssistant() {
    return blankLineShowAssistant;
  }

  public void setBlankLineShowAssistant(boolean blankLineShowAssistant) {
    this.blankLineShowAssistant = blankLineShowAssistant;
  }

  public boolean getPriceVariableAndNotNormalLineSwitchToNextLine() {
    return priceVariableAndNotNormalLineSwitchToNextLine;
  }

  public void setPriceVariableAndNotNormalLineSwitchToNextLine(boolean priceVariableAndNotNormalLineSwitchToNextLine) {
    this.priceVariableAndNotNormalLineSwitchToNextLine = priceVariableAndNotNormalLineSwitchToNextLine;
  }

  public boolean getEnableInputMethods() {
    return enableInputMethods;
  }

  public void setEnableInputMethods(boolean enableInputMethods) {
    this.enableInputMethods = enableInputMethods;
  }

  public boolean getHasProductSelect() {
    return hasProductSelect;
  }

  public void setHasProductSelect(boolean hasProductSelect) {
    this.hasProductSelect = hasProductSelect;
  }

  public boolean getUseInputGifts() {
    return useInputGifts;
  }

  public void setUseInputGifts(boolean useInputGifts) {
    this.useInputGifts = useInputGifts;
  }

  public boolean getOpenCashdrawMustLogin() {
    return openCashdrawMustLogin;
  }

  public void setOpenCashdrawMustLogin(boolean openCashdrawMustLogin) {
    this.openCashdrawMustLogin = openCashdrawMustLogin;
  }

  public boolean getCanImportPrizeGoods() {
    return canImportPrizeGoods;
  }

  public void setCanImportPrizeGoods(boolean canImportPrizeGoods) {
    this.canImportPrizeGoods = canImportPrizeGoods;
  }

  public boolean getUseManualDiscount() {
    return useManualDiscount;
  }

  public void setUseManualDiscount(boolean useManualDiscount) {
    this.useManualDiscount = useManualDiscount;
  }

  public boolean getShowDiscountRate() {
    return showDiscountRate;
  }

  public void setShowDiscountRate(boolean showDiscountRate) {
    this.showDiscountRate = showDiscountRate;
  }

  public boolean getShowBarCode() {
    return showBarCode;
  }

  public void setShowBarCode(boolean showBarCode) {
    this.showBarCode = showBarCode;
  }

  public boolean getShowRtlPrc() {
    return showRtlPrc;
  }

  public void setShowRtlPrc(boolean showRtlPrc) {
    this.showRtlPrc = showRtlPrc;
  }

  public boolean getShowFavAmount() {
    return showFavAmount;
  }

  public void setShowFavAmount(boolean showFavAmount) {
    this.showFavAmount = showFavAmount;
  }

  public void setLineNoWidth(int lineNoWidth) {
    this.lineNoWidth = lineNoWidth;
  }

  public int getInputCodeNameWidth() {
    return inputCodeNameWidth;
  }

  public void setInputCodeNameWidth(int inputCodeNameWidth) {
    this.inputCodeNameWidth = inputCodeNameWidth;
  }

  public int getPriceUnitWidth() {
    return priceUnitWidth;
  }

  public void setPriceUnitWidth(int priceUnitWidth) {
    this.priceUnitWidth = priceUnitWidth;
  }

  public int getQuantityWidth() {
    return quantityWidth;
  }

  public void setQuantityWidth(int quantityWidth) {
    this.quantityWidth = quantityWidth;
  }

  public int getDiscountWidth() {
    return discountWidth;
  }

  public void setDiscountWidth(int discountWidth) {
    this.discountWidth = discountWidth;
  }

  public int getAmountWidth() {
    return amountWidth;
  }

  public void setAmountWidth(int totalWidth) {
    this.amountWidth = totalWidth;
  }

  public String getInputCodePattern() {
    return inputCodePattern;
  }

  public void setInputCodePattern(String inputCodePattern) {
    this.inputCodePattern = inputCodePattern;
  }

  public String getPricePattern() {
    return pricePattern;
  }

  public void setPricePattern(String pricePattern) {
    this.pricePattern = pricePattern;
  }

  public String getQuantityPattern() {
    return quantityPattern;
  }

  public void setQuantityPattern(String quantityPattern) {
    this.quantityPattern = quantityPattern;
  }

  public String getAmountPattern() {
    return amountPattern;
  }

  public void setAmountPattern(String amountPattern) {
    this.amountPattern = amountPattern;
  }

  public String getDiscountPattern() {
    return discountPattern;
  }

  public void setDiscountPattern(String discountPattern) {
    this.discountPattern = discountPattern;
  }

  public void setUseProductHelper(boolean useProductHelper) {
    this.useProductHelper = useProductHelper;
  }

  public boolean getUseProductHelper() {
    return useProductHelper;
  }

  public boolean getUseProductHelperOnlyWhenNotExist() {
    return useProductHelperOnlyWhenNotExist;
  }

  public void setUseProductHelperOnlyWhenNotExist(boolean useProductHelperOnlyWhenNotExist) {
    this.useProductHelperOnlyWhenNotExist = useProductHelperOnlyWhenNotExist;
  }

  public String getPcsQuantityPattern() {
    return pcsQuantityPattern;
  }

  public void setPcsQuantityPattern(String pcsQuantityPattern) {
    this.pcsQuantityPattern = pcsQuantityPattern;
  }

  public boolean getEnablePcsQuantity() {
    return enablePcsQuantity;
  }

  public void setEnablePcsQuantity(boolean enablePcsQuantity) {
    this.enablePcsQuantity = enablePcsQuantity;
  }

  public boolean getShowingAssistant() {
    return showingAssistant;
  }

  public void setShowingAssistant(boolean showingAssistant) {
    this.showingAssistant = showingAssistant;
  }

  public boolean getMustGetWeigth() {
    return mustGetWeigth;
  }

  public void setMustGetWeigth(boolean mustGetWeigth) {
    this.mustGetWeigth = mustGetWeigth;
  }

  public boolean getShowInvalidInputPromptBox() {
    return showInvalidInputPromptBox;
  }

  public void setShowInvalidInputPromptBox(boolean showInvalidInputPromptBox) {
    this.showInvalidInputPromptBox = showInvalidInputPromptBox;
  }

  public boolean getAutoMergeSameProduct() {
    return autoMergeSameProduct;
  }

  public void setAutoMergeSameProduct(boolean autoMergeSameProduct) {
    this.autoMergeSameProduct = autoMergeSameProduct;
  }

  public int getAutoMergeSameProductTipTime() {
    return autoMergeSameProductTipTime;
  }

  public void setAutoMergeSameProductTipTime(int autoMergeSameProductTipTime) {
    this.autoMergeSameProductTipTime = autoMergeSameProductTipTime;
  }

  public boolean getShowingInputCode() {
    return showingInputCode;
  }

  public void setShowingInputCode(boolean showingInputCode) {
    this.showingInputCode = showingInputCode;
  }

  public int getCreditCount() {
    return creditCount;
  }

  public void setCreditCount(int creditCount) {
    this.creditCount = creditCount;
  }

  public boolean getCanChangeMember() {
    return canChangeMember;
  }

  public void setCanChangeMember(boolean canChangeMember) {
    this.canChangeMember = canChangeMember;
  }

  public boolean getShowLineAssistant() {
    return showLineAssistant;
  }

  public void setShowLineAssistant(boolean showLineAssistant) {
    this.showLineAssistant = showLineAssistant;
  }

  public String getLineAssistantCode() {
    return lineAssistantCode;
  }

  public void setLineAssistantCode(String lineAssistantCode) {
    this.lineAssistantCode = lineAssistantCode;
  }

  public void setMaxHoldCount(int maxHoldCount) {
    this.maxHoldCount = maxHoldCount;
  }

  public int getMaxHoldCount() {
    return maxHoldCount;
  }

  public boolean getCanInitAssistant() {
    return canInitAssistant;
  }

  public void setCanInitAssistant(boolean canInitAssistant) {
    this.canInitAssistant = canInitAssistant;
  }

  public int getAssistantDialogType() {
    return assistantDialogType;
  }

  public void setAssistantDialogType(int assistantDialogType) {
    this.assistantDialogType = assistantDialogType;
  }

  public boolean getUseMemberRegister() {
    return useMemberRegister;
  }

  public void setUseMemberRegister(boolean useMemberRegister) {
    this.useMemberRegister = useMemberRegister;
  }

  public boolean getShowProgressDialog() {
    return showProgressDialog;
  }

  public void setShowProgressDialog(boolean showProgressDialog) {
    this.showProgressDialog = showProgressDialog;
  }

  public int getMaxHoldHour() {
    return maxHoldHour;
  }

  public void setMaxHoldHour(int maxHoldHour) {
    this.maxHoldHour = maxHoldHour;
  }

  public boolean getAutoShowPromotionCouponUi() {
    return autoShowPromotionCouponUi;
  }

  public void setAutoShowPromotionCouponUi(boolean autoShowPromotionCouponUi) {
    this.autoShowPromotionCouponUi = autoShowPromotionCouponUi;
  }

  public boolean getShowInvQty() {
    return showInvQty;
  }

  public void setShowInvQty(boolean showInvQty) {
    this.showInvQty = showInvQty;
  }

  public boolean getCheckHasOnlinePayment() {
    return checkHasOnlinePayment;
  }

  public void setCheckHasOnlinePayment(boolean checkHasOnlinePayment) {
    this.checkHasOnlinePayment = checkHasOnlinePayment;
  }

  public boolean getShowUpowerVoucherHelper() {
    return showUpowerVoucherHelper;
  }

  public void setShowUpowerVoucherHelper(boolean showUpowerVoucherHelper) {
    this.showUpowerVoucherHelper = showUpowerVoucherHelper;
  }

  public int getSaleAmountLimit() {
    return saleAmountLimit;
  }

  public void setSaleAmountLimit(int saleAmountLimit) {
    this.saleAmountLimit = saleAmountLimit;
  }

  public boolean getShowFaceMemberInfoPanel() {
    return showFaceMemberInfoPanel;
  }

  public void setShowFaceMemberInfoPanel(boolean showFaceMemberInfoPanel) {
    this.showFaceMemberInfoPanel = showFaceMemberInfoPanel;
  }

  public boolean getShowFaceMemberPreferenceAnalysisPanel() {
    return showFaceMemberPreferenceAnalysisPanel;
  }

  public void setShowFaceMemberPreferenceAnalysisPanel(boolean showFaceMemberPreferenceAnalysisPanel) {
    this.showFaceMemberPreferenceAnalysisPanel = showFaceMemberPreferenceAnalysisPanel;
  }

  public boolean getCheckGoodsPrice() {
    return checkGoodsPrice;
  }

  public void setCheckGoodsPrice(boolean checkGoodsPrice) {
    this.checkGoodsPrice = checkGoodsPrice;
  }

  public boolean getEnableGoodsSortCodeLimit() {
    return enableGoodsSortCodeLimit;
  }

  public void setEnableGoodsSortCodeLimit(boolean enableGoodsSortCodeLimit) {
    this.enableGoodsSortCodeLimit = enableGoodsSortCodeLimit;
  }

  public String getLimitedGoodsSort() {
    return limitedGoodsSort;
  }

  public void setLimitedGoodsSort(String limitedGoodsSort) {
    this.limitedGoodsSort = limitedGoodsSort;
  }

  public boolean enableLimitedGoodsSort() {
    return !(!getEnableGoodsSortCodeLimit() || limitedGoodsSort == null || limitedGoodsSort.isEmpty());
  }

  public boolean getAllowNegativeInvQty() {
    return allowNegativeInvQty;
  }

  public void setAllowNegativeInvQty(boolean allowNegativeInvQty) {
    this.allowNegativeInvQty = allowNegativeInvQty;
  }

  public boolean getUseHoldMemo() {
    return useHoldMemo;
  }

  public void setUseHoldMemo(boolean useHoldMemo) {
    this.useHoldMemo = useHoldMemo;
  }

  public boolean getSaleAmountZeroCheck() {
    return saleAmountZeroCheck;
  }

  public void setSaleAmountZeroCheck(boolean saleAmountZeroCheck) {
    this.saleAmountZeroCheck = saleAmountZeroCheck;
  }

  public boolean getUseShowOrHideProductSelect() {
    return useShowOrHideProductSelect;
  }

  public void setUseShowOrHideProductSelect(boolean useShowOrHideProductSelect) {
    this.useShowOrHideProductSelect = useShowOrHideProductSelect;
  }

  public boolean getModifyDataToNewLine() {
    return modifyDataToNewLine;
  }

  public void setModifyDataToNewLine(boolean modifyDataToNewLine) {
    this.modifyDataToNewLine = modifyDataToNewLine;
  }

  public boolean getShowMemberPromptMsg() {
    return showMemberPromptMsg;
  }

  public void setShowMemberPromptMsg(boolean showMemberPromptMsg) {
    this.showMemberPromptMsg = showMemberPromptMsg;
  }

  public boolean getShowMemberRemark() {
    return showMemberRemark;
  }

  public void setShowMemberRemark(boolean showMemberRemark) {
    this.showMemberRemark = showMemberRemark;
  }

  public boolean getUseGetWeightToLastLine() {
    return useGetWeightToLastLine;
  }

  public void setUseGetWeightToLastLine(boolean useGetWeightToLastLine) {
    this.useGetWeightToLastLine = useGetWeightToLastLine;
  }

  public String getHighlightProductBrandCodes() {
    return highlightProductBrandCodes;
  }

  public void setHighlightProductBrandCodes(String highlightProductBrandCodes) {
    this.highlightProductBrandCodes = highlightProductBrandCodes;
  }

  public boolean getAllowTareWeight() {
    return allowTareWeight;
  }

  public void setAllowTareWeight(boolean allowTareWeight) {
    this.allowTareWeight = allowTareWeight;
  }

  public boolean getCheckScaleNetWeight() {
    return checkScaleNetWeight;
  }

  public void setCheckScaleNetWeight(boolean checkScaleNetWeight) {
    this.checkScaleNetWeight = checkScaleNetWeight;
  }

  public boolean getShowEnvironmentalTax() {
    return showEnvironmentalTax;
  }

  public void setShowEnvironmentalTax(boolean showEnvironmentalTax) {
    this.showEnvironmentalTax = showEnvironmentalTax;
  }

  public boolean getShowTotalEnvironmentalTax() {
    return showTotalEnvironmentalTax;
  }

  public void setShowTotalEnvironmentalTax(boolean showTotalEnvironmentalTax) {
    this.showTotalEnvironmentalTax = showTotalEnvironmentalTax;
  }

  public String getOutboundOrderTitleHint() {
    return outboundOrderTitleHint;
  }

  public void setOutboundOrderTitleHint(String outboundOrderTitleHint) {
    this.outboundOrderTitleHint = outboundOrderTitleHint;
  }

  public boolean getShowCodeNameWithAllColumn() {
    return showCodeNameWithAllColumn;
  }

  public void setShowCodeNameWithAllColumn(boolean showCodeNameWithAllColumn) {
    this.showCodeNameWithAllColumn = showCodeNameWithAllColumn;
  }

  public boolean getTitleLineDisplayPanelLeftAlign() {
    return titleLineDisplayPanelLeftAlign;
  }

  public void setTitleLineDisplayPanelLeftAlign(boolean titleLineDisplayPanelLeftAlign) {
    this.titleLineDisplayPanelLeftAlign = titleLineDisplayPanelLeftAlign;
  }

  public String getTitleLastOrderHint() {
    return titleLastOrderHint;
  }

  public void setTitleLastOrderHint(String titleLastOrderHint) {
    this.titleLastOrderHint = titleLastOrderHint;
  }

  public boolean getUseHoldTip() {
    return useHoldTip;
  }

  public void setUseHoldTip(boolean useHoldTip) {
    this.useHoldTip = useHoldTip;
  }

  public boolean getUseSkuCount() {
    return useSkuCount;
  }

  public void setUseSkuCount(boolean useSkuCount) {
    this.useSkuCount = useSkuCount;
  }

  public String getMemberBirthInfo() {
    return memberBirthInfo;
  }

  public void setMemberBirthInfo(String memberBirthInfo) {
    this.memberBirthInfo = memberBirthInfo;
  }

  public boolean getUseCautionLabel() {
    return useCautionLabel;
  }

  public void setUseCautionLabel(boolean useCautionLabel) {
    this.useCautionLabel = useCautionLabel;
  }

  public boolean getUseStoreDiscountReason() {
    return useStoreDiscountReason;
  }

  public void setUseStoreDiscountReason(boolean useStoreDiscountReason) {
    this.useStoreDiscountReason = useStoreDiscountReason;
  }

  public boolean getEnableFlowNoEncrypt() {
    return enableFlowNoEncrypt;
  }

  public void setEnableFlowNoEncrypt(boolean enableFlowNoEncrypt) {
    this.enableFlowNoEncrypt = enableFlowNoEncrypt;
  }

  public boolean isUseErpGdShortcutKey() {
    return useErpGdShortcutKey;
  }

  public void setUseErpGdShortcutKey(boolean useErpGdShortcutKey) {
    this.useErpGdShortcutKey = useErpGdShortcutKey;
  }

  public boolean getAutoSetAssistant() {
    return autoSetAssistant;
  }

  public void setAutoSetAssistant(boolean autoSetAssistant) {
    this.autoSetAssistant = autoSetAssistant;
  }

  public boolean getUseLoginByCardPattern() {
    return useLoginByCardPattern;
  }

  public void setUseLoginByCardPattern(boolean useLoginByCardPattern) {
    this.useLoginByCardPattern = useLoginByCardPattern;
  }

  public boolean getUsePrintPermissionControl() {
    return usePrintPermissionControl;
  }

  public void setUsePrintPermissionControl(boolean usePrintPermissionControl) {
    this.usePrintPermissionControl = usePrintPermissionControl;
  }

  public String getDistributeOrderSelfTakeCodePrefix() {
    return distributeOrderSelfTakeCodePrefix;
  }

  public void setDistributeOrderSelfTakeCodePrefix(String distributeOrderSelfTakeCodePrefix) {
    this.distributeOrderSelfTakeCodePrefix = distributeOrderSelfTakeCodePrefix;
  }

  public String getRetailHelperSeparator() {
    return retailHelperSeparator;
  }

  public void setRetailHelperSeparator(String retailHelperSeparator) {
    this.retailHelperSeparator = retailHelperSeparator;
  }

  public String parseRetailHelperSeparator() {
    if ("\\n".equals(retailHelperSeparator)) {
      return "\n";
    }
    return retailHelperSeparator;
  }

  public boolean getGoodsNegateInvCheck() {
    return goodsNegateInvCheck;
  }

  public void setGoodsNegateInvCheck(boolean goodsNegateInvCheck) {
    this.goodsNegateInvCheck = goodsNegateInvCheck;
  }

  public boolean getShowCashier() {
    return showCashier;
  }

  public void setShowCashier(boolean showCashier) {
    this.showCashier = showCashier;
  }

  public boolean getOrderAssistantCheck() {
    return orderAssistantCheck;
  }

  public void setOrderAssistantCheck(boolean orderAssistantCheck) {
    this.orderAssistantCheck = orderAssistantCheck;
  }

  public boolean getNeedCheckHoldTranPermission() {
    return needCheckHoldTranPermission;
  }

  public void setNeedCheckHoldTranPermission(boolean needCheckHoldTranPermission) {
    this.needCheckHoldTranPermission = needCheckHoldTranPermission;
  }
}
