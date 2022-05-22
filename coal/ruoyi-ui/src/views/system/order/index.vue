<template>
  <div class="app-container">
  <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>    
    </el-row>

    <el-table  :data="orderList" >
      <el-table-column label="工单编号" prop="orderId" width="120" />
      <el-table-column label="工单状态" prop="orderStatus" align="center" width="100"/>>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180"/>>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope" >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >派遣</el-button>
      </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />


    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="工单名称" prop="orderName">
          <el-input v-model="form.orderName" placeholder="请输入角色名称" />
        </el-form-item>

        <el-form-item label="备注">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>

export default {
  name: "Order",
  dicts: [],
  data() {
    return {
       orderList: [],
       total: 0,
       queryParams: {
        pageNum: 1,
        pageSize: 10       
      },
      form: {},
      open: false,
      title: ""
    };
  },
  created() {
    this.getList();
  },
  methods: {
    handleAdd() {  
      this.open = true;
      this.title = "添加工单";
    },
    getList() {
      function createOrder(orderId, orderStatus, createTime){
        return {orderId:orderId, orderStatus:orderStatus, creatTime:createTime}
      }
      this.orderList = [createOrder(1,"new","2022-05-22 20:10:10"),createOrder(2,"assigned","2022-05-22 20:10:12")];
      this.total = this.orderList.length;
    },
    handleUpdate(eachrow){

    },
    cancel() {
      this.open = false;
      this.resetForm("form");
    },
    submitForm: function() {

    },

 
  }
};
</script>
