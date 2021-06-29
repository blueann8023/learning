package me.lm.basic.thrift;

import com.google.common.collect.Sets;
import com.maoyan.movie.trade.show.export.thrift.inter.showservice.TBaseShowPriceRequest;
import com.maoyan.settlement.export.param.TOpenPlatformOrderRequest;
import com.maoyan.settlement.export.param.TOpenPlatformSeatRequest;
import com.meituan.service.mobile.mtthrift.util.json.JacksonUtils;
import com.meituan.service.movie.order.search.common.CoreOrderRequestParam;
import com.meituan.service.movie.order.search.common.ResponseFieldParam;
import com.meituan.service.movie.order.search.thrift.coreorder.TCoreOrderRequest;
import com.sankuai.movie.avitrade.nuovoorder.api.TCreateRequest;
import com.sankuai.movie.avitrade.nuovoorder.api.TCreateSeatPromotion;
import com.sankuai.movie.avitrade.nuovostock.api.TBaseSeat;
import com.sankuai.movie.avitrade.nuovostock.api.TLockStockRequest;
import com.sankuai.movie.avitrade.nuovostock.api.TSeatInfo;
import com.sankuai.movie.avitrade.nuovostock.api.TSeatPrice;
import com.sankuai.movie.avitrade.nuovostock.api.TSubmitStockRequest;
import org.assertj.core.util.Lists;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * description TODO
 * @author liumin16
 * @since 2021-04-01 14:04
 **/
public class ThriftSerialize {

