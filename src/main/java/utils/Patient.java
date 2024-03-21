package utils;

/**
 * </br>
 * Created by yangxiaohua on 2024/3/21.
 */
class Patient {
  private String PATIENT_ID;
  private String VISIT_ID;
  private String 住院号;
  private String PATIENT_NAME;
  private String SEX;
  private String AGE;
  private String WARD_NAME;
  private String 主诊断;
  private String 其他诊断;
  private String 身高;
  private String 体重;
  private String 入院时间;
  private String 出院时间;
  private String 手术时间;
  private String 手术名称;
  private String 病理;
  private String B超;
  private String 记录日期;
  private String 记录时间;
  private String CAPRINI评分;
  private String 护理措施;
  private String 护理措施2;
  private String 护理措施3;
  private String 药品名;
  private String 年龄0至40岁;
  private String 年龄41至60岁;
  private String 年龄61至74岁;
  private String 年龄大于等于75岁;
  private String 肥胖即体质指数BMI大于25;
  private String 卧床时间小于72小时且持续步行少于30步;
  private String 卧床时间大于等于72小时且持续步行少于30步;
  private String 下肢肿胀目前或1个月内;
  private String 下肢静脉曲张目前或1个月内;
  private String 炎性肠病史如克隆氏病或溃疡性结肠炎;
  private String 充血性心力衰竭史;
  private String 严重肺病史如COPD或肺气肿或不包括哮喘;
  private String 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者;
  private String 一月内或现在急性心肌梗死;
  private String 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症;
  private String 一月内进行过全麻或局麻下大于等于45分钟的手术;
  private String 一月内或现在PICC置管或中心静脉置管;
  private String 一月内下肢关节置换手术史;
  private String 一月内下肢石膏固定或其他原因限制下肢活动;
  private String 一月内髋或骨盆或下肢骨折;
  private String 一月内严重创伤比如由于车祸或坠落导致的多处骨折;
  private String 一月内需长期卧床的脑卒中;
  private String 一月内急性脊髓损伤瘫痪;
  private String VTE病史;
  private String VTE家族史;
  private String 小手术即手术时间小于45分钟;
  private String 大手术即手术时间大于等于45分钟;
  private String 关节镜手术即手术时间大于等于45分钟;
  private String 腹腔鏡手术即手术时间大于等于45分钟;
  private String 怀孕或产后一个月内;
  private String 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史;
  private String 正在口服避孕药或其他药物避孕措施;
  private String 狼疮抗凝物阳性括号获得性;
  private String 抗磷脂抗体阳性括号获得性;
  private String 高同型半胱氨酸血症括号获得性;
  private String 肝素诱导的血小板减少症括号获得性;
  private String 凝血因子VLEIDEN突变括号遗传性;
  private String 凝血酶原G20210A突变括号遗传性;
  private String 蛋白S斜杠C缺乏括号遗传性;
  private String 抗凝血酶III缺乏括号遗传性;
  private String 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等;
  private String 纤维蛋白降解物1;
  private String D_D二聚体;
  private String 凝血酶时间1;
  private String 凝血酶原时间1;
  private String 国际标准化比率1;
  private String 纤维蛋白原1;
  private String 部分凝血活酶时间1;
  private String 血小板计数1;
  private String 尿酸URIC1;

  private String 肌酐CREA1;

  private String 凝血因子活性1;

  private String 纤维蛋白原水平min1;

  private String 纤维蛋白原水平1;

  private String 血小板功能1;

  private String 凝血综合参数1;

  private String 预测纤溶指标1;

  private String 纤溶指标1;

  private String 凝固时间1;

  private String 血块强度;

  private String TEG凝血因子活性1;

  private String TEG纤维蛋白原水平1;

  private String TEG血小板功能1;

  private String TEG纤溶系统1;

  private String 总胆固醇CHOL1;

  private String 甘油三脂TG1;

  private String 高密度脂蛋白胆固醇HDL1;

  private String 低密度脂蛋白胆固醇LDL1;

  private String 非高密度脂蛋白胆固醇NHDL1;

  private String 纤维蛋白原降解物术后第一天;
  private String D_D二聚体术后第一天;

  private String 肌酐CREA术后第一天;
  private String 尿酸URIC术后第一天;

  // Add other fields and corresponding setters/getters as needed

  public String getPATIENT_ID() {
    return PATIENT_ID;
  }

  public void setPATIENT_ID(String PATIENT_ID) {
    this.PATIENT_ID = PATIENT_ID;
  }

  public String getVISIT_ID() {
    return VISIT_ID;
  }

  public void setVISIT_ID(String VISIT_ID) {
    this.VISIT_ID = VISIT_ID;
  }

  public String get住院号() {
    return 住院号;
  }

  public void set住院号(String 住院号) {
    this.住院号 = 住院号;
  }

  public String getPATIENT_NAME() {
    return PATIENT_NAME;
  }

  public void setPATIENT_NAME(String PATIENT_NAME) {
    this.PATIENT_NAME = PATIENT_NAME;
  }

  public String getSEX() {
    return SEX;
  }

  public void setSEX(String SEX) {
    this.SEX = SEX;
  }

  public String getAGE() {
    return AGE;
  }

  public void setAGE(String AGE) {
    this.AGE = AGE;
  }

  public String getWARD_NAME() {
    return WARD_NAME;
  }

  public void setWARD_NAME(String WARD_NAME) {
    this.WARD_NAME = WARD_NAME;
  }

  public String get主诊断() {
    return 主诊断;
  }

  public void set主诊断(String 主诊断) {
    this.主诊断 = 主诊断;
  }

  public String get其他诊断() {
    return 其他诊断;
  }

  public void set其他诊断(String 其他诊断) {
    this.其他诊断 = 其他诊断;
  }

  public String get身高() {
    return 身高;
  }

  public void set身高(String 身高) {
    this.身高 = 身高;
  }

  public String get体重() {
    return 体重;
  }

