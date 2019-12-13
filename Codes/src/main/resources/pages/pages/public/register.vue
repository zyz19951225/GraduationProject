<template>
	<view class="container">
		<view class="left-bottom-sign"></view>
		<view class="back-btn yticon icon-zuojiantou-up" @click="navBack"></view>
		<view class="right-top-sign"></view>
		<!-- 设置白色背景防止软键盘把下部绝对定位元素顶上来盖住输入框等 -->
		<view class="wrapper">
			<view class="left-top-sign">LOGIN</view>
			<view class="welcome">
				欢迎注册！
			</view>
			<view class="input-content">
				<view class="input-item">
					<text class="tit">手机号码</text>
					<input 
						type="number" 
						v-model="form_query.telephone"
						placeholder="请输入手机号码"
						maxlength="11"
						data-key="mobile"
						@input="inputChange"
					/>
				</view>

				<!--<view class="input-item">-->
					<!--<text class="tit">验证码</text>-->
					<!--<div style="display: block">-->
					<!--<input-->
						<!--v-model="otpCode"-->
						<!--placeholder="请输入验证码"-->
						<!--placeholder-class="input-empty"-->
						<!--maxlength="20"-->
						<!--@input="inputChange"-->
						<!--@confirm="toLogin"-->
					<!--/><button size="medium" @click="getOtp">获取</button>-->
					<!--</div>-->
				<!--</view>-->
				<view class="input-item">
					<text class="tit">密码</text>
					<input
							type="mobile"
							v-model="form_query.encrptPassword"
							placeholder="8-18位不含特殊字符的数字、字母组合"
							placeholder-class="input-empty"
							maxlength="20"
							password
							data-key="password"
							@input="inputChange"
							@confirm="toLogin"
					/>
				</view>
			</view>
			<button class="confirm-btn"  style="width: 300upx" @click="toRegist" :disabled="logining">注册</button>
			<button class="confirm-btn" @click="navToLogin" >已有账号去登录</button>
			<!--<view class="forget-section">-->
				<!--忘记密码?-->
			<!--</view>-->
		</view>
	
	</view>
</template>

<script>
	import {
        mapMutations
    } from 'vuex';

	export default{
		data(){
			return {
				telephone: '1',
				password: '1',
				logining: false,
			    otpCode:"1",
				name:"1",
				gender:"1",
				age:"1",
				form_query:{
                    telephone: '',
                    encrptPassword: '',
                    otpCode:"",
                    name:"Bnana",
                    gender:"1",
                    age:"1",
				}
			}
		},
		onLoad(){

		},
		methods: {
            ...mapMutations(['login']),
            inputChange(e) {
                const key = e.currentTarget.dataset.key;
                this[key] = e.detail.value;
            },
            navBack() {
                uni.navigateBack();
            },
            navToLogin(){
                var url = '/pages/public/login';
                uni.navigateTo({
                    url
                })
            },
            toRegist() {
                if(!/(^1[3|4|5|7|8][0-9]{9}$)/.test(this.form_query.telephone)){
                    this.$api.msg('请输入正确的手机号码');
                    return;
                }
                if(!/(^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$)/.test(this.form_query.encrptPassword)){
                    this.$api.msg('密码必须为英文加数字且大于6位');
                    return;
                }
                var params = this.form_query
                this.$http.post("user/register", params).then((res) => {
                    console.log("success")
                    console.log(res)
                    if (res.data.status == "fail") {
                        this.$api.msg(res.data.data.errMsg);
                        this.form_query = {}
                    }else {
                        this.$api.msg("注册成功！请登录");
                        this.navToLogin()
                    }
                }).catch(error => {
                    console.log(error)
                    return
                }).finally(() => {

                })
            },
            jsonToStr(json) {
                let str = "";
                for (let key in json) {
                    str += "&" + key + "=" + json[key];
                }
                return str.substring(1);
            },
            async toLogin() {
                this.logining = true;
                const {mobile, password} = this;
                var cmd;

            },
        }
	}
</script>

<style lang='scss'>
	page{
		background: #fff;
	}
	.container{
		padding-top: 115px;
		position:relative;
		width: 100vw;
		height: 100vh;
		overflow: hidden;
		background: #fff;
	}
	.wrapper{
		position:relative;
		z-index: 90;
		background: #fff;
		padding-bottom: 40upx;
	}
	.back-btn{
		position:absolute;
		left: 40upx;
		z-index: 9999;
		padding-top: var(--status-bar-height);
		top: 40upx;
		font-size: 40upx;
		color: $font-color-dark;
	}
	.left-top-sign{
		font-size: 120upx;
		color: $page-color-base;
		position:relative;
		left: -16upx;
	}
	.right-top-sign{
		position:absolute;
		top: 80upx;
		right: -30upx;
		z-index: 95;
		&:before, &:after{
			display:block;
			content:"";
			width: 400upx;
			height: 80upx;
			background: #b4f3e2;
		}
		&:before{
			transform: rotate(50deg);
			border-radius: 0 50px 0 0;
		}
		&:after{
			position: absolute;
			right: -198upx;
			top: 0;
			transform: rotate(-50deg);
			border-radius: 50px 0 0 0;
			/* background: pink; */
		}
	}
	.left-bottom-sign{
		position:absolute;
		left: -270upx;
		bottom: -320upx;
		border: 100upx solid #d0d1fd;
		border-radius: 50%;
		padding: 180upx;
	}
	.welcome{
		position:relative;
		left: 50upx;
		top: -90upx;
		font-size: 46upx;
		color: #555;
		text-shadow: 1px 0px 1px rgba(0,0,0,.3);
	}
	.input-content{
		padding: 0 60upx;
	}
	.input-item{
		display:flex;
		flex-direction: column;
		align-items:flex-start;
		justify-content: center;
		padding: 0 30upx;
		background:$page-color-light;
		height: 120upx;
		border-radius: 4px;
		margin-bottom: 50upx;
		&:last-child{
			margin-bottom: 0;
		}
		.tit{
			height: 50upx;
			line-height: 56upx;
			font-size: $font-sm+2upx;
			color: $font-color-base;
		}
		input{
			height: 60upx;
			font-size: $font-base + 2upx;
			color: $font-color-dark;
			width: 100%;
		}	
	}

	.confirm-btn{
		width: 630upx;
		height: 76upx;
		line-height: 76upx;
		border-radius: 50px;
		margin-top: 70upx;
		background: $uni-color-primary;
		color: #fff;
		font-size: $font-lg;
		&:after{
			border-radius: 100px;
		}
	}
	.forget-section{
		font-size: $font-sm+2upx;
		color: $font-color-spec;
		text-align: center;
		margin-top: 40upx;
	}
	.register-section{
		position:absolute;
		left: 0;
		bottom: 50upx;
		width: 100%;
		font-size: $font-sm+2upx;
		color: $font-color-base;
		text-align: center;
		text{
			color: $font-color-spec;
			margin-left: 10upx;
		}
	}
</style>
