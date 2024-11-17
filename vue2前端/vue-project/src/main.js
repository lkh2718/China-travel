import Vue from 'vue'
import App from './new_file.vue'
import router from './router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
Vue.config.productionTip = false

//新添加的3行
import axios from 'axios';
// 设置 Axios 的基础 URL
axios.defaults.baseURL = '/';

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')




