package me.lm.basic.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by blue_ann on 26/06/2018.
 */
public class IOObject {

	private static final String srcPath = "/Users/blue_ann/Desktop/";
	private static final String dstPath = "/Users/blue_ann/Desktop/";

	@Test
	public void handle() {


		for (int i = 1; i <= 1; i++) {
			String srcFileName = srcPath + "data" + i + ".js";
			String dstFileName = dstPath + "result" + i;
			List<Long> orderIds = Lists.newArrayList();
			List<Integer> seatNum = Lists.newArrayList();
			List<Double> payMoney = Lists.newArrayList();
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
				orderIds.add(jsonObject.getJSONObject("_source").getLongValue("id"));
				// seatNum.add(jsonObject.getJSONObject("_source").getIntValue("seat_num"));
				// payMoney.add(jsonObject.getJSONObject("_source").getDoubleValue("pay_money"));

			}
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dstFileName));
				bufferedWriter.write(JSON.toJSONString(orderIds));
				bufferedWriter.flush();
				System.out.println(orderIds.size());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(orderIds.size());
			System.out.println(seatNum.stream().mapToInt(Integer::intValue).sum());
			System.out.println(payMoney.stream().mapToDouble(Double::doubleValue).sum());

		}
	}

	@Test
	public void testJSON() {
		String dataMapJson = "{\"seatTypes\":\"N\",\"hallName\":\"单区厅\",\"movieName\":\"美容针\",\"lockTime\":\"2018-12-11 22:12:49\",\"poiId\":2418248,\"cinemaName\":\"猫眼电影(阿凡达店)\",\"releaseSeconds\":900,\"newProgress\":true,\"userName\":\"blue_ann8023\",\"seats\":\"3:5\",\"sectionName\":\"默认场区\",\"language\":\"国语\"}";
		JSONObject orderMain = null;
		try {
			orderMain = JSON.parseObject(dataMapJson);
			System.out.println(orderMain.toJSONString());
		} catch (Exception e) {
			return;
		}
	}
}
