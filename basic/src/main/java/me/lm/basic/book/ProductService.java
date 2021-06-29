package me.lm.basic.book;

import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description TODO
 * @author liumin16
 * @since 2021-04-21 13:14
 **/
public class ProductService {

	@Test
	public void saveUpdate() {

		Product old1 = Product.newBuilder()
				.id(1)
				.halls(Lists.newArrayList("1", "2"))
				.movies(Lists.newArrayList(1, 2))
				.price(2.2f)
				.seatUpDown(Pair.of(1, 10))
				.show(0)
				.version(1)
				.build();
		Product old2 = Product.newBuilder()
				.id(2)
				.halls(Lists.newArrayList("1", "2"))
				.movies(Lists.newArrayList(3, 4))
				.price(2.3f)
				.seatUpDown(Pair.of(1, 10))
				.show(0)
				.version(1)
				.build();


		Product new1 = Product.newBuilder()
				.id(0)//新增
				.halls(Lists.newArrayList("1", "2"))
				.movies(Lists.newArrayList(1, 2))
				.price(2.2f)
				.seatUpDown(Pair.of(1, 10))
				.show(0)
				.version(1)
				.build();

		Product new2 = Product.newBuilder()
				.id(2)//变更
				.halls(Lists.newArrayList("2", "3"))
				.movies(Lists.newArrayList(3, 4))
				.price(2.3f)
				.seatUpDown(Pair.of(1, 10))
				.show(0)
				.version(1)
				.build();

		Product new3 = Product.newBuilder()
				.id(7)//异常数据
				.halls(Lists.newArrayList("2", "3"))
				.movies(Lists.newArrayList(3, 4))
				.price(2.3f)
				.seatUpDown(Pair.of(1, 10))
				.show(0)
				.version(1)
				.build();

		List<Product> oldPs = Lists.newArrayList(old1, old2);
		List<Product> newPs = Lists.newArrayList(new1, new2);

		//新增 我们需要
		//如果判断是新增数据呢？news ids-olds ids 的差集 即new id not in olds id 的集合 && 约定id=0 为新增;不满足id=0为异常数据,这种原理上不会出现只有自己测试数据没造对
		//代码怎么写呢？
		//异常数据
		if (newPs.stream().anyMatch(newP -> oldPs.stream().noneMatch(oldP -> newP.getId() == oldP.getId()) && newP.getId() > 0)) {
			//数据异常
			return;
		}
		//新增
		List<Product> realNewPs = newPs.stream().filter(newP -> oldPs.stream().noneMatch(oldP -> newP.getId() == oldP.getId())).collect(Collectors.toList());
		realNewPs.forEach(realNewP -> {
			//执行新增逻辑
			// insert 上单
			// insert do

		});

		//更新
		List<Product> realUpdatePs = newPs.stream().filter(newP -> oldPs.stream().anyMatch(oldP -> newP.getId() == oldP.getId())).collect(Collectors.toList());
		realUpdatePs.forEach(realUpdateP -> {
			// 执行删除逻辑 old
			// 执行新增逻辑 new
		});

		//删除
		List<Product> realDeletePs = oldPs.stream().filter(oldP -> newPs.stream().noneMatch(newP -> oldP.getId() == newP.getId())).collect(Collectors.toList());
		realDeletePs.forEach(realDeleteP -> {
			// 执行删除逻辑
			//update do status
			//delete 上单
		});

	}
}
