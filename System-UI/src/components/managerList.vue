<template style="background-color: cadetblue;">
  <div>
    <div>
      <el-input v-model="like" placeholder="请输入内容" style="width: 300px;"></el-input>
      <el-button @click="add" type="success" icon="el-icon-document-add" circle></el-button>
      <el-button @click="selectBymanagerName" icon="el-icon-search" circle></el-button>
    </div>
    <el-table :data="managerList" style="width: 30;">
      <el-table-column prop="managername" label="姓名" width="180">
      </el-table-column>
      <el-table-column prop="managertel" label="电话" width="180">
      </el-table-column>
      <el-table-column prop="manageremail" label="邮箱">
      </el-table-column>
      <el-table-column prop="other" label="备注">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="more(scope)" type="success" icon="el-icon-s-custom" circle></el-button>
          <el-button @click="update(scope)" type="primary" icon="el-icon-circle-plus" circle></el-button>
          <el-button @click="del(scope)" type="danger" icon="el-icon-remove" circle></el-button>
        </template>
      </el-table-column>

    </el-table>
    <div>
      <el-dialog :title="title" :visible="isShowChange" width="30%" :show-close="false">
        <el-form :model="manager" label-width="80px">
          <el-form-item label="用户名">
            <input type="hidden" v-model="manager.managerid"></input>
            <input type="text" v-model="manager.managername"/>
          </el-form-item>
          </el-form-item>
          <el-form-item label="邮箱">
            <input type="text" v-model="manager.manageremail"/>
          </el-form-item>
          <el-form-item label="备注">
            <input type="text" v-model="manager.other"/>
          </el-form-item>
          <el-form-item label="密码">
            <input type="text" v-model="manager.managerpassword"/>
          </el-form-item>
          <el-button @click="close">取 消</el-button>
          <el-button type="primary" @click="save">保存</el-button>
        </el-form>
      </el-dialog>
    </div>
    <div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="curPage"
                     :page-sizes="[3, 4, 5]" :page-size="manager.row" layout="total, sizes, prev, pager, next, jumper"
                     :total="totalCount">
      </el-pagination>

    </div>
    <div>
      <el-dialog :title="title" :visible="isShowMore" width="30%" :show-close="false">
        <el-form :model="moreList" label-width="150px">
          <el-form-item label="用户名">{{ moreList.mangername }}</el-form-item>
          <el-form-item label="性别">{{ moreList.sex }}</el-form-item>
          <el-form-item label="Id">{{ moreList.managerid }}</el-form-item>
          <el-form-item label="账户">{{ moreList.manageraccount }}</el-form-item>
          <el-form-item label="邮箱">{{ moreList.manageremail }}</el-form-item>
          <el-form-item label="照片">{{ moreList.image }}</el-form-item>
          <el-form-item label="出生日期">{{ moreList.birthdate }}</el-form-item>
          <el-form-item label="学历">{{ moreList.education }}</el-form-item>
          <el-form-item label="身份证号码">{{ moreList.idcard }}</el-form-item>
          <el-form-item label="备注">{{ moreList.other }}</el-form-item>
          <el-button @click="close">取 消</el-button>
        </el-form>
      </el-dialog>
    </div>

  </div>

</template>

<script>
export default {
  data() {
    return {
      manager: {
        managerid: "",
        managername: "",
        manageremail: "",
        other: "",
        managerpassword: ""


      },
      managerList: [],
      like: "",
      isShowChange: false,
      title: "",
      moreList: [],
      page: 1, //页码
      row: 3, //每页显示条数
      totalCount: "", //总条数
      totalPage: "", //总页数
      curPage: "", //当前页
      isShowMore: false,


    }
  },
  methods: {
    load: function () {
      var mythis = this;
      $.ajax({
        url: "http://localhost:8080/manager/findAllManagerByPage",
        dataType: 'json', //服务器返回json格式数据
        type: 'get', //HTTP请求类型
        timeout: 10000, //超时时间设置为10秒；
        data: {
          "pageNum": mythis.page,
          "row": mythis.row
        },
        success: function (data) {
          if (data != null) {
            mythis.managerList = data.managerList;
            mythis.curPage = data.curPage;
            mythis.totalCount = data.total;
          }

        },
        error: function (xhr, type, errorThrown) {

        }
      });
    },
    del: function (manager) {

      var mythis = this;
      $.ajax({
        url: "http://localhost:8080/manager/del",

        data: {
          "managerId": manager.row.managerid
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
      mythis.manager.managername = "";
      mythis.manager.managertel = "";
      mythis.manager.manageremail = "";
      mythis.manager.other = "";
      mythis.manager.managerpassword = "";
    },
    close: function () {
      var mythis = this;
      mythis.isShowChange = false;
      mythis.isShowMore = false;
    },
    save: function (data) {
      var mythis = this;
      var managername = mythis.manager.managername;
      if (managername != null && managername.length != 0) {
        if (mythis.title == "添加") {
          $.ajax({
            url: "http://localhost:8080/manager/add",

            data: {
              "managername": managername,
              "manageremail": mythis.manager.manageremail,
              "other": mythis.manager.other,
              "managerpassword": mythis.manager.managerpassword
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
            url: "http://localhost:8080/manager/update",
            data: {
              "managername": managername,
              "manageremail": mythis.manager.manageremail,
              "other": mythis.manager.other,
              "managerid": mythis.manager.managerid,

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
    update: function (manager) {
      var mythis = this;
      var managerid = manager.row.managerid;
      mythis.title = "修改";
      mythis.isShowChange = true;
      //清空数据
      mythis.manager.managername = "";
      mythis.manager.managertel = "";
      mythis.manager.manageremail = "";
      mythis.manager.other = "";
      mythis.manager.managerpassword = "";
      $.ajax({
        url: "http://localhost:8080/manager/selectById",

        data: {
          "managerid": managerid
        },
        dataType: "json",
        type: "get",
        success: function (data) {
          if (data.info != null) {
            mythis.manager = data.info;
          }
        }
      })
    },
    selectBymanagerName: function () {
      var mythis = this;
      var like = mythis.like;
      console.log(like);
      if (like != null && like.length != 0) {
        $.ajax({
          url: "http://localhost:8080/manager/selectBymanagerName",

          type: "get",
          dataType: "json",
          data: {
            "managerName": like
          },

          success: function (data) {
            console.log(data);
            if (data.info != null) {
              mythis.managerList = data.info;
            } else {
              mythis.managerList = "";
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
    },
    more: function (manager) {
      var mythis = this;
      mythis.isShowMore = true;
      mythis.title = "详细信息";
      $.ajax({
        url: "http://localhost:8080/manager/selectById",
        type: "get",
        dataType: "json",
        data: {
          "managerid": manager.row.managerid
        },
        success: function (data) {
          if (data.info != null) {
            mythis.moreList = data.info;
          }
        }
      })
    }


  },
  mounted: function () {
    this.load();

  }

}
</script>

<style>
</style>
