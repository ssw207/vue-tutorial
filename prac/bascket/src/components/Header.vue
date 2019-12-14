<template>
	<div>
		<slot name="header">No title</slot>
	</div>
</template>

<script>
export default {
	props: {
		title: {
			type: String,
			default: '',
			required: true,
		},
	},
};
</script>

<style scoped>
h1 {
	text-align: center;
	background: gray;
}
</style>
