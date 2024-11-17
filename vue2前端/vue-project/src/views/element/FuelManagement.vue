<template>
  <el-container style="height: 700px; border: 1px solid #eee">
    <el-header style="font-size:40px;background-color: rgb(238, 241, 246)">燃料co2排放量管理系统</el-header>
    <el-container>
      <!-- <el-aside width="200px"> -->
      <el-aside width="200px" style="border: 1px solid #eee">
        <el-menu :default-openeds="['1', '3']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>系统管理</template>
<!--             <el-menu-item index="1-1">燃料管理</el-menu-item>
            <el-menu-item index="1-2">员工管理</el-menu-item> -->
            <el-menu-item index="1-1">
              <router-link to="/fuel">燃料管理</router-link>
            </el-menu-item>
            <el-menu-item index="1-2">
              <router-link to="/stuff">员工管理</router-link>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>


  <el-main>
    
<div id="app">

    <div class="content-header">

        <h1>fuels管理系统</h1>

    </div>

    <div class="app-container">

        <div class="box">

            <div class="filter-container">
                <el-input placeholder="id值" v-model="pagination.id" style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="燃料种类" v-model="pagination.fossilEnergyType" style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="CAD值" v-model="pagination.CAD " style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="CD值" v-model="pagination.CD " style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="NAVar值" v-model="pagination.NAVar " style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="FC值" v-model="pagination.FC" style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="FCbj值" v-model="pagination.FCbj" style="width: 200px;" class="filter-item"></el-input>
                <el-input placeholder="NCVbj值" v-model="pagination.NCVbj" style="width: 200px;" class="filter-item"></el-input>
                <el-button @click="getAll()" class="dalfBut">查询</el-button>
                <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
            </div>


            <!--从dataList中加载数据并进行展示-->
            <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>
                <el-table-column type="index" align="center" label="序号" width="75"></el-table-column>
                <el-table-column prop="id" label="id值" align="center" width="115"></el-table-column>
                <el-table-column prop="fossilEnergyType" label="燃料种类" align="center" width="165"></el-table-column>
                <el-table-column prop="CAD" label="CAD值" align="center" width="115"></el-table-column>
                <el-table-column prop="CD" label="CD值" align="center" width="115"></el-table-column>
                <el-table-column prop="NAVar" label="NAVar值" align="center" width="115"></el-table-column>
                <el-table-column prop="FC" label="FC值" align="center" width="115"></el-table-column>
                <el-table-column prop="FCbj" label="FCbj值" align="center" width="115"></el-table-column>
                <el-table-column prop="NCVbj" label="NCVbj值" align="center" width="135"></el-table-column>
                <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
                        <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页组件-->
            <div class="pagination-container">
                <el-pagination
                        class="pagiantion"
                        @current-change="handleCurrentChange"
                        :current-page="pagination.currentPage"
                        :page-size="pagination.pageSize"
                        layout="total, prev, pager, next, jumper"
                        :total="pagination.total">
                </el-pagination>

            </div>

            <!-- 新增标签弹层 -->
            <div class="add-form">
                <el-dialog title="新增燃料信息" :visible.sync="dialogFormVisible">
                    <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="id" prop="id">
                                    <el-input v-model="formData.id"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="燃料种类" prop="fossilEnergyType">
                                    <el-input v-model="formData.fossilEnergyType"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="CAD值" prop="CAD">
                                    <el-input v-model.number="formData.CAD"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="CD值" prop="CD">
                                    <el-input v-model.number="formData.CD"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="NAVar值" prop="NAVar">
                                    <el-input v-model.number="formData.NAVar"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="FC值" prop="FC">
                                    <el-input v-model.number="formData.FC"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="FCbj值" prop="FCbj">
                                    <el-input v-model.number="formData.FCbj"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="NCVbj值" prop="NCVbj">
                                    <el-input v-model.number="formData.NCVbj"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button @click="cancel()">取消</el-button>
                        <el-button type="primary" @click="handleAdd()">确定</el-button>
                    </div>
                </el-dialog>
            </div>

            <!-- 编辑标签弹层 -->

            <div class="add-form">

                <el-dialog title="编辑检查项" :visible.sync="dialogFormVisible4Edit">

                    <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="id" prop="id">
                                    <el-input v-model="formData.id"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="燃料种类" prop="fossilEnergyType">
                                    <el-input v-model="formData.fossilEnergyType"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="CAD值" prop="CAD">
                                    <el-input v-model.number="formData.CAD"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="CD值" prop="CD">
                                    <el-input v-model.number="formData.CD"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="NAVar值" prop="NAVar">
                                    <el-input v-model.number="formData.NAVar"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="FC值" prop="FC">
                                    <el-input v-model.number="formData.FC"/>
                                </el-form-item>
                            </el-col>
                            <el-col :span="12">
                                <el-form-item label="FCbj值" prop="FCbj">
                                    <el-input v-model.number="formData.FCbj"/>
                                </el-form-item>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-form-item label="NCVbj值" prop="NCVbj">
                                    <el-input v-model.number="formData.NCVbj"/>
                                </el-form-item>
                            </el-col>
                        </el-row>

                    </el-form>

                    <div slot="footer" class="dialog-footer">

                        <el-button @click="cancel()">取消</el-button>

                        <el-button type="primary" @click="handleEdit()">确定</el-button>

                    </div>

                </el-dialog>

            </div>

        </div>

    </div>

</div>

  </el-main>



    </el-container>
  </el-container>
</template>