  public void set体重(String 体重) {
    this.体重 = 体重;
  }

  public String get入院时间() {
    return 入院时间;
  }

  public void set入院时间(String 入院时间) {
    this.入院时间 = 入院时间;
  }

  public String get出院时间() {
    return 出院时间;
  }

  public void set出院时间(String 出院时间) {
    this.出院时间 = 出院时间;
  }

  public String get手术时间() {
    return 手术时间;
  }

  public void set手术时间(String 手术时间) {
    this.手术时间 = 手术时间;
  }

  public String get手术名称() {
    return 手术名称;
  }

  public void set手术名称(String 手术名称) {
    this.手术名称 = 手术名称;
  }

  public String get病理() {
    return 病理;
  }

  public void set病理(String 病理) {
    this.病理 = 病理;
  }

  public String getB超() {
    return B超;
  }

  public void setB超(String b超) {
    B超 = b超;
  }

  public String get记录日期() {
    return 记录日期;
  }

  public void set记录日期(String 记录日期) {
    this.记录日期 = 记录日期;
  }

  public String get记录时间() {
    return 记录时间;
  }

  public void set记录时间(String 记录时间) {
    this.记录时间 = 记录时间;
  }

  public String getCAPRINI评分() {
    return CAPRINI评分;
  }

  public void setCAPRINI评分(String CAPRINI评分) {
    this.CAPRINI评分 = CAPRINI评分;
  }

  public String get护理措施() {
    return 护理措施;
  }

  public void set护理措施(String 护理措施) {
    this.护理措施 = 护理措施;
  }

  public String get护理措施2() {
    return 护理措施2;
  }

  public void set护理措施2(String 护理措施2) {
    this.护理措施2 = 护理措施2;
  }

  public String get护理措施3() {
    return 护理措施3;
  }

  public void set护理措施3(String 护理措施3) {
    this.护理措施3 = 护理措施3;
  }

  public String get药品名() {
    return 药品名;
  }

  public void set药品名(String 药品名) {
    this.药品名 = 药品名;
  }

  public String get年龄0至40岁() {
    return 年龄0至40岁;
  }

  public void set年龄0至40岁(String 年龄0至40岁) {
    this.年龄0至40岁 = 年龄0至40岁;
  }

  public String get年龄41至60岁() {
    return 年龄41至60岁;
  }

  public void set年龄41至60岁(String 年龄41至60岁) {
    this.年龄41至60岁 = 年龄41至60岁;
  }

  public String get年龄61至74岁() {
    return 年龄61至74岁;
  }

  public void set年龄61至74岁(String 年龄61至74岁) {
    this.年龄61至74岁 = 年龄61至74岁;
  }

  public String get年龄大于等于75岁() {
    return 年龄大于等于75岁;
  }

  public void set年龄大于等于75岁(String 年龄大于等于75岁) {
    this.年龄大于等于75岁 = 年龄大于等于75岁;
  }

  public String get肥胖即体质指数BMI大于25() {
    return 肥胖即体质指数BMI大于25;
  }

  public void set肥胖即体质指数BMI大于25(String 肥胖即体质指数BMI大于25) {
    this.肥胖即体质指数BMI大于25 = 肥胖即体质指数BMI大于25;
  }

  public String get卧床时间小于72小时且持续步行少于30步() {
    return 卧床时间小于72小时且持续步行少于30步;
  }

  public void set卧床时间小于72小时且持续步行少于30步(String 卧床时间小于72小时且持续步行少于30步) {
    this.卧床时间小于72小时且持续步行少于30步 = 卧床时间小于72小时且持续步行少于30步;
  }

  public String get卧床时间大于等于72小时且持续步行少于30步() {
    return 卧床时间大于等于72小时且持续步行少于30步;
  }

  public void set卧床时间大于等于72小时且持续步行少于30步(String 卧床时间大于等于72小时且持续步行少于30步) {
    this.卧床时间大于等于72小时且持续步行少于30步 = 卧床时间大于等于72小时且持续步行少于30步;
  }

  public String get下肢肿胀目前或1个月内() {
    return 下肢肿胀目前或1个月内;
  }

  public void set下肢肿胀目前或1个月内(String 下肢肿胀目前或1个月内) {
    this.下肢肿胀目前或1个月内 = 下肢肿胀目前或1个月内;
  }

  public String get下肢静脉曲张目前或1个月内() {
    return 下肢静脉曲张目前或1个月内;
  }

  public void set下肢静脉曲张目前或1个月内(String 下肢静脉曲张目前或1个月内) {
    this.下肢静脉曲张目前或1个月内 = 下肢静脉曲张目前或1个月内;
  }

  public String get炎性肠病史如克隆氏病或溃疡性结肠炎() {
    return 炎性肠病史如克隆氏病或溃疡性结肠炎;
  }

  public void set炎性肠病史如克隆氏病或溃疡性结肠炎(String 炎性肠病史如克隆氏病或溃疡性结肠炎) {
    this.炎性肠病史如克隆氏病或溃疡性结肠炎 = 炎性肠病史如克隆氏病或溃疡性结肠炎;
  }

  public String get充血性心力衰竭史() {
    return 充血性心力衰竭史;
  }

  public void set充血性心力衰竭史(String 充血性心力衰竭史) {
    this.充血性心力衰竭史 = 充血性心力衰竭史;
  }

  public String get严重肺病史如COPD或肺气肿或不包括哮喘() {
    return 严重肺病史如COPD或肺气肿或不包括哮喘;
  }

  public void set严重肺病史如COPD或肺气肿或不包括哮喘(String 严重肺病史如COPD或肺气肿或不包括哮喘) {
    this.严重肺病史如COPD或肺气肿或不包括哮喘 = 严重肺病史如COPD或肺气肿或不包括哮喘;
  }

  public String get恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者() {
    return 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者;
  }

  public void set恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者(String 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者) {
    this.恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者 = 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者;
  }

