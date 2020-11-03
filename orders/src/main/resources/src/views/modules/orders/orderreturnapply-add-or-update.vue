<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuId">
      <el-input v-model="dataForm.skuId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderSn">
      <el-input v-model="dataForm.orderSn" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="memberUsername">
      <el-input v-model="dataForm.memberUsername" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="returnAmount">
      <el-input v-model="dataForm.returnAmount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="returnName">
      <el-input v-model="dataForm.returnName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="returnPhone">
      <el-input v-model="dataForm.returnPhone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="handleTime">
      <el-input v-model="dataForm.handleTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuImg">
      <el-input v-model="dataForm.skuImg" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuName">
      <el-input v-model="dataForm.skuName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuBrand">
      <el-input v-model="dataForm.skuBrand" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuAttrsVals">
      <el-input v-model="dataForm.skuAttrsVals" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuCount">
      <el-input v-model="dataForm.skuCount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuPrice">
      <el-input v-model="dataForm.skuPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="skuRealPrice">
      <el-input v-model="dataForm.skuRealPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="reason">
      <el-input v-model="dataForm.reason" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="descriptionêö">
      <el-input v-model="dataForm.descriptionêö" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="descPics">
      <el-input v-model="dataForm.descPics" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="handleNote">
      <el-input v-model="dataForm.handleNote" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="handleMan">
      <el-input v-model="dataForm.handleMan" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="receiveMan">
      <el-input v-model="dataForm.receiveMan" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="receiveTime">
      <el-input v-model="dataForm.receiveTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="receiveNote">
      <el-input v-model="dataForm.receiveNote" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="receivePhone">
      <el-input v-model="dataForm.receivePhone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="companyAddress">
      <el-input v-model="dataForm.companyAddress" placeholder=""></el-input>
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
          orderId: '',
          skuId: '',
          orderSn: '',
          createTime: '',
          memberUsername: '',
          returnAmount: '',
          returnName: '',
          returnPhone: '',
          status: '',
          handleTime: '',
          skuImg: '',
          skuName: '',
          skuBrand: '',
          skuAttrsVals: '',
          skuCount: '',
          skuPrice: '',
          skuRealPrice: '',
          reason: '',
          descriptionêö: '',
          descPics: '',
          handleNote: '',
          handleMan: '',
          receiveMan: '',
          receiveTime: '',
          receiveNote: '',
          receivePhone: '',
          companyAddress: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderSn: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          memberUsername: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          returnAmount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          returnName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          returnPhone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          handleTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuImg: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuBrand: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuAttrsVals: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          skuRealPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          reason: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          descriptionêö: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          descPics: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          handleNote: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          handleMan: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          receiveMan: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          receiveTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          receiveNote: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          receivePhone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          companyAddress: [
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
              url: this.$http.adornUrl(`/orders/orderreturnapply/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.orderReturnApply.orderId
                this.dataForm.skuId = data.orderReturnApply.skuId
                this.dataForm.orderSn = data.orderReturnApply.orderSn
                this.dataForm.createTime = data.orderReturnApply.createTime
                this.dataForm.memberUsername = data.orderReturnApply.memberUsername
                this.dataForm.returnAmount = data.orderReturnApply.returnAmount
                this.dataForm.returnName = data.orderReturnApply.returnName
                this.dataForm.returnPhone = data.orderReturnApply.returnPhone
                this.dataForm.status = data.orderReturnApply.status
                this.dataForm.handleTime = data.orderReturnApply.handleTime
                this.dataForm.skuImg = data.orderReturnApply.skuImg
                this.dataForm.skuName = data.orderReturnApply.skuName
                this.dataForm.skuBrand = data.orderReturnApply.skuBrand
                this.dataForm.skuAttrsVals = data.orderReturnApply.skuAttrsVals
                this.dataForm.skuCount = data.orderReturnApply.skuCount
                this.dataForm.skuPrice = data.orderReturnApply.skuPrice
                this.dataForm.skuRealPrice = data.orderReturnApply.skuRealPrice
                this.dataForm.reason = data.orderReturnApply.reason
                this.dataForm.descriptionêö = data.orderReturnApply.descriptionêö
                this.dataForm.descPics = data.orderReturnApply.descPics
                this.dataForm.handleNote = data.orderReturnApply.handleNote
                this.dataForm.handleMan = data.orderReturnApply.handleMan
                this.dataForm.receiveMan = data.orderReturnApply.receiveMan
                this.dataForm.receiveTime = data.orderReturnApply.receiveTime
                this.dataForm.receiveNote = data.orderReturnApply.receiveNote
                this.dataForm.receivePhone = data.orderReturnApply.receivePhone
                this.dataForm.companyAddress = data.orderReturnApply.companyAddress
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
              url: this.$http.adornUrl(`/orders/orderreturnapply/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'skuId': this.dataForm.skuId,
                'orderSn': this.dataForm.orderSn,
                'createTime': this.dataForm.createTime,
                'memberUsername': this.dataForm.memberUsername,
                'returnAmount': this.dataForm.returnAmount,
                'returnName': this.dataForm.returnName,
                'returnPhone': this.dataForm.returnPhone,
                'status': this.dataForm.status,
                'handleTime': this.dataForm.handleTime,
                'skuImg': this.dataForm.skuImg,
                'skuName': this.dataForm.skuName,
                'skuBrand': this.dataForm.skuBrand,
                'skuAttrsVals': this.dataForm.skuAttrsVals,
                'skuCount': this.dataForm.skuCount,
                'skuPrice': this.dataForm.skuPrice,
                'skuRealPrice': this.dataForm.skuRealPrice,
                'reason': this.dataForm.reason,
                'descriptionêö': this.dataForm.descriptionêö,
                'descPics': this.dataForm.descPics,
                'handleNote': this.dataForm.handleNote,
                'handleMan': this.dataForm.handleMan,
                'receiveMan': this.dataForm.receiveMan,
                'receiveTime': this.dataForm.receiveTime,
                'receiveNote': this.dataForm.receiveNote,
                'receivePhone': this.dataForm.receivePhone,
                'companyAddress': this.dataForm.companyAddress
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
