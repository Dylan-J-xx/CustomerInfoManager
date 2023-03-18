<template>
  <div>
    <div>
      <el-input v-model="like" placeholder="请输入内容" style="width: 300px;"></el-input>
      <el-button @click="selectByuserName" icon="el-icon-search" circle></el-button>
    </div>
    <el-table :data="serviceList" style="width: 30;">
      <el-table-column prop="username" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="type" label="服务类型" width="180">
      </el-table-column>
      <el-table-column prop="date" label="服务日期">
      </el-table-column>
      <el-table-column prop="time" label="服务时间">
      </el-table-column>
      <el-table-column prop="managername" label="客户经理">
      </el-table-column>
      <el-table-column prop="satisfaction" label="客户满意度">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="update(scope)" type="primary" icon="el-icon-circle-plus" circle></el-button>
          <el-button @click="del(scope)" type="danger" icon="el-icon-remove" circle></el-button>
        </template>
      </el-table-column>

    </el-table>
    <div>
      <el-dialog :title="title" :visible="isShowChange" width="30%" :show-close="false">
        <el-form :model="service" label-width="150px">
          <el-form-item label="用户名">
            <input type="hidden" v-model="service.serviceid"></input>
            <input type="text" v-model="service.username"/>
          </el-form-item>
          <el-form-item label="服务类型">
            <template>
              <el-select v-model="service.type" placeholder="请选择">
                <el-option v-for="x in serviceoptions" :key="x.value" :label="x.label" :value="x.value">
                </el-option>
              </el-select>
            </template>
          </el-form-item>
          <el-form-item label="服务日期">
            <input type="text" v-model="service.date"/>
          </el-form-item>
          <el-form-item label="服务时间">
            <input type="text" v-model="service.time"/>
          </el-form-item>
          <el-form-item label="客户经理">
            <input type="text" v-model="service.managername"/>
          </el-form-item>
          <el-form-item label="客户满意度">
            <template>
              <el-select v-model="service.satisfaction" placeholder="请选择">
                <el-option v-for="y in satisfactionoptions" :key="y.value" :label="y.label" :value="y.value">
                </el-option>
              </el-select>
            </template>
          </el-form-item>
          <el-button @click="close">取 消</el-button>
          <el-button type="primary" @click="save">保存</el-button>
        </el-form>
      </el-dialog>
    </div>
    <div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="curPage"
                     :page-sizes="[3, 4, 5]" :page-size="service.row" layout="total, sizes, prev, pager, next, jumper"
                     :total="totalCount">
      </el-pagination>

    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {
      service: {
        serviceid: "",
        username: "",
        type: "",
        date: "",
        time: "",
        managername: "",
        satisfaction: ""


      },
      serviceList: [],
      like: "",
      isShowChange: false,
      title: "",
      page: 1, //页码
      row: 3, //每页显示条数
      totalCount: "", //总条数
      totalPage: "", //总页数
      curPage: "", //当前页
      serviceoptions: [{
        value: '上门服务',
        label: '上门服务'
      }, {
        value: '解决客户投诉',
        label: '解决客户投诉'
      }],
      satisfactionoptions: [{
        value: '很满意',
        label: '很满意'
      }, {
        value: '比较满意',
        label: '比较满意'
      }, {
        value: '不满意',
        label: '不满意'
      }, {
        value: '很不满意',
        label: '很不满意'
      }]


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
    del: function (service) {

      var mythis = this;
      $.ajax({
        url: "http://localhost:8080/service/delete",

        data: {
          "serviceid": service.row.serviceid
        },
        dataType: 'json', //服务器返回json格式数据
        type: 'get', //HTTP请求类型
        timeout: 10000, //超时时间设置为10秒；
        success: function (data) {
          if (data.info == "删除成功") {
            alert("删除成功");
            mythis.load();
          }
        },
        error: function (xhr, type, errorThrown) {
          alert("删除失败");

        }
      });
    },
    add: function () {
      var mythis = this;
      mythis.isShowChange = true;
      mythis.title = "添加";
      //数据清空
      mythis.service.userName = "";
      mythis.service.type = "";
      mythis.service.date = "";
      mythis.service.time = "";
      mythis.service.managerName = "";
      mythis.service.satisfaction = "";
    },
    close: function () {
      var mythis = this;
      mythis.isShowChange = false;
    },
    save: function (data) {
      var mythis = this;
      var username = mythis.service.username;
      if (username != null && username.length != 0) {
        if (mythis.title == "添加") {
          $.ajax({
            url: "http://localhost:8080/service/insert",

            data: {
              "username": username,
              "type": mythis.service.type,
              "date": mythis.service.date,
              "time": mythis.service.time,
              "managername": mythis.service.managername,
              "satisfaction": mythis.service.satisfaction
            },
            dataType: 'json', //服务器返回json格式数据
            type: 'get', //HTTP请求类型
            timeout: 10000, //超时时间设置为10秒；
            success: function (data) {
              if (data.info != null) {
                alert("保存成功");
                mythis.close();
                mythis.load();
              } else {
                alert("错误");
              }

            },
            error: function (xhr, type, errorThrown) {

            }
          });
        } else {
          $.ajax({
            url: "http://localhost:8080/service/update",

            data: {
              "username": username,
              "type": mythis.service.type,
              "date": mythis.service.date,
              "time": mythis.service.time,
              "managername": mythis.service.managername,
              "satisfaction": mythis.service.satisfaction,
              "serviceid": mythis.service.serviceid
            },
            type: "get",
            dataType: "json",
            success: function (data) {
              if (data.info == "修改成功") {
                alert("修改成功");
                mythis.close();
                mythis.load();
              } else {
                alert("错误");
              }

            }
          })
        }
      } else {
        alert("请至少填写用户名!");
      }

    },
    update: function (service) {
      var mythis = this;
      var serviceid = service.row.serviceid;

      mythis.title = "修改";
      mythis.isShowChange = true;
      //清空数据
      mythis.service.username = "";
      mythis.service.type = "";
      mythis.service.date = "";
      mythis.service.time = "";
      mythis.service.managername = "";
      mythis.service.satisfaction = "";
      $.ajax({
        url: "http://localhost:8080/service/selectByserviceid",

        data: {
          "serviceid": serviceid
        },
        dataType: "json",
        type: "get",
        success: function (data) {
          if (data.info != null) {
            mythis.service = data.info;
          }
        }
      })
    },
    selectByuserName: function () {
      var mythis = this;
      var like = mythis.like;
      console.log(like);
      if (like != null && like.length != 0) {
        $.ajax({
          url: "http://localhost:8080/service/selectByserviceName",
          type: "get",
          dataType: "json",
          data: {
            "serviceName": like
          },

          success: function (data) {
            console.log(data);
            if (data.info != null) {
              mythis.serviceList = data.info;
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
