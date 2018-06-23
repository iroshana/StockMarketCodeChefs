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
    changecomponent: function() {},
    reset: function() {
      this.currentStatus = LOGIN;
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
      }
    };
  }
};
</script>