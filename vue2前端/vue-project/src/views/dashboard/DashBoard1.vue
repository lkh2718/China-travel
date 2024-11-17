<template>
  <el-container style="height: 700px; border: 1px solid #eee">
    <el-header style="font-size:40px;background-color: rgb(238, 241, 246)">燃料co2排放量管理系统</el-header>
    <el-container>
      <el-aside width="200px" class="custom-sidebar">
        <el-menu :default-openeds="['1', '3']" class="custom-menu">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>系统管理</template>
            <el-menu-item index="1-1" class="deep-blue-button">
              <router-link to="/fuel">燃料管理</router-link>
            </el-menu-item>
            <el-menu-item index="1-2" class="deep-blue-button">
              <router-link to="/stuff">员工管理</router-link>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main style="position: relative; overflow: hidden;">
        <img src="./being必应桌面壁纸.jpg" alt="背景图片" style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; object-fit: cover; z-index: -1;">
        <!-- 主要内容 -->
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
// 脚本部分保持不变
</script>

<style>
.custom-sidebar {
  background-color: #2c3e50;
  border-right: none;
}

.custom-menu {
  background-color: transparent;
}

.custom-menu .el-submenu__title,
.custom-menu .el-menu-item {
  color: #ecf0f1;
}

.custom-menu .el-menu-item:hover,
.custom-menu .el-submenu__title:hover {
  background-color: #34495e;
}


.custom-menu .deep-blue-button {
  background-color: #f7f7f7;  /* 浅灰色 */
  margin: 5px 0;
  border-radius: 4px;
}

.custom-menu .deep-blue-button:hover {
background-color: #6c757d;  /* 灰蓝色 */

}


</style>