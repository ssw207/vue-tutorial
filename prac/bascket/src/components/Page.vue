<template>
	<div>
		<Header>
			<h1 slot="header">장바구니</h1>
		</Header>
		<Content>
			<Basket slot="content"></Basket>
		</Content>
		<Footer>
			<p slot="footer">연락처 : 010-123-1234</p>
		</Footer>
	</div>
</template>

<script>
import Header from '@/components/Header.vue';
import Content from '@/components/Content.vue';
import Footer from '@/components/Footer.vue';

import Basket from '@/components/Basket.vue';

export default {
	components: {
		Header,
		Content,
		Footer,
		Basket,
	},
};
</script>

<style scoped>
div {
	width: 90%;
	margin: auto;
}
</style>
