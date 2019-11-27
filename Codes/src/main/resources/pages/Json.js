/* 用户 */
const userInfo = {
	status: 1,
	data: {
		id: 1,
		mobile: 18888888888,
		nickname: 'Leo yo',
		portrait: 'http://img.61ef.cn/news/201409/28/2014092805595807.jpg'
	},
	msg: '提示'
}
/* 首页轮播图 */
const carouselList = [{
		src: "/static/index/lb1.jpg",
		background: "rgb(203, 87, 60)",
	},
	{
		src: "/static/index/lb2.jpg",
		background: "rgb(205, 215, 218)",
	},
	{
		src: "/static/index/lb3.jpg",
		background: "rgb(183, 73, 69)",
	}
]
/* 商品列表 */
const goodsList = [{
		image: "/static/index/display/zs1.png",
		image2: "http://pic.rmb.bdstatic.com/819a044daa66718c2c40a48c1ba971e6.jpeg",
		image3: "http://img001.hc360.cn/y5/M00/1B/45/wKhQUVYFE0uEZ7zVAAAAAMj3H1w418.jpg",
		title: "红樱桃",
		price: 179,
		sales: 61,
	},
	{
		image: "/static/index/display/zs2.png",
		image2: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554013048&di=a3dc9fd1406dd7bad7fbb97b5489ec04&imgtype=jpg&er=1&src=http%3A%2F%2Fimg009.hc360.cn%2Fhb%2FnKo44ac2656F831c684507E3Da0E3a26841.jpg",
		image3: "http://img.zcool.cn/community/017a4e58b4eab6a801219c77084373.jpg",
		title: "青柚",
		price: 78,
		sales: 16,
	},
	{
		image: "/static/index/display/zs3.png",
		image2: "http://m.360buyimg.com/n12/jfs/t247/42/1078640382/162559/3628a0b/53f5ad09N0dd79894.jpg%21q70.jpg",
		image3: "http://ikids.61kids.com.cn/upload/2018-12-29/1546070626796114.jpg",
		title: "橙子",
		price: 108.8,
		sales: 5,
	}, {
		image: "/static/index/display/zs4.png",
		image2: "http://images.jaadee.com/images/201702/goods_img/30150_d85aed83521.jpg",
		image3: "http://img13.360buyimg.com/popWaterMark/jfs/t865/120/206320620/138889/dcc94caa/550acedcN613e2a9d.jpg",
		title: "阳光玫瑰",
		price: 265,
		sales: 88,
	}, {
		image: "/static/index/display/zs5.png",
		image2: "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553418265666&di=d4a7f7eb0ae3c859edeb921641ee1c3a&imgtype=0&src=http%3A%2F%2Fimg003.hc360.cn%2Fy3%2FM02%2FF8%2F9F%2FwKhQh1TuSkGELIlQAAAAAPuLl4M987.jpg",
		image3: "http://img.ef43.com.cn/product/2016/8/05100204b0c.jpg",
		title: "苹果",
		price: 422,
		sales: 137,
	}, {
        image: "/static/index/display/zs6.png",
		image2: "http://image5.suning.cn/uimg/b2c/newcatentries/0070158827-000000000622091973_2_800x800.jpg",
		image3: "http://img.61ef.cn/news/201903/20/2019032009251784.jpg",
		title: "枣子",
		price: 179,
		sales: 95,
	},
]

