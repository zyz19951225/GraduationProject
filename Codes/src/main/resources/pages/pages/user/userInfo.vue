<template>
    <view class="content">
        <view class="user-info-box" >

            <view class="portrait-box">
                <image class="portrait" src="/static/index/display/zs1.png"></image>
            </view>
            <!--<view class="info-box">-->
                <!--<text class="username">{{userInfo.name || '游客,请登录！'}}</text>-->
            <!--</view>-->
        </view>
        <view class="row b-b">
            <text class="tit">用户名</text>
            <input class="input" type="text" v-model="addressData.ecipient" placeholder="收货人姓名" placeholder-class="placeholder" />
        </view>
        <view class="row b-b">
            <text class="tit">年龄</text>
            <input class="input" type="text" v-model="addressData.ecipient" placeholder="收货人姓名" placeholder-class="placeholder" />
        </view>
        <view class="row b-b">
            <text class="tit">手机号</text>
            <input class="input" type="number" v-model="addressData.telephone" placeholder="收货人手机号码" placeholder-class="placeholder" />
        </view>
        <view class="row b-b">
            <text class="tit">地址</text>
            <input class="input" type="text" v-model="addressData.address" placeholder="请输入地址" placeholder-class="placeholder" />
            <!--<text @click="chooseLocation" class="input">-->
            <!--{{addressData.address}}-->
            <!--</text>-->
            <text class="yticon icon-shouhuodizhi"></text>
        </view>
        <view class="row b-b">
            <text class="tit">门牌号</text>
            <input class="input" type="text" v-model="addressData.area" placeholder="楼号、门牌" placeholder-class="placeholder" />
        </view>

        <view class="row default-row">
            <text class="tit">设为默认</text>
            <switch :checked="defaultFlag" color="#fa436a" @change="switchChange" />
        </view>
        <button class="add-btn" @click="confirm">提交</button>
    </view>
</template>

<script>
    import {
        mapState,mapMutations
    } from 'vuex';
    export default {
        data() {
            return {
                addressData: {
                    id:'',
                    userId:'',
                    ecipient: '',
                    telephone: '',
                    address: '',
                    area: '',
                    defaultAddress: ""
                },
                defaultFlag:false,
                commitType:""
            }
        },
        onLoad(option){
            let title = '用户信息';
            var that = this
            if(option.type==='edit'){
                title = '编辑用户信息'
                that.commitType = option.type
                this.addressData = JSON.parse(option.data)
                if(this.addressData.defaultAddress = 1){
                    that.defaultFlag = true
                }else {
                    that.defaultFlag = false
                }
                console.log(this.addressData)
            }
            this.manageType = option.type;
            uni.setNavigationBarTitle({
                title
            })
        },
        computed: {
            ...mapState(['userInfo'])
        },
        methods: {
            switchChange(e){
                console.log(e.detail)
                if(e.detail.value == true){
                    this.addressData.defaultAddress = 1;
                }else {
                    this.addressData.defaultAddress = 0;
                }
                console.log(this.addressData.defaultAddress)

            },

            //地图选择地址
            chooseLocation(){
                uni.chooseLocation({
                    success: (data)=> {
                        this.addressData.addressName = data.name;
                        this.addressData.address = data.name;
                    }
                })
            },

            navToAddress(){
                var url = '/pages/address/address';
                uni.navigateTo({
                    url
                })
            },
            //提交
            confirm(){
                let data = this.addressData;
                var that = this
                if(!data.ecipient){
                    this.$api.msg('请填写收货人姓名');
                    return;
                }
                if(!/(^1[3|4|5|7|8][0-9]{9}$)/.test(data.telephone)){
                    this.$api.msg('请输入正确的手机号码');
                    return;
                }
                if(!data.address){
                    this.$api.msg('请在地图选择所在位置');
                    return;
                }
                if(!data.area){
                    this.$api.msg('请填写门牌号信息');
                    return;
                }
                if(this.commitType == 'edit'){
                    this.$http.post("user/updateUsersAddress",data).then((res) => {
                        console.log("success")
                        console.log(res)
                        if(res.data.status === "success"){
                            this.navToAddress()

                        }else{
                            this.$api.msg(res.data.data.errMsg);
                        }
                    }).catch(error => {
                        console.log(error)
                    }).finally(() => {
                        //console.log("success")
                    })
                }else {
                    data.userId = that.userInfo.id
                    this.$http.post("user/addUsersAddress",data).then((res) => {
                        console.log("success")
                        console.log(res)
                        if(res.data.status === "success"){
                            this.navToAddress()
                        }else{
                            this.$api.msg(res.data.data.errMsg);
                        }
                    }).catch(error => {
                        console.log(error)
                    }).finally(() => {
                        //console.log("success")
                    })
                }

                //this.$api.prePage()获取上一页实例，可直接调用上页所有数据和方法，在App.vue定义
                // this.$api.prePage().refreshList(data, this.manageType);
                // this.$api.msg(`地址${this.manageType=='edit' ? '修改': '添加'}成功`);
                // setTimeout(()=>{
                // 	uni.navigateBack()
                // }, 800)
            },
        }
    }
</script>

<style lang="scss">
    page{
        background: $page-color-base;
        padding-top: 16upx;
    }
    .user-info-box{

        height: 180upx;
        display:flex;
        align-items:center;
        position:relative;
        z-index: 1;
        .portrait{
            width: 130upx;
            height: 130upx;
            border:5upx solid #fff;
            border-radius: 50%;
        }
        .username{
            font-size: $font-lg + 6upx;
            color: $font-color-dark;
            margin-left: 20upx;
        }
    }
    .row{
        display: flex;
        align-items: center;
        position: relative;
        padding:0 30upx;
        height: 110upx;
        background: #fff;

        .tit{
            flex-shrink: 0;
            width: 120upx;
            font-size: 30upx;
            color: $font-color-dark;
        }
        .input{
            flex: 1;
            font-size: 30upx;
            color: $font-color-dark;
        }
        .icon-shouhuodizhi{
            font-size: 36upx;
            color: $font-color-light;
        }
    }
    .portrait-box{
        width: 200upx;
        height: 200upx;
        border:6upx solid #fff;
        border-radius: 50%;
        position:relative;
        z-index: 2;
    }
    .default-row{
        margin-top: 16upx;
        .tit{
            flex: 1;
        }
        switch{
            transform: translateX(16upx) scale(.9);
        }
    }
    .add-btn{
        display: flex;
        align-items: center;
        justify-content: center;
        width: 690upx;
        height: 80upx;
        margin: 60upx auto;
        font-size: $font-lg;
        color: #fff;
        background-color: $base-color;
        border-radius: 10upx;
        box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
    }
</style>
