<template>
<div id="main">
  <Layout></Layout>
  <Login v-show="isLogin"></Login>

  </div>
</template>

<script>
import Layout from '@/components/Layout'
import Login from '@/components/Login'

export default {
  name: 'App',
  components:{Layout, Login},
  data:{
      isLogin: true
  },
  methods:{
      changecomponent: function(){

      }
  }
  
}
</script>


