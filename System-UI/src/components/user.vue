<template>
  <div>
    <iframe src="../../static/html/yinghua2.html" width="100%" height="100%"
            style="position: fixed; top: 0px; left: 0px;"></iframe>
    <div class="yh">
      <div style="">
        <el-form :model="moreList" label-width="150px">
          <el-form-item label="用户名" style="color: white;">{{ moreList.username }}</el-form-item>
          <el-form-item label="性别" style="color: white;">{{ moreList.sex }}</el-form-item>
          <el-form-item label="Id" style="color: white;">{{ moreList.userid }}</el-form-item>
          <el-form-item label="邮箱" style="color: white;">{{ moreList.useremail }}</el-form-item>
          <el-form-item label="照片">{{ moreList.image }}</el-form-item>
          <el-form-item label="出生日期" style="color: white;">{{ moreList.birthdate }}</el-form-item>
          <el-form-item label="学历" style="color: white;">{{ moreList.education }}</el-form-item>
          <el-form-item label="身份证号码" style="color: white;">{{ moreList.idcard }}</el-form-item>
          <el-form-item label="客户单位" style="color: white;">{{ moreList.customerunit }}</el-form-item>
          <el-form-item label="客户经理" style="color: white;">{{ moreList.managername }}</el-form-item>
          <el-form-item label="备注" style="color: white;">{{ moreList.other }}</el-form-item>
          <el-button @click="exit">返回</el-button>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      moreList: [],
      Url: "http://localhost:8080/user",
    }
  },
  methods: {
    load: function () {
      var mythis = this;
      var userid = sessionStorage.getItem("userid");
      console.log(userid);
      $.ajax({
        url: mythis.Url + "/selectById",
        type: "get",
        dataType: "json",
        data: {
          "userid": userid
        },
        success: function (data) {
          if (data.info != null) {
            mythis.moreList = data.info;
          }
        }
      })
    },
    exit: function () {
      var mythis = this;
      mythis.$router.replace("/");
    }

  },
  mounted: function () {
    this.load();
  }

}
</script>

<style>
.yh {
  position: absolute;
  top: 40px;
  left: 450px;
  border-radius: 5px;
  width: 500px;
  height: 550px;
  border: 0px;
  padding: 50px;
  margin: 20px;
  border-style: solid;
}
</style>
