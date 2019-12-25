import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		hasLogin: false,
		userInfo: {},
        addressList:[]
	},
	mutations: {
		login(state, provider) {
			console.log("login--")
			console.log(state)
			console.log(provider)
			state.hasLogin = true;
			state.userInfo = provider;
			uni.setStorage({//缓存用户登陆状态
			    key: 'userInfo',  
			    data: provider  
			}) 
			console.log(state.userInfo);
		},
        addressListSave(state,provider){
		  console.log("SaveMyAddressList")
		  console.log(provider)
          state.addressList = provider;
            uni.setStorage({//缓存用户地址信息
                key: 'addressList',
                data: provider
            })
            console.log(state.addressList);
        },
		logout(state) {
			state.hasLogin = false;
			state.userInfo = {};
            state.addressList = []
			uni.removeStorage({  
                key: 'userInfo'  
            })
		}
	},
	actions: {
	
	}
})

export default store
