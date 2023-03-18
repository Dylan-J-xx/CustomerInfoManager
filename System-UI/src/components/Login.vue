<template>
  <div>
    <iframe src="../../static/html/yinghua2.html" width="100%" height="100%"
            style="position: fixed; top: 0px; left: 0px;"></iframe>
    <iframe src="../../static/html/sbtx2.html" width="100%" height="100%"
            style="position: fixed; top: 0px; left: 0px;"></iframe>
    <div class="center">
      <div style="font-size:75px; opacity: 0.5;">Welcome</div>
    </div>
    <div class="xm">
      <div style="font-size: 30px; left: 200px; opacity: 0.5;">账户</div>
    </div>
    <el-input type="text" prefix-icon="el-icon-user" v-model="account" placeholder="请输入账户"
              style="position: absolute; width: 300px; top: 300px; left: 630px;opacity: 0.5;"></el-input>
    <div class="mm">
      <div style="font-size: 30px; left: 200px; opacity: 0.5;">密码</div>
    </div>
    <el-input prefix-icon="el-icon-cherry" v-model="pass" placeholder="请输入密码"
              style="position: absolute; width: 300px; top: 370px; left: 630px;opacity: 0.5;" show-password></el-input>
    <a @click="login" style="position: relative;left: 500px;top: 450px;">Login</a>
    <a @click="reload" style="position: relative;left: 530px;top: 450px;">Enroll</a>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pass: "",
      account: "",
      Url: "http://localhost:8080/"
    }
  },
  methods: {

    login: function () {
      var mythis = this;
      var account = mythis.account;
      var pass = mythis.pass;
      $.ajax({
        url: mythis.Url + "login",
        type: "get",
        datatype: "json",
        data: {
          "account": account,
          "password": pass
        },
        success: function (data) {
          console.log(data);
          if (data.info == "管理员登录成功") {
            alert("您的身份是管理员，登录成功");
            sessionStorage.setItem("superadminname", data.data.superadminname);
            mythis.$router.replace("superadmin");
          } else if (data.info == "客户登录成功") {
            alert("您的身份是客户，登录成功！")
            sessionStorage.setItem("userid", data.data.userid);
            mythis.$router.replace("user");
          } else if (data.info == "客户经理登录成功") {
            alert("您的身份是客户经理，登录成功");
            mythis.$router.replace("manager");
            sessionStorage.setItem("managername", data.data.managername);

          } else {
            alert("账号或密码错误，请重试！")
            mythis.reload();
          }
        }
      })

    },
    reload: function () {
      mythis.$router.replace("Login");
    }
  },

}
</script>
<style>
.center {
  position: absolute;
  width: 200px;
  height: 100px;
  right: 800px;
  bottom: 500px;
}

.xm {
  position: absolute;
  width: 100px;
  height: 50px;
  right: 900px;
  top: 300px;
}

.mm {
  position: absolute;
  width: 100px;
  height: 50px;
  right: 900px;
  top: 370px;
}

a {
  position: relative;
  padding: 10px 30px;
  margin: 0 45px;
  color: #706188;
  text-decoration: none;
  font-size: 20px;
  text-transform: uppercase;
  transition: 0.5s;
  overflow: hidden;
  -webkit-box-reflect: below 1px linear-gradient(transparent, #0003);
}

a:hover {
  background: #706188;
  color: #111;
  box-shadow: 0 0 50px #706188;
  transition-delay: 0.5s;
}

a:nth-child(1) {
  filter: hue-rotate(115deg);
}


a::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 10px;
  border-top: 2px solid #706188;
  border-left: 2px solid #706188;
  transition: 0.5s;
  transition-delay: 0.5s;
}

a:hover::before {
  width: 100%;
  height: 100%;
  transition-delay: 0s;
}

a::after {
  content: '';
  position: absolute;
  right: 0;
  bottom: 0;
  width: 10px;
  height: 10px;
  border-bottom: 2px solid #706188;
  border-right: 2px solid #706188;
  transition: 0.5s;
  transition-delay: 0.5s;
}

a:hover::after {
  width: 100%;
  height: 100%;
  transition-delay: 0s;
}
</style>
