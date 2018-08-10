package per.yang.lock;

import java.util.Date;

/**
 * Created by songbao.yang on 2016/12/28.
 */
public class TicketInfo {

    private static final long serialVersionUID = 2739256012931423618L;
    private String eticketNum;
    private int ticketType;
    private Date createTime;
    private Date lastUpdateTime;
    private String passengerName;
    private String issueType;
    private String oneFlightNum;
    private String oneDepartureDate;
    private String oneDepartureTime;
    private String oneDepartureAirport;
    private String oneArrivalAirport;
    private String oneArrivalTime;
    private String oneCabin;
    private String oneRealFlightNum;
    private String oneStatus;
    private TicketInfo.TicketStatus oneStatusEnum;
    private String oneIcsPnr;
    private String oneCrsPnr;
    private String twoFlightNum;
    private String twoDepartureDate;
    private String twoDepartureTime;
    private String twoDepartureAirport;
    private String twoArrivalAirport;
    private String twoArrivalTime;
    private String twoCabin;
    private String twoRealFlightNum;
    private String twoStatus;
    private TicketInfo.TicketStatus twoStatusEnum;
    private String twoIcsPnr;
    private String twoCrsPnr;
    private String threeFlightNum;
    private String threeDepartureDate;
    private String threeDepartureTime;
    private String threeDepartureAirport;
    private String threeArrivalAirport;
    private String threeArrivalTime;
    private String threeCabin;
    private String threeRealFlightNum;
    private String threeStatus;
    private TicketInfo.TicketStatus threeStatusEnum;
    private String threeIcsPnr;
    private String threeCrsPnr;
    private String fourFlightNum;
    private String fourDepartureDate;
    private String fourDepartureTime;
    private String fourDepartureAirport;
    private String fourArrivalAirport;
    private String fourArrivalTime;
    private String fourCabin;
    private String fourRealFlightNum;
    private String fourStatus;
    private TicketInfo.TicketStatus fourStatusEnum;
    private String fourIcsPnr;
    private String fourCrsPnr;
    private String detrResponse;
    private String ticketOffice;
    private String issueTime;
    private String issuePlace;
    private String ticketPrice;
    private String constructionFee;
    private String fuelTax;
    private String detrsResponse;
    private String passengerType;
    private String ticketStatus;
    private String returnTicketStatus;
    private int oneFinalStatus;
    private int twoFinalStatus;
    private int threeFinalStatus;
    private int fourFinalStatus;
    private String luggageWeight;
    private String returnLuggageWeight;
    private String exchTicket;
    private String ticketRules;
    private String exceptionStatus;
    private String exceptionMsg;

    public TicketInfo() {
    }

