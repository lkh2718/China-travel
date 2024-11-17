<template>
<div>
  <!-- <h1>{{message}}</h1> -->
<!-- <fuel-management></fuel-management>
<stuff-management></stuff-management> -->
<router-view></router-view>
</div>
</template>

<script>
/* import FuelManagement from './views/element/FuelManagement.vue'
import StuffManagement from './views/element/StuffManagement.vue'
 */
export default {
  components: { /* StuffManagement, FuelManagement */ },
  
  data () {
    return {
      message:"Hello,vue"
    }
  }
}
</script>

<style>

</style>
