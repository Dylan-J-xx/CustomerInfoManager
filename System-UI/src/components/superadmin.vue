<template>
  <div class="lo">
    <el-container>
      <div class="tupian">
        <iframe src="../../static/html/xr1.html" width="100%" height="100%" style="position: absolute; "
                class="ss"></iframe>
      </div>


      <el-container>

        <el-aside width="200px">
          <div class="id">
            <el-col span="8">
              <img @click="exit" src="../../static/image/stwb.jpeg" style="height: 50px; width: 50px;"/>
              <span>用户:{{ admin }}</span>
            </el-col>
          </div>
          <el-menu :default-openeds="['1']" router>
            <el-submenu class="tm" index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>用户管理</span>
              </template>
              <el-menu-item class="tm1" index="/superadmin/userList">客户信息</el-menu-item>
              <el-menu-item class="tm2" index="/superadmin/serviceList">服务信息</el-menu-item>
              <el-menu-item class="tm3" index="/superadmin/managerList">客户经理信息</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      admin: ""
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    load: function () {
      var mythis = this;
      var superadminname = sessionStorage.getItem("superadminname");
      mythis.admin = superadminname;
    },
    exit: function () {
      var mythis = this;
      mythis.$router.replace("/");
    }
  },
  mounted: function () {
    this.load()
  }
}
</script>

<style>
.tm, .tm1, .tm2, .tm3 {
  background-color: cadetblue;
}

.lo {
  width: 100%;
  height: 100%;
  background-color: cadetblue;
  background-image: url();
  background-repeat: no-repeat;
  background-size: 100% 100%;
  margin: 0;
  padding: 0;
  top: 0;
  position: fixed;
}

.id {
  height: 100px;
}

.tupian {
  position: absolute;
  top: 200px;
  left: 900px;
  border-radius: 0px;
  width: 500px;
  height: 550px;
  border: 0px;
  margin: 20px;
  border-style: none;

}

.ss {
  border: medium none;
}
</style>
