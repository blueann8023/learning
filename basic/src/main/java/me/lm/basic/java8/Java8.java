// /*
// package me.lm.basic.java8;
//
// import org.joda.time.DateTime;
// import org.joda.time.Interval;
// import org.junit.Test;
//
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// public class Java8 {
//
// 	// default method for interface
// 	// list iteracotr issue ??
// 	@Test
// 	public void defaultMethodForInterface() {
// 		Furmula furmula = new Furmula() {
// 			@Override
// 			public double calculate(int a) {
// 				return sqrt(a);
// 			}
// 		};
// 		furmula.calculate(10);
//
// 		furmula.sqrt(10);
// 	}
//
// 	// functional interface
// 	@Test
// 	public void functionalInterface() {
// 		Game<String> game = new Game<String>() {
// 			@Override
// 			public void play(String gameName) {
// 				System.out.print(gameName);
// 			}
// 		};
// 		game.play("GoGo");
// 		Game<String> game1 = System.out::print;
// 	}
//
// 	// stream map
// 	@Test
// 	public void testStreamMap() {
//
// 		List<RegionVO> regions = new ArrayList<>();
// 		for (int k = 0; k < 3; k++) {
// 			RegionVO region = new RegionVO();
// 			region.setRegionId("k:" + k);
// 			List<RowVO> rows = new ArrayList<>();
// 			for (int j = 0; j < 5; j++) {
// 				RowVO row = new RowVO();
//
// 				List<SeatVO> seats = new ArrayList<>();
// 				for (int i = 0; i < 10; i++) {
// 					SeatVO seat = new SeatVO();
// 					seat.setSeatNo("k:" + k + ",j:" + j + ",i:" + i);
// 					seats.add(seat);
// 				}
// 				row.setSeats(seats);
// 				rows.add(row);
// 			}
// 			region.setRows(rows);
// 			regions.add(region);
// 		}
// 		Map<String, Stream<SeatVO>> regoinMapSeats = regions.stream().collect(Collectors.toMap(RegionVO::getRegionId, tSeatRegion -> tSeatRegion.getRows().stream().flatMap(tRow -> tRow.getSeats().stream())));
// 		String key = regoinMapSeats.entrySet().stream().filter(entry -> entry.getValue().anyMatch(tSeat -> "k:2,j:0,i:8".equals(tSeat.getSeatNo()))).findFirst().get().getKey();
// 		System.out.println("KEY:" + key);
//
// 	}
//
// 	@Test
// 	public void testStreamDistinct() {
//
// 	}
//
// 	@Test
// 	public void testLamda() {
//
// 		String a = "";
// 		DateTime showTime = DateTime.now();
// 		DateTime now = DateTime.now().withTimeAtStartOfDay();
//
// 		if (new Interval(now, now.plusDays(3)).gap().contains(showTime)) {
// 			a = "今天";
// 			String.format("%s %s月%日", a, showTime.monthOfYear(), showTime.getDayOfMonth());
// 		} else if (new Interval(now.plusDays(1), now.plusDays(2)).contains(showTime)) {
// 			a = "今天";
// 			String.format("%s %s月%日", a, showTime.monthOfYear(), showTime.getDayOfMonth());
// 		} else if (new Interval(now.plusDays(2), now.plusDays(3)).contains(showTime)) {
// 			a = "今天";
// 			String.format("%s %s月%日", a, showTime.monthOfYear(), showTime.getDayOfMonth());
// 		} else if (new Interval(now.plusDays(4), now.plusDays(7)).contains(showTime)) {//
// 			String.format("本周%s %s月%日", showTime.getDayOfWeek(), showTime.monthOfYear(), showTime.getDayOfMonth());
// 		}
//
//
//
// 	}
//
// }
//
//
//
// */