  public String get一月内或现在急性心肌梗死() {
    return 一月内或现在急性心肌梗死;
  }

  public void set一月内或现在急性心肌梗死(String 一月内或现在急性心肌梗死) {
    this.一月内或现在急性心肌梗死 = 一月内或现在急性心肌梗死;
  }

  public String get一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症() {
    return 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症;
  }

  public void set一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症(String 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症) {
    this.一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症 = 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症;
  }

  public String get一月内进行过全麻或局麻下大于等于45分钟的手术() {
    return 一月内进行过全麻或局麻下大于等于45分钟的手术;
  }

  public void set一月内进行过全麻或局麻下大于等于45分钟的手术(String 一月内进行过全麻或局麻下大于等于45分钟的手术) {
    this.一月内进行过全麻或局麻下大于等于45分钟的手术 = 一月内进行过全麻或局麻下大于等于45分钟的手术;
  }

  public String get一月内或现在PICC置管或中心静脉置管() {
    return 一月内或现在PICC置管或中心静脉置管;
  }

  public void set一月内或现在PICC置管或中心静脉置管(String 一月内或现在PICC置管或中心静脉置管) {
    this.一月内或现在PICC置管或中心静脉置管 = 一月内或现在PICC置管或中心静脉置管;
  }

  public String get一月内下肢关节置换手术史() {
    return 一月内下肢关节置换手术史;
  }

  public void set一月内下肢关节置换手术史(String 一月内下肢关节置换手术史) {
    this.一月内下肢关节置换手术史 = 一月内下肢关节置换手术史;
  }

  public String get一月内髋或骨盆或下肢骨折() {
    return 一月内髋或骨盆或下肢骨折;
  }

  public void set一月内髋或骨盆或下肢骨折(String 一月内髋或骨盆或下肢骨折) {
    this.一月内髋或骨盆或下肢骨折 = 一月内髋或骨盆或下肢骨折;
  }

  public String get一月内严重创伤比如由于车祸或坠落导致的多处骨折() {
    return 一月内严重创伤比如由于车祸或坠落导致的多处骨折;
  }

  public void set一月内严重创伤比如由于车祸或坠落导致的多处骨折(String 一月内严重创伤比如由于车祸或坠落导致的多处骨折) {
    this.一月内严重创伤比如由于车祸或坠落导致的多处骨折 = 一月内严重创伤比如由于车祸或坠落导致的多处骨折;
  }

  public String get一月内需长期卧床的脑卒中() {
    return 一月内需长期卧床的脑卒中;
  }

  public void set一月内需长期卧床的脑卒中(String 一月内需长期卧床的脑卒中) {
    this.一月内需长期卧床的脑卒中 = 一月内需长期卧床的脑卒中;
  }

  public String get一月内急性脊髓损伤瘫痪() {
    return 一月内急性脊髓损伤瘫痪;
  }

  public void set一月内急性脊髓损伤瘫痪(String 一月内急性脊髓损伤瘫痪) {
    this.一月内急性脊髓损伤瘫痪 = 一月内急性脊髓损伤瘫痪;
  }

  public String getVTE病史() {
    return VTE病史;
  }

  public void setVTE病史(String VTE病史) {
    this.VTE病史 = VTE病史;
  }

  public String getVTE家族史() {
    return VTE家族史;
  }

  public void setVTE家族史(String VTE家族史) {
    this.VTE家族史 = VTE家族史;
  }

  public String get小手术即手术时间小于45分钟() {
    return 小手术即手术时间小于45分钟;
  }

  public void set小手术即手术时间小于45分钟(String 小手术即手术时间小于45分钟) {
    this.小手术即手术时间小于45分钟 = 小手术即手术时间小于45分钟;
  }

  public String get大手术即手术时间大于等于45分钟() {
    return 大手术即手术时间大于等于45分钟;
  }

  public void set大手术即手术时间大于等于45分钟(String 大手术即手术时间大于等于45分钟) {
    this.大手术即手术时间大于等于45分钟 = 大手术即手术时间大于等于45分钟;
  }

  public String get关节镜手术即手术时间大于等于45分钟() {
    return 关节镜手术即手术时间大于等于45分钟;
  }

  public void set关节镜手术即手术时间大于等于45分钟(String 关节镜手术即手术时间大于等于45分钟) {
    this.关节镜手术即手术时间大于等于45分钟 = 关节镜手术即手术时间大于等于45分钟;
  }

  public String get腹腔鏡手术即手术时间大于等于45分钟() {
    return 腹腔鏡手术即手术时间大于等于45分钟;
  }

  public void set腹腔鏡手术即手术时间大于等于45分钟(String 腹腔鏡手术即手术时间大于等于45分钟) {
    this.腹腔鏡手术即手术时间大于等于45分钟 = 腹腔鏡手术即手术时间大于等于45分钟;
  }

  public String get怀孕或产后一个月内() {
    return 怀孕或产后一个月内;
  }

  public void set怀孕或产后一个月内(String 怀孕或产后一个月内) {
    this.怀孕或产后一个月内 = 怀孕或产后一个月内;
  }

  public String get有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史() {
    return 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史;
  }

  public void set有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史(String 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史) {
    this.有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史 = 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史;
  }

  public String get正在口服避孕药或其他药物避孕措施() {
    return 正在口服避孕药或其他药物避孕措施;
  }

  public void set正在口服避孕药或其他药物避孕措施(String 正在口服避孕药或其他药物避孕措施) {
    this.正在口服避孕药或其他药物避孕措施 = 正在口服避孕药或其他药物避孕措施;
  }

  public String get狼疮抗凝物阳性括号获得性() {
    return 狼疮抗凝物阳性括号获得性;
  }

  public void set狼疮抗凝物阳性括号获得性(String 狼疮抗凝物阳性括号获得性) {
    this.狼疮抗凝物阳性括号获得性 = 狼疮抗凝物阳性括号获得性;
  }

