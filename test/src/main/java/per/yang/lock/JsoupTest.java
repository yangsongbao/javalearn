package per.yang.lock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * Created by songbao.yang on 2017/6/5.
 */
public class JsoupTest {

    public static void main(String[] args) {

        JsoupTest jsoupTest = new JsoupTest();
//        Map<String, String> flightHrefs = jsoupTest.getFlightHrefs();
//        Map<String, List<String>> jobNames = jsoupTest.getJobNames(flightHrefs);

//        List<String> delivery_domestic_tts_detail_node = jsoupTest.getGitName("room_f_fuwu_betad");

        Map<String, String> flightHrefs = jsoupTest.getFlightHrefs();
        Map<String, List<String>> jobNames = jsoupTest.getJobNames(flightHrefs);

        Map<String, Set<String>> groups = Maps.newHashMap();
        for (String key : jobNames.keySet()){
            Set<String> gitGroups = Sets.newHashSet();
            List<String> jogNameList = jobNames.get(key);
            for (String jobName : jogNameList){
                List<String> gitNames = jsoupTest.getGitName(jobName);
                for (String gitName : gitNames){
                    String gitGroup = jsoupTest.getGitGroup(gitName);
                    if (gitGroup != null){
                        gitGroups.add(gitGroup);
                    }
                }
            }
            groups.put(key, gitGroups);
        }
        System.out.println(JSONObject.toJSON(groups));

        Set<String> groupList = Sets.newHashSet();
        for (String key : groups.keySet()){
            Set<String> strings = groups.get(key);
            Iterator<String> iterator = strings.iterator();
            while (iterator.hasNext()){
                groupList.add(iterator.next());
            }
        }

        System.out.println(JSONObject.toJSON(groupList));
    }

    private Map<String,String> getCookies(){
        String cookie = "screenResolution=1366x768;  QN99=9780; QunarGlobal=10.86.213.152_-5b0064b7_15c16344411_375b|1495022681422; QN601=3cf899b88345082447891d87b506eee3; QN269=0229C8D03AF911E7B697FA163E069637; QN48=tc_07e16eef937345fc_15c164bc3dc_8150; QN235=2017-05-18; QN43=4; QN42=%E6%AC%A7%E9%98%B3%E4%B8%8A%E5%A4%A9; _q=U.lbov8072; _t=25046328; csrfToken=v9a3GpWvSRAp8xMeCzZjWkxOhuCPJynI; _s=s_PJINSU7A53SX23RM6G7E6BCUAU; _v=sds8J7HCRQKagorl3DbsYqRtNgVspOQGf-vyOxToLuAS48Ie6gUJP0ZlVj5PP3CDi1W7yO2Qn-i4tCYCTy6Ar5O5ih4jW5JrReyqfneEJG3ywZmsu-7u4Dc72c2_jrfzE5963v0Vs8lpmRodapVtiNdJh5KwoS9U7IY_qKTNELsy;  QN205=organic; QN621=1490067914133%3DDEFAULT%26fr%3Dflight_dom_search; SignOnDefault=songbao.yang; iconSize=16x16; _mdp=773B2E66C07643ACD909120FDB3845FE; _uf=lbov8072; Hm_lvt_75154a8409c0f82ecd97d538ff0ab3f3=1495022683,1495159856,1496633110; _i=ue-xY4nn6VTXXX7APYP5__x__CfX; _vi=TsKAcmS8ACcgjBKO90T0HZUmCNY-TcncgzDu-Gcmj_qhMHLyQdotEgp2V-wn2xCYBNhn0cx18RlJaDibOmAfHV3O4_QYSi_H-Nv5fyDFwgv2mO3mUKGEX5mz6cZobdykbUpftwHMsdP0IGwiYOoPC-1TBIdmRH5-w-q_OxIRqNp3; screenResolution=1366x768; JSESSIONID=DDCE493E3D275FB9C545E158326BC412";
        Map<String, String> split = Splitter.on(";").withKeyValueSeparator("=").split(cookie);
        Map cookieMap = Maps.newHashMap();
        for (String key : split.keySet()){
            String value = split.get(key);
            cookieMap.put(key.trim(), value.trim());
        }
        cookieMap.put("QN1", "dXrgilkcC40gQ+IfLiM4Ag==");
        cookieMap.put("ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE", "\"c29uZ2Jhby55YW5nOjE0OTc0MzQyOTU4MTk6YmVlY2VjZmEzNmQ4Y2YyZjA3ZmNhOTBiY2I5MTU2ODczMGIwZjc5NGIxOWNlZWYyNGZjNzVmNzMzOGE1OWQxZg==\"");
        return cookieMap;
    }