/* 购物车 */
const cartList = [
    {
        id: 1,
        userId: 6,
        fruitId: 1,
        image: "/static/index/display/zs1.png",
        description: "描述",
        stock: 10,
        title: "樱桃",
        price: 100,
        num: 1
    },
    {
        id: 2,
        userId: 6,
        fruitId: 1,
        image: "/static/index/display/zs1.png",
        description: "描述",
        stock: 10,
        title: "樱桃",
        price: 100,
        num: 1
    },
    {
        id: 3,
        userId: 6,
        fruitId: 1,
        image: "/static/index/display/zs1.png",
        description: "描述",
        stock: 10,
        title: "樱桃",
        price: 100,
        num: 1
    }

];
//详情展示页面
const detailData = {
	title: '纯种金毛幼犬活体有血统证书',
	title2: '拆家小能手 你值得拥有',
	favorite: true,
	imgList: [{
			src: 'http://img0.imgtn.bdimg.com/it/u=2396068252,4277062836&fm=26&gp=0.jpg'
		},
		{
			src: 'http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1309/06/c4/25310541_1378426131583.jpg'
		},
		{
			src: 'http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1610/26/c4/28926240_1477451226577_mthumb.jpg'
		},
		{
			src: 'http://picture.ik123.com/uploads/allimg/190219/12-1Z219105139.jpg'
		},
	],
	episodeList: [
		1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
	],
	guessList: [{
			src: 'http://img.52z.com/upload/news/image/20180530/20180530081619_31029.jpg',
			title: '猫眼指甲油',
			title2: '独树一帜的免照灯猫眼指甲'
		},
		{
			src: 'http://m.china-7.net/uploads/14778449362891.jpg',
			title: '创意屋',
			title2: '创意屋形上下双层高低床'
		},
		{
			src: 'http://www.k73.com/up/allimg/130415/22-130415093527.jpg',
			title: 'MissCandy 指甲油',
			title2: '十分适合喜欢素净的妹纸，尽显淡雅的气质'
		},
		{
			src: 'http://img0.imgtn.bdimg.com/it/u=2108933440,2194129200&fm=214&gp=0.jpg	',
			title: 'RMK 2017星空海蓝唇釉',
			title2: '唇釉质地，上唇后很滋润。少女也会心动的蓝色，透明液体形状。'
		}
	],
	evaList: [{
			src: 'http://gss0.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/77c6a7efce1b9d1663174705fbdeb48f8d546486.jpg',
			nickname: 'Ranth Allngal',
			time: '09-20 12:54',
			zan: '54',
			content: '评论不要太苛刻，不管什么产品都会有瑕疵，客服也说了可以退货并且商家承担运费，我觉得至少态度就可以给五星。'
		},
		{
			src: 'http://img0.imgtn.bdimg.com/it/u=2396068252,4277062836&fm=26&gp=0.jpg',
			nickname: 'Ranth Allngal',
			time: '09-20 12:54',
			zan: '54',
			content: '楼上说的好有道理。'
		}
	]
}
const shareList = [{
		type: 1,
		icon: '/static/temp/share_wechat.png',
		text: '微信好友'
	},
	{
		type: 2,
		icon: '/static/temp/share_moment.png',
		text: '朋友圈'
	},
	{
		type: 3,
		icon: '/static/temp/share_qq.png',
		text: 'QQ好友'
	},
	{
		type: 4,
		icon: '/static/temp/share_qqzone.png',
		text: 'QQ空间'
	}
]
const lazyLoadList = [{
		src: 'http://img0.imgtn.bdimg.com/it/u=2396068252,4277062836&fm=26&gp=0.jpg'
	},
	{
		src: 'http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1309/06/c4/25310541_1378426131583.jpg'
	},
	{
		src: 'http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1610/26/c4/28926240_1477451226577_mthumb.jpg'
	},
	{
		src: 'http://picture.ik123.com/uploads/allimg/190219/12-1Z219105139.jpg'
	},
	{
		src: 'http://img5.imgtn.bdimg.com/it/u=2904900134,438461613&fm=26&gp=0.jpg'
	},
	{
		src: 'http://img1.imgtn.bdimg.com/it/u=1690475408,2565370337&fm=26&gp=0.jpg'
	},
	{
		src: 'http://img.99114.com/group1/M00/7F/99/wKgGS1kVrPGAe5LmAAU2KrJmb3Q923_600_600.jpg'
	},
	{
		src: 'http://img4.imgtn.bdimg.com/it/u=261047209,372231813&fm=26&gp=0.jpg'
	},
	{
		src: 'http://i2.17173cdn.com/i7mz64/YWxqaGBf/tu17173com/20150107/eMyVMObjlbcvDEv.jpg'
	},
	{
		src: 'http://img008.hc360.cn/m4/M02/E7/87/wKhQ6FSrfU6EfUoyAAAAAITAfyc280.jpg'
	},
	{
		src: 'http://pic1.win4000.com/wallpaper/d/5991569950166.jpg'
	},
	{
		src: 'http://gss0.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/6f061d950a7b0208f9fe945e60d9f2d3572cc85e.jpg'
	},
	{
		src: 'http://pic41.nipic.com/20140429/18169759_125841756000_2.jpg'
	},
	{
		src: 'http://www.k73.com/up/allimg/130415/22-130415093527.jpg'
	},
	{
		src: 'http://img.52z.com/upload/news/image/20180530/20180530081619_31029.jpg'
	},
	{
		src: 'http://b-ssl.duitang.com/uploads/item/201410/02/20141002111638_tXAzU.jpeg'
	},
	{
		src: 'http://img2.ph.126.net/C4JW6f57QWSB21-8jh2UGQ==/1762596304262286698.jpg'
	},
	{
		src: 'http://att.bbs.duowan.com/forum/201405/17/190257nzcvkkdg6w2e8226.jpg'
	},
	{
		src: 'http://attach.bbs.miui.com/forum/201504/10/223644v3intigyvva0vgym.jpg'
	},
	{
		src: 'http://pic1.win4000.com/mobile/3/57888a298d61d.jpg'
	},
]

