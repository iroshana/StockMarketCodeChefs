<template>
<div>
    <div class="login-container" v-if="isLogin">
        <div class="d-flex align-items-center justify-content-center bg-br-primary ht-100v">
            <div class="login-wrapper wd-300 wd-xs-350 pd-25 pd-xs-40 bg-white rounded shadow-base">                
                <div class="signin-logo tx-center tx-28 tx-bold tx-inverse mg-b-10"><span class="tx-normal">[</span>Stock Market Game<span class="tx-normal">]</span></div>

                <div id="alertWithIcon" style="display:none;">
                    <div class="alert alert-danger" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="d-flex align-items-center justify-content-start">
                            <span><strong id="msg"></strong></span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control input-login" v-model="userModel.userName" placeholder="Enter Username">
                    <!--<small v-show="isSubmitted && !userModel.userName" class="tx-danger">User Name is Required</small>-->
                </div><!-- form-group -->
                <div class="form-group">
                    <input type="password" class="form-control input-login" v-model="userModel.password" placeholder="Enter Password" v-on:keyup.enter="login">
                    <!--<small v-show="isSubmitted && !userModel.password" class="tx-danger">User Name is Required</small>-->
                    
                </div><!-- form-group -->
                <button v-on:click="login" type="submit" class="btn btn-primary active  btn-block mg-b-10">  Log me in</button>
                <div class="text-center" @click="changecomponent()"><a>Sign Up</a></div>
            </div><!-- login-wrapper -->
        </div><!-- d-flex -->
    </div>
    <!-- <Layout v-if="isLoginSuccess"></Layout> -->
    <AfterLogin v-if="isLoginSuccess"></AfterLogin>


    <!-- Modal Component -->
    <b-modal id="signUp"
    v-model="showSignUp"
             ref="signupref"
             title="Player Sign Up"
             :hide-footer="true">
             <div class="row no-gutters">
               <b-form @submit="onSubmitPlayer" @reset="onResetPlayer">

                 <div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup1"
                    label="Name:"
                    label-for="exampleInput1"
                    >
        <b-form-input id="exampleInput1"
                      type="text"
                      v-model="signupVM.name"
                      >
        </b-form-input>
      </b-form-group>
                 </div>
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup2"
                    label="Email:"
                    label-for="exampleInput2">
        <b-form-input id="exampleInput2"
                      type="text"
                      v-model="signupVM.email"
                      >
        </b-form-input>
      </b-form-group>
                 </div></div>

<div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup10"
                    label="User Name:"
                    label-for="exampleInput10"
                    >
        <b-form-input id="exampleInput10"
                      type="text"
                      v-model="signupVM.userName"
                      >
        </b-form-input>
      </b-form-group>
                 </div>
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup11"
                    label="Password:"
                    label-for="exampleInput11">
        <b-form-input id="exampleInput11"
                      type="password"
                      v-model="signupVM.Password"
                      >
        </b-form-input>
      </b-form-group>
                 </div></div>


<div class="row">
                 <div class="col-md-6">
                   <b-form-group id="exampleInputGroup3"
                    label="Default Rating:"
                    label-for="exampleInput3">
        <b-form-input id="exampleInput3"
                      type="text"
                      v-model="signupVM.rating"
                      :readonly="true">
        </b-form-input>
      </b-form-group>

                 </div>
                 <div class="col-md-6">
                   
                 </div></div>
            
      <b-button type="submit" variant="primary">Save</b-button>
      <b-button type="reset" variant="danger">Close</b-button>
    </b-form>
               
             </div>
      
    </b-modal>

</div>
</template>

<script>
import AfterLogin from "@/components/AfterLogin"

const LOGIN = 0,
  LOGIN_SUCCESS = 1,
  LOGIN_FAIL = 2,
  SIGNUP = 3;
export default {
  name: "Login",
  components: { AfterLogin },  
  methods: {
    login: function() {
      this.currentStatus = LOGIN_SUCCESS;      
    },
    changecomponent: function() {
      //this.$refs.signupref.show();
      this.showSignUp = true;
    },
    reset: function() {
      this.currentStatus = LOGIN;
    },
    onSubmitPlayer(evt){
      evt.preventDefault();

      if(this.signupVM.name && this.signupVM.email){
        axios
        .post(apiUrl + "/Player/Create",{

        })
        .then(
          function(response) {
            this.$refs.myModalRef.hide();
            this.getShareList();
            this.getCompanySharePrices();
          }.bind(this)
        )
        .catch(function(error) {
          console.log(error);
        });
      }

    },
    onResetPlayer(){
      this.showSignUp = false;
    }
  },
  computed: {
    isLoginSuccess() {
      return this.currentStatus === LOGIN_SUCCESS;
    },
    isLogin() {
      return this.currentStatus === LOGIN;
    }
  },
  mounted() {
    this.reset();
  },
  data() {
    return {
      currentStatus: LOGIN,
      userModel: {
        userName: "",
        password: ""
      },
      showSignUp: false,
      signupVM:{
        id:'',
        name:'',
        email:'',
        rating:'1',
        userName:'',
        password:''
      }
    };
  }
};
</script>