<script>
import axios from 'axios';
export default {
  data() {
    return {
      dataList: [], // 当前页要展示的列表数据
      dialogFormVisible: false, // 添加表单是否可见
      dialogFormVisible4Edit: false, // 编辑表单是否可见
      formData: {}, // 表单数据
      pagination: {
        currentPage: 1, // 当前页码
        pageSize: 10, // 每页显示的记录数
        total: 0, // 总记录数
        id: null,
        fossilEnergyType: "",
        CAD: "",
        CD: "",
        NAVar: "",
        FC: "",
        FCbj: "",
        NCVbj: "",
      },
    };
  },


        //钩子函数，VUE对象初始化完成后自动执行
        created() {
            this.getAll();
        },

        methods: {
            //列表
            //查询全部和分页查询
            getAll() {
                //使用axios发送异步请求
                //①路径为fuels
                //②方法为get
                //④使用then和res将数据提取
                //⑤提取的数据部分为R对象中的data
                //⑥使用console实现网页中控制台对数据的接受打印。
                // axios.get("/fuels").then((res)=>{
                //    console.log(res.data);
                //    this.dataList=res.data.data;
                // });
                //console.log(this.pagination.id);//测试能否接收到条件查询数据
                //拼接条件查询/fuels/2/5?id=&fossilEnergyType&……
                var condition="?q";//一个无效前缀，主要是为了后面的格式能够统一
                if (this.pagination.id==null)
                {
                    condition+="&id="+1234567890;
                }
                else
                {
                    condition+="&id="+this.pagination.id;
                }
                condition+="&fossilEnergyType="+this.pagination.fossilEnergyType;
                condition+="&CAD="+this.pagination.CAD;
                condition+="&CD="+this.pagination.CD;
                condition+="&NAVar="+this.pagination.NAVar;
                condition+="&FC="+this.pagination.FC;
                condition+="&FCbj="+this.pagination.FCbj;
                condition+="&NCVbj="+this.pagination.NCVbj;
                //测试条件查询
                console.log(condition);

                axios.get("/fuels/"+this.pagination.currentPage+"/"+this.pagination.pageSize+condition).then((res)=>{
                    console.log(res.data);
                    //this.dataList=res.data.data;
                    this.pagination.pageSize=res.data.data.size;
                    this.pagination.currentPage=res.data.data.current;
                    this.pagination.total=res.data.data.total;

                    this.dataList=res.data.data.records;
                });
            },

            //弹出添加窗口
            handleCreate() {
                this.dialogFormVisible=true;
                this.resetForm();
            },

            //重置表单
            resetForm() {
                this.formData={};//直接将数据置空
            },

            //添加
            handleAdd () {
                //①使用的是post请求
                //②传递的路径是fuels
                //③传到后端的数据是formData
                axios.post("/fuels",this.formData).then((res)=>{

                    if(res.data.flag==true)
                    {
                        //④关闭弹层表单
                        this.dialogFormVisible=false;
                        //⑥添加成功提示绿色
                        this.$message.success("添加成功！");
                    }
                    else
                    {
                        //⑦添加失败为红色
                        this.$message.error(res.data.msg);
                    }

                    //⑤重新加载更新后的数据并展示
                    this.getAll();
                })
            },

            //取消
            cancel(){
                this.dialogFormVisible=false;
                this.dialogFormVisible4Edit=false;
                this.$message.info("当前操作取消");
            },
            // 删除
            handleDelete(row) {
                this.$confirm("此操作永久删除当前信息，是否继续？","警告",{type:"info"}).then(()=>
                {
                    console.log("success");//点击确认之后跳转到这里

                    //打印出这一行的数据
                    console.log(row);
                    //①路径是/fuels/id,我们这里用字符串拼接的方式来做的
                    //②设置删除失败与成功的判断操作
                    axios.delete("/fuels/"+row.id).then((res)=>{
                        if(res.data.flag==true)
                        {
                            //⑥删除成功提示绿色
                            this.$message.success("删除成功！");
                        }
                        else
                        {
                            //⑦删除失败为红色
                            this.$message.error("删除失败！");
                        }
                        //删除完成之后重新刷新页面
                        this.getAll();
                    })
                }).catch(()=>{
                    console.log("concel");
                    this.$message.info("当前操作取消");
                })

            },

            //弹出编辑窗口
            handleUpdate(row) {
                //①先获取全部数据
                axios.get("/fuels").then((res)=>{
                    console.log(res.data);
                    this.dataList=res.data.data;
                });
                //②获取我们点的这行的数据，并展示到表单
                axios.get("/fuels/"+row.id).then((res)=>{
                    if(res.data.flag==true)
                    {
                        this.dialogFormVisible4Edit=true;
                        this.formData=res.data.data;
                    }
                    else
                    {
                        this.$message.error("数据同步失败，自动刷新！");
                        this.getAll();
                    }
                });
            },

            //修改
            handleEdit() {
                //①使用的是put请求
                //②传递的路径是fuels
                //③传到后端的数据是formData
                axios.put("/fuels",this.formData).then((res)=>{

                    if(res.data.flag==true)
                    {
                        //④关闭弹层表单
                        this.dialogFormVisible4Edit=false;
                        //⑥添加成功提示绿色
                        this.$message.success("修改成功！");
                    }
                    else
                    {
                        //⑦添加失败为红色
                        this.$message.error("修改失败！");
                    }

                    //⑤重新加载更新后的数据并展示
                    this.getAll();
                })
            },



            //切换页码
            handleCurrentChange(currentPage) {
                //①修改页码值为当前选中的页码值
                this.pagination.currentPage=currentPage;
                //②执行查询
                this.getAll();
            },

            //条件查询
        }
    }

</script>

<style>
/* 可以添加自定义样式 */
</style>