package me.lm.basic.io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * Created by blue_ann on 26/06/2018.
 */
public class IOObject {

    private static final String srcPath = "/Users/blue_ann/Desktop/data/";
    private static final String dstPath = "/Users/blue_ann/Desktop/result/";

    @Test
    public void handle() {



        for (int i = 22; i <= 22; i++) {
            String srcFileName = srcPath + "data" + i + ".js";
            String dstFileName = dstPath + "result" + i;
            List<Long> orderIds = Lists.newArrayList();
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(srcFileName))) {
                String input;
                while (null != (input = br.readLine())) {
                    sb.append(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            String searchResult = sb.toString();
            JSONObject searchResultJO = JSON.parseObject(searchResult);
            JSONArray ordersJOA = searchResultJO.getJSONObject("hits").getJSONArray("hits");

            for (int j = 0; j < ordersJOA.size(); j++) {
                JSONObject jsonObject = ordersJOA.getJSONObject(j);
                orderIds.add(jsonObject.getLong("_id"));
            }
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dstFileName));
                bufferedWriter.write(JSON.toJSONString(orderIds));
                bufferedWriter.flush();
                System.out.println(orderIds.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