const orderList = [{
		time: '2019-04-06 11:37',
		state: 1,
		goodsList: [{
				image: 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553187020783&di=bac9dd78b36fd984502d404d231011c0&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201609%2F26%2F20160926173213_s5adi.jpeg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4031878334,2682695508&fm=11&gp=0.jpg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1620020012,789258862&fm=26&gp=0.jpg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4031878334,2682695508&fm=11&gp=0.jpg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1620020012,789258862&fm=26&gp=0.jpg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4031878334,2682695508&fm=11&gp=0.jpg',
			},
			{
				image: 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1620020012,789258862&fm=26&gp=0.jpg',
			}
		]
	},
	{
		time: '2019-04-06 11:37',
		state: 9,
		goodsList: [{
			title: '古黛妃 短袖t恤女 春夏装2019新款韩版宽松',
			price: 179.5,
			image: 'https://img13.360buyimg.com/n8/jfs/t1/30343/20/1029/481370/5c449438Ecb46a15b/2b2adccb6dc742fd.jpg',
			number: 1,
			attr: '珊瑚粉 M'
		}]
	},
	{
		time: '2019-04-06 11:37',
		state: 1,
		goodsList: [{
				image: 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/2120460599/O1CN01LBPS4C1GINkwsOTXS_!!2120460599.jpg_430x430q90.jpg',
			},
			{
				image: 'https://img.alicdn.com/imgextra/i2/1069876356/TB2ocTQG4WYBuNjy1zkXXXGGpXa_!!1069876356.jpg_430x430q90.jpg',
			},
			{
				image: 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i4/2120460599/O1CN01YsmgwZ1GINkv38rkn_!!2120460599.jpg_430x430q90.jpg',
			},
		]
	},
	{
		time: '2019-04-06 11:37',
		state: 1,
		goodsList: [{
			title: '回力女鞋高帮帆布鞋女学生韩版鞋子女2019潮鞋女鞋新款春季板鞋女',
			price: 69,
			image: 'https://img.alicdn.com/imgextra/i3/2128794607/TB2gzzoc41YBuNjy1zcXXbNcXXa_!!2128794607.jpg_430x430q90.jpg',
			number: 1,
			attr: '白色-高帮 39'
		}]
	},
	{
		time: '2019-04-06 11:37',
		state: 1,
		goodsList: [{
				image: 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i4/3358098495/O1CN01dhYyid2Ccl5MWLDok_!!3358098495.jpg_430x430q90.jpg',
			},
			{
				image: 'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/3358098495/O1CN01AWsnFA2Ccl5OzvqsL_!!3358098495.jpg_430x430q90.jpg',
			},
		]
	},
	{
		time: '2019-04-06 11:37',
		state: 1,
		goodsList: [{
				image: 'https://img.alicdn.com/imgextra/i4/3470687433/O1CN0124mMQOSERr18L1h_!!3470687433.jpg_430x430q90.jpg',
			},
			{
				image: 'https://img.alicdn.com/imgextra/i3/2888462616/O1CN01ERra5J1VCAbZaKI5n_!!0-item_pic.jpg_430x430q90.jpg',
			},
			{
				image: 'https://gd3.alicdn.com/imgextra/i3/819381730/O1CN01YV4mXj1OeNhQIhQlh_!!819381730.jpg_400x400.jpg',
			},
		]
	}

]
const cateList = [{
		id: 1,
		name: '新品上市'
	},
	{
		id: 2,
		name: '店长推荐'
	},
	{
		id: 3,
		name: '轻食果切'
	},
	{
		id: 4,
		name: '特色饮品'
	},
	{
		id: 5,
		pid: 1,
		name: '新品上市'
	},
	{
		id: 6,
		pid: 1,
		name: '进口新品'
	},
	{
		id: 8,
		pid: 5,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 9,
		pid: 5,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 10,
		pid: 5,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 11,
		pid: 5,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 12,
		pid: 5,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 14,
		pid: 6,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 15,
		pid: 6,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 16,
		pid: 6,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 17,
		pid: 2,
		name: '店长推荐',
	},
	{
		id: 18,
		pid: 2,
		name: '上期推荐',
	},
	{
		id: 19,
		pid: 17,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 20,
		pid: 17,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 21,
		pid: 18,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 22,
		pid: 18,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 23,
		pid: 18,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 24,
		pid: 18,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 25,
		pid: 3,
		name: '单水果拼盘'
	},
	{
		id: 26,
		pid: 3,
		name: '多水果拼盘'
	},
	{
		id: 27,
		pid: 25,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 28,
		pid: 25,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 29,
		pid: 26,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 30,
		pid: 26,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 31,
		pid: 26,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 32,
		pid: 26,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 33,
		pid: 4,
		name: '椰子汁',
	},
	{
		id: 34,
		pid: 4,
		name: '水果榨汁',
	},
	// {
	// 	id: 35,
	// 	pid: 4,
	// 	name: '童装',
	// },
	//  {
	// 	id: 39,
	// 	pid: 4,
	// 	name: '喂养用品',
	// },
	{
		id: 36,
		pid: 33,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 37,
		pid: 34,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	{
		id: 39,
		pid: 34,
		name: '樱桃',
		picture: '/static/index/display/zs1.png'
	},
	// {
	// 	id: 42,
	// 	pid: 35,
	// 	name: '婴童衣橱',
	// 	picture: '/static/temp/cate19.jpg'
	// },
	// {
	// 	id: 43,
	// 	pid: 39,
	// 	name: '吸奶器',
	// 	picture: '/static/temp/cate21.jpg'
	// },
	// {
	// 	id: 44,
	// 	pid: 39,
	// 	name: '儿童餐具',
	// 	picture: '/static/temp/cate22.jpg'
	// },
	// {
	// 	id: 45,
	// 	pid: 39,
	// 	name: '牙胶安抚',
	// 	picture: '/static/temp/cate23.jpg'
	// },
	// {
	// 	id: 46,
	// 	pid: 39,
	// 	name: '围兜',
	// 	picture: '/static/temp/cate24.jpg'
	// },
]

export default {
	carouselList,
	cartList,
	detailData,
	lazyLoadList,
	userInfo,
	shareList,
	goodsList,
	orderList,
	cateList
}
