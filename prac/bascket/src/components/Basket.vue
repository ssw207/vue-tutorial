<template>
	<selection>
		<div>
			<h2>상품선택</h2>
			<ul v-if="items.length">
				<li v-for="item in items" :item="item" :key="item.id">
					<p>상품명 : {{ item.name }}</p>
					<span>갯수 : {{ item.quentity }}개</span>
					<input class="input" type="number" v-model="item.quentity" min="0" />
				</li>
			</ul>
		</div>
		<div>
			<h2>구매내역</h2>
			<ul v-if="items.length">
				<li v-for="(item, index) in items" :item="item" :key="item.id">
					<span>
						{{ index + 1 }}
						{{ item.name }} : {{ item.price | formatCurrency }} x
						{{ item.quentity }} =
						{{ (item.price * item.quentity) | formatCurrency }}
					</span>
				</li>
			</ul>
			<p>합계 : {{ total }}</p>
			<p class="warn" v-if="!canBuy">
				{{ minTotal }}원 이상부터 구매할수 있습니다.
			</p>
			<button @click="doBuy($event)">구매</button>
		</div>
	</selection>
</template>

<script>
let id = 0;
let items = [
	{ id: id++, name: 'pen', price: 100, quentity: 0 },
	{ id: id++, name: 'car', price: 1000, quentity: 0 },
	{ id: id++, name: 'bus', price: 10000, quentity: 0 },
];
export default {
	data() {
		return {
			items: items,
			minTotal: 1000,
		};
	},
	computed: {
		total() {
			// array.reduce((결과값, 배열의 항목){return 연산처리}, 최초값)
			return this.items.reduce((sum, item) => {
				return (sum += item.price * item.quentity);
			}, 0);
		},
		canBuy() {
			return this.total >= this.minTotal;
		},
	},
	filters: {
		formatCurrency(value) {
			if (!value) return 0;
			return value.toString().replace(/(\d)(?=(\d{3})+$)/g, '$1,');
		},
	},
	methods: {
		doBuy({ target }) {
			console.log({ target }); // 메서드을 실행한 이벤트 객체에 접근가능
			// 서버 데이터전송
			alert(this.total + '원 판매되었습니다');
			this.items.forEach(function(item) {
				return (item.quentity = 0);
			});
		},
	},
};
</script>

<style scoped>
.input {
	width: 5%;
	text-align: right;
}
div {
	border: 1px solid black;
	padding: 10px;
	margin-top: 5px;
	margin: auto;
}
.warn {
	color: red;
}
li {
	border: 1px solid black;
	margin-right: 10px;
	padding: 10px;
	width: 80%;
}
</style>