    private Map<String, String> getCookies2(){
        String cookie = "screenResolution=1366x768; QN99=9780; QunarGlobal=10.86.213.152_-5b0064b7_15c16344411_375b|1495022681422; QN601=3cf899b88345082447891d87b506eee3; QN269=0229C8D03AF911E7B697FA163E069637; QN48=tc_07e16eef937345fc_15c164bc3dc_8150; QN235=2017-05-18; QN43=4; QN42=%E6%AC%A7%E9%98%B3%E4%B8%8A%E5%A4%A9; _q=U.lbov8072; _t=25046328; csrfToken=v9a3GpWvSRAp8xMeCzZjWkxOhuCPJynI; _s=s_PJINSU7A53SX23RM6G7E6BCUAU; _v=sds8J7HCRQKagorl3DbsYqRtNgVspOQGf-vyOxToLuAS48Ie6gUJP0ZlVj5PP3CDi1W7yO2Qn-i4tCYCTy6Ar5O5ih4jW5JrReyqfneEJG3ywZmsu-7u4Dc72c2_jrfzE5963v0Vs8lpmRodapVtiNdJh5KwoS9U7IY_qKTNELsy;  QN205=organic; QN621=1490067914133%3DDEFAULT%26fr%3Dflight_dom_search; iconSize=16x16; _mdp=773B2E66C07643ACD909120FDB3845FE; _uf=lbov8072; Hm_lvt_75154a8409c0f82ecd97d538ff0ab3f3=1495022683,1495159856,1496633110; _i=ue-xY4nn6VTXXX7APYP5__x__CfX; _vi=TsKAcmS8ACcgjBKO90T0HZUmCNY-TcncgzDu-Gcmj_qhMHLyQdotEgp2V-wn2xCYBNhn0cx18RlJaDibOmAfHV3O4_QYSi_H-Nv5fyDFwgv2mO3mUKGEX5mz6cZobdykbUpftwHMsdP0IGwiYOoPC-1TBIdmRH5-w-q_OxIRqNp3; SignOnDefault=songbao.yang; HPTabName=DEFAULT; HPTabNameRemote=; LastActiveTab=DEFAULT; http%3a%2f%2fehr.corp.qunar.com%2fpsp%2fhcmprd%2femployee%2fhrms%2frefresh=list:%20%3Ftab%3Dhc_ux_manager_dashboard%7C%3Frp%3Dhc_ux_manager_dashboard%7C%3Ftab%3Dremoteunifieddashboard%7C%3Frp%3Dremoteunifieddashboard; ExpirePage=; PS_LOGINLIST=; PS_TOKENEXPIRE=; psback=; ps_theme=; l-pswebapp1-8000-PORTAL-PSJSESSIONID=9i520OBtqc6clCxiyza7NXraAfJrd2Rs!1783521729; JSESSIONID=F506454BF343737D56C14115A24C07B1; screenResolution=1366x768";
        Map<String, String> split = Splitter.on(";").withKeyValueSeparator("=").split(cookie);
        Map cookieMap = Maps.newHashMap();
        for (String key : split.keySet()){
            String value = split.get(key);
            cookieMap.put(key.trim(), value.trim());
        }
        cookieMap.put("QN1", "dXrgilkcC40gQ+IfLiM4Ag==");
        cookieMap.put("ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE", "\"c29uZ2Jhby55YW5nOjE0OTc0MzQyOTU4MTk6YmVlY2VjZmEzNmQ4Y2YyZjA3ZmNhOTBiY2I5MTU2ODczMGIwZjc5NGIxOWNlZWYyNGZjNzVmNzMzOGE1OWQxZg==\"");
        return cookieMap;
    }

