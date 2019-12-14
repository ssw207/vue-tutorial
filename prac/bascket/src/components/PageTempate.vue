<template>
	<div>
		<Header slot="header"></Header>
		<Content slot="content"></Content>
		<Footer slot="footer"></Footer>
	</div>
</template>

<script>
import Header from '@/components/Header.vue';
import Content from '@/components/Content.vue';
import Footer from '@/components/Footer.vue';

export default {
	components: {
		Header,
		Content,
		Footer,
	},
};
</script>

<style scoped>
div {
	width: 90%;
	margin: auto;
}
</style>