    public int getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getIssueType() {
        return this.issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getOneIcsPnr() {
        return this.oneIcsPnr;
    }

    public void setOneIcsPnr(String oneIcsPnr) {
        this.oneIcsPnr = oneIcsPnr;
    }

    public String getOneCrsPnr() {
        return this.oneCrsPnr;
    }

    public void setOneCrsPnr(String oneCrsPnr) {
        this.oneCrsPnr = oneCrsPnr;
    }

    public String getTwoIcsPnr() {
        return this.twoIcsPnr;
    }

    public void setTwoIcsPnr(String twoIcsPnr) {
        this.twoIcsPnr = twoIcsPnr;
    }

    public String getTwoCrsPnr() {
        return this.twoCrsPnr;
    }

    public void setTwoCrsPnr(String twoCrsPnr) {
        this.twoCrsPnr = twoCrsPnr;
    }

    public TicketInfo.TicketStatus getOneStatusEnum() {
        return this.oneStatusEnum;
    }

    public void setOneStatusEnum(TicketInfo.TicketStatus oneStatusEnum) {
        this.oneStatusEnum = oneStatusEnum;
    }

    public TicketInfo.TicketStatus getTwoStatusEnum() {
        return this.twoStatusEnum;
    }

    public void setTwoStatusEnum(TicketInfo.TicketStatus twoStatusEnum) {
        this.twoStatusEnum = twoStatusEnum;
    }

    public String getEticketNum() {
        return this.eticketNum;
    }

    public void setEticketNum(String eticketNum) {
        this.eticketNum = eticketNum;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getOneFlightNum() {
        return this.oneFlightNum;
    }

    public void setOneFlightNum(String oneFlightNum) {
        this.oneFlightNum = oneFlightNum;
    }

    public String getOneDepartureDate() {
        return this.oneDepartureDate;
    }

    public void setOneDepartureDate(String oneDepartureDate) {
        this.oneDepartureDate = oneDepartureDate;
    }

    public String getOneDepartureTime() {
        return this.oneDepartureTime;
    }

    public void setOneDepartureTime(String oneDepartureTime) {
        this.oneDepartureTime = oneDepartureTime;
    }

    public String getOneDepartureAirport() {
        return this.oneDepartureAirport;
    }

    public void setOneDepartureAirport(String oneDepartureAirport) {
        this.oneDepartureAirport = oneDepartureAirport;
    }

    public String getOneArrivalAirport() {
        return this.oneArrivalAirport;
    }

    public void setOneArrivalAirport(String oneArrivalAirport) {
        this.oneArrivalAirport = oneArrivalAirport;
    }

    public String getOneArrivalTime() {
        return this.oneArrivalTime;
    }

    public void setOneArrivalTime(String oneArrivalTime) {
        this.oneArrivalTime = oneArrivalTime;
    }

    public String getOneCabin() {
        return this.oneCabin;
    }

    public void setOneCabin(String oneCabin) {
        this.oneCabin = oneCabin;
    }

    public String getOneRealFlightNum() {
        return this.oneRealFlightNum;
    }

    public void setOneRealFlightNum(String oneRealFlightNum) {
        this.oneRealFlightNum = oneRealFlightNum;
    }

    public String getOneStatus() {
        return this.oneStatus;
    }

    public void setOneStatus(String oneStatus) {
        this.oneStatus = oneStatus;
    }

    public String getTwoFlightNum() {
        return this.twoFlightNum;
    }

    public void setTwoFlightNum(String twoFlightNum) {
        this.twoFlightNum = twoFlightNum;
    }

    public String getTwoDepartureDate() {
        return this.twoDepartureDate;
    }

    public void setTwoDepartureDate(String twoDepartureDate) {
        this.twoDepartureDate = twoDepartureDate;
    }

    public String getTwoDepartureTime() {
        return this.twoDepartureTime;
    }

    public void setTwoDepartureTime(String twoDepartureTime) {
        this.twoDepartureTime = twoDepartureTime;
    }

    public String getTwoDepartureAirport() {
        return this.twoDepartureAirport;
    }

    public void setTwoDepartureAirport(String twoDepartureAirport) {
        this.twoDepartureAirport = twoDepartureAirport;
    }

    public String getTwoArrivalAirport() {
        return this.twoArrivalAirport;
    }

    public void setTwoArrivalAirport(String twoArrivalAirport) {
        this.twoArrivalAirport = twoArrivalAirport;
    }

    public String getTwoArrivalTime() {
        return this.twoArrivalTime;
    }

    public void setTwoArrivalTime(String twoArrivalTime) {
        this.twoArrivalTime = twoArrivalTime;
    }

    public String getTwoCabin() {
        return this.twoCabin;
    }

    public void setTwoCabin(String twoCabin) {
        this.twoCabin = twoCabin;
    }

    public String getTwoRealFlightNum() {
        return this.twoRealFlightNum;
    }

    public void setTwoRealFlightNum(String twoRealFlightNum) {
        this.twoRealFlightNum = twoRealFlightNum;
    }

    public String getTwoStatus() {
        return this.twoStatus;
    }

    public void setTwoStatus(String twoStatus) {
        this.twoStatus = twoStatus;
    }

    public String getDetrResponse() {
        return this.detrResponse;
    }

    public void setDetrResponse(String detrResponse) {
        this.detrResponse = detrResponse;
    }

    public String getTicketOffice() {
        return this.ticketOffice;
    }

    public void setTicketOffice(String ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public String getIssueTime() {
        return this.issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssuePlace() {
        return this.issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getTicketPrice() {
        return this.ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getConstructionFee() {
        return this.constructionFee;
    }

    public void setConstructionFee(String constructionFee) {
        this.constructionFee = constructionFee;
    }

    public String getFuelTax() {
        return this.fuelTax;
    }

    public void setFuelTax(String fuelTax) {
        this.fuelTax = fuelTax;
    }

    public String getDetrsResponse() {
        return this.detrsResponse;
    }

    public void setDetrsResponse(String detrsResponse) {
        this.detrsResponse = detrsResponse;
    }

    public String getExceptionStatus() {
        return this.exceptionStatus;
    }

    public void setExceptionStatus(String exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public int getOneFinalStatus() {
        return this.oneFinalStatus;
    }

    public void setOneFinalStatus(int oneFinalStatus) {
        this.oneFinalStatus = oneFinalStatus;
    }

    public int getTwoFinalStatus() {
        return this.twoFinalStatus;
    }

    public void setTwoFinalStatus(int twoFinalStatus) {
        this.twoFinalStatus = twoFinalStatus;
    }

    public String getPassengerType() {
        return this.passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getReturnTicketStatus() {
        return this.returnTicketStatus;
    }

    public void setReturnTicketStatus(String returnTicketStatus) {
        this.returnTicketStatus = returnTicketStatus;
    }

    public String getLuggageWeight() {
        return this.luggageWeight;
    }

    public void setLuggageWeight(String luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public String getReturnLuggageWeight() {
        return this.returnLuggageWeight;
    }

    public void setReturnLuggageWeight(String returnLuggageWeight) {
        this.returnLuggageWeight = returnLuggageWeight;
    }

    public String getExchTicket() {
        return this.exchTicket;
    }

    public void setExchTicket(String exchTicket) {
        this.exchTicket = exchTicket;
    }

    public String getTicketRules() {
        return this.ticketRules;
    }

    public void setTicketRules(String ticketRules) {
        this.ticketRules = ticketRules;
    }

    public String getThreeFlightNum() {
        return this.threeFlightNum;
    }

    public void setThreeFlightNum(String threeFlightNum) {
        this.threeFlightNum = threeFlightNum;
    }

    public String getThreeDepartureDate() {
        return this.threeDepartureDate;
    }

    public void setThreeDepartureDate(String threeDepartureDate) {
        this.threeDepartureDate = threeDepartureDate;
    }

    public String getThreeDepartureTime() {
        return this.threeDepartureTime;
    }

    public void setThreeDepartureTime(String threeDepartureTime) {
        this.threeDepartureTime = threeDepartureTime;
    }

    public String getThreeDepartureAirport() {
        return this.threeDepartureAirport;
    }

    public void setThreeDepartureAirport(String threeDepartureAirport) {
        this.threeDepartureAirport = threeDepartureAirport;
    }

    public String getThreeArrivalAirport() {
        return this.threeArrivalAirport;
    }

    public void setThreeArrivalAirport(String threeArrivalAirport) {
        this.threeArrivalAirport = threeArrivalAirport;
    }

    public String getThreeArrivalTime() {
        return this.threeArrivalTime;
    }

    public void setThreeArrivalTime(String threeArrivalTime) {
        this.threeArrivalTime = threeArrivalTime;
    }

    public String getThreeCabin() {
        return this.threeCabin;
    }

    public void setThreeCabin(String threeCabin) {
        this.threeCabin = threeCabin;
    }

    public String getThreeRealFlightNum() {
        return this.threeRealFlightNum;
    }

    public void setThreeRealFlightNum(String threeRealFlightNum) {
        this.threeRealFlightNum = threeRealFlightNum;
    }

    public String getThreeStatus() {
        return this.threeStatus;
    }

    public void setThreeStatus(String threeStatus) {
        this.threeStatus = threeStatus;
    }

    public String getThreeIcsPnr() {
        return this.threeIcsPnr;
    }

    public void setThreeIcsPnr(String threeIcsPnr) {
        this.threeIcsPnr = threeIcsPnr;
    }

    public String getThreeCrsPnr() {
        return this.threeCrsPnr;
    }

    public void setThreeCrsPnr(String threeCrsPnr) {
        this.threeCrsPnr = threeCrsPnr;
    }

    public String getFourFlightNum() {
        return this.fourFlightNum;
    }

    public void setFourFlightNum(String fourFlightNum) {
        this.fourFlightNum = fourFlightNum;
    }

    public String getFourDepartureDate() {
        return this.fourDepartureDate;
    }

    public void setFourDepartureDate(String fourDepartureDate) {
        this.fourDepartureDate = fourDepartureDate;
    }

    public String getFourDepartureTime() {
        return this.fourDepartureTime;
    }

    public void setFourDepartureTime(String fourDepartureTime) {
        this.fourDepartureTime = fourDepartureTime;
    }

    public String getFourDepartureAirport() {
        return this.fourDepartureAirport;
    }

    public void setFourDepartureAirport(String fourDepartureAirport) {
        this.fourDepartureAirport = fourDepartureAirport;
    }

    public String getFourArrivalAirport() {
        return this.fourArrivalAirport;
    }

    public void setFourArrivalAirport(String fourArrivalAirport) {
        this.fourArrivalAirport = fourArrivalAirport;
    }

    public String getFourArrivalTime() {
        return this.fourArrivalTime;
    }

    public void setFourArrivalTime(String fourArrivalTime) {
        this.fourArrivalTime = fourArrivalTime;
    }

    public String getFourCabin() {
        return this.fourCabin;
    }

    public void setFourCabin(String fourCabin) {
        this.fourCabin = fourCabin;
    }

    public String getFourRealFlightNum() {
        return this.fourRealFlightNum;
    }

    public void setFourRealFlightNum(String fourRealFlightNum) {
        this.fourRealFlightNum = fourRealFlightNum;
    }

    public String getFourStatus() {
        return this.fourStatus;
    }

    public void setFourStatus(String fourStatus) {
        this.fourStatus = fourStatus;
    }

    public String getFourIcsPnr() {
        return this.fourIcsPnr;
    }

    public void setFourIcsPnr(String fourIcsPnr) {
        this.fourIcsPnr = fourIcsPnr;
    }

    public String getFourCrsPnr() {
        return this.fourCrsPnr;
    }

    public void setFourCrsPnr(String fourCrsPnr) {
        this.fourCrsPnr = fourCrsPnr;
    }

    public TicketInfo.TicketStatus getThreeStatusEnum() {
        return this.threeStatusEnum;
    }

    public void setThreeStatusEnum(TicketInfo.TicketStatus threeStatusEnum) {
        this.threeStatusEnum = threeStatusEnum;
    }

    public TicketInfo.TicketStatus getFourStatusEnum() {
        return this.fourStatusEnum;
    }

    public void setFourStatusEnum(TicketInfo.TicketStatus fourStatusEnum) {
        this.fourStatusEnum = fourStatusEnum;
    }

    public int getThreeFinalStatus() {
        return this.threeFinalStatus;
    }

    public void setThreeFinalStatus(int threeFinalStatus) {
        this.threeFinalStatus = threeFinalStatus;
    }

    public int getFourFinalStatus() {
        return this.fourFinalStatus;
    }

    public void setFourFinalStatus(int fourFinalStatus) {
        this.fourFinalStatus = fourFinalStatus;
    }

    public String toString() {
        return "TicketInfo{eticketNum=\'" + this.eticketNum + '\'' + ", ticketType=" + this.ticketType + ", createTime=" + this.createTime + ", lastUpdateTime=" + this.lastUpdateTime + ", passengerName=\'" + this.passengerName + '\'' + ", issueType=\'" + this.issueType + '\'' + ", oneFlightNum=\'" + this.oneFlightNum + '\'' + ", oneDepartureDate=\'" + this.oneDepartureDate + '\'' + ", oneDepartureTime=\'" + this.oneDepartureTime + '\'' + ", oneDepartureAirport=\'" + this.oneDepartureAirport + '\'' + ", oneArrivalAirport=\'" + this.oneArrivalAirport + '\'' + ", oneArrivalTime=\'" + this.oneArrivalTime + '\'' + ", oneCabin=\'" + this.oneCabin + '\'' + ", oneRealFlightNum=\'" + this.oneRealFlightNum + '\'' + ", oneStatus=\'" + this.oneStatus + '\'' + ", oneStatusEnum=" + this.oneStatusEnum + ", oneIcsPnr=\'" + this.oneIcsPnr + '\'' + ", oneCrsPnr=\'" + this.oneCrsPnr + '\'' + ", twoFlightNum=\'" + this.twoFlightNum + '\'' + ", twoDepartureDate=\'" + this.twoDepartureDate + '\'' + ", twoDepartureTime=\'" + this.twoDepartureTime + '\'' + ", twoDepartureAirport=\'" + this.twoDepartureAirport + '\'' + ", twoArrivalAirport=\'" + this.twoArrivalAirport + '\'' + ", twoArrivalTime=\'" + this.twoArrivalTime + '\'' + ", twoCabin=\'" + this.twoCabin + '\'' + ", twoRealFlightNum=\'" + this.twoRealFlightNum + '\'' + ", twoStatus=\'" + this.twoStatus + '\'' + ", twoStatusEnum=" + this.twoStatusEnum + ", twoIcsPnr=\'" + this.twoIcsPnr + '\'' + ", twoCrsPnr=\'" + this.twoCrsPnr + '\'' + ", threeFlightNum=\'" + this.threeFlightNum + '\'' + ", threeDepartureDate=\'" + this.threeDepartureDate + '\'' + ", threeDepartureTime=\'" + this.threeDepartureTime + '\'' + ", threeDepartureAirport=\'" + this.threeDepartureAirport + '\'' + ", threeArrivalAirport=\'" + this.threeArrivalAirport + '\'' + ", threeArrivalTime=\'" + this.threeArrivalTime + '\'' + ", threeCabin=\'" + this.threeCabin + '\'' + ", threeRealFlightNum=\'" + this.threeRealFlightNum + '\'' + ", threeStatus=\'" + this.threeStatus + '\'' + ", threeStatusEnum=" + this.threeStatusEnum + ", threeIcsPnr=\'" + this.threeIcsPnr + '\'' + ", threeCrsPnr=\'" + this.threeCrsPnr + '\'' + ", fourFlightNum=\'" + this.fourFlightNum + '\'' + ", fourDepartureDate=\'" + this.fourDepartureDate + '\'' + ", fourDepartureTime=\'" + this.fourDepartureTime + '\'' + ", fourDepartureAirport=\'" + this.fourDepartureAirport + '\'' + ", fourArrivalAirport=\'" + this.fourArrivalAirport + '\'' + ", fourArrivalTime=\'" + this.fourArrivalTime + '\'' + ", fourCabin=\'" + this.fourCabin + '\'' + ", fourRealFlightNum=\'" + this.fourRealFlightNum + '\'' + ", fourStatus=\'" + this.fourStatus + '\'' + ", fourStatusEnum=" + this.fourStatusEnum + ", fourIcsPnr=\'" + this.fourIcsPnr + '\'' + ", fourCrsPnr=\'" + this.fourCrsPnr + '\'' + ", detrResponse=\'" + this.detrResponse + '\'' + ", ticketOffice=\'" + this.ticketOffice + '\'' + ", issueTime=\'" + this.issueTime + '\'' + ", issuePlace=\'" + this.issuePlace + '\'' + ", ticketPrice=\'" + this.ticketPrice + '\'' + ", constructionFee=\'" + this.constructionFee + '\'' + ", fuelTax=\'" + this.fuelTax + '\'' + ", detrsResponse=\'" + this.detrsResponse + '\'' + ", passengerType=\'" + this.passengerType + '\'' + ", ticketStatus=\'" + this.ticketStatus + '\'' + ", returnTicketStatus=\'" + this.returnTicketStatus + '\'' + ", oneFinalStatus=" + this.oneFinalStatus + ", twoFinalStatus=" + this.twoFinalStatus + ", threeFinalStatus=" + this.threeFinalStatus + ", fourFinalStatus=" + this.fourFinalStatus + ", luggageWeight=\'" + this.luggageWeight + '\'' + ", returnLuggageWeight=\'" + this.returnLuggageWeight + '\'' + ", exchTicket=\'" + this.exchTicket + '\'' + ", ticketRules=\'" + this.ticketRules + '\'' + ", exceptionStatus=\'" + this.exceptionStatus + '\'' + ", exceptionMsg=\'" + this.exceptionMsg + '\'' + '}';
    }

    public static enum TicketStatus {
        OPEN_FOR_USE(1, "xxxxx"),
        CHECKED_IN(2, "CHECKED_IN"),
        LIFT_BOARDED(3, "LIFT_BOARDED"),
        USED_FLOWN(4, "USED_FLOWN"),
        REFUNDED(5, "REFUNDED"),
        PRINT_EXCH(6, "PRINT_EXCH"),
        EXCHANGED(7, "EXCHANGED"),
        PAPER_TICKET(8, "PAPER_TICKET"),
        FIM_EXCH(9, "FIM_EXCH"),
        SUSPENDED(10, "SUSPENDED"),
        VOID(11, "VOID"),
        CPN_NOTE(12, "CPN_NOTE"),
        AIRP_CNTL(13, "AIRP_CNTL"),
        EXPIRE(14, "EXPIRE"),
        UNKNOWN(15, "UNKNOWN");

        int type;
        String desc;

        private TicketStatus(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public int getType() {
            return this.type;
        }

        public String getDesc() {
            return this.desc;
        }
    }
}
