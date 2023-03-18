<template>
  <div>
    <div>
      <el-input v-model="like" placeholder="请输入内容" style="width: 300px;"></el-input>
      <el-button @click="selectByuserName" icon="el-icon-search" circle></el-button>
    </div>
    <el-table :data="serviceList" style="width: 30; background-color: cadetblue;">
      <el-table-column prop="username" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="type" label="服务类型" width="180">
      </el-table-column>
      <el-table-column prop="date" label="服务日期">
      </el-table-column>
      <el-table-column prop="time" label="服务时间">
      </el-table-column>
      <el-table-column prop="satisfaction" label="客户满意度">
      </el-table-column>
    </el-table>
    <div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="curPage"
                     :page-sizes="[3, 4, 5]" :page-size="serviceList.row"
                     layout="total, sizes, prev, pager, next, jumper"
                     :total="totalCount">
      </el-pagination>
    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {
      serviceList: [],
      like: "",
      Url: "http://localhost:8080",
      page: 1, //页码
      row: 3, //每页显示条数
      totalCount: "", //总条数
      totalPage: "", //总页数
      curPage: "", //当前页
    }
  },
  methods: {
    load: function () {
      var mythis = this;
      $.ajax({
        url: "http://localhost:8080/service/findAllserviceByPage",

        dataType: 'json', //服务器返回json格式数据
        type: 'get', //HTTP请求类型
        timeout: 10000, //超时时间设置为10秒；
        data: {
          "pageNum": mythis.page,
          "row": mythis.row,
        },
        success: function (data) {
          if (data != null) {
            mythis.serviceList = data.list;
            mythis.curPage = data.curPage;
            mythis.totalCount = data.total;
          }

        },
        error: function (xhr, type, errorThrown) {

        }
      });
    },
    selectByuserName: function () {
      var mythis = this;
      var like = mythis.like;
      if (like != null && like.length != 0) {
        $.ajax({
          url: "http://localhost:8080/service/selectByserviceName",

          type: "get",
          dataType: "json",
          data: {
            "userName": like
          },

          success: function (data) {
            console.log(data);
            if (data.selectinfo != null) {
              mythis.serviceList = data.selectinfo;
            } else {
              mythis.serviceList = "";
            }
          },
          error: function (xhr, type, errorThrown) {

          }
        })
      } else {
        mythis.load();
      }
    },
    handleSizeChange(val) { //下来框选中条数触发的事件
      //更改每页显示条数

      this.row = val;
      //刷新
      this.load();

    },
    handleCurrentChange(val) { //当前页触发的事件
      //更改页码
      this.page = val;
      //刷新
      this.load();
    }


  },
  mounted: function () {
    this.load();

  }

}
</script>

<style>
</style>