  public String get抗磷脂抗体阳性括号获得性() {
    return 抗磷脂抗体阳性括号获得性;
  }

  public void set抗磷脂抗体阳性括号获得性(String 抗磷脂抗体阳性括号获得性) {
    this.抗磷脂抗体阳性括号获得性 = 抗磷脂抗体阳性括号获得性;
  }

  public String get高同型半胱氨酸血症括号获得性() {
    return 高同型半胱氨酸血症括号获得性;
  }

  public void set高同型半胱氨酸血症括号获得性(String 高同型半胱氨酸血症括号获得性) {
    this.高同型半胱氨酸血症括号获得性 = 高同型半胱氨酸血症括号获得性;
  }

  public String get肝素诱导的血小板减少症括号获得性() {
    return 肝素诱导的血小板减少症括号获得性;
  }

  public void set肝素诱导的血小板减少症括号获得性(String 肝素诱导的血小板减少症括号获得性) {
    this.肝素诱导的血小板减少症括号获得性 = 肝素诱导的血小板减少症括号获得性;
  }

  public String get凝血因子VLEIDEN突变括号遗传性() {
    return 凝血因子VLEIDEN突变括号遗传性;
  }

  public void set凝血因子VLEIDEN突变括号遗传性(String 凝血因子VLEIDEN突变括号遗传性) {
    this.凝血因子VLEIDEN突变括号遗传性 = 凝血因子VLEIDEN突变括号遗传性;
  }

  public String get凝血酶原G20210A突变括号遗传性() {
    return 凝血酶原G20210A突变括号遗传性;
  }

  public void set凝血酶原G20210A突变括号遗传性(String 凝血酶原G20210A突变括号遗传性) {
    this.凝血酶原G20210A突变括号遗传性 = 凝血酶原G20210A突变括号遗传性;
  }

  public String get蛋白S斜杠C缺乏括号遗传性() {
    return 蛋白S斜杠C缺乏括号遗传性;
  }

  public void set蛋白S斜杠C缺乏括号遗传性(String 蛋白S斜杠C缺乏括号遗传性) {
    this.蛋白S斜杠C缺乏括号遗传性 = 蛋白S斜杠C缺乏括号遗传性;
  }

  public String get抗凝血酶III缺乏括号遗传性() {
    return 抗凝血酶III缺乏括号遗传性;
  }

  public void set抗凝血酶III缺乏括号遗传性(String 抗凝血酶III缺乏括号遗传性) {
    this.抗凝血酶III缺乏括号遗传性 = 抗凝血酶III缺乏括号遗传性;
  }

  public String get其他高凝状态比如血纤维蛋白原异常或红细胞增多症等() {
    return 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等;
  }

  public void set其他高凝状态比如血纤维蛋白原异常或红细胞增多症等(String 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等) {
    this.其他高凝状态比如血纤维蛋白原异常或红细胞增多症等 = 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等;
  }

  public String get纤维蛋白降解物1() {
    return 纤维蛋白降解物1;
  }

  public void set纤维蛋白降解物1(String 纤维蛋白降解物1) {
    this.纤维蛋白降解物1 = 纤维蛋白降解物1;
  }

  public String getD_D二聚体() {
    return D_D二聚体;
  }

  public void setD_D二聚体(String d_D二聚体) {
    D_D二聚体 = d_D二聚体;
  }

  public String get凝血酶时间1() {
    return 凝血酶时间1;
  }

  public void set凝血酶时间1(String 凝血酶时间1) {
    this.凝血酶时间1 = 凝血酶时间1;
  }

  public String get凝血酶原时间1() {
    return 凝血酶原时间1;
  }

  public void set凝血酶原时间1(String 凝血酶原时间1) {
    this.凝血酶原时间1 = 凝血酶原时间1;
  }

  public String get国际标准化比率1() {
    return 国际标准化比率1;
  }

  public void set国际标准化比率1(String 国际标准化比率1) {
    this.国际标准化比率1 = 国际标准化比率1;
  }

  public String get纤维蛋白原1() {
    return 纤维蛋白原1;
  }

  public void set纤维蛋白原1(String 纤维蛋白原1) {
    this.纤维蛋白原1 = 纤维蛋白原1;
  }

  public String get部分凝血活酶时间1() {
    return 部分凝血活酶时间1;
  }

  public void set部分凝血活酶时间1(String 部分凝血活酶时间1) {
    this.部分凝血活酶时间1 = 部分凝血活酶时间1;
  }

  public String get血小板计数1() {
    return 血小板计数1;
  }

  public void set血小板计数1(String 血小板计数1) {
    this.血小板计数1 = 血小板计数1;
  }

  public String get尿酸URIC1() {
    return 尿酸URIC1;
  }

  public void set尿酸URIC1(String 尿酸URIC1) {
    this.尿酸URIC1 = 尿酸URIC1;
  }

  public String get肌酐CREA1() {
    return 肌酐CREA1;
  }

  public void set肌酐CREA1(String 肌酐CREA1) {
    this.肌酐CREA1 = 肌酐CREA1;
  }

  public String get凝血因子活性1() {
    return 凝血因子活性1;
  }

  public void set凝血因子活性1(String 凝血因子活性1) {
    this.凝血因子活性1 = 凝血因子活性1;
  }

  public String get一月内下肢石膏固定或其他原因限制下肢活动() {
    return 一月内下肢石膏固定或其他原因限制下肢活动;
  }

  public void set一月内下肢石膏固定或其他原因限制下肢活动(String 一月内下肢石膏固定或其他原因限制下肢活动) {
    this.一月内下肢石膏固定或其他原因限制下肢活动 = 一月内下肢石膏固定或其他原因限制下肢活动;
  }

  public String get纤维蛋白原水平min1() {
    return 纤维蛋白原水平min1;
  }

  public void set纤维蛋白原水平min1(String 纤维蛋白原水平min1) {
    this.纤维蛋白原水平min1 = 纤维蛋白原水平min1;
  }