	@Test
	public void serialize() {

		// 构建请求参数
		// TBaseShowPriceRequest request = new TBaseShowPriceRequest();
		// request.setShowSeqNo("202105110000019");
		// request.setChannelId(1000095);


		// request.setChannelId(1000014);
		// request.setShowSeqNo("202104160000008");
		// System.out.println(JacksonUtils.serialize(request));

		// TSubmitStockRequest tSubmitStockRequest = new TSubmitStockRequest();
		// tSubmitStockRequest.setId(20210401000000005L);
		// List<TSeatInfo> seatInfos = new ArrayList<>();
		// TSeatInfo tSeatInfo = new TSeatInfo();
		// TBaseSeat tBaseSeat = new TBaseSeat();
		// tBaseSeat.setNo("99999902#10#10");
		// tBaseSeat.setType("N");
		// tBaseSeat.setSectionId("1");
		// tBaseSeat.setRowId("10");
		// tBaseSeat.setColumnId("1");
		// TSeatPrice tSeatPrice = new TSeatPrice();
		// tSeatPrice.setSellPrice(2600);
		// tSeatPrice.setSettlePrice(2200);
		// tSeatPrice.setPurchasePrice(2200);
		// tSeatPrice.setFee(400);
		// tSeatPrice.setMinPrice(10);
		// // tSeatPrice.setExtInfo("\"extInfo\":\"{\\\"price\\\":2100,\\\"priceId\\\":\\\"909\\\",\\\"originalServiceFee\\\":100,\\\"priceType\\\":\\\"1\\\",\\\"serviceFeehall\\\":0,\\\"serviceFeePat\\\":100}\"}}]]");
		// tSeatInfo.setBaseSeat(tBaseSeat);
		// tSeatInfo.setSeatPrice(tSeatPrice);
		// seatInfos.add(tSeatInfo);
		// tSubmitStockRequest.setSeatInfos(seatInfos);
		// System.out.println(JacksonUtils.serialize(tSubmitStockRequest));
		//
		//
		//
		TBaseSeat tBaseSeat = new TBaseSeat();
		tBaseSeat.setNo("99999902#10#05");
		tBaseSeat.setType("N");
		tBaseSeat.setSectionId("1");
		tBaseSeat.setRowId("1");
		tBaseSeat.setColumnId("5");

		TLockStockRequest tLockStockRequest = new TLockStockRequest();
		tLockStockRequest.setShowId("202105110000016");
		tLockStockRequest.setUserId(10197465380095L);
		tLockStockRequest.setMobile("17610246538");
		tLockStockRequest.setChannelId(1000095);
		tLockStockRequest.setBaseSeats(Lists.newArrayList(tBaseSeat));
		System.out.println(JacksonUtils.serialize(tLockStockRequest));


		// TCreateSeatPromotion tCreateSeatPromotions = new TCreateSeatPromotion();
		// tCreateSeatPromotions.setPromotionIds(Lists.newArrayList(100000909L));
		// tCreateSeatPromotions.setSeatNo("99999902#10#05");
		// TCreateRequest tCreateRequest = new TCreateRequest();
		// tCreateRequest.setChannelId(1000095);
		// tCreateRequest.setChannelType(8);
		// tCreateRequest.setChannelVersion("1.0.0");
		// tCreateRequest.setChannelOrderId("lztest00001");
		// tCreateRequest.setUserId(10197465380095L);
		// tCreateRequest.setPhone("17610246538");
		// tCreateRequest.setShowId("202105110000016");
		// tCreateRequest.setStockId(20210419000000025L);
		// tCreateRequest.setCreateSeatPromotions(Lists.newArrayList(tCreateSeatPromotions));
		// System.out.println(JacksonUtils.serialize(tCreateRequest));
		//
		//
		// HashSet<Long> idSet = Sets.newHashSet(22382224432L);
		// HashSet<Integer> payStatusSet = Sets.newHashSet(0, 1, 2);
		// HashSet<Integer> fixStatusSet = Sets.newHashSet(1);
		// HashSet<Integer> refundStatusSet = Sets.newHashSet(0, 1, 2);
		//
		// String requestString = CoreOrderRequestParam.builder()
		// 		// .payStartTime(new DateTime().minusDays(1).getMillis())
		// 		// .payStatusSet(payStatusSet)
		// 		// .fixStatusSet(fixStatusSet)
		// 		// .refundStatusSet
		// 		.orderIdSet(Sets.newHashSet(22382224432L))
		// 		.lastest(true)
		// 		.offset(0)
		// 		.limit(2)
		// 		.buildJSONString();
		//
		// TCoreOrderRequest tCoreOrderRequest = new TCoreOrderRequest();
		// tCoreOrderRequest.setRequestParam(requestString);
		// // tCoreOrderRequest.setResponseFieldsParam(ResponseFieldParam.newBuilder().originalId(true).uniqueStatus(true).buildJSONString());
		// System.out.println(JacksonUtils.serialize(tCoreOrderRequest));
		//
		//
		// System.out.println(JacksonUtils.serialize(tCoreOrderRequest));
		//
		// TCreateRequest a = new TCreateRequest();


		// TOpenPlatformOrderRequest request = new TOpenPlatformOrderRequest();
		// request.setOrderId("121212");
		// request.setUniqueId("1");//1 支付 订单维度的唯一UniqueId *
		// request.setBusinessLineType(1);// com.meituan.service.mobile.maoyan.order.gdomain.enums.BusinessLineTypeEnum.SEAT
		// request.setSubBusinessLineType(0);//com.maoyan.settlement.export.enums.SettleSubBizTypeEnum.NONE
		// request.setSettleLogType(2);//com.maoyan.settlement.export.enums.SettleLogTypeEnum.PAY *
		// request.setBizCode("订单号");
		// request.setSourceChannel(2);//SettleSourceChannelEnum.OPEN_PLATFORM
		// request.setBizTime(dpOrderModel.getFixTime().getTime());//出票成功的时间
		// request.setFinalSettleMoney(dpOrderModel.getSettleCinemaPrice());//同商家影院的结算价
		// request.setCinemaId(dpOrderModel.getCinemaId());
		// TOpenPlatformSeatRequest seatRequest = new TOpenPlatformSeatRequest();
		// seatRequest.setSaleSystem(String.valueOf(dpOrderModel.getSellSource()));
		// seatRequest.setCinemaId(dpOrderModel.getCinemaId());
		// seatRequest.setCinemaName(dpOrderModel.getCinemaName());
		// seatRequest.setOutOrderNo(dpOrderModel.getOriginalId());
		// seatRequest.setOrderType(1);//com.meituan.service.mobile.maoyan.order.gdomain.enums.OrderTypeEnum.SeatOrder
		// seatRequest.setMovieName(showModel.getMovieName());
		// seatRequest.setMovieHallName(showModel.getHallName());
		// seatRequest.setMovieType(dpOrderModel.getTicketType());
		// seatRequest.setSeatList(dpOrderModel.getSeat());
		// seatRequest.setMovieTime(dpOrderModel.getShowTime().getTime());
		// seatRequest.setPurchasePrice(dpOrderModel.getSettlePrice());
		// seatRequest.setBackSaleChannelPrice(dpOrderModel.getSettlePrice());
		// seatRequest.setOrderCreatTime(dpOrderModel.getFixTime().getTime());
		// seatRequest.setPayTime(dpOrderModel.getFixTime().getTime());
		// seatRequest.setOrderStatus("4");//com.maoyan.service.maoyan.transaction.data.query.export.enums.MainStatusEnum.WAIT_CONSUME 待消费 *
		// seatRequest.setSalePrice(dpOrderModel.getSettleMaoyanPrice());
		// seatRequest.setPayedPrice(dpOrderModel.getSettleMaoyanPrice());
		// seatRequest.setSaleChannel(Integer.valueOf(dpOrderModel.getChannelId()));
		// request.setSeatDetailInfo(seatRequest);

// System.out.println(JacksonUtils.serialize(tCoreOrderRequest));
	}
}
