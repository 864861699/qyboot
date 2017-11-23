package com.ax.service.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class AchievementDyyDetails {
    private Integer id;

    private BigDecimal baseMoney;

    private Integer class2;

    private String class2Name;

    private BigDecimal achievement;

    private BigDecimal commission;

    private String customName;

    private String month;

    private BigDecimal tidian;

    private String grade;

    private BigDecimal performance;

    private BigDecimal specialMoney;

    private String username;

    private Integer userid;

    private Integer checkstatus;

    private Date joindate;

    private Integer dirid;

    private Integer type;

    private Integer moneyType;

    private Integer uesrtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBaseMoney() {
        return baseMoney;
    }

    public void setBaseMoney(BigDecimal baseMoney) {
        this.baseMoney = baseMoney;
    }

    public Integer getClass2() {
        return class2;
    }

    public void setClass2(Integer class2) {
        this.class2 = class2;
    }

    public String getClass2Name() {
        return class2Name;
    }

    public void setClass2Name(String class2Name) {
        this.class2Name = class2Name == null ? null : class2Name.trim();
    }

    public BigDecimal getAchievement() {
        return achievement;
    }

    public void setAchievement(BigDecimal achievement) {
        this.achievement = achievement;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public BigDecimal getTidian() {
        return tidian;
    }

    public void setTidian(BigDecimal tidian) {
        this.tidian = tidian;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public BigDecimal getSpecialMoney() {
        return specialMoney;
    }

    public void setSpecialMoney(BigDecimal specialMoney) {
        this.specialMoney = specialMoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Integer getDirid() {
        return dirid;
    }

    public void setDirid(Integer dirid) {
        this.dirid = dirid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(Integer moneyType) {
        this.moneyType = moneyType;
    }

    public Integer getUesrtype() {
        return uesrtype;
    }

    public void setUesrtype(Integer uesrtype) {
        this.uesrtype = uesrtype;
    }
}