  public String get纤维蛋白原水平1() {
    return 纤维蛋白原水平1;
  }

  public void set纤维蛋白原水平1(String 纤维蛋白原水平1) {
    this.纤维蛋白原水平1 = 纤维蛋白原水平1;
  }

  public String get血小板功能1() {
    return 血小板功能1;
  }

  public void set血小板功能1(String 血小板功能1) {
    this.血小板功能1 = 血小板功能1;
  }

  public String get凝血综合参数1() {
    return 凝血综合参数1;
  }

  public void set凝血综合参数1(String 凝血综合参数1) {
    this.凝血综合参数1 = 凝血综合参数1;
  }

  public String get预测纤溶指标1() {
    return 预测纤溶指标1;
  }

  public void set预测纤溶指标1(String 预测纤溶指标1) {
    this.预测纤溶指标1 = 预测纤溶指标1;
  }

  public String get纤溶指标1() {
    return 纤溶指标1;
  }

  public void set纤溶指标1(String 纤溶指标1) {
    this.纤溶指标1 = 纤溶指标1;
  }

  public String get凝固时间1() {
    return 凝固时间1;
  }

  public void set凝固时间1(String 凝固时间1) {
    this.凝固时间1 = 凝固时间1;
  }

  public String get血块强度() {
    return 血块强度;
  }

  public void set血块强度(String 血块强度) {
    this.血块强度 = 血块强度;
  }

  public String getTEG凝血因子活性1() {
    return TEG凝血因子活性1;
  }

  public void setTEG凝血因子活性1(String TEG凝血因子活性1) {
    this.TEG凝血因子活性1 = TEG凝血因子活性1;
  }

  public String getTEG纤维蛋白原水平1() {
    return TEG纤维蛋白原水平1;
  }

  public void setTEG纤维蛋白原水平1(String TEG纤维蛋白原水平1) {
    this.TEG纤维蛋白原水平1 = TEG纤维蛋白原水平1;
  }

  public String getTEG血小板功能1() {
    return TEG血小板功能1;
  }

  public void setTEG血小板功能1(String TEG血小板功能1) {
    this.TEG血小板功能1 = TEG血小板功能1;
  }

  public String getTEG纤溶系统1() {
    return TEG纤溶系统1;
  }

  public void setTEG纤溶系统1(String TEG纤溶系统1) {
    this.TEG纤溶系统1 = TEG纤溶系统1;
  }

  public String get总胆固醇CHOL1() {
    return 总胆固醇CHOL1;
  }

  public void set总胆固醇CHOL1(String 总胆固醇CHOL1) {
    this.总胆固醇CHOL1 = 总胆固醇CHOL1;
  }

  public String get甘油三脂TG1() {
    return 甘油三脂TG1;
  }

  public void set甘油三脂TG1(String 甘油三脂TG1) {
    this.甘油三脂TG1 = 甘油三脂TG1;
  }

  public String get高密度脂蛋白胆固醇HDL1() {
    return 高密度脂蛋白胆固醇HDL1;
  }

  public void set高密度脂蛋白胆固醇HDL1(String 高密度脂蛋白胆固醇HDL1) {
    this.高密度脂蛋白胆固醇HDL1 = 高密度脂蛋白胆固醇HDL1;
  }

  public String get低密度脂蛋白胆固醇LDL1() {
    return 低密度脂蛋白胆固醇LDL1;
  }

  public void set低密度脂蛋白胆固醇LDL1(String 低密度脂蛋白胆固醇LDL1) {
    this.低密度脂蛋白胆固醇LDL1 = 低密度脂蛋白胆固醇LDL1;
  }

  public String get非高密度脂蛋白胆固醇NHDL1() {
    return 非高密度脂蛋白胆固醇NHDL1;
  }

  public void set非高密度脂蛋白胆固醇NHDL1(String 非高密度脂蛋白胆固醇NHDL1) {
    this.非高密度脂蛋白胆固醇NHDL1 = 非高密度脂蛋白胆固醇NHDL1;
  }

  public String get纤维蛋白原降解物术后第一天() {
    return 纤维蛋白原降解物术后第一天;
  }

  public void set纤维蛋白原降解物术后第一天(String 纤维蛋白原降解物术后第一天) {
    this.纤维蛋白原降解物术后第一天 = 纤维蛋白原降解物术后第一天;
  }

  public String getD_D二聚体术后第一天() {
    return D_D二聚体术后第一天;
  }

  public void setD_D二聚体术后第一天(String d_D二聚体术后第一天) {
    D_D二聚体术后第一天 = d_D二聚体术后第一天;
  }

  public String get肌酐CREA术后第一天() {
    return 肌酐CREA术后第一天;
  }

  public void set肌酐CREA术后第一天(String 肌酐CREA术后第一天) {
    this.肌酐CREA术后第一天 = 肌酐CREA术后第一天;
  }

  public String get尿酸URIC术后第一天() {
    return 尿酸URIC术后第一天;
  }

  public void set尿酸URIC术后第一天(String 尿酸URIC术后第一天) {
    this.尿酸URIC术后第一天 = 尿酸URIC术后第一天;
  }

