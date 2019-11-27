<template>
    <view class="content">
        <view class="navbar" :style="{position:headerPosition,top:headerTop}">
            <view class="nav-item" :class="{current: filterIndex === 0}" @click="tabClick(0)">
                综合排序
            </view>
            <view class="nav-item" :class="{current: filterIndex === 1}" @click="tabClick(1)">
                销量优先
            </view>
            <view class="nav-item" :class="{current: filterIndex === 2}" @click="tabClick(2)">
                <text>价格</text>
                <view class="p-box">
                    <text :class="{active: priceOrder === 1 && filterIndex === 2}" class="yticon icon-shang"></text>
                    <text :class="{active: priceOrder === 2 && filterIndex === 2}" class="yticon icon-shang xia"></text>
                </view>
            </view>
        </view>
        <view class="goods-list">
            <view
                    v-for="(item, index) in goodsList" :key="index"
                    class="goods-item"
                    @click="navToDetailPage(item)"
            >
                <view class="image-wrapper">
                    <image :src="item.image" mode="aspectFill"></image>
                </view>
                <text class="title clamp">{{item.title}}</text>
                <view class="price-box">
                    <text class="price">{{item.price}}</text>
                    <text>已售 {{item.sales}}</text>
                </view>
            </view>
        </view>
        <uni-load-more :status="loadingType"></uni-load-more>
    </view>
</template>

<script>
    import uniLoadMore from '@/components/uni-load-more/uni-load-more.vue';
    export default {
        components: {
            uniLoadMore
        },
        data() {
            return {
                headerPosition:"fixed",
                headerTop:"0px",
                loadingType: 'more', //加载更多状态
                filterIndex: 0,
                priceOrder: 0, //1 价格从低到高 2价格从高到低
                goodsList: [],
                startNum:0
            };
        },

        onLoad(options){
            // #ifdef H5
            this.headerTop = document.getElementsByTagName('uni-page-head')[0].offsetHeight+'px';
            // #endif
            this.loadData();
        },
        onPageScroll(e){
            //兼容iOS端下拉时顶部漂移
            if(e.scrollTop>=0){
                this.headerPosition = "fixed";
            }else{
                this.headerPosition = "absolute";
            }
        },
        //下拉刷新
        onPullDownRefresh(){
            this.loadData('refresh');
        },
        //加载更多
        onReachBottom(){
            console.log("onReachBottom")
            this.startNum = this.startNum+8
            this.loadData();
        },
        methods: {
            //加载商品 ，带下拉刷新和上滑加载
             loadData(type='add', loading) {
                 console.log("onloadStart---------------------------------------------")
                //没有更多直接返回
                    if(this.loadingType === 'nomore'){
                     console.log("所有数据查询查询完成，不再进行查询操作")
                        return;
                    }

                 var params = this.startNum
                 this.$http.post("selectFruitInfoBatch?startNum="+params).then((res) => {
                     console.log("success")
                     console.log(res)
                     if (res.data.status == "success") {
                         if(res.data.data.length > 0){
                             let goodList = res.data.data;
                             this.goodsList = this.goodsList.concat(goodList);
                         }else{
                             console.log("已查询完所有数据")
                             this.$api.msg("没有更多了！")
                             this.loadingType  = 'nomore'
                         }

                     }else {
                         this.$api.msg("error");
                     }
                 }).catch(error => {
                     console.log(error)
                 })

                //判断是否还有下一页，有是more  没有是nomore(测试数据判断大于20就没有了)
                // this.loadingType  = this.goodsList.length > 20 ? 'nomore' : 'more';
                if(type === 'refresh'){
                    if(loading == 1){
                        uni.hideLoading()
                    }else{
                        uni.stopPullDownRefresh();
                    }
                }

                console.log("onloadEnd**************************************************")
            },
            //筛选点击
            tabClick(index){
                if(this.filterIndex === index && index !== 2){
                    return;
                }
                this.filterIndex = index;
                if(index === 2){
                    this.priceOrder = this.priceOrder === 1 ? 2: 1;
                }else{
                    this.priceOrder = 0;
                }
                uni.pageScrollTo({
                    duration: 300,
                    scrollTop: 0
                })
                // uni.showLoading({
                //     title: '正在加载'
                // })
                if(this.filterIndex === 1){
                    for(var item in this.goodsList){
                        console.log(this.goodsList[item].sales)
                    }
                    this.goodsList.sort((a,b)=>b.sales - a.sales)
                    for(var item in this.goodsList){
                        console.log(this.goodsList[item].sales)
                    }
                }
                if(this.filterIndex === 2){
                    for(var item in this.goodsList){
                        console.log(this.goodsList[item].price)
                    }
                    this.goodsList.sort((a,b)=>{
                        if(this.priceOrder == 1){
                            return a.price - b.price;
                        }
                        return b.price - a.price;
                    })
                    for(var item in this.goodsList){
                        console.log(this.goodsList[item].price)
                    }
                }

            },
            //详情
            navToDetailPage(item){
                //测试数据没有写id，用title代替
                let id = item.fruitId;
                uni.navigateTo({
                    url: `/pages/product/product?id=`+id
                })
            },
            stopPrevent(){}
        },
    }
</script>

<style lang="scss">
    page, .content{
        background: $page-color-base;
    }
    .content{
        padding-top: 96upx;
    }

    .navbar{
        position: fixed;
        left: 0;
        top: var(--window-top);
        display: flex;
        width: 100%;
        height: 80upx;
        background: #fff;
        box-shadow: 0 2upx 10upx rgba(0,0,0,.06);
        z-index: 10;
        .nav-item{
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            font-size: 30upx;
            color: $font-color-dark;
            position: relative;
            &.current{
                color: $base-color;
                &:after{
                    content: '';
                    position: absolute;
                    left: 50%;
                    bottom: 0;
                    transform: translateX(-50%);
                    width: 120upx;
                    height: 0;
                    border-bottom: 4upx solid $base-color;
                }
            }
        }
        .p-box{
            display: flex;
            flex-direction: column;
            .yticon{
                display: flex;
                align-items: center;
                justify-content: center;
                width: 30upx;
                height: 14upx;
                line-height: 1;
                margin-left: 4upx;
                font-size: 26upx;
                color: #888;
                &.active{
                    color: $base-color;
                }
            }
            .xia{
                transform: scaleY(-1);
            }
        }
    }

    /* 商品列表 */
    .goods-list{
        display:flex;
        flex-wrap:wrap;
        padding: 0 30upx;
        background: #fff;
        .goods-item{
            display:flex;
            flex-direction: column;
            width: 48%;
            padding-bottom: 40upx;
            &:nth-child(2n+1){
                margin-right: 4%;
            }
        }
        .image-wrapper{
            width: 100%;
            height: 330upx;
            border-radius: 3px;
            overflow: hidden;
            image{
                width: 100%;
                height: 100%;
                opacity: 1;
            }
        }
        .title{
            font-size: $font-lg;
            color: $font-color-dark;
            line-height: 80upx;
        }
        .price-box{
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding-right: 10upx;
            font-size: 24upx;
            color: $font-color-light;
        }
        .price{
            font-size: $font-lg;
            color: $uni-color-primary;
            line-height: 1;
            &:before{
                content: '￥';
                font-size: 26upx;
            }
        }
    }


</style>
