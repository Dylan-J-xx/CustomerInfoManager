import Vue from 'vue'
import Router from 'vue-router'
// import Login from '@/components/Login'
import userList from '@/components/userList'
import managerList from '@/components/managerList'
import contactList from '@/components/contactList'
import serviceplay from '@/components/serviceplay'
import managerservice from '@/components/managerservice'
import serviceList from '@/components/serviceList'
import Login from '@/components/Login'
import superadmin from '@/components/superadmin'
import manager from '@/components/manager'
import user from '@/components/user'


// import HelloWorld from '@/components/HelloWorld'
// import index from '@/components/index'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    // {
    //   path:'/index',
    //   name:'index',
    //   component:index,
    //   children:[
    //     {
    //       path:'userList',
    //       name:'userList',
    //       component:userList
    //     }
    //   ]
    // },

    // {
    //   path:'/',
    //   name:'HelloWorld',
    //   component:HelloWorld
    // },
    {
      path: '/user',
      name: 'user',
      component: user,

    },
    {
      path: '/superadmin',
      name: 'superadmin',
      component: superadmin,
      children: [{
        path: 'managerList',
        name: 'managerList',
        component: managerList
      },
        {
          path: 'serviceList',
          name: 'serviceList',
          component: serviceList
        },
        {
          path: 'userList',
          name: 'userList',
          component: userList
        }
      ]
    },
    {
      path: '/manager',
      name: 'manager',
      component: manager,
      children: [{

        path: 'contactList',
        name: 'contactList',
        component: contactList


      },
        {
          path: 'serviceplay',
          name: 'serviceplay',
          component: serviceplay
        },
        {
          path: 'managerservice',
          name: 'managerservice',
          component: managerservice
        }
      ]
    }

  ]

})