  @Override
  public String toString() {
    return "Patient{" +
      "PATIENT_ID='" + PATIENT_ID + '\'' +
      ", VISIT_ID='" + VISIT_ID + '\'' +
      ", 住院号='" + 住院号 + '\'' +
      ", PATIENT_NAME='" + PATIENT_NAME + '\'' +
      ", SEX='" + SEX + '\'' +
      ", AGE='" + AGE + '\'' +
      ", WARD_NAME='" + WARD_NAME + '\'' +
      ", 主诊断='" + 主诊断 + '\'' +
      ", 其他诊断='" + 其他诊断 + '\'' +
      ", 身高='" + 身高 + '\'' +
      ", 体重='" + 体重 + '\'' +
      ", 入院时间='" + 入院时间 + '\'' +
      ", 出院时间='" + 出院时间 + '\'' +
      ", 手术时间='" + 手术时间 + '\'' +
      ", 手术名称='" + 手术名称 + '\'' +
      ", 病理='" + 病理 + '\'' +
      ", B超='" + B超 + '\'' +
      ", 记录日期='" + 记录日期 + '\'' +
      ", 记录时间='" + 记录时间 + '\'' +
      ", CAPRINI评分='" + CAPRINI评分 + '\'' +
      ", 护理措施='" + 护理措施 + '\'' +
      ", 护理措施2='" + 护理措施2 + '\'' +
      ", 护理措施3='" + 护理措施3 + '\'' +
      ", 药品名='" + 药品名 + '\'' +
      ", 年龄0至40岁='" + 年龄0至40岁 + '\'' +
      ", 年龄41至60岁='" + 年龄41至60岁 + '\'' +
      ", 年龄61至74岁='" + 年龄61至74岁 + '\'' +
      ", 年龄大于等于75岁='" + 年龄大于等于75岁 + '\'' +
      ", 肥胖即体质指数BMI大于25='" + 肥胖即体质指数BMI大于25 + '\'' +
      ", 卧床时间小于72小时且持续步行少于30步='" + 卧床时间小于72小时且持续步行少于30步 + '\'' +
      ", 卧床时间大于等于72小时且持续步行少于30步='" + 卧床时间大于等于72小时且持续步行少于30步 + '\'' +
      ", 下肢肿胀目前或1个月内='" + 下肢肿胀目前或1个月内 + '\'' +
      ", 下肢静脉曲张目前或1个月内='" + 下肢静脉曲张目前或1个月内 + '\'' +
      ", 炎性肠病史如克隆氏病或溃疡性结肠炎='" + 炎性肠病史如克隆氏病或溃疡性结肠炎 + '\'' +
      ", 充血性心力衰竭史='" + 充血性心力衰竭史 + '\'' +
      ", 严重肺病史如COPD或肺气肿或不包括哮喘='" + 严重肺病史如COPD或肺气肿或不包括哮喘 + '\'' +
      ", 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者='" + 恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者 + '\'' +
      ", 一月内或现在急性心肌梗死='" + 一月内或现在急性心肌梗死 + '\'' +
      ", 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症='" + 一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症 + '\'' +
      ", 一月内进行过全麻或局麻下大于等于45分钟的手术='" + 一月内进行过全麻或局麻下大于等于45分钟的手术 + '\'' +
      ", 一月内或现在PICC置管或中心静脉置管='" + 一月内或现在PICC置管或中心静脉置管 + '\'' +
      ", 一月内下肢关节置换手术史='" + 一月内下肢关节置换手术史 + '\'' +
      ", 一月内下肢石膏固定或其他原因限制下肢活动='" + 一月内下肢石膏固定或其他原因限制下肢活动 + '\'' +
      ", 一月内髋或骨盆或下肢骨折='" + 一月内髋或骨盆或下肢骨折 + '\'' +
      ", 一月内严重创伤比如由于车祸或坠落导致的多处骨折='" + 一月内严重创伤比如由于车祸或坠落导致的多处骨折 + '\'' +
      ", 一月内需长期卧床的脑卒中='" + 一月内需长期卧床的脑卒中 + '\'' +
      ", 一月内急性脊髓损伤瘫痪='" + 一月内急性脊髓损伤瘫痪 + '\'' +
      ", VTE病史='" + VTE病史 + '\'' +
      ", VTE家族史='" + VTE家族史 + '\'' +
      ", 小手术即手术时间小于45分钟='" + 小手术即手术时间小于45分钟 + '\'' +
      ", 大手术即手术时间大于等于45分钟='" + 大手术即手术时间大于等于45分钟 + '\'' +
      ", 关节镜手术即手术时间大于等于45分钟='" + 关节镜手术即手术时间大于等于45分钟 + '\'' +
      ", 腹腔鏡手术即手术时间大于等于45分钟='" + 腹腔鏡手术即手术时间大于等于45分钟 + '\'' +
      ", 怀孕或产后一个月内='" + 怀孕或产后一个月内 + '\'' +
      ", 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史='" + 有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史 + '\'' +
      ", 正在口服避孕药或其他药物避孕措施='" + 正在口服避孕药或其他药物避孕措施 + '\'' +
      ", 狼疮抗凝物阳性括号获得性='" + 狼疮抗凝物阳性括号获得性 + '\'' +
      ", 抗磷脂抗体阳性括号获得性='" + 抗磷脂抗体阳性括号获得性 + '\'' +
      ", 高同型半胱氨酸血症括号获得性='" + 高同型半胱氨酸血症括号获得性 + '\'' +
      ", 肝素诱导的血小板减少症括号获得性='" + 肝素诱导的血小板减少症括号获得性 + '\'' +
      ", 凝血因子VLEIDEN突变括号遗传性='" + 凝血因子VLEIDEN突变括号遗传性 + '\'' +
      ", 凝血酶原G20210A突变括号遗传性='" + 凝血酶原G20210A突变括号遗传性 + '\'' +
      ", 蛋白S斜杠C缺乏括号遗传性='" + 蛋白S斜杠C缺乏括号遗传性 + '\'' +
      ", 抗凝血酶III缺乏括号遗传性='" + 抗凝血酶III缺乏括号遗传性 + '\'' +
      ", 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等='" + 其他高凝状态比如血纤维蛋白原异常或红细胞增多症等 + '\'' +
      ", 纤维蛋白降解物1='" + 纤维蛋白降解物1 + '\'' +
      ", D_D二聚体='" + D_D二聚体 + '\'' +
      ", 凝血酶时间1='" + 凝血酶时间1 + '\'' +
      ", 凝血酶原时间1='" + 凝血酶原时间1 + '\'' +
      ", 国际标准化比率1='" + 国际标准化比率1 + '\'' +
      ", 纤维蛋白原1='" + 纤维蛋白原1 + '\'' +
      ", 部分凝血活酶时间1='" + 部分凝血活酶时间1 + '\'' +
      ", 血小板计数1='" + 血小板计数1 + '\'' +
      ", 尿酸URIC1='" + 尿酸URIC1 + '\'' +
      ", 肌酐CREA1='" + 肌酐CREA1 + '\'' +
      ", 凝血因子活性1='" + 凝血因子活性1 + '\'' +
      ", 纤维蛋白原水平min1='" + 纤维蛋白原水平min1 + '\'' +
      ", 纤维蛋白原水平1='" + 纤维蛋白原水平1 + '\'' +
      ", 血小板功能1='" + 血小板功能1 + '\'' +
      ", 凝血综合参数1='" + 凝血综合参数1 + '\'' +
      ", 预测纤溶指标1='" + 预测纤溶指标1 + '\'' +
      ", 纤溶指标1='" + 纤溶指标1 + '\'' +
      ", 凝固时间1='" + 凝固时间1 + '\'' +
      ", 血块强度='" + 血块强度 + '\'' +
      ", TEG凝血因子活性1='" + TEG凝血因子活性1 + '\'' +
      ", TEG纤维蛋白原水平1='" + TEG纤维蛋白原水平1 + '\'' +
      ", TEG血小板功能1='" + TEG血小板功能1 + '\'' +
      ", TEG纤溶系统1='" + TEG纤溶系统1 + '\'' +
      ", 总胆固醇CHOL1='" + 总胆固醇CHOL1 + '\'' +
      ", 甘油三脂TG1='" + 甘油三脂TG1 + '\'' +
      ", 高密度脂蛋白胆固醇HDL1='" + 高密度脂蛋白胆固醇HDL1 + '\'' +
      ", 低密度脂蛋白胆固醇LDL1='" + 低密度脂蛋白胆固醇LDL1 + '\'' +
      ", 非高密度脂蛋白胆固醇NHDL1='" + 非高密度脂蛋白胆固醇NHDL1 + '\'' +
      ", 纤维蛋白原降解物术后第一天='" + 纤维蛋白原降解物术后第一天 + '\'' +
      ", D_D二聚体术后第一天='" + D_D二聚体术后第一天 + '\'' +
      ", 肌酐CREA术后第一天='" + 肌酐CREA术后第一天 + '\'' +
      ", 尿酸URIC术后第一天='" + 尿酸URIC术后第一天 + '\'' +
      '}';
  }

