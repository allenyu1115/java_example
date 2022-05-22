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

  </div>
</template>

<script>

export default {
  name: "Order",
  dicts: ['sys_normal_disable'],
  data() {
    return {
    };
  },
  methods: {
   handleAdd() {
     console.log("ffff");
    }
 
  }
};
</script>
