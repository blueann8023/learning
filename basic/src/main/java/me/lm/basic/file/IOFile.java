package me.lm.basic.file;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * description TODO
 * @author liumin16
 * @since 2021-02-08 13:19
 **/
public class IOFile {
	@Test
	public void a() {
//写文件
		File file = new File("/Users/blue_ann/Desktop/a.txt");
		try {
			final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 10000; i++) {
				bufferedWriter.write("22193056296,");
			}
			bufferedWriter.flush();
		} catch (IOException e) {
		}
	}

	@Test
	public void b() {

		DateTime s = DateTime.now();

		System.out.println(s.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
		DateTime e = s.plusDays(3);
		System.out.println(e.toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));

		Duration duration = Duration.standardDays(1);
		for (DateTime i = s; e.isAfter(i); i = i.plus(duration)) {
			if (i.plus(duration).isAfter(e)) {
				System.out.println(new Interval(i, e));
			} else {
				System.out.println(new Interval(i, i.plus(duration)));
			}
		}
	}


	@Test
	public void c() {
//写文件

		int s = 1;
		int e = 4;

		int duration = 1;
		for (int i = s; e > i; i = i + duration) {
			System.out.print(i);
			System.out.print(i + duration);
			System.out.println();
		}

	}


	@Test
	public void tableSql() {


		String sql = "ALTER TABLE %s%s ADD COLUMN `biz_category` tinyint(4) DEFAULT '0' COMMENT '选座订单业务类型' AFTER `unique_status`;";
		String tableNameP = "movie_order_main_u";
		String filePath = "/Users/blue_ann/Desktop";
		IntStream.range(0, 4).forEach(schemeIndex -> {
			File file = new File(filePath + "/scheme" + schemeIndex + ".txt");
			try {
				final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
				IntStream.range(128 * schemeIndex, 128 * (schemeIndex + 1)).forEach(tableIndex -> {
					try {
						bufferedWriter.write(String.format(sql, tableNameP,String.format("%03d", tableIndex)));

						bufferedWriter.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				bufferedWriter.flush();
			} catch (IOException e) {
			}
		});
	}

}
