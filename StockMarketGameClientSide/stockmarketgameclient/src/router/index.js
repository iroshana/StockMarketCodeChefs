import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Dashboard from '@/components/Dashboard'
import Layout from '@/components/Layout'

Vue.use(Router)

export default new Router({
  routes: [    
    {
      path:'/home',
      name: 'Layout',
      component: Layout
    },
    {
      path: '/test',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
    }

  ]
})
