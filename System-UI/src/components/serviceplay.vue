<template>
  <el-form ref="form" :model="form" label-width="80px">
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button @click="reload">重置</el-button>
    <el-form-item label="服务名称">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
    <el-form-item label="服务类型">
      <el-select v-model="form.type" placeholder="请选择服务类型">
        <el-option label="上门服务" value="上门服务"></el-option>
        <el-option label="解决客户投诉" value="解决客户投诉"></el-option>
        <el-option label="客户培训" value="客户培训"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="服务时间">
      <el-col :span="11">
        <el-date-picker type="date" placeholder="选择日期" v-model="form.date" style="width: 100%;"></el-date-picker>
      </el-col>
      <el-col class="line" :span="2">-</el-col>
      <el-col :span="11">
        <el-input placeholder="选择时间" v-model="form.time" style="width: 100%;"></el-input>
      </el-col>
    </el-form-item>

    </el-form-item>
  </el-form>
</template>
<script>
export default {
  data() {
    return {
      form: {
        name: '',
        type: '',
        date: '',
        time: '',
      }
    }
  },
  methods: {
    onSubmit: function () {
      alert("创建成功");

      var mythis = this;
      mythis.reload();
      $.ajax({
        url: "http://localhost:8080/service/submit",
        data: {
          "type": mythis.form.type,
          "date": mythis.form.date,
          "time": mythis.form.time
        },
        datatype: "json",
        type: "get",
        success: function (data) {
          if (data.info != null) {
            alert("创建成功");

          }
        }
      })

    },
    reload: function () {
      this.$router.replace("serviceplay");
      var mythis = this;
      mythis.form.date = "";
      mythis.form.name = "";
      mythis.form.time = "";
      mythis.form.type = "";
    }
  }
}

</script>

<style>
</style>
