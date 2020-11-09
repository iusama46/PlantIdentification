package co.usam.plantix.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsageDetail {

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("daily_limit")
    @Expose
    private Object dailyLimit;
    @SerializedName("weekly_limit")
    @Expose
    private Object weeklyLimit;
    @SerializedName("monthly_limit")
    @Expose
    private Object monthlyLimit;
    @SerializedName("total_limit")
    @Expose
    private Integer totalLimit;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("used_day")
    @Expose
    private Integer usedDay;
    @SerializedName("used_week")
    @Expose
    private Integer usedWeek;
    @SerializedName("used_month")
    @Expose
    private Integer usedMonth;
    @SerializedName("used_total")
    @Expose
    private Integer usedTotal;
    @SerializedName("remaining_day")
    @Expose
    private Object remainingDay;
    @SerializedName("remaining_week")
    @Expose
    private Object remainingWeek;
    @SerializedName("remaining_month")
    @Expose
    private Object remainingMonth;
    @SerializedName("remaining_total")
    @Expose
    private Integer remainingTotal;

    public UsageDetail() {
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Object getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(Object dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public Object getWeeklyLimit() {
        return weeklyLimit;
    }

    public void setWeeklyLimit(Object weeklyLimit) {
        this.weeklyLimit = weeklyLimit;
    }

    public Object getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(Object monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }

    public Integer getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(Integer totalLimit) {
        this.totalLimit = totalLimit;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Integer getUsedDay() {
        return usedDay;
    }

    public void setUsedDay(Integer usedDay) {
        this.usedDay = usedDay;
    }

    public Integer getUsedWeek() {
        return usedWeek;
    }

    public void setUsedWeek(Integer usedWeek) {
        this.usedWeek = usedWeek;
    }

    public Integer getUsedMonth() {
        return usedMonth;
    }

    public void setUsedMonth(Integer usedMonth) {
        this.usedMonth = usedMonth;
    }

    public Integer getUsedTotal() {
        return usedTotal;
    }

    public void setUsedTotal(Integer usedTotal) {
        this.usedTotal = usedTotal;
    }

    public Object getRemainingDay() {
        return remainingDay;
    }

    public void setRemainingDay(Object remainingDay) {
        this.remainingDay = remainingDay;
    }

    public Object getRemainingWeek() {
        return remainingWeek;
    }

    public void setRemainingWeek(Object remainingWeek) {
        this.remainingWeek = remainingWeek;
    }

    public Object getRemainingMonth() {
        return remainingMonth;
    }

    public void setRemainingMonth(Object remainingMonth) {
        this.remainingMonth = remainingMonth;
    }

    public Integer getRemainingTotal() {
        return remainingTotal;
    }

    public void setRemainingTotal(Integer remainingTotal) {
        this.remainingTotal = remainingTotal;
    }

}
