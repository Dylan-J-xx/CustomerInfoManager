<template>
  <div>
    <div>
      <el-input v-model="like" placeholder="请输入内容" style="width: 300px;"></el-input>
      <el-button @click="add" type="success" icon="el-icon-document-add" circle></el-button>
      <el-button @click="selectByuserName" icon="el-icon-search" circle></el-button>
    </div>
    <div class="bg">
      <el-table :data="userList" style="width: 30;">
        <el-table-column prop="username" label="姓名" width="180" class="1">
        </el-table-column>
        <el-table-column prop="useremail" label="邮箱">
        </el-table-column>
        <el-table-column prop="managername" label="客户经理">
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
    </div>
    <div>
      <el-dialog :title="title" :visible="isShowChange" width="30%" :show-close="false">
        <el-form :model="user" label-width="80px">
          <el-form-item label="用户名">
            <input type="hidden" v-model="user.userid"></input>
            <input type="text" v-model="user.username"/>
          </el-form-item>
          <el-form-item label="邮箱">
            <input type="text" v-model="user.useremail"/>
          </el-form-item>
          <el-form-item label="客户经理">
            <input type="text" v-model="user.managername"/>
          </el-form-item>
          <el-form-item label="备注">
            <input type="text" v-model="user.other"/>
          </el-form-item>
          <el-form-item label="密码">
            <input type="text" v-model="user.userpassword"/>
          </el-form-item>

          <el-button @click="close">取 消</el-button>
          <el-button type="primary" @click="save">保存</el-button>
        </el-form>
      </el-dialog>
    </div>
    <div>
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="curPage"
                     :page-sizes="[3, 4, 5]" :page-size="userList.row" layout="total, sizes, prev, pager, next, jumper"
                     :total="totalCount">
      </el-pagination>

    </div>
    <div>
      <el-dialog :title="title" :visible="isShowMore" width="30%" :show-close="false">
        <el-form :model="moreList" label-width="150px">
          <el-form-item label="用户名">{{ moreList.username }}</el-form-item>
          <el-form-item label="性别">{{ moreList.sex }}</el-form-item>
          <el-form-item label="Id">{{ moreList.userid }}</el-form-item>
          <el-form-item label="账户">{{ moreList.useraccount }}</el-form-item>
          <el-form-item label="邮箱">{{ moreList.useremail }}</el-form-item>
          <el-form-item label="照片">{{ moreList.image }}</el-form-item>
          <el-form-item label="出生日期">{{ moreList.birthdate }}</el-form-item>
          <el-form-item label="学历">{{ moreList.education }}</el-form-item>
          <el-form-item label="身份证号码">{{ moreList.idcard }}</el-form-item>
          <el-form-item label="客户单位">{{ moreList.customerunit }}</el-form-item>
          <el-form-item label="客户经理">{{ moreList.managername }}</el-form-item>
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
      user: {
        userid: "",
        username: "",
        useremail: "",
        managername: "",
        other: "",
        userpassword: ""


      },
      userList: [],
      like: "",
      Url: "http://localhost:8080/user",
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
        url: mythis.Url + "/findAllUserByPage",
        dataType: 'json', //服务器返回json格式数据
        type: 'get', //HTTP请求类型
        timeout: 10000, //超时时间设置为10秒；
        data: {
          "pageNum": mythis.page,
          "row": mythis.row
        },
        success: function (data) {
          console.log(data.userList);
          if (data != null) {
            mythis.userList = data.userList;
            mythis.curPage = data.curPage;
            mythis.totalCount = data.total;
          }

        },
        error: function (xhr, type, errorThrown) {

        }
      });
    },
    del: function (user) {

      var mythis = this;
      console.log(user.row.userid);
      $.ajax({
        url: mythis.Url + "/del",
        data: {
          "userId": user.row.userid
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
      mythis.user.username = "";
      mythis.user.usertel = "";
      mythis.user.useremail = "";
      mythis.user.managername = "";
      mythis.user.other = "";
      mythis.user.userpassword = "";
    },
    close: function () {
      var mythis = this;
      mythis.isShowChange = false;
      mythis.isShowMore = false;
    },
    save: function (data) {
      var mythis = this;
      var username = mythis.user.username;
      if (username != null && username.length != 0) {
        if (mythis.title == "添加") {
          $.ajax({
            url: mythis.Url + "/add",
            data: {
              "username": username,
              "useremail": mythis.user.useremail,
              "managername": mythis.user.managername,
              "other": mythis.user.other,
              "userpassword": mythis.user.userpassword

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
              alert("1")

            }
          });
        } else {
          $.ajax({
            url: mythis.Url + "/update",
            data: {
              "username": username,
              "useremail": mythis.user.useremail,
              "managername": mythis.user.managername,
              "other": mythis.user.other,
              "userid": mythis.user.userid
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

            },
            error: function (xhr, type, errorThrown) {
              alert("1")

            }
          })
        }
      } else {
        alert("请至少填写用户名!");
      }

    },
    update: function (user) {
      var mythis = this;
      var userid = user.row.userid;
      mythis.title = "修改";
      mythis.isShowChange = true;
      //清空数据
      mythis.user.username = "";
      mythis.user.usertel = "";
      mythis.user.useremail = "";
      mythis.user.managername = "";
      mythis.user.other = "";
      $.ajax({
        url: mythis.Url + "/selectById",
        data: {
          "userid": userid
        },
        dataType: "json",
        type: "get",
        success: function (data) {
          if (data.info != null) {
            mythis.user = data.info;
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
          url: mythis.Url + "/selectByuserName",
          type: "get",
          dataType: "json",
          data: {
            "userName": like
          },

          success: function (data) {
            console.log(data);
            if (data.info != null) {
              mythis.userList = data.info;
            } else {
              mythis.userList = "";
            }
          },
          error: function (xhr, type, errorThrown) {
            alert("1")

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
    more: function (user) {
      var mythis = this;
      mythis.isShowMore = true;
      mythis.title = "详细信息";
      $.ajax({
        url: mythis.Url + "/selectById",
        type: "get",
        dataType: "json",
        data: {
          "userid": user.row.userid
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
/*最外层透明*/
::v-deep .el-table,
::v-deep .el-table__expanded-cell {
  background-color: transparent !important;
}

/* 表格内背景颜色 */
::v-deep .el-table th,
::v-deep .el-table tr,
::v-deep .el-table td {
  background-color: transparent !important;
}
</style>