  public String toString2() {
    return
      "|PATIENT_ID" +
        "|VISIT_ID" +
        "|住院号" +
        "|PATIENT_NAME" +
        "|SEX" +
        "|AGE" +
        "|WARD_NAME" +
        "|主诊断" +
        "|其他诊断" +
        "|身高" +
        "|体重" +
        "|入院时间" +
        "|出院时间" +
        "|手术时间" +
        "|手术名称" +
        "|病理" +
        "|B超" +
        "|记录日期" +
        "|记录时间" +
        "|CAPRINI评分" +
        "|护理措施" +
        "|护理措施2" +
        "|护理措施3" +
        "|药品名" +
        "|年龄0至40岁" +
        "|年龄41至60岁" +
        "|年龄61至74岁" +
        "|年龄大于等于75岁" +
        "|肥胖即体质指数BMI大于25" +
        "|卧床时间小于72小时且持续步行少于30步" +
        "|卧床时间大于等于72小时且持续步行少于30步" +
        "|下肢肿胀目前或1个月内" +
        "|下肢静脉曲张目前或1个月内" +
        "|炎性肠病史如克隆氏病或溃疡性结肠炎" +
        "|充血性心力衰竭史" +
        "|严重肺病史如COPD或肺气肿或不包括哮喘" +
        "|恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者" +
        "|一月内或现在急性心肌梗死" +
        "|一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症" +
        "|一月内进行过全麻或局麻下大于等于45分钟的手术" +
        "|一月内或现在PICC置管或中心静脉置管" +
        "|一月内下肢石膏固定或其他原因限制下肢活动" +
        "|一月内下肢关节置换手术史" +
        "|一月内髋或骨盆或下肢骨折" +
        "|一月内严重创伤比如由于车祸或坠落导致的多处骨折" +
        "|一月内需长期卧床的脑卒中" +
        "|一月内急性脊髓损伤瘫痪" +
        "|VTE病史" +
        "|VTE家族史" +
        "|小手术即手术时间小于45分钟" +
        "|大手术即手术时间大于等于45分钟" +
        "|关节镜手术即手术时间大于等于45分钟" +
        "|腹腔鏡手术即手术时间大于等于45分钟" +
        "|怀孕或产后一个月内" +
        "|有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史" +
        "|正在口服避孕药或其他药物避孕措施" +
        "|狼疮抗凝物阳性括号获得性" +
        "|抗磷脂抗体阳性括号获得性" +
        "|高同型半胱氨酸血症括号获得性" +
        "|肝素诱导的血小板减少症括号获得性" +
        "|凝血因子VLEIDEN突变括号遗传性" +
        "|凝血酶原G20210A突变括号遗传性" +
        "|蛋白S斜杠C缺乏括号遗传性" +
        "|抗凝血酶III缺乏括号遗传性" +
        "|其他高凝状态比如血纤维蛋白原异常或红细胞增多症等" +
        "|纤维蛋白降解物1" +
        "|D_D二聚体" +
        "|凝血酶时间1" +
        "|凝血酶原时间1" +
        "|国际标准化比率1" +
        "|纤维蛋白原1" +
        "|部分凝血活酶时间1" +
        "|血小板计数1" +
        "|尿酸URIC1" +
        "|肌酐CREA1" +
        "|凝血因子活性1" +
        "|纤维蛋白原水平min1" +
        "|纤维蛋白原水平1" +
        "|血小板功能1" +
        "|凝血综合参数1" +
        "|预测纤溶指标1" +
        "|纤溶指标1" +
        "|凝固时间1" +
        "|血块强度" +
        "|TEG凝血因子活性1" +
        "|TEG纤维蛋白原水平1" +
        "|TEG血小板功能1" +
        "|TEG纤溶系统1" +
        "|总胆固醇CHOL1" +
        "|甘油三脂TG1" +
        "|高密度脂蛋白胆固醇HDL1" +
        "|低密度脂蛋白胆固醇LDL1" +
        "|非高密度脂蛋白胆固醇NHDL1" +
        "|纤维蛋白原降解物术后第一天" +
        "|D_D二聚体术后第一天" +
        "|肌酐CREA术后第一天" +
        "|尿酸URIC术后第一天";
  }

