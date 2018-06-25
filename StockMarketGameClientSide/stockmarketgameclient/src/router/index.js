import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Dashboard from '@/components/Dashboard'
import Layout from '@/components/Layout'
import Login from '@/components/Login'
import MyShares from '@/components/MyShares'
import WatchList from '@/components/WatchList'
import SharePrice from '@/components/SharePrice'
import PurchaseHistory from '@/components/PurchaseHistory'
import TransactionHistory from '@/components/TransactionHistory'
import AllPlayers from '@/components/AllPlayers'
import PreviousRound from '@/components/PreviousRound'

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
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/share',
      name: 'MyShares',
      component: MyShares
    },
    {
      path: '/watch',
      name: 'WatchList',
      component: WatchList
    },
    {
      path: '/shareprice',
      name: 'SharePrice',
      component: SharePrice
    },
    {
      path: '/purchasehistory',
      name: 'PurchaseHistory',
      component: PurchaseHistory
    },
    {
      path: '/transactionhistory',
      name: 'TransactionHistory',
      component: TransactionHistory
    },
    {
      path: '/allplayers',
      name: 'AllPlayers',
      component: AllPlayers
    },
    {
      path: '/previousround',
      name: 'PreviousRound',
      component: PreviousRound
    }

  ]
})