    private Map<String, String> getFlightHrefs(){

        Map<String, String> cookieMap = getCookies();
        Connection connect = Jsoup.connect("http://qdr.corp.qunar.com/view/f%E6%9C%BA%E7%A5%A8/");
        connect = connect.cookies(cookieMap);
        try {
            Document document = connect.get();
            Element projectstatus = document.getElementById("projectstatus");
            Element tbody = projectstatus.child(0);

            Elements hrefs = tbody.getElementsByAttribute("href");

            Map<String, String> flightHrefs = Maps.newHashMap();
            for (int i = 0; i < hrefs.size(); i++) {
                Element element = hrefs.get(i);
                String text = element.ownText();
                flightHrefs.put(text, element.attr("href"));
            }
            return flightHrefs;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Map<String, List<String>> getJobNames(Map<String, String> flightHrefs){

        Map<String, String> cookies = getCookies2();
        Map<String, List<String>> department2Jobs = Maps.newHashMap();
        for (String key : flightHrefs.keySet()){
            Connection connect = Jsoup.connect("http://qdr.corp.qunar.com" + flightHrefs.get(key));
            connect = connect.cookies(cookies);
            try {
                Document document = connect.get();
                List<String> jobNames = parse2JobNames(document);
                department2Jobs.put(key, jobNames);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return department2Jobs;
    }

    private List<String> parse2JobNames(Document document){
        if (document == null){
            return null;
        }
        Element projectstatus = document.getElementById("projectstatus");
        Element tbody = projectstatus.child(0);
        Elements elements = tbody.getElementsByAttributeValueStarting("id", "job_");

        List<String> jobNames = Lists.newArrayList();
        for (Element element : elements){
            String idValue = element.attr("id");
            String jobName = idValue.substring(4);
            jobNames.add(jobName);
        }
        return jobNames;
    }

    private List<String> getGitName(String jobName){
        if (jobName == null){
            System.out.println("gitName is null, job:" + jobName);
            return null;
        }

        Connection connect = Jsoup.connect("http://wanshiwu.corp.qunar.com/job/json/" + jobName);
        try {
            Document document = connect.get();
            Node node = document.childNode(0).childNode(1).childNode(0);
            Attributes attributes = node.attributes();
            String text = attributes.get("text");
            JSONObject jsonObject = JSON.parseObject(text);
            String status = jsonObject.getString("status");
            if (status != null && status.equals("false")){
                System.out.println("status is false, job :" + jobName);
                return Lists.newArrayList();
            }
            if (jsonObject == null){
                System.out.println();
            }
            if (jsonObject.getJSONObject("schema") == null){
                System.out.println();
            }
            Set<String> keySet = jsonObject.getJSONObject("schema").keySet();
            Iterator<String> iterator = keySet.iterator();

            List<String> gitNames = Lists.newArrayList();
            while (iterator.hasNext()){
                String next = iterator.next();
                String[] split = next.split("/");
                if (split.length == 2){
                    gitNames.add(next);
                } else {
                    System.out.println("++++++++++++++++ illegal gitName:" + next);
                }
            }
            return gitNames;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("gitName return null, job:" + jobName);
        return Lists.newArrayList();
    }

    private String getGitGroup(String gitName){
        if (gitName == null){
            return null;
        }

        String[] split = gitName.split("/");
        if (split.length != 2){
            System.out.println("---------------git name error, name: " + gitName);
            return null;
        }
        return split[0];
    }
}
