package per.yang;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public boolean full = true;

    protected void finalize(){

        if(!full){
            System.out.println("finalize");
        }
    }

    public static void main(String[] args ) throws Throwable {
        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setEticketNum("");
        ticketInfo.setTicketType(0);
        DateTime dateTime = new DateTime().minusDays(1);
        ticketInfo.setCreateTime(dateTime.toDate());
        ticketInfo.setLastUpdateTime(dateTime.toDate());
        ticketInfo.setPassengerName("万文杰");
        ticketInfo.setIssueType("ARL-D");

        ticketInfo.setOneFlightNum("SC4927");
        ticketInfo.setOneDepartureDate("09-07");
        ticketInfo.setOneDepartureTime("07:00");
        ticketInfo.setOneDepartureAirport("TNA");
        ticketInfo.setOneArrivalAirport("URC");
        ticketInfo.setOneArrivalTime("");
        ticketInfo.setOneCabin("T");
        ticketInfo.setOneRealFlightNum("SC4927");
        ticketInfo.setOneStatus("");
        ticketInfo.setOneStatusEnum(null);
        ticketInfo.setOneIcsPnr("");
        ticketInfo.setOneCrsPnr("PFGN25");

        ticketInfo.setTwoFlightNum("");
        ticketInfo.setTwoDepartureDate("");
        ticketInfo.setTwoDepartureTime("");
        ticketInfo.setTwoDepartureAirport("");
        ticketInfo.setTwoArrivalAirport("");
        ticketInfo.setTwoArrivalTime("");
        ticketInfo.setTwoCabin("");
        ticketInfo.setTwoRealFlightNum("");
        ticketInfo.setTwoStatus("");
        ticketInfo.setTwoStatusEnum(null);
        ticketInfo.setTwoIcsPnr("");
        ticketInfo.setTwoCrsPnr("");
        ticketInfo.setDetrResponse("DETR:TN/324-2391528108\n" +
                "ISSUED BY:                           ORG/DST: TNA/URC                 ARL-D\n" +
                "E/R: 不得签转/改期退票收费\n" +
                "TOUR CODE:  ESCb\n" +
                "PASSENGER: 万文杰\n" +
                "EXCH:                               CONJ TKT:\n" +
                "O FM:1TNA SC    4927  T 07SEP 0700 OK T/TNA16T29 07SEP6/07SEP6 20K OPEN FOR USE      --T2 RL:PFGN25  /\n" +
                "  TO: URC   ESCb\n" +
                "FC: ESCb\n" +
                "FARE:                      |FOP:\n" +
                "TAX:                       |OI:\n" +
                "TOTAL:                     |TKTN: 324-2391528108\n" +
                "    ESCb\n" +
                "^^ESCb");

        ticketInfo.setTicketOffice(null);
        ticketInfo.setIssueTime(null);
        ticketInfo.setIssuePlace(null);
        ticketInfo.setTicketPrice(null);
        ticketInfo.setConstructionFee(null);
        ticketInfo.setFuelTax(null);
        ticketInfo.setDetrsResponse(null);

        ticketInfo.setPassengerType("");
        ticketInfo.setTicketStatus("OK");
        ticketInfo.setReturnTicketStatus(null);
        ticketInfo.setOneFinalStatus(2);
        ticketInfo.setTwoFinalStatus(0);
        ticketInfo.setLuggageWeight("20K");
        ticketInfo.setReturnLuggageWeight("");

        ticketInfo.setExchTicket("");
        ticketInfo.setTicketRules("不得签转/改期\n" +
                "退票收费");

        ticketInfo.setExceptionStatus(null);
        ticketInfo.setExceptionMsg(null);


        int i = 1000000000;
        for(TicketInfo.TicketStatus status : TicketInfo.TicketStatus.values()){
            i++;
            ticketInfo.setEticketNum(String.valueOf(i));
            ticketInfo.setOneStatusEnum(status);
            Map<String, TicketInfo> ticketInfoMap = Maps.newHashMap();
            ticketInfoMap.put(ticketInfo.getEticketNum(), ticketInfo);
            if(status.equals(TicketInfo.TicketStatus.UNKNOWN)){
                ticketInfo.setDetrResponse(null);
            }
            System.out.println("** " + status);
            System.out.println("{code}");
            System.out.println(JSON.toJSONString(ticketInfoMap));
            System.out.println("{code}");
        }

        String s = "DETR TN/7818787023068,F\n" + "NAME: 李节华   TKTN:7818787023068\n" + "RCPT:\n" + "1   RP1222065387";
        String d = "1   RP1222065387";

    }

}