  public String toFormatString() {
    return
      PATIENT_ID + ' ' +
        VISIT_ID + ' ' +
        住院号 + ' ' +
        PATIENT_NAME + ' ' +
        SEX + ' ' +
        AGE + ' ' +
        WARD_NAME + ' ' +
        主诊断 + ' ' +
        其他诊断 + ' ' +
        身高 + ' ' +
        体重 + ' ' +
        入院时间 + ' ' +
        出院时间 + ' ' +
        手术时间 + ' ' +
        手术名称 + ' ' +
        病理 + ' ' +
        B超 + ' ' +
        记录日期 + ' ' +
        记录时间 + ' ' +
        CAPRINI评分 + ' ' +
        护理措施 + ' ' +
        护理措施2 + ' ' +
        护理措施3 + ' ' +
        药品名 + ' ' +
        年龄0至40岁 + ' ' +
        年龄41至60岁 + ' ' +
        年龄61至74岁 + ' ' +
        年龄大于等于75岁 + ' ' +
        肥胖即体质指数BMI大于25 + ' ' +
        卧床时间小于72小时且持续步行少于30步 + ' ' +
        卧床时间大于等于72小时且持续步行少于30步 + ' ' +
        下肢肿胀目前或1个月内 + ' ' +
        下肢静脉曲张目前或1个月内 + ' ' +
        炎性肠病史如克隆氏病或溃疡性结肠炎 + ' ' +
        充血性心力衰竭史 + ' ' +
        严重肺病史如COPD或肺气肿或不包括哮喘 + ' ' +
        恶性肿瘤或白血病或淋巴瘤或黑色素瘤且包含目前化疗或靶向治疗者 + ' ' +
        一月内或现在急性心肌梗死 + ' ' +
        一月内或现在需住院静脉输注抗生素治疗的严重感染比如肺炎或蜂窝织炎或败血症 + ' ' +
        一月内进行过全麻或局麻下大于等于45分钟的手术 + ' ' +
        一月内或现在PICC置管或中心静脉置管 + ' ' +
        一月内下肢关节置换手术史 + ' ' +
        一月内下肢石膏固定或其他原因限制下肢活动 + ' ' +
        一月内髋或骨盆或下肢骨折 + ' ' +
        一月内严重创伤比如由于车祸或坠落导致的多处骨折 + ' ' +
        一月内需长期卧床的脑卒中 + ' ' +
        一月内急性脊髓损伤瘫痪 + ' ' +
        VTE病史 + ' ' +
        VTE家族史 + ' ' +
        小手术即手术时间小于45分钟 + ' ' +
        大手术即手术时间大于等于45分钟 + ' ' +
        关节镜手术即手术时间大于等于45分钟 + ' ' +
        腹腔鏡手术即手术时间大于等于45分钟 + ' ' +
        怀孕或产后一个月内 + ' ' +
        有不明原因的死胎史或3次以上自然流产史或伴有先兆子痫的早产史或低体重儿生产史 + ' ' +
        正在口服避孕药或其他药物避孕措施 + ' ' +
        狼疮抗凝物阳性括号获得性 + ' ' +
        抗磷脂抗体阳性括号获得性 + ' ' +
        高同型半胱氨酸血症括号获得性 + ' ' +
        肝素诱导的血小板减少症括号获得性 + ' ' +
        凝血因子VLEIDEN突变括号遗传性 + ' ' +
        凝血酶原G20210A突变括号遗传性 + ' ' +
        蛋白S斜杠C缺乏括号遗传性 + ' ' +
        抗凝血酶III缺乏括号遗传性 + ' ' +
        其他高凝状态比如血纤维蛋白原异常或红细胞增多症等 + ' ' +
        纤维蛋白降解物1 + ' ' +
        D_D二聚体 + ' ' +
        凝血酶时间1 + ' ' +
        凝血酶原时间1 + ' ' +
        国际标准化比率1 + ' ' +
        纤维蛋白原1 + ' ' +
        部分凝血活酶时间1 + ' ' +
        血小板计数1 + ' ' +
        尿酸URIC1 + ' ' +
        肌酐CREA1 + ' ' +
        凝血因子活性1 + ' ' +
        纤维蛋白原水平min1 + ' ' +
        纤维蛋白原水平1 + ' ' +
        血小板功能1 + ' ' +
        凝血综合参数1 + ' ' +
        预测纤溶指标1 + ' ' +
        纤溶指标1 + ' ' +
        凝固时间1 + ' ' +
        血块强度 + ' ' +
        TEG凝血因子活性1 + ' ' +
        TEG纤维蛋白原水平1 + ' ' +
        TEG血小板功能1 + ' ' +
        TEG纤溶系统1 + ' ' +
        总胆固醇CHOL1 + ' ' +
        甘油三脂TG1 + ' ' +
        高密度脂蛋白胆固醇HDL1 + ' ' +
        低密度脂蛋白胆固醇LDL1 + ' ' +
        非高密度脂蛋白胆固醇NHDL1 + ' ' +
        纤维蛋白原降解物术后第一天 + ' ' +
        D_D二聚体术后第一天 + ' ' +
        肌酐CREA术后第一天 + ' ' +
        尿酸URIC术后第一天 + ' ';
  }

  // Add other setters/getters as needed
}
