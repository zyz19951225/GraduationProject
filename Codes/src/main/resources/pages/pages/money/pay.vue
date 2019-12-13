<template>
	<view class="app">
		<view class="price-box">
			<text>支付金额</text>
			<text class="price">{{needPay}}</text>
		</view>

		<view class="pay-type-list">

			<view class="type-item b-b" @click="changePayType(1)">
				<text class="icon yticon icon-weixinzhifu"></text>
				<view class="con">
					<text class="tit">微信支付</text>
					<text>推荐使用微信支付</text>
				</view>
				<label class="radio">
					<radio value="" color="#fa436a" :checked='payType == 1' />
				</label>
			</view>
			<view class="type-item b-b" @click="changePayType(2)">
				<text class="icon yticon icon-alipay"></text>
				<view class="con">
					<text class="tit">支付宝支付</text>
				</view>
				<label class="radio">
					<radio value="" color="#fa436a" :checked='payType == 2' />
				</label>
			</view>
			<view class="type-item" @click="changePayType(3)">
				<text class="icon yticon icon-erjiye-yucunkuan"></text>
				<view class="con">
					<text class="tit">预存款支付</text>
					<text>可用余额 ¥198.5</text>
				</view>
				<label class="radio">
					<radio value="" color="#fa436a" :checked='payType == 3' />
				</label>
			</view>
		</view>
		
		<text class="mix-btn" @click="confirm">确认支付</text>
	</view>
</template>

<script>

	export default {
		data() {
			return {
				payType: 1,
				orderInfo: {},
				needDeleteOrder:[],
				needPay:""
			};
		},
		computed: {
		
		},
		onLoad(options) {
            this.orderInfo = JSON.parse(options.data).orderInfo
		    console.log(this.orderInfo)
			this.needDeleteOrder = JSON.parse(options.data).needDeleteOrder
			console.log(this.needDeleteOrder)
			this.needPay = JSON.parse(options.data).needPay
			
		},

		methods: {
			//选择支付方式
			changePayType(type) {
				this.payType = type;
			},

			//删除支付成功的订单
			deleteOrders(){
			  var params = JSON.stringify(this.needDeleteOrder)

                this.$http.post("user/deleteOrders",params).then((res) => {
                    console.log(res)
                    if (res.data.status == "success") {
                        this.$api.msg(res.data.message)

                    }else {
                        this.$api.msg(res.data.message);
                    }
                }).catch(error => {
                    console.log(error)
                    return
                }).finally(() => {

                })

            },
			//确认支付
			confirm() {
			    var params = this.orderInfo
                this.$http.post("user/createOrderInfo",params).then((res) => {
                    console.log(res)
                    if (res.data.status == "success") {
                        this.$api.msg(res.data.message)
                        this.deleteOrders()
                    }else {
                        this.$api.msg(res.data.message);
                    }
                }).catch(error => {
                    console.log(error)
                    return
                }).finally(() => {
                })
				uni.redirectTo({
					url: '/pages/money/paySuccess'
				})
			},
		}
	}
</script>

<style lang='scss'>
	.app {
		width: 100%;
	}

	.price-box {
		background-color: #fff;
		height: 265upx;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		font-size: 28upx;
		color: #909399;

		.price{
			font-size: 50upx;
			color: #303133;
			margin-top: 12upx;
			&:before{
				content: '￥';
				font-size: 40upx;
			}
		}
	}

	.pay-type-list {
		margin-top: 20upx;
		background-color: #fff;
		padding-left: 60upx;
		
		.type-item{
			height: 120upx;
			padding: 20upx 0;
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding-right: 60upx;
			font-size: 30upx;
			position:relative;
		}
		
		.icon{
			width: 100upx;
			font-size: 52upx;
		}
		.icon-erjiye-yucunkuan {
			color: #fe8e2e;
		}
		.icon-weixinzhifu {
			color: #36cb59;
		}
		.icon-alipay {
			color: #01aaef;
		}
		.tit{
			font-size: $font-lg;
			color: $font-color-dark;
			margin-bottom: 4upx;
		}
		.con{
			flex: 1;
			display: flex;
			flex-direction: column;
			font-size: $font-sm;
			color: $font-color-light;
		}
	}
	.mix-btn {
		display: flex;
		align-items: center;
		justify-content: center;
		width: 630upx;
		height: 80upx;
		margin: 80upx auto 30upx;
		font-size: $font-lg;
		color: #fff;
		background-color: $base-color;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}

</style>
