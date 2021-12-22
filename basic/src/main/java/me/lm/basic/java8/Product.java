package me.lm.basic.java8;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * description TODO
 * @author liumin16
 * @since 2021-04-21 13:10
 **/
public class Product {

	private int id;// 0-N 0标识新增

	private int show; //0,1,2
	private int version; // 0,1,2
	private List<String> halls;
	private List<Integer> movies;

	private Pair<Integer, Integer> seatUpDown;
	private float price;

	private Product(Builder builder) {
		id = builder.id;
		show = builder.show;
		version = builder.version;
		halls = builder.halls;
		movies = builder.movies;
		seatUpDown = builder.seatUpDown;
		price = builder.price;
	}

	public static Builder newBuilder() {
		return new Builder();
	}


	public static final class Builder {
		private int id;
		private int show;
		private int version;
		private List<String> halls;
		private List<Integer> movies;
		private Pair<Integer, Integer> seatUpDown;
		private float price;

		private Builder() {
		}

		public Builder id(int val) {
			id = val;
			return this;
		}

		public Builder show(int val) {
			show = val;
			return this;
		}

		public Builder version(int val) {
			version = val;
			return this;
		}

		public Builder halls(List<String> val) {
			halls = val;
			return this;
		}

		public Builder movies(List<Integer> val) {
			movies = val;
			return this;
		}

		public Builder seatUpDown(Pair<Integer, Integer> val) {
			seatUpDown = val;
			return this;
		}

		public Builder price(float val) {
			price = val;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<String> getHalls() {
		return halls;
	}

	public void setHalls(List<String> halls) {
		this.halls = halls;
	}

	public List<Integer> getMovies() {
		return movies;
	}

	public void setMovies(List<Integer> movies) {
		this.movies = movies;
	}

	public Pair<Integer, Integer> getSeatUpDown() {
		return seatUpDown;
	}

	public void setSeatUpDown(Pair<Integer, Integer> seatUpDown) {
		this.seatUpDown = seatUpDown;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
