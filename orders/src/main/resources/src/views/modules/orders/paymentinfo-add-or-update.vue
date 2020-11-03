<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="alipayTradeNo">
      <el-input v-model="dataForm.alipayTradeNo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="totalAmount">
      <el-input v-model="dataForm.totalAmount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="subject">
      <el-input v-model="dataForm.subject" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="paymentStatus">
      <el-input v-model="dataForm.paymentStatus" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="confirmTime">
      <el-input v-model="dataForm.confirmTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="callbackContent">
      <el-input v-model="dataForm.callbackContent" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="callbackTime">
      <el-input v-model="dataForm.callbackTime" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          orderSn: '',
          orderId: '',
          alipayTradeNo: '',
          totalAmount: '',
          subject: '',
          paymentStatus: '',
          createTime: '',
          confirmTime: '',
          callbackContent: '',
          callbackTime: ''
        },
        dataRule: {
          orderSn: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          alipayTradeNo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          totalAmount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          subject: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          paymentStatus: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          confirmTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          callbackContent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          callbackTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/orders/paymentinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderSn = data.paymentInfo.orderSn
                this.dataForm.orderId = data.paymentInfo.orderId
                this.dataForm.alipayTradeNo = data.paymentInfo.alipayTradeNo
                this.dataForm.totalAmount = data.paymentInfo.totalAmount
                this.dataForm.subject = data.paymentInfo.subject
                this.dataForm.paymentStatus = data.paymentInfo.paymentStatus
                this.dataForm.createTime = data.paymentInfo.createTime
                this.dataForm.confirmTime = data.paymentInfo.confirmTime
                this.dataForm.callbackContent = data.paymentInfo.callbackContent
                this.dataForm.callbackTime = data.paymentInfo.callbackTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/orders/paymentinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderSn': this.dataForm.orderSn,
                'orderId': this.dataForm.orderId,
                'alipayTradeNo': this.dataForm.alipayTradeNo,
                'totalAmount': this.dataForm.totalAmount,
                'subject': this.dataForm.subject,
                'paymentStatus': this.dataForm.paymentStatus,
                'createTime': this.dataForm.createTime,
                'confirmTime': this.dataForm.confirmTime,
                'callbackContent': this.dataForm.callbackContent,
                'callbackTime': this.dataForm.callbackTